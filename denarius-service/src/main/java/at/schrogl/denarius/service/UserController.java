package at.schrogl.denarius.service;

import at.schrogl.denarius.persistence.dao.UserDao;
import at.schrogl.denarius.persistence.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private final UserDao userDao;

	public UserController(UserDao userDao) {
		this.userDao = userDao;
	}

	@GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	User getUser(@PathVariable("id") String userId) {
		return userDao.findById(Long.valueOf(userId)).orElse(null);
	}
}
