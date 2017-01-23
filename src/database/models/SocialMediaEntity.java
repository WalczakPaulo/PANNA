package database.models;

import javax.persistence.*;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name =  "\"Social media\"", schema = "SYSTEM") public class SocialMediaEntity
{
	private long idSocialMedia;
	private String siteName;
	private long numberOfTheFollowers;
	private Long activeUsersMonthly;
	private FootbalClubsEntity footbalClubsByIdClub;
	private PlayersEntity playersByIdEmployee;

	@Id
	@Column(name =  "\"ID_SocialMedia\"", nullable = false)
	public long getIdSocialMedia()
	{
		return idSocialMedia;
	}

	public void setIdSocialMedia(long idSocialMedia)
	{
		this.idSocialMedia = idSocialMedia;
	}

	@Basic
	@Column(name =  "\"Site name\"", nullable = false, length = 30)
	public String getSiteName()
	{
		return siteName;
	}

	public void setSiteName(String siteName)
	{
		this.siteName = siteName;
	}

	@Basic
	@Column(name =  "\"Number of the followers\"", nullable = false)
	public long getNumberOfTheFollowers()
	{
		return numberOfTheFollowers;
	}

	public void setNumberOfTheFollowers(long numberOfTheFollowers)
	{
		this.numberOfTheFollowers = numberOfTheFollowers;
	}

	@Basic
	@Column(name =  "\"Active users monthly\"")
	public Long getActiveUsersMonthly()
	{
		return activeUsersMonthly;
	}

	public void setActiveUsersMonthly(Long activeUsersMonthly)
	{
		this.activeUsersMonthly = activeUsersMonthly;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idSocialMedia ^ (idSocialMedia >>> 32));
		result = 31 * result + (siteName != null ? siteName.hashCode() : 0);
		result = 31 * result + (int) (numberOfTheFollowers ^ (numberOfTheFollowers >>> 32));
		result = 31 * result + (activeUsersMonthly != null ? activeUsersMonthly.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SocialMediaEntity that = (SocialMediaEntity) o;

		if (idSocialMedia != that.idSocialMedia)
			return false;
		if (numberOfTheFollowers != that.numberOfTheFollowers)
			return false;
		if (siteName != null ? !siteName.equals(that.siteName) : that.siteName != null)
			return false;
		return activeUsersMonthly != null ?
				activeUsersMonthly.equals(that.activeUsersMonthly) :
				that.activeUsersMonthly == null;
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

	@ManyToOne
	@JoinColumn(name =  "\"ID_Employee\"", referencedColumnName =  "\"ID_Employee\"")
	public PlayersEntity getPlayersByIdEmployee()
	{
		return playersByIdEmployee;
	}

	public void setPlayersByIdEmployee(PlayersEntity playersByIdEmployee)
	{
		this.playersByIdEmployee = playersByIdEmployee;
	}
}
