package com.cdw.store.service;

import com.cdw.store.dto.ImageDto;

import java.util.List;

public interface IImageService {
    public List<ImageDto> findImageByProductId(Long id);
}
