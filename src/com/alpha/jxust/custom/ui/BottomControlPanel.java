package com.alpha.jxust.custom.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

import com.alpha.college.R;
import com.alpha.jxust.constant.Constant;

/**
 * 自定义布局:底部按钮控制面板
 * @author bing
 */
public class BottomControlPanel extends RelativeLayout implements OnClickListener 
{
	// 接收添加此控件的上下文对象,暂时没有用到
	@SuppressWarnings("unused")
	private Context mContext;

	private ImageText mNewBtn = null;
	private ImageText mSchoolFellowBtn = null;
	private ImageText mTxetBookBtn = null;
	private ImageText mMoreBtn = null;

	// 默认的背景颜色
	private int DEFALUT_BACKGROUND_COLOR = Color.rgb(243, 243, 243);

	// 内部接口BottomPanelCallback对象
	private BottomPanelCallback mBottomCallback = null;

	// 存放自定义按钮ImageText的容器
	private List<ImageText> viewList = new ArrayList<ImageText>();

	// 内部接口,实现BottomPanelCallback点击事件监听
	public interface BottomPanelCallback
	{
		public void onBottomPanelClick(int itemId);
	}

	// 构造函数
	public BottomControlPanel(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
	}

	protected void onFinishInflate() 
	{
		// 找到布局对应的控件,布局文件为bottom_panel_layout.xml
		mNewBtn = (ImageText)findViewById(R.id.btn_news);
		mSchoolFellowBtn = (ImageText)findViewById(R.id.btn_school_fellow);
		mTxetBookBtn = (ImageText)findViewById(R.id.btn_textbook);
		mMoreBtn = (ImageText)findViewById(R.id.btn_more);

		// 设置默认的默认的背景颜色
		setBackgroundColor(DEFALUT_BACKGROUND_COLOR);

		// 将ImageText加入BottomControlPanel中
		viewList.add(mNewBtn);
		viewList.add(mSchoolFellowBtn);
		viewList.add(mTxetBookBtn);
		viewList.add(mMoreBtn);
	}

	// 初始化BottomControlPanel控件
	public void initBottomPanel()
	{
		if(mNewBtn != null)
		{
			mNewBtn.setImage(R.drawable.news_unselected);
			mNewBtn.setText("新闻");
		}
		if(mSchoolFellowBtn != null)
		{
			mSchoolFellowBtn.setImage(R.drawable.school_fellow_unselected);
			mSchoolFellowBtn.setText("校友");
		}
		if(mTxetBookBtn != null)
		{
			mTxetBookBtn.setImage(R.drawable.textbook_unselected);
			mTxetBookBtn.setText("教材");
		}
		if(mMoreBtn != null)
		{
			mMoreBtn.setImage(R.drawable.more_unselected);
			mMoreBtn.setText("更多");
		}

		// 为自定的ImageText设置事件监听器
		setBtnListener();
	}
	
	// 为BottomControlPanel布局中的四个ImageText子控件设置点击事件
	private void setBtnListener()
	{
		// num记录当前ViewGroup中ImageText的个数
		int num = this.getChildCount();
		for(int i = 0; i < num; i++)
		{
			View v = getChildAt(i);
			if(v != null)
			{
				v.setOnClickListener(this);
			}
		}
	}

	// 
	public void setBottomCallback(BottomPanelCallback bottomCallback)
	{
		mBottomCallback = bottomCallback;
	}

	// OnClickListener接口的抽象方法
	public void onClick(View v) 
	{
		// 初始化BottomControlPanel,设置为未选中状态
		initBottomPanel();

		// 记录是哪一个ImageText点击了
		int index = -1;

		switch(v.getId())
		{
		case R.id.btn_news:
			index = Constant.BTN_FLAG_NEWS;
			mNewBtn.setChecked(Constant.BTN_FLAG_NEWS);
			break;
		case R.id.btn_school_fellow:
			index = Constant.BTN_FLAG_SCHOOLFELLOW;
			mSchoolFellowBtn.setChecked(Constant.BTN_FLAG_SCHOOLFELLOW);
			break;
		case R.id.btn_textbook:
			index = Constant.BTN_FLAG_TEXTBOOK;
			mTxetBookBtn.setChecked(Constant.BTN_FLAG_TEXTBOOK);
			break;
		case R.id.btn_more:
			index = Constant.BTN_FLAG_MORE;
			mMoreBtn.setChecked(Constant.BTN_FLAG_MORE);
			break;
		default:break;
		}

		if(mBottomCallback != null)
		{
			mBottomCallback.onBottomPanelClick(index);
		}
	}

	public void defaultBtnChecked()
	{
		if(mNewBtn != null)
		{
			mNewBtn.setChecked(Constant.BTN_FLAG_NEWS);
		}
	}

	protected void onLayout(boolean changed, int left, int top, int right, int bottom) 
	{
		super.onLayout(changed, left, top, right, bottom);
		layoutItems(left, top, right, bottom);
	}

	// 最左边和最右边的view由母布局的padding进行控制位置。这里需对第2、3个view的位置重新设置
	private void layoutItems(int left, int top, int right, int bottom)
	{
		int n = getChildCount();
		
		if(n == 0)
		{
			return;
		}
		
		int paddingLeft = getPaddingLeft();
		int paddingRight = getPaddingRight();
		int width = right - left;
		@SuppressWarnings("unused")
		int height = bottom - top;
		int allViewWidth = 0;
		for(int i = 0; i< n; i++){
			View v = getChildAt(i);
			allViewWidth += v.getWidth();
		}
		int blankWidth = (width - allViewWidth - paddingLeft - paddingRight) / (n - 1);

		LayoutParams params1 = (LayoutParams) viewList.get(1).getLayoutParams();
		params1.leftMargin = blankWidth;
		viewList.get(1).setLayoutParams(params1);

		LayoutParams params2 = (LayoutParams) viewList.get(2).getLayoutParams();
		params2.leftMargin = blankWidth;
		viewList.get(2).setLayoutParams(params2);
	}
}
