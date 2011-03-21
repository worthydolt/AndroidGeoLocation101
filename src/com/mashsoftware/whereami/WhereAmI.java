package com.mashsoftware.whereami;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class WhereAmI extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		LocationManager locationManager;
		String context = Context.LOCATION_SERVICE;
		locationManager = (LocationManager) getSystemService(context);

		String provider = LocationManager.GPS_PROVIDER;
		Location location = locationManager.getLastKnownLocation(provider);
		updateWithNewLocation(location);
	}

	private void updateWithNewLocation(Location location) {
		StringBuilder latlongString;
		TextView myLocationText;
		myLocationText = (TextView) findViewById(R.id.myLocationText);
		latlongString = new StringBuilder();
		if (location != null) {
			double lat = location.getLatitude();
			double lng = location.getLongitude();
			latlongString.append("Lat:").append(lat).append("\nLong:")
					.append(lng);
		} else {
			latlongString.append("No location found");
		}
		myLocationText.setText(latlongString.toString());
	}
}