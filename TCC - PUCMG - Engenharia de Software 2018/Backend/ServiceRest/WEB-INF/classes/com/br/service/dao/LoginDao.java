package com.br.service.dao;

import com.br.service.entity.Usuario;


public interface LoginDao {
	public boolean checkLogin(String usuario,String senha);
	public Usuario getUsuarioLogado(String usuario,String senha);
	public Usuario getDadosUsuarioAlterado(String usuario,String senha);
}
