package br.com.control.controlEAD.repository;

import br.com.control.controlEAD.model.News;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends ReactiveMongoRepository<News, String> {
}
