package com.jfeesoft.fr.service.impl;

import com.jfeesoft.fr.service.StatisticsService;
import io.jenetics.jpx.Latitude;
import io.jenetics.jpx.Longitude;
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

        ArrayList<Double> pointsXAndYSubtractedAndSquared = new ArrayList<>();

        for(WayPoint wayPoint : points){
            double latitude = Double.parseDouble(wayPoint.getLatitude().toString());
            double longitude = Double.parseDouble(wayPoint.getLongitude().toString());
            double longitudeMinusLatitudeSquared = Math.pow(longitude - latitude, 2);
            pointsXAndYSubtractedAndSquared.add(longitudeMinusLatitudeSquared);
        }

        double distance = 0;

        for(int x = 0; x < pointsXAndYSubtractedAndSquared.size()-1; x++){
            double distanceOfNearbyPoints = Math.sqrt(pointsXAndYSubtractedAndSquared.get(x)+pointsXAndYSubtractedAndSquared.get(x+1));
            distance = distance + distanceOfNearbyPoints;
        }

        return distance;

    }
}
