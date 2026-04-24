package com.files.entity1;

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
@Table(name="traveldetails")
@Inheritance(strategy = org.hibernate.boot.model.source.spi.InheritanceType.JOINED)
public class TravelInformation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int travelid;
	private String customername;
	private float packageprice;
}
