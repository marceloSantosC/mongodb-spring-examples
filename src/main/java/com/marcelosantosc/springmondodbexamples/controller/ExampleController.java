package com.marcelosantosc.springmondodbexamples.controller;


import com.marcelosantosc.springmondodbexamples.model.ExampleModel;
import com.marcelosantosc.springmondodbexamples.repository.ExampleRepository;
import com.marcelosantosc.springmondodbexamples.repository.NestedExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/examples")
public class ExampleController {
 private final ExampleRepository exampleRepository;
 private final NestedExampleRepository nestedExampleRepository;

    @GetMapping("/{id}")
    public ExampleModel getExamplesById(@PathVariable String id) {
        return exampleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<ExampleModel> getByFilters(@RequestParam(required = false) LocalDate minDate,
                                           @RequestParam(required = false) LocalDate maxDate,
                                           @RequestParam(required = false) String name) {

        // Query by Example ou query method seriam mais apropriados aqui, porém @Query é mais didático
        if (minDate != null && maxDate != null) {
            return exampleRepository.findByCreatedAtBetween(minDate, maxDate);
        }

        if (name != null) {
            return exampleRepository.findByName(name);
        }

        return exampleRepository.findAll();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createExample(@RequestBody ExampleModel exampleModel) {
        exampleModel.setId(null);

        if (exampleModel.getNestedExample() != null) {
            exampleModel.getNestedExample().setId(null);
            nestedExampleRepository.save(exampleModel.getNestedExample());
        }

        exampleRepository.save(exampleModel);
    }



}

