package es.udc.smunin.android_callbacks.model.value_objects;

/**
 * Represents a class (of students).
 * 
 * @author Santiago Mun’n <santimunin@gmail.com>
 * 
 */
public class Class {
	private String name;
	private String teacher;
	private int hours;

	public Class (String name, String teacher, int hours) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.hours = hours;
	}


	public String getName() {
		return name;
	}

	public String getTeacher() {
		return teacher;
	}

	public int getHours() {
		return hours;
	}

	@Override
	public String toString() {
		return name;
	}

}
