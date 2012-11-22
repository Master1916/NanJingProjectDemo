package com.litsoft.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.litsoft.demo.R;
import com.litsoft.demo.chart.PieChart;
import com.litsoft.demo.util.ToastText;

public class ChooseWeekActivity extends Activity implements OnClickListener {
	private static final String TAG="ChooseWeekActivity";
	private Spinner chooseweek;
	private Button sure, cancle;
	private String chooseResult = null;

	private double values[];
	private String titles[];
	private String biaoti;
	private String title;
	private int colors[];
	private PieChart netWorkchar;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_week_activity);
		chooseweek = (Spinner) findViewById(R.id.choose_week_spinner);
		initSpinner();
		 
		chooseweek.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Spinner temp = (Spinner) arg0;
				chooseResult = temp.getSelectedItem().toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		sure = (Button) findViewById(R.id.w_sure);
		cancle = (Button) findViewById(R.id.w_cancle);
		sure.setOnClickListener(this);
		cancle.setOnClickListener(this);

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		super.onStart();
		//initParm();
	}

	private void initParm() {
		Log.v(TAG, "initParm() ");
		netWorkchar = new PieChart();
		values = new double[] { 80, 77, 18, 703, 142 };
		Intent intent=this.getIntent();
		String str=intent.getStringExtra("zhyy");
		if(str.equals("zhyy")){
			titles = new String[] { "工作安排", "工作请示", "工作计划", "工作总结", "用户登录" };
			title = "综合应用门户运维指标";
		}else{
			titles = new String[] { "紧急事件", "严重事件", "重要事件", "警告", "被阻断的攻击事件" };
		title = " 网络攻击统计";
		}
		
		colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA,
				Color.YELLOW, Color.CYAN };
		
		biaoti = chooseweek.getSelectedItem().toString();
	}

	private void initSpinner() {
		String weeks[] = { "2012-1周", "2012-2周", "2012-3周",
				"2012-4周", "2012-5周", "2012-6周", "2012-7周", "2012-8周",
				"2012-9周", "2012-10", "2011-11周", "2012-12周" };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, weeks);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		chooseweek.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		if (v == sure) {
			  initParm();
             // intent = netWorkchar.execute(this, values, titles, colors, title,biaoti);
             // startActivity(intent);
		}else if(v==cancle){
			  finish();
		}
		
	}

}
