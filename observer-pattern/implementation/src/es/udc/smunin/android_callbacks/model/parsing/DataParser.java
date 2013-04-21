package es.udc.smunin.android_callbacks.model.parsing;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import es.udc.smunin.android_callbacks.model.value_objects.Class;

/**
 * Provides methods to convert serialized data into java objects.
 * 
 * @author Santiago Mun’n Gonz‡lez <santimunin@gmail.com>
 * 
 */
public class DataParser {

	private static final String TAG = "DataParser";
	private static DataParser instance = new DataParser();
	private final static String OK = "OK";

	private DataParser() {
	}

	public static DataParser getInstance() {
		return instance;
	}

	public boolean parseLogin(String JSONdata) {
		JSONObject data;
		String status;
		try {
			data = new JSONObject(JSONdata);
			status = data.getString("status");
		} catch (JSONException e) {
			status = "";
		}
		return status.equals(OK);
	}

	/**
	 * Parses a JSON string and returns a list of classes.
	 * 
	 * @param JSONdata
	 *            Raw classes data.
	 * @return List of classes. <code>null</code> if parsing fails.
	 */
	public List<Class> parseClasses(String JSONdata) {
		List<Class> result = new LinkedList<Class>();
		JSONObject data;
		try {
			data = new JSONObject(JSONdata);

			JSONArray classes = data.getJSONArray("classes");
			for (int i = 0; i < classes.length(); i++) {
				String name = ((JSONObject) classes.get(i)).getString("name");
				String teacher = ((JSONObject) classes.get(i))
						.getString("teacher");
				int hours = ((JSONObject) classes.get(i)).getInt("hours");
				result.add(new Class(name, teacher, hours));
			}
		} catch (JSONException e) {
			Log.e(TAG, e.toString());
		}
		return result;
	}
}
