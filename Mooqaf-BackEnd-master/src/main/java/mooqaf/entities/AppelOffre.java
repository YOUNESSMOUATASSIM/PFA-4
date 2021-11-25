package mooqaf.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AppelOffre  implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titre;
	
	private Date dateExpiration;
	
	private String description;
	
	@ManyToOne
	private Specialite specialite;
	
	@ManyToOne
	private Particulier particulier;
	
	@OneToMany(mappedBy = "appelOffre",cascade = CascadeType.ALL,orphanRemoval = true)

	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Proposition> propositions;
}
