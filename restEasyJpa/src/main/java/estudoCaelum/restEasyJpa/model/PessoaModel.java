package estudoCaelum.restEasyJpa.model;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement
public class PessoaModel {
	
	private Long id;
	@NotEmpty(message="O nome deve ser informado.")
	@Size(min=5, max=50, message="O nome deve conter entre 5 e 50 caracteres.")
	private String nome;
	@NotEmpty
	@Size(min=5, max=50, message="O sobrenome deve conter entre 5 e 50 caracteres.")
	private String sobreNome;

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
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
}
