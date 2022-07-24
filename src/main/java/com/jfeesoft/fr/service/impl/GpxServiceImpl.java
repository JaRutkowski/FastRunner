package com.jfeesoft.fr.service.impl;

import com.jfeesoft.fr.service.GpxService;
import io.jenetics.jpx.GPX;
import io.jenetics.jpx.Track;
import io.jenetics.jpx.TrackSegment;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@Log
public class GpxServiceImpl implements GpxService {
    private Path fastRunnerDir;

    @Override
    public void upload(MultipartFile file) {
        createUploadDirectory();
        Path uploadPath = fastRunnerDir.resolve(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            Files.copy(file.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
            file.getInputStream().close();
        } catch (IOException e) {
            log.severe(e.getMessage());
        }
    }

    public void parseGpx(String path) throws IOException {
        GPX.read(Path.of(path)).tracks()
                .flatMap(Track::segments)
                .flatMap(TrackSegment::points)
                .forEach(System.out::println);
    }

    private void createUploadDirectory() {
        File uploadDirectory = new File("C:\\fast-runner");
        if(!uploadDirectory.exists()) {
            try {
                Files.createDirectories(uploadDirectory.toPath());
            } catch (IOException e) {
                log.severe(e.getMessage());
            }
        }
        fastRunnerDir = uploadDirectory.toPath();
    }
}
