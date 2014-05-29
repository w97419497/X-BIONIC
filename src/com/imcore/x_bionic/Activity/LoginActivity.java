package com.imcore.x_bionic.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import com.imcore.x_bionic.R;

public class LoginActivity extends Activity implements OnClickListener {

	private ImageView imageLoge;
	private Button xinaBtn, contBtn, buBtn, newBtn, helpBtn, serviceBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		imageLoge = (ImageView) findViewById(R.id.logo_view);

		xinaBtn = (Button) findViewById(R.id.xin_btn);
		contBtn = (Button) findViewById(R.id.teng_btn);
		buBtn = (Button) findViewById(R.id.bu_btn);
		newBtn = (Button) findViewById(R.id.new_btn);
		helpBtn = (Button) findViewById(R.id.hele_btn);
		serviceBtn = (Button) findViewById(R.id.service_btn);

		xinaBtn.setOnClickListener(this);
		contBtn.setOnClickListener(this);
		buBtn.setOnClickListener(this);
		newBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.xin_btn:
			Intent intent = new Intent(this, SinaLoginActivity.class);
			startActivity(intent);
			break;
		case R.id.bu_btn:
			Intent intent1 = new Intent(this, ClanLoginActivity.class);
			startActivity(intent1);
			break;
		case R.id.teng_btn:
			Intent intent2 = new Intent(this, TengXunLoginActivity.class);
			startActivity(intent2);
			break;
		case R.id.new_btn:
			Intent intent3 = new Intent(this, RegisterActivity.class);
			startActivity(intent3);

			break;

		default:
			break;
		}

	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			AlertDialog isExit = new AlertDialog.Builder(this).create();
			// 设置对话框标题
			isExit.setTitle("系统提示");
			// 设置对话框消息
			isExit.setMessage("确定要退出吗");
			// 添加选择按钮并注册监听
			isExit.setButton("确定", listener);
			isExit.setButton2("取消", listener);
			// 显示对话框
			isExit.show();
		}
		return false;
	}

	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
				System.exit(0);
				finish();
				break;
			case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
				break;
			default:
				break;
			}
		}
	};

}
