package com.cdw.store.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.Attribute;

@Repository
public interface AttributeRepo extends JpaRepository<Attribute, Long> {
	@Query("Select  a.value from Attribute a  where a.category.id = :cateId and a.name=:name")
	List<String> findAttributeValueByNameAndCategoryId(Long cateId, String name);

	@Query("Select  a.name from Attribute a  where a.category.id = :cateId group by a.name")
	List<String> findAttributeNameByCategoryId(Long cateId);

	@Query("Select  a.value from Attribute a  where  a.name=:name")
	List<String> findAttributeValueByName(String name);

	@Query("Select  a.name from Attribute a group by a.name")
	List<String> findAttributeName();

	Optional<Attribute> findById(Long id);
	boolean existsByNameAndValueAndCategoryId(String name, String value, Long categoryId);
}
