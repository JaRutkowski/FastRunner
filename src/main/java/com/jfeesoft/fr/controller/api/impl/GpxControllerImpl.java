package com.jfeesoft.fr.controller.api.impl;

import com.jfeesoft.fr.controller.api.GpxController;
import com.jfeesoft.fr.service.GpxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class GpxControllerImpl implements GpxController {
    private final GpxService gpxService;

    @Override
    public ResponseEntity upload(MultipartFile file) {
        gpxService.upload(file);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity parse(String file) throws IOException {
        gpxService.parseGpx(file);
        return ResponseEntity.ok().build();
    }
}
