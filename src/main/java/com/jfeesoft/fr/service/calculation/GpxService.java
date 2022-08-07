package com.jfeesoft.fr.service.calculation;

import io.jenetics.jpx.GPX;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GpxService {
    GPX parseGpx(String path) throws IOException;

    double calculateDistance(String path) throws IOException;
}
