package com.jfeesoft.fr.service.calculation;

import io.jenetics.jpx.GPX;
import io.jenetics.jpx.WayPoint;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface GpxService {
    GPX parseGpx(String path) throws IOException;

    double calculateDistance(String path) throws IOException;

    List<WayPoint> getWayPoints(String path) throws IOException;
}
