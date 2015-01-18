package com.example.weather.present;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        
        Intent intent = getIntent();
        String city = intent.getExtras().getString("city");
        String country = intent.getExtras().getString("country");
        String temperature = intent.getExtras().getString("temperature");
        String humidity = intent.getExtras().getString("humidity");
        
        Log.v("city2", city);
	    Log.v("country2", country); 
	    Log.v("temperature2", temperature); 
	    Log.v("humidity2", humidity);
	    
	    TextView ci =new TextView(this); 
	    ci=(TextView)findViewById(R.id.textView3); 
	    ci.setText(city);
	    
	    TextView co =new TextView(this); 
	    co=(TextView)findViewById(R.id.textView5); 
	    co.setText(country);
	    
	    TextView te =new TextView(this); 
	    te=(TextView)findViewById(R.id.textView7); 
	    te.setText(temperature);
	    
	    TextView hu =new TextView(this); 
	    hu=(TextView)findViewById(R.id.textView9); 
	    hu.setText(humidity);
    }
}
