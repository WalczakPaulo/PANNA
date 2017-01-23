package database.models;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name =  "\"Contracts\"", schema = "SYSTEM") public class ContractsEntity
{
	private long idContract;
	private String contractName;
	private long reward;
	private Time beginDate;
	private Time endDate;
	private String remarks;

	@Id
	@Column(name =  "\"ID_Contract\"", nullable = false)
	public long getIdContract()
	{
		return idContract;
	}

	public void setIdContract(long idContract)
	{
		this.idContract = idContract;
	}

	@Basic
	@Column(name =  "\"Contract Name\"", nullable = false, length = 30)
	public String getContractName()
	{
		return contractName;
	}

	public void setContractName(String contractName)
	{
		this.contractName = contractName;
	}

	@Basic
	@Column(name =  "\"Reward\"", nullable = false)
	public long getReward()
	{
		return reward;
	}

	public void setReward(long reward)
	{
		this.reward = reward;
	}

	@Basic
	@Column(name =  "\"Begin date\"", nullable = false)
	public Time getBeginDate()
	{
		return beginDate;
	}

	public void setBeginDate(Time beginDate)
	{
		this.beginDate = beginDate;
	}

	@Basic
	@Column(name =  "\"End date\"")
	public Time getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Time endDate)
	{
		this.endDate = endDate;
	}

	@Basic
	@Column(name =  "\"Remarks\"")
	public String getRemarks()
	{
		return remarks;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idContract ^ (idContract >>> 32));
		result = 31 * result + (contractName != null ? contractName.hashCode() : 0);
		result = 31 * result + (int) (reward ^ (reward >>> 32));
		result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
		result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
		result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ContractsEntity that = (ContractsEntity) o;

		if (idContract != that.idContract)
			return false;
		if (reward != that.reward)
			return false;
		if (contractName != null ? !contractName.equals(that.contractName) : that.contractName != null)
			return false;
		if (beginDate != null ? !beginDate.equals(that.beginDate) : that.beginDate != null)
			return false;
		if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null)
			return false;
		return remarks != null ? remarks.equals(that.remarks) : that.remarks == null;
	}
}
