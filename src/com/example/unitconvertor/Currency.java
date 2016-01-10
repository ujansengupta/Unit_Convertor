package com.example.unitconvertor;

import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Currency extends Activity implements OnCheckedChangeListener {

	TextView TV1,Copy;
	EditText ET1, ETName, ETValue;
	public static String file = "Currency";
	SharedPreferences sCount, s0, s1, s2, s3, s4, s5, sUSD, sGBP, sEUR;
	RadioButton RB10, RB11, RB12, RB13, RB14, RB15, RB20, RB21, RB22, RB23,
			RB24, RB25;
	Button B1, BEdit, BDel;
	String str2, str1, str3,xyz;
	static String copy1,copy2;
	double x;
	SharedPreferences.Editor editor;
	int counter = 0,copy;
	RadioGroup RGC1, RGC2;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.currency);
		initialise();

		/*
		 * TV1.setVisibility(View.VISIBLE); TV1.setText(counter + "");
		 */
		showRadio();

		RGC1.setOnCheckedChangeListener((OnCheckedChangeListener) this);
		RGC2.setOnCheckedChangeListener((OnCheckedChangeListener) this);

		ET1.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				// TV.setText(ET.getText().toString());
				if (RGC1.getCheckedRadioButtonId() == -1) {
					return;
				}

				else if (ET1.getText().toString().equals("")) {
					TV1.setText("Enter Value");
				}

				else {
					onCheckedChanged(RGC1, RGC1.getCheckedRadioButtonId());
				}
			}
		});

		B1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				str1 = ETName.getText().toString();
				str2 = ETValue.getText().toString();

				if (!str1.equals("") && !str2.equals("")) {

					editor = sCount.edit();
					editor.putInt("Counter", (counter + 1));
					editor.commit();

					counter = sCount.getInt("Counter", 0);

					try {

						switch (counter) {

						case 1:

							editor = s0.edit();
							editor.putString("Name1", str1);
							editor.putFloat("Value1", Float.parseFloat(str2));
							editor.commit();
							break;
						case 2:

							editor = s1.edit();
							editor.putString("Name2", str1);
							editor.putFloat("Value2", Float.parseFloat(str2));
							editor.commit();
							break;
						case 3:

							editor = s2.edit();
							editor.putString("Name3", str1);
							editor.putFloat("Value3", Float.parseFloat(str2));
							editor.commit();
							break;
						case 4:

							editor = s3.edit();
							editor.putString("Name4", str1);
							editor.putFloat("Value4", Float.parseFloat(str2));
							editor.commit();
							break;
						case 5:

							editor = s4.edit();
							editor.putString("Name5", str1);
							editor.putFloat("Value5", Float.parseFloat(str2));
							editor.commit();
							break;
						case 6:

							editor = s5.edit();
							editor.putString("Name6", str1);
							editor.putFloat("Value6", Float.parseFloat(str2));
							editor.commit();
							break;
						}
					} catch (NumberFormatException e) {

					}
				} else if (str1.equals("all") || str1.equals("All")){
					
					Toast.makeText(getApplicationContext(),
							"Please enter a different name",
							Toast.LENGTH_LONG).show();
				}
				
				else {
					Toast.makeText(getApplicationContext(),
							"Please enter both Name and Value",
							Toast.LENGTH_LONG).show();

				}

				// TV1.setText(counter + "");

				showRadio();

				ETName.clearFocus();
				ETValue.clearFocus();
				ETName.setHint("Enter New Unit");
				ETValue.setHint("Enter Value");
			}
		});

		BEdit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				str2 = ETValue.getText().toString();

				if (!str2.equals("")) {

					String str4;

					str4 = ETName.getText().toString();
					
					if (str4.equals("Dollar") || str4.equals("dollar")) {
						editor = sUSD.edit();
						editor.putFloat("ValueUSD", Float.parseFloat(str2));
						editor.commit();
					} else if (str4.equals("Pound Sterling")
							|| str4.equals("pound sterling")) {
						editor = sGBP.edit();
						editor.putFloat("ValueGBP", Float.parseFloat(str2));
						editor.commit();
					} else if (str4.equals("Euro") || str4.equals("euro")) {
						editor = sEUR.edit();
						editor.putFloat("ValueEUR", Float.parseFloat(str2));
						editor.commit();
					} else if (str4.equals(s0.getString("Name1", null))
							&& !str4.equals(null)) {
						editor = s0.edit();
						editor.putFloat("Value1", Float.parseFloat(str2));
						editor.commit();
					} else if (str4.equals(s1.getString("Name2", null))
							&& !str4.equals(null)) {
						editor = s1.edit();
						editor.putFloat("Value2", Float.parseFloat(str2));
						editor.commit();
					} else if (str4.equals(s2.getString("Name3", null))
							&& !str4.equals(null)) {
						editor = s2.edit();
						editor.putFloat("Value3", Float.parseFloat(str2));
						editor.commit();
					} else if (str4.equals(s3.getString("Name4", null))
							&& !str4.equals(null)) {
						editor = s3.edit();
						editor.putFloat("Value4", Float.parseFloat(str2));
						editor.commit();
					} else if (str4.equals(s4.getString("Name5", null))
							&& !str4.equals(null)) {
						editor = s4.edit();
						editor.putFloat("Value5", Float.parseFloat(str2));
						editor.commit();
					} else if (str4.equals(s5.getString("Name6", null))
							&& !str4.equals(null)) {
						editor = s5.edit();
						editor.putFloat("Value6", Float.parseFloat(str2));
						editor.commit();
					} else {
						Toast.makeText(getApplicationContext(),
								"Unit doesn't exist", Toast.LENGTH_LONG).show();
					}

				} else {
					Toast.makeText(getApplicationContext(),
							"Please enter a value", Toast.LENGTH_LONG).show();
				}

				ETName.clearFocus();
				ETValue.clearFocus();

				ETName.setHint("Enter New Unit");
				ETValue.setHint("Enter Value");
			}

		});

		BDel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				str2 = ETName.getText().toString();

				if (!str2.equals("")) {

					if (str2.equals("Dollar") || str2.equals("dollar")) {
						Toast.makeText(getApplicationContext(),
								"Pre-defined units cannot be deleted",
								Toast.LENGTH_LONG).show();
					} else if (str2.equals("Pound Sterling")
							|| str2.equals("pound sterling")) {
						Toast.makeText(getApplicationContext(),
								"Pre-defined units cannot be deleted",
								Toast.LENGTH_LONG).show();
					} else if (str2.equals("Euro") || str2.equals("euro")) {
						Toast.makeText(getApplicationContext(),
								"Pre-defined units cannot be deleted",
								Toast.LENGTH_LONG).show();
					} else if (str2.equals("Rupee") || str2.equals("rupee")) {
						Toast.makeText(getApplicationContext(),
								"Pre-defined units cannot be deleted",
								Toast.LENGTH_LONG).show();
					} else if (str2.equals(s0.getString("Name1", null))
							&& !str2.equals(null)) {
						editor = s0.edit();
						editor.remove("Name1");
						editor.remove("Value1");
						editor.commit();
					} else if (str2.equals(s1.getString("Name2", null))
							&& !str2.equals(null)) {
						editor = s1.edit();
						editor.remove("Name2");
						editor.remove("Value2");
						editor.commit();
					} else if (str2.equals(s2.getString("Name3", null))
							&& !str2.equals(null)) {
						editor = s2.edit();
						editor.remove("Name3");
						editor.remove("Value3");
						editor.commit();
					} else if (str2.equals(s3.getString("Name4", null))
							&& !str2.equals(null)) {
						editor = s3.edit();
						editor.remove("Name4");
						editor.remove("Value4");
						editor.commit();
					} else if (str2.equals(s4.getString("Name5", null))
							&& !str2.equals(null)) {
						editor = s4.edit();
						editor.remove("Name5");
						editor.remove("Value5");
						editor.commit();
					} else if (str2.equals(s5.getString("Name6", null))
							&& !str2.equals(null)) {
						editor = s5.edit();
						editor.remove("Name6");
						editor.remove("Value6");
						editor.commit();
					} else if (str2.equals("All") || str2.equals("all")) {
						editor = s0.edit();
						editor.clear();
						editor.commit();
						counter = 0;
						Toast.makeText(getApplicationContext(),
								"All user-defined data deleted",
								Toast.LENGTH_LONG).show();
					} else {
						Toast.makeText(getApplicationContext(),
								"Unit doesn't exist", Toast.LENGTH_LONG).show();
					}

				}

				else {
					Toast.makeText(getApplicationContext(),
							"Unit doesn't exist", Toast.LENGTH_LONG).show();
				}

				showRadio();
				ETName.clearFocus();
				ETValue.clearFocus();

				ETName.setHint("Enter New Unit");
				ETValue.setHint("Enter Value");
			}
		});
		
		Copy.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				xyz = TV1.getText().toString();
				
				ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 
				 ClipData clip = ClipData.newPlainText("Converted!", ET1.getText() + " " + copy1 + " " + "=" + " " + xyz + " " + copy2 );
				 clipboard.setPrimaryClip(clip);
				 
				 Toast.makeText(getApplicationContext(),
							"Items copied to clipboard",
							Toast.LENGTH_LONG).show();
				
				
			}
		});

	}

	private void showRadio() {
		// TODO Auto-generated method stub

		RB10.setVisibility(View.INVISIBLE);
		RB20.setVisibility(View.INVISIBLE);
		RB11.setVisibility(View.INVISIBLE);
		RB21.setVisibility(View.INVISIBLE);
		RB12.setVisibility(View.INVISIBLE);
		RB22.setVisibility(View.INVISIBLE);
		RB13.setVisibility(View.INVISIBLE);
		RB23.setVisibility(View.INVISIBLE);
		RB14.setVisibility(View.INVISIBLE);
		RB24.setVisibility(View.INVISIBLE);
		RB15.setVisibility(View.INVISIBLE);
		RB25.setVisibility(View.INVISIBLE);

		counter = sCount.getInt("Counter", 0);

		if (counter > 6) {
			Toast.makeText(getApplicationContext(),
					"Sorry! Unit list is full. Please delete some units",
					Toast.LENGTH_LONG).show();
			ETName.setHint("Sorry! Unit list full.");
			ETValue.setHint("Sorry! Unit list full.");
			/*
			 * counter = 0; editor = sCount.edit(); editor.putInt("Counter", 0);
			 * editor.commit();
			 */
		}

		RB15.setText(s5.getString("Name6", null));
		RB25.setText(s5.getString("Name6", null));

		if (s5.getString("Name6", null) != null) {
			RB15.setVisibility(View.VISIBLE);
			RB25.setVisibility(View.VISIBLE);
		}

		RB14.setText(s4.getString("Name5", null));
		RB24.setText(s4.getString("Name5", null));

		if (s4.getString("Name5", null) != null) {
			RB14.setVisibility(View.VISIBLE);
			RB24.setVisibility(View.VISIBLE);
		}

		RB13.setText(s3.getString("Name4", null));
		RB23.setText(s3.getString("Name4", null));

		if (s3.getString("Name4", null) != null) {
			RB13.setVisibility(View.VISIBLE);
			RB23.setVisibility(View.VISIBLE);
		}

		RB12.setText(s2.getString("Name3", null));
		RB22.setText(s2.getString("Name3", null));

		if (s2.getString("Name3", null) != null) {
			RB12.setVisibility(View.VISIBLE);
			RB22.setVisibility(View.VISIBLE);
		}

		RB11.setText(s1.getString("Name2", null));
		RB21.setText(s1.getString("Name2", null));

		if (s1.getString("Name2", null) != null) {
			RB11.setVisibility(View.VISIBLE);
			RB21.setVisibility(View.VISIBLE);
		}

		RB10.setText(s0.getString("Name1", null));
		RB20.setText(s0.getString("Name1", null));

		if (s0.getString("Name1", null) != null) {
			RB10.setVisibility(View.VISIBLE);
			RB20.setVisibility(View.VISIBLE);
		}

	}

	private void initialise() {
		// TODO Auto-generated method stub

		sCount = getSharedPreferences(file, 0);

		s0 = getSharedPreferences(file, 0);
		s1 = getSharedPreferences(file, 0);
		s2 = getSharedPreferences(file, 0);
		s3 = getSharedPreferences(file, 0);
		s4 = getSharedPreferences(file, 0);
		s5 = getSharedPreferences(file, 0);
		sUSD = getSharedPreferences(file, 0);
		sGBP = getSharedPreferences(file, 0);
		sEUR = getSharedPreferences(file, 0);

		RGC1 = (RadioGroup) findViewById(R.id.RGCustom1);
		RGC2 = (RadioGroup) findViewById(R.id.RGCustom2);
		B1 = (Button) findViewById(R.id.ButtonCustom1);
		BEdit = (Button) findViewById(R.id.bEdit);
		BDel = (Button) findViewById(R.id.bDelete);
		TV1 = (TextView) findViewById(R.id.TVCustom1);
		Copy = (TextView) findViewById(R.id.CopyConvertor);
		ET1 = (EditText) findViewById(R.id.ETCustom1);
		ETName = (EditText) findViewById(R.id.ETCustom2);
		ETValue = (EditText) findViewById(R.id.ETCustom3);
		counter = sCount.getInt("Counter", 0);

		// RadioButtons

		RB10 = (RadioButton) findViewById(R.id.custom10);
		RB11 = (RadioButton) findViewById(R.id.custom11);
		RB12 = (RadioButton) findViewById(R.id.custom12);
		RB13 = (RadioButton) findViewById(R.id.custom13);
		RB14 = (RadioButton) findViewById(R.id.custom14);
		RB15 = (RadioButton) findViewById(R.id.custom15);
		RB20 = (RadioButton) findViewById(R.id.custom20);
		RB21 = (RadioButton) findViewById(R.id.custom21);
		RB22 = (RadioButton) findViewById(R.id.custom22);
		RB23 = (RadioButton) findViewById(R.id.custom23);
		RB24 = (RadioButton) findViewById(R.id.custom24);
		RB25 = (RadioButton) findViewById(R.id.custom25);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.currency, menu);
		return true;
				
	}

	
	

	@Override
	public void onCheckedChanged(RadioGroup arg0, int checkedId) {
		// TODO Auto-generated method stub

		String number = ET1.getText().toString();
		if (number.equals("")) {
			return;
		}
		x = Double.parseDouble(number);

		switch (checkedId) {
		case R.id.dollar1:
			Calc(0, GetId(RGC2.getCheckedRadioButtonId()));
			copy1 = "Dollars";
			break;
		case R.id.pound1:
			Calc(1, GetId(RGC2.getCheckedRadioButtonId()));
			copy1 = "Pounds";
			break;
		case R.id.euro1:
			Calc(2, GetId(RGC2.getCheckedRadioButtonId()));
			copy1 = "Euros";
			break;
		case R.id.rupee1:
			Calc(3, GetId(RGC2.getCheckedRadioButtonId()));
			copy1 = "Rupees";
			break;
		case R.id.custom10:
			Calc(4, GetId(RGC2.getCheckedRadioButtonId()));
			copy1 = RB10.getText().toString();
			break;
		case R.id.custom11:
			Calc(5, GetId(RGC2.getCheckedRadioButtonId()));
			copy1 = RB11.getText().toString();
			break;
		case R.id.custom12:
			Calc(6, GetId(RGC2.getCheckedRadioButtonId()));
			copy1 = RB12.getText().toString();
			break;
		case R.id.custom13:
			Calc(7, GetId(RGC2.getCheckedRadioButtonId()));
			copy1 = RB13.getText().toString();
			break;
		case R.id.custom14:
			Calc(8, GetId(RGC2.getCheckedRadioButtonId()));
			copy1 = RB14.getText().toString();
			break;
		case R.id.custom15:
			Calc(9, GetId(RGC2.getCheckedRadioButtonId()));
			copy1 = RB15.getText().toString();
			break;
		// ------------------- FROM ^ TO
		// \/---------------------------------------
		case R.id.dollar2:
			Calc(GetId(RGC1.getCheckedRadioButtonId()), 0);
			copy2 = "Dollars";
			break;
		case R.id.pound2:
			Calc(GetId(RGC1.getCheckedRadioButtonId()), 1);
			copy2 = "Pounds";
			break;
		case R.id.euro2:
			Calc(GetId(RGC1.getCheckedRadioButtonId()), 2);
			copy2 = "Euros";
			break;
		case R.id.rupee2:
			Calc(GetId(RGC1.getCheckedRadioButtonId()), 3);
			copy2 = "Rupees";
			break;
		case R.id.custom20:
			Calc(GetId(RGC1.getCheckedRadioButtonId()), 4);
			copy2 = RB20.getText().toString();
			break;
		case R.id.custom21:
			Calc(GetId(RGC1.getCheckedRadioButtonId()), 5);
			copy2 = RB21.getText().toString();
			break;
		case R.id.custom22:
			Calc(GetId(RGC1.getCheckedRadioButtonId()), 6);
			copy2 = RB22.getText().toString();
			break;
		case R.id.custom23:
			Calc(GetId(RGC1.getCheckedRadioButtonId()), 7);
			copy2 = RB23.getText().toString();
			break;
		case R.id.custom24:
			Calc(GetId(RGC1.getCheckedRadioButtonId()), 8);
			copy2 = RB24.getText().toString();
			break;
		case R.id.custom25:
			Calc(GetId(RGC1.getCheckedRadioButtonId()), 9);
			copy2 = RB25.getText().toString();
			break;

		}
	}

	private void Calc(int val1, int val2) {

		if (val1 == val2) {
			TV1.setText(ET1.getText().toString());
			return;
		}
		switch (val1) {
		case 0:
			x = x * sUSD.getFloat("ValueUSD", (float) 54.35);
			break;
		case 1:
			x = x * sGBP.getFloat("ValueGBP", (float) 83.31);
			break;
		case 2:
			x = x * sEUR.getFloat("ValueEUR", (float) 70.98);
			break;
		case 3:
			x = x * 1;
			break;
		case 4:
			x = x * s0.getFloat("Value1", 0);
			break;
		case 5:
			x = x * s1.getFloat("Value2", 0);
			break;
		case 6:
			x = x * s2.getFloat("Value3", 0);
			break;
		case 7:
			x = x * s3.getFloat("Value4", 0);
			break;
		case 8:
			x = x * s4.getFloat("Value5", 0);
			break;
		case 9:
			x = x * s5.getFloat("Value6", 0);
			break;
		default:
			TV1.setText("Select Initial Unit");
			return;

		}
		switch (val2) {
		case 0:
			x = x / sUSD.getFloat("ValueUSD", (float) 54.35);
			break;
		case 1:
			x = x / sGBP.getFloat("ValueGBP", (float) 83.31);
			break;
		case 2:
			x = x / sEUR.getFloat("ValueEUR", (float) 70.98);
			break;
		case 3:
			x = x / 1;
			break;
		case 4:
			x = x / s0.getFloat("Value1", 0);
			break;
		case 5:
			x = x / s1.getFloat("Value2", 0);
			break;
		case 6:
			x = x / s2.getFloat("Value3", 0);
			break;
		case 7:
			x = x / s3.getFloat("Value4", 0);
			break;
		case 8:
			x = x / s4.getFloat("Value5", 0);
			break;
		case 9:
			x = x / s5.getFloat("Value6", 0);
			break;
		default:
			TV1.setText("Select Desired Unit");
			return;
		}
		str3 = x + "";
		TV1.setText(str3);
	}

	private int GetId(int arg) {
		switch (arg) {
		case R.id.dollar1:
			return 0;
		case R.id.pound1:
			return 1;
		case R.id.euro1:
			return 2;
		case R.id.rupee1:
			return 3;
		case R.id.custom10:
			return 4;
		case R.id.custom11:
			return 5;
		case R.id.custom12:
			return 6;
		case R.id.custom13:
			return 7;
		case R.id.custom14:
			return 8;
		case R.id.custom15:
			return 9;

			// -----------FROM ^ TO \/----------------

		case R.id.dollar2:
			return 0;
		case R.id.pound2:
			return 1;
		case R.id.euro2:
			return 2;
		case R.id.rupee2:
			return 3;
		case R.id.custom20:
			return 4;
		case R.id.custom21:
			return 5;
		case R.id.custom22:
			return 6;
		case R.id.custom23:
			return 7;
		case R.id.custom24:
			return 8;
		case R.id.custom25:
			return 9;
		default:
			return -1;
		}
	}


}
