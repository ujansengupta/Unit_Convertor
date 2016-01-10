package com.example.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Volume extends Activity implements OnCheckedChangeListener {

	RadioGroup L1, L2;
	TextView TV;
	EditText ET;
	double x;
	String s1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.volume);

		L1 = (RadioGroup) findViewById(R.id.RGV1);
		L1.setOnCheckedChangeListener((OnCheckedChangeListener) this);

		L2 = (RadioGroup) findViewById(R.id.RGV2);
		L2.setOnCheckedChangeListener(/*(OnCheckedChangeListener)*/ this);

		TV = (TextView) findViewById(R.id.TVV1);
		ET = (EditText) findViewById(R.id.ETV1);

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

		case R.id.cbm1:

			Calc(0, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.lit1:

			Calc(1, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.usgal1:

			Calc(2, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.usquar1:

			Calc(3, GetID(L2.getCheckedRadioButtonId()));

			break;

		case R.id.uspi1:

			Calc(4, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.uscup1:

			Calc(5, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.usoz1:

			Calc(6, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.ustb1:

			Calc(7, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.usts1:

			Calc(8, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.milit1:

			Calc(9, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.impgal1:

			Calc(10, GetID(L2.getCheckedRadioButtonId()));
			break;

		case R.id.impquar1:

			Calc(11, GetID(L2.getCheckedRadioButtonId()));

			break;

		case R.id.impi1:

			Calc(12, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.impcup1:

			Calc(13, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.impoz1:

			Calc(14, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.imptb1:

			Calc(15, GetID(L2.getCheckedRadioButtonId()));

			break;
		case R.id.impts1:

			Calc(16, GetID(L2.getCheckedRadioButtonId()));

			break;

		// ------------------- FROM ^ TO
		// \/---------------------------------------

		case R.id.cbm2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 0);
			break;

		case R.id.lit2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 1);
			break;

		case R.id.usgal2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 2);

			break;
		case R.id.usquar2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 3);

			break;
		case R.id.uspi2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 4);

			break;
		case R.id.uscup2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 5);

			break;
		case R.id.usoz2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 6);

			break;
		case R.id.ustb2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 7);

			break;
		case R.id.usts2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 8);

			break;
		case R.id.milit2:
			
			Calc(GetID(L1.getCheckedRadioButtonId()), 9);

			break;
		case R.id.impgal2:
			
			Calc(GetID(L1.getCheckedRadioButtonId()), 10);

			break;
		case R.id.impquar2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 11);

			break;
		case R.id.impi2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 12);

			break;
		case R.id.impcup2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 13);

			break;
		case R.id.impoz2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 14);

			break;
		case R.id.imptb2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 15);

			break;
		case R.id.impts2:

			Calc(GetID(L1.getCheckedRadioButtonId()), 16);

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
			x = (x * 1); // FROM Cubic Meter
			break;
		case 1:
			x = (x * 0.001); // FROM Liter
			break;
		case 2:
			x = (x * 0.00378541); // FROM US Gal
			break;
		case 3:
			x = (x * 0.000946353); 	// FROM US Quart
			break;
		case 4:
			x = (x * 0.000473176); // FROM US Pint
			break;
		case 5:
			x = (x * 0.000236588); // FROM US Cup
			break;
		case 6:
			x = (x * 2.9574e-5); // FROM US Oz
			break;
		case 7:
			x = (x * 1.4787e-5); // FROM US Tbsp
			break;
		case 8:
			x = (x * 4.9289e-6); // FROM US Tsp
			break;
		case 9:
			x = (x * 1e-6); // FROM Milliliter
			break;
		case 10:
			x = (x * 0.00454609); // FROM IMP Gal
			break;
		case 11:
			x = (x * 0.00113652); 	// FROM IMP Quart
			break;
		case 12:
			x = (x * 0.000568261); // FROM IMP Pint
			break;
		case 13:
			x = (x * 0.000236588); // FROM IMP Cup
			break;
		case 14:
			x = (x * 2.9574e-5); // FROM IMP Oz
			break;
		case 15:
			x = (x *1.77582e-5); // FROM IMP Tbsp
			break;
		case 16:
			x = (x *5.9194e-6); // FROM IMP Tsp
			break;
		default:
			TV.setText("Select Initial Unit");
			return;
		}

		switch (val2) {
		case 0:
			x = (x * 1); // FROM Cubic Meter
			break;
		case 1:
			x = (x / 0.001); // FROM Liter
			break;
		case 2:
			x = (x / 0.00378541); // FROM US Gal
			break;
		case 3:
			x = (x / 0.000946353); 	// FROM US Quart
			break;
		case 4:
			x = (x / 0.000473176); // FROM US Pint
			break;
		case 5:
			x = (x / 0.000236588); // FROM US Cup
			break;
		case 6:
			x = (x / 2.9574e-5); // FROM US Oz
			break;
		case 7:
			x = (x / 1.4787e-5); // FROM US Tbsp
			break;
		case 8:
			x = (x / 4.9289e-6); // FROM US Tsp
			break;
		case 9:
			x = (x /1e-6); // FROM Milliliter
			break;
		case 10:
			x = (x / 0.00454609); // FROM IMP Gal
			break;
		case 11:
			x = (x / 0.00113652); 	// FROM IMP Quart
			break;
		case 12:
			x = (x / 0.000568261); // FROM IMP Pint
			break;
		case 13:
			x = (x / 0.000236588); // FROM IMP Cup
			break;
		case 14:
			x = (x / 2.9574e-5); // FROM IMP Oz
			break;
		case 15:
			x = (x / 1.77582e-5); // FROM IMP Tbsp
			break;
		case 16:
			x = (x / 5.9194e-6); // FROM IMP Tsp
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
		case R.id.cbm1:
			return 0;
		case R.id.lit1:
			return 1;
		case R.id.usgal1:
			return 2;
		case R.id.usquar1:
			return 3;
		case R.id.uspi1:
			return 4;
		case R.id.uscup1:
			return 5;
		case R.id.usoz1:
			return 6;
		case R.id.ustb1:
			return 7;
		case R.id.usts1:
			return 8;
		case R.id.milit1:
			return 9;
		case R.id.impgal1:
			return 10;
		case R.id.impquar1:
			return 11;
		case R.id.impi1:
			return 12;
		case R.id.impcup1:
			return 13;
		case R.id.impoz1:
			return 14;
		case R.id.imptb1:
			return 15;
		case R.id.impts1:
			return 16;

			// -----------FROM ^ TO \/----------------

		case R.id.cbm2:
			return 0;
		case R.id.lit2:
			return 1;
		case R.id.usgal2:
			return 2;
		case R.id.usquar2:
			return 3;
		case R.id.uspi2:
			return 4;
		case R.id.uscup2:
			return 5;
		case R.id.usoz2:
			return 6;
		case R.id.ustb2:
			return 7;
		case R.id.usts2:
			return 8;
		case R.id.milit2:
			return 9;
		case R.id.impgal2:
			return 10;
		case R.id.impquar2:
			return 11;
		case R.id.impi2:
			return 12;
		case R.id.impcup2:
			return 13;
		case R.id.impoz2:
			return 14;
		case R.id.imptb2:
			return 15;
		case R.id.impts2:
			return 16;
		default:
			return -1;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.volume, menu);
		return true;
	}
}
