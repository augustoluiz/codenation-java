package com.quintomodulo.manipuladados.challenge.service;

import com.quintomodulo.manipuladados.challenge.model.Challenge;
import com.quintomodulo.manipuladados.challenge.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeServiceImpl implements ChallengeServiceInterface{

    @Autowired
    private ChallengeRepository challengeRepository;

    @Override
    public List<Challenge> findAll() {
        return this.challengeRepository.findAll();
    }

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return this.challengeRepository.findByAccelerationIdAndUserId(accelerationId, userId);
    }

    @Override
    public Challenge save(Challenge object) {
        return this.challengeRepository.save(object);
    }
}
