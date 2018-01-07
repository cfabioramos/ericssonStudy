package estudoCaelum.restEasyJpa.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErroModel {
	
	private String mensagem;
	
	public ErroModel(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
