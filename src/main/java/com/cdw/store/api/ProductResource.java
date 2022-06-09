package com.cdw.store.api;

import java.util.*;
import java.util.stream.Collectors;

import com.cdw.store.model.Filter;
import com.cdw.store.model.QueryOperator;
import com.cdw.store.repo.ProductRepo;
import com.cdw.store.repo.specs.ProductSpecification;
import com.cdw.store.utils.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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
private ProductRepo productRepo;
@Autowired
ProductConverter productConverter;
//	@GetMapping("/all")
//	public ResponseEntity<List<ProductDto>> getAllProducts(){
//		List<ProductDto> products = productService.findALlProducts();
//		return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
//	}
	@GetMapping("/instantSearch/query")
	public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam("key")String key){
		List<ProductDto> products = productService.searchProducts(key);
		return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
	}
	@GetMapping("/things")
	public ResponseEntity getThings(@RequestParam("filter") String[] filters) {
		return ResponseEntity.ok(filters);
	}
	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> searchProducts(@RequestParam(required = false) String q,
															 @RequestParam(defaultValue = "0") int page,
															 @RequestParam(defaultValue = "10") int size){
		Pageable paging = PageRequest.of(page, size);
		Page<ProductDto> pageProducts;
		if(q==null){
			pageProducts=productService.findAll(paging);
		}else{
				pageProducts=productService.searchAndPaging(q,paging);
		}
		return new ResponseEntity<>(responsePaging(pageProducts), HttpStatus.OK);
	}

	@GetMapping("/all/{id}")
	public ResponseEntity<Map<String, Object>> getProductsByCategoryId(@PathVariable("id") Long id, @RequestParam(defaultValue = "0") int page,
																		 @RequestParam(defaultValue = "10") int size){
		Pageable paging = PageRequest.of(page, size);
		Page<ProductDto> pageProducts=productService.findByCategoryId(id,paging);
		return new ResponseEntity<>(responsePaging(pageProducts), HttpStatus.OK);
	}
	private Map<String, Object> responsePaging(Page<ProductDto> pageProducts){
		List<ProductDto> products= pageProducts.getContent();
		Map<String, Object> response = new HashMap<>();
		response.put("products", products);
		response.put("currentPage", pageProducts.getNumber());
		response.put("totalItems", pageProducts.getTotalElements());
		response.put("totalPages", pageProducts.getTotalPages());
		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetailProductDto> getProductById(@PathVariable("id") Long id){
		DetailProductDto product = productService.findProductById(id);
		return new ResponseEntity<DetailProductDto>(product, HttpStatus.OK);
	}
	@GetMapping("/bbbb")
	public void getFilter(){
		List<ProductDto> productDtos = new ArrayList<>();
		ProductSpecification msWatchTime = new ProductSpecification();
		msWatchTime.add(new Filter("price",QueryOperator.LESS_THAN_EQUAL ,"20000000"));
		msWatchTime.add(new Filter("price",QueryOperator.GREATER_THAN ,"17000000"));
		List<Product> msWatchTimeList = productRepo.findAll(msWatchTime, Sort.by("name"));

		productDtos=msWatchTimeList.stream().map(productEntity->productConverter.convertToDto(productEntity)).collect(Collectors.toList());

		productDtos.forEach(System.out::println);

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
