package com.example.coco_bongo;

import android.net.Uri;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;

import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


import com.example.coco_bongo.data.CustomGrid;
import com.example.coco_bongo.models.menuItem;
import com.example.coco_bongo.R;

public class MainActivity extends Activity {
	private GridView grid;
	  String[] menuItem = {
			"Tickets",
			"Promos",
			"Boutique",
			"Shows",
			"Set del Mes",
			"Media",
			"Galeria",
			"E-cards",
			"Ubicacion",
			"Idioma",
	  };
	  int[] imageId = {
		      R.drawable.tickets_button,
		      R.drawable.promo_button,
		      R.drawable.shop_button,
		      R.drawable.shows_button,
		      R.drawable.set_button,
		      R.drawable.media_button,
		      R.drawable.galeria_button,
		      R.drawable.ecards_button,
		      R.drawable.location_button,
		      R.drawable.idioma_button,
		  };
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		   // getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		   //getActionBar().setCustomView(R.layout.menu_ej);
		setContentView(R.layout.activity_main);
		grid=(GridView) findViewById(R.id.grid_items);
		//ArrayList<menuItem> menuItems= new ArrayList<menuItem>();
		
//		for (Integer item: getResources().getIntArray(R.array.array_menu_items)){
//			menuItem one_item = new menuItem(item);
//			menuItems.add(one_item);
//		}
		CustomGrid adapter=new CustomGrid(this,menuItem,imageId);
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				if (position==0){
					Intent ticketsIntent = new Intent(getApplicationContext(), TicketsActivity.class);
					startActivity(ticketsIntent);
				}
				if (position==1){
					Intent ticketsIntent = new Intent(getApplicationContext(), PromosActivity.class);
					startActivity(ticketsIntent);
				}
				if (position==2){
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cocobongoboutique.com/store/"));
					startActivity(browserIntent);
				//	Toast.makeText(getApplicationContext(), "Clickedd"+menuItem[position], Toast.LENGTH_SHORT).show();
				}
				if (position==3){
					Intent showsIntent = new Intent(getApplicationContext(), ShowsActivity.class);
					startActivity(showsIntent);
				}
				if (position==5){
					Intent mediaIntent = new Intent(getApplicationContext(),MediaActivity.class);
					startActivity(mediaIntent);
				//	Toast.makeText(getApplicationContext(), "Clickedd"+menuItem[position], Toast.LENGTH_SHORT).show();
				}
				if (position==8){
					Intent locationIntent= new Intent(getApplicationContext(),LocationActivity.class);
					startActivity(locationIntent);
				}
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
