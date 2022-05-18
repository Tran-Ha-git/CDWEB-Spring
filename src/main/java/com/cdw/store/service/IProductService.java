package com.cdw.store.service;

import java.util.List;

import com.cdw.store.dto.DetailProductDto;
import com.cdw.store.dto.ProductDto;
import com.cdw.store.model.Product;

public interface IProductService {
	public ProductDto addProduct(ProductDto productDto);

	public List<ProductDto> findALlProducts();

	public ProductDto updateProduct(ProductDto productDto);

	public void deleteProduct(Long id);

	public DetailProductDto findProductById(Long id);
	public List<ProductDto> searchProducts(String key);
}
