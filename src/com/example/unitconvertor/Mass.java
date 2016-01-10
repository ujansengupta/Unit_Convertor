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

public class Mass extends Activity implements OnCheckedChangeListener{
	RadioGroup L1, L2;
	TextView TV;
	EditText ET;
	double x;
	String s1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mass);

		L1 = (RadioGroup) findViewById(R.id.RGM1);
		L1.setOnCheckedChangeListener((OnCheckedChangeListener) this);

		L2 = (RadioGroup) findViewById(R.id.RGM2);
		L2.setOnCheckedChangeListener((OnCheckedChangeListener) this);

		TV = (TextView) findViewById(R.id.TVM1);
		ET = (EditText) findViewById(R.id.ETM1);

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

		case R.id.g1:

			Calc(0, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.micg1:

			Calc(1, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.mg1:

			Calc(2, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.kg1:

			Calc(3, GetID(L2.getCheckedRadioButtonId()));

			break;

		case R.id.MTon1:

			Calc(4, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.LTon1:

			Calc(5, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.STon1:

			Calc(6, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.stone1:

			Calc(7, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.pound1:

			Calc(8, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.ounce1:

			Calc(9, GetID(L2.getCheckedRadioButtonId()));

			break;
		
			

		// ------------------- FROM ^ TO
		// \/---------------------------------------

		case R.id.g2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 0);
			break;

		case R.id.micg2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 1);
			break;

		case R.id.mg2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 2);

			break;
		case R.id.kg2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 3);

			break;
		case R.id.MTon2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 4);

			break;
		case R.id.LTon2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 5);

			break;
		case R.id.STon2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 6);

			break;
		case R.id.stone2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 7);

			break;
		case R.id.pound2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 8);

			break;
		case R.id.ounce2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 9);

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
			x = (x/1); // FROM Gram
			break;
		case 1:
			x = (x * 1e-6); // FROM Microgram
			break;
		case 2:
			x = (x * 1e-3); // FROM Milligram
			break;
		case 3:
			x = (x * 1000); 	// FROM Kilogram
			break;
		case 4:
			x = (x * 1e6); // FROM Metric Ton
			break;
		case 5:
			x = (x * 1.016e6); // FROM Long Ton
			break;
		case 6:
			x = (x * 907185); // FROM Short Ton
			break;
		case 7:
			x = (x * 6350.29); // FROM Stone
			break;
		case 8:
			x = (x * 453.592); // FROM Pound
			break;
		case 9:
			x = (x * 28.3495); // FROM Ounce
			break;
		default:
			TV.setText("Select Initial Unit");
			return;
		}

		switch (val2) {
		case 0:
			x = (x/1); // FROM Gram
			break;
		case 1:
			x = (x / 1e-6); // FROM Microgram
			break;
		case 2:
			x = (x / 1e-3); // FROM Milligram
			break;
		case 3:
			x = (x / 1000); 	// FROM Kilogram
			break;
		case 4:
			x = (x / 1e6); // FROM Metric Ton
			break;
		case 5:
			x = (x / 1.016e6); // FROM Long Ton
			break;
		case 6:
			x = (x / 907185); // FROM Short Ton
			break;
		case 7:
			x = (x / 6350.29); // FROM Stone
			break;
		case 8:
			x = (x / 453.592); // FROM Pound
			break;
		case 9:
			x = (x / 28.3495); // FROM Ounce
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
		case R.id.g1:
			return 0;
		case R.id.micg1:
			return 1;
		case R.id.mg1:
			return 2;
		case R.id.kg1:
			return 3;
		case R.id.MTon1:
			return 4;
		case R.id.LTon1:
			return 5;
		case R.id.STon1:
			return 6;
		case R.id.stone1:
			return 7;
		case R.id.pound1:
			return 8;
		case R.id.ounce1:
			return 9;
		

			// -----------FROM ^ TO \/----------------

		case R.id.g2:
			return 0;
		case R.id.micg2:
			return 1;
		case R.id.mg2:
			return 2;
		case R.id.kg2:
			return 3;
		case R.id.MTon2:
			return 4;
		case R.id.LTon2:
			return 5;
		case R.id.STon2:
			return 6;
		case R.id.stone2:
			return 7;
		case R.id.pound2:
			return 8;
		case R.id.ounce2:
			return 9;
		default:
			return -1;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mass, menu);
		return true;
	}

	

}
