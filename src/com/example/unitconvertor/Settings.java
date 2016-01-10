package com.example.unitconvertor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Settings extends Activity {

	ImageButton IBSound, IBEmail;
	TextView TVSound, TVEmail;
	Boolean i;
	public static String filename = "Sound";
	SharedPreferences someData;
	AudioManager am;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

		someData = getSharedPreferences(filename, 0);

		IBSound = (ImageButton) findViewById(R.id.IBSound1);
		IBEmail = (ImageButton) findViewById(R.id.IBEmail1);
		TVSound = (TextView) findViewById(R.id.tvSound1);
		TVEmail = (TextView) findViewById(R.id.tvEmail1);

		i = someData.getBoolean("soundbool", true);

		if (i == false) {
			IBSound.setImageResource(R.drawable.mute);
			i = false;
			TVSound.setText("Sound : Off");
		} else {
			IBSound.setImageResource(R.drawable.sound);
			i = true;
			TVSound.setText("Sound : On");
		}

		IBSound.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				someData = getSharedPreferences(filename, 0);

				if (i) {
					IBSound.setImageResource(R.drawable.mute);
					i = false;
					TVSound.setText("Sound : Off");
					am.setRingerMode(am.RINGER_MODE_SILENT);
					/*
					 * Bundle basket = new Bundle(); basket.putBoolean("mode",
					 * i); Intent a = new Intent(Settings.this,
					 * Homescreen.class); a.putExtras(basket);
					 */
				} else {
					IBSound.setImageResource(R.drawable.sound);
					i = true;
					TVSound.setText("Sound : On");
					am.setRingerMode(am.RINGER_MODE_NORMAL);
					/*
					 * Bundle basket = new Bundle(); basket.putBoolean("mode",
					 * i); Intent a = new Intent(Settings.this,
					 * Homescreen.class); a.putExtras(basket);
					 */
				}

				SharedPreferences.Editor editor = someData.edit();
				editor.putBoolean("soundbool", i);
				editor.commit();

			}
		});

		IBEmail.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String emailaddress[] = { "ujansengupta@yahoo.co.in", "anas_dps@yahoo.co.in","ashwin.93@live.com" };

				Intent emailIntent = new Intent(
						android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
						emailaddress);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Review of Unit Convertor");
				emailIntent.setType("plain/text");
				startActivity(emailIntent);

			}
		});

		TVEmail.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String emailaddress[] = { "ujansengupta@yahoo.co.in", "anas_dps@yahoo.co.in" };

				Intent emailIntent = new Intent(
						android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
						emailaddress);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Review of Unit Convertor");
				emailIntent.setType("plain/text");
				startActivity(emailIntent);

			}
		});
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

}
