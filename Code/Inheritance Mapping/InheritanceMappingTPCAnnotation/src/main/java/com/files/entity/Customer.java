package com.files.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="customer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerid;
	
	@Column(name="customer_name")
	private String cname;
	private long phone;
	private float price;
}
