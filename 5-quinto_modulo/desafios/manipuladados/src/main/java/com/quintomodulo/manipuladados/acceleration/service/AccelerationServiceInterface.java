package com.quintomodulo.manipuladados.acceleration.service;

import com.quintomodulo.manipuladados.acceleration.model.Acceleration;
import com.quintomodulo.manipuladados.generic_interface.ServiceInterface;

import java.util.List;
import java.util.Optional;

public interface AccelerationServiceInterface extends ServiceInterface<Acceleration> {

    Optional<Acceleration> findById(Long id);

    List<Acceleration> findByCompanyId(Long companyId);

}
