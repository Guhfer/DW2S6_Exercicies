package com.br.ifsp.dw2.taskmanager.service;

import com.br.ifsp.dw2.taskmanager.controller.resource.UserResource;
import com.br.ifsp.dw2.taskmanager.entity.User;
import com.br.ifsp.dw2.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResource saveUser(UserResource userResource) {

        if(userRepository.existsByEmail(userResource.getEmail())) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "User already registered");
        }
        return buildUserResource(userRepository.save(new User(userResource)));

    }

    public UserResource findUserById(Long id) {
        return buildUserResource(userRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "User not found")));
    }

    public List<UserResource> findAll() {
        return userRepository.findAll()
                .stream().map(this::buildUserResource).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "User not found"));
    }

    private UserResource buildUserResource(User user) {
        return new UserResource(user);
    }
}
