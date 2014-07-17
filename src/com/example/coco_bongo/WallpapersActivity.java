package com.example.coco_bongo;

import com.example.coco_bongo.data.CustomGrid;
import com.example.coco_bongo.models.OptionsMenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class WallpapersActivity extends Activity {
	int[] wallpaperItem = {
			R.string.wallpaper1,
			R.string.wallpaper2,
			R.string.wallpaper3,
			R.string.wallpaper4,
			R.string.wallpaper5,
			R.string.wallpaper6,
			R.string.wallpaper7,
			R.string.wallpaper8,
			R.string.wallpaper9,

		};
	int[] imageId={
			R.drawable.wp_thumb_1,
			R.drawable.wp_thumb_2,
			R.drawable.wp_thumb_3,
			R.drawable.wp_thumb_4,
			R.drawable.wp_thumb_5,
			R.drawable.wp_thumb_6,
			R.drawable.wp_thumb_7,
			R.drawable.wp_thumb_8,
			R.drawable.wp_thumb_9,
			
	};
	int[] imageBigid={
			R.drawable.wallpaper_540x480_1,
			R.drawable.wallpaper_540x480_2,
			R.drawable.wallpaper_540x480_3,
			R.drawable.wallpaper_540x480_4,
			R.drawable.wallpaper_540x480_5,
			R.drawable.wallpaper_540x480_6,
			R.drawable.wallpaper_540x480_7,
			R.drawable.wallpaper_540x480_8,
			R.drawable.wallpaper_540x480_9,
			
		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wallpapers);
		GridView grid = (GridView) findViewById(R.id.grid_wallpapers);
		CustomGrid adapter = new CustomGrid(getApplicationContext(), wallpaperItem, imageId);
		grid.setAdapter(adapter);
		
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Intent detailIntent = new Intent(getApplicationContext(), WallpaperDetailActivity.class);
				detailIntent.putExtra("title", getString(wallpaperItem[position]));
				detailIntent.putExtra("imageId", imageBigid[position]);
				detailIntent.putExtra("position", position);
				startActivity(detailIntent);
				
			}
			
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
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
