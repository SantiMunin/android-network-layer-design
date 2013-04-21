package es.udc.smunin.android_callbacks.views;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import es.udc.smunin.android_callbacks.R;
import es.udc.smunin.android_callbacks.model.OperationsManager;
import es.udc.smunin.android_callbacks.model.callbacks.OperationCallback;
import es.udc.smunin.android_callbacks.model.value_objects.Class;

/**
 * 
 * @author Santiago Mun’n Gonz‡lez <santimunin@gmail.com>
 * 
 */
public class TestActivity extends Activity {

	private final static String TAG = "TestActivity";

	/**
	 * Activity initialization.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		((Button) findViewById(R.id.login))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						String user = ((TextView) findViewById(R.id.user))
								.getText().toString();
						String password = ((TextView) findViewById(R.id.password))
								.getText().toString();
						OperationsManager.getInstance().login(user, password,
								new LoginCallback());
					}
				});
		((Button) findViewById(R.id.classes))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						String classText = ((TextView) findViewById(R.id.class_text))
								.getText().toString();
						OperationsManager.getInstance().getClasses(classText,
								new ClassListCallback());
					}
				});

	}

	/**
	 * Topbar initialization.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

	/**
	 * Defines the login callback.
	 * 
	 * @author Santiago Mun’n Gonz‡lez<santimunin@gmail.com>
	 * 
	 */
	private class LoginCallback implements OperationCallback<Boolean> {
		@Override
		public void onSuccess(Boolean result) {
			String message = result ? "TRUE!" : "FALSE!";
			Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT)
					.show();
		}

		@Override
		public void onFailure() {
			Toast.makeText(getApplicationContext(), "Connection problems? :(",
					Toast.LENGTH_SHORT).show();
		}
	}

	private class ClassListCallback implements OperationCallback<List<Class>> {
		/**
		 * Actions to take if there was a problem with the network.
		 */
		@Override
		public void onFailure() {
			Toast.makeText(getApplicationContext(), "Connection problems? :(",
					Toast.LENGTH_SHORT).show();

		}

		/**
		 * Actions to take after obtaining a list of classes.
		 */
		@Override
		public void onSuccess(List<Class> list) {
			if (list.size() == 0) {
				Toast.makeText(getApplicationContext(), "Empty list :|",
						Toast.LENGTH_SHORT).show();
			} else {
				for (Class class1 : list) {
					Log.d(TAG, class1.toString());
				}
				Toast.makeText(getApplicationContext(),
						"List printed! See your logcat", Toast.LENGTH_SHORT)
						.show();
			}

		}
	}

}
