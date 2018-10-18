package br.com.control.controlEAD.service;

import br.com.control.controlEAD.model.Costumer;
import br.com.control.controlEAD.repository.CostumerReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CostumerService {
    private final CostumerReposity costumerReposity;

    @Autowired
    public CostumerService(CostumerReposity costumerReposity) {
        this.costumerReposity = costumerReposity;
    }

    public Mono<Costumer> findByEmail(String email) {
        return costumerReposity.findByEmail(email);
    }

    public Mono<Void> deleteAll() {
        return costumerReposity.deleteAll();
    }


    public Mono<Costumer> save(Costumer costumer) {
        return costumerReposity.save(costumer);
    }
}
