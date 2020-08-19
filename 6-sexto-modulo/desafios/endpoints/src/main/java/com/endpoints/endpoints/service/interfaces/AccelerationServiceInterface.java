package com.endpoints.endpoints.service.interfaces;

import com.endpoints.endpoints.entity.Acceleration;

import java.util.List;
import java.util.Optional;

public interface AccelerationServiceInterface extends ServiceInterface<Acceleration> {

    Optional<Acceleration> findById(Long id);

    List<Acceleration> findByCompanyId(Long companyId);

}
