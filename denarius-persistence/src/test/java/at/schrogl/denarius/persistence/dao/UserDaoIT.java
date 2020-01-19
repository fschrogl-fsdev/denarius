package at.schrogl.denarius.persistence.dao;

import at.schrogl.denarius.persistence.SpringTestPersistenceConfiguration;
import at.schrogl.denarius.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SpringTestPersistenceConfiguration.class)
@Transactional
public class UserDaoIT {

	@Autowired
	private UserDao userDao;

	@Test
	void testFindByUsername() {
		User user = new User("testUsername", "secretPassword", "test@test.com", Boolean.TRUE);
		user = userDao.save(user);

		assertTrue(userDao.findByUsername(null).isEmpty());
		assertTrue(userDao.findByUsername("").isEmpty());
		assertEquals(user, userDao.findByUsername("testUsername").get());
	}

	@Test
	void testFindByEmail() {
		User user = new User("testUsername", "secretPassword", "test@test.com", Boolean.TRUE);
		user = userDao.save(user);

		assertTrue(userDao.findByEmail(null).isEmpty());
		assertTrue(userDao.findByEmail("").isEmpty());
		assertEquals(user, userDao.findByEmail("test@test.com").get());
	}

	@Test
	void testFindByUuid() {
		User user = new User("testUsername", "secretPassword", "test@test.com", Boolean.TRUE);
		user = userDao.save(user);

		assertTrue(userDao.findByUuid(null).isEmpty());
		assertTrue(userDao.findByUuid(UUID.randomUUID()).isEmpty());
		assertEquals(user, userDao.findByUuid(user.getUuid()).get());
	}

	@Test
	void testUpdate() {
		User user = new User("testUsername", "secretPassword", "test@test.com", Boolean.TRUE);
		user = userDao.save(user);

		User user2 = new User("testUsername2", "secretPassword", "test2@test.com", Boolean.FALSE);
		user2.setUuid(user.getUuid());

		assertEquals(user.getUuid(), userDao.updateByUuid(user2));
		assertEquals(user2.getUsername(), userDao.findByUuid(user.getUuid()).get().getUsername());
		assertEquals(user2.getEmail(), userDao.findByUuid(user.getUuid()).get().getEmail());
		assertEquals(user2.isActive(), userDao.findByUuid(user.getUuid()).get().isActive());
	}

	@Test
	void testDeleteByUuid() {
		User user = new User("testUsername", "secretPassword", "test@test.com", Boolean.TRUE);
		user = userDao.save(user);

		assertTrue(userDao.deleteByUuid(user.getUuid()).isPresent());
		assertTrue(userDao.deleteByUuid(user.getUuid()).isEmpty());
	}
}