package com.cdw.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddDto {
    private Long id;
    private String name;
    private String longDescription;
    private Long price;
    private Long quantity;
    private Integer discount;
    private Integer status;

}