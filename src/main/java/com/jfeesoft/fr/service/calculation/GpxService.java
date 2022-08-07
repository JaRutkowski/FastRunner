package com.jfeesoft.fr.service;

import io.jenetics.jpx.GPX;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GpxService {
    void upload(MultipartFile file);

    GPX parseGpx(String path) throws IOException;

    double calculateDistance(String path) throws IOException;
}
