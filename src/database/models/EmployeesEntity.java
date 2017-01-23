package database.models;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name = "\"Employees\"", schema = "SYSTEM") public class EmployeesEntity
{
	private long idEmployee;
	private String name;
	private String surname;
	private Time employmentDate;
	private Long phoneNumber;
	private Long pesel;
	private Time nextVacationDate;
	private Time nextTrainingDate;
	private AddressesEntity addressesByIdAddress;
	private CountriesEntity countriesByIdCountry;

	@Id
	@Column(name = "\"ID_Employee\"", nullable = false)
	public long getIdEmployee()
	{
		return idEmployee;
	}

	public void setIdEmployee(long idEmployee)
	{
		this.idEmployee = idEmployee;
	}

	@Basic
	@Column(name = "\"Name\"", nullable = false, length = 30)
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Basic
	@Column(name = "\"Surname\"", nullable = false, length = 30)
	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	@Basic
	@Column(name = "\"Employment date\"", nullable = false)
	public Time getEmploymentDate()
	{
		return employmentDate;
	}

	public void setEmploymentDate(Time employmentDate)
	{
		this.employmentDate = employmentDate;
	}

	@Basic
	@Column(name = "\"Phone number\"")
	public Long getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	@Basic
	@Column(name = "\"PESEL\"")
	public Long getPesel()
	{
		return pesel;
	}

	public void setPesel(Long pesel)
	{
		this.pesel = pesel;
	}

	@Basic
	@Column(name = "\"Next vacation date\"")
	public Time getNextVacationDate()
	{
		return nextVacationDate;
	}

	public void setNextVacationDate(Time nextVacationDate)
	{
		this.nextVacationDate = nextVacationDate;
	}

	@Basic
	@Column(name = "\"Next training date\"")
	public Time getNextTrainingDate()
	{
		return nextTrainingDate;
	}

	public void setNextTrainingDate(Time nextTrainingDate)
	{
		this.nextTrainingDate = nextTrainingDate;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idEmployee ^ (idEmployee >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (surname != null ? surname.hashCode() : 0);
		result = 31 * result + (employmentDate != null ? employmentDate.hashCode() : 0);
		result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
		result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
		result = 31 * result + (nextVacationDate != null ? nextVacationDate.hashCode() : 0);
		result = 31 * result + (nextTrainingDate != null ? nextTrainingDate.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		EmployeesEntity that = (EmployeesEntity) o;

		if (idEmployee != that.idEmployee)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (surname != null ? !surname.equals(that.surname) : that.surname != null)
			return false;
		if (employmentDate != null ?
				!employmentDate.equals(that.employmentDate) :
				that.employmentDate != null)
			return false;
		if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null)
			return false;
		if (pesel != null ? !pesel.equals(that.pesel) : that.pesel != null)
			return false;
		if (nextVacationDate != null ?
				!nextVacationDate.equals(that.nextVacationDate) :
				that.nextVacationDate != null)
			return false;
		return nextTrainingDate != null ?
				nextTrainingDate.equals(that.nextTrainingDate) :
				that.nextTrainingDate == null;
	}

	@ManyToOne
	@JoinColumn(name = "\"ID_Address\"", referencedColumnName = "\"ID_Address\"")
	public AddressesEntity getAddressesByIdAddress()
	{
		return addressesByIdAddress;
	}

	public void setAddressesByIdAddress(AddressesEntity addressesByIdAddress)
	{
		this.addressesByIdAddress = addressesByIdAddress;
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
