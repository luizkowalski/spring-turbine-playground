package com.inkdrop.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tips")
public class Tip implements Serializable {

	private static final long serialVersionUID = 885909755564240924L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String fqid;
	
	@Column(nullable=false)
	private String tip;
	
	@ManyToOne
	private Venue venue;
	
	@Column
	private Date createdAtFoursquare;
}
