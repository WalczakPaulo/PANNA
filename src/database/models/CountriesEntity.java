package database.models;

import javax.persistence.*;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name = "\"Countries\"", schema = "SYSTEM") public class CountriesEntity
{
	private long idCountry;
	private String fullName;
	private String shortName;

	@Id
	@Column(name = "\"ID_Country\"", nullable = false, precision = 0)
	public long getIdCountry()
	{
		return idCountry;
	}

	public void setIdCountry(long idCountry)
	{
		this.idCountry = idCountry;
	}

	@Basic
	@Column(name = "\"Full name\"", nullable = false, length = 30)
	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	@Basic
	@Column(name = "\"Short name\"", nullable = false, length = 3)
	public String getShortName()
	{
		return shortName;
	}

	public void setShortName(String shortName)
	{
		this.shortName = shortName;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idCountry ^ (idCountry >>> 32));
		result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
		result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CountriesEntity that = (CountriesEntity) o;

		if (idCountry != that.idCountry)
			return false;
		if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null)
			return false;
		return shortName != null ? shortName.equals(that.shortName) : that.shortName == null;
	}

	@Override
	public String toString()
	{
		return "CountriesEntity{" + "idCountry=" + idCountry + ", fullName='" + fullName + '\''
				+ ", shortName='" + shortName + '\'' + '}';
	}
}
