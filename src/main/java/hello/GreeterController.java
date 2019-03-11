package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController signifies the class below as a controller where
 * every method returns a domain object rather than a view
 *
 * It is shorthand for @Controller and @ResponseBody combined into one
 */
@RestController
@ComponentScan(basePackageClasses = GreeterController.class)
public class GreeterController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * @RequestMapping annotation ensures that HTTP requests to /greeting
     * are mapped to the greeter() method
     * 1. @RequestMapping binds the value of the query string parameter 'name'
     *    into the 'name' parameter  of the greeter() method.
     * 2. If the 'name' parameter is absent in the request, the 'defaultValue'
     *    of 'World' is used instead.
     *
     * Additionally, I must note that the example below does not specify
     * GET vs. PUT, POST, etc. because @RequestMapping maps all HTTP
     * operations by default. I must use @RequestMapping(method=GET) to
     * narrow the mapping I want to do,
     *
     * @param name is the value of the query string parameter
     * @return a new 'Greeter' object with 'id' and 'content' attributes
     * based on the next value from the 'counter', and then formats the given 'name'
     * by using the greeting 'template'
     */
    @RequestMapping("/greeter")
    public Greeter greeter(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeter(counter.incrementAndGet(), String.format(template, name));
    }
}
