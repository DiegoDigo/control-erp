package br.com.control.controlEAD.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "news")
public class News {
    @Id
    private String id;
    @Indexed
    private String title;
    private String body;
    @DBRef
    private List<Company> companies;

}
