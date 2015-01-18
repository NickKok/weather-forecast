package com.example.weather;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Button  mButton = (Button) findViewById(R.id.button1);
		final EditText  mEdit   = (EditText)findViewById(R.id.editText1);

		    mButton.setOnClickListener(
		        new View.OnClickListener()
		        {
		            public void onClick(View view)
		            {
		               // Log.v("EditText", mEdit.getText().toString());
		                String city= mEdit.getText().toString();
		                String temperature=new String();
		        		String country=new String();
		        		String humidity=new String();
		                ArrayList response = new ArrayList<String>();
		                try {
		        			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&mode=xml");
		        			response = new RssHandler().execute(url).get();
		
		        			    country=response.get(0).toString();
		        			    temperature=response.get(1).toString();
		        			    humidity=response.get(2).toString();
		        			   
		        			    Intent i =new Intent();
		        			    i.putExtra("city", city);
		        			    i.putExtra("country", country);
		        			    i.putExtra("temperature", temperature);
		        			    i.putExtra("humidity", humidity);
		        			    //explicit intent
		        			    i.setClassName("com.example.weather.present", "com.example.weather.present.MainActivity2");
		        			    //implicit intent
		        			    //i.setAction("com.example.weather.present.result");
		        			    startActivity(i);
		        			    
		        		} catch (InterruptedException e) {
		        			// TODO Auto-generated catch block
		        			e.printStackTrace();
		        		} catch (ExecutionException e) {
		        			// TODO Auto-generated catch block
		        			e.printStackTrace();
		        		} catch (MalformedURLException e) {
		        			// TODO Auto-generated catch block
		        			e.printStackTrace();
		        		}
		            }
		        });
		
	}
}

