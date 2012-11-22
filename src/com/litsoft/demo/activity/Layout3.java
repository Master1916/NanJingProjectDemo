package com.litsoft.demo.activity;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.litsoft.demo.R;
import com.litsoft.demo.chart.BarChart;
import com.litsoft.demo.chart.PieChart;

public class Layout3 extends Activity implements OnClickListener {
	private TextView textView = null;
	private TextView gzap, gzqs, gzjh, gzzj, yhdl;
	private LinearLayout l1, l2;
	private Spinner yw_choose, yw1_choose;
	private PieChart pieChart;
	private double values[];
	private String titles[];
	private int colors[];
	//private String time;
	private String biaoti;
	private BarChart barChart;
	private LinearLayout show_chart, show_barchart;
int weizhi=1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout3);
		pieChart = new PieChart();
		

		yw_choose = (Spinner) findViewById(R.id.yw_choose);
		initSpinner();
		yw_choose.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Spinner temp = (Spinner) arg0;
				//time = temp.getSelectedItem().toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		yw1_choose = (Spinner) findViewById(R.id.yw1_choose);
		yw1_choose.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(weizhi==1){
					updateView1("工作安排");
				}else if(weizhi==2){
					updateView1("工作请示");
				}else if(weizhi==3){
					updateView1("工作计划");
				}else if(weizhi==4){
					updateView1("工作总结");
				}else if(weizhi==5){
					updateView1("用户登录");
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		initSpinner1();

		l1 = (LinearLayout) findViewById(R.id.yun_everyday_layout);
		l2 = (LinearLayout) findViewById(R.id.yun_event_layout);
       initView();
	}

	private void initSpinner() {
 
		String week[] = new String[30];

		for (int i = 1; i <= 30; i++) {

			week[i - 1] = "2012年-" + i + "周";
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, week);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 
		yw_choose.setAdapter(adapter);
	}

	private void initSpinner1() {
		String weeks[] = { "2012-1周-10周", "2012-11周-20周", "2012-21周-30周",
				"2012-31周-40周", "2012-41周-50周" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, weeks);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		yw1_choose.setAdapter(adapter);
		 
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// initParm(5);
	}

	private void initView() {
		barChart = new BarChart();
		gzap = (TextView) findViewById(R.id.gzap);
		gzap.setClickable(true);
		gzap.setFocusable(true);
		gzap.setBackgroundResource(R.drawable.choose);
		gzqs = (TextView) findViewById(R.id.gzqs);
		gzqs.setClickable(true);
		gzqs.setFocusable(true);
		gzqs.setBackgroundResource(R.drawable.de);
		gzjh = (TextView) findViewById(R.id.gzjh);
		gzjh.setClickable(true);
		gzjh.setFocusable(true);
		gzjh.setBackgroundResource(R.drawable.de);
		gzzj = (TextView) findViewById(R.id.gzzj);
		gzzj.setClickable(true);
		gzzj.setFocusable(true);
		gzzj.setBackgroundResource(R.drawable.de);
		yhdl = (TextView) findViewById(R.id.yhdl);
		yhdl.setClickable(true);
		yhdl.setFocusable(true);
		yhdl.setBackgroundResource(R.drawable.de);

		gzap.setOnClickListener(this);
		gzqs.setOnClickListener(this);
		gzjh.setOnClickListener(this);
		gzzj.setOnClickListener(this);
		yhdl.setOnClickListener(this);
		show_barchart = (LinearLayout) findViewById(R.id.show_barchart);
		show_chart = (LinearLayout) findViewById(R.id.show_chat);
		initParm(5);
		updateView();
		updateView1("用户登录");

	}

	private void updateView1(String title) {
		 
		 
		int flag = (int) yw1_choose.getSelectedItemId();
		View view = barChart.executeview(this, Color.RED,  title, flag);
		LinearLayout.LayoutParams mLayoutParams = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		// 在父类布局中添加它，及布局样式
		show_barchart.removeAllViews();
		show_barchart.addView(view, mLayoutParams);
	}

	private void updateView() {

		View view = pieChart.executeview(this, values, titles, colors);

		LinearLayout.LayoutParams mLayoutParams = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		// 在父类布局中添加它，及布局样式
		show_chart.removeAllViews();
		show_chart.addView(view, mLayoutParams);
	}

	private void initParm(int num) {
		values = new double[num];

		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			values[i] = Math.floor(r.nextDouble() * 100);
		}
		colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA,
				Color.YELLOW, Color.CYAN };
		titles = new String[] { "工作安排", "工作请示", "工作计划", "工作总结", "用户登录" };

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		disAble(v);
		if (v == gzap) {
			updateView1("工作安排");
		} else if (v == gzqs) {
			updateView1("工作请示");
		} else if (v == gzjh) {
			updateView1("工作计划");
		} else if (v == gzzj) {
			updateView1("工作总结");
		} else if (v == yhdl) {
			updateView1("用户登录");
		}

	}

	private void disAble(View v) {
		if (v == gzap) {
			weizhi=1;
			gzap.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
			gzqs.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			gzjh.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			gzzj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yhdl.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			 
		} else if (v == gzqs) {
			weizhi=2;
			gzap.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			gzqs.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.choose));
			gzjh.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			gzzj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yhdl.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
		} else if (v == gzjh) {
			weizhi=3;
			gzap.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			gzqs.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			gzjh.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
			gzzj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yhdl.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
		} else if (v == gzzj) {
			weizhi=4;
			gzap.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			gzqs.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			gzjh.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			gzzj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.choose));
			yhdl.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
		} else if (v == yhdl) {
			weizhi=5;
			gzap.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			gzqs.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			gzjh.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			gzzj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yhdl.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.choose));
		}  

	}

	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		menu.add(0, 1, 1, "每周统计");
		menu.add(0, 2, 2, "单项统计");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == 1) {
			l1.setVisibility(LinearLayout.VISIBLE);

			l2.setVisibility(LinearLayout.GONE);

		} else if (item.getItemId() == 2) {
			l2.setVisibility(LinearLayout.VISIBLE);

			l1.setVisibility(LinearLayout.GONE);
		}
		return super.onOptionsItemSelected(item);
	}
}
