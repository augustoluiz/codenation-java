package com.modulosete.oauth.service.impl;

import com.modulosete.oauth.entity.Acceleration;
import com.modulosete.oauth.repository.AccelerationRepository;
import com.modulosete.oauth.service.interfaces.AccelerationServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccelerationService implements AccelerationServiceInterface {

    private AccelerationRepository accelerationRepository;

    @Override
    public Optional<Acceleration> findById(Long id) {
        return accelerationRepository.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return accelerationRepository.findByCandidatesIdCompanyId(companyId);
    }

}
