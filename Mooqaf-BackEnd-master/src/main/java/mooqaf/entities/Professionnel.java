package mooqaf.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Professionnel")
@Data @AllArgsConstructor @ToString @NoArgsConstructor 
public class Professionnel extends Utilisateur{
	
	@ManyToOne
	private Specialite specialite;
	
	@OneToMany(mappedBy = "professionnel")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Proposition> propositions;
	
}
