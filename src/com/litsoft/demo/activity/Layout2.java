package com.litsoft.demo.activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;

import com.calendar.storm.CalendarDemoActivity;
import com.litsoft.demo.R;
import com.litsoft.demo.chart.BarChart;
import com.litsoft.demo.chart.PieChart;

public class Layout2 extends Activity implements OnClickListener {
	private TextView textView = null;
	private TextView jjsj, yzsj, zysj, jgsj, gjsj;
	private LinearLayout l1, l2;
	private LinearLayout pchart;
	private LinearLayout bchart;
	private TextView show_time, choose_time;

	int year = 0;
	int month = 0;
	int date = 0;

	int weizhi = 1;
	private MyTabHostFive myTab;
	private PieChart pieChart;
	private BarChart barChart;
	private double values[];
	private String titles[];
	private int colors[];
	public static String time;
	private String biaoti;
	private Spinner choose_week;
	private String xTitle, yTitle;
	double xStart, xEnd;
	int xNum, color;
	private String Legend;

	private void initParm(int num) {
		values = new double[num];
		time = show_time.getText().toString();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			values[i] = Math.floor(r.nextDouble() * 100);
		}
		colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA,
				Color.YELLOW, Color.CYAN };
		titles = new String[] { "紧急事件", "严重事件", "重要事件", "警告", "被阻断的攻击事件" };
		biaoti = time + "网络统计";

	}

	private void initParm1() {
		values = new double[30];
		Random r = new Random();
		for (int i = 0; i < values.length; i++) {
			values[i] = r.nextDouble() * 300;
		}
		xTitle = "时间(天)";
		yTitle = "数量(个)";
		xStart = 0.5;
		xEnd = 30.5;
		xNum = 15;
		color = Color.RED;
	}

	private void initView() {
		pieChart = new PieChart();
		barChart = new BarChart();
		show_time = (TextView) findViewById(R.id.show_time);
		choose_time = (TextView) findViewById(R.id.choose_time);
		if ("".equals(show_time.getText().toString())
				|| null == show_time.getText().toString()) {
			show_time.setText(getSystemData());
		}
		choose_time.setClickable(true);
		choose_time.setFocusable(true);
		choose_time.setOnClickListener(this);
		pchart = (LinearLayout) findViewById(R.id.pchart);
		bchart = (LinearLayout) findViewById(R.id.barChart);
		updateView();
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		date = c.get(Calendar.DATE);
		jjsj = (TextView) findViewById(R.id.jjsj);
		jjsj.setClickable(true);
		jjsj.setFocusable(true);
		jjsj.setBackgroundResource(R.drawable.choose);
		jjsj.setOnClickListener(this);
		yzsj = (TextView) findViewById(R.id.yzsj);
		yzsj.setClickable(true);
		yzsj.setFocusable(true);
		yzsj.setBackgroundResource(R.drawable.de);
		yzsj.setOnClickListener(this);
		zysj = (TextView) findViewById(R.id.zysj);
		zysj.setClickable(true);
		zysj.setFocusable(true);
		zysj.setBackgroundResource(R.drawable.de);
		zysj.setOnClickListener(this);
		jgsj = (TextView) findViewById(R.id.jgsj);
		jgsj.setClickable(true);
		jgsj.setFocusable(true);
		jgsj.setOnClickListener(this);
		jgsj.setBackgroundResource(R.drawable.de);
		gjsj = (TextView) findViewById(R.id.zdsj);
		gjsj.setClickable(true);
		gjsj.setFocusable(true);
		gjsj.setBackgroundResource(R.drawable.de);
		gjsj.setOnClickListener(this);
		choose_week = (Spinner) findViewById(R.id.choose_week);
		Legend = new String();
		initSpinner();

	}

	private void updateView() {

		View view = pieChart.executeGetView(this);

		// 为其建立布局样式，对应xml布局中：
		// android:layout_width="fill_parent"
		// android:layout_height="wrap_content"
		LinearLayout.LayoutParams mLayoutParams = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		// 在父类布局中添加它，及布局样式
		pchart.removeAllViews();
		pchart.addView(view, mLayoutParams);
	}

	private void updateView1(String legend) {
		Legend = legend;

		View view = barChart.executeGetView(this, values, Legend, xTitle,
				yTitle, xStart, xEnd, xNum, color);

		// 为其建立布局样式，对应xml布局中：
		// android:layout_width="fill_parent"
		// android:layout_height="wrap_content"
		LinearLayout.LayoutParams mLayoutParams = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		// 在父类布局中添加它，及布局样式
		bchart.removeAllViews();
		bchart.addView(view, mLayoutParams);
	}

	private void initSpinner() {
		String month[] = new String[12];

		for (int i = 0; i < 12; i++) {

			month[i] = "2012年-" + ++i + "月";
			i--;
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, month);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		choose_week.setAdapter(adapter);
		choose_week.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if (weizhi == 1) {
					initParm1();
					updateView1("紧急事件");
				} else if (weizhi == 2) {
					initParm1();
					updateView1("严重事件");
				} else if (weizhi == 3) {
					updateView1("重要事件");
				} else if (weizhi == 4) {
					updateView1("警告事件");
				} else if (weizhi == 5) {
					updateView1("攻击事件");
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
	}

	private String getSystemData() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 其中yyyy-MM-dd是你要表示的格式
		// 可以任意组合，不限个数和次序；具体表示为：MM-month,dd-day,yyyy-year;kk-hour,mm-minute,ss-second;
		String str = sdf.format(d);
		return str;

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		show_time.setText(time);

		updateView();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout2);

		initView();

		initParm1();
		l1 = (LinearLayout) findViewById(R.id.everyday_layout);
		l2 = (LinearLayout) findViewById(R.id.event_layout);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		disAble(v);
		if (v == jjsj) {

			initParm1();
			updateView1("紧急事件");
		} else if (v == yzsj) {
			initParm1();
			updateView1("严重事件");
		} else if (v == zysj) {
			initParm1();
			updateView1("重要事件");
		} else if (v == jgsj) {
			initParm1();
			updateView1("警告事件");
		} else if (v == gjsj) {
			initParm1();
			updateView1("攻击事件");

		} else if (v == choose_time) {
			Intent intent = new Intent(Layout2.this, CalendarDemoActivity.class);
			intent.putExtra("layout", 2);
			startActivityForResult(intent, 0);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, 1, 1, "每天统计");
		menu.add(0, 2, 2, "事件统计");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == 1) {
			l1.setVisibility(LinearLayout.VISIBLE);
			l2.setVisibility(LinearLayout.GONE);
		} else if (item.getItemId() == 2) {
			l1.setVisibility(LinearLayout.GONE);
			l2.setVisibility(LinearLayout.VISIBLE);
			initParm1();
			updateView1("紧急事件");
		}
		return super.onOptionsItemSelected(item);
	}

	private void disAble(View v) {
		if (v == jjsj) {
			weizhi = 1;
			jjsj.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
			yzsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			zysj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			jgsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			gjsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));

		} else if (v == yzsj) {
			weizhi = 2;
			jjsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yzsj.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
			zysj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			jgsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			gjsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
		} else if (v == zysj) {
			weizhi = 3;
			jjsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yzsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			zysj.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
			jgsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			gjsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
		} else if (v == jgsj) {
			weizhi = 4;
			jjsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yzsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			zysj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			jgsj.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
			gjsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
		} else if (v == gjsj) {
			weizhi = 5;
			jjsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yzsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			zysj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			jgsj.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			gjsj.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
		}
	}

}
