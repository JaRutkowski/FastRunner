package com.jfeesoft.fr.service.common.impl;

import com.jfeesoft.fr.service.common.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Log
public class FileServiceImpl implements FileService {
    @Value("${app.storage.path}")
    private String storageDir;
    private Path fastRunnerDir;

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

    private void createUploadDirectory() {
        File createNewDirectory = new File(storageDir);
        if (!createNewDirectory.exists()) {
            try {
                Files.createDirectories(createNewDirectory.toPath());
            } catch (IOException e) {
                log.severe(e.getMessage());
            }
        }
        fastRunnerDir = createNewDirectory.toPath();
    }
}
