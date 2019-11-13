package spring.data.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.InterfaceSpringData;
import model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTeste {
	
	@Autowired
	private InterfaceSpringData interfaceSpringData;
	
	@Test
	public void testeInsert() {
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setNome("jeje");
		usuarioSpringData.setLogin("jejezinho");
		usuarioSpringData.setSenha("liana123");
		
		interfaceSpringData.save(usuarioSpringData);
	}
	
	
	@Test
	public void teste() {
		System.out.println("Iniciou com sucesso");
	}
}
