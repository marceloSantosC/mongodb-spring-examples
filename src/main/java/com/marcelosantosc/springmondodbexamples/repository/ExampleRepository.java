package com.marcelosantosc.springmondodbexamples.repository;

import com.marcelosantosc.springmondodbexamples.model.ExampleModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExampleRepository extends MongoRepository<ExampleModel, String> {

    @Query("{'name': ?0}")
    List<ExampleModel> findByName(String name);

    @Query("{'$and': [{'createdAt': {'$gte': ?0}}, {'createdAt': {'$lte': ?1}}]}")
    List<ExampleModel> findByCreatedAtBetween(LocalDate start, LocalDate end);

}
