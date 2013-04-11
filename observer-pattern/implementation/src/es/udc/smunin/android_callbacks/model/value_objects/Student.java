package es.udc.smunin.android_callbacks.model.value_objects;

/**
 * Represents a student.
 * 
 * @author Santiago Mun’n <santimunin@gmail.com>
 * 
 */
public class Student {
	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

}
