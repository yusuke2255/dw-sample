package my.sample.auth;

import io.dropwizard.auth.Authorizer;
import my.sample.core.User;

public class ExampleAuthorizer implements Authorizer<User> {
    @Override
    public boolean authorize(User user, String role) {
        return role.equals(user.getLevel());
    }
}