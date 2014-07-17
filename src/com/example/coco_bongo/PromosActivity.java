package com.example.coco_bongo;

import com.example.coco_bongo.data.CustomGrid;
import com.example.coco_bongo.models.OptionsMenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

public class PromosActivity extends Activity {
	 int[] promoItem = {
				R.string.promo_1,
				R.string.promo_2,
				R.string.promo_3,
				R.string.promo_4,
				R.string.promo_5,
			

		  };
		  int[] imageId = {
				  R.drawable.ejemplo_promo,
				  R.drawable.ejemplo_promo,
				  R.drawable.ejemplo_promo,
				  R.drawable.ejemplo_promo,
				  R.drawable.ejemplo_promo,
			   
			  };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_promos);
		GridView grid = (GridView) findViewById(R.id.grid_promos);
		CustomGrid adapter= new CustomGrid(getApplicationContext(), promoItem, imageId);
		grid.setAdapter(adapter);
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
