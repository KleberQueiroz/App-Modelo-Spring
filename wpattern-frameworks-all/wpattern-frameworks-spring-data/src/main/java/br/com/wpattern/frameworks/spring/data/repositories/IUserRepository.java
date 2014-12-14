package br.com.wpattern.frameworks.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wpattern.frameworks.spring.data.entities.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByLogin(String login);

}
