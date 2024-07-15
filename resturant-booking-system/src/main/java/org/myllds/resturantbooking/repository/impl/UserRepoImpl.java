package org.myllds.resturantbooking.repository.impl;

import org.myllds.resturantbooking.model.Admin;
import org.myllds.resturantbooking.model.User;
import org.myllds.resturantbooking.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepoImpl implements UserRepository {
    private Map<String, User> userMap = new ConcurrentHashMap<>();
    private Map<String, Admin> adminMap = new ConcurrentHashMap<>();
    @Override
    public void addAdmin(Admin admin) {
        adminMap.put(admin.getId(), admin);
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
    }

    @Override
    public User findUserById(String id) {
        return userMap.get(id);
    }

    @Override
    public Admin findAdminById(String id) {
        return adminMap.get(id);
    }
}
