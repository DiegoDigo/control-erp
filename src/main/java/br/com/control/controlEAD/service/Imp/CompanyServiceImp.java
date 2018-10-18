package br.com.control.controlEAD.service.Imp;

import br.com.control.controlEAD.model.Company;
import br.com.control.controlEAD.repository.CompanyRepository;
import br.com.control.controlEAD.service.CompanyService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyServiceImp implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImp(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Mono<Company> saveCompany(Company company) {
        return this.companyRepository.save(company);
    }

    @Override
    public Flux<Company> getAllCompany() {
        return this.companyRepository.findAll();
    }

    @Override
    public Mono<Company> getCompanyById(String id) {
        return this.companyRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteCompanyById(String id) {
        return this.companyRepository.deleteById(id);
    }
}
