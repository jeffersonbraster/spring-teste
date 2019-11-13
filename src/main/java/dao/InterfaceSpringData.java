package dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.UsuarioSpringData;

@Repository
public interface InterfaceSpringData extends CrudRepository<UsuarioSpringData, Long> {

	
}
