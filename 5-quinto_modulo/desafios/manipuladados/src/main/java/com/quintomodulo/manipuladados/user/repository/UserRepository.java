package com.quintomodulo.manipuladados.user.repository;

import com.quintomodulo.manipuladados.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

}
