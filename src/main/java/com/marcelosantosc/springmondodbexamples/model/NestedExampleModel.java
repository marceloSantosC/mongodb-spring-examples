package com.marcelosantosc.springmondodbexamples.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("nestedExample")
public class NestedExampleModel {

    @Id
    private String id;

    @Field("desc")
    private String description;

}
