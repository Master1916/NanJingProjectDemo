package com.litsoft.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.litsoft.demo.R;

public class CapplicationActivity extends Activity implements OnClickListener {
	private Button btn1, btn2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.capplication_layout);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		if (v == btn1) {
			intent = new Intent(CapplicationActivity.this,
					ListApplicationActivity.class);
		} else {

		}
		startActivity(intent);
	}

}
