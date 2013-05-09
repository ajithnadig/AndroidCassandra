package com.android.cassandra.droidbargain;

import java.util.Calendar;

import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;






public class InputActivity extends Activity {

	private User user;
	private Context context;
	private EditText usernameEditText;
	private EditText emailEditText;
	private SpinAdapter adapter;
	private Spinner mySpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);
		
		Calendar c = Calendar.getInstance();
		c.getTimeInMillis();
		
		
		System.out.println("Time in Milliseconds "+c.getTimeInMillis());



		usernameEditText = (EditText) findViewById(R.id.firstname);
		emailEditText = (EditText) findViewById(R.id.email);
		String lastName = (String) findViewById(R.id.lastname).toString();
		String age = (String) findViewById(R.id.age).toString();

		context = this.getApplicationContext();
		//custom Adapter opject: SpinAdapter
		adapter = new SpinAdapter(context,android.R.layout.simple_spinner_dropdown_item,FeedActivity().store_data);
		//Add Spinner to activity_input layout
		//<Spinner android:id="@+id/miSpinner" android:layout_width="wrap_content" android:layout_height="wrap_content"></Spinner>
		mySpinner = (Spinner) findViewById(R.id.miSpinner);
		mySpinner.setAdapter(adapter);
		
		mySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

	            @Override
	            public void onItemSelected(AdapterView<?> adapterView, View view,
	                    int position, long id) {
	                // Here you get the current item (a User object) that is selected by its position
	                StoreFactory store = adapter.getItem(position);
	                // Here you can do the action you want to...
	                //Toast.makeText(Main.this, "ID: " + user.getId() + "\nName: " + user.getName(),
	                    //Toast.LENGTH_SHORT).show();
	            }
	            @Override
	            public void onNothingSelected(AdapterView<?> adapter) {  }
	        });
		 

		Button buttonDB = (Button) findViewById(R.id.putindb);
		buttonDB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//
//				try {
//					
//					user = new User(usernameEditText.getText().toString(), emailEditText.getText().toString());
//
//					AsyncHttpClient client = new AsyncHttpClient();
//					JSONObject jsonParams = new JSONObject();
//
//					jsonParams.put(user.getAttName(), user.getName());
//					jsonParams.put(user.getAttEmail(), user.getEmail());
//					StringEntity entity = new StringEntity(jsonParams.toString());
//					System.out.println(jsonParams.toString());
//
//					client.put(context,"http://198.61.177.186:8080/virgil/data/android/users/5",entity,null,new AsyncHttpResponseHandler() {
//						@Override
//						public void onSuccess(String response) {
//							System.out.println("Success HTTP PUT");
//						}
//					});
//
//				} catch (Exception e) {
//					System.out.println("Failed HTTP PUT");
//				} 








				Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_LONG).show();



						        AsyncHttpClient client = new AsyncHttpClient();
				
						        client.get("http://198.61.177.186:8080/virgil/data/android/posts_by_location/45.49806%7C-73.57506", new AsyncHttpResponseHandler() {
						            @Override
						            public void onSuccess(String response) {
						                System.out.println(response);
						                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
						            }
						        });		        


			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.input, menu);
		return true;
	}

}
