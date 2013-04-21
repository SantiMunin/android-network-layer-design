package es.udc.smunin.android_callbacks.model.network;

/**
 * Two possible actions after an asynchronous request.
 * 
 * @author Santiago Mun’n Gonz‡lez <santimunin@gmail.com>
 * 
 */
public interface RequestCallback {
	/**
	 * Action to take if the request was correctly performed.
	 * 
	 * @param response
	 *            server's response.
	 */
	public void onSuccess(String response);

	/**
	 * Action to take if the request failed.
	 */
	public void onFailure();
}
