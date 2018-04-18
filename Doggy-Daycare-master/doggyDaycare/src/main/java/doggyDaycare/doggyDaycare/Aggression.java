package doggyDaycare.doggyDaycare;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="aggression")

public class Aggression implements Serializable {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INCIDENT_ID")
	private int incidentId;
	@Column(name="AGGRESSOR")
	private int aggressor;
	@Column(name="VICTIM")
	private int victim;
	@Column(name="INCIDENT_DATE", columnDefinition="DATE DEFAULT CURRENT_DATE")
	private Date incidentDate;
	@Column(name="INCIDENT_DESCRIPTION")
	private String incidentDescription;
	
	@ManyToOne
	private Aggressor aggDog;
	
	@ManyToOne
	private Victim vicDog;
	
	private static final long serialVersionUID = 1L;
	
	public Aggression(int incidentId, int aggressor, int victim, Date incidentDate, 
			String incidentDescription) {
		super();
		this.incidentId = incidentId;
		this.aggressor = aggressor;
		this.victim = victim;
		this.incidentDate = incidentDate;
		this.incidentDescription = incidentDescription;		
	}

	public Aggression() {
		super();
	}

	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}

	public int getAggressor() {
		return aggressor;
	}

	public void setAggressor(int aggressor) {
		this.aggressor = aggressor;
	}

	public int getVictim() {
		return victim;
	}

	public void setVictim(int victim) {
		this.victim = victim;
	}

	public Date getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}

	public String getIncidentDescription() {
		return incidentDescription;
	}

	public void setIncidentDescription(String incidentDescription) {
		this.incidentDescription = incidentDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aggressor;
		result = prime * result + ((incidentDate == null) ? 0 : incidentDate.hashCode());
		result = prime * result + ((incidentDescription == null) ? 0 : incidentDescription.hashCode());
		result = prime * result + incidentId;
		result = prime * result + victim;
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
		Aggression other = (Aggression) obj;
		if (aggressor != other.aggressor)
			return false;
		if (incidentDate == null) {
			if (other.incidentDate != null)
				return false;
		} else if (!incidentDate.equals(other.incidentDate))
			return false;
		if (incidentDescription == null) {
			if (other.incidentDescription != null)
				return false;
		} else if (!incidentDescription.equals(other.incidentDescription))
			return false;
		if (incidentId != other.incidentId)
			return false;
		if (victim != other.victim)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aggression [incidentId=" + incidentId + ", aggressor=" + aggressor + ", victim=" + victim
				+ ", incidentDate=" + incidentDate + ", incidentDescription=" + incidentDescription + "]";
	}
   
}
