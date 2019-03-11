package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication is a convenience annotation that adds all
 * of the following:
 * 1. @Configuration: tags the class as a source of bean definitions
 *    for the application context
 * 2. @EnableAutoConfiguration: tells Spring Boot to start beans based
 *    on classpath settings, other beans, and various property settings.
 * 3. @ComponentScan: tells Springs to look for other components,
 *    configurations, and services in the 'hello' package, allowing it
 *    to find the correct controllers
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
