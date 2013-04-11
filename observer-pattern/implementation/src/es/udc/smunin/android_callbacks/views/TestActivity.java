package es.udc.smunin.android_callbacks.views;

import es.udc.smunin.android_callbacks.R;
import es.udc.smunin.android_callbacks.R.layout;
import es.udc.smunin.android_callbacks.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

}
