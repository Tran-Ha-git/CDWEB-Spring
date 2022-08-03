package com.cdw.store.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdw.store.model.Product;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Query("SELECT p FROM Product p WHERE UPPER(p.name) LIKE %?1%")
    List<Product> search(String keyword);
    Page<Product> findByNameContainingIgnoreCase(String q, Pageable pageable);

//    @Query("Select distinct p from Product p join p.attributes a join a.category c where c.id = :id")
    @Query("Select distinct p from Product p join p.attributes a join a.category c where c.id = :id")
        Page<Product> findProductsByCategoryId(Long id, Pageable pageable);


    @Query("Select distinct p from Product p join p.attributes a join a.category c where c.name = :name")
        Page<Product> findProductsByCategogyName(String name, Pageable pageable);

	@Query("SELECT p.quantity FROM Product p WHERE p.id = :id")
	Long getQuantityProductByProductId(@Param("id") Long id);
	
	@Query("SELECT price-(price*(discount/100)) FROM Product p WHERE p.id = :id")
	Long getOutputPriceProductByProductId(Long id);
    @Query("Select distinct p.longDescription from Product p  where p.id = :id")
    String getLongDescriptionById(Long id);
    
    @Query(value = "select p.*\r\n"
    		+ "from product_attribute pt inner join attribute t on pt.attribute_id=t.id \r\n"
    		+ "inner join product p on p.id=pt.product_id\r\n"
    		+ " where t.category_id=1 and p.status =1\r\n"
    		+ " GROUP BY p.id limit 10", nativeQuery = true)
	List<Product> findTop10ByAttributesCategoryId(Long catId);
}
