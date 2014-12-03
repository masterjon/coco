package com.app.coco_bongo;


import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.app.coco_bongo.data.CustomGrid;
import com.app.coco_bongo.models.OptionsMenu;

public class MainActivity extends Activity {
	private GridView grid;
    private Locale locale = null;

	  int[] menuItem = {
			R.string.title_activity_tickets,
			R.string.title_activity_promos,
			R.string.title_activity_boutique,
			R.string.title_activity_shows,
			R.string.title_activity_set,
			R.string.title_activity_media,
		//	R.string.title_activity_gallery,
			R.string.title_activity_virtual_tour,
			R.string.title_activity_ecards,
			R.string.title_activity_location,
			R.string.title_activity_lang,
			
			
	  };
	  int[] imageId = {
		      R.drawable.tickets_button,
		      R.drawable.promo_button,
		      R.drawable.shop_button,
		      R.drawable.shows_button,
		      R.drawable.set_button,
		      R.drawable.media_button,
		     // R.drawable.galeria_button,
		      R.drawable.tour_virtual,
		      R.drawable.ecards_button,
		      R.drawable.location_button,
		      R.drawable.idioma_button,
		     
		  };
	  @Override
	    public void onConfigurationChanged(Configuration newConfig)
	    {
	        super.onConfigurationChanged(newConfig);
	        if (locale != null)
	        {
	            newConfig.locale = locale;
	            Locale.setDefault(locale);
	            getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
	            Toast.makeText(this, locale.toString(), Toast.LENGTH_LONG).show();
	        }
	    }
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
     	 
		setTitle(R.string.app_name);
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
					Intent promosIntent = new Intent(getApplicationContext(), PromosActivity.class);
					startActivity(promosIntent);
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
				if (position==4){
					//Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.soundcloud.com/forss/flickermood"));
					//startActivity(browserIntent);
					
					Intent setIntent = new Intent(getApplicationContext(), SetActivity.class);
					startActivity(setIntent);
				}
				if (position==5){
					Intent mediaIntent = new Intent(getApplicationContext(),MediaActivity.class);
					startActivity(mediaIntent);
				//	Toast.makeText(getApplicationContext(), "Clickedd"+menuItem[position], Toast.LENGTH_SHORT).show();
				}
//				if (position==6){
//					Intent galleryIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://galeria.cocobongo.com.mx/"));
//					startActivity(galleryIntent);
//				}
				if (position==6){
					Intent virtualTourIntent = new Intent(getApplicationContext(),VirtualTourActivity.class);
					startActivity(virtualTourIntent);
				}	
				if (position==7){
					Intent ecardsIntent= new Intent(getApplicationContext(),EcardsActivity.class);
					startActivity(ecardsIntent);
				}
				if (position==8){
					Intent locationIntent= new Intent(getApplicationContext(),LocationActivity.class);
					startActivity(locationIntent);
				}
				if (position==9){
					Intent langIntent= new Intent(getApplicationContext(),LangActivity.class);
					startActivity(langIntent);
				}

			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		OptionsMenu.selectItem(item,getApplicationContext());
		return super.onMenuItemSelected(featureId, item);
	}

}
