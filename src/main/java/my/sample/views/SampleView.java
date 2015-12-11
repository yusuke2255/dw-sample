package my.sample.views;

import io.dropwizard.views.View;

public class SampleView extends View {
	

	public SampleView(SampleView.Template template) {
		super(template.getTemplateName());
	}
	
	public enum Template {
    	FREEMARKER("/var/apps/sample.ftl");
    	
    	private String templateName;
    	private Template(String templateName){
    		this.templateName = templateName;
    	}
    	
    	public String getTemplateName(){
    		return templateName;
    	}
    }
	
	
}
