package org.myllds.resturantbooking.service.impl;

import org.myllds.resturantbooking.constants.ExceptionMessages;
import org.myllds.resturantbooking.exception.AdminNotFoundException;
import org.myllds.resturantbooking.exception.UserNotFoundException;
import org.myllds.resturantbooking.model.Admin;
import org.myllds.resturantbooking.model.User;
import org.myllds.resturantbooking.repository.UserRepository;
import org.myllds.resturantbooking.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addAdmin(String id, String name) {
        userRepository.addAdmin(new Admin(id, name));
    }

    @Override
    public void addUser(String id, String name) {
        userRepository.addUser(new User(id, name));
    }

    @Override
    public boolean validateUser(String id) {
        User userById = userRepository.findUserById(id);
        if(userById == null) {
            throw new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND);
        }
        return true;
    }

    @Override
    public boolean validateAdmin(String id) {
        Admin adminById = userRepository.findAdminById(id);
        if(adminById == null) {
            throw new AdminNotFoundException(ExceptionMessages.ADMIN_NOT_FOUND);
        }
        return true;
    }
}
