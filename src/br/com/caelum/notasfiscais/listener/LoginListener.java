package br.com.caelum.notasfiscais.listener;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.util.EmailComercial;

public class LoginListener {
	
	@Inject @Any
	private Instance<String> todosEmails;;
	
	public void onLogin(@Observes Usuario usuario) {
		
		for(String email: todosEmails) {
			System.out.println("Notifica " + email);
		}
		System.out.printf("Usuario %s se logou no sistema.", usuario.getLogin());
		//enviando email para outro sistema.
		
	}

}
