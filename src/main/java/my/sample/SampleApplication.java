package my.sample;


import java.util.Map;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import my.sample.auth.ExampleAuthorizer;
import my.sample.auth.ExampleOAuthAuthenticator;
import my.sample.core.User;
import my.sample.dao.AccessTokenDAO;
import my.sample.dao.UserDAO;
import my.sample.resources.SampleResource;


public class SampleApplication extends Application<SampleConfiguration> {
	public static void main(String[] args) throws Exception {
        new SampleApplication().run(args);
    }

	@Override
    public String getName() {
        return "mysample";
    }

	@Override
	public void initialize(Bootstrap<SampleConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
		
		bootstrap.addBundle(new ViewBundle<SampleConfiguration>() {
			
	        @Override
	        public Map<String, Map<String, String>> getViewConfiguration(SampleConfiguration config) {
	            return config.getViewRendererConfiguration();
	        }
	        
	    });

	};

	@Override
	public void run(SampleConfiguration configuration,Environment environment) throws Exception {

		// -----------------------------------------------------------------------
		// DAO
		// -----------------------------------------------------------------------
		AccessTokenDAO accessTokenDAO = new AccessTokenDAO();
		UserDAO userDAO = new UserDAO();
		
		// -----------------------------------------------------------------------
		// Utility
		// -----------------------------------------------------------------------
		
		// -----------------------------------------------------------------------
		// Resource
		// -----------------------------------------------------------------------
		final SampleResource sampleResource = new SampleResource();
		environment.jersey().register(sampleResource);

		environment.jersey().register(new AuthDynamicFeature(
		        new OAuthCredentialAuthFilter.Builder<User>()
		            .setAuthenticator(new ExampleOAuthAuthenticator(accessTokenDAO,userDAO))
		            .setAuthorizer(new ExampleAuthorizer())
		            .setPrefix("Bearer")
		            .buildAuthFilter()));

	}
	
	
}
