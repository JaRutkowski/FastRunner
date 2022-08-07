package com.jfeesoft.fr.service.statistic;

import io.jenetics.jpx.WayPoint;

import java.util.List;

public interface StatisticsService {
    double calculateDistance(List<WayPoint> points);
}
