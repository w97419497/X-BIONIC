package com.imcore.x_bionic.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.imcore.x_bionic.R;
import com.imcore.x_bionic.Activity.LoginActivity;

public class SlidFragment extends Fragment {
	private ImageView imageView;
	private Button btn_into;
	private View view;
	private int[] drawable = new int[] { R.drawable.welcompage1,
			R.drawable.welcompage2, R.drawable.welcompage3 };;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.slid_fragment, null);
		imageView = (ImageView) view.findViewById(R.id.welcom);
		btn_into = (Button) view.findViewById(R.id.into_Activity);
		Bundle b = getArguments();
		int position = b.getInt("position");
		if (position != drawable.length - 1) {
			btn_into.setVisibility(View.INVISIBLE);
		}
		setImage(position);
		return view;
	}

	private void setImage(int position) {
		imageView.setImageResource(drawable[position]);
		btn_into.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), LoginActivity.class);
				startActivity(intent);
			}
		});

	}

}
