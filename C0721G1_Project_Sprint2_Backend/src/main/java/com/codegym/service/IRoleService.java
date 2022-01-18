package com.codegym.service;

import com.codegym.model.Role;

import java.util.List;

public interface IRoleService extends IGeneralService<Role> {
    List<Role> findByName(String name);
}
