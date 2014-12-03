package com.app.coco_bongo;

import com.app.coco_bongo.models.OptionsMenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class VirtualTourActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_virtual_tour);
		
		ImageButton tourCancun = (ImageButton) findViewById(R.id.virtual_tour_cancun);
		tourCancun.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com/maps?ll=21.132973,-86.747414&spn=0.326638,0.603561&cbll=21.132973,-86.747414&layer=c&panoid=wwDGw0yhxu0AAAQXDl2gvQ&cbp=12,92.86,,0,-9.45&t=m&z=12"));
				startActivity(browserIntent);
			}
		});
		ImageButton tourPlaya = (ImageButton) findViewById(R.id.virtual_tour_playa);
		tourPlaya.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com/maps?ll=20.628074,-87.072235&spn=0.200819,0.315857&cbll=20.628074,-87.072235&layer=c&panoid=mT2XFCvd8joAAAQfCNDqgw&cbp=12,319.74,,0,-52.18&t=m&z=12 "));
				startActivity(browserIntent);
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
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
