package database.models;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name =  "\"Player participation\"", schema = "SYSTEM") public class PlayerParticipationEntity
{
	private long idParticipation;
	private long goals;
	private long assists;
	private Long numberOfPasses;
	private Time timeSpentOnPitch;
	private Long mark;
	private String injury;
	private Long numbersOfCardsReceived;
	private Long distanceCovered;
	private MatchesEntity matchesByIdMatch;

	@Id
	@Column(name =  "\"ID_Participation\"", nullable = false)
	public long getIdParticipation()
	{
		return idParticipation;
	}

	public void setIdParticipation(long idParticipation)
	{
		this.idParticipation = idParticipation;
	}

	@Basic
	@Column(name =  "\"Goals\"", nullable = false)
	public long getGoals()
	{
		return goals;
	}

	public void setGoals(long goals)
	{
		this.goals = goals;
	}

	@Basic
	@Column(name =  "\"Assists\"", nullable = false)
	public long getAssists()
	{
		return assists;
	}

	public void setAssists(long assists)
	{
		this.assists = assists;
	}

	@Basic
	@Column(name =  "\"Number of passes\"")
	public Long getNumberOfPasses()
	{
		return numberOfPasses;
	}

	public void setNumberOfPasses(Long numberOfPasses)
	{
		this.numberOfPasses = numberOfPasses;
	}

	@Basic
	@Column(name =  "\"Time spent on pitch\"", nullable = false)
	public Time getTimeSpentOnPitch()
	{
		return timeSpentOnPitch;
	}

	public void setTimeSpentOnPitch(Time timeSpentOnPitch)
	{
		this.timeSpentOnPitch = timeSpentOnPitch;
	}

	@Basic
	@Column(name =  "\"Mark\"")
	public Long getMark()
	{
		return mark;
	}

	public void setMark(Long mark)
	{
		this.mark = mark;
	}

	@Basic
	@Column(name =  "\"Injury\"", length = 1)
	public String getInjury()
	{
		return injury;
	}

	public void setInjury(String injury)
	{
		this.injury = injury;
	}

	@Basic
	@Column(name =  "\"Numbers of cards received\"")
	public Long getNumbersOfCardsReceived()
	{
		return numbersOfCardsReceived;
	}

	public void setNumbersOfCardsReceived(Long numbersOfCardsReceived)
	{
		this.numbersOfCardsReceived = numbersOfCardsReceived;
	}

	@Basic
	@Column(name =  "\"Distance covered\"")
	public Long getDistanceCovered()
	{
		return distanceCovered;
	}

	public void setDistanceCovered(Long distanceCovered)
	{
		this.distanceCovered = distanceCovered;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idParticipation ^ (idParticipation >>> 32));
		result = 31 * result + (int) (goals ^ (goals >>> 32));
		result = 31 * result + (int) (assists ^ (assists >>> 32));
		result = 31 * result + (numberOfPasses != null ? numberOfPasses.hashCode() : 0);
		result = 31 * result + (timeSpentOnPitch != null ? timeSpentOnPitch.hashCode() : 0);
		result = 31 * result + (mark != null ? mark.hashCode() : 0);
		result = 31 * result + (injury != null ? injury.hashCode() : 0);
		result = 31 * result + (numbersOfCardsReceived != null ? numbersOfCardsReceived.hashCode() : 0);
		result = 31 * result + (distanceCovered != null ? distanceCovered.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PlayerParticipationEntity that = (PlayerParticipationEntity) o;

		if (idParticipation != that.idParticipation)
			return false;
		if (goals != that.goals)
			return false;
		if (assists != that.assists)
			return false;
		if (numberOfPasses != null ?
				!numberOfPasses.equals(that.numberOfPasses) :
				that.numberOfPasses != null)
			return false;
		if (timeSpentOnPitch != null ?
				!timeSpentOnPitch.equals(that.timeSpentOnPitch) :
				that.timeSpentOnPitch != null)
			return false;
		if (mark != null ? !mark.equals(that.mark) : that.mark != null)
			return false;
		if (injury != null ? !injury.equals(that.injury) : that.injury != null)
			return false;
		if (numbersOfCardsReceived != null ?
				!numbersOfCardsReceived.equals(that.numbersOfCardsReceived) :
				that.numbersOfCardsReceived != null)
			return false;
		return distanceCovered != null ?
				distanceCovered.equals(that.distanceCovered) :
				that.distanceCovered == null;
	}

	@ManyToOne
	@JoinColumn(name =  "\"ID_Match\"", referencedColumnName =  "\"ID_Match\"", nullable = false)
	public MatchesEntity getMatchesByIdMatch()
	{
		return matchesByIdMatch;
	}

	public void setMatchesByIdMatch(MatchesEntity matchesByIdMatch)
	{
		this.matchesByIdMatch = matchesByIdMatch;
	}
}
