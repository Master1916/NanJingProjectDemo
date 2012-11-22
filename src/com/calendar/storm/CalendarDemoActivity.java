package com.calendar.storm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.calendar.storm.CalendarLayout.OnDayClickListener;
import com.calendar.storm.CalendarView.OnMonthChangeListener;
import com.litsoft.demo.R;
import com.litsoft.demo.activity.Layout1;
import com.litsoft.demo.activity.Layout2;
import com.litsoft.demo.activity.MyTabHostFive;

public class CalendarDemoActivity extends Activity implements
		OnMonthChangeListener, OnDayClickListener {
	private CalendarView mView;
	private CalendarLayout mCalendarLayout;
	private TextView month;
	private Intent intent;
	int numLayout;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 隐藏标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 隐藏状态栏
		// 定义全屏参数
		int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
		// 获得当前窗体对象
		Window window = CalendarDemoActivity.this.getWindow();
		// 设置当前窗体为全屏显示
		window.setFlags(flag, flag);
		setContentView(R.layout.main1);

		mCalendarLayout = (CalendarLayout) findViewById(R.id.mycalendar);
		mView = mCalendarLayout.getMainView();
		mView.setMonthChangeListener(this);
		mCalendarLayout.setDayClickListener(this);

		month = (TextView) findViewById(R.id.month);
		month.setText(mView.getYear() + "年" + mView.getMonth() + "月");
		intent = getIntent();
		numLayout = intent.getIntExtra("layout", 0);
	}

	@Override
	public void onMonthChanged() {
		month.setText(mView.getYear() + "年" + mView.getMonth() + "月");
	}

	@Override
	public void onDayClick() {
		Cell day = mView.getmTouchedCell();
		Toast.makeText(
				this,
				day.getYear() + "-" + day.getMonth() + "-"
						+ day.getDayOfMonth(), Toast.LENGTH_SHORT).show();
		String str = day.getYear() + "-" + day.getMonth() + "-"
				+ day.getDayOfMonth();

		Intent intent = new Intent(CalendarDemoActivity.this,
				MyTabHostFive.class);
		if (numLayout == 1) {
			Layout1.times = str;
		}else if(numLayout==2){
			Layout2.time=str;
			
		}

		startActivity(intent);
		finish();

	}
}