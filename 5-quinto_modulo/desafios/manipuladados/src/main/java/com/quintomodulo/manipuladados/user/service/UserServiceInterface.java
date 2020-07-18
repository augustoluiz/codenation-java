package com.quintomodulo.manipuladados.user.service;

import com.quintomodulo.manipuladados.generic_interface.ServiceInterface;
import com.quintomodulo.manipuladados.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface extends ServiceInterface<User> {

    List<User> findAll();

    Optional<User> findById(Long userId);

    List<User> findByAccelerationName(String name);

    List<User> findByCompanyId(Long companyId);


}
