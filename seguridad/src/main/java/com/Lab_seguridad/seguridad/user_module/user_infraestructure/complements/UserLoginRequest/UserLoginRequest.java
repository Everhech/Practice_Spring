package com.Lab_seguridad.seguridad.user_module.user_infraestructure.complements.UserLoginRequest;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserLoginRequest {
    private final String username;
    private final String password;
}
