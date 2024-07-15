package org.myllds.resturantbooking;

import org.myllds.resturantbooking.repository.UserRepository;
import org.myllds.resturantbooking.repository.impl.UserRepoImpl;
import org.myllds.resturantbooking.service.UserService;
import org.myllds.resturantbooking.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepoImpl();
        UserService userService = new UserServiceImpl(userRepository);
        userService.addUser("u1", "User1");
        userService.addAdmin("a1", "Admin1");
    }
}