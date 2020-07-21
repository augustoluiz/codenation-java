package com.quintomodulo.manipuladados.acceleration.service;

import com.quintomodulo.manipuladados.acceleration.model.Acceleration;
import com.quintomodulo.manipuladados.generic_interface.ServiceInterface;

import java.util.List;
import java.util.Optional;

public interface AccelerationServiceInterface extends ServiceInterface<Acceleration> {

    List<Acceleration> findAll();

    Optional<Acceleration> findAccelerationById(Long id);

    Optional<Acceleration> findAccelerationByName(String name);

    List<Acceleration> findByCompanyId(Long companyId);

}
