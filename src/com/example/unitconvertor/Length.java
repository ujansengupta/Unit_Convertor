package com.example.unitconvertor;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.*;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Length extends Activity implements OnCheckedChangeListener {

	RadioGroup L1, L2;
	TextView TV;
	EditText ET;
	double x;
	String s1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.length);

		L1 = (RadioGroup) findViewById(R.id.RG1);
		L1.setOnCheckedChangeListener((OnCheckedChangeListener) this);

		L2 = (RadioGroup) findViewById(R.id.RG2);
		L2.setOnCheckedChangeListener(/*(OnCheckedChangeListener)*/ this);

		TV = (TextView) findViewById(R.id.TV1);
		ET = (EditText) findViewById(R.id.ET1);

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

		case R.id.cm1:

			Calc(0, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.mm1:

			Calc(1, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.km1:

			Calc(2, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.m1:

			Calc(3, GetID(L2.getCheckedRadioButtonId()));

			break;

		case R.id.mile1:

			Calc(4, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.yard1:

			Calc(5, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.foot1:

			Calc(6, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.inch1:

			Calc(7, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.Nmile1:

			Calc(8, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.ly1:

			Calc(9, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.au1:

			Calc(10, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.ang1:

			Calc(11, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.mic1:

			Calc(12, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.par1:

			Calc(13, GetID(L2.getCheckedRadioButtonId()));

			break;
			

		// ------------------- FROM ^ TO
		// \/---------------------------------------

		case R.id.cm2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 0);
			break;

		case R.id.mm2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 1);
			break;

		case R.id.km2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 2);

			break;
		case R.id.m2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 3);

			break;
		case R.id.mile2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 4);

			break;
		case R.id.yard2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 5);

			break;
		case R.id.foot2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 6);

			break;
		case R.id.inch2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 7);

			break;
		case R.id.Nmile2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 8);

			break;
		case R.id.ly2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 9);

			break;
		case R.id.au2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 10);

			break;
		case R.id.ang2:

			Calc(GetID(L1.getCheckedRadioButtonId()),11);

			break;
		case R.id.mic2:

			Calc(GetID(L1.getCheckedRadioButtonId()),12);

			break;
		case R.id.par2:

			Calc(GetID(L1.getCheckedRadioButtonId()),13);

			break;
		}
	}

	private void Calc(int val1, int val2) {
		
		if(val1==val2){
			TV.setText(ET.getText().toString());
			return;
		}
		switch (val1) {
		case 0:
			x = (x * 0.01); // FROM Centimeter
			break;
		case 1:
			x = (x * 0.001); // FROM Millimeter
			break;
		case 2:
			x = (x * 1000); // FROM Kilometer
			break;
		case 3:
			x = (x / 1); 	// FROM Meter
			break;
		case 4:
			x = (x * 1609.34); // FROM Mile
			break;
		case 5:
			x = (x * 0.9144); // FROM Yard
			break;
		case 6:
			x = (x * 0.3048); // FROM Foot
			break;
		case 7:
			x = (x * 0.0254); // FROM Inch
			break;
		case 8:
			x = (x * 1852); // FROM Nautical Mile
			break;
		case 9:
			x = (x * 9.46073e15); // FROM Light Year
			break;
		case 10:
			x = (x * 1.495979e11); // FROM Astronomical Unit
			break;
		case 11:
			x = (x * 1e-10); // FROM Angstrom
			break;
		case 12:
			x = (x * 1e-6); // FROM Micron
			break;
		case 13:
			x = (x * 3.085e16); // FROM Parsec
			break;
		default:
			TV.setText("Select Initial Unit");
			return;
		}

		switch (val2) {
		case 0:
			x = (x * 100); // TO Centimeter
			break;
		case 1:
			x = (x * 1000); // TO Millimeter
			break;
		case 2:
			x = (x * 0.001); // TO Kilometer
			break;
		case 3:
			x = (x * 1); // TO Meter
			break;
		case 4:
			x = (x * 6.213712e-4);// TO Mile
			break;
		case 5:
			x = (x * 1.093613); // TO Yard
			break;
		case 6:
			x = (x * 3.28084); // TO Foot
			break;
		case 7:
			x = (x * 39.37008); // TO Inch
			break;
		case 8:
			x = (x * 5.399568e-4); // TO Nautical Mile
			break;
		case 9:
			x = (x * 1.057001e-16); // TO Light Year
			break;
		case 10:
			x = (x * 6.684587e-12); // TO Astronomical Unit
			break;
		case 11:
			x = (x * 1e10); // TO Angstrom
			break;
		case 12:
			x = (x * 1e6); // TO Micron
			break;
		case 13:
			x = (x * 3.241491e-17); // TO Parsec
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
		case R.id.cm1:
			return 0;
		case R.id.mm1:
			return 1;
		case R.id.km1:
			return 2;
		case R.id.m1:
			return 3;
		case R.id.mile1:
			return 4;
		case R.id.yard1:
			return 5;
		case R.id.foot1:
			return 6;
		case R.id.inch1:
			return 7;
		case R.id.Nmile1:
			return 8;
		case R.id.ly1:
			return 9;
		case R.id.au1:
			return 10;
		case R.id.ang1:
			return 11;
		case R.id.mic1:
			return 12;
		case R.id.par1:
			return 13;

			// -----------FROM ^ TO \/----------------

		case R.id.cm2:
			return 0;
		case R.id.mm2:
			return 1;
		case R.id.km2:
			return 2;
		case R.id.m2:
			return 3;
		case R.id.mile2:
			return 4;
		case R.id.yard2:
			return 5;
		case R.id.foot2:
			return 6;
		case R.id.inch2:
			return 7;
		case R.id.Nmile2:
			return 8;
		case R.id.ly2:
			return 9;
		case R.id.au2:
			return 10;
		case R.id.ang2:
			return 11;
		case R.id.mic2:
			return 12;
		case R.id.par2:
			return 13;
		default:
			return -1;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.length, menu);
		return true;
	}

}
