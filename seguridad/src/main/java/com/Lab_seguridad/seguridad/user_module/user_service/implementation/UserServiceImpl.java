package com.Lab_seguridad.seguridad.user_module.user_service.implementation;

import com.Lab_seguridad.seguridad.user_module.user_core.entities.User;
import com.Lab_seguridad.seguridad.user_module.user_core.repositories.iUserRepository;
import com.Lab_seguridad.seguridad.user_module.user_service.interfaces.iUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements iUserService {

    private final iUserRepository userRepository;

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> getUserLogin(int id, String username, String password) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            return Optional.empty();
        }
        System.out.println("Valor de user: "+ user);
        if (username.equalsIgnoreCase(user.get().getUsername()) && password.equalsIgnoreCase(user.get().getPassword())){
            return user;
        }
        return Optional.empty();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsersByQuery();
    }

    @Override
    public User getUser(String username, String password) {
        return userRepository.getUserByQuery(username, password);
    }
}
