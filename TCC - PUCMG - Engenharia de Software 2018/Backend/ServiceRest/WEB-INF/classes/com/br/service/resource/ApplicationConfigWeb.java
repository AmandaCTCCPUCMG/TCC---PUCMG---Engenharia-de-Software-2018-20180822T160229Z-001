package com.br.service.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

@ApplicationPath("/")
public class ApplicationConfigWeb extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private HashSet<Class<?>> classes = new HashSet<Class<?>>();

	public ApplicationConfigWeb() {
		CorsFilter corsFilter = new CorsFilter();		
		corsFilter.getAllowedOrigins().add("*");
		corsFilter.setAllowedMethods("OPTIONS, GET, POST,DELETE, PUT,PATCH");
		singletons.add(corsFilter);
		singletons.add(new UsuarioServiceImpl());
	}

	public Set<Object> getSingletons() {
		return singletons;
	}
}
