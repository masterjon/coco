package com.app.coco_bongo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.app.coco_bongo.data.CustomGrid;
import com.app.coco_bongo.models.OptionsMenu;

public class ShowsActivity extends Activity {
	int[] showsItem = {
		R.string.show_queen,
		R.string.show_lmfao,
		R.string.show_moulin,
		R.string.show_follow,
		R.string.show_captain,
		R.string.show_beyonce,
		R.string.show_samba,
		R.string.show_michael,
		R.string.show_elvis,
		
	};
	int[] Imageid={
		R.drawable.show_thumb_1,
		R.drawable.show_thumb_2,
		R.drawable.show_thumb_3,
		R.drawable.show_thumb_4,
		R.drawable.show_thumb_5,
		R.drawable.show_thumb_6,
		R.drawable.show_thumb_7,
		R.drawable.show_thumb_8,
		R.drawable.show_thumb_9,
	};
	int[] ImageBigid={
			R.drawable.show_detail_1,
			R.drawable.show_detail_2,
			R.drawable.show_detail_3,
			R.drawable.show_detail_4,
			R.drawable.show_detail_5,
			R.drawable.show_detail_6,
			R.drawable.show_detail_7,
			R.drawable.show_detail_8,
			R.drawable.show_detail_9,

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
				
				showIntent.putExtra("title", getString(showsItem[position]));
				showIntent.putExtra("imageId", ImageBigid[position]);
				startActivity(showIntent);
				
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
