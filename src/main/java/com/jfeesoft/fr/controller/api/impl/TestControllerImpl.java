package com.jfeesoft.fr.controller.api.impl;

import com.jfeesoft.fr.controller.api.TestController;
import com.jfeesoft.fr.model.domain.Test;
import com.jfeesoft.fr.service.impl.TestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestControllerImpl implements TestController {
    private final TestServiceImpl testServiceImpl;

    @Override
    public ResponseEntity findAll() {
        return ResponseEntity.ok(testServiceImpl.findAll());
    }

    @Override
    public ResponseEntity findAllById(Integer id) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity findAllByName(String name) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity save(Test test) {
        return ResponseEntity.ok(testServiceImpl.save(test));
    }

    @Override
    public ResponseEntity delete(Integer id) {
        testServiceImpl.deleteTest(id);
        return ResponseEntity.ok().build();
    }


}
