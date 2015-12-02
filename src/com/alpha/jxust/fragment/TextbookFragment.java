package com.alpha.jxust.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alpha.college.R;
import com.alpha.jxust.activity.MainActivity;
import com.alpha.jxust.constant.Constant;

public class TextbookFragment extends BaseFragment 
{
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		View newsLayout = inflater.inflate(R.layout.layout_textbook, container,false);
		return newsLayout;
	}

	public void onResume() 
	{
		super.onResume();
		MainActivity.currFragTag = Constant.FRAGMENT_FLAG_TEXTBOOK;
	}
}
