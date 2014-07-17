package com.example.coco_bongo;

import com.example.coco_bongo.models.OptionsMenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MediaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_media);
		ImageButton wallpapers_btn = (ImageButton) findViewById(R.id.wallpapers_img);
		ImageButton sonidos_btn = (ImageButton) findViewById(R.id.sonodos_img);
			
		wallpapers_btn.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent wallpapers  = new Intent(getApplicationContext(),WallpapersActivity.class);
				startActivity(wallpapers);
			}
		});
		sonidos_btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent sonidos= new Intent(getApplicationContext(), SonidosActivity.class);
				startActivity(sonidos);
			}
	    });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
    	// TODO Auto-generated method stub
    	OptionsMenu.selectItem(item,getApplicationContext());
    	return super.onMenuItemSelected(featureId, item);
    }
}
