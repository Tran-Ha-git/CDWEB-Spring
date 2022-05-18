package com.cdw.store.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cdw.store.dto.DetailProductDto;
import com.cdw.store.dto.ProductDto;
import com.cdw.store.model.Product;
import com.cdw.store.service.impl.ProductService;

@RestController
@RequestMapping("/product")
public class ProductResource {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> products = productService.findALlProducts();
		return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
	}
	@GetMapping("/instantSearch/query")
	public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam("key")String key){
		List<ProductDto> products = productService.searchProducts(key);
		return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<DetailProductDto> getProductById(@PathVariable("id") Long id){
		DetailProductDto product = productService.findProductById(id);
		return new ResponseEntity<DetailProductDto>(product, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
		ProductDto newProduct = productService.addProduct(productDto);
		return new ResponseEntity<ProductDto>(newProduct, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto){
		ProductDto updateProduct = productService.addProduct(productDto);
		return new ResponseEntity<ProductDto>(updateProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id){
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
