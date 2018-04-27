package model;

import java.sql.Date;

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
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Dog_ID")
	private int dogId;
	@Column(name="Owner_ID")
	private int ownerId;
	@Column(name="Age")
	private int age;
	@Column(name="Todays_Playground")	//new code 4-23
	private int playgroundId;
	@Column(name="Name")
	private String name;
	@Column(name="Breed")
	private String breed;
	@Column(name="Gender")
	private String gender;
	@Column(name="Age")
	private int age;
	@Column(name="Registration_Date", columnDefinition="DATE DEFAULT CURRENT_DATE")
	private Date registrationDate;
	@Column(name="Vaccinations", nullable=false, columnDefinition="BOOLEAN")
	private Boolean vaccinations = true;
	@Column(name="Last_Visit")
	private Date lastVisit;
	@Column(name="Active_Flag", nullable=false, columnDefinition="BOOLEAN")
	private Boolean activeFlag = true;
	@Column(name="Todays_Playground")
	private int todaysPlayground;
	@Column(name="Todays_Classes")
	private int todaysClasses;
	
	@ManyToOne
	private Owner owner;
	
	public Dog(int ownerId, int age, int playgroundId, String name, String breed, String gender, Date registrationDate, boolean vaccinations,
			Date lastVisit, boolean activeFlag) {
		super();
		this.ownerId = ownerId;
		this.age = age;
		this.playgroundId = playgroundId;
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.registrationDate = registrationDate;
		this.vaccinations = vaccinations;
		this.lastVisit = lastVisit;
		this.activeFlag = activeFlag;
		this.todaysPlayground = todaysPlayground;
		this.todaysClasses = todaysClasses;
	}
	
	public Dog() {
		super();
	}
	
	public Dog(String name) {
		this.name = name;
	}
	
	public Dog(int dogId, String name) {
		super();
		this.dogId = dogId;
		this.name = name;
	}
	
	public int getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPlaygroundId() {
		return playgroundId;
	}

	public void setPlaygroundId(int playgroundId) {
		this.playgroundId = playgroundId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	public int getTodaysPlayground() {
		return todaysPlayground;
	}

	public void setTodaysPlayground(int todaysPlayground) {
		this.todaysPlayground = todaysPlayground;
	}

	public int getTodaysClasses() {
		return todaysClasses;
	}

	public void setTodaysClasses(int todaysClasses) {
		this.todaysClasses = todaysClasses;
	}

	public java.sql.Date convertJavaToSqlDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeFlag == null) ? 0 : activeFlag.hashCode());
		result = prime * result + age;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + dogId;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastVisit == null) ? 0 : lastVisit.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ownerId;
		result = prime * result + playgroundId;
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + todaysClasses;
		result = prime * result + todaysPlayground;
		result = prime * result + ((vaccinations == null) ? 0 : vaccinations.hashCode());
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
		if (activeFlag == null) {
			if (other.activeFlag != null)
				return false;
		} else if (!activeFlag.equals(other.activeFlag))
			return false;
		if (age != other.age)
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
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (ownerId != other.ownerId)
			return false;
		if (playgroundId != other.playgroundId)
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (todaysClasses != other.todaysClasses)
			return false;
		if (todaysPlayground != other.todaysPlayground)
			return false;
		if (vaccinations == null) {
			if (other.vaccinations != null)
				return false;
		} else if (!vaccinations.equals(other.vaccinations))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dog [dogId=" + dogId + ", ownerId=" + ownerId + ", age=" + age + ", playgroundId=" + playgroundId
				+ ", name=" + name + ", breed=" + breed + ", gender=" + gender + ", registrationDate="
				+ registrationDate + ", vaccinations=" + vaccinations + ", lastVisit=" + lastVisit + ", activeFlag="
				+ activeFlag + ", owner=" + owner + "]";

	}

}
