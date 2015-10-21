package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Model
public class LoginBean implements Serializable{
	
	@Inject
	private UsuarioDao dao;
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	@Inject
	Event<Usuario> eventoLogin;
	
	private Usuario usuario = new Usuario();
	
	public String efetuaLogin() {
		boolean loginValido = dao.existe(this.usuario);
		if(loginValido) {
			eventoLogin.fire(usuario);
			usuarioLogado.logar(usuario);
			return "produto?faces-redirect=true";
		}else {
			usuarioLogado.deslogar();
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
		
	}
	
}
