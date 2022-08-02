package com.cdw.store.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdw.store.dto.AttributeDto;
import com.cdw.store.model.AttributeFilter;
import com.cdw.store.service.IAttributeService;

@RestController
@RequestMapping("/attribute")
public class AttributeResource {
	@Autowired
	private IAttributeService attributeService;

	@GetMapping("/{id}")
	public ResponseEntity<List<AttributeFilter>> getAttributeByCategoryId(@PathVariable("id") Long id) {
		List<AttributeFilter> attributeFilters = new ArrayList<>();
		List<String> attributeNames = attributeService.findAttributeNameByCategoryId(id);
		attributeNames.forEach((attributeName) -> {
			AttributeFilter attributeFilter = new AttributeFilter();
			attributeFilter.setName(attributeName);
			attributeFilter.setValues(attributeService.findAttributeValueByNameAndCategoryId(id, attributeName));
			attributeFilters.add(attributeFilter);
		});
		attributeFilters.forEach((e) -> {
			System.out.println(e.getName());
			e.getValues().forEach(t -> System.out.println(t));
		});
		return new ResponseEntity<>(attributeFilters, HttpStatus.OK);
	}

	@GetMapping("/updateStatus")
	public ResponseEntity<Boolean> updateStatus(@RequestParam Long[] id, @RequestParam String status) {
		boolean result = attributeService.updateStatus(id, status);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<AttributeDto> saveCategory(@RequestBody AttributeDto dto) {
		AttributeDto result = attributeService.saveAttribute(dto);
		return new ResponseEntity<AttributeDto>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("/checkAttributeName")
	public ResponseEntity<Boolean> existAttributeName(@RequestParam String name, @RequestParam String value,@RequestParam Long categoryId) {
		boolean result = attributeService.existAttributeNameInTheSameCategory(name, value,categoryId);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
}
