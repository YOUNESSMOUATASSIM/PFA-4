package mooqaf.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import mooqaf.Auth.User;

@Entity
@Table(name = "Ville",uniqueConstraints = @UniqueConstraint(columnNames = "nom"))
@Data @NoArgsConstructor @AllArgsConstructor  @ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ville implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7628907005754835370L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String nom;
	
	@OneToMany(mappedBy = "ville",cascade = CascadeType.ALL,orphanRemoval = true)
	

	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Utilisateur> utilisateurs;
	
	
}
