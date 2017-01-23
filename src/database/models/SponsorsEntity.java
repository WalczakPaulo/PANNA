package database.models;

import javax.persistence.*;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name =  "\"Sponsors\"", schema = "SYSTEM") public class SponsorsEntity
{
	private long idSponsor;
	private String name;
	private long nip;
	private long regon;
	private Long bankAccountNumber;
	private Long stockMarketValue;
	private AddressesEntity addressesByIdAddress;

	@Id
	@Column(name =  "\"ID_Sponsor\"", nullable = false)
	public long getIdSponsor()
	{
		return idSponsor;
	}

	public void setIdSponsor(long idSponsor)
	{
		this.idSponsor = idSponsor;
	}

	@Basic
	@Column(name =  "\"Name\"", nullable = false)
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Basic
	@Column(name =  "\"NIP\"", nullable = false)
	public long getNip()
	{
		return nip;
	}

	public void setNip(long nip)
	{
		this.nip = nip;
	}

	@Basic
	@Column(name =  "\"REGON\"", nullable = false)
	public long getRegon()
	{
		return regon;
	}

	public void setRegon(long regon)
	{
		this.regon = regon;
	}

	@Basic
	@Column(name =  "\"Bank account number\"")
	public Long getBankAccountNumber()
	{
		return bankAccountNumber;
	}

	public void setBankAccountNumber(Long bankAccountNumber)
	{
		this.bankAccountNumber = bankAccountNumber;
	}

	@Basic
	@Column(name =  "\"Stock market value\"")
	public Long getStockMarketValue()
	{
		return stockMarketValue;
	}

	public void setStockMarketValue(Long stockMarketValue)
	{
		this.stockMarketValue = stockMarketValue;
	}

	@Override
	public int hashCode()
	{
		int result = (int) (idSponsor ^ (idSponsor >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (int) (nip ^ (nip >>> 32));
		result = 31 * result + (int) (regon ^ (regon >>> 32));
		result = 31 * result + (bankAccountNumber != null ? bankAccountNumber.hashCode() : 0);
		result = 31 * result + (stockMarketValue != null ? stockMarketValue.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SponsorsEntity that = (SponsorsEntity) o;

		if (idSponsor != that.idSponsor)
			return false;
		if (nip != that.nip)
			return false;
		if (regon != that.regon)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (bankAccountNumber != null ?
				!bankAccountNumber.equals(that.bankAccountNumber) :
				that.bankAccountNumber != null)
			return false;
		return stockMarketValue != null ?
				stockMarketValue.equals(that.stockMarketValue) :
				that.stockMarketValue == null;
	}

	@ManyToOne
	@JoinColumn(name =  "\"ID_Address\"", referencedColumnName =  "\"ID_Address\"", nullable = false)
	public AddressesEntity getAddressesByIdAddress()
	{
		return addressesByIdAddress;
	}

	public void setAddressesByIdAddress(AddressesEntity addressesByIdAddress)
	{
		this.addressesByIdAddress = addressesByIdAddress;
	}
}
