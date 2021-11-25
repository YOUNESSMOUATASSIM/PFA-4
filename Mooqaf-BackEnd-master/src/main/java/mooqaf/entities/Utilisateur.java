package mooqaf.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import mooqaf.entities.Ville;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Data @NoArgsConstructor @AllArgsConstructor

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public abstract class Utilisateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	@NotNull
	private String prenom;
	@NotNull
	private String nom;
	@NotNull
	@Column(unique = true)
	private String tel;
	
	@ManyToOne()
	private Ville ville;
	

}
