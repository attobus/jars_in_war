package demo.jars_in_war.method1.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The rest controller holding the methodA
 */
@RestController
public class ClassA {

	/**
	 * The template of response.
	 */
	private static final String template = "MethodA, value = %s";

	/**
	 * The counter of responses.
	 */
	private final AtomicLong counter = new AtomicLong();

	/**
	 * Creates a DataA entry as a response to request to the /methodA
	 * 
	 * @param value - the parameter value
	 * @return - the DataA entry
	 */
    @RequestMapping("/methodA")
	public DataA methodA(@RequestParam(value = "value", defaultValue = "null") String value) {
		return new DataA(counter.incrementAndGet(), String.format(template, value));
	}
}
