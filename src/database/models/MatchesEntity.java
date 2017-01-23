package database.models;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name = "\"Matches\"", schema = "SYSTEM") public class MatchesEntity
{
	private long idMatch;
	private Time date;
	private String matchType;
	private MatchOverviewsEntity matchOverviewsByIdMatchOverview;
	private MatchTypesEntity matchTypesByIdMatchType;

	@Id
	@Column(name = "\"ID_Match\"", nullable = false)
	public long getIdMatch()
	{
		return idMatch;
	}

	public void setIdMatch(long idMatch)
	{
		this.idMatch = idMatch;
	}

	@Basic
	@Column(name = "\"Date\"", nullable = false)
	public Time getDate()
	{
		return date;
	}

	public void setDate(Time date)
	{
		this.date = date;
	}

	@Basic
	@Column(name = "\"Match type\"", nullable = false, length = 30)
	public String getMatchType()
	{
		return matchType;
	}

	public void setMatchType(String matchType)
	{
		this.matchType = matchType;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idMatch ^ (idMatch >>> 32));
		result = 31 * result + (date != null ? date.hashCode() : 0);
		result = 31 * result + (matchType != null ? matchType.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MatchesEntity that = (MatchesEntity) o;

		if (idMatch != that.idMatch)
			return false;
		if (date != null ? !date.equals(that.date) : that.date != null)
			return false;
		return matchType != null ? matchType.equals(that.matchType) : that.matchType == null;
	}

	@ManyToOne
	@JoinColumn(name = "\"ID_MatchOverview\"", referencedColumnName = "\"ID_MatchOverview\"")
	public MatchOverviewsEntity getMatchOverviewsByIdMatchOverview()
	{
		return matchOverviewsByIdMatchOverview;
	}

	public void setMatchOverviewsByIdMatchOverview(MatchOverviewsEntity matchOverviewsByIdMatchOverview)
	{
		this.matchOverviewsByIdMatchOverview = matchOverviewsByIdMatchOverview;
	}

	@ManyToOne
	@JoinColumn(name = "\"ID_MatchType\"", referencedColumnName = "\"ID_MatchType\"", nullable = false)
	public MatchTypesEntity getMatchTypesByIdMatchType()
	{
		return matchTypesByIdMatchType;
	}

	public void setMatchTypesByIdMatchType(MatchTypesEntity matchTypesByIdMatchType)
	{
		this.matchTypesByIdMatchType = matchTypesByIdMatchType;
	}
}
