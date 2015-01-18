package com.example.weather;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class WeatherPresent extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather_present);
		
		Intent intent = getIntent();
        String city = intent.getExtras().getString("city");
        String country = intent.getExtras().getString("country");
        String temperature = intent.getExtras().getString("temperature");
        String humidity = intent.getExtras().getString("humidity");
        
        Log.v("city2", city);
	    Log.v("country2", country); 
	    Log.v("temperature2", temperature); 
	    Log.v("humidity2", humidity);
	    
	    ListView listView = (ListView) findViewById(R.id.list);
	    ArrayList items = new ArrayList<String>();
	    
	    items.add("City: "+city);
	    items.add("Country: "+country);
	    items.add("Temperature: "+temperature);
	    items.add("Humidity: "+humidity);
	    
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
	    listView.setAdapter(adapter);
	    
	}
}
