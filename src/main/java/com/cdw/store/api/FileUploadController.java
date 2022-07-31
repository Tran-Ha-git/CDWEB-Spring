package com.cdw.store.api;

import com.cdw.store.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/FileUpload")
public class FileUploadController {
    @Autowired
    private IStorageService storageService;

    @PostMapping("")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
        try{
            String generatedFileName = storageService.storeFile(file);
            return new ResponseEntity<>(generatedFileName, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("", HttpStatus.NOT_IMPLEMENTED);
        }
    }
    @GetMapping("/files/{fileName:.+}")
    public ResponseEntity<byte[]> readDetailFile(@PathVariable String fileName){
    try{
        byte[] bytes = storageService.readFileContent(fileName);
        return  ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }catch(Exception e){
        return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("")
    public ResponseEntity<List<String>> getUploadedFiles(){
    try{
    List<String> urls = storageService.loadAll()
            .map(path->{
                //convert fileName to url (send request "readDetailFile")
                String urlPath = MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "readDetailFile",path.getFileName().toString()).build().toUri().toString();
                return urlPath;
            }).collect(Collectors.toList());
            return new ResponseEntity<>(urls,HttpStatus.OK);
                }catch(Exception e){
        return ResponseEntity.noContent().build();
                }
    }
    
    @PostMapping("/multi")
    public ResponseEntity<List<String>> uploadFile(@RequestParam("files") List<MultipartFile> files){
        try{
            List<String> filenames = new ArrayList<String>();
            for (MultipartFile file : files) {
            	String generatedFileName = storageService.storeFile(file);
             	filenames.add(generatedFileName);
			}
			return new ResponseEntity<>(filenames , HttpStatus.OK);
        }catch(Exception e){
        	e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
