package com.github.ryankenney.rkenney_swagger_example;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.github.ryankenney.rkenney_swagger_example.services.DatabaseService;
import com.github.ryankenney.rkenney_swagger_example.services.HelloService;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * This class bootstraps all of our JAX-RS classes (without regards to Swagger).
 */
public class JaxRsServlet extends Application {
	HashSet<Object> singletons = new HashSet<Object>();

	public JaxRsServlet() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setBasePath("/rkenney-swagger-example/api");
		beanConfig.setResourcePackage(HelloService.class.getPackage().getName());
		beanConfig.setScan(true);
	}

	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> set = new HashSet<Class<?>>();
		set.add(HelloService.class);
		set.add(DatabaseService.class);
		set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		return set;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
