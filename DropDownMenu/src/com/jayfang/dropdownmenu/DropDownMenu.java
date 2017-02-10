package com.jayfang.dropdownmenu;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jayfang.dropdownmenu.example.R;

/**
 * 
 * <a href="http://fangjie.info">JayFang</a> Email:JayFang1993@gmail.com
 * GitHub:github.com/JayFang1993
 * 
 */
public class DropDownMenu extends LinearLayout {

	// Menu 展开的ListView 的 adapter
	private List<MenuListAdapter> mMenuAdapters = new ArrayList<MenuListAdapter>();

	// Menu 展开的 list item
	private List<DropItemBean> mMenuItems = new ArrayList<DropItemBean>();

	// Menu 展开的 list item
	private List<DropItemBean> mMenuMoreItems = new ArrayList<DropItemBean>();
	private ListView mMenuLeftList;
	private ListView mMenuRightList;
	// Menu 展开的ListView 的 adapter
	private List<MenuListAdapter> mMenuLeftAdapters = new ArrayList<MenuListAdapter>();
	// Menu 展开的ListView 的 adapter
	private List<MenuListAdapter> mMenuRightAdapters = new ArrayList<MenuListAdapter>();

	// 菜单 上的文字
	private List<TextView> mTvMenuTitles = new ArrayList<TextView>();
	// 菜单 的背景布局
	private List<RelativeLayout> mRlMenuBacks = new ArrayList<RelativeLayout>();
	// 菜单 的箭头
	private List<ImageView> mIvMenuArrow = new ArrayList<ImageView>();
	
	private List<ImageView> mIvMenuMoreArrow = new ArrayList<ImageView>();

	private Context mContext;

	private PopupWindow mPopupWindow;

	// Menu 展开的ListView
	private ListView mMenuList;
	// Menu 展开的ListView 下部的阴影
	private RelativeLayout mRlShadow;

	// 监听器
	private OnMenuSelectedListener mMenuSelectedListener;

	// 主Menu的个数
	private int mMenuCount;
	// Menu 展开的list 显示数量
	private int mShowCount;

	// 选中行数
	private int mRowSelected = 0;
	// 选中列数
	private int mColumnSelected = 0;

	// Menu的字体颜色
	private int mMenuTitleTextColor;
	// Menu的字体大小
	private int mMenuTitleTextSize;
	// Menu的按下的字体颜色
	private int mMenuPressedTitleTextColor;
	// Menu的按下背景
	private int mMenuPressedBackColor;
	// Menu的背景
	private int mMenuBackColor;
	// Menu list 的字体大小
	private int mMenuListTextSize;
	// Menu list 的字体颜色
	private int mMenuListTextColor;
	// 是否显示选中的对勾
	private boolean mShowCheck;
	// 是否现实列表的分割线
	private boolean mShowDivider;
	// 列表的背景
	private int mMenuListBackColor;
	// 列表的按下效果
	private int mMenuListSelectorRes;
	// 箭头距离
	private int mArrowMarginTitle;

	// 对勾的图片资源
	private int mCheckIcon;
	// 向上的箭头图片资源
	private int mUpArrow;
	// 向下的箭头图片资源
	private int mDownArrow;

	private boolean mDrawable = false;

	private String[] mDefaultMenuTitle;

	private boolean isDebug = true;

	public DropDownMenu(Context mContext) {
		super(mContext);
		init(mContext);

	}

	public DropDownMenu(Context mContext, AttributeSet attrs) {
		super(mContext, attrs);
		init(mContext);
	}

	private void init(Context mContext) {
		this.mContext = mContext;
		View popWindows = LayoutInflater.from(mContext).inflate(R.layout.popupwindow_menu, null);
		mPopupWindow = new PopupWindow(popWindows, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
		mMenuList = (ListView) popWindows.findViewById(R.id.lv_menu);
		mRlShadow = (RelativeLayout) popWindows.findViewById(R.id.rl_menu_shadow);

		mMenuLeftList = (ListView) popWindows.findViewById(R.id.lv_menu_left);
		mMenuRightList = (ListView) popWindows.findViewById(R.id.lv_menu_right);

		mMenuCount = 2;
		mShowCount = 5;
		mMenuTitleTextColor = getResources().getColor(R.color.default_menu_text);
		mMenuPressedBackColor = getResources().getColor(R.color.default_menu_press_back);
		mMenuPressedTitleTextColor = getResources().getColor(R.color.default_menu_press_text);
		mMenuBackColor = getResources().getColor(R.color.default_menu_back);
		mMenuListBackColor = getResources().getColor(R.color.white);
		mMenuListSelectorRes = getResources().getColor(R.color.white);
		mMenuTitleTextSize = 18;
		mArrowMarginTitle = 10;
		mShowCheck = true;
		mShowDivider = true;
		mCheckIcon = R.drawable.ico_make;
		mUpArrow = R.drawable.arrow_up;
		mDownArrow = R.drawable.arrow_down;

	}

	// 设置 Menu的item
	public void setmMenuItems(List<DropItemBean> menuItems) {
		mMenuItems = menuItems;
		mDrawable = true;
		invalidate();
	}

	public void setmMenuMoreItems(List<DropItemBean> mMenuMoreItems) {
		this.mMenuMoreItems = mMenuMoreItems;
	}

	// 设置 Menu的数量
	public void setmMenuCount(int menuCount) {
		mMenuCount = menuCount;
	}

	public void setShowDivider(boolean mShowDivider) {
		this.mShowDivider = mShowDivider;
	}

	public void setmMenuListBackColor(int menuListBackColor) {
		mMenuListBackColor = menuListBackColor;
	}

	public void setmMenuListSelectorRes(int menuListSelectorRes) {
		mMenuListSelectorRes = menuListSelectorRes;
	}

	public void setmArrowMarginTitle(int arrowMarginTitle) {
		mArrowMarginTitle = arrowMarginTitle;
	}

	public void setmMenuPressedTitleTextColor(int menuPressedTitleTextColor) {
		mMenuPressedTitleTextColor = menuPressedTitleTextColor;
	}

	public void setDefaultMenuTitle(String[] mDefaultMenuTitle) {
		this.mDefaultMenuTitle = mDefaultMenuTitle;
	}

	public void setIsDebug(boolean isDebug) {
		this.isDebug = isDebug;
	}

	// 设置 show 数量
	public void setmShowCount(int showCount) {
		mShowCount = showCount;
	}

	// 设置 Menu的字体颜色
	public void setmMenuTitleTextColor(int menuTitleTextColor) {
		mMenuTitleTextColor = menuTitleTextColor;
	}

	// 设置 Menu的字体大小
	public void setmMenuTitleTextSize(int menuTitleTextSize) {
		mMenuTitleTextSize = menuTitleTextSize;
	}

	// 设置Menu的背景色
	public void setmMenuBackColor(int menuBackColor) {
		mMenuBackColor = menuBackColor;
	}

	// 设置Menu的按下背景色
	public void setmMenuPressedBackColor(int menuPressedBackColor) {
		mMenuPressedBackColor = menuPressedBackColor;
	}

	// 设置Menu list的字体颜色
	public void setmMenuListTextColor(int menuListTextColor) {
		mMenuListTextColor = menuListTextColor;
		for (int i = 0; i < mMenuAdapters.size(); i++) {
			mMenuAdapters.get(i).setTextColor(mMenuListTextColor);
		}
	}

	// 设置Menu list的字体大小
	public void setmMenuListTextSize(int menuListTextSize) {
		mMenuListTextSize = menuListTextSize;
		for (int i = 0; i < mMenuAdapters.size(); i++) {
			mMenuAdapters.get(i).setTextSize(menuListTextSize);
		}
	}

	// 设置是否显示对勾
	public void setShowCheck(boolean mShowCheck) {
		this.mShowCheck = mShowCheck;
	}

	// 设置对勾的icon
	public void setmCheckIcon(int checkIcon) {
		mCheckIcon = checkIcon;
	}

	public void setmUpArrow(int upArrow) {
		mUpArrow = upArrow;
	}

	public void setmDownArrow(int downArrow) {
		mDownArrow = downArrow;
	}

	public void setMenuSelectedListener(OnMenuSelectedListener menuSelectedListener) {
		mMenuSelectedListener = menuSelectedListener;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (mDrawable) {
			mPopupWindow.setTouchable(true);
			mPopupWindow.setOutsideTouchable(true);
			mPopupWindow.setBackgroundDrawable(new BitmapDrawable());

			mRlShadow.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mPopupWindow.dismiss();
				}
			});

			mMenuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					mPopupWindow.dismiss();
					mRowSelected = position;

					mTvMenuTitles.get(mColumnSelected).setText(mMenuItems.get(mColumnSelected).getMenulist().get(mRowSelected).getMenuname());
					mIvMenuArrow.get(mColumnSelected).setImageResource(mDownArrow);
					mMenuAdapters.get(mColumnSelected).setSelectIndex(mRowSelected);
					if (mMenuSelectedListener == null && isDebug)
						Toast.makeText(mContext, "MenuSelectedListener is  null", Toast.LENGTH_LONG).show();
					else
						mMenuSelectedListener.onSelected(view, mRowSelected, mColumnSelected);
				}
			});
			
			mMenuRightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					mRowSelected = position;
					mIvMenuMoreArrow.get(mColumnSelected).setImageResource(mDownArrow);
					mMenuRightAdapters.get(mColumnSelected).setSelectIndex(mRowSelected);
					mMenuRightAdapters.get(mColumnSelected).notifyDataSetChanged();
					if (mMenuSelectedListener == null && isDebug)
						Toast.makeText(mContext, "MenuSelectedListener is  null", Toast.LENGTH_LONG).show();
					else
						mMenuSelectedListener.onSelected(view, mRowSelected, mColumnSelected);
				}
			});
			
			mMenuLeftList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					mColumnSelected =  position;
					mRowSelected = 0;
					mMenuRightList.setAdapter(mMenuRightAdapters.get((int)id));
					if (!mShowDivider)
						mMenuRightList.setDivider(null);
					mMenuRightList.setBackgroundColor(mMenuListBackColor);
					
					if (mMenuSelectedListener == null && isDebug)
						Toast.makeText(mContext, "MenuSelectedListener is  null", Toast.LENGTH_LONG).show();
					else
						mMenuSelectedListener.onSelected(view, mRowSelected, mColumnSelected);
				}
			});

			mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
				@Override
				public void onDismiss() {
					for (int i = 0; i < mMenuCount; i++) {
						mIvMenuArrow.get(i).setImageResource(mDownArrow);
						mRlMenuBacks.get(i).setBackgroundColor(mMenuBackColor);
						mTvMenuTitles.get(i).setTextColor(mMenuTitleTextColor);
					}
				}
			});

			if (mMenuItems.size() != mMenuCount) {
				if (isDebug)
					Toast.makeText(mContext, "Menu item is not setted or incorrect", Toast.LENGTH_LONG).show();
				return;
			}

			int mMenuMaxCount = mMenuCount;
			if (mMenuMoreItems != null && mMenuMoreItems.size() > 0) {
				mMenuMaxCount = mMenuMaxCount + 1;
			}

			if (mMenuAdapters.size() == 0) {
				for (int i = 0; i < mMenuCount; i++) {
					MenuListAdapter adapter = new MenuListAdapter(mContext, mMenuItems.get(i).getMenulist());
					adapter.setShowCheck(mShowCheck);
					adapter.setCheckIcon(mCheckIcon);
					mMenuAdapters.add(adapter);
				}
			} else if (mMenuAdapters.size() != mMenuCount) {
				if (isDebug)
					Toast.makeText(mContext, "If you want set Adapter by yourself,please ensure the number of adpaters equal mMenuCount", Toast.LENGTH_LONG).show();
				return;
			}

			if(mMenuMoreItems!=null && mMenuMoreItems.size()>0){
				if (mMenuLeftAdapters.size() == 0 ) {
					MenuListAdapter adapter = new MenuListAdapter(mContext, mMenuMoreItems.get(0).getMenulist());
					mMenuLeftAdapters.add(adapter);
					
					for(int i=0;i<mMenuMoreItems.get(0).getMenulist().size();i++){
						MenuBean mMenuBean = mMenuMoreItems.get(0).getMenulist().get(i);
						MenuListAdapter radapter = new MenuListAdapter(mContext, mMenuBean.getRightlist());
						radapter.setShowCheck(mShowCheck);
						radapter.setCheckIcon(mCheckIcon);
						mMenuRightAdapters.add(radapter);
						
					}
				} else if (mMenuLeftAdapters.size() != 	1) {
					if (isDebug)
						Toast.makeText(mContext, "If you want set Adapter by yourself,please ensure the number of adpaters equal mMenuCount", Toast.LENGTH_LONG).show();
					return;
				}
			}
			

			int width = getWidth();

			for (int i = 0; i < mMenuMaxCount; i++) {
				final RelativeLayout v = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.menu_item, null, false);
				RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(width / mMenuMaxCount, LayoutParams.WRAP_CONTENT);
				v.setLayoutParams(parms);
				TextView tv = (TextView) v.findViewById(R.id.tv_menu_title);
				tv.setTextColor(mMenuTitleTextColor);
				tv.setTextSize(mMenuTitleTextSize);
				if (mDefaultMenuTitle == null || mDefaultMenuTitle.length == 0) {
					if (i == mMenuCount) {
						tv.setText("更多");
					} else {
						tv.setText(mMenuItems.get(i).getMenulist().get(0).getMenuname());
					}
				} else {
					tv.setText(mDefaultMenuTitle[i]);
				}
				this.addView(v, i);
				mTvMenuTitles.add(tv);

				RelativeLayout rl = (RelativeLayout) v.findViewById(R.id.rl_menu_head);
				rl.setBackgroundColor(mMenuBackColor);
				mRlMenuBacks.add(rl);

				ImageView iv = (ImageView) v.findViewById(R.id.iv_menu_arrow);
				if(i==mMenuCount){
					for(int j=0;j<mMenuMoreItems.get(0).getMenulist().size();j++){
						mIvMenuMoreArrow.add(iv);
						mIvMenuMoreArrow.get(j).setImageResource(mDownArrow);
					}
				}else{
					mIvMenuArrow.add(iv);
					mIvMenuArrow.get(i).setImageResource(mDownArrow);
				}
				

				RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iv.getLayoutParams();
				params.leftMargin = mArrowMarginTitle;
				iv.setLayoutParams(params);

				final int index = i;

				v.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View view) {
						if (index < mMenuCount) {
							mMenuList.setVisibility(View.VISIBLE);
							mRlShadow.setVisibility(View.VISIBLE);
							mMenuLeftList.setVisibility(View.GONE);
							mMenuRightList.setVisibility(View.GONE);
							
							mMenuList.setAdapter(mMenuAdapters.get(index));
							if (mMenuAdapters.get(index).getCount() > mShowCount) {
								View childView = mMenuAdapters.get(index).getView(0, null, mMenuList);
								childView.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
								RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, childView.getMeasuredHeight() * mShowCount);
								mMenuList.setLayoutParams(parms);
							} else {
								View childView = mMenuAdapters.get(index).getView(0, null, mMenuList);
								childView.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
								RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
								mMenuList.setLayoutParams(parms);
							}
							if (!mShowDivider)
								mMenuList.setDivider(null);
							mMenuList.setBackgroundColor(mMenuListBackColor);
							// mMenuList.setSelector(mMenuListSelectorRes);
							mColumnSelected = index;
							mTvMenuTitles.get(index).setTextColor(mMenuPressedTitleTextColor);
							mRlMenuBacks.get(index).setBackgroundColor(mMenuPressedBackColor);
							mIvMenuArrow.get(index).setImageResource(mUpArrow);
							mPopupWindow.showAsDropDown(v);
						} else {
							mMenuList.setVisibility(View.GONE);
							mRlShadow.setVisibility(View.GONE);
							mMenuLeftList.setVisibility(View.VISIBLE);
							mMenuRightList.setVisibility(View.VISIBLE);
							
							mMenuLeftList.setAdapter(mMenuLeftAdapters.get(0));
							if (!mShowDivider)
								mMenuLeftList.setDivider(null);
							mMenuLeftList.setBackgroundColor(mMenuListBackColor);
							
							mMenuRightList.setAdapter(mMenuRightAdapters.get(0));
							if (!mShowDivider)
								mMenuRightList.setDivider(null);
							mMenuRightList.setBackgroundColor(mMenuListBackColor);
							mPopupWindow.showAsDropDown(v);
						}
					}
				});
			}

			mDrawable = false;
		}
	}

	public void setDefault(int mColumnSelected, int mRowSelected) {
		mTvMenuTitles.get(mColumnSelected).setText(mMenuItems.get(mColumnSelected).getMenulist().get(mRowSelected).getMenuname());
		mIvMenuArrow.get(mColumnSelected).setImageResource(mDownArrow);
		mMenuAdapters.get(mColumnSelected).setSelectIndex(mRowSelected);
	}

}
