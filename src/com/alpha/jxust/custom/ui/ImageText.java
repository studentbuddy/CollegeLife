package com.alpha.jxust.custom.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alpha.college.R;
import com.alpha.jxust.constant.Constant;

/**
 * 自定义的按钮控件
 * @author bing
 * 上面一个ImageView下面一个TextView
 */
public class ImageText extends LinearLayout
{
	// 接收添加此控件的上下文对象
	private Context mContext = null;
	
	// 按钮里面上面一个ImageView下面一个TextView
	private ImageView mImageView = null;
	private TextView mTextView = null;
	
	// 记录按钮中ImageView默认的宽高
	private final static int DEFAULT_IMAGE_WIDTH = 64;
	private final static int DEFAULT_IMAGE_HEIGHT = 64;
	
	// 选中和未选中状态下的颜色值
	private int CHECKED_COLOR = Color.rgb(29, 118, 199);
	private int UNCHECKED_COLOR = Color.GRAY;
	
	// 构造函数
	public ImageText(Context context) 
	{
		super(context);
		mContext = context;
	}

	// 构造函数
	@SuppressWarnings("unused")
	public ImageText(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		mContext = context;
		
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View parentView = inflater.inflate(R.layout.image_text_layout, this, true);
		
		// 取出布局文件中的ImageView和TextView
		mImageView = (ImageView)findViewById(R.id.image_iamge_text);
		mTextView = (TextView)findViewById(R.id.text_iamge_text);
	}

	// 根据资源ID设置ImageView的内容
	public void setImage(int id)
	{
		if(mImageView != null)
		{
			mImageView.setImageResource(id);
			// 尺寸为默认值
			setImageSize(DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
		}
	}

	// 设置TextView文本内容
	public void setText(String s)
	{
		if(mTextView != null)
		{
			mTextView.setText(s);
			// 当前未选中,所以显示未选中状态下的颜色
			mTextView.setTextColor(UNCHECKED_COLOR);
		}
	}

	// 处理触摸事件拦截情况,放出当前焦点
	public boolean onInterceptTouchEvent(MotionEvent ev) 
	{
		return true;
	}
	
	// 设置ImageView尺寸
	private void setImageSize(int w, int h)
	{
		if(mImageView != null)
		{
			ViewGroup.LayoutParams params = mImageView.getLayoutParams();
			params.width = w;
			params.height = h;
			mImageView.setLayoutParams(params);
		}
	}
	
	// 根据点击的按钮的ID将ImageText按钮设置为选中状态
	public void setChecked(int itemID)
	{
		if(mTextView != null)
		{
			mTextView.setTextColor(CHECKED_COLOR);
		}

		int checkDrawableId = -1;

		switch (itemID)
		{
		case Constant.BTN_FLAG_NEWS:
			checkDrawableId = R.drawable.news_selected;
			break;
		case Constant.BTN_FLAG_SCHOOLFELLOW:
			checkDrawableId = R.drawable.school_fellow_selected;
			break;
		case Constant.BTN_FLAG_TEXTBOOK:
			checkDrawableId = R.drawable.textbook_selected;
			break;
		case Constant.BTN_FLAG_MORE:
			checkDrawableId = R.drawable.more_selected;
			break;
		default:break;
		}
		
		if(mImageView != null)
		{
			mImageView.setImageResource(checkDrawableId);
		}
	}
}
