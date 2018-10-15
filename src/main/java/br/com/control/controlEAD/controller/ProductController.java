package br.com.control.controlEAD.controller;

import br.com.control.controlEAD.model.Company;
import br.com.control.controlEAD.model.Product;
import br.com.control.controlEAD.repository.CompanyRepository;
import br.com.control.controlEAD.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@RestController
@RequestMapping("product")
public class ProductController{

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Mono<ResponseEntity<Product>> create(@RequestBody Product product){
        return this.productService.saveProduct(product)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @GetMapping
    public Flux<Product> getAll(){
        return this.productService.getAll();
    }
}
