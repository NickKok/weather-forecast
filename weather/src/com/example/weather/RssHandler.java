package com.example.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.AsyncTask;

public class RssHandler extends AsyncTask<URL, Void, ArrayList<String>> {

	@Override
	protected ArrayList<String> doInBackground(URL... urls) {
		String response = new String();
		String temperature=new String();
		String country=new String();
		String humidity=new String();
		String text=new String();
		text=null;
		ArrayList ret = new ArrayList<String>();
		try {
			XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
			XmlPullParser myparser = xmlFactoryObject.newPullParser();
			HttpURLConnection mConnection = (HttpURLConnection) urls[0].openConnection();
			InputStream mStream = mConnection.getInputStream();
			myparser.setInput(mStream, null);
			int event = myparser.getEventType();
			while (event != XmlPullParser.END_DOCUMENT) 
			{
				 String name=myparser.getName();
		            switch (event){
		               case XmlPullParser.START_TAG:
		               break;
		               case XmlPullParser.TEXT:
		               text = myparser.getText();
		               break;

		               case XmlPullParser.END_TAG:
		                  if(name.equals("country")){
		                     country = text;
		                  }
		                  else if(name.equals("humidity")){ 	
		                     humidity = myparser.getAttributeValue(null,"value");
		                  }
		                  
		                  else if(name.equals("temperature")){
		                     temperature = myparser.getAttributeValue(null,"value");
		                  }
		                  else{
		                  }
		                  break;
		                  }		 
		                  event = myparser.next(); 

			   }		 
			   					
		
			
			ret.add(country);
			ret.add(temperature);
			ret.add(humidity);
			
		
				
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

}