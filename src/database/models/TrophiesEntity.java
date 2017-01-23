package database.models;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name =  "\"Trophies\"", schema = "SYSTEM") public class TrophiesEntity
{
	private long idTrophy;
	private Time receivingDate;
	private String nameOfTheTrophy;
	private String issuingOrganization;
	private FootbalClubsEntity footbalClubsByIdClub;

	@Id
	@Column(name =  "\"ID_Trophy\"", nullable = false)
	public long getIdTrophy()
	{
		return idTrophy;
	}

	public void setIdTrophy(long idTrophy)
	{
		this.idTrophy = idTrophy;
	}

	@Basic
	@Column(name =  "\"Receiving date\"", nullable = false)
	public Time getReceivingDate()
	{
		return receivingDate;
	}

	public void setReceivingDate(Time receivingDate)
	{
		this.receivingDate = receivingDate;
	}

	@Basic
	@Column(name =  "\"Name of the trophy\"", nullable = false, length = 30)
	public String getNameOfTheTrophy()
	{
		return nameOfTheTrophy;
	}

	public void setNameOfTheTrophy(String nameOfTheTrophy)
	{
		this.nameOfTheTrophy = nameOfTheTrophy;
	}

	@Basic
	@Column(name =  "\"Issuing organization\"", nullable = false, length = 30)
	public String getIssuingOrganization()
	{
		return issuingOrganization;
	}

	public void setIssuingOrganization(String issuingOrganization)
	{
		this.issuingOrganization = issuingOrganization;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idTrophy ^ (idTrophy >>> 32));
		result = 31 * result + (receivingDate != null ? receivingDate.hashCode() : 0);
		result = 31 * result + (nameOfTheTrophy != null ? nameOfTheTrophy.hashCode() : 0);
		result = 31 * result + (issuingOrganization != null ? issuingOrganization.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TrophiesEntity that = (TrophiesEntity) o;

		if (idTrophy != that.idTrophy)
			return false;
		if (receivingDate != null ? !receivingDate.equals(that.receivingDate) : that.receivingDate != null)
			return false;
		if (nameOfTheTrophy != null ?
				!nameOfTheTrophy.equals(that.nameOfTheTrophy) :
				that.nameOfTheTrophy != null)
			return false;
		return issuingOrganization != null ?
				issuingOrganization.equals(that.issuingOrganization) :
				that.issuingOrganization == null;
	}

	@ManyToOne
	@JoinColumn(name =  "\"ID_Club\"", referencedColumnName =  "\"ID_Club\"")
	public FootbalClubsEntity getFootbalClubsByIdClub()
	{
		return footbalClubsByIdClub;
	}

	public void setFootbalClubsByIdClub(FootbalClubsEntity footbalClubsByIdClub)
	{
		this.footbalClubsByIdClub = footbalClubsByIdClub;
	}
}
