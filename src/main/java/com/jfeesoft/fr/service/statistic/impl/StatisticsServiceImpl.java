package com.jfeesoft.fr.service.impl;

import com.jfeesoft.fr.service.StatisticsService;
import io.jenetics.jpx.WayPoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
@Log
public class StatisticsServiceImpl implements StatisticsService {
    @Override
    public double calculateDistance(List<WayPoint> points) {
        List<Double> pointsXAndYSubtractedAndSquared = new ArrayList<>();
        for (WayPoint wayPoint : points) {
            double latitude = Double.parseDouble(wayPoint.getLatitude().toString()),
                    longitude = Double.parseDouble(wayPoint.getLongitude().toString()),
                    longitudeMinusLatitudeSquared = Math.pow(longitude - latitude, 2);
            pointsXAndYSubtractedAndSquared.add(longitudeMinusLatitudeSquared);
        }

        double distance = 0;
        for (int i = 0; i < pointsXAndYSubtractedAndSquared.size() - 1; i++)
            distance = distance + Math.sqrt(
                    pointsXAndYSubtractedAndSquared.get(i) + pointsXAndYSubtractedAndSquared.get(i + 1));
        return distance;
    }
}
