package es.udc.smunin.androidnaive.network;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * Provides basic networks calls.
 * 
 */
public class NetworkOperationsManager {
	private static final String TAG = "NetworkLayer";
	private static final String GOOGLE_URL = "http://www.google.com";

	/**
	 * Gets Google's index.
	 * 
	 * @return A string (html format) with the page source.
	 * @throws IOException
	 *             If there was any problem performing the request.
	 */
	public static String getGooglePage() throws IOException {
		return performHttpRequest(GOOGLE_URL);
	}

	/**
	 * Performs a HTTP request.
	 * 
	 * @param url
	 *            Target.
	 * @return Server's response.
	 * @throws IOException
	 *             If there was any problem performing the request.
	 */
	private static String performHttpRequest(String url) throws IOException {
		Log.i(TAG, "sent: " + url);

		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		HttpResponse responseGet = client.execute(get);
		HttpEntity resEntityGet = responseGet.getEntity();
		if (resEntityGet != null) {
			String response = EntityUtils.toString(resEntityGet);
			Log.i("TAG", "response: " + response);
			return response;
		}
		return "";
	}
}
