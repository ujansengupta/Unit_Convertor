package com.example.unitconvertor;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Pressure extends Activity implements OnCheckedChangeListener {
	RadioGroup L1, L2;
	TextView TV;
	EditText ET;
	double x;
	String s1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pressure);

		L1 = (RadioGroup) findViewById(R.id.RGP1);
		L1.setOnCheckedChangeListener((OnCheckedChangeListener) this);

		L2 = (RadioGroup) findViewById(R.id.RGP2);
		L2.setOnCheckedChangeListener((OnCheckedChangeListener) this);

		TV = (TextView) findViewById(R.id.TVP1);
		ET = (EditText) findViewById(R.id.ETP1);

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

		case R.id.bar1:

			Calc(0, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.psi1:

			Calc(1, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.pft1:

			Calc(2, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.at1:

			Calc(3, GetID(L2.getCheckedRadioButtonId()));

			break;

		case R.id.inHg1:

			Calc(4, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.cmHg1:

			Calc(5, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.kgsm1:

			Calc(6, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.pa1:

			Calc(7, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.inAq1:

			Calc(8, GetID(L2.getCheckedRadioButtonId()));

			break;

		// ------------------- FROM ^
		// TO \/---------------------------------------

		case R.id.bar2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 0);
			break;

		case R.id.psi2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 1);
			break;

		case R.id.pft2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 2);

			break;
		case R.id.at2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 3);

			break;
		case R.id.inHg2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 4);

			break;
		case R.id.cmHg2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 5);

			break;
		case R.id.kgsm2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 6);

			break;
		case R.id.pa2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 7);

			break;
		case R.id.inAq2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 8);

			break;

		}
	}

	private void Calc(int val1, int val2) {

		if (val1 == val2) {
			TV.setText(ET.getText().toString());
			return;
		}
		switch (val1) {
		case 0:
			x = (x / 1); // FROM Bar
			break;
		case 1:
			x = (x / 14.50377); // FROM psi
			break;
		case 2:
			x = (x / 2088.543); // FROM pft
			break;
		case 3:
			x = (x / 0.9869233); // FROM Atmosphere
			break;
		case 4:
			x = (x / 29.52998); // FROM Inches of Hg
			break;
		case 5:
			x = (x / 75.00617); // FROM Centimeters of Hg
			break;
		case 6:
			x = (x / 10197.16); // FROM Kg/m2
			break;
		case 7:
			x = (x / 100000); // FROM Pascals
			break;
		case 8:
			x = (x / 401.4629); // FROM Inches of Water
			break;
		default:
			TV.setText("Select Initial Unit");
			return;
		}

		switch (val2) {
		case 0:
			x = (x / 1); // TO Bar
			break;
		case 1:
			x = (x * 14.50377); // TO psi
			break;
		case 2:
			x = (x * 2088.543); // TO pft
			break;
		case 3:
			x = (x * 0.9869233); // To Atmosphere
			break;
		case 4:
			x = (x * 29.52998); // TO Inches of Hg
			break;
		case 5:
			x = (x * 75.00617); // TO Centimeters of Hg
			break;
		case 6:
			x = (x * 10197.16); // TO Kg/m2
			break;
		case 7:
			x = (x * 100000); // TO Pascals
			break;
		case 8:
			x = (x * 401.4629); // TO Inches of Water
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
		case R.id.bar1:
			return 0;
		case R.id.psi1:
			return 1;
		case R.id.pft1:
			return 2;
		case R.id.at1:
			return 3;
		case R.id.inHg1:
			return 4;
		case R.id.cmHg1:
			return 5;
		case R.id.kgsm1:
			return 6;
		case R.id.pa1:
			return 7;
		case R.id.inAq1:
			return 8;
		
			// -----------FROM ^ TO \/----------------

		case R.id.bar2:
			return 0;
		case R.id.psi2:
			return 1;
		case R.id.pft2:
			return 2;
		case R.id.at2:
			return 3;
		case R.id.inHg2:
			return 4;
		case R.id.cmHg2:
			return 5;
		case R.id.kgsm2:
			return 6;
		case R.id.pa2:
			return 7;
		case R.id.inAq2:
			return 8;
		default:
			return -1;
		}
	}

}
