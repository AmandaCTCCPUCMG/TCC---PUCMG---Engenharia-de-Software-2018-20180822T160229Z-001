package com.br.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.br.service.dao.LoginDaoImpl;
import com.br.service.entity.Login;
import com.br.service.entity.Usuario;

@Path("/service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginServiceImpl {

	private LoginDaoImpl loginServiceImpl = new LoginDaoImpl();

	@POST
	@Path("/check-user-login")
	public boolean verificaLoginUsuario(Login login) {
		String email = login.getUsuario().getEmail();
		String senha = login.getUsuario().getSenha();
		boolean isValid = loginServiceImpl.checkLogin(email, senha);
		if (isValid) {			
			return true;
		}
		return false;
	}

	@GET
	@Path("/get-user-login/")
	public Usuario getUsuarioLogado(@QueryParam("email") String email, @QueryParam("senha") String senha) {
		Usuario user = loginServiceImpl.getUsuarioLogado(email,senha);
		return user;
	}

	@POST
	@Path("/get-user-after-edit")
	public Usuario getUsuarioEditado(Usuario u) {
		Usuario user = loginServiceImpl.getDadosUsuarioAlterado(u.getEmail(),
				u.getSenha());
		return user;
	}
}