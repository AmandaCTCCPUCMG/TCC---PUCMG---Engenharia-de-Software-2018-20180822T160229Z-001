package com.br.service.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.service.connectionDB.ConnectorMysql;
import com.br.service.entity.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private ConnectorMysql con;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void addUsuario(Usuario u) {
		try {

			con = new ConnectorMysql();
			con.conectaBase();

			String sql = "INSERT INTO"
					+ " usuario(cpf, nome, endereco, estado, municipio, telefone, email, senha)"
					+ " VALUES (?,?,?,?,?,?,?,?)";
			ps = con.conectaBase().prepareStatement(sql);

			ps.setString(1, u.getCpf());
			ps.setString(2, u.getNome());
			ps.setString(3, u.getEndereco());
			ps.setString(4, u.getEstado());
			ps.setString(5, u.getMunicipio());
			ps.setString(6, u.getTelefone());
			ps.setString(7, u.getEmail());
			ps.setString(8, u.getSenha());

			ps.executeUpdate();

			con.conectaBase().close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUsuario(Usuario u) {
		try {
			con = new ConnectorMysql();
			con.conectaBase();

			String sql = "UPDATE usuario SET " + "cpf= ?" + ", nome= ?"
					+ ", endereco= ?" + ", estado= ?" + ", municipio= ?"
					+ ", telefone= ?" + ", email= ?" + ", senha= ?"
					+ " WHERE id = "+u.getId();

			ps = con.conectaBase().prepareStatement(sql);
			
			ps.setString(1, u.getCpf());
			ps.setString(2, u.getNome());
			ps.setString(3, u.getEndereco());
			ps.setString(4, u.getEstado());
			ps.setString(5, u.getMunicipio());
			ps.setString(6, u.getTelefone());
			ps.setString(7, u.getEmail());
			ps.setString(8, u.getSenha());

			ps.executeUpdate();

			con.conectaBase().close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> getAllUsuarios() {

		List<Usuario> user = new ArrayList<Usuario>();

		try {
			con = new ConnectorMysql();
			con.conectaBase();

			String sql = "SELECT * FROM usuario";
			ps = con.conectaBase().prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt(1));
				u.setCpf(rs.getString(2));
				u.setNome(rs.getString(3));
				u.setEndereco(rs.getString(4));
				u.setEstado(rs.getString(5));
				u.setMunicipio(rs.getString(6));
				u.setTelefone(rs.getString(7));
				u.setEmail(rs.getString(8));
				u.setSenha(rs.getString(9));
				user.add(u);
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void removeUsuario(long id) {
		try {
			con = new ConnectorMysql();
			con.conectaBase();

			String sql = "DELETE FROM usuario WHERE id = " +id;
			ps = con.conectaBase().prepareStatement(sql);
			ps.executeUpdate(sql);

			con.conectaBase().close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario getUsuario(String email) {
		Usuario u = new Usuario();
		try {
			con = new ConnectorMysql();
			con.conectaBase();

			String sql = "SELECT * FROM usuario WHERE email ='" + email + "'";
			ps = con.conectaBase().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				u.setCpf(rs.getString(2));
				u.setNome(rs.getString(3));
				u.setEndereco(rs.getString(4));
				u.setEstado(rs.getString(5));
				u.setMunicipio(rs.getString(6));
				u.setTelefone(rs.getString(7));
				u.setEmail(rs.getString(8));
				u.setSenha(rs.getString(9));
			}
			con.conectaBase().close();
			ps.close();
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public boolean verificaCadastroUsuario(Usuario u) {
		Usuario user = new Usuario();
		try {
			con = new ConnectorMysql();
			con.conectaBase();

			String sql = "SELECT * FROM usuario WHERE"
					+ " cpf ='" + u.getCpf()+ "'"
					+ "AND"
					+ " email ='" + u.getEmail() + "'";
			
			ps = con.conectaBase().prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				return true;
			}
			con.conectaBase().close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
}
