package com.ums.model.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);

    private final static String DIRECTORIES_UPLOAD = "uploads";

    @Override
    public Resource load(String photoName) throws MalformedURLException {

        Path pathArchive = getPath(photoName);
        log.info(pathArchive.toString());

        Resource resource = new UrlResource(pathArchive.toUri());

        if (!resource.exists() && !resource.isReadable()) {
            pathArchive = Paths.get("src/main/resources/static/images").resolve("no-usuario.png").toAbsolutePath();

            resource = new UrlResource(pathArchive.toUri());

            log.error("Error image could not be loaded: " + photoName);

        }
        return resource;
    }

    @Override
    public String load(MultipartFile multipartFile) throws IOException {

        String fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename().replace(" ", "");

       String filePath = "D:\\uploads\\";
        log.info(filePath);

        File dest = new File(filePath+fileName);
        multipartFile.transferTo(dest);

        return fileName;
    }

    @Override
    public boolean remove(String namePhoto) {

        if (namePhoto != null && namePhoto.length() > 0) {
            Path pathPhotoArchive = Paths.get("uploads").resolve(namePhoto).toAbsolutePath();
            File file = pathPhotoArchive.toFile();
            if (file.exists() && file.canRead()) {
                file.delete();
                return true;
            }
        }

        return false;
    }

    @Override
    public Path getPath(String namePhoto) {
        return Paths.get(DIRECTORIES_UPLOAD).resolve(namePhoto).toAbsolutePath();
    }

}
