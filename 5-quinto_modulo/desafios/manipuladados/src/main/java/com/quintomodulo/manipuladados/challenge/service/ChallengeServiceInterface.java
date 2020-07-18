package com.quintomodulo.manipuladados.challenge.service;

import com.quintomodulo.manipuladados.challenge.model.Challenge;
import com.quintomodulo.manipuladados.generic_interface.ServiceInterface;

import java.util.List;

public interface ChallengeServiceInterface extends ServiceInterface<Challenge> {

    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);

}
