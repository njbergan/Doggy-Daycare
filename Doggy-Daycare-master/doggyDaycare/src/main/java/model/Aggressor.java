package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity

public class Aggressor implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AGGRESSOR_ID")
	private int aggressorId;
	@Column(name="DOG_ID")
	private int dogId;
	
	@OneToOne
	private Dog dog;
	
	@OneToMany(mappedBy="warmonger")
	@JoinColumn(name="AGGRESSOR")
	private List<Aggression> incidents = new ArrayList<Aggression>();

	
	private static final long serialVersionUID = 1L;
	
	public Aggressor(int aggressorId, int dogId) {
		super();
		this.aggressorId = aggressorId;
		this.dogId = dogId;
	}

	public Aggressor() {
		super();
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public List<Aggression> getIncidents() {
		return incidents;
	}

	public void setAggressors(List<Aggression> incidents) {
		this.incidents = incidents;
	}

	public int getAggressorId() {
		return aggressorId;
	}

	public void setAggressorId(int aggressorId) {
		this.aggressorId = aggressorId;
	}

	public int getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dog == null) ? 0 : dog.hashCode());
		result = prime * result + dogId;
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
		Aggressor other = (Aggressor) obj;
		if (dog == null) {
			if (other.dog != null)
				return false;
		} else if (!dog.equals(other.dog))
			return false;
		if (dogId != other.dogId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aggressor [dogId=" + dogId + ", dog=" + dog + "]";
	}
   
}
