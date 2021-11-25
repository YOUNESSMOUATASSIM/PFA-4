package mooqaf.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Particulier")
@Data @AllArgsConstructor @ToString @NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Particulier extends Utilisateur implements Serializable{
	
	@OneToMany(mappedBy = "particulier",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<AppelOffre> appelOffres;
}
