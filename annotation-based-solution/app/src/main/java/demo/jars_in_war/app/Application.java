package demo.jars_in_war.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import demo.jars_in_war.method1.ApplicationB;
import demo.jars_in_war.method2.ApplicationA;

/**
 *	The main class for the war file 
 */
@SpringBootApplication(scanBasePackageClasses = { ApplicationA.class, ApplicationB.class })
public class Application extends SpringBootServletInitializer {
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	/**
	 * The main method to start the application as a standalone Spring Boot application  
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
