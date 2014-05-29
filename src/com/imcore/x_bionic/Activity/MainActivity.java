package com.imcore.x_bionic.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.imcore.x_bionic.R;
import com.imcore.x_bionic.Fragment.OneFragment;
import com.imcore.x_bionic.Fragment.SideFragment;
import com.imcore.x_bionic.Fragment.SlidFragment;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private ListView mListView;
	private ImageView side_image, side_sreach;
	private TextView title;
	private String[] mStringItem;
	private List<String> list;
	private CharSequence mDSequenceTitle;
	private CharSequence mTitle;
	Fragment fagment = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		side_image = (ImageView) findViewById(R.id.side_image);
		side_sreach = (ImageView) findViewById(R.id.side_serech);

		title = (TextView) findViewById(R.id.home_page_title);

		side_image.setOnClickListener(this);

		Log.i("111", "1111");

		side_sreach.setOnClickListener(this);

		initDrawerLayout();
		ActionBar bar = getSupportActionBar();
		bar.hide();
		fagment = new SideFragment();
		getfragment(fagment);

	}

	private void initDrawerLayout() {
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);
		getListResouse();
		mListView = (ListView) findViewById(R.id.left_drawer);

		// View view = getLayoutInflater().inflate(R.layout.heard_picture,
		// null);
		// mDrawerLayout.addView(view);

		mListView.setAdapter(new listAdapter());
		mListView.setOnItemClickListener(new NaviDrawerListener());
		initialDrawerListener();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

	}

	// 适配器
	class listAdapter extends BaseAdapter {
		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View context, ViewGroup arg2) {
			View view = context;
			ViewHolder hoder = null;
			if (view == null) {
				view = getLayoutInflater().inflate(R.layout.list_view_iteam,
						null);
				hoder = new ViewHolder();
				hoder.Title = (TextView) view
						.findViewById(R.id.list_item_title);
				view.setTag(hoder);
			} else {

				hoder = (ViewHolder) view.getTag();
			}

			String title = list.get(position);
			hoder.Title.setText(title);
			return view;
		}
		private class ViewHolder {
			TextView Title;
		}

	}

	// 给list添加数据
	private List<String> getListResouse() {
		list = new ArrayList<String>();
		list.add("您的订购");
		list.add("帐户设置");
		list.add("达人申请");
		list.add("部落社区");
		list.add("购物车");
		list.add("订阅信息");
		list.add("分享设置");
		return list;
	}

	private void initialDrawerListener() {
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_launcher, R.string.drawer_open,
				R.string.drawer_close) {

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
			}

		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}
	// d对listview监听
	private class NaviDrawerListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> arg0, View view, int position,
				long arg3) {
			selectNavitiItem(position);

		}

	}

	private void selectNavitiItem(int position) {
		switch (position) {
		case 0:
			fagment = new OneFragment();
			break;
		case 1:
			fagment = new OneFragment();
			break;
		case 2:
			fagment = new OneFragment();
			break;
		case 3:
			fagment = new OneFragment();
			break;
		}

		getfragment(fagment, position);

	}


	
	private void getfragment(Fragment fagment) {
		android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager()
				.beginTransaction();
		ft.replace(R.id.main_content, fagment);
		ft.commit();
	}

	// 加载不同的Fragment
	private void getfragment(Fragment fagment2, int position) {
		android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager()
				.beginTransaction();
		ft.replace(R.id.main_content, fagment);
		ft.commit();
		mListView.setItemChecked(position, true);
		mDrawerLayout.closeDrawer(mListView);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.side_image:
			mDrawerLayout.openDrawer(mListView);
			break;
		case R.id.side_serech:

			Intent intent = new Intent(this, SearchActivity.class);

			startActivity(intent);
			break;
		default:
			break;
		}

	}

}
