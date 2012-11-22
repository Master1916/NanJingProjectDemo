package com.litsoft.demo.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;

import com.litsoft.demo.R;

public class MyTabHostFive extends TabActivity {

	private TabHost mTabHost;

	public static TabWidget mTabWidget;

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
		Window window = MyTabHostFive.this.getWindow();
		// 设置当前窗体为全屏显示
		window.setFlags(flag, flag);
		setContentView(R.layout.main);
		mTabHost = this.getTabHost();
		/* 去除标签下方的白线 */
		// 初始化一个Inflater
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		mTabHost.setPadding(mTabHost.getPaddingLeft(),
				mTabHost.getPaddingTop(), mTabHost.getPaddingRight(),
				mTabHost.getPaddingBottom() - 5);
		Resources rs = getResources();

		Intent layout1intent = new Intent();
		layout1intent.setClass(this, Layout1.class);
		TabHost.TabSpec layout1spec = mTabHost.newTabSpec("layout1");

		View view1 = inflater.inflate(R.layout.tab1, null);

		layout1spec.setIndicator(view1);
		// layout1spec.setIndicator("", rs.getDrawable(R.drawable.network));
		layout1spec.setContent(layout1intent);
		mTabHost.addTab(layout1spec);

		Intent layout2intent = new Intent();
		layout2intent.setClass(this, Layout3.class);
		TabHost.TabSpec layout2spec = mTabHost.newTabSpec("layout2");

		View view2 = inflater.inflate(R.layout.tab2, null);
		layout2spec.setIndicator(view2);

		// layout2spec.setIndicator("", rs.getDrawable(R.drawable.bingdu));
		layout2spec.setContent(layout2intent);
		mTabHost.addTab(layout2spec);

		Intent layout3intent = new Intent();
		layout3intent.setClass(this, Layout2.class);
		TabHost.TabSpec layout3spec = mTabHost.newTabSpec("layout3");
		View view3 = inflater.inflate(R.layout.tab3, null);

		// layout3spec.setIndicator("", rs.getDrawable(R.drawable.zonghe));、
		layout3spec.setIndicator(view3);
		layout3spec.setContent(layout3intent);
		mTabHost.addTab(layout3spec);

		/* 对Tab标签的定制 */
		mTabWidget = mTabHost.getTabWidget();
		mTabWidget.setVisibility(android.view.View.VISIBLE);

		for (int i = 0; i < mTabWidget.getChildCount(); i++) {
			/* 得到每个标签的视图 */
			View view = mTabWidget.getChildAt(i);
			/* 设置每个标签的背景 */
			if (mTabHost.getCurrentTab() == i) {
				// view.setBackgroundDrawable(getResources().getDrawable(R.drawable.number_bg_pressed));
				view.setBackgroundColor(android.graphics.Color
						.parseColor("#547E9E"));
			} else {
				// view.setBackgroundDrawable(getResources().getDrawable(R.drawable.number_bg));
				view.setBackgroundColor(android.graphics.Color
						.parseColor("#5B5B5B"));
			}
			/* 设置Tab间分割竖线的颜色 */
			// mTabWidget.setDividerDrawable(Color.WHITE);
			// mTabWidget.setBackgroundColor(Color.WHITE);

			/* 设置Tab间分割竖线的背景图片 */
			// mTabWidget.setDividerDrawable(R.drawable.bingdu);
			/* 设置tab的高度 */
			mTabWidget.getChildAt(i).getLayoutParams().height = 70;
			// TextView tv = (TextView)
			// mTabWidget.getChildAt(i).findViewById(android.R.id.title);
			/* 设置tab内字体的颜色 */
			// tv.setTextColor(Color.rgb(49, 116, 171));

		}

		/* 当点击Tab选项卡的时候，更改当前Tab标签的背景 */
		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String tabId) {
				for (int i = 0; i < mTabWidget.getChildCount(); i++) {
					View view = mTabWidget.getChildAt(i);
					if (mTabHost.getCurrentTab() == i) {
						// view.setBackgroundDrawable(getResources().getDrawable(R.drawable.number_bg_pressed));
						view.setBackgroundColor(android.graphics.Color
								.parseColor("#547E9E"));
					} else {
						// view.setBackgroundDrawable(getResources().getDrawable(R.drawable.number_bg));
						view.setBackgroundColor(android.graphics.Color
								.parseColor("#5B5B5B"));
					}
				}
			}
		});

	}

	public void setCurrentTab(int index) {
		mTabHost.setCurrentTab(index);
	}

	protected void dialog() {
		AlertDialog.Builder builder = new Builder(MyTabHostFive.this);
		builder.setMessage("确认退出吗？");

		builder.setTitle("提示");

		builder.setPositiveButton("确认", new OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();

				MyTabHostFive.this.finish();
			}
		});

		builder.setNeutralButton("取消", new OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}

		});

		builder.create().show();
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub System.out.println("keydown");
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			dialog();
		}

		return super.onKeyDown(keyCode, event);

	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			if (event.getAction() == KeyEvent.ACTION_DOWN
					&& event.getRepeatCount() == 0) {
				dialog();
			}
			return true;
		}
		return super.dispatchKeyEvent(event);
	}

}