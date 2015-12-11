package my.sample.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccessTokenDAO {

	private Map<String, Long> accessTokenStore = new HashMap<>();
	
	public AccessTokenDAO() {
		accessTokenStore.put("token-111", 1L);
	}
	
	public Optional<Long> checkToken(String token) {
		Long id = accessTokenStore.get(token);
		
		return Optional.ofNullable(id);
	}
	
}
