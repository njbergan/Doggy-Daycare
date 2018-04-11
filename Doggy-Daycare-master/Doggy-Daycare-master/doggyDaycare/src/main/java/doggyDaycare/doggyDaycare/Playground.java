package doggyDaycare.doggyDaycare;

public class Playground {
	
	int playgroundId;
	String name;
	String location;

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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + playgroundId;
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
		Playground other = (Playground) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (playgroundId != other.playgroundId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Playground [playgroundId=" + playgroundId + ", name=" + name + ", location=" + location + "]";
	}
}
