package com.files.entity1;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name="MountainDestination")
@PrimaryKeyJoinColumn(name="travelid")
public class MountainDestination extends TravelInformation 
{
	private String activities;
	private String roomtype;
}
