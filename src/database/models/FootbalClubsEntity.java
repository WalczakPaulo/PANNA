package database.models;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name = "\"Footbal clubs\"", schema = "SYSTEM") public class FootbalClubsEntity
{
	private long idClub;
	private String clubName;
	private String nickname;
	private String coloration;
	private String siteAddress;
	private LocalDate creationDate;
	private Long nip;
	private Long regon;
	private AddressesEntity addressesByIdAddress;

	@Id
	@Column(name = "\"ID_Club\"", nullable = false)
	public long getIdClub()
	{
		return idClub;
	}

	public void setIdClub(long idClub)
	{
		this.idClub = idClub;
	}

	@Basic
	@Column(name = "\"Club Name\"", nullable = false, length = 60)
	public String getClubName()
	{
		return clubName;
	}

	public void setClubName(String clubName)
	{
		this.clubName = clubName;
	}

	@Basic
	@Column(name = "\"Nickname\"", nullable = false, length = 30)
	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	@Basic
	@Column(name = "\"Coloration\"", nullable = false, length = 30)
	public String getColoration()
	{
		return coloration;
	}

	public void setColoration(String coloration)
	{
		this.coloration = coloration;
	}

	@Basic
	@Column(name = "\"Site address\"", length = 256)
	public String getSiteAddress()
	{
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress)
	{
		this.siteAddress = siteAddress;
	}

	@Basic
	@Column(name = "\"Creation Date\"")
	public LocalDate getCreationDate()
	{
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate)
	{
		this.creationDate = creationDate;
	}

	@Basic
	@Column(name = "\"NIP\"")
	public Long getNip()
	{
		return nip;
	}

	public void setNip(Long nip)
	{
		this.nip = nip;
	}

	@Basic
	@Column(name = "\"REGON\"")
	public Long getRegon()
	{
		return regon;
	}

	public void setRegon(Long regon)
	{
		this.regon = regon;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idClub ^ (idClub >>> 32));
		result = 31 * result + (clubName != null ? clubName.hashCode() : 0);
		result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
		result = 31 * result + (coloration != null ? coloration.hashCode() : 0);
		result = 31 * result + (siteAddress != null ? siteAddress.hashCode() : 0);
		result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
		result = 31 * result + (nip != null ? nip.hashCode() : 0);
		result = 31 * result + (regon != null ? regon.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		FootbalClubsEntity that = (FootbalClubsEntity) o;

		if (idClub != that.idClub)
			return false;
		if (clubName != null ? !clubName.equals(that.clubName) : that.clubName != null)
			return false;
		if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null)
			return false;
		if (coloration != null ? !coloration.equals(that.coloration) : that.coloration != null)
			return false;
		if (siteAddress != null ? !siteAddress.equals(that.siteAddress) : that.siteAddress != null)
			return false;
		if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null)
			return false;
		if (nip != null ? !nip.equals(that.nip) : that.nip != null)
			return false;
		return regon != null ? regon.equals(that.regon) : that.regon == null;
	}

	@ManyToOne
	@JoinColumn(name = "\"ID_Address\"", referencedColumnName = "\"ID_Address\"", nullable = false)
	public AddressesEntity getAddressesByIdAddress()
	{
		return addressesByIdAddress;
	}

	public void setAddressesByIdAddress(AddressesEntity addressesByIdAddress)
	{
		this.addressesByIdAddress = addressesByIdAddress;
	}
}
