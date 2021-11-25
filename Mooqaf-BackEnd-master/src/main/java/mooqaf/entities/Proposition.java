package mooqaf.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Proposition")
@Data @AllArgsConstructor @ToString @NoArgsConstructor 
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Proposition implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double prix;
	private Date dateExpiration;
	
	@ManyToOne
	private AppelOffre appelOffre;
	@ManyToOne
	private Professionnel professionnel;
	
	
	
}
