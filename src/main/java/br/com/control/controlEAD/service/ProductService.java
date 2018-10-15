package br.com.control.controlEAD.service;

import br.com.control.controlEAD.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Product> saveProduct(Product product);

    Flux<Product> getAll();

}
