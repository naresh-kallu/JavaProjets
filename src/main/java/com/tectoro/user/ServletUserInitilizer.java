package com.tectoro.user;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



public class ServletUserInitilizer extends SpringBootServletInitializer{
	
	protected SpringApplicationBuilder configure(SpringServletApplication application) {
		return application.sources(SpringServletApplication.class);
	}
	

}
