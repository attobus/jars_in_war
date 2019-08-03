package demo.jars_in_war.method1.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * The application class which allows using the REST controllers in the project as a separate
 * as a separate Spring Boot application
 */
@SpringBootApplication
@ImportResource("classpath:app-configA.xml")
public class ApplicationA {

	/**
	 * The main method which starts the Spring Boot application
	 * @param args
	 */
    public static void main(String[] args) {
    	 SpringApplication.run(ApplicationA.class, args);
    }
}
