package br.com.control.controlEAD.controller;

import br.com.control.controlEAD.model.Company;
import br.com.control.controlEAD.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @PreAuthorize("hasRole('ADMIN') or hasRole('REVENDA')" )
    @GetMapping("{id}")
    public Mono<ResponseEntity<Company>> get(@PathVariable("id") String id){
        return companyService.getCompanyById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
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
