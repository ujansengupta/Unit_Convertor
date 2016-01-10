package com.example.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Area extends Activity implements OnCheckedChangeListener{

	RadioGroup L1, L2;
	TextView TV;
	EditText ET;
	double x;
	String s1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.area);

		L1 = (RadioGroup) findViewById(R.id.RGA1);
		L1.setOnCheckedChangeListener((OnCheckedChangeListener) this);

		L2 = (RadioGroup) findViewById(R.id.RGA2);
		L2.setOnCheckedChangeListener(/*(OnCheckedChangeListener)*/ this);

		TV = (TextView) findViewById(R.id.TVA1);
		ET = (EditText) findViewById(R.id.ETA1);

		ET.addTextChangedListener(new TextWatcher() {

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
				if (L1.getCheckedRadioButtonId() == -1) {
					return;
				}

				else if (ET.getText().toString().equals("")) {
					TV.setText("Enter Value");
				}

				else {
					onCheckedChanged(L1, L1.getCheckedRadioButtonId());
				}
			}
		});
	}

	public void onCheckedChanged(RadioGroup arg0, int arg1) {

		String number = ET.getText().toString();
		if (number.equals("")) {
			return;
		}
		x = Double.parseDouble(number);

		switch (arg1) {

		case R.id.sqm1:

			Calc(0, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.sqkm1:

			Calc(1, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.sqf1:

			Calc(2, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.sqmi1:

			Calc(3, GetID(L2.getCheckedRadioButtonId()));

			break;

		case R.id.hec1:

			Calc(4, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.sqi1:

			Calc(5, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.acr1:

			Calc(6, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.sqy1:

			Calc(7, GetID(L2.getCheckedRadioButtonId()));

			break;

		// ------------------- FROM ^ TO
		// \/---------------------------------------

		case R.id.sqm2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 0);
			break;

		case R.id.sqkm2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 1);
			break;

		case R.id.sqf2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 2);

			break;
		case R.id.sqmi2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 3);

			break;
		case R.id.hec2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 4);

			break;
		case R.id.sqi2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 5);

			break;
		case R.id.acr2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 6);

			break;
		case R.id.sqy2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 7);

			break;
		}
	}

	private void Calc(int val1, int val2) {
	//Converting all to SQUARE METER intially	
		if(val1==val2){
			TV.setText(ET.getText().toString());
			return;
		}
		switch (val1) {
		case 0:
			x = (x * 1); // FROM Square Meter
			break;
		case 1:
			x = (x * 1e6); // FROM Square Kilometer
			break;
		case 2:
			x = (x * 0.092903); // FROM Square Foot
			break;
		case 3:
			x = (x * 2.59e6); 	// FROM Square Mile
			break;
		case 4:
			x = (x * 10000); // FROM Hectare
			break;
		case 5:
			x = (x * 0.00064516); // FROM Square Inch
			break;
		case 6:
			x = (x * 4046.86); // FROM Acre
			break;
		case 7:
			x = (x * 0.836127); // FROM Square Yard
			break;
		default:
			TV.setText("Select Initial Unit");
			return;
		}

		switch (val2) {
		case 0:
			x = (x * 1); // TO Square Meter
			break;
		case 1:
			x = (x * 1e-6); // TO Square Kilometer
			break;
		case 2:
			x = (x * 10.7639); // TO Square Foot
			break;
		case 3:
			x = (x * 3.861e-7); // TO Square Mile
			break;
		case 4:
			x = (x * 1e-4);// TO Hectare
			break;
		case 5:
			x = (x * 1550); // TO Square Inch
			break;
		case 6:
			x = (x * 0.000247105); // TO Acre
			break;
		case 7:
			x = (x * 1.19599); // TO Square Yard
			break;
		default:
			TV.setText("Select Desired Unit");
			return;
		}

		s1 = x + "";
		TV.setText(s1);
	}

	private int GetID(int arg) {
		switch (arg) {
		case R.id.sqm1:
			return 0;
		case R.id.sqkm1:
			return 1;
		case R.id.sqf1:
			return 2;
		case R.id.sqmi1:
			return 3;
		case R.id.hec1:
			return 4;
		case R.id.sqi1:
			return 5;
		case R.id.acr1:
			return 6;
		case R.id.sqy1:
			return 7;

			// -----------FROM ^ TO \/----------------

		case R.id.sqm2:
			return 0;
		case R.id.sqkm2:
			return 1;
		case R.id.sqf2:
			return 2;
		case R.id.sqmi2:
			return 3;
		case R.id.hec2:
			return 4;
		case R.id.sqi2:
			return 5;
		case R.id.acr2:
			return 6;
		case R.id.sqy2:
			return 7;
		default:
			return -1;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.area, menu);
		return true;
	}
}
