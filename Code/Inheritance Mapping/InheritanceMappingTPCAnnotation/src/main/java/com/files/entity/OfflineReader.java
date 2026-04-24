package com.files.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="offlineuser")
@AttributeOverrides(
		{
			@AttributeOverride(name="customerid", column = @Column(name="customerid")),
			@AttributeOverride(name="cname", column = @Column(name="customer_name")),
			@AttributeOverride(name="phone", column = @Column(name="phone")),
			@AttributeOverride(name="price", column = @Column(name="price"))
		}
		)
public class OfflineReader extends Customer
{
	
	private String address;
	private String newsboy;
}
