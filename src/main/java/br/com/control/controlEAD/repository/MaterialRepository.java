package br.com.control.controlEAD.repository;

import br.com.control.controlEAD.model.Material;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends ReactiveMongoRepository<Material, String> {
}
