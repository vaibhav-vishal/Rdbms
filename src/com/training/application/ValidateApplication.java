package com.training.application;

import com.training.entity.User;
import com.training.entity.ValidateUser;

public class ValidateApplication {

	public static void main(String[] args) {

		User user1 = new User("vaibhav", "vaibhav123", "Associate");
		User user2 = new User("Sriavtasn", "Sriavtas", "Trainer");

		ValidateUser val = new ValidateUser();
		System.out.println(val.validate(user1));

	}

}
