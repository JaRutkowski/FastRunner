package com.jfeesoft.fr.service.calculation.impl;

import com.jfeesoft.fr.service.statistic.StatisticsService;
import com.jfeesoft.fr.service.calculation.GpxService;
import io.jenetics.jpx.GPX;
import io.jenetics.jpx.Track;
import io.jenetics.jpx.TrackSegment;
import io.jenetics.jpx.WayPoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

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
        return statisticsService.calculateDistance(getWayPoints(path));
    }

    public List<WayPoint> getWayPoints(String path) throws IOException {
        return parseGpx(path).getTracks().get(0).getSegments().get(0).getPoints();
    }

}
