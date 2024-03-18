package com.project.backendshopdelivery.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {

    @Value("${fileUpload.rootPath}")
    private String rootPath;

    private Path root;
    // tạo duong dan file
    private void init() {
        try {
            root = Paths.get(rootPath); // lay duong dan
            if (Files.notExists(root)) {
                // neu duong dan k ton tai thi tao duong dan
                Files.createDirectories(root);
            }
        } catch (Exception e) {
            System.out.println("error create folder");
        }

    }

    @Override
    public boolean saveFile(MultipartFile file) {
        try{
            init();
            // thay vi dung root + "/ name file" thi Path ho tro ham getOriginal, va kiem tra da ton tai va long vao vs REPlace_exit
            Files.copy(file.getInputStream(),root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            return true;
        }catch(Exception e){
            System.out.println("Erro save file");
            return false;
        }
    }

    @Override
    public Resource loadFile(String fileName) {
        try {
            init();
            Path file = root.resolve(fileName); // resolve(fileName) = \filename
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }
        } catch (Exception e) {
            System.out.println("Can't load file");
        }
        return null;
    }
}
