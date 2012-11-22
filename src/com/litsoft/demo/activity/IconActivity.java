package com.litsoft.demo.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.litsoft.demo.R;

public class IconActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //定义全屏参数
        int flag=WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
        Window window=IconActivity.this.getWindow();
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
		setContentView(R.layout.iconactivity);
		
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				Intent intent = new Intent(IconActivity.this,MyTabHostFive.class);

				startActivity(intent);
				finish();
			}
		};
		timer.schedule(timerTask, 1000 * 1); // 2秒后执行

	}
		
	}

 
