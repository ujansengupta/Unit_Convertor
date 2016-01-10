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

public class Temperature extends Activity implements OnCheckedChangeListener {
	RadioGroup L1, L2;
	TextView TV;
	EditText ET;
	double x;
	String s1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temperature);
		L1 = (RadioGroup) findViewById(R.id.RGT1);
		L1.setOnCheckedChangeListener((OnCheckedChangeListener) this);

		L2 = (RadioGroup) findViewById(R.id.RGT2);
		L2.setOnCheckedChangeListener(/*(OnCheckedChangeListener)*/ this);

		TV = (TextView) findViewById(R.id.TVT1);
		ET = (EditText) findViewById(R.id.ETT1);

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
		case R.id.cel1:Calc(0,GetId(L2.getCheckedRadioButtonId()));
						break;
		case R.id.far1:Calc(1,GetId(L2.getCheckedRadioButtonId()));
						break;
		case R.id.kel1:Calc(2,GetId(L2.getCheckedRadioButtonId()));
						break;
		
		// ------------------- FROM ^ TO
		// \/---------------------------------------
		case R.id.cel2:Calc(GetId(L1.getCheckedRadioButtonId()),0);
						break;	
		case R.id.far2:Calc(GetId(L1.getCheckedRadioButtonId()),1);
						break;	
		case R.id.kel2:Calc(GetId(L1.getCheckedRadioButtonId()),2);
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
				x=x*1;
				break;
			case 1:
				x=((((x-32)*5)/9));
				break;
			case 2:
				x=x-273.15;
				break;
			default:
				TV.setText("Select Initial Unit");
				return;
			
		}
		switch(val2)
		{
			case 0:
				x=x*1;
				break;
			case 1:
				x=((((x*9)/5))+32);
				break;
			case 2:
				x=x+273.15;
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
			case R.id.cel1:
				return 0;
			case R.id.far1:
				return 1;
			case R.id.kel1:
				return 2;
				// -----------FROM ^ TO \/----------------
				
			case R.id.cel2:
				return 0;
			case R.id.far2:
				return 1;
			case R.id.kel2:
				return 2;
			default:
				return -1;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.temperature, menu);
		return true;
	}
}
