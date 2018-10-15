package br.com.control.controlEAD.controller;

import br.com.control.controlEAD.model.Company;
import br.com.control.controlEAD.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public Flux<Company> getAll(){
        return companyService.getAllCompany();

    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<Company>> get(@PathVariable("id") String id){
        return companyService.getCompanyById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @PostMapping
    public Mono<ResponseEntity<Company>> create(@RequestBody Company company){
          return companyService.saveCompany(company)
                  .map(ResponseEntity::ok)
                  .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @PutMapping
    public Mono<ResponseEntity<Company>> update(@RequestBody Company company){
        return companyService.saveCompany(company)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return companyService.deleteCompanyById(id);


    }
}
