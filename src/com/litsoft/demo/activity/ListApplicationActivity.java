package com.litsoft.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.litsoft.demo.R;
import com.litsoft.demo.chart.BarChart;
import com.litsoft.demo.chart.PieChart;

public class ListApplicationActivity extends Activity implements OnClickListener{
	private Button but1;
	private Button but2;
	private Button but3;
	private Button but4;
	private Button but5;
	private Button but6;
	private PieChart zhyychart;
	private BarChart Workarrangementbarchart;
	
	private double values[];
	private String titles[];
	private int colors[];
	private String title;
	private String biaoti;
	private String str1,str2,str3,str4,str5;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method s
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listapplicationactivity);
		initVIew();
	}
	private void initVIew(){
		but1=(Button)findViewById(R.id.but1);
		but1.setOnClickListener(this);
		but2=(Button)findViewById(R.id.but2);
		but2.setOnClickListener(this);
		but3=(Button)findViewById(R.id.but3);
		but3.setOnClickListener(this);
		but4=(Button)findViewById(R.id.but4);
		but4.setOnClickListener(this);
		but5=(Button)findViewById(R.id.but5);
		but5.setOnClickListener(this);
		but6=(Button)findViewById(R.id.but6);
		but6.setOnClickListener(this);
		zhyychart=new PieChart();
		Workarrangementbarchart=new BarChart();
		initParm();
	}
	private void initParm(){
		values=new double[]{206,1483,889,137,1795};
		titles=new String[]{"工作安排","工作请示","工作计划","工作总结","用户登录"};
		colors=new int[]{ Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN };
		title="综合应用运营门户指标";
		biaoti="2012年-1周";
		str1="工作安排";
		str2="工作请示";
		str3="工作计划";
		str4="工作总结";
		str5="用户登录";
		 
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent=null;
		if(v==but1){
			
			//intent=zhyychart.execute(this, values, titles, colors, title,biaoti); 
			intent =new Intent(ListApplicationActivity.this,ChooseWeekActivity.class);
			intent.putExtra("zhyy", "zhyy");
			
		}else if(v==but2){
			//intent=Workarrangementbarchart.execute(this,Color.BLUE,str1);
		}else if(v==but3){
			//intent=Workarrangementbarchart.execute(this,Color.GREEN,str2);
		}else if(v==but4){
			//intent=Workarrangementbarchart.execute(this,Color.YELLOW,str3);
		}
		else if(v==but5){
			//intent=Workarrangementbarchart.execute(this,Color.CYAN,str4);
		}
		else if(v==but6){
			//intent=Workarrangementbarchart.execute(this,Color.MAGENTA,str5);
		}
		 
		
		startActivity(intent);
	}
	 
	
	
	

}
