package com.salon.service;

import com.salon.exception.UserException;
import com.salon.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUser();

    User getUserById(Long id) throws UserException;

    User updateUser(User user, Long id) throws UserException;

    void deleteById(Long id) throws UserException;
}
