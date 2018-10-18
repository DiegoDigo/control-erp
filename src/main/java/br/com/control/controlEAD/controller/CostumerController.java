package br.com.control.controlEAD.controller;

import br.com.control.controlEAD.model.request.CostumerRequest;
import br.com.control.controlEAD.model.response.CostumerResponse;
import br.com.control.controlEAD.service.CostumerService;
import br.com.control.controlEAD.util.JWTutil;
import br.com.control.controlEAD.util.PBKDF2Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
public class CostumerController {

    private final JWTutil jwTutil;

    private final CostumerService costumerService;

    private final PBKDF2Encoder passwordEncoder;

    @Autowired
    public CostumerController(JWTutil jwTutil, CostumerService costumerService, PBKDF2Encoder passwordEncoder) {
        this.jwTutil = jwTutil;
        this.costumerService = costumerService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("login")
    public Mono<ResponseEntity<CostumerResponse>> login(@RequestBody CostumerRequest costumer) {
        return costumerService.findByEmail(costumer.getEmail()).map((userDetails) -> {
            if (passwordEncoder.encode(costumer.getPassword()).equals(userDetails.getPassword())) {
                return ResponseEntity.ok(new CostumerResponse(jwTutil.generateToken(userDetails)));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        });
    }
}
