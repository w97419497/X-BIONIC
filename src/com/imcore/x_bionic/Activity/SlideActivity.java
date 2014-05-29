package com.imcore.x_bionic.Activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import com.imcore.x_bionic.R;
import com.imcore.x_bionic.Fragment.SlidFragment;

public class SlideActivity extends ActionBarActivity {

	private ViewPager viewpager;
	private ImageView btn1, btn2, btn3;
	private viewpagerAdapert adapert;

	private List<ImageView> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide);

		viewpager = (ViewPager) findViewById(R.id.view_pager);
		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.hide();

		getPicture();

		adapert = new viewpagerAdapert();
		viewpager.setAdapter(adapert);

		viewpager.setOnPageChangeListener(mViewPagerListener);
	}

	class viewpagerAdapert extends FragmentStatePagerAdapter {
		public viewpagerAdapert() {
			super(getSupportFragmentManager());
		}

		@Override
		public Fragment getItem(int position) {
			SlidFragment slid = new SlidFragment();
			Bundle b = new Bundle();
			b.putInt("position", position);
			slid.setArguments(b);
			return slid;
		}

		@Override
		public int getCount() {
			return 3;
		}
	}

	// ViewPagerÇÐ»»Ò³ÃæÊ±µÄ¼àÌýÆ÷
	private OnPageChangeListener mViewPagerListener = new OnPageChangeListener() {
		@Override
		public void onPageSelected(int position) {

			for (int i = 0; i < list.size(); i++) {

				if (position == i) {
					list.get(position).setBackgroundResource(
							R.drawable.whitepoint);
				} else {
					list.get(i).setBackgroundResource(R.drawable.no);
				}
			}

		}

		@Override
		public void onPageScrolled(int position, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int position) {
		}
	};

	private void getPicture() {
		list = new ArrayList<ImageView>();
		list.add((ImageView) findViewById(R.id.one));
		list.add((ImageView) findViewById(R.id.two));
		list.add((ImageView) findViewById(R.id.three));

	}

}
