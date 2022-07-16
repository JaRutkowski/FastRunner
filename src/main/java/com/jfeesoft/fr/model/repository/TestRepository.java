package com.jfeesoft.fr.model.repository;

import com.jfeesoft.fr.model.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
