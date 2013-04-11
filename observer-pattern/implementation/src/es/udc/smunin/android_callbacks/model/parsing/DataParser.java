package es.udc.smunin.android_callbacks.model.parsing;

import java.util.LinkedList;
import java.util.List;

import es.udc.smunin.android_callbacks.model.value_objects.Class;
import es.udc.smunin.android_callbacks.model.value_objects.Student;

/**
 * Provides methods to convert serialized data into java objects.
 * 
 * @author Santiago Mun’n Gonz‡lez <santimunin@gmail.com>
 * 
 */
public class DataParser {

	private static final String TAG = "DataParser";
	private static DataParser instance = new DataParser();

	private DataParser() {
	}

	public static DataParser getInstance() {
		return instance;
	}

	/**
	 * Parses a json string and returns a list of classes.
	 * 
	 * @param JSONdata
	 *            Raw classes data.
	 * @return List of classes. <code>null</code> if parsing fails.
	 */
	public List<Class> parseClasses(String JSONdata) {
		// TODO actual implementation
		List<Class> result = new LinkedList<Class>();
		result.add(new Class(1, "Algorithms", "Spiderman", 100));
		result.add(new Class(2, "Functional Programming", "Mr. T", 100));
		return result;
	}

	/**
	 * Parses a json string and returns a list of students.
	 * 
	 * @param JSONdata
	 *            Raw students data.
	 * @return List of students. <code>null</code> if parsing fails.
	 */
	public List<Student> parseStudents(String JSONdata) {
		List<Student> result = new LinkedList<Student>();
		result.add(new Student("Brogrammer #1", 9));
		result.add(new Student("Brogrammer #2", 7));
		result.add(new Student("Turing prize", 10));
		return result;
	}
}
