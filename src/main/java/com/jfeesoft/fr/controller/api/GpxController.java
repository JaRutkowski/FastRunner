package com.jfeesoft.fr.controller.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequestMapping(value = "/gpx", produces = MediaType.APPLICATION_JSON_VALUE)
public interface GpxController {
    @PostMapping("/upload")
    ResponseEntity upload(@RequestParam("file") MultipartFile file);

    @PostMapping()
    ResponseEntity parse(@RequestParam("file") String file) throws IOException;
}
