package com.cdw.store.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cdw.store.utils.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	@Autowired
	private ProductConverter productConverter;
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
	@GetMapping("/search")
	public ResponseEntity<Map<String, Object>> searchAndPaging( @RequestParam(required = false) String q,
															 @RequestParam(defaultValue = "0") int page,
															 @RequestParam(defaultValue = "3") int size){
		Pageable paging = PageRequest.of(page, size);
		Page<Product> pageProducts ;
		if(q==null){
			pageProducts=productService.findALl(paging);
		}else{
			pageProducts=productService.searchBAndPaging(q,paging);
		}
		List<ProductDto> products= pageProducts.getContent().stream().map(productEntity->productConverter.convertToDto(productEntity)).collect(Collectors.toList());
		Map<String, Object> response = new HashMap<>();
		response.put("products", products);
		response.put("currentPage", pageProducts.getNumber());
		response.put("totalItems", pageProducts.getTotalElements());
		response.put("totalPages", pageProducts.getTotalPages());
		return new ResponseEntity<>(response, HttpStatus.OK);
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
