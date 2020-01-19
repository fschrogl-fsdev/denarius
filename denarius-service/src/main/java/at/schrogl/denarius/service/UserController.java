package at.schrogl.denarius.service;

import at.schrogl.denarius.persistence.dao.UserDao;
import at.schrogl.denarius.persistence.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

	private final UserDao userDao;

	public UserController(UserDao userDao) {
		this.userDao = userDao;
	}

	@PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UUID create(@RequestBody User user) {
		return userDao.save(user).getUuid();
	}

	@GetMapping(path = "/users/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	User read(@PathVariable("uuid") UUID uuid) {
		return userDao.findByUuid(uuid).orElse(null);
	}

	@PutMapping(path = "/users/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UUID update(@PathVariable("uuid") UUID uuid, @RequestBody User user) {
		return userDao.updateByUuid(user);
	}

	@DeleteMapping(path = "/users/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User delete(@PathVariable("uuid") UUID uuid) {
		return userDao.deleteByUuid(uuid).orElse(null);
	}
}
