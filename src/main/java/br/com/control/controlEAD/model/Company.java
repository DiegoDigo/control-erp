package br.com.control.controlEAD.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "company")
public class Company {
    @Id
    private String id;
    @Indexed
    private String name;
    @Indexed(unique = true)
    private String license;
    private Boolean isClient;
    @DBRef
    private List<Product> prosucts;
    @DBRef
    private List<News> news;

    public Company(String name, String license, Boolean isClient) {
        this.name = name;
        this.license = license;
        this.isClient = isClient;
    }
}
