package com.jfeesoft.fr.service.common;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void upload(MultipartFile file);
}
