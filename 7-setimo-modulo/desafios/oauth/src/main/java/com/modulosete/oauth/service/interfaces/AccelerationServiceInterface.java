package com.modulosete.oauth.service.interfaces;

import com.modulosete.oauth.entity.Acceleration;

import java.util.List;
import java.util.Optional;

public interface AccelerationServiceInterface extends ServiceInterface<Acceleration> {

    Optional<Acceleration> findById(Long id);

    List<Acceleration> findByCompanyId(Long companyId);

}
