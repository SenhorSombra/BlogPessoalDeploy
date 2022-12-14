package br.org.generation.BlogPessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "O atributo Nome é Obrigatorio")
	@Size(min = 3, max = 255)
	private String nome;
	@NotBlank
	@Size(min = 5 ,max = 5000)
	private String foto;
	@Schema(example = "exemple@exemple.com.br")
	@NotBlank(message = "Usuario é Obrigatorio")
	@Size(min = 5 ,max = 255)
	@Email(message = "O atributo Usuário deve ser um email válido!")
	private String usuario;
	@NotBlank(message = "Senha é Obrigatorio")
	@Size(min = 5 ,max = 255)
	private String senha;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;
	
	
	
	
	public Usuario(Long id, String nome, String foto, String usuario,String senha) {
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.usuario = usuario;
		this.senha = senha;
	}





	public Usuario() {}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public List<Postagem> getPostagem() {
		return postagem;
	}
	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

}
