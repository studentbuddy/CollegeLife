package com.alpha.jxust.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;

import com.alpha.college.R;
import com.alpha.jxust.constant.Constant;
import com.alpha.jxust.custom.ui.BottomControlPanel;
import com.alpha.jxust.custom.ui.BottomControlPanel.BottomPanelCallback;
import com.alpha.jxust.custom.ui.HeadControlPanel;
import com.alpha.jxust.fragment.BaseFragment;

/**
 * 主界面
 * @author bing
 * 实现了自定义的BottomControlPanel.BottomPanelCallback接口,
 * 用于监听BottomControlPanel的点击事件
 */
public class MainActivity extends Activity implements BottomPanelCallback 
{
	// 底部按钮控制面板
	BottomControlPanel bottomPanel = null;
	// 顶部控制面板
	HeadControlPanel headPanel = null;

	// FragmentManager能够实现管理activity中fragment
	private FragmentManager fragmentManager = null;
	// FragmentTransaction对fragment进行添加,移除,替换,以及执行其他动作.
	private FragmentTransaction fragmentTransaction = null;

	// 符号标识,标识当前是显示哪一个Fragment标签
	public static String currFragTag = "";
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 绑定布局文件,初始化控件,设置点击事件
		initUI();
		// 获取到fragmentManager管理对象
		fragmentManager = getFragmentManager();
		// 设置最开始显示的是新闻界面
		setDefaultFirstFragment(Constant.FRAGMENT_FLAG_NEWS);
	}

	// 初始化控件
	private void initUI()
	{
		bottomPanel = (BottomControlPanel)findViewById(R.id.bottom_layout);
		if(bottomPanel != null)
		{
			// 设置ImageText文本内容,设置ImageText为未选中状态,并设置好ImageText的点击事件
			bottomPanel.initBottomPanel();
			// 设置bottomPanel中BottomPanelCallback对象
			bottomPanel.setBottomCallback(this);
		}
		
		headPanel = (HeadControlPanel)findViewById(R.id.head_layout);
		if(headPanel != null)
		{
			headPanel.initHeadPanel();
		}
	}

	// BottomPanelCallback接口的抽象方法
	// 用于处理BottomControlPanel的点击事件
	public void onBottomPanelClick(int itemId) 
	{
		String tag = "";
		if((itemId & Constant.BTN_FLAG_NEWS) != 0)
		{
			tag = Constant.FRAGMENT_FLAG_NEWS;
		}
		else if((itemId & Constant.BTN_FLAG_SCHOOLFELLOW) != 0)
		{
			tag = Constant.FRAGMENT_FLAG_SCHOOLFELLOW;
		}
		else if((itemId & Constant.BTN_FLAG_TEXTBOOK) != 0)
		{
			tag = Constant.FRAGMENT_FLAG_TEXTBOOK;
		}
		else if((itemId & Constant.BTN_FLAG_MORE) != 0)
		{
			tag = Constant.FRAGMENT_FLAG_MORE;
		}
		
		// 中间帧布局切换Fragment
		setTabSelection(tag); 
		// 顶部控件切换标题 
		headPanel.setMiddleTitle(tag);
	}

	// 设置默认第一个Fragment
	private void setDefaultFirstFragment(String tag)
	{
		setTabSelection(tag);
		bottomPanel.defaultBtnChecked();
	}

	// 
	private void commitTransactions(String tag)
	{
		if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) 
		{
			fragmentTransaction.commit();
			currFragTag = tag;
			fragmentTransaction = null;
		}
	}

	private FragmentTransaction ensureTransaction( )
	{
		if(fragmentTransaction == null)
		{
			fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		}
		return fragmentTransaction;
	}

	private void attachFragment(int layout, Fragment f, String tag)
	{
		if(f != null)
		{
			if(f.isDetached())
			{
				ensureTransaction();
				fragmentTransaction.attach(f);
			}
			else if(!f.isAdded())
			{
				ensureTransaction();
				fragmentTransaction.add(layout, f, tag);
			}
		}
	}

	private Fragment getFragment(String tag)
	{
		Fragment f = fragmentManager.findFragmentByTag(tag);
		if(f == null)
		{
			f = BaseFragment.newInstance(getApplicationContext(), tag);
		}
		return f;
	}
	
	private void detachFragment(Fragment f)
	{
		if(f != null && !f.isDetached())
		{
			ensureTransaction();
			fragmentTransaction.detach(f);
		}
	}
	
	// 切换fragment 
	private  void switchFragment(String tag)
	{
		// 如果点击的就是当前界面的ImageText则不处理
		if(TextUtils.equals(tag, currFragTag))
		{
			return;
		}
		// 如果是其他的ImageText则把上一个fragment干掉
		if(currFragTag != null && !currFragTag.equals(""))
		{
			detachFragment(getFragment(currFragTag));
		}
		attachFragment(R.id.fragment_content, getFragment(tag), tag);
		commitTransactions(tag);
	} 

	/**
	 * 设置选中的Tag
	 */
	public  void setTabSelection(String tag) 
	{
		// 开启一个Fragment事务
		fragmentTransaction = fragmentManager.beginTransaction();
		switchFragment(tag);

	}

	protected void onStop() 
	{
		super.onStop();
		// 清空currFragTag标识
		currFragTag = "";
	}

	protected void onSaveInstanceState(Bundle outState) {}
}
