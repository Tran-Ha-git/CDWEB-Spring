package com.cdw.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	private Long id;
	private String name;
	private String desc;
	private String brand;
	private Long price;
	private Integer discount;
	private String urlImg;
	private Integer status;
	
}
