package com.jfeesoft.fr.service.impl;

import com.jfeesoft.fr.model.domain.Test;
import com.jfeesoft.fr.model.repository.TestRepository;
import com.jfeesoft.fr.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    public List<Test> findAll() {
        return testRepository.findAll();
    }
}
