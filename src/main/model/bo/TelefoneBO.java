package main.model.bo;

import java.util.List;

import main.model.dao.TelefoneDAO;
import main.model.exception.TelefoneJaUtilizadoException;
import main.model.vo.Telefone;

public class TelefoneBO {

	private TelefoneDAO dao = new TelefoneDAO();
	
	public Telefone inserir(Telefone novoTelefone) throws TelefoneJaUtilizadoException {
		novoTelefone.setAtivo(novoTelefone.getIdCliente() != null);
		
		if(dao.telefoneJaCadastrado(novoTelefone.getDdd(), novoTelefone.getNumero())) {
			throw new TelefoneJaUtilizadoException("Telefone informado já existe");
		}
		
		return dao.inserir(novoTelefone);
	}
	
	public boolean atualizar(Telefone telefoneAlterado) {
		telefoneAlterado.setAtivo(telefoneAlterado.getIdCliente() != null);

		return dao.atualizar(telefoneAlterado);
	}
	
	public boolean excluir(int id) {
		return dao.excluir(id);
	}
	
	public Telefone consultarPorId(int id) {
		return dao.consultarPorId(id);
	}
	
	public List<Telefone> consultarTodos() {
		return dao.consultarTodos();
	}
}
