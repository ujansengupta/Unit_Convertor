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

public class Speed extends Activity implements OnCheckedChangeListener {
	RadioGroup L1, L2;
	TextView TV;
	EditText ET;
	double x;
	String s1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.speed);
		L1 = (RadioGroup) findViewById(R.id.RGS1);
		L1.setOnCheckedChangeListener((OnCheckedChangeListener) this);

		L2 = (RadioGroup) findViewById(R.id.RGS2);
		L2.setOnCheckedChangeListener(/*(OnCheckedChangeListener)*/ this);

		TV = (TextView) findViewById(R.id.TVS1);
		ET = (EditText) findViewById(R.id.ETS1);

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

	

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		String number = ET.getText().toString();
		if (number.equals("")) {
			return;
		}
		x = Double.parseDouble(number);
		
		switch(checkedId)
		{
		case R.id.kmhr1:Calc(0,GetId(L2.getCheckedRadioButtonId()));
						break;
		case R.id.msec1:Calc(1,GetId(L2.getCheckedRadioButtonId()));
						break;
		case R.id.mihr1:Calc(2,GetId(L2.getCheckedRadioButtonId()));
						break;
		case R.id.knot1:Calc(3,GetId(L2.getCheckedRadioButtonId()));
						break;
		case R.id.fsec1:Calc(4,GetId(L2.getCheckedRadioButtonId()));
						break;
		// ------------------- FROM ^ TO
		// \/---------------------------------------
		case R.id.kmhr2:Calc(GetId(L1.getCheckedRadioButtonId()),0);
						break;	
		case R.id.msec2:Calc(GetId(L1.getCheckedRadioButtonId()),1);
						break;	
		case R.id.mihr2:Calc(GetId(L1.getCheckedRadioButtonId()),2);
						break;	
		case R.id.knot2:Calc(GetId(L1.getCheckedRadioButtonId()),3);
						break;	
		case R.id.fsec2:Calc(GetId(L1.getCheckedRadioButtonId()),4);
						break;	

		}
	}
	private void Calc(int val1, int val2) {
		
		if(val1==val2){
			TV.setText(ET.getText().toString());
			return;
		}
		switch(val1)
		{
			case 0:
				x=x*0.277778;
				break;
			case 1:
				x=x*1;
				break;
			case 2:
				x=x*0.44704;
				break;
			case 3:
				x=x*0.514444;
				break;
			case 4:
				x=x*0.3048;
				break;
			default:
				TV.setText("Select Initial Unit");
				return;
			
		}
		switch(val2)
		{
			case 0:
				x=x*3.6;
				break;
			case 1:
				x=x*1;
				break;
			case 2:
				x=x*2.23694;
				break;
			case 3:
				x=x*1.94384;
				break;
			case 4:
				x=x*3.28084;
				break;
			default:
				TV.setText("Select Desired Unit");
				return;
		}
		s1 = x + "";
		TV.setText(s1);
	}
	private int GetId(int arg) {
		switch (arg) 
		{	
			case R.id.kmhr1:
				return 0;
			case R.id.msec1:
				return 1;
			case R.id.mihr1:
				return 2;
			case R.id.knot1:
				return 3;
			case R.id.fsec1:
				return 4;
			
				// -----------FROM ^ TO \/----------------
				
			case R.id.kmhr2:
				return 0;
			case R.id.msec2:
				return 1;
			case R.id.mihr2:
				return 2;
			case R.id.knot2:
				return 3;
			case R.id.fsec2:
				return 4;
			default:
				return -1;
		}
	}

@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.speed, menu);
		return true;
	}
}
