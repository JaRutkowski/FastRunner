package com.jfeesoft.fr.controller.api;

import com.jfeesoft.fr.model.domain.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public interface TestController {
    @GetMapping
    ResponseEntity<List<Test>> findAll();
}
