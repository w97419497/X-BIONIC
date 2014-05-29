package com.imcore.x_bionic.Activity;

import com.imcore.x_bionic.R;
import com.imcore.x_bionic.R.id;
import com.imcore.x_bionic.R.layout;
import com.imcore.x_bionic.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchActivity extends Activity {

	private GridView gridView;
	private ImageView return_image, produnct_image;
	private TextView title;
	private EditText search_text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		return_image=(ImageView)findViewById(R.id.search_reyurn);
		produnct_image = (ImageView)findViewById(R.id.product);
		title=(TextView)findViewById(R.id.search_title);
		gridView = (GridView)findViewById(R.id.gridview);
		search_text =(EditText)findViewById(R.id.edit_seacrh);
		
	}

}
