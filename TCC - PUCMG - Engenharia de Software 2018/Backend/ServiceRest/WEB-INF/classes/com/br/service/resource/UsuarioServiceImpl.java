package com.br.service.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.br.service.dao.UsuarioDaoImpl;
import com.br.service.entity.Usuario;

@Path("/service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioServiceImpl {

	private UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();

	@GET
	@Path("/find-all")
	public List<Usuario> findAllUsuario() {
		return usuarioDaoImpl.getAllUsuarios();
	}

	@GET
	@Path("/find/{cpf}")
	public Usuario findUsuarioById(@PathParam("email") String email) {
		return usuarioDaoImpl.getUsuario(email);
	}

	@DELETE
	@Path("/remove/{id}")
	public void removeUsuarioById(@PathParam("id") long id) {
		usuarioDaoImpl.removeUsuario(id);
	}
 
	@POST
	@Path("/add")
	public Usuario cadastroUsuario(Usuario user) {
		usuarioDaoImpl.addUsuario(user);
		return user;
	}

	@PUT
	@Path("/update")
	public void atualizaUsuario(Usuario u) {
		usuarioDaoImpl.updateUsuario(u);
	}
	
	@POST
	@Path("/valida-cadastro/")
	public boolean findUsuarioById(Usuario user) {
		boolean isCheckd = usuarioDaoImpl.verificaCadastroUsuario(user); 
		return isCheckd;
		
	}
	
			
}