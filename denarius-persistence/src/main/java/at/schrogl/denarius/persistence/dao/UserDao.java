package at.schrogl.denarius.persistence.dao;

import at.schrogl.denarius.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface UserDao extends JpaRepository<User, Long> {

	@Transactional(readOnly = true)
	Optional<User> findByUsername(String username);

	@Transactional(readOnly = true)
	Optional<User> findByEmail(String email);

	@Transactional(readOnly = true)
	Optional<User> findByUuid(UUID uuid);

	@Transactional
	default UUID updateByUuid(User user) {
		Optional<User> userToUpdate = findByUuid(user.getUuid());

		if (userToUpdate.isPresent()) {
			userToUpdate.get().setUsername(user.getUsername());
			userToUpdate.get().setPassword(user.getPassword());
			userToUpdate.get().setEmail(user.getEmail());
			userToUpdate.get().setActive(user.isActive());
			save(userToUpdate.get());
			return user.getUuid();
		} else {
			return null;
		}
	}

	@Transactional
	default Optional<User> deleteByUuid(UUID uuid) {
		Optional<User> userToDelete = findByUuid(uuid);
		if (userToDelete.isPresent()) {
			delete(userToDelete.get());
			return userToDelete;
		} else {
			return Optional.empty();
		}
	}
}
