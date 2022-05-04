package com.cdw.store.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdw.store.dto.ProductDto;
import com.cdw.store.exception.ProductNotFoundException;
import com.cdw.store.model.Attribute;
import com.cdw.store.model.Image;
import com.cdw.store.model.Product;
import com.cdw.store.repo.ProductRepo;
import com.cdw.store.service.IProductService;
import com.cdw.store.utils.ProductConverter;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductConverter productConverter;

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product addProduct(Product product) {
		product.setName("xxx");
		return productRepo.save(product);
	}

	@Override
	public List<ProductDto> findALlProducts() {
		List<Product> entities = productRepo.findAll();

		List<ProductDto> results = new ArrayList<>();

		for (Product entity : entities) {
			ProductDto result = productConverter.convertToDto(entity);

			// set link img
			List<Image> imgs = entity.getImages();
			if (imgs != null && imgs.size() > 0) {
				result.setUrlImg(imgs.get(0).getLink());
			}
			
			//get brand
			String brand = "";
			List<Attribute> attributes = entity.getAttributes();
			for (Attribute attribute : attributes) {
				if(attribute.getName().equals("THƯƠNG HIỆU")) {
					brand=attribute.getValue();
				}
			}
			result.setBrand(brand);
			results.add(result);
		}
		return results;
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}

	@Override
	public Product findProductById(Long id) {
		return productRepo.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product by id = " + id + " was not found"));
	}

}
