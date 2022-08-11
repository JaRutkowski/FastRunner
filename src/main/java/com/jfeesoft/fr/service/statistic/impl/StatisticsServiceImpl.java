package com.jfeesoft.fr.service.statistic.impl;

import com.jfeesoft.fr.service.statistic.StatisticsService;
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
        double distance = 0;

        int countToTwo = 0;
        for (int x = 0; x < points.size()-1; x++) {
            countToTwo++;
            double latitudeA = Double.parseDouble(points.get(x).getLatitude().toString()),
                    longitudeA = Double.parseDouble(points.get(x).getLongitude().toString()),
                    latitudeB = Double.parseDouble(points.get(x+1).getLatitude().toString()),
                    longitudeB = Double.parseDouble(points.get(x+1).getLatitude().toString()),
                    longitudeMinusLatitudeSquared;

            System.out.println(latitudeA);
            System.out.println(longitudeA);
            System.out.println(latitudeB);
            System.out.println(longitudeB);


            //longitudeMinusLatitudeSquared = Math.pow(longitude - latitude, 2);
            //pointsXAndYSubtractedAndSquared.add(longitudeMinusLatitudeSquared);
           // distance = distance + calculatex(longitude, latitude);
        }

            return distance;


    }

        public double calculate(double longitude, double latitude ){
            return Math.sqrt(
                    longitude + latitude);
        }


}
