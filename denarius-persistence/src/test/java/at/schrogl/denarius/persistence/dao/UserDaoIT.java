package at.schrogl.denarius.persistence.dao;

import at.schrogl.denarius.persistence.SpringTestPersistenceConfiguration;
import at.schrogl.denarius.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SpringTestPersistenceConfiguration.class)
@Transactional
public class UserDaoIT {

	@Autowired
	private UserDao userDao;

	@Test
	public void testFindByUsername() {
		User user = new User("testUsername", "secretPassword", "test@test.com", Boolean.TRUE);
		user = userDao.save(user);

		assertTrue(userDao.findByUsername(null).isEmpty());
		assertTrue(userDao.findByUsername("").isEmpty());
		assertEquals(user, userDao.findByUsername("testUsername").get());
	}

	@Test
	public void testFindByEmail() {
		User user = new User("testUsername", "secretPassword", "test@test.com", Boolean.TRUE);
		user = userDao.save(user);

		assertTrue(userDao.findByEmail(null).isEmpty());
		assertTrue(userDao.findByEmail("").isEmpty());
		assertEquals(user, userDao.findByEmail("test@test.com").get());
	}

}