package com.quintomodulo.manipuladados.company.service;

import com.quintomodulo.manipuladados.company.model.Company;
import com.quintomodulo.manipuladados.generic_interface.ServiceInterface;

import java.util.List;
import java.util.Optional;

public interface CompanyServiceInterface extends ServiceInterface<Company> {

    Optional<Company> findById(Long id);

    List<Company> findByAccelerationId(Long accelerationId);

    List<Company> findByUserId(Long userId);

}
