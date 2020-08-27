package csj.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the people database table.
 * 
 */
@Entity
@NamedQuery(name="People.findAll", query="SELECT p FROM People p")
public class People implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date bday;

	private String description;

	private String firstname;

	private String lastname;

	private String portrait;

	private Boolean sexe;

	private String wiki;

	public People() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBday() {
		return this.bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPortrait() {
		return this.portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public Boolean getSexe() {
		return this.sexe;
	}

	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}

	public String getWiki() {
		return this.wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

}