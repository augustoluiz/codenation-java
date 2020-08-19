package com.endpoints.endpoints.service.interfaces;


import com.endpoints.endpoints.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface extends ServiceInterface<User> {

    Optional<User> findById(Long userId);

    List<User> findByAccelerationName(String accelerationName);

    List<User> findByCompanyId(Long companyId);


}
