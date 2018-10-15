package br.com.control.controlEAD.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Null;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "material")
public class Material {
    @Id
    private String id;
    @Indexed
    private String type;
    @Indexed
    private String name;
    @Null
    private String url;
}
