package my.sample.core;

import java.security.Principal;

public class User implements Principal {
	
	private final String name;
	
	private final String level;
	
	private final long id;
	
	public User(String name, String level, long id) {
		super();
		this.name = name;
		this.level = level;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public String getLevel() {
		return level;
	}

	public long getId() {
		return id;
	}

}
