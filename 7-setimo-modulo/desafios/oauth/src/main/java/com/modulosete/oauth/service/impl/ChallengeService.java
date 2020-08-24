package com.modulosete.oauth.service.impl;

import com.modulosete.oauth.entity.Challenge;
import com.modulosete.oauth.repository.ChallengeRepository;
import com.modulosete.oauth.service.interfaces.ChallengeServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ChallengeService implements ChallengeServiceInterface {

    private ChallengeRepository repository;

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return repository.findByAccelerationIdAndUserId(accelerationId, userId);
    }

}
