package com.example.unitconvertor;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Homescreen extends Activity {

	ImageButton B1, B2, B3;
	AudioManager am1;
	Boolean i;
	SharedPreferences sp1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homescreen);

		sp1 = getSharedPreferences("Sound", 0);
		/*if(sp1.getBoolean("soundbool", true))
		{
			am1.setRingerMode(am1.RINGER_MODE_NORMAL);
		}
		else
		{
			am1.setRingerMode(am1.RINGER_MODE_SILENT);
		}*/
			
		
		B1 = (ImageButton) findViewById(R.id.IB1);
		B2 = (ImageButton) findViewById(R.id.IB2);
		B3 = (ImageButton) findViewById(R.id.IB3);
		am1 = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

		B1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent myIntent = new Intent(
						"com.example.unitconvertor.MAINACTIVITY");
				startActivity(myIntent);

			}
		});

		B2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent ourIntent = new Intent(
						"com.example.unitconvertor.SETTINGS");
				startActivity(ourIntent);

			}
		});

		B3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent newIntent = new Intent("com.example.unitconvertor.ABOUT");
				startActivity(newIntent);

			}
		});

	}



	/*@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		am1.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	}
*/
	
	/*
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Bundle gotBasket = getIntent().getExtras();
		i = gotBasket.getBoolean("mode");
		if (i == true) {
			am1.setRingerMode(am1.RINGER_MODE_NORMAL);
		} else
			am1.setRingerMode(am1.RINGER_MODE_SILENT);
		
	}



	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Bundle gotBasket = getIntent().getExtras();
		i = gotBasket.getBoolean("mode");
		if (i == true) {
			am1.setRingerMode(am1.RINGER_MODE_NORMAL);
		} else
			am1.setRingerMode(am1.RINGER_MODE_SILENT);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		Bundle gotBasket = getIntent().getExtras();
		i = gotBasket.getBoolean("mode");
		if (i == true) {
			am1.setRingerMode(am1.RINGER_MODE_NORMAL);
		} else
			am1.setRingerMode(am1.RINGER_MODE_SILENT);
	} */
	
}
