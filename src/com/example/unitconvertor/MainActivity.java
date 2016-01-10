package com.example.unitconvertor;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.app.TabActivity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

import android.widget.TabWidget;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tabHost = getTabHost();

		// Tab for Length
		TabSpec Mon = tabHost.newTabSpec("Length");
		// setting Title and Icon for the Tab
		Mon.setIndicator("Length",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent MonIntent = new Intent(this, Length.class);
		Mon.setContent(MonIntent);

		// Tab for Mass
		TabSpec Tue = tabHost.newTabSpec("Mass");
		Tue.setIndicator("Mass",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent TueIntent = new Intent(this, Mass.class);
		Tue.setContent(TueIntent);

		// Tab for Temperature
		TabSpec Wed = tabHost.newTabSpec("Temperature");
		Wed.setIndicator("Temperature",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent WedIntent = new Intent(this, Temperature.class);
		Wed.setContent(WedIntent);

		// Tab for Pressure
		TabSpec Thu = tabHost.newTabSpec("Pressure");
		Thu.setIndicator("Pressure",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent ThuIntent = new Intent(this, Pressure.class);
		Thu.setContent(ThuIntent);

		// Tab for Speed
		TabSpec Fri = tabHost.newTabSpec("Speed");
		Fri.setIndicator("Speed",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent FriIntent = new Intent(this, Speed.class);
		Fri.setContent(FriIntent);

		// Tab for Area
		TabSpec Area = tabHost.newTabSpec("Area");
		Area.setIndicator("Area",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent AreaIntent = new Intent(this, Area.class);
		Area.setContent(AreaIntent);

		// Tab for Volume
		TabSpec Volume = tabHost.newTabSpec("Volume");
		Volume.setIndicator("Volume",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent VolumeIntent = new Intent(this, Volume.class);
		Volume.setContent(VolumeIntent);

	// Tab for Currency
		TabSpec Currency = tabHost.newTabSpec("Currency");
		Currency.setIndicator("Currency",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent CurrencyIntent = new Intent(this, Currency.class);
		Currency.setContent(CurrencyIntent); 
		

		// Adding all TabSpec to TabHost
		tabHost.addTab(Mon); // Adding Length tab
		tabHost.addTab(Tue); // Adding Mass tab
		tabHost.addTab(Wed); // Adding Temperature tab
		tabHost.addTab(Thu);// Adding Pressure Tab
		tabHost.addTab(Fri);// Adding Speed Tab
		tabHost.addTab(Area);// Adding Area Tab
		tabHost.addTab(Volume);// Adding Volume Tab
		tabHost.addTab(Currency);// Adding Currency Tab
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;

	}

	
}
