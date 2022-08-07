package com.jfeesoft.fr.service.impl;

import com.jfeesoft.fr.service.StatisticsService;
import com.jfeesoft.fr.service.calculation.GpxService;
import io.jenetics.jpx.GPX;
import io.jenetics.jpx.Track;
import io.jenetics.jpx.TrackSegment;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;

@RequiredArgsConstructor
@Service
@Log
public class GpxServiceImpl implements GpxService {
    private final StatisticsService statisticsService;

    public GPX parseGpx(String path) throws IOException {
        GPX gpx = GPX.read(Path.of(path));
        gpx.tracks().flatMap(Track::segments)
                .flatMap(TrackSegment::points);
        return gpx;
    }

    public double calculateDistance(String path) throws IOException {
        return statisticsService.calculateDistance(parseGpx(path).getTracks().get(0).getSegments().get(0).getPoints());
    }
}
