package com.example.coco_bongo;

import com.example.coco_bongo.data.CustomGrid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.GridView;

public class ShowsActivity extends Activity {
	String[] showsItem = {
		"Show 1",
		"Show 2",
		"Show 3",
		"Show 4",
		"Show 5",
		"Show 6",
		"Show 7",
		"Show 8",
		"Show 9",
		"Show 10",
		"Show 11",
		"Show 12",
		
	};
	int[] Imageid={
		R.drawable.frame8,
		R.drawable.frame8,
		R.drawable.frame8,
		R.drawable.frame8,
		R.drawable.frame8,
		R.drawable.frame8,
		R.drawable.frame8,
		R.drawable.frame8,
		R.drawable.frame8,
		R.drawable.frame8,
		R.drawable.frame8,
		R.drawable.frame8,
	};
	int[] ImageBigid={
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
		setContentView(R.layout.activity_shows);
		GridView grid = (GridView) findViewById(R.id.grid_show);
		CustomGrid adapter= new CustomGrid(getApplicationContext(), showsItem, Imageid);
		grid.setAdapter(adapter);
		
		grid.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Intent showIntent = new Intent(getApplicationContext(), ShowDetailActivity.class);
				
				showIntent.putExtra("title", showsItem[position]);
				showIntent.putExtra("imageId", ImageBigid[position]);
				startActivity(showIntent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shows, menu);
		return true;
	}

}
