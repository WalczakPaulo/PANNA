package database.models;

import javax.persistence.*;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
@Entity @Table(name =  "\"Physiotherapists\"", schema = "SYSTEM") public class PhysiotherapistsEntity
{
	private String education;
	private String fieldOfMedicine;
	private String isMasseur;
	private long idEmployee;

	@Basic
	@Column(name =  "\"Education\"", nullable = false)
	public String getEducation()
	{
		return education;
	}

	public void setEducation(String education)
	{
		this.education = education;
	}

	@Basic
	@Column(name =  "\"Field of medicine\"", nullable = false)
	public String getFieldOfMedicine()
	{
		return fieldOfMedicine;
	}

	public void setFieldOfMedicine(String fieldOfMedicine)
	{
		this.fieldOfMedicine = fieldOfMedicine;
	}

	@Basic
	@Column(name =  "\"Is masseur\"", nullable = false, length = 1)
	public String getIsMasseur()
	{
		return isMasseur;
	}

	public void setIsMasseur(String isMasseur)
	{
		this.isMasseur = isMasseur;
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
		int result = education != null ? education.hashCode() : 0;
		result = 31 * result + (fieldOfMedicine != null ? fieldOfMedicine.hashCode() : 0);
		result = 31 * result + (isMasseur != null ? isMasseur.hashCode() : 0);
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

		PhysiotherapistsEntity that = (PhysiotherapistsEntity) o;

		if (idEmployee != that.idEmployee)
			return false;
		if (education != null ? !education.equals(that.education) : that.education != null)
			return false;
		if (fieldOfMedicine != null ?
				!fieldOfMedicine.equals(that.fieldOfMedicine) :
				that.fieldOfMedicine != null)
			return false;
		return isMasseur != null ? isMasseur.equals(that.isMasseur) : that.isMasseur == null;
	}
}
