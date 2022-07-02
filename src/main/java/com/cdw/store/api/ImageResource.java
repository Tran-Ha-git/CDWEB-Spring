package com.cdw.store.api;

import com.cdw.store.dto.DetailProductDto;
import com.cdw.store.dto.ImageDto;
import com.cdw.store.repo.ImageRepo;
import com.cdw.store.repo.ProductRepo;
import com.cdw.store.service.impl.ImageService;
import com.cdw.store.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageResource {
    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageRepo imageRepo;

    @GetMapping("/{productId}")
    public ResponseEntity<List<ImageDto>> getProductById(@PathVariable("productId") Long productId){
        List<ImageDto> images = imageService.findImageByProductId(productId);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }
}
