package at.schrogl.denarius.persistence.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	public User() {
		this.uuid = UUID.randomUUID();
	}

	public User(String username, String password, String email, Boolean active) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
		this.uuid = UUID.randomUUID();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(name = "UUID", unique = true, nullable = false, updatable = false)
	private UUID uuid;

	@Column(name = "USERNAME", unique = true, nullable = false, length = 50)
	private String username;

	@Column(name = "PASSWORD", nullable = false, length = 255)
	private String password;

	@Column(name = "EMAIL", unique = true, nullable = false, length = 255)
	private String email;

	@Column(name = "ACTIVE", nullable = false)
	private Boolean active;

	@Override
	public String toString() {
		return String.format("UserCredentials[id=%d, username=%s, active=%b]", id, username, active);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User that = (User) o;
		return username.equals(that.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
