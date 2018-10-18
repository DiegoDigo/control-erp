package br.com.control.controlEAD.repository;

import br.com.control.controlEAD.model.Costumer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CostumerReposity extends ReactiveMongoRepository<Costumer, String> {

    Mono<Costumer> findByEmail(String email);
}
