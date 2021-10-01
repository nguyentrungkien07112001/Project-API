package com.vti.ki4m.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface IFileService {

    String uploadImage(MultipartFile image) throws IOException;

    File dowwnloadImage(String nameImage) throws IOException;
}
