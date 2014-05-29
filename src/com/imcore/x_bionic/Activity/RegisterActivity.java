package com.imcore.x_bionic.Activity;

import com.imcore.x_bionic.R;
import com.imcore.x_bionic.R.layout;
import com.imcore.x_bionic.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends Activity implements OnClickListener {

	private Button xin_register, teng_register, phone_register;
	
	private TextView title;
	
	private ImageView back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		xin_register = (Button) findViewById(R.id.xin_register);
		teng_register = (Button) findViewById(R.id.teng_register);
		phone_register = (Button) findViewById(R.id.bu_register);
		title = (TextView)findViewById(R.id.title_text_register);
		
		back = (ImageView)findViewById(R.id.return_view_register);
		
		xin_register.setOnClickListener(this);
		teng_register.setOnClickListener(this);
		phone_register.setOnClickListener(this);
		back.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.xin_register:
//
			break;
		case R.id.teng_register:
//
			break;
		case R.id.bu_register:
//
			break;
		case R.id.return_view_register:
			Intent intent = new Intent(this,LoginActivity.class);
			startActivity(intent);
			
			break;
			
			
		default:
			break;
		}

	}

}
