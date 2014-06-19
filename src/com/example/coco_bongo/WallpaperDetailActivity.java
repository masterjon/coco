package com.example.coco_bongo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class WallpaperDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wallpaper_detail);
		Bundle extras = getIntent().getExtras();
		 if(extras != null){
			 String wpTitle=extras.getString("title");
			 Integer wpImage=extras.getInt("imageId");
			 
			TextView title =(TextView) findViewById(R.id.wallpaper_title_single);
			title.setText(wpTitle);
			
			ImageView img=(ImageView) findViewById(R.id.wallpaper_img_single);
			img.setImageResource(wpImage);
			
		 }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wallpaper_detail, menu);
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.action_share:
			Intent i = new Intent();
        	i.setAction(Intent.ACTION_SEND);
        	Bundle extras = getIntent().getExtras();
        	if(extras != null){
	   			 String showTitle=extras.getString("title");
	   			 Integer showImage=extras.getInt("imageId");
	   			i.putExtra(Intent.EXTRA_TEXT, "Me gustó el Show: " + showTitle);	        	
	        	i.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" + getPackageName() + "/drawable/" + showImage));
	        	i.setType("image/png");
	        	startActivity(Intent.createChooser(i, getResources().getText(R.string.share)));	
   			
   		 }
        	
        	        	
            return true;
		}
		return super.onMenuItemSelected(featureId, item);
		
	}

}
