package com.example.coco_bongo;

import com.example.coco_bongo.data.CustomGrid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class WallpapersActivity extends Activity {
	String[] wallpaperItem = {
			"Wallpaper 1",
			"Wallpaper 2",
			"Wallpaper 3",
			"Wallpaper 4",
			"Wallpaper 5",
			"Wallpaper 6",
			"Wallpaper 7",
			"Wallpaper 8",
			"Wallpaper 9",
			"Wallpaper 10",
			"Wallpaper 11",
			"Wallpaper 12",
			
		};
	int[] imageId={
			R.drawable.frame5,
			R.drawable.frame5,
			R.drawable.frame5,
			R.drawable.frame5,
			R.drawable.frame5,
			R.drawable.frame5,
			R.drawable.frame5,
			R.drawable.frame5,
			R.drawable.frame5,
			R.drawable.frame5,
			R.drawable.frame5,
			R.drawable.frame5,
		};
	int[] imageBigid={
			R.drawable.frame8_big,
			R.drawable.frame8_big,
			R.drawable.frame8_big,
			R.drawable.frame8_big,
			R.drawable.frame8_big,
			R.drawable.frame8_big,
			R.drawable.frame8_big,
			R.drawable.frame8_big,
			R.drawable.frame8_big,
			R.drawable.frame8_big,
			R.drawable.frame8_big,
			R.drawable.frame8_big,
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
				detailIntent.putExtra("title", wallpaperItem[position]);
				detailIntent.putExtra("imageId", imageBigid[position]);
				startActivity(detailIntent);
				
			}
			
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wallpapers, menu);
		return true;
	}

}
