package com.alpha.jxust.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alpha.college.R;
import com.alpha.jxust.activity.MainActivity;
import com.alpha.jxust.constant.Constant;

/**
 * 新闻的Fragment
 * @author bing
 *
 */
public class NewsFragment extends BaseFragment 
{
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		View newsLayout = inflater.inflate(R.layout.layout_news, container,false);
		return newsLayout;
	}

	public void onResume() 
	{
		super.onResume();
		MainActivity.currFragTag = Constant.FRAGMENT_FLAG_NEWS;
	}
}
