package database.models;

import javax.persistence.*;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name =  "\"Match types\"", schema = "SYSTEM") public class MatchTypesEntity
{
	private long idMatchType;
	private String matchName;

	@Id
	@Column(name =  "\"ID_MatchType\"", nullable = false)
	public long getIdMatchType()
	{
		return idMatchType;
	}

	public void setIdMatchType(long idMatchType)
	{
		this.idMatchType = idMatchType;
	}

	@Basic
	@Column(name =  "\"Match name\"", nullable = false, length = 60)
	public String getMatchName()
	{
		return matchName;
	}

	public void setMatchName(String matchName)
	{
		this.matchName = matchName;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idMatchType ^ (idMatchType >>> 32));
		result = 31 * result + (matchName != null ? matchName.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MatchTypesEntity that = (MatchTypesEntity) o;

		if (idMatchType != that.idMatchType)
			return false;
		return matchName != null ? matchName.equals(that.matchName) : that.matchName == null;
	}
}
