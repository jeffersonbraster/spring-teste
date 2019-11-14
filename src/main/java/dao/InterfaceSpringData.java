package dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.UsuarioSpringData;

@Repository
public interface InterfaceSpringData extends CrudRepository<UsuarioSpringData, Long> {
		
		@Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
		public List<UsuarioSpringData> buscaPorNome(String nome);
		
		@Query(value = "select p from UsuarioSpringData p where p.nome = :paramnome")
		public UsuarioSpringData buscaPorNomeParam (@Param("paramnome") String paramnome);
		
		@Modifying
		@Transactional
		@Query(value = "delete from UsuarioSpringData u where u.nome = ?1")
		public void deletePorNome(String nome);
		
		@Modifying
		@Transactional
		@Query(value = "update UsuarioSpringData u set u.nome = ?1 where u.id = ?2")
		public void updateNomePorId(String nome, long id);
	
}
