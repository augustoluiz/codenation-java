package com.quintomodulo.manipuladados.acceleration.repository;

import com.quintomodulo.manipuladados.acceleration.model.Acceleration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    List<Acceleration> findAll();

}
