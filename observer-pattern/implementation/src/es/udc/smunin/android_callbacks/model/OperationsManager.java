package es.udc.smunin.android_callbacks.model;

import java.util.List;

import es.udc.smunin.android_callbacks.model.callbacks.OperationCallback;
import es.udc.smunin.android_callbacks.model.network.HttpRequester;
import es.udc.smunin.android_callbacks.model.network.RequestCallback;
import es.udc.smunin.android_callbacks.model.parsing.DataParser;
import es.udc.smunin.android_callbacks.model.value_objects.Class;

/**
 * Provides the client with a facade of all the networks operations. Implements
 * Singleton.
 * 
 * @author Santiago Mun’n <santiagomunin@gmail.com>
 * 
 */
public class OperationsManager {
	private final static String BASE_URL = "http://dsi-android-server.herokuapp.com";
	private final static String LOGIN_URL = "login";
	private final static String CLASSES_URL = "classes";
	/**
	 * Single instance of the class.
	 */
	private static OperationsManager instance = new OperationsManager();

	/**
	 * Private constructor (singleton pattern).
	 */
	private OperationsManager() {
	}

	/**
	 * Returns the single instance of the class.
	 * 
	 * @return Single instance of the class.
	 */
	public static OperationsManager getInstance() {
		return instance;
	}

	/**
	 * Tries to log an user in.
	 * 
	 * @param user
	 *            Username.
	 * @param password
	 *            Password.
	 * @param callback
	 *            Action to take after the login attempt.
	 */
	public void login(String user, String password,
			final OperationCallback<Boolean> callback) {
		RequestCallback requestCallback = new RequestCallback() {

			@Override
			public void onSuccess(String response) {
				boolean loginOk = DataParser.getInstance().parseLogin(response) ? true
						: false;
				callback.onSuccess(loginOk);
			}

			@Override
			public void onFailure() {
				callback.onFailure();
			}
		};

		new HttpRequester(buildUrl(BASE_URL, LOGIN_URL, user, password),
				requestCallback).execute();
	}

	/**
	 * Gets the list of the classes which has "classText" in his name.
	 * 
	 * @param classText
	 *            Search string.
	 * @param callback
	 *            Action to take with the obtained result.
	 */
	public void getClasses(String classText,
			final OperationCallback<List<Class>> callback) {
		RequestCallback requestCallback = new RequestCallback() {

			@Override
			public void onSuccess(String response) {
				List<Class> classes = DataParser.getInstance().parseClasses(
						response);
				if (classes != null) {
					callback.onSuccess(classes);
				}
			}

			/**
			 * What happens if the connections fails?
			 */
			@Override
			public void onFailure() {
				callback.onFailure();
			}
		};

		new HttpRequester(buildUrl(BASE_URL, CLASSES_URL, classText),
				requestCallback).execute();
	}

	/**
	 * Builds a URL joining strings with a slash.
	 * 
	 * @param parts
	 * @return parts[0]/parts[1]/.../parts[n]
	 */
	private String buildUrl(String... parts) {
		if (parts.length < 0) {
			return "";
		}
		StringBuilder resultBuilder = new StringBuilder(parts[0]);
		for (int i = 1; i < parts.length; i++) {
			resultBuilder.append('/');
			resultBuilder.append(parts[i]);
		}
		return resultBuilder.toString();
	}
}
