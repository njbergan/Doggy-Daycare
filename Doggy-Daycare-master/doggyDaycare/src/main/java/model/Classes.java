package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="classes")

public class Classes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Class_Id")
	private int classId;
	@Column(name="Class_Name")
	private String className;
	@Column(name="Class_Description")
	private String classDescription;
	
	public Classes() {
		super();
	}
	
	public Classes(int classId, String className, String classDescription) {
		super();
		this.classId = classId;
		this.className = className;
		this.classDescription = classDescription;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classDescription == null) ? 0 : classDescription.hashCode());
		result = prime * result + classId;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
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
		Classes other = (Classes) obj;
		if (classDescription == null) {
			if (other.classDescription != null)
				return false;
		} else if (!classDescription.equals(other.classDescription))
			return false;
		if (classId != other.classId)
			return false;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + ", classDescription=" + classDescription
				+ "]";
	}

}
