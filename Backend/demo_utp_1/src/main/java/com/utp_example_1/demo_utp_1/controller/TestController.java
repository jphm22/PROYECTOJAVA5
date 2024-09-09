package com.utp_example_1.demo_utp_1.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {

	 @Autowired
	    private DataSource dataSource;

	    @GetMapping("/test-connection")
	    public String testConnection() {
	        try (Connection connection = dataSource.getConnection()) {
	            return "Conexión exitosa: " + connection.getMetaData().getDatabaseProductName();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return "Error en la conexión: " + e.getMessage();
	        }
	    }
}
