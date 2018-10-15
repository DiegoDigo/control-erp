package br.com.control.controlEAD.repository;

import br.com.control.controlEAD.model.Company;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {
}
