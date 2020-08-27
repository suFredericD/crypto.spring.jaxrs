package csj.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the currency_type database table.
 * 
 */
@Entity
@Table(name="currency_type")
@NamedQuery(name="CurrencyType.findAll", query="SELECT c FROM CurrencyType c")
@JsonIgnoreProperties(value={"currencies"},allowSetters = true)
public class CurrencyType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String label;

	private String slug;

	//bi-directional many-to-one association to Currency
	@OneToMany(mappedBy="currencyType")
	private List<Currency> currencies;

	public CurrencyType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<Currency> getCurrencies() {
		return this.currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}

	public Currency addCurrency(Currency currency) {
		getCurrencies().add(currency);
		currency.setCurrencyType(this);

		return currency;
	}

	public Currency removeCurrency(Currency currency) {
		getCurrencies().remove(currency);
		currency.setCurrencyType(null);

		return currency;
	}

}