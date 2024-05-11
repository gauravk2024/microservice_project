package com.thinkitive.microservice.userservice.service;

import com.thinkitive.microservice.userservice.entity.UserService;

public interface ServiceUser {
    public UserService getUser(int id);
    public UserService createUser(com.thinkitive.microservice.userservice.entity.UserService user);
    public void deleteUser(int id);
    public UserService updateUser(int id, UserService user);
}
