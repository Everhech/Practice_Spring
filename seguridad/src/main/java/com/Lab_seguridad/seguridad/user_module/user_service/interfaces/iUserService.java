package com.Lab_seguridad.seguridad.user_module.user_service.interfaces;

import com.Lab_seguridad.seguridad.user_module.user_core.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface iUserService {
    public ArrayList<User> getAllUsers();
    public Optional<User> getUserLogin(int id, String username, String password);

    // With SQL Query
    public List<User> getUsers();
    public User getUser(String username, String password);

}
