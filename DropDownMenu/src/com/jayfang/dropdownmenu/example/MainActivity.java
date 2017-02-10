//package com.jayfang.dropdownmenu.example;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import android.app.Activity;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//
//import com.jayfang.dropdownmenu.DropDownMenu;
//import com.jayfang.dropdownmenu.DropItemBean;
//import com.jayfang.dropdownmenu.MenuBean;
//import com.jayfang.dropdownmenu.OnMenuSelectedListener;
//
//
//public class MainActivity extends  Activity {
//
//    private DropDownMenu mMenu;
//    private List<DropItemBean> mMenuItems=new ArrayList<DropItemBean>();
//    private List<DropItemBean> mMenuMoreItems=new ArrayList<DropItemBean>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        mMenu=(DropDownMenu)findViewById(R.id.menu);
//        init();
//        
//        mMenu.setmMenuCount(mMenuItems.size());
//        mMenu.setmShowCount(6);
//        mMenu.setShowCheck(true);
//        mMenu.setmMenuTitleTextSize(16);
//        mMenu.setmMenuTitleTextColor(Color.parseColor("#777777"));
//        mMenu.setmMenuListTextSize(16);
//        mMenu.setmMenuListTextColor(Color.BLACK);
//        mMenu.setmMenuBackColor(Color.parseColor("#eeeeee"));
//        mMenu.setmMenuPressedBackColor(Color.WHITE);
//        mMenu.setmMenuPressedTitleTextColor(Color.BLACK);
//        mMenu.setmCheckIcon(R.drawable.ico_make);
//        mMenu.setmUpArrow(R.drawable.arrow_up);
//        mMenu.setmDownArrow(R.drawable.arrow_down);
//
//        mMenu.setShowDivider(false);
//        mMenu.setmMenuListBackColor(getResources().getColor(R.color.white));
//        mMenu.setmMenuListSelectorRes(R.color.white);
//        mMenu.setmArrowMarginTitle(20);
//
//        mMenu.setMenuSelectedListener(new OnMenuSelectedListener() {
//            @Override
//            public void onSelected(View listview, int RowIndex, int ColumnIndex) {
//                Log.i("MainActivity", "select " + ColumnIndex + " column and " + RowIndex + " row");
//            }
//        });
//        
//        mMenu.setmMenuMoreItems(mMenuMoreItems);
//        mMenu.setmMenuItems(mMenuItems);
//        mMenu.setIsDebug(false);
//    }
//	private void init() {
//		List<MenuBean> menulist;
//		List<MenuBean> menulistleft;
//		List<MenuBean> menulistright;
//		MenuBean mbean;
//		MenuBean mrbean;
//		DropItemBean dbean= new DropItemBean();
//		
//		menulist = new ArrayList<MenuBean>();
//		mbean = new MenuBean();
//		mbean.setMenuname("按月薪");
//		menulist.add(mbean);
//		
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("2k以下");
//		menulist.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("2k-5k");
//		menulist.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("5k-10k");
//		menulist.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("10k-15k");
//		menulist.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("15k-25k");
//		menulist.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("25k-50k");
//		menulist.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("50k以上");
//		menulist.add(mbean);
//		dbean.setMenulist(menulist);
//		mMenuItems.add(dbean);
//		
//        dbean= new DropItemBean();
//		menulist = new ArrayList<MenuBean>();
//		mbean = new MenuBean();
//		mbean.setMenuname("按职业性质");
//		menulist.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("全职");
//		menulist.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("兼职");
//		menulist.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("实习");
//		menulist.add(mbean);
//		dbean.setMenulist(menulist);
//		mMenuItems.add(dbean);
//		
//		
//		dbean= new DropItemBean();
//		menulistleft = new ArrayList<MenuBean>();
//		mbean = new MenuBean();
//		mbean.setMenuname("工作地点");
//		menulistright = new ArrayList<MenuBean>();
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("不限");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("北京");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("上海");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("南京");
//		menulistright.add(mrbean);
//		mbean.setRightlist(menulistright);
//		menulistleft.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("工作经验");
//		menulistright = new ArrayList<MenuBean>();
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("全部");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("应届毕业生");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("1-3年");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("3-5年");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("5-10年");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("10年以上");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("不限");
//		menulistright.add(mrbean);
//		mbean.setRightlist(menulistright);
//		menulistleft.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("学历要求");
//		menulistright = new ArrayList<MenuBean>();
//		mrbean = new MenuBean();
//		mrbean.setMenuname("全部");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("学历不限");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("大专");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("硕士");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("博士");
//		menulistright.add(mrbean);
//		mbean.setRightlist(menulistright);
//		menulistleft.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("融资阶段");
//		menulistright = new ArrayList<MenuBean>();
//		mrbean = new MenuBean();
//		mrbean.setMenuname("全部");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("未融资");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("天使轮");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("A轮");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("B轮");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("C轮");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("D轮及以上");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("上市公司");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("需要融资");
//		menulistright.add(mrbean);
//		mbean.setRightlist(menulistright);
//		menulistleft.add(mbean);
//		
//		mbean = new MenuBean();
//		mbean.setMenuname("所属行业");
//		menulistright = new ArrayList<MenuBean>();
//		mrbean = new MenuBean();
//		mrbean.setMenuname("全部");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("互联网");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("电子商务");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("游戏");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("文化娱乐");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("广告营销");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("软件");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("教育");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("硬件");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("艺术");
//		menulistright.add(mrbean);
//		
//		mrbean = new MenuBean();
//		mrbean.setMenuname("其他");
//		menulistright.add(mrbean);
//		mbean.setRightlist(menulistright);
//		menulistleft.add(mbean);
//		
//		dbean.setMenulist(menulistleft);
//		
//		mMenuMoreItems.add(dbean);
//		 
//	}
// 
// 
//}
