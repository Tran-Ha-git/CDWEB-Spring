package com.cdw.store.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cdw.store.model.Attribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
	private Long id;
	private String name;
	private String status;
	private List<AttributeDto> attributes =new ArrayList<>();
}
