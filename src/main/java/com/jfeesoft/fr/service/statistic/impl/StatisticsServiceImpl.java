package com.jfeesoft.fr.service.statistic.impl;

import com.jfeesoft.fr.service.statistic.StatisticsService;
import io.jenetics.jpx.WayPoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Log
public class StatisticsServiceImpl implements StatisticsService {
    @Override
    public double calculateDistance(List<WayPoint> points) {
        double distance = 0;
        for (int x = 0; x < points.size() - 1; x++) {
            double latitudeA = Double.parseDouble(points.get(x).getLatitude().toString()),
                    longitudeA = Double.parseDouble(points.get(x).getLongitude().toString()),
                    latitudeB = Double.parseDouble(points.get(x + 1).getLatitude().toString()),
                    longitudeB = Double.parseDouble(points.get(x + 1).getLongitude().toString()),
                    latitudeBMinusLatitudeASquared = Math.pow(latitudeB - latitudeA, 2),
                    longitudeBMinusLongitudeASquared = Math.pow(longitudeB - longitudeA, 2);
            distance = distance + Math.sqrt(
                    latitudeBMinusLatitudeASquared + longitudeBMinusLongitudeASquared);
        }
        return distance;
    }
}
