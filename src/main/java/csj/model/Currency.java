package csj.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the currency database table.
 * 
 */
@Entity
@NamedQuery(name="Currency.findAll", query="SELECT c FROM Currency c")
public class Currency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String code;

	@Temporal(TemporalType.DATE)
	private Date creation;

	private String logo;

	private String micro;

	private Boolean minable;

	private String name;

	private String pname;

	private Long project;

	private Timestamp record;

	private String slug;

	private String wiki;

	//bi-directional many-to-one association to CurrencyType
	@ManyToOne
	@JoinColumn(name="type")
	private CurrencyType currencyType;

	public Currency() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreation() {
		return this.creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMicro() {
		return this.micro;
	}

	public void setMicro(String micro) {
		this.micro = micro;
	}

	public Boolean getMinable() {
		return this.minable;
	}

	public void setMinable(Boolean minable) {
		this.minable = minable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Long getProject() {
		return this.project;
	}

	public void setProject(Long project) {
		this.project = project;
	}

	public Timestamp getRecord() {
		return this.record;
	}

	public void setRecord(Timestamp record) {
		this.record = record;
	}

	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getWiki() {
		return this.wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public CurrencyType getCurrencyType() {
		return this.currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

}