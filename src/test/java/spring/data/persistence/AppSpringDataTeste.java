package spring.data.persistence;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.InterfaceSpringData;
import dao.InterfaceTelefone;
import model.Telefone;
import model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTeste {
	
	@Autowired
	private InterfaceSpringData interfaceSpringData;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
	@Test
	public void testeInsert() {
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setNome("thiago");
		usuarioSpringData.setLogin("tlira");
		usuarioSpringData.setSenha("123");
		
		interfaceSpringData.save(usuarioSpringData);
	}
	
	
	@Test
	public void testeConsulta() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringData.findById(9L);
		
		System.out.println(usuarioSpringData.get().getId());
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getSenha());
		
		for (Telefone telefone :  usuarioSpringData.get().getTelefones()) {
			System.out.println(telefone.getTipo());
			System.out.println(telefone.getNumero());
		}
	}
	
	@Test
	public void testeConsultaTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringData.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());			
			System.out.println("----------------------------------------------");
		}
	}
	
	@Test
	public void update() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringData.findById(3L);
		
		UsuarioSpringData data = usuarioSpringData.get();
		
		data.setNome("Liana Sabino");
		
		interfaceSpringData.save(data);
	}
	
	@Test
	public void testeDelete() {
		interfaceSpringData.deleteById(3L);
	}
	
	@Test
	public void testeConsultaNome() {
		List<UsuarioSpringData> list = interfaceSpringData.buscaPorNome("feliz");
		
		for (UsuarioSpringData usuarioSpringData : list) {
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println("----------------------------------------------");
		}
	}
	
	@Test
	public void testeConsultaNomeParam() {
		UsuarioSpringData usuarioSpringData = interfaceSpringData.buscaPorNomeParam("rosa");
		
		
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			
		
	}
	
	@Test
	public void testeDeletePorNome() {
		interfaceSpringData.deletePorNome("feliz");
	}
	
	@Test
	public void testeUpdatePorId() {
		interfaceSpringData.updateNomePorId("Andre brandao", 1L);
	}
	
	@Test
	public void testeTelefone() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringData.findById(9L);
		
		
		Telefone telefone = new Telefone();
		
		telefone.setTipo("casa");
		telefone.setNumero("9999999");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		
		interfaceTelefone.save(telefone);
	}
	
	@Test
	public void teste() {
		System.out.println("Iniciou com sucesso");
	}
}
