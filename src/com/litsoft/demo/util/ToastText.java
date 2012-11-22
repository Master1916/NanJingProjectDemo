package com.litsoft.demo.util;

import android.content.Context;
import android.widget.Toast;

public class ToastText {
	
	public  static void show(Context context,String msg){
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
		
	}

}
