package com.jfeesoft.fr.controller.api;

import com.jfeesoft.fr.model.domain.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public interface TestController {
    @GetMapping
    ResponseEntity findAll();

    @GetMapping("/byId/{id}")
    ResponseEntity findAllById(@PathVariable Integer id);

    @GetMapping("/byName")
    ResponseEntity findAllByName(@RequestParam String name);

    @PostMapping
    ResponseEntity save(@RequestBody Test test);

    // update

    @DeleteMapping("/byId/{id}")
    ResponseEntity delete(@PathVariable Integer id);

    // rozpoznać temat: header

    // mock aplikacji - narysować ekrany
}
