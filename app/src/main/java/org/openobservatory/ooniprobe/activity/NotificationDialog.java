package org.openobservatory.ooniprobe.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Window;

import org.openobservatory.ooniprobe.R;

public class NotificationDialog extends Activity {
	private static final String TAG = "NotificationDialog";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //hide activity title
		final String message = getIntent().getStringExtra("message");
		displayAlert(message);
	}

	private void displayAlert(String message) {
		new AlertDialog.Builder(NotificationDialog.this)
				.setTitle(getString(R.string.notifications))
				.setMessage(message)
				.setNegativeButton(getString(android.R.string.cancel), (dialog, id) -> {
					dialog.cancel();
					finish();
				})
				.setPositiveButton(getString(android.R.string.ok), (dialog, id) -> {
					Intent browserIntent = new Intent(NotificationDialog.this, BrowserActivity.class);
					browserIntent.putExtra("payload", getIntent().getStringExtra("payload"));
					startActivity(browserIntent);
					finish();
				})
				.show();
	}
}