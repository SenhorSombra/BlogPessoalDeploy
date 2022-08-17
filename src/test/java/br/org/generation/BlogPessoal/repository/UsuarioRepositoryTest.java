package br.org.generation.BlogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.org.generation.BlogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {

		//usuarioRepository.deleteAll();

		usuarioRepository.save(new Usuario(0L, "João da Silva", "https://br.depositphotos.com/stock-photos/sol.html","joao@email.com.br", "12345678"));

		usuarioRepository.save(new Usuario(0L, "Manuela da Silva", "https://br.depositphotos.com/stock-photos/sol.html","manuela@email.com.br", "12345678"));

		usuarioRepository.save(new Usuario(0L, "Adriana da Silva", "https://br.depositphotos.com/stock-photos/sol.html","adriana@email.com.br", "12345678"));

		usuarioRepository.save(new Usuario(0L, "Paulo Antunes", "https://br.depositphotos.com/stock-photos/sol.html","paulo@email.com.br", "12345678"));
	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveretornarUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
	}

	@Test
	@DisplayName("Retorna 3 usuario")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));

	}

}
