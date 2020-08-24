package com.modulosete.oauth.service.interfaces;

import com.modulosete.oauth.entity.Challenge;

import java.util.List;

public interface ChallengeServiceInterface extends ServiceInterface<Challenge> {

    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);

}
