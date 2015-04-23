package net.croz.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private final JdbcOperations database;

	@Autowired
	public CustomerController(JdbcOperations database) {
		this.database = database;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> index() {
		return database.query("SELECT name FROM CUSTOMER",
				new BeanPropertyRowMapper<Customer>(Customer.class));
	}
}
