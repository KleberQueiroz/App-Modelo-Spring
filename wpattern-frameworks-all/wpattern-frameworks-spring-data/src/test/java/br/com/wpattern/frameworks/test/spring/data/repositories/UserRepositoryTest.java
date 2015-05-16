package br.com.wpattern.frameworks.test.spring.data.repositories;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import br.com.wpattern.frameworks.spring.data.entities.UserEntity;
import br.com.wpattern.frameworks.spring.data.repositories.IUserRepository;
import br.com.wpattern.frameworks.test.spring.data.AbstractSpringDataTest;

import com.google.gson.Gson;

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
	
	@Test
	public void testInsertJson() throws JsonGenerationException, JsonMappingException, IOException {
		Gson gson = new Gson();
		
		String jsonUser = "{\"login\":\"Branquinho\",\"password\":\"123456\",\"age\":20}";
		
		UserEntity user = gson.fromJson(jsonUser, UserEntity.class);
		
		//this.logger.info(gson.toJson(user));

		this.userRepository.save(user);
	}

}
