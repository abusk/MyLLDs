package org.myllds.resturantbooking.repository;

import org.myllds.resturantbooking.model.Admin;
import org.myllds.resturantbooking.model.User;

public interface UserRepository {
    void addAdmin(Admin admin);
    void addUser(User user);
    User findUserById(String id);
    Admin findAdminById(String id);
}
