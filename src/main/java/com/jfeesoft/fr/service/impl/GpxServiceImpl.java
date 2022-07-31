package com.jfeesoft.fr.service.impl;

import com.jfeesoft.fr.service.GpxService;
import com.jfeesoft.fr.service.StatisticsService;
import io.jenetics.jpx.GPX;
import io.jenetics.jpx.Track;
import io.jenetics.jpx.TrackSegment;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Log
public class GpxServiceImpl implements GpxService {
    private Path fastRunnerDir;
    private final StatisticsService statisticsService;

    @Override
    public void upload(MultipartFile file) {
        createUploadDirectory();
        Path uploadPath = fastRunnerDir.resolve(Objects.requireNonNull(file.getOriginalFilename())); // /mnt/serv/fr/test.txt
        try {
            Files.copy(file.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
            file.getInputStream().close();
        } catch (IOException e) {
            log.severe(e.getMessage());
        }
    }

    public GPX parseGpx(String path) throws IOException {
        GPX gpx = GPX.read(Path.of(path));
        gpx.tracks().flatMap(Track::segments)
                .flatMap(TrackSegment::points)
                .forEach(System.out::println);
        return gpx;
    }

    public double calculateDistance(String path) throws IOException {
        return statisticsService.calculateDistance(parseGpx(path).getWayPoints());
    }

    private void createUploadDirectory() {
        File uploadDirectory = new File("C:\\fast-runner");
        if (!uploadDirectory.exists()) {
            try {
                Files.createDirectories(uploadDirectory.toPath());
            } catch (IOException e) {
                log.severe(e.getMessage());
            }
        }
        fastRunnerDir = uploadDirectory.toPath();
    }
}
