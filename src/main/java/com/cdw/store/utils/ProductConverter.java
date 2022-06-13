package com.cdw.store.utils;

import java.util.ArrayList;
import java.util.List;

import com.cdw.store.dto.AddressDto;
import com.cdw.store.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cdw.store.dto.DetailProductDto;
import com.cdw.store.dto.ProductDto;
import com.cdw.store.model.Attribute;
import com.cdw.store.model.Image;
import com.cdw.store.model.Product;

@Service
public class ProductConverter {
	public Product convertToEntity(ProductDto dto) {
		Product entity= new Product();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSummary(dto.getDesc());
		entity.setPrice(dto.getPrice());
		entity.setDiscount(dto.getDiscount());
		return entity;
	}
	public Page<ProductDto> convertToDto(Page<Product> pageEntity){
		if (pageEntity == null) {
			return null;
		}
		return pageEntity.map(this::convertToDto);
	}
	public ProductDto convertToDto(Product entity) {
		ProductDto dto= new ProductDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDesc(entity.getSummary());
		dto.setPrice(entity.getPrice());
		dto.setDiscount(entity.getDiscount());
		if(entity.getImages().size()>0){
			dto.setUrlImg(entity.getImages().get(0).getLink());
		}



		return dto;
	}
	
	public DetailProductDto convertToDetailProductDto (Product entity) {
		DetailProductDto dto= new DetailProductDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setQuantity(dto.getQuantity());
		dto.setDiscount(entity.getDiscount());
		dto.setQuantity(entity.getQuantity());
		
		//get brand
		String brand = "";
		List<Attribute> attributes = entity.getAttributes();
		for (Attribute attribute : attributes) {
			if(attribute.getName().equals("THƯƠNG HIỆU")) {
				brand=attribute.getValue();
			}
		}
		dto.setBrand(brand);
		
		List<Image> imgs = entity.getImages();
		if(imgs!=null && imgs.size()>0) {
			List<String> urlImgs = new ArrayList<String>();
			imgs.stream().forEach(img->{
				urlImgs.add(img.getLink());
			});
			String urls[] = urlImgs.toArray(new String[urlImgs.size()]);
			dto.setUrlImgs(urls);
		}
		
		String summary = entity.getSummary();
		String[] description= summary.split(";");
		dto.setDescription(description);
		
		String promotion = entity.getPromotion();
		String[] promotions= promotion.split(";");
		dto.setPromotion(promotions);
		
		dto.setDescription_full(entity.getLongDescription());
		dto.setDescription_short(entity.getShortDescription());
		return dto;
	}
}
