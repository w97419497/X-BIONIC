package com.imcore.x_bionic.Activity;



import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.imcore.x_bionic.R;
import com.imcore.x_bionic.Activity.http.HttpHelper;
import com.imcore.x_bionic.Activity.http.JsonUtil;
import com.imcore.x_bionic.Activity.http.RequestEntity;
import com.imcore.x_bionic.Activity.http.ResponseJsonEntity;
import com.imcore.x_bionic.model.User;
import com.imcore.x_bionic.util.ConnectivityUtil;
import com.imcore.x_bionic.util.TextUtil;
import com.imcore.x_bionic.util.ToastUtil;

public class ClanLoginActivity extends Activity {
	// 部落登入Activity
	private ImageView image_one, image_two;
	private EditText edit_one, edit_two;
	private TextView texe_one, Text_two;
	private ProgressDialog prggress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cactivity_login);

		image_one = (ImageView) findViewById(R.id.return_view);
		image_one.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ClanLoginActivity.this,
						LoginActivity.class);
				startActivity(intent);
			}
		});
		texe_one = (TextView) findViewById(R.id.title_text);
		Text_two = (TextView) findViewById(R.id.text1);
		edit_one = (EditText) findViewById(R.id.userName);
		edit_two = (EditText) findViewById(R.id.pssword);
		image_two = (ImageView) findViewById(R.id.into);
		image_two.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getLogin();
			}
		});
	}

	private void getLogin() {
		String phoneName = edit_one.getText().toString();
		String password = edit_two.getText().toString();

		if (!TextUtil.isNumber(phoneName)) {
			Toast.makeText(ClanLoginActivity.this, "你所拨打电话号码是已停机",
					Toast.LENGTH_SHORT).show();
			return;
		}

		if (!ConnectivityUtil.isOnline(this)) {
			Toast.makeText(ClanLoginActivity.this, "你的网络不给力啊",
					Toast.LENGTH_SHORT).show();
			return;
		}
		new LoginTask(phoneName, password).execute();
	}

	class LoginTask extends AsyncTask<Void, Void, String> {

		private String phoneNumber;
		private String password;

		public LoginTask(String phoneName, String password) {
			this.phoneNumber = phoneName;
			this.password = password;
		}
		@Override
		protected void onPreExecute() {
			prggress = ProgressDialog.show(ClanLoginActivity.this, "请稍后",
					"正在玩命加载....");
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(Void... params) {
			String url = "/passport/login.do";
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("phoneNumber",phoneNumber);
			map.put("password",password);
			map.put("client","android");
			RequestEntity entity = new RequestEntity(url, map);
			String jsonResponse = null;
			try {
				jsonResponse = HttpHelper.execute(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return jsonResponse;
		}
		@Override
		protected void onPostExecute(String result) {
			prggress.dismiss();
			prggress = null;
			if (TextUtil.isEmptyString(result)) {
				Toast.makeText(ClanLoginActivity.this, "呵呵", Toast.LENGTH_SHORT)
						.show();
				edit_two.setText("");
				return;
			}
			ResponseJsonEntity jentity = ResponseJsonEntity.fromJSON(result);
			if (jentity.getStatus() == 200) {
				String jsonData = jentity.getData();
				Log.i("user", jsonData);
				User user = JsonUtil.toObject(jsonData, User.class);
				// 在SharedPreferences中保存userId和token
				SharedPreferences saveMessage = getSharedPreferences("user",
						ClanLoginActivity.this.MODE_PRIVATE);
				if (!saveMessage.getString("userName", "").equals(phoneNumber)) {
					SharedPreferences.Editor editor = saveMessage.edit();
					editor.putString("userName", phoneNumber);
					editor.putString("password", password);
					editor.commit();
				}
				Intent intent = new Intent(ClanLoginActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			} else {
				ToastUtil.showToast(ClanLoginActivity.this,
						jentity.getMessage());
				edit_two.setText("");
				edit_two.setFocusable(true);
				edit_two.requestFocus();
			}
		}
	};

	// 取保存的密码和账号
	@Override
	protected void onResume() {
		SharedPreferences getMessage = getSharedPreferences("user",
				this.MODE_PRIVATE);
		String userName = getMessage.getString("userName", "");
		String password = getMessage.getString("password", "");
		if (!TextUtil.isEmptyString(userName)
				&& !TextUtil.isEmptyString(password)) {
			edit_one.setText(userName);
			edit_two.setText(password);
		}
		super.onResume();
	}
}