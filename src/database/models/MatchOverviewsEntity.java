package database.models;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name =  "\"Match overviews\"", schema = "SYSTEM") public class MatchOverviewsEntity
{
	private long idMatchOverview;
	private Time duration;
	private long numberOfTicketsSold;
	private long viewership;
	private Long socialMediaMentions;
	private Long temperature;
	private Long rainfall;

	@Id
	@Column(name =  "\"ID_MatchOverview\"", nullable = false)
	public long getIdMatchOverview()
	{
		return idMatchOverview;
	}

	public void setIdMatchOverview(long idMatchOverview)
	{
		this.idMatchOverview = idMatchOverview;
	}

	@Basic
	@Column(name =  "\"Duration\"", nullable = false)
	public Time getDuration()
	{
		return duration;
	}

	public void setDuration(Time duration)
	{
		this.duration = duration;
	}

	@Basic
	@Column(name =  "\"Number of tickets sold\"", nullable = false)
	public long getNumberOfTicketsSold()
	{
		return numberOfTicketsSold;
	}

	public void setNumberOfTicketsSold(long numberOfTicketsSold)
	{
		this.numberOfTicketsSold = numberOfTicketsSold;
	}

	@Basic
	@Column(name =  "\"Viewership\"", nullable = false)
	public long getViewership()
	{
		return viewership;
	}

	public void setViewership(long viewership)
	{
		this.viewership = viewership;
	}

	@Basic
	@Column(name =  "\"Social media mentions\"")
	public Long getSocialMediaMentions()
	{
		return socialMediaMentions;
	}

	public void setSocialMediaMentions(Long socialMediaMentions)
	{
		this.socialMediaMentions = socialMediaMentions;
	}

	@Basic
	@Column(name =  "\"Temperature\"")
	public Long getTemperature()
	{
		return temperature;
	}

	public void setTemperature(Long temperature)
	{
		this.temperature = temperature;
	}

	@Basic
	@Column(name =  "\"Rainfall\"")
	public Long getRainfall()
	{
		return rainfall;
	}

	public void setRainfall(Long rainfall)
	{
		this.rainfall = rainfall;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idMatchOverview ^ (idMatchOverview >>> 32));
		result = 31 * result + (duration != null ? duration.hashCode() : 0);
		result = 31 * result + (int) (numberOfTicketsSold ^ (numberOfTicketsSold >>> 32));
		result = 31 * result + (int) (viewership ^ (viewership >>> 32));
		result = 31 * result + (socialMediaMentions != null ? socialMediaMentions.hashCode() : 0);
		result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
		result = 31 * result + (rainfall != null ? rainfall.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MatchOverviewsEntity that = (MatchOverviewsEntity) o;

		if (idMatchOverview != that.idMatchOverview)
			return false;
		if (numberOfTicketsSold != that.numberOfTicketsSold)
			return false;
		if (viewership != that.viewership)
			return false;
		if (duration != null ? !duration.equals(that.duration) : that.duration != null)
			return false;
		if (socialMediaMentions != null ?
				!socialMediaMentions.equals(that.socialMediaMentions) :
				that.socialMediaMentions != null)
			return false;
		if (temperature != null ? !temperature.equals(that.temperature) : that.temperature != null)
			return false;
		return rainfall != null ? rainfall.equals(that.rainfall) : that.rainfall == null;
	}
}
