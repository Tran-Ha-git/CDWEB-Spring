package com.cdw.store.service;

import java.util.List;

import com.cdw.store.dto.ProductDto;
import com.cdw.store.model.Product;

public interface IProductService {
	public Product addProduct(Product product);

	public List<ProductDto> findALlProducts();

	public Product updateProduct(Product product);

	public void deleteProduct(Long id);

	public Product findProductById(Long id);
}
