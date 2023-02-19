package br.com.rp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GretingControloer {
	
	private static final String template = "hello, %s!";
	
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greting greeting(
			@RequestParam(value = "name", defaultValue = "Word")
	String name) {
		
		return new Greting(counter.incrementAndGet(), String.format(template, name));
		
	}

}
