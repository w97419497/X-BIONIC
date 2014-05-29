package com.imcore.x_bionic.Activity;

import com.imcore.x_bionic.*;
import com.imcore.x_bionic.R.id;
import com.imcore.x_bionic.R.layout;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SparnesActivity extends Activity {
	
	private ProgressBar bar;
	
	private ImageView imageview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sparnes);
		
		
		
		imageview = (ImageView) findViewById(R.id.sparnes);
		bar = (ProgressBar)findViewById(R.id.progress_bar);
		
		
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (bar.getProgress() >= 100) {
						Intent intent = new Intent(SparnesActivity.this,
								SlideActivity.class);
						startActivity(intent);
						finish();
						return;
					}
					try {
						Thread.sleep(388L);
						bar.incrementProgressBy(10);
					} catch (InterruptedException e) {
						while(true)
						  e.printStackTrace();
					}
				}

			}
		}).start();
//		new Handler().postDelayed(new Runnable() {
//			
//			
//			@Override
//			public void run() {
//				Intent intent = new Intent(SparnesActivity.this,
//						SlideActivity.class);
//				startActivity(intent);
//				SparnesActivity.this.finish();
//			}
//		},3000);
	
	
	
	
	
	}
		
		
		
		
	


}
