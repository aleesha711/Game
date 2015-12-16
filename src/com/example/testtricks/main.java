package com.example.testtricks;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class main extends Activity implements OnClickListener {
	CheckBox checkBox;
	EditText editText;
	Button button;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		checkBox = (CheckBox) findViewById(R.id.checkBox1);
		editText = (EditText) findViewById(R.id.editText1);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
		loadSavedPreferences();
	}
	private void loadSavedPreferences() {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		boolean cbValue = sp.getBoolean("CHECKBOX", false);
		String name = sp.getString("NAME", "Enter your name");
		if (cbValue) {
			checkBox.setChecked(true);
		} else {
			checkBox.setChecked(false);
		}

		editText.setText(name);
	}

	private void savePreferences(String key, boolean value) {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	private void savePreferences(String key, String value) {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putString(key, value);
		edit.commit();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		savePreferences("CHECKBOX", checkBox.isChecked());
		if (checkBox.isChecked())
			savePreferences("NAME", editText.getText().toString());

		finish();
	}

}

