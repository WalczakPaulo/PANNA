package database.models;

import javax.persistence.*;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name =  "\"Players\"", schema = "SYSTEM") public class PlayersEntity
{
	private long playerNumber;
	private long height;
	private Long accuracy;
	private Long velocity;
	private Long stamina;
	private String isInjured;
	private String isCaptain;
	private Long marketValue;
	private long idEmployee;

	@Basic
	@Column(name =  "\"Player_Number\"", nullable = false)
	public long getPlayerNumber()
	{
		return playerNumber;
	}

	public void setPlayerNumber(long playerNumber)
	{
		this.playerNumber = playerNumber;
	}

	@Basic
	@Column(name =  "\"Height\"", nullable = false)
	public long getHeight()
	{
		return height;
	}

	public void setHeight(long height)
	{
		this.height = height;
	}

	@Basic
	@Column(name =  "\"Accuracy\"")
	public Long getAccuracy()
	{
		return accuracy;
	}

	public void setAccuracy(Long accuracy)
	{
		this.accuracy = accuracy;
	}

	@Basic
	@Column(name =  "\"Velocity\"")
	public Long getVelocity()
	{
		return velocity;
	}

	public void setVelocity(Long velocity)
	{
		this.velocity = velocity;
	}

	@Basic
	@Column(name =  "\"Stamina\"")
	public Long getStamina()
	{
		return stamina;
	}

	public void setStamina(Long stamina)
	{
		this.stamina = stamina;
	}

	@Basic
	@Column(name =  "\"Is injured\"", length = 1)
	public String getIsInjured()
	{
		return isInjured;
	}

	public void setIsInjured(String isInjured)
	{
		this.isInjured = isInjured;
	}

	@Basic
	@Column(name =  "\"Is captain\"", length = 1)
	public String getIsCaptain()
	{
		return isCaptain;
	}

	public void setIsCaptain(String isCaptain)
	{
		this.isCaptain = isCaptain;
	}

	@Basic
	@Column(name =  "\"Market value\"")
	public Long getMarketValue()
	{
		return marketValue;
	}

	public void setMarketValue(Long marketValue)
	{
		this.marketValue = marketValue;
	}

	@Id
	@Column(name =  "\"ID_Employee\"", nullable = false)
	public long getIdEmployee()
	{
		return idEmployee;
	}

	public void setIdEmployee(long idEmployee)
	{
		this.idEmployee = idEmployee;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (playerNumber ^ (playerNumber >>> 32));
		result = 31 * result + (int) (height ^ (height >>> 32));
		result = 31 * result + (accuracy != null ? accuracy.hashCode() : 0);
		result = 31 * result + (velocity != null ? velocity.hashCode() : 0);
		result = 31 * result + (stamina != null ? stamina.hashCode() : 0);
		result = 31 * result + (isInjured != null ? isInjured.hashCode() : 0);
		result = 31 * result + (isCaptain != null ? isCaptain.hashCode() : 0);
		result = 31 * result + (marketValue != null ? marketValue.hashCode() : 0);
		result = 31 * result + (int) (idEmployee ^ (idEmployee >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PlayersEntity that = (PlayersEntity) o;

		if (playerNumber != that.playerNumber)
			return false;
		if (height != that.height)
			return false;
		if (idEmployee != that.idEmployee)
			return false;
		if (accuracy != null ? !accuracy.equals(that.accuracy) : that.accuracy != null)
			return false;
		if (velocity != null ? !velocity.equals(that.velocity) : that.velocity != null)
			return false;
		if (stamina != null ? !stamina.equals(that.stamina) : that.stamina != null)
			return false;
		if (isInjured != null ? !isInjured.equals(that.isInjured) : that.isInjured != null)
			return false;
		if (isCaptain != null ? !isCaptain.equals(that.isCaptain) : that.isCaptain != null)
			return false;
		return marketValue != null ? marketValue.equals(that.marketValue) : that.marketValue == null;
	}
}
