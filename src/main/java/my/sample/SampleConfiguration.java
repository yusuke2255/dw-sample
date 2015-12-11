package my.sample;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

//import java.util.HashMap;
//import java.util.Map;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//
//import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
//import io.dropwizard.db.DataSourceFactory;

public class SampleConfiguration extends Configuration {
	
	
	@NotNull
    private Map<String, Map<String, String>> viewRendererConfiguration =  new HashMap<String, Map<String,String>>();
	public Map<String, Map<String, String>> getViewRendererConfiguration() {
		return viewRendererConfiguration;
	}

	public void setViewRendererConfiguration(
			Map<String, Map<String, String>> viewRendererConfiguration) {
		this.viewRendererConfiguration = viewRendererConfiguration;
	}

}
