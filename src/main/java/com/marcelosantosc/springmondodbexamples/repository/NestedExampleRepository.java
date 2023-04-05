package com.marcelosantosc.springmondodbexamples.repository;

import com.marcelosantosc.springmondodbexamples.model.NestedExampleModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NestedExampleRepository extends MongoRepository<NestedExampleModel, String> {
}
