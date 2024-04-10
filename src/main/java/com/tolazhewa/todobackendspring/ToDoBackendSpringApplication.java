package com.tolazhewa.todobackendspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class ToDoBackendSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(ToDoBackendSpringApplication.class, args);
	}
}
