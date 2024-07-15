package org.myllds.resturantbooking.service;

public interface UserService {
    void addAdmin(String id, String name);
    void addUser(String id, String name);
    boolean validateUser(String id);
    boolean validateAdmin(String id);
}
