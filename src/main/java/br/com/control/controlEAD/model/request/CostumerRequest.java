package br.com.control.controlEAD.model.request;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CostumerRequest {
    private String email;
    private String password;
}
