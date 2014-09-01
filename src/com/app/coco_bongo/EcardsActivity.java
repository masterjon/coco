package com.app.coco_bongo;

import com.app.coco_bongo.data.CustomGrid;
import com.app.coco_bongo.models.OptionsMenu;
import com.app.coco_bongo.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class EcardsActivity extends Activity {
	int[] ecardItem = {
			R.string.ecard_gaga_michael,
			R.string.ecard_gaga,
			R.string.ecard_elvis,
			R.string.ecard_michael,
			R.string.ecard_beetlejuice_mask,
			R.string.ecard_beyonce,
			R.string.ecard_madonna,
			R.string.ecard_beetlejuice,
			R.string.ecard_mask,
			
		};
	int[] imageId={
			R.drawable.ecard_thumb_1,
			R.drawable.ecard_thumb_2,
			R.drawable.ecard_thumb_3,
			R.drawable.ecard_thumb_4,
			R.drawable.ecard_thumb_5,
			R.drawable.ecard_thumb_6,
			R.drawable.ecard_thumb_7,
			R.drawable.ecard_thumb_8,
			R.drawable.ecard_thumb_9,
			
	};
	int[] imageBigid={
			R.drawable.marco_ecard_1,
			R.drawable.marco_ecard_2,
			R.drawable.marco_ecard_3,
			R.drawable.marco_ecard_4,
			R.drawable.marco_ecard_5,
			R.drawable.marco_ecard_6,
			R.drawable.marco_ecard_7,
			R.drawable.marco_ecard_8,
			R.drawable.marco_ecard_9,
		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ecards);
		GridView grid = (GridView) findViewById(R.id.grid_ecards);
		CustomGrid adapter = new CustomGrid(getApplicationContext(), ecardItem, imageId);
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Intent detailIntent = new Intent(getApplicationContext(), EcardDetailActivity.class);
				detailIntent.putExtra("title", ecardItem[position]);
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
