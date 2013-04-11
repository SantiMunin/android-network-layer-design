package es.udc.smunin.android_callbacks.model.value_objects;

/**
 * Represents a class (of students).
 * 
 * @author Santiago Mun’n <santimunin@gmail.com>
 * 
 */
public class Class {
	private int id;
	private String name;
	private String teacher;
	private int hours;

	public Class(int id, String name, String teacher, int hours) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.hours = hours;
	}

	public int getId() {
		return id;
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

}
