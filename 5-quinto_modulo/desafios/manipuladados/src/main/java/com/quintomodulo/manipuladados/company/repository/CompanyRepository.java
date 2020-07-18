package com.quintomodulo.manipuladados.company.repository;

import com.quintomodulo.manipuladados.company.model.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository  extends CrudRepository<Company, Long> {

    List<Company> findAll();

}
