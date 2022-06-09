package com.cdw.store.service;

import java.util.List;

import com.cdw.store.dto.DetailProductDto;
import com.cdw.store.dto.ProductDto;
import com.cdw.store.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
	public ProductDto addProduct(ProductDto productDto);

	public List<ProductDto> findALlProducts();

	public ProductDto updateProduct(ProductDto productDto);

	public void deleteProduct(Long id);

	public DetailProductDto findProductById(Long id);
	public List<ProductDto> searchProducts(String key);
	public Page<ProductDto>searchAndPaging(String q,Pageable  paging);
	public Page<ProductDto>findByCategoryId(Long id,Pageable  paging);
	public Page<ProductDto>findAll(Pageable  paging);
}
