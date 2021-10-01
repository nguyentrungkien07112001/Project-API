package com.vti.ki4m.service.serviceImpl;

import com.vti.ki4m.service.IFileService;
import com.vti.ki4m.utils.FileManager;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileService implements IFileService {

    private FileManager fileManager = new FileManager();
    private String linkFolder = "C:\\KI4M-base-BE\\publics";

    @Override
    public String uploadImage(MultipartFile image) throws IOException {

        String nameImage = new Date().getTime() + "." + fileManager.getFormatFile(image.getOriginalFilename());

        String path = linkFolder + "\\" + nameImage;

        fileManager.createNewMultiPartFile(path, image);

        // TODO save link file to database

        // return link uploaded file
        return path;
    }

    @Override
    public File dowwnloadImage(String nameImage) throws IOException {

        String path = linkFolder + "\\" + nameImage;

        return new File(path);
    }
}
