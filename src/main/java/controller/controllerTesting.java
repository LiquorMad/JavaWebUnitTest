package controller;
import model.DAO;
import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.Cookie;

import org.junit.jupiter.api.Test;

class controllerTesting {
	Controller controller = new Controller();
	@Test
	//Verefica se só utilizador cadastrado pode ter acesso
	void testAutentication() {
		assertEquals(true,controller.authencication("1","1"));
	}
	@Test
	//Verefica tamanho minimo de password
	void testinglenghtPassword() {
		assertEquals(false, controller.isValidlenghtPassword("2"));
	}
	
	@Test
	//Verifica se o nome é valido
	void testingValidName() {
		assertEquals(true, controller.isValidName("L54"));
	}
	@Test
	//Testar se cookie esta seguro
	void testingSecureCookie() {
		System.out.println("Testing cookie"+controller.isSecureCookie());
		assertEquals(true, controller.isSecureCookie());
	}
	
	
}
