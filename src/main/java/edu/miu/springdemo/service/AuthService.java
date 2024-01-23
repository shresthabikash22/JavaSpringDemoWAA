package edu.miu.springdemo.service;

import edu.miu.springdemo.entity.dto.request.LoginRequest;
import edu.miu.springdemo.entity.dto.request.RefreshTokenRequest;
import edu.miu.springdemo.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
