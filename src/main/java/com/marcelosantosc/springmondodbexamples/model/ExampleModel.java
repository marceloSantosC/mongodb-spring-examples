package com.marcelosantosc.springmondodbexamples.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("example")
public class ExampleModel {

    @Id
    private String id;

    @Field("name") // @Field = @Column
    private String name;

    @Field("desc")
    private String description;

    @Field("createdAt")
    private LocalDate createdAt;

    @DBRef // Faz referência a uma outra collection, equivale a @OneToOne ou @OneToMany. Suporta lazy load e referenciar outro db
    private NestedExampleModel nestedExample;


}
