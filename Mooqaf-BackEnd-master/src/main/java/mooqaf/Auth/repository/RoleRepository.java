package mooqaf.Auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mooqaf.Auth.Role;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findRoleByName(String name);

}
