package com.imcore.x_bionic.Activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.imcore.x_bionic.R;
import com.imcore.x_bionic.Activity.http.HttpHelper;
import com.imcore.x_bionic.Activity.http.RequestEntity;

public class ProductMainActivity extends Activity implements OnClickListener {

	private GridView buy_gridview_up, buy_gridview_down;

	private ImageView buy_image_1, buy_image_2, produnt_image, produnt_search;
	private TextView title;
	static Boolean boolena = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_main);

		buy_image_1 = (ImageView) findViewById(R.id.buy_picture1);
		buy_image_1.setOnClickListener(this);
		buy_image_2 = (ImageView) findViewById(R.id.buy_picture2);
		buy_image_2.setOnClickListener(this);
		
		
		buy_gridview_up = (GridView) findViewById(R.id.buy_griVew_up);
		
		new logTask().execute();
		
		
		
		
		
		
		
		
		
		
		
		
		
		buy_gridview_down = (GridView) findViewById(R.id.buy_down);
		

		produnt_image = (ImageView) findViewById(R.id.product_image);
		produnt_image.setOnClickListener(this);

		produnt_search = (ImageView) findViewById(R.id.produnt_serech);
		produnt_search.setOnClickListener(this);
		title = (TextView) findViewById(R.id.produtc_title);

		
		
		
		
	}

	/**
	 * 
	 * 得到数据
	 * 
	 */
	class logTask extends AsyncTask<Void, Void,String>{

		@Override
		protected String doInBackground(Void... params) {

        String url="category/list.do";
        
        RequestEntity entity = new RequestEntity(url,0,null);
			String jssonRequest="";
			
			
			try {
				jssonRequest = HttpHelper.execute(entity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return jssonRequest;
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buy_picture1:

			if (boolena == false) {
				buy_gridview_up.setVisibility(View.VISIBLE);
				boolena = true;
			} else if (boolena == true) {
				buy_gridview_up.setVisibility(View.GONE);
				boolena = false;
			}
			break;

		case R.id.buy_picture2:

			if (boolena == false) {
				buy_gridview_down.setVisibility(View.VISIBLE);
				boolena = true;
			} else if (boolena == true) {
				buy_gridview_down.setVisibility(View.GONE);
				boolena = false;
			}

			break;
		case R.id.product_image:

			break;
		case R.id.produnt_serech:

			break;

		default:
			break;
		}

	}

}
