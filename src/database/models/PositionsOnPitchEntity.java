package database.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Antoni Rozanski on 25.01.2017.
 */
@Entity @Table(name = "\"Positions on pitch\"", schema = "SYSTEM") public class PositionsOnPitchEntity
{
	private long idPosition;
	private String positionName;
	private Collection<PlayersEntity> playerssByIdPosition;

	@Id
	@Column(name = "\"ID_Position\"", nullable = false, precision = 0)
	public long getIdPosition()
	{
		return idPosition;
	}

	public void setIdPosition(long idPosition)
	{
		this.idPosition = idPosition;
	}

	@Basic
	@Column(name = "\"Position name\"", nullable = false, length = 30)
	public String getPositionName()
	{
		return positionName;
	}

	public void setPositionName(String positionName)
	{
		this.positionName = positionName;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PositionsOnPitchEntity that = (PositionsOnPitchEntity) o;

		if (idPosition != that.idPosition)
			return false;
		if (positionName != null ? !positionName.equals(that.positionName) : that.positionName != null)
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idPosition ^ (idPosition >>> 32));
		result = 31 * result + (positionName != null ? positionName.hashCode() : 0);
		return result;
	}

}
