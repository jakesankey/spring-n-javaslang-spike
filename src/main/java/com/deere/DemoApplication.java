package com.deere;

import java.util.concurrent.Future;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import javaslang.*;

@RestController
@SpringBootApplication
public class DemoApplication {

	void foo() {
	}

	@Async
	@RequestMapping(value = "/hello")
	public Future<String> available() {
		String hello = "Hello, World!";
		return new AsyncResult<>(hello);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
