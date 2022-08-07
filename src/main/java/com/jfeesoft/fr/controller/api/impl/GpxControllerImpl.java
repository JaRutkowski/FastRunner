package com.jfeesoft.fr.controller.api.impl;

import com.jfeesoft.fr.controller.api.GpxController;
import com.jfeesoft.fr.service.common.FileService;
import com.jfeesoft.fr.service.calculation.GpxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class GpxControllerImpl implements GpxController {
    private final GpxService gpxService;
    private final FileService fileService;

    @Override
    public ResponseEntity upload(MultipartFile file) {
        fileService.upload(file);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity parse(String file) throws IOException {
        gpxService.parseGpx(file);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity calculateDistance(String file) throws IOException {
        return ResponseEntity.ok(gpxService.calculateDistance(file));
    }
}
