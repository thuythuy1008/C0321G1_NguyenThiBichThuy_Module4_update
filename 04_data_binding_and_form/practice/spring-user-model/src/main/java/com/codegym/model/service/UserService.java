package com.codegym.model.service;

import com.codegym.model.bean.Login;
import com.codegym.model.bean.User;

public interface UserService {
    public User checkLogin(Login login);
}
