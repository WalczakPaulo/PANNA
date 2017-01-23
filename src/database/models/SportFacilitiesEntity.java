package database.models;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name =  "\"Sport facilities\"", schema = "SYSTEM") public class SportFacilitiesEntity
{
	private long idFacility;
	private String facilityName;
	private long numberOfSeats;
	private String roofPresence;
	private long reflectorsBrightness;
	private Long constructionCost;
	private Time creationDate;
	private Time nextInspectionDate;
	private AddressesEntity addressesByIdAddress;
	private FootbalClubsEntity footbalClubsByIdClub;

	@Id
	@Column(name =  "\"ID_Facility\"", nullable = false)
	public long getIdFacility()
	{
		return idFacility;
	}

	public void setIdFacility(long idFacility)
	{
		this.idFacility = idFacility;
	}

	@Basic
	@Column(name =  "\"Facility name\"", nullable = false, length = 60)
	public String getFacilityName()
	{
		return facilityName;
	}

	public void setFacilityName(String facilityName)
	{
		this.facilityName = facilityName;
	}

	@Basic
	@Column(name =  "\"Number of seats\"", nullable = false)
	public long getNumberOfSeats()
	{
		return numberOfSeats;
	}

	public void setNumberOfSeats(long numberOfSeats)
	{
		this.numberOfSeats = numberOfSeats;
	}

	@Basic
	@Column(name =  "\"Roof presence\"", nullable = false, length = 1)
	public String getRoofPresence()
	{
		return roofPresence;
	}

	public void setRoofPresence(String roofPresence)
	{
		this.roofPresence = roofPresence;
	}

	@Basic
	@Column(name =  "\"Reflectors brightness\"", nullable = false)
	public long getReflectorsBrightness()
	{
		return reflectorsBrightness;
	}

	public void setReflectorsBrightness(long reflectorsBrightness)
	{
		this.reflectorsBrightness = reflectorsBrightness;
	}

	@Basic
	@Column(name =  "\"Construction cost\"")
	public Long getConstructionCost()
	{
		return constructionCost;
	}

	public void setConstructionCost(Long constructionCost)
	{
		this.constructionCost = constructionCost;
	}

	@Basic
	@Column(name =  "\"Creation date\"")
	public Time getCreationDate()
	{
		return creationDate;
	}

	public void setCreationDate(Time creationDate)
	{
		this.creationDate = creationDate;
	}

	@Basic
	@Column(name =  "\"Next inspection date\"")
	public Time getNextInspectionDate()
	{
		return nextInspectionDate;
	}

	public void setNextInspectionDate(Time nextInspectionDate)
	{
		this.nextInspectionDate = nextInspectionDate;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idFacility ^ (idFacility >>> 32));
		result = 31 * result + (facilityName != null ? facilityName.hashCode() : 0);
		result = 31 * result + (int) (numberOfSeats ^ (numberOfSeats >>> 32));
		result = 31 * result + (roofPresence != null ? roofPresence.hashCode() : 0);
		result = 31 * result + (int) (reflectorsBrightness ^ (reflectorsBrightness >>> 32));
		result = 31 * result + (constructionCost != null ? constructionCost.hashCode() : 0);
		result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
		result = 31 * result + (nextInspectionDate != null ? nextInspectionDate.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SportFacilitiesEntity that = (SportFacilitiesEntity) o;

		if (idFacility != that.idFacility)
			return false;
		if (numberOfSeats != that.numberOfSeats)
			return false;
		if (reflectorsBrightness != that.reflectorsBrightness)
			return false;
		if (facilityName != null ? !facilityName.equals(that.facilityName) : that.facilityName != null)
			return false;
		if (roofPresence != null ? !roofPresence.equals(that.roofPresence) : that.roofPresence != null)
			return false;
		if (constructionCost != null ?
				!constructionCost.equals(that.constructionCost) :
				that.constructionCost != null)
			return false;
		if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null)
			return false;
		return nextInspectionDate != null ?
				nextInspectionDate.equals(that.nextInspectionDate) :
				that.nextInspectionDate == null;
	}

	@ManyToOne
	@JoinColumn(name =  "\"ID_Address\"", referencedColumnName =  "\"ID_Address\"", nullable = false)
	public AddressesEntity getAddressesByIdAddress()
	{
		return addressesByIdAddress;
	}

	public void setAddressesByIdAddress(AddressesEntity addressesByIdAddress)
	{
		this.addressesByIdAddress = addressesByIdAddress;
	}

	@ManyToOne
	@JoinColumn(name =  "\"ID_Club\"", referencedColumnName =  "\"ID_Club\"", nullable = false)
	public FootbalClubsEntity getFootbalClubsByIdClub()
	{
		return footbalClubsByIdClub;
	}

	public void setFootbalClubsByIdClub(FootbalClubsEntity footbalClubsByIdClub)
	{
		this.footbalClubsByIdClub = footbalClubsByIdClub;
	}
}
