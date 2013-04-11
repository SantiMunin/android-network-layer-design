package es.udc.smunin.android_callbacks.model;

import java.util.List;

import android.content.Context;
import android.widget.Toast;

/**
 * This class must be extended in order to provide to the
 * {@link OperationsManager} with some actions to perform after the data
 * retrieval.
 * 
 * @author Santiago Mun’n <santimunin@gmail.com>
 * 
 * @param <T>
 */
public abstract class ListCallback<T> extends Context {
	/**
	 * Action to take in case that the request returns a list of T objects.
	 * 
	 * @param Application
	 *            context.
	 * @param list
	 *            of T objects.
	 * 
	 */
	public abstract void onSuccess(Context context, List<T> list);

	/**
	 * Action to take when the request retuns an empty list.
	 * 
	 * By default, it shows a toast.
	 * 
	 * @param Application
	 *            context.
	 */
	public void onSuccessEmpty(Context context) {
		Toast.makeText(this, "Empty list :(", Toast.LENGTH_SHORT).show();
	}

	/**
	 * Action to take when the request fails.
	 * 
	 * @param Application
	 *            context.
	 */
	public void onFailure(Context context) {
		Toast.makeText(this, "CONNECTION PROBLEM", Toast.LENGTH_SHORT).show();
	}

}
