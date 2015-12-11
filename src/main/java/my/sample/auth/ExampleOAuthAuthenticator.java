package my.sample.auth;

import com.google.common.base.Optional;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import my.sample.core.User;
import my.sample.dao.AccessTokenDAO;
import my.sample.dao.UserDAO;

public class ExampleOAuthAuthenticator implements Authenticator<String,User>{

	private final AccessTokenDAO accessTokenDao;
	private final UserDAO userDao;
	
	
	public ExampleOAuthAuthenticator(AccessTokenDAO accessTokenDao,UserDAO userDao) {
		super();
		this.accessTokenDao = accessTokenDao;
		this.userDao = userDao;
	}

	public Optional<User> authenticate(String credentials) throws AuthenticationException {
		java.util.Optional<Long> maybeId = accessTokenDao.checkToken(credentials);
		
		if (maybeId.isPresent() == false) {
			return Optional.absent();
		}
		
		Optional<User> user = Optional.fromNullable(userDao.getUser(maybeId.get()).orElse(null));
		return user;
	}

}
