package com.quintomodulo.manipuladados.acceleration.service;

import com.quintomodulo.manipuladados.acceleration.model.Acceleration;
import com.quintomodulo.manipuladados.acceleration.repository.AccelerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccelerationServiceImpl implements AccelerationServiceInterface{

    @Autowired
    private AccelerationRepository accelerationRepository;

    @Override
    public List<Acceleration> findAll() {
        return this.accelerationRepository.findAll();
    }

    @Override
    public Optional<Acceleration> findAccelerationById(Long id) {
        return this.accelerationRepository.findById(id);
    }

    @Override
    public Optional<Acceleration> findAccelerationByName(String name) {
        return this.accelerationRepository.findAccelerationByName(name);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return this.accelerationRepository.findByCompanyId(companyId);
    }

    @Override
    public Acceleration save(Acceleration object) {
        return this.accelerationRepository.save(object);
    }
}
