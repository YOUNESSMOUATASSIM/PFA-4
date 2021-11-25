package mooqaf.service;

import java.security.Principal;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.ResponseEntity;

import mooqaf.entities.AppelOffre;
import mooqaf.response.ResponseMessage;

public interface IService<T> {
	public List<T> all();
	public T one( Long id);
	public T add(T object,Principal currentUser);
	public T update(T object, Long id,Principal currentUser);
	public T delete(Long id, Principal currentUser);
}
