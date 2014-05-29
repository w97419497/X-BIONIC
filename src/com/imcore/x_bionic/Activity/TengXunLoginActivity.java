package com.imcore.x_bionic.Activity;

import com.imcore.x_bionic.R;
import com.imcore.x_bionic.R.layout;
import com.imcore.x_bionic.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TengXunLoginActivity extends Activity implements OnClickListener {

	private Button btn_impower, btn_logout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teng_xun_login);

		btn_impower = (Button) findViewById(R.id.impower);
		btn_logout = (Button) findViewById(R.id.logout);

		btn_impower.setOnClickListener(this);
		btn_logout.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.impower:
			//
			break;

		case R.id.logout:
			//
			break;

		default:
			break;
		}

	}

}
