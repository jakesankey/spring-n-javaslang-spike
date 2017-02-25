package com.sankey;

import java.util.concurrent.Future;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import javaslang.collection.*;
import javaslang.jackson.datatype.*;
import com.fasterxml.jackson.databind.*;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Async
	@RequestMapping(value = "/people")
	Future<List<String>> available(@RequestParam(defaultValue = "0") Integer minAge) {
		return new AsyncResult<>(peopleUnderAge(minAge));
	}

	@Bean // adds javaslang jackson support for spring
	Module javaslangModule() {
		return new JavaslangModule();
	}

	private List<String> peopleUnderAge(Integer minAge) {
		List<Person> persons = List.of(
			new Person("John", "Doe", 40), 
			new Person("Jane", "Doe", 30), 
			new Person("Jill", "Doe", 5), 
			new Person("Joe", "Doe", 12)
		);
		return persons.filter(p -> p.getAge() >= minAge).map(Person::getName);
	}
}
