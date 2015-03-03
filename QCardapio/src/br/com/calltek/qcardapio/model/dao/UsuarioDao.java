package br.com.calltek.qcardapio.model.dao;

import br.com.calltek.qcardapio.model.bean.Usuario;

public class UsuarioDao {

	public Usuario getUsuario(String login, String senha) {
		// TODO Auto-generated method stub
		if (login.equals("admin") && senha.equals("123")) {
			return new Usuario();
		} else {
			return null;
		}
	}
}
