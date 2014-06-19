package com.example.coco_bongo;

import com.example.coco_bongo.data.CustomGrid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;

public class PromosActivity extends Activity {
	 String[] promoItem = {
				"Promo1",
				"Promo2",
				"Promo3",
				"Promo4",
				"Promo5",
			

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
		getMenuInflater().inflate(R.menu.promos, menu);
		return true;
	}

}
