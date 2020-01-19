package at.schrogl.denarius.service;

import at.schrogl.denarius.SpringTestServiceConfiguration;
import at.schrogl.denarius.persistence.dao.UserDao;
import at.schrogl.denarius.persistence.model.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = SpringTestServiceConfiguration.class)
public class UserControllerTest {

	@Mock
	private UserDao userDaoMock;

	@InjectMocks
	private UserController userController;

	@Before
	public void beforeTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreate() {
		Mockito.when(userDaoMock.save(any())).thenReturn(new User());

		User user = new User("username", "password", "denarius@schrogl.at", true);
		assertNotNull(userController.create(user));
	}

	@Test
	public void testRead() {
		User user = userController.read(UUID.randomUUID());
		assertNull(user);
	}

	@Test
	public void testUpdate() {
		Mockito.when(userDaoMock.updateByUuid(any())).thenReturn(UUID.randomUUID());

		User user = new User("username", "password", "denarius@schrogl.at", true);
		assertNotNull(userController.update(UUID.randomUUID(), user));
	}

	@Test
	public void testDelete() {
		assertNull(userController.delete(UUID.randomUUID()));
	}
}