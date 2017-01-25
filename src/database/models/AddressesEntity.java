package database.models;

import javax.persistence.*;

/**
 * Created by Antoni Rozanski on 25.01.2017.
 */
@Entity @Table(name = "\"Addresses\"", schema = "SYSTEM") public class AddressesEntity
{
	private long idAddress;
	private String city;
	private String street;
	private String postalCode;
	private CountriesEntity countriesByIdCountry;

	@Id
	@Column(name = "\"ID_Address\"", nullable = false, precision = 0)
	public long getIdAddress()
	{
		return idAddress;
	}

	public void setIdAddress(long idAddress)
	{
		this.idAddress = idAddress;
	}

	@Basic
	@Column(name = "\"City\"", nullable = false, length = 30)
	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	@Basic
	@Column(name = "\"Street\"", nullable = false, length = 30)
	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	@Basic
	@Column(name = "\"Postal code\"", nullable = false, length = 5)
	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		AddressesEntity that = (AddressesEntity) o;

		if (idAddress != that.idAddress)
			return false;
		if (city != null ? !city.equals(that.city) : that.city != null)
			return false;
		if (street != null ? !street.equals(that.street) : that.street != null)
			return false;
		if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null)
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idAddress ^ (idAddress >>> 32));
		result = 31 * result + (city != null ? city.hashCode() : 0);
		result = 31 * result + (street != null ? street.hashCode() : 0);
		result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "\"ID_Country\"", referencedColumnName = "\"ID_Country\"", nullable = false)
	public CountriesEntity getCountriesByIdCountry()
	{
		return countriesByIdCountry;
	}

	public void setCountriesByIdCountry(CountriesEntity countriesByIdCountry)
	{
		this.countriesByIdCountry = countriesByIdCountry;
	}
}
