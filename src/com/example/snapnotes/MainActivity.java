package com.example.snapnotes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	private static final String TAG = "MainActivity";
	private EditText mContentET, mTitleET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTitleET = (EditText) findViewById(R.id.main_titleEditText);
		mContentET = (EditText) findViewById(R.id.main_contentEditText);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



	private void showToast(String msg) {
		Toast error = Toast.makeText(this, msg, Toast.LENGTH_LONG);
		error.show();
	}


	public void saveToDropbox(View view) {
		//create file
		File file = new File(getFilesDir(), mTitleET.getText().toString());
		FileOutputStream outputStream;
		try {
			outputStream = openFileOutput(mTitleET.getText().toString(), Context.MODE_PRIVATE);
			outputStream.write(mContentET.getText().toString().getBytes());
			outputStream.close();

		} catch (IOException e) {
			showToast("Error creating file");
			e.printStackTrace();
		}

		//upload file
		//UploadFile upload = new UploadFile(this, mApi, file);
		//upload.execute();

	}



}
