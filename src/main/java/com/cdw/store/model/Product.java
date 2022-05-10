package com.cdw.store.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String shortDescription;
	private String longDescription;
	private String summary;
	private Long quantity;
	private Long view;
	private Long price; // gia nhap kho
	private Integer status; // 0:ngung ban, 1: con hang
	private Integer discount; // % giam

	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Image> images = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "productComment", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "product_attribute", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "attribute_id"))
	List<Attribute> attributes = new ArrayList<>();

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product) o;
		return Objects.equals(id, product.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
