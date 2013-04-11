package es.udc.smunin.android_callbacks.model.network;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * Network low-level functionality. Singleton class.
 * 
 * @author Santiago Mun’n Gonz‡lez <santimunin@gmail.com>
 * 
 */
public class HttpRequester {

	private static HttpRequester instance = new HttpRequester();
	private static final String TAG = "HttpRequester";

	/**
	 * Private constructor to implement the Singleton pattern.
	 */
	private HttpRequester() {
	}

	/**
	 * 
	 * @return single instance of this class.
	 */
	public static HttpRequester getInstance() {
		return instance;
	}

	/**
	 * Performs a http request.
	 * 
	 * @param url
	 *            Target.
	 * @return Server's response.
	 * @throws IOException
	 *             If there was any problem performing the request.
	 */
	public String performHttpRequest(String url) throws IOException {
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
