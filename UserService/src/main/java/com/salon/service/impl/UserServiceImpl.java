package com.salon.service.impl;

import com.salon.exception.UserException;
import com.salon.model.User;
import com.salon.repository.UserRepository;
import com.salon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) throws UserException {
        return userRepository.findById(id).orElseThrow(() -> new UserException("User not found!"));

    }

    @Override
    public User updateUser(User user, Long id) throws UserException {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new UserException("User not found with id:" + id);
        }
        User existingUser = optional.get();
        existingUser.setEmail(user.getEmail());
        existingUser.setFullName(user.getFullName());
        existingUser.setPhone(user.getPhone());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteById(Long id) throws UserException {

        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new UserException("User not exists with id:" + id);
        }
        userRepository.deleteById(optional.get().getId());

    }
}
