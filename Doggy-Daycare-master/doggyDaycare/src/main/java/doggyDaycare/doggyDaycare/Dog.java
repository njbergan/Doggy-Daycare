package doggyDaycare.doggyDaycare;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dog")
public class Dog {
	
//	private long dogId;
//	private long ownerId;
//	private String name;
//	private String breed;
//	private String gender;
//	private Date registrationDate;
//	private int vaccinations;
//	private Date lastVisit;
//	private int activeFlag;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Dog_ID")
	private int dogId;
	@Column(name="Owner_ID")
	private int ownerId;
	@Column(name="Name")
	private String name;
	@Column(name="Breed")
	private String breed;
	@Column(name="Gender")
	private String gender;
	@Column(name="Registration_Date", columnDefinition="DATE DEFAULT CURRENT_DATE")
	private Date registrationDate;
	@Column(name="Vaccinated", nullable=false, columnDefinition="BOOLEAN")
	private Boolean vaccinations = true;
	@Column(name="Last_Visit")
	private Date lastVisit;
	@Column(name="Active_Flag", nullable=false, columnDefinition="BOOLEAN")
	private Boolean activeFlag = true;
	
	@ManyToOne
	private Owner owner;
	
	public Dog(int ownerId, String name, String breed, String gender, Date registrationDate, boolean vaccinations,
			Date lastVisit, boolean activeFlag) {
		super();
		this.ownerId = ownerId;
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.registrationDate = registrationDate;
		this.vaccinations = vaccinations;
		this.lastVisit = lastVisit;
		this.activeFlag = activeFlag;
	}
	
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Dog(String name) {
		this.name = name;
	}
	
	public Dog(int dogId, String name) {
		super();
		this.dogId = dogId;
		this.name = name;
	}

	public long getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public boolean getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(boolean vaccinations) {
		this.vaccinations = vaccinations;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Boolean.hashCode(activeFlag);
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + (int) (dogId ^ (dogId >>> 32));
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastVisit == null) ? 0 : lastVisit.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (ownerId ^ (ownerId >>> 32));
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + Boolean.hashCode(vaccinations);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (activeFlag != other.activeFlag)
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (dogId != other.dogId)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastVisit == null) {
			if (other.lastVisit != null)
				return false;
		} else if (!lastVisit.equals(other.lastVisit))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ownerId != other.ownerId)
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (vaccinations != other.vaccinations)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dog [dogId=" + dogId + ", ownerId=" + ownerId + ", name=" + name + ", breed=" + breed + ", gender="
				+ gender + ", registrationDate=" + registrationDate + ", vaccinations=" + vaccinations + ", lastVisit="
				+ lastVisit + ", activeFlag=" + activeFlag + "]";
	}
}
