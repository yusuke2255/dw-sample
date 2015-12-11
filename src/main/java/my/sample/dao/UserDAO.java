package my.sample.dao;

import java.util.Optional;

import my.sample.core.User;

public class UserDAO {

	public Optional<User> getUser(long id) {
		if (id == 1L) {
			return Optional.of(new User("A", "Admin", 1L));
		}
		
		return Optional.empty();
	}
	
}
