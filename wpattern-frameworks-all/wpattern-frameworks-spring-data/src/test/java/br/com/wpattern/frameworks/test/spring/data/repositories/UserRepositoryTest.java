package br.com.wpattern.frameworks.test.spring.data.repositories;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.wpattern.frameworks.spring.data.entities.UserEntity;
import br.com.wpattern.frameworks.spring.data.repositories.IUserRepository;
import br.com.wpattern.frameworks.test.spring.data.AbstractSpringDataTest;

public class UserRepositoryTest extends AbstractSpringDataTest {

	private Logger logger = Logger.getLogger(this.getClass());

	@Inject
	private IUserRepository userRepository;

	@Test
	public void testList() {
		List<UserEntity> users = this.userRepository.findAll();

		this.logger.debug(users);
	}

	@Test
	public void testInsert() {
		UserEntity user = new UserEntity();

		user.setLogin("LOGIN_" + System.currentTimeMillis());
		user.setPassword("PASSWORD");
		user.setRegisterDate(new Date());
		user.setAge(22);

		this.logger.debug(this.userRepository.save(user));
	}

	@Test
	public void testFindByLogin() {
		UserEntity user = this.userRepository.findByLogin("login2");

		this.logger.debug(user);
	}

}
