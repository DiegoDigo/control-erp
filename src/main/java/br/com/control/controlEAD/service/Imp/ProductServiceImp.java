package br.com.control.controlEAD.service.Imp;

import br.com.control.controlEAD.model.Product;
import br.com.control.controlEAD.repository.ProductRepository;
import br.com.control.controlEAD.service.ProductService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<Product> saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Flux<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Mono<Product> getProductId(String id) {
        return this.productRepository.findById(id);
    }
}
