package com.unioncom.cn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unioncom.cn.bean.Person;

@RestController
@SpringBootApplication
public class ViewControlloer {
	@RequestMapping(value="/search", produces={MediaType.APPLICATION_JSON_VALUE})
	public Person search(String personName) {
		return new Person(personName, 28, "hunan");
	}
	
	/*public static void main(String[] args) {
		SpringApplication.run(ViewControlloer.class, args);
	}*/
}
