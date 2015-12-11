package my.sample.template;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;

public class SampleTemplateLoader extends FileTemplateLoader {

	public SampleTemplateLoader() throws IOException {
		super(new File("//var/apps"));
	}

}
