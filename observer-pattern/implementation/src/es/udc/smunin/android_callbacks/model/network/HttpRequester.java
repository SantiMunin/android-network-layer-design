package es.udc.smunin.android_callbacks.model.network;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Network low-level functionality.
 * 
 * @author Santiago Mun’n Gonz‡lez <santimunin@gmail.com>
 * 
 */
public class HttpRequester extends AsyncTask<Void, String, String> {

	private static final String TAG = "HttpRequester";
	private static final int TIMEOUT = 7000;
	private static final String TIMEOUT_PARAM = "http.socket.timeout";
	private String url;
	private RequestCallback callback;
	private boolean connection_problem = false;

	/**
	 * Performs a http request and reacts to the response.
	 * 
	 * @param url
	 *            Target url.
	 * @param callback
	 *            Action to perform after the request.
	 */
	public HttpRequester(String url, RequestCallback callback) {
		this.url = url;
		this.callback = callback;

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
	private String performHttpRequest(String url) throws IOException {
		Log.i(TAG, "sent: " + url);

		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		client.getParams().setParameter(TIMEOUT_PARAM, TIMEOUT);
		HttpResponse responseGet = client.execute(get);
		HttpEntity resEntityGet = responseGet.getEntity();
		if (resEntityGet != null) {
			String response = EntityUtils.toString(resEntityGet);
			return response;
		}
		return "";
	}

	@Override
	protected String doInBackground(Void... params) {
		try {
			return this.performHttpRequest(url);
		} catch (IOException e) {
			connection_problem = true;
			return "";
		}
	}

	@Override
	protected void onPostExecute(String result) {
		if (connection_problem) {
			Log.e(TAG, "Connection problem");
			this.callback.onFailure();
		} else {
			Log.i(TAG, "Response: " + result);
			this.callback.onSuccess(result);
		}
		super.onPostExecute(result);
	}

}
