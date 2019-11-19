package com.github.ryankenney.rkenney_swagger_example;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.models.Info;
import io.swagger.models.Swagger;
import io.swagger.models.Tag;

/**
 * This servlet generates the <code>swagger.json</code> that defines our REST
 * endpoints in a way that lets Swagger provide an interactive experience.
 */
@SuppressWarnings("serial")
public class SwaggerDescriptorServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		Info info = new Info().title("Ryan Kenney's Swagger Example");

		ServletContext context = config.getServletContext();
		Swagger swagger = new Swagger().info(info);
		
		// These entries allow us to provide descriptions for the top level APIs.
		// If these lines are completely omitted, only the names will appear in the Swagger UI. 
		swagger.tag(new Tag().name("hello").description("Hello service"));
		swagger.tag(new Tag().name("database").description("Database service"));

		context.setAttribute("swagger", swagger);
	}
}
