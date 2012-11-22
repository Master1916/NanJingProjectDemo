package com.litsoft.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.litsoft.demo.R;
import com.litsoft.demo.chart.PieChart;

public class MainActivity extends Activity implements OnClickListener {

	private static final String ACTION_FLOWRATE = "intent.action.FLOWRATEACTIVITY";
	private ImageButton im1, im2, im3, im4, im5;
	private PieChart netWorkchar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		initView();
	}

	private void initView() {
		netWorkchar = new PieChart();
		im1 = (ImageButton) findViewById(R.id.im1);
		im2 = (ImageButton) findViewById(R.id.im2);
		im3 = (ImageButton) findViewById(R.id.im3);
		im1.setOnClickListener(this);
		im2.setOnClickListener(this);
		im3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		if (v == im1) {
			intent = new Intent(MainActivity.this, FlowRateActivity.class);
		} else if (v == im2) {
			 
			//intent = netWorkchar.execute(this);
			intent=new Intent(MainActivity.this,ChooseWeekActivity.class);
			intent.putExtra("zhyy", "network");
		} else if (v == im3) {
			//intent = new Intent(MainActivity.this, CapplicationActivity.class);
			intent = new Intent(MainActivity.this,
					ListApplicationActivity.class);

		}
		startActivity(intent);

	}

}
