package com.jayfang.dropdownmenu.example;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jayfang.dropdownmenu.DropDownMenu;
import com.jayfang.dropdownmenu.OnMenuSelectedListener;
import com.jayfang.dropdownmenu.R;

public class MainActivity extends Activity {

	private DropDownMenu mMenu;
	private ListView mList;

	private int city_index;
	private int sex_index;
	private int age_index;
	private List<String> data;
	String[] arr1 = new String[] { "类型", "全部", "动作", "冒险", "喜剧" };
	String[] arr2 = new String[] { "地区", "全部", "内地", "香港", "台湾" };
	String[] arr3 = new String[] { "年份", "全部", "2016", "2015", "2014",
			"2013-2011", "2010-2006", "2005-2000" };
	String[] arr4 = new String[] { "剧情看点", "全部", "青春校园", "失恋自愈", "肌肉硬汉" };
	String[] arr5 = new String[] { "分类", "全部", "微电影", "预告片", "电影特辑" };
	String[] arr6 = new String[] { "资费", "全部", "免费", "会员" };
	String[] arr7 = new String[] { "清晰度", "全部", "1080p" };
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == 1) {
				List<String[]> items = new ArrayList<String[]>();
				String[] arr1 = new String[] { "类型", "全部", "动作", "冒险", "喜剧" };
				String[] arr2 = new String[] { "地区", "全部", "内地", "香港", "台湾" };
				String[] arr3 = new String[] { "年份", "全部", "2016", "2015",
						"2014", "2013-2011", "2010-2006", "2005-2000" };
				String[] arr4 = new String[] { "剧情看点", "全部", "青春校园", "失恋自愈",
						"肌肉硬汉" };
				String[] arr5 = new String[] { "分类", "全部", "微电影", "预告片", "电影特辑" };
				String[] arr6 = new String[] { "资费", "全部", "免费", "会员" };
				String[] arr7 = new String[] { "清晰度", "全部", "1080p" };
				items.add(arr1);
				items.add(arr2);
				items.add(arr3);
				items.add(arr4);
				items.add(arr5);
				items.add(arr6);
				items.add(arr7);

				int column = mMenu.getColumnSelected();
				mMenu.setMenuItems(items);
				mMenu.setIsrefresh(true);
				mMenu.invalidate();

			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mMenu = (DropDownMenu) findViewById(R.id.menu);
		mMenu.setMenuCount(7);
		mMenu.setShowCount(6);
		mMenu.setShowCheck(true);
		mMenu.setMenuTitleTextSize(16);
		mMenu.setMenuTitleTextColor(Color.BLACK);
		mMenu.setMenuListTextSize(16);
		mMenu.setMenuListTextColor(Color.BLACK);
		mMenu.setMenuBackColor(0x2ac291);
		mMenu.setMenuPressedBackColor(0x2ac291);

		mMenu.setCheckIcon(R.drawable.ico_make);

		mMenu.setUpArrow(R.drawable.arrow_up);
		mMenu.setDownArrow(R.drawable.arrow_down);

		List<String[]> items = new ArrayList<String[]>();
		items.add(arr1);
		items.add(arr2);
		items.add(arr3);
		items.add(arr4);
		items.add(arr5);
		items.add(arr6);
		items.add(arr7);
		mMenu.setMenuItems(items);
		mMenu.setMenuSelectedListener(new OnMenuSelectedListener() {
			@Override
			public void onSelected(View listview, int RowIndex, int ColumnIndex) {
				Log.i("MainActivity", "select " + ColumnIndex + " column and "
						+ RowIndex + " row");
				if (ColumnIndex == 0) {
					city_index = RowIndex;
				} else if (ColumnIndex == 1) {
					sex_index = RowIndex;
				} else {
					age_index = RowIndex;
				}
				// 过滤筛选
				setFilter();
			}
		});

		mList = (ListView) findViewById(R.id.lv_list);
		data = getData();
		mList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, data));

		handler.sendEmptyMessage(1);

	}

	private void setFilter() {
		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < getData().size(); i++) {
			boolean city = ((city_index == 0) ? true : data.get(i).contains(
					arr1[city_index]));
			boolean sex = ((sex_index == 0) ? true : data.get(i).contains(
					arr2[sex_index]));
			boolean age = ((age_index == 0) ? true : data.get(i).contains(
					arr3[age_index]));
			if (city && sex && age) {
				temp.add(data.get(i));
			}
		}
		mList.setAdapter(new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_expandable_list_item_1, temp));
	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		data.add("上海-上海-上海-上海-上海－男－10");
		return data;
	}

}
