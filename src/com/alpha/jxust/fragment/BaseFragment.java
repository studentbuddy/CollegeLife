package com.alpha.jxust.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.text.TextUtils;

import com.alpha.jxust.constant.Constant;
/**
 * 自定义的Fragment的基类
 * @author bing
 *
 */
public class BaseFragment extends Fragment 
{
	@SuppressWarnings("unused")
	private static final String TAG = "BaseFragment";
	
	protected FragmentManager mFragmentManager = null;
	protected FragmentTransaction mFragmentTransaction = null;

	public static BaseFragment newInstance(Context context,String tag)
	{
		BaseFragment baseFragment =  null;
		if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_NEWS))
		{
			baseFragment = new NewsFragment();
		}
		else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_SCHOOLFELLOW))
		{
			baseFragment = new SchoolfellowFragment();
		}
		else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_TEXTBOOK))
		{
			baseFragment = new TextbookFragment();
		}
		else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_MORE))
		{
			baseFragment = new MoreFragment();
		}
		return baseFragment;
	}
}
