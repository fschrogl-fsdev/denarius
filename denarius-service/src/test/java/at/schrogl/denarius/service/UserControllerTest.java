package at.schrogl.denarius.service;

import at.schrogl.denarius.SpringTestServiceConfiguration;
import at.schrogl.denarius.persistence.dao.UserDao;
import at.schrogl.denarius.persistence.model.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;

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
	public void getUser() {
		User user = userController.getUser("1");
		assertNull(user);
	}
}