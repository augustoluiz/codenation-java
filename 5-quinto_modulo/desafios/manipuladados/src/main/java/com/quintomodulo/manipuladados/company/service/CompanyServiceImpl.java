package com.quintomodulo.manipuladados.company.service;

import com.quintomodulo.manipuladados.company.model.Company;
import com.quintomodulo.manipuladados.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyServiceInterface{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return this.companyRepository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return this.companyRepository.findbyAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return this.companyRepository.findByUserId(userId);
    }

    @Override
    public Company save(Company object) {
        return this.companyRepository.save(object);
    }
}
