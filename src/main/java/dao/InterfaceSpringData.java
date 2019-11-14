package dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.UsuarioSpringData;

@Repository
public interface InterfaceSpringData extends CrudRepository<UsuarioSpringData, Long> {
		
		@Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
		public List<UsuarioSpringData> buscaPorNome(String nome);
	
}
