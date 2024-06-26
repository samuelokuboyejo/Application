package com.example.my_second_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class MySecondAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(MySecondAppApplication.class, args);
	}

	@GetMapping("/greet")
	public GreetResponse greet(){
		GreetResponse response = new GreetResponse(
				"Hello",
				List.of("Java", "Golang", "Javascript"),
				new Person("Alex", 25, 350_000));
		return response;
	}



	record Person (String name, int age, double savings){

	}


	record  GreetResponse(String greet,
						  List<String> favProgrammingLanguages,
						  Person person){}
}

