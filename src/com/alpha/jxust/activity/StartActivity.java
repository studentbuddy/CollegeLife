package com.alpha.jxust.activity;

import com.alpha.college.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 启动界面
 * @author bing
 * 显示启动图片,3秒之后跳如主界面
 */
public class StartActivity extends Activity 
{
	// 启动主Activity的Intent
	Intent intent = null;

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		// 新建一个线程
		new Thread() 
		{
			public void run() 
			{
				try 
				{
					// 3秒之后启动一个新的Activity
					Thread.sleep(3000);
					Intent intent = (new Intent(StartActivity.this, MainActivity.class));
					startActivity(intent);
					finish();
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}.start();
	}
}
