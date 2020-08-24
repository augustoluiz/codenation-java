package com.modulosete.oauth.service.interfaces;

import com.modulosete.oauth.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface extends ServiceInterface<User> {

    Optional<User> findById(Long userId);

    List<User> findByAccelerationName(String name);

    List<User> findByCompanyId(Long companyId);


}
