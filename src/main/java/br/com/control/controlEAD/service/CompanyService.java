package br.com.control.controlEAD.service;


import br.com.control.controlEAD.model.Company;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyService {

    Mono<Company> saveCompany(Company company);

    Flux<Company> getAllCompany();

    Mono<Company> getCompanyById(String id);

    Mono<Void> deleteCompanyById(String id);

}
