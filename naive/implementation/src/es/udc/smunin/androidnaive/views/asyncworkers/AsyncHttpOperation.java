package es.udc.smunin.androidnaive.views.asyncworkers;

import java.io.IOException;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import es.udc.smunin.androidnaive.network.NetworkOperationsManager;

/**
 * Performs a http request in background and then updates the UI.
 * 
 */
public class AsyncHttpOperation extends AsyncTask<String, Void, String> {
	private static final String TAG = "AsyncHttpOperation";
	private boolean request_error = false;
	private Context context;

	/**
	 * Creates an instance from the application context.
	 * 
	 * @param context
	 *            Application context.
	 */
	public AsyncHttpOperation(Context context) {
		this.context = context;
	}

	/**
	 * This operation will be done in background (http request).
	 */
	@Override
	protected String doInBackground(String... params) {
		try {
			return NetworkOperationsManager.getGooglePage();
		} catch (IOException e) {
			request_error = true;
			return "";
		}
	}

	/**
	 * After the request, shows a toast with the result of the operation.
	 */
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if (request_error) {
			Toast.makeText(context, "FAIL", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(context, "WORKS (see logcat)", Toast.LENGTH_SHORT)
					.show();
			Log.i(TAG, "it worked! -> " + result);
		}
	}
}
