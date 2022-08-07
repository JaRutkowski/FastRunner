package com.jfeesoft.fr.model.repository;

import com.jfeesoft.fr.model.domain.ActivityEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityEntryRepository extends JpaRepository<ActivityEntry, Long> {
}
