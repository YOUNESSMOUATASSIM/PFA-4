package mooqaf.Auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mooqaf.Auth.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
	User findUserByTel(String tel);
}
