package com.thymeleafform;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {

    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadpath = Paths.get(uploadDir);

        if (!Files.exists(uploadpath)) {
            Files.createDirectories(uploadpath);
        }
        try (InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadpath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save file" + fileName, ioe);
        }
        }
    }
