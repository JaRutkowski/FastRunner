package com.jfeesoft.fr.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GpxService {
    void upload(MultipartFile file);
    void parseGpx(String path) throws IOException;
}
