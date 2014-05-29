package com.imcore.x_bionic.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.imcore.x_bionic.R;
import com.imcore.x_bionic.Activity.ProductMainActivity;

public class SideFragment extends Fragment implements OnClickListener {
	private ImageView home_page_1, home_page_2, home_page_3, home_page_4;

	Fragment fagment = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.side_fragmnt, null);

		home_page_1 = (ImageView) view.findViewById(R.id.home_page_1);
		home_page_2 = (ImageView) view.findViewById(R.id.home_page_2);
		home_page_3 = (ImageView) view.findViewById(R.id.home_page_3);
		home_page_4 = (ImageView) view.findViewById(R.id.home_page_4);

		home_page_1.setOnClickListener(this);
		home_page_2.setOnClickListener(this);
		home_page_3.setOnClickListener(this);
		home_page_4.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {

		Intent intent = null;

		switch (v.getId()) {

		case R.id.home_page_1:
			intent = new Intent(getActivity(), ProductMainActivity.class);

			startActivity(intent);

			break;
		case R.id.home_page_2:

			break;
		case R.id.home_page_3:

			break;
		case R.id.home_page_4:

			break;

		default:
			break;
		}

	}

}
