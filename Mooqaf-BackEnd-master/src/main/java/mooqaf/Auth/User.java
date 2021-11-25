package mooqaf.Auth;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mooqaf.entities.Ville;

@Entity
@Table(name="user ", uniqueConstraints=@UniqueConstraint(columnNames="tel"))
@Data @NoArgsConstructor @AllArgsConstructor
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String tel;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password ;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="users_roles",
			joinColumns = @JoinColumn(
					name="tel", referencedColumnName = "tel"
					),
			inverseJoinColumns = @JoinColumn(
					name="role", referencedColumnName = "name"
					)
			)
	private Collection<Role> roles;
	

}
