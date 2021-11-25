package mooqaf.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Table(name="Specialite")
@Data 
@NoArgsConstructor @AllArgsConstructor @ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Specialite implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String intitule;

	@OneToMany(mappedBy = "specialite")
	@JsonProperty(access=Access.WRITE_ONLY)
	
	private Collection<Professionnel> professionnels;
	@OneToMany(mappedBy = "specialite")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<AppelOffre> appelOffres;
	


}
