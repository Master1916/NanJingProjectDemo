package com.litsoft.demo.activity;

import android.app.Activity;
 
 
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;

import com.litsoft.demo.R;
import com.litsoft.demo.chart.LineChart;

public class ChooseViewModeActivity extends Activity implements OnClickListener{
	private RadioGroup ChooseViewMode;
	private RadioButton day, week;
	private Spinner ChooseMode;
	private String chooseResult;
	private int mode=1;
	private LineChart qyzxchart;
	private Button sure,cancle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_viewmode_activity);
		setTitle(R.string.choose_viewmode);
		initView();

	}

	private void initView() {
		sure=(Button)findViewById(R.id.sure);
		cancle=(Button)findViewById(R.id.cancle);
		sure.setOnClickListener(this);
		cancle.setOnClickListener(this);
		qyzxchart=new LineChart(); 
		ChooseViewMode = (RadioGroup) findViewById(R.id.chooseviewmode);
		day = (RadioButton) findViewById(R.id.day);
		week = (RadioButton) findViewById(R.id.week);
		ChooseViewMode.setOnCheckedChangeListener(mChangRadio);
		ChooseMode = (Spinner) findViewById(R.id.choosemodespinner);
		initSpinner(day.getId());
		ChooseMode.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Spinner temp=(Spinner)arg0;
				chooseResult=temp.getSelectedItem().toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	private OnCheckedChangeListener mChangRadio = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			ChooseMode.setVisibility(0);
			initSpinner(checkedId);

		}
	};
	

	 
	
	private void initSpinner(int checkedId) {

		if (checkedId == day.getId()) {
			String days[] = { "2012-11-1", "2012-11-2", "2012-11-3",
					"2012-11-4", "2012-11-5", "2012-11-6", "2012-11-7",
					"2012-11-8", "2012-11-9", "2012-11-10" };
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, days);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			ChooseMode.setAdapter(adapter);
			mode=1;

		} else {
			String weeks[] = { "2011-11-1周", "2011-11-2周", "2011-11-3周", "2011-11-4周",
					"2011-5周", "2011-6周", "2011-7周", "2011-8周", "2011-9周", "2011-10",
					"2011-11周", "2011-12周" };
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, weeks);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			ChooseMode.setAdapter(adapter);
          mode=2;
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		/*if(v==sure){
			Intent intent=qyzxchart.execute(ChooseViewModeActivity.this, chooseResult, mode);
			startActivity(intent);
		}else{
			finish();
		}*/
		
	}

 

}
