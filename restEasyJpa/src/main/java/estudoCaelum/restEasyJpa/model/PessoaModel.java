package estudoCaelum.restEasyJpa.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PessoaModel {

	private Long id;
	private String nome;
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
