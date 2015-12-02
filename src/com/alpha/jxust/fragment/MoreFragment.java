package com.alpha.jxust.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alpha.college.R;
import com.alpha.jxust.activity.MainActivity;
import com.alpha.jxust.constant.Constant;

/**
 * 更多的Fragment
 * @author bing
 *
 */
public class MoreFragment extends BaseFragment 
{
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		View contactsLayout = inflater.inflate(R.layout.layout_more,container, false);
		return contactsLayout;
	}
	
	public void onResume() 
	{
		super.onResume();
		MainActivity.currFragTag = Constant.FRAGMENT_FLAG_MORE;
	}
}
