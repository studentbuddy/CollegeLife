package com.alpha.jxust.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alpha.college.R;
import com.alpha.jxust.activity.MainActivity;
import com.alpha.jxust.constant.Constant;

/**
 * 校友查询的Fragment 
 * @author bing
 *
 */
public class SchoolfellowFragment extends BaseFragment 
{
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		View settingLayout = inflater.inflate(R.layout.layout_schoolfellow,container, false);
		return settingLayout;
	}
	
	public void onResume() 
	{
		super.onResume();
		MainActivity.currFragTag = Constant.FRAGMENT_FLAG_SCHOOLFELLOW;
	}
}
