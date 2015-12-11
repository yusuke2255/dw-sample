package my.sample.resources;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.dropwizard.auth.Auth;
import my.sample.core.User;
import my.sample.views.SampleView;

@Path("/")
public class SampleResource {

	
	@GET
	@Path("/image")
	public Response getTopPage() {
		try {
			BufferedImage image = ImageIO.read(new File("/Users/yusukekawata/Pictures/yaruo.jpeg"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpeg", baos);
			byte[] imageData = baos.toByteArray();
			return Response.ok(imageData, "image/jpeg").build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.serverError().build();
		
		//return Response.
	}
	
	@GET
	@Path("/sample")
	@Produces(MediaType.TEXT_HTML)
	public SampleView getSampleView() {
		return new SampleView(SampleView.Template.FREEMARKER);
	}
	
	@GET
	@Path("/secret/resource")
	@RolesAllowed("ADMIN")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSecretResource(@Auth User user) {
		Map<String, String> res = new HashMap<>();
		res.put("key", "VALUE");
		return Response.ok().entity(res).build();
	}
	
	
}
