package com.mart.order.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "order_table")
public class Order {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "image")
	private String image;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "title")
	private String title;
	
	@JsonIgnore
	@Column(name = "color")
	private List<String> color;
	
	@Column(name = "selling_price")
	private int selling_price;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "discount")
	private String discount;
	
	@JsonIgnore
	@Column(name = "size")
	private List<Integer> size;
	
	@Column(name = "email")
	private String email;
	
}
