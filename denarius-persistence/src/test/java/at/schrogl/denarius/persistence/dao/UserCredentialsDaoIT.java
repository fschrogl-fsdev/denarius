package at.schrogl.denarius.persistence.dao;

import at.schrogl.denarius.persistence.TestPersistenceConfiguration;
import at.schrogl.denarius.persistence.model.UserCredentials;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TestPersistenceConfiguration.class)
public class UserCredentialsDaoIT {

	@Autowired
	private UserCredentialsDao userCredentialsDao;

	@Test
	public void testFindByUsername() {
		UserCredentials userCredentials = new UserCredentials("testUsername", "secretPassword", Boolean.TRUE);
		userCredentials = userCredentialsDao.save(userCredentials);

		assertTrue(userCredentialsDao.findByUsername(null).isEmpty());
		assertTrue(userCredentialsDao.findByUsername("").isEmpty());
		assertEquals(userCredentials, userCredentialsDao.findByUsername("testUsername").get());
	}

}