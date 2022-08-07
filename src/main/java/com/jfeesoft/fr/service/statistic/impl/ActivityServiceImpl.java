package com.jfeesoft.fr.service.statistic.impl;

import com.jfeesoft.fr.model.domain.ActivityEntry;
import com.jfeesoft.fr.model.repository.ActivityEntryRepository;
import com.jfeesoft.fr.service.statistic.ActivityEntryService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityEntryService {
    private final ActivityEntryRepository activityEntryRepository;

    @Override
    public void save(ActivityEntry activityEntry) {
        activityEntryRepository.save(activityEntry);
    }
}
