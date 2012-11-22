package com.litsoft.demo.activity;

 
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.litsoft.demo.R;
import com.litsoft.demo.chart.WgtcChart;

 

public class FlowRateActivity extends Activity implements OnClickListener{
	private ImageButton im1,im2,im3,im4;
	private WgtcChart wgtcChart;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle(R.string.flow_rate_name);
		 
		setContentView(R.layout.flow_ratea_activity);
		initView();
	}
	private void initView(){
		wgtcChart=new WgtcChart();
		im1=(ImageButton)findViewById(R.id.im1);
		im1.setOnClickListener(this);
		im2=(ImageButton)findViewById(R.id.im2);
		im2.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent =null;
		if(v==im1){
			intent=wgtcChart.execute(this);
		}else if(v==im2){
			intent=new Intent(FlowRateActivity.this,ChooseViewModeActivity.class);
		}
		startActivity(intent);
	}

}
