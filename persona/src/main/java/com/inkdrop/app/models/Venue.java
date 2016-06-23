package com.inkdrop.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="venues")
public class Venue implements Serializable {
	private static final long serialVersionUID = -2675865713179895233L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String fqid;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private String address;
	
	@OneToMany(cascade={CascadeType.ALL, CascadeType.REMOVE}, mappedBy="venue")
	private List<Tip> tips = new ArrayList<>();
	
	@ManyToOne
	private Category category;

}
