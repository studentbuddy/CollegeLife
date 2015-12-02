package com.alpha.jxust.custom.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alpha.college.R;
import com.alpha.jxust.constant.Constant;

/**
 * 顶部控制面板
 * @author bing
 * 一个自定义的布局.布局中有两个TextView,一个在中间,一个在右边.
 */
public class HeadControlPanel extends RelativeLayout 
{
	// 接收添加此控件的上下文对象
	@SuppressWarnings("unused")
	private Context mContext;
	
	// 中间的TextView
	private TextView mMidleTitle;
	
	// 右边的TextView
	@SuppressWarnings("unused")
	private TextView mRightTitle;
	
	// 设置一下中间TextView默认字体大小
	private static final float middle_title_size = 20f; 
	
	// 设置一下右边TextView默认字体大小
	@SuppressWarnings("unused")
	private static final float right_title_size = 17f; 
	
	// 默认的背景颜色
	private static final int default_background_color = Color.rgb(21, 126, 203);

	// 构造函数
	public HeadControlPanel(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
	}

	// onFinishInflate 当View中所有的子控件均被映射成xml后触发
	// 简言之:inflate(Context context, int resource, ViewGroup root)方法执行后触发
	protected void onFinishInflate() 
	{
		// 对应的布局文件为head_panel_layout.xml
		mMidleTitle = (TextView)findViewById(R.id.midle_title);
		mRightTitle = (TextView)findViewById(R.id.right_title);
		setBackgroundColor(default_background_color);
	}
	
	// 初始化顶部标签
	public void initHeadPanel()
	{
		{
			setMiddleTitle(Constant.FRAGMENT_FLAG_NEWS);
		}
	}
	
	// 设置顶部便签中间的TextView的内容和字体大小
	public void setMiddleTitle(String s)
	{
		mMidleTitle.setText(s);
		mMidleTitle.setTextSize(middle_title_size);
	}
}
