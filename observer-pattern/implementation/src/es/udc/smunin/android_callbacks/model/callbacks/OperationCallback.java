package es.udc.smunin.android_callbacks.model.callbacks;

/**
 * This class must be extended in order to provide to the
 * {@link OperationsManager} with some actions to perform after the data
 * retrieval. This callback consists of an action if the response is
 * <code>true</code>, <code>false</code> or incorrect (network problems).
 * 
 * @author Santiago Mun’n <santimunin@gmail.com>
 * 
 */
public interface OperationCallback<T> {
	/**
	 * Actions if the response is <code>true</code>.
	 */
	public void onSuccess(T result);

	/**
	 * Actions if there was any connection problem.
	 */
	public void onFailure();

}
