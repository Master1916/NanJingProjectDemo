package com.litsoft.demo.activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.calendar.storm.CalendarDemoActivity;
import com.litsoft.demo.R;
import com.litsoft.demo.chart.LineChart;

public class Layout1 extends Activity implements OnClickListener {
	// private Button chooseTime;
	// private Button dx100, dx10, yd10, skyzx ;
	private String title;
	private String time;
	private LineChart lineChart;
	private TextView showTime, qyzx, wgtc, dx100, dx10, yd10, skyzx,
			chooseTime;
	int year = 0;
	int month = 0;
	int date = 0;
	public static String times = "";
	private LinearLayout linearlayout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout1);

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		initParm();
	}

	private String getSystemData() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 其中yyyy-MM-dd是你要表示的格式
		// 可以任意组合，不限个数和次序；具体表示为：MM-month,dd-day,yyyy-year;kk-hour,mm-minute,ss-second;
		String str = sdf.format(d);
		return str;

	}

	private void initParm() {
		showTime = (TextView) findViewById(R.id.show_time);

		if ("".equals(times) || null == times) {
			showTime.setText(getSystemData());
		} else {
			showTime.setText(times);
		}

		lineChart = new LineChart();
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		date = c.get(Calendar.DATE);
		qyzx = (TextView) findViewById(R.id.quzx);
		qyzx.setClickable(true);
		qyzx.setFocusable(true);
		qyzx.setBackgroundDrawable(getResources().getDrawable(R.drawable.choose));

		qyzx.setOnClickListener(this);

		wgtc = (TextView) findViewById(R.id.wgtc);
		wgtc.setClickable(true);
		wgtc.setFocusable(true);
		wgtc.setBackgroundDrawable(getResources().getDrawable(R.drawable.de));
		// wgtc.setBackgroundColor(android.graphics.Color.parseColor("#000000"));
		wgtc.setOnClickListener(this);

		dx100 = (TextView) findViewById(R.id.dx100);
		dx100.setClickable(true);
		dx100.setFocusable(true);
		dx100.setBackgroundDrawable(getResources().getDrawable(R.drawable.de));
		// wgtc.setBackgroundColor(android.graphics.Color.parseColor("#000000"));
		dx100.setOnClickListener(this);

		dx10 = (TextView) findViewById(R.id.dx10);
		dx10.setClickable(true);
		dx10.setFocusable(true);
		dx10.setBackgroundDrawable(getResources().getDrawable(R.drawable.de));
		// wgtc.setBackgroundColor(android.graphics.Color.parseColor("#000000"));
		dx10.setOnClickListener(this);

		yd10 = (TextView) findViewById(R.id.yd10);

		yd10.setClickable(true);
		yd10.setFocusable(true);
		yd10.setBackgroundDrawable(getResources().getDrawable(R.drawable.de));
		yd10.setOnClickListener(this);

		skyzx = (TextView) findViewById(R.id.skyzx);
		skyzx.setClickable(true);
		skyzx.setFocusable(true);
		skyzx.setBackgroundDrawable(getResources().getDrawable(R.drawable.de));
		skyzx.setOnClickListener(this);

		chooseTime = (TextView) findViewById(R.id.choose_time);
		chooseTime.setClickable(true);
		chooseTime.setFocusable(true);

		chooseTime.setOnClickListener(this);
		linearlayout = (LinearLayout) findViewById(R.id.linearlayout);

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		updateView();

	}

	private void updateView() {

		View view = lineChart.executeGetView(this);

		// 为其建立布局样式，对应xml布局中：
		// android:layout_width="fill_parent"
		// android:layout_height="wrap_content"
		LinearLayout.LayoutParams mLayoutParams = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		// 在父类布局中添加它，及布局样式
		linearlayout.removeAllViews();
		linearlayout.addView(view, mLayoutParams);
	}

	private void disAble(View v) {
		if (v == qyzx) {
			qyzx.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
			wgtc.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			dx100.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			dx10.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yd10.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			skyzx.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
		} else if (v == wgtc) {
			qyzx.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			wgtc.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
			dx100.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			dx10.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yd10.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			skyzx.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
		} else if (v == dx100) {
			qyzx.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			wgtc.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			dx100.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
			dx10.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yd10.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			skyzx.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
		} else if (v == dx10) {
			qyzx.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			wgtc.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			dx100.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			dx10.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
			yd10.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			skyzx.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
		} else if (v == yd10) {
			qyzx.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			wgtc.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			dx100.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			dx10.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yd10.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
			skyzx.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
		} else if (v == skyzx) {
			qyzx.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			wgtc.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			dx100.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.de));
			dx10.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			yd10.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.de));
			skyzx.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.choose));
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		// String time = chooseTime.getText().toString();
		String title = null;
		String str = null;
		disAble(v);
		if (v == qyzx) {

			updateView();

		} else if (v == wgtc) {

			updateView();

		} else if (v == dx100) {

			updateView();

		} else if (v == dx10) {

			updateView();

		} else if (v == yd10) {

			updateView();

		} else if (v == skyzx) {

			updateView();

		} else if (v == chooseTime) {
			Intent intent = new Intent(Layout1.this, CalendarDemoActivity.class);
			intent.putExtra("layout", 1);
			startActivityForResult(intent, 0);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, 1, 1, "加载数据");
		menu.add(0, 2, 2, "退出");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == 1) {

		} else if (item.getItemId() == 2) {
			dialog();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		System.out.println("onActivityResult");
		updateView();
		
	}

	protected void dialog() {
		AlertDialog.Builder builder = new Builder(Layout1.this);
		builder.setMessage("确认退出吗？");

		builder.setTitle("提示");

		builder.setPositiveButton("确认",
				new android.content.DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();

						Layout1.this.finish();
					}
				});

		builder.setNeutralButton("取消",
				new android.content.DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}

				});

		builder.create().show();
	}

}
