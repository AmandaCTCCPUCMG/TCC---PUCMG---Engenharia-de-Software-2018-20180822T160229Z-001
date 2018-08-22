package com.br.service.dao;

import java.util.List;

import com.br.service.entity.Usuario;

public interface UsuarioDao {
	public void addUsuario(Usuario u);

	public void updateUsuario(Usuario u);

	public void removeUsuario(long id);

	public Usuario getUsuario(String cpf);

	public List<Usuario> getAllUsuarios();
	
	public boolean verificaCadastroUsuario(Usuario u);
}
