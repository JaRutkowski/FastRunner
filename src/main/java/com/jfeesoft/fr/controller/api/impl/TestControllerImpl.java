package com.jfeesoft.fr.controller.api.impl;

import com.jfeesoft.fr.controller.api.TestController;
import com.jfeesoft.fr.model.domain.Test;
import com.jfeesoft.fr.service.impl.TestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestControllerImpl implements TestController {
    private final TestServiceImpl testServiceImpl;

    @Override
    public ResponseEntity<List<Test>> findAll() {
        return ResponseEntity.ok(testServiceImpl.findAll());
    }
}
