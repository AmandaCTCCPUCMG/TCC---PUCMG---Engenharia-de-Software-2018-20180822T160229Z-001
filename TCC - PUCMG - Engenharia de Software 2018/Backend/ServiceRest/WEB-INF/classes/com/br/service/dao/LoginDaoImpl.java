package com.br.service.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.service.connectionDB.ConnectorMysql;
import com.br.service.entity.Usuario;

public class LoginDaoImpl implements LoginDao {

	private ConnectorMysql con;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Usuario user;

	@Override
	public boolean checkLogin(String usuario, String senha) {
		try {
			con = new ConnectorMysql();
			con.conectaBase();

			String sql = "SELECT * FROM usuario WHERE email ='" + usuario
					+ "' and senha ='" + senha + "'";
			ps = con.conectaBase().prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {				
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Usuario getUsuarioLogado(String email,String senha) {
		try {
			con = new ConnectorMysql();
			con.conectaBase();

			String sql = "SELECT * FROM usuario WHERE email ='" + email
					+ "' and senha ='" + senha + "'";
			ps = con.conectaBase().prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				user = new Usuario();
				user.setId(rs.getInt(1));
				user.setCpf(rs.getString(2));
				user.setNome(rs.getString(3));
				user.setEndereco(rs.getString(4));
				user.setEstado(rs.getString(5));
				user.setMunicipio(rs.getString(6));
				user.setTelefone(rs.getString(7));
				user.setEmail(rs.getString(8));
				user.setSenha(rs.getString(9));
			}
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Usuario();
	}

	@Override
	public Usuario getDadosUsuarioAlterado(String usuario, String senha) {
		try {
			con = new ConnectorMysql();
			con.conectaBase();

			String sql = "SELECT * FROM usuario WHERE email ='" + usuario
					+ "' and senha ='" + senha + "'";
			ps = con.conectaBase().prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				user = new Usuario();
				user.setId(rs.getInt(1));
				user.setCpf(rs.getString(2));
				user.setNome(rs.getString(3));
				user.setEndereco(rs.getString(4));
				user.setEstado(rs.getString(5));
				user.setMunicipio(rs.getString(6));
				user.setTelefone(rs.getString(7));
				user.setEmail(rs.getString(8));
				user.setSenha(rs.getString(9));
			}
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Usuario();
	}
}
