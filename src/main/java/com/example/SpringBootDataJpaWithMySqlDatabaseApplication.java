package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.entities.User;
import com.example.service.UserDataAccessException;
import com.example.service.UserService;

@SpringBootApplication
public class SpringBootDataJpaWithMySqlDatabaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootDataJpaWithMySqlDatabaseApplication.class, args);
		
		 UserService userService = applicationContext.getBean(UserService.class);
		//CRUD - >Create,Read,Update and Delete
		userService.createUser(getUser());
		userService.createUsers(getUserList());
	
		User user;
		try {
			user = userService.findUserById(3);
			System.out.println(user);
		} catch (UserDataAccessException e) {
			System.out.println(e.getMessage());
		}
		
		
		userService.findAllUsers().forEach(System.out::println);
		
		userService.updateUserAgeById(1,45);
		
		userService.deleteUserById(3);
	}
	
	private static List<User> getUserList(){
		User user1 = new User();
		user1.setName("Sudha Verma");
		user1.setAge(31);
		user1.setDob(LocalDate.of(1998, Month.AUGUST, 20));
		
		User user2 = new User();
		user2.setName("Raj Verma");
		user2.setAge(32);
		user2.setDob(LocalDate.of(1998, Month.FEBRUARY, 22));
		
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		return userList;
	}
	
	private static User getUser() {
		User user = new User();
		user.setName("Sean Murphy");
		user.setAge(30);
		user.setDob(LocalDate.of(1998, Month.MARCH, 20));
		return user;
	}
}


