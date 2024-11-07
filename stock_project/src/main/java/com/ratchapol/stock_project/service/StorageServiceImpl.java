package com.ratchapol.stock_project.service;

import com.ratchapol.stock_project.exception.StorageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService{

    @Value("${app.upload.path:images}")
    private String path;
    private Path rootLocation;
    
    @Override
    public void init() {
        this.rootLocation = Paths.get(path);
        try{
            Files.createDirectories(rootLocation);
        }catch(StorageException exception){
            throw new StorageException("Could not init storage, " + exception.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(StorageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String store(MultipartFile file) {
        if(file == null || file.isEmpty()){
            return null;
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")){
                throw new StorageException("Path is outside current directory.");
            }
            fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, this.rootLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
                return fileName;
            } catch (IOException ex) {
                Logger.getLogger(StorageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(StorageException exception){
            throw new StorageException("Fail to store file: " + fileName + ", " + exception.getMessage());
        }
        return null;
        
    }
    
}