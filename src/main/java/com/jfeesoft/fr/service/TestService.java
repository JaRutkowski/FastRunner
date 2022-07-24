package com.jfeesoft.fr.service;

import com.jfeesoft.fr.model.domain.Test;

import java.util.List;

public interface TestService {
    List<Test> findAll();

    Integer save(Test test);

    void deleteTest(Integer id);

}
