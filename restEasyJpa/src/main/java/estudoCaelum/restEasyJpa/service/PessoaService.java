package estudoCaelum.restEasyJpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import estudoCaelum.restEasyJpa.model.PessoaModel;

@Stateless
public class PessoaService {

	static List<PessoaModel> pessoas;
	static Long identifier = 4L;

	static {
		pessoas = new ArrayList<>();
		
		PessoaModel pessoa1 = new PessoaModel();
		pessoa1.setId(1L);
		pessoa1.setNome("Carlos");
		pessoa1.setSobreNome("Conceição");
		
		PessoaModel pessoa2 = new PessoaModel();
		pessoa2.setId(2L);
		pessoa2.setNome("Rafael");
		pessoa2.setSobreNome("Silva");
		
		PessoaModel pessoa3 = new PessoaModel();
		pessoa3.setId(3L);
		pessoa3.setNome("Joao");
		pessoa3.setSobreNome("Alberto");
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
	}
	
	public List<PessoaModel> findAll(){
		return pessoas;
	}
	
	public PessoaModel findOne(Long id) {
		return pessoas.stream().filter(model -> model.getId().equals(id)).findFirst().get();
	}
	
	public PessoaModel insert(PessoaModel model) {
		model.setId(identifier++);
		pessoas.add(model);
		return model;
	}
}
