package at.schrogl.denarius.persistence.dao;

import at.schrogl.denarius.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {

	@Transactional(readOnly = true)
	Optional<User> findByUsername(String username);

	@Transactional(readOnly = true)
	Optional<User> findByEmail(String email);

}
