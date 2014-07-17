package com.example.coco_bongo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class WallpaperDetailActivity extends Activity {
	private static final String ALBUM_PATH="/Pictures/CocoBongo/";
	String extStorageDirectory;
	int [] img_res1={
		R.drawable.wallpaper_540x480_1,
		R.drawable.wallpaper_540x480_2,
		R.drawable.wallpaper_540x480_3,
		R.drawable.wallpaper_540x480_4,
		R.drawable.wallpaper_540x480_5,
		R.drawable.wallpaper_540x480_6,
		R.drawable.wallpaper_540x480_7,
		R.drawable.wallpaper_540x480_8,
		R.drawable.wallpaper_540x480_9,
	};
	int [] img_res2={
			R.drawable.wallpaper_960x854_1,
			R.drawable.wallpaper_960x854_2,
			R.drawable.wallpaper_960x854_3,
			R.drawable.wallpaper_960x854_4,
			R.drawable.wallpaper_960x854_5,
			R.drawable.wallpaper_960x854_6,
			R.drawable.wallpaper_960x854_6,
			R.drawable.wallpaper_960x854_7,
			R.drawable.wallpaper_1080x960_8,
			R.drawable.wallpaper_1080x960_9,
	};
	int [] img_res3={
			R.drawable.wallpaper_1080x960_1,
			R.drawable.wallpaper_1080x960_2,
			R.drawable.wallpaper_1080x960_3,
			R.drawable.wallpaper_1080x960_4,
			R.drawable.wallpaper_1080x960_5,
			R.drawable.wallpaper_1080x960_6,
			R.drawable.wallpaper_1080x960_7,
			R.drawable.wallpaper_1080x960_8,
			R.drawable.wallpaper_1080x960_9,
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wallpaper_detail);
		Bundle extras = getIntent().getExtras();
		 if(extras != null){
			 String wpTitle=extras.getString("title");
			 Integer wpImage=extras.getInt("imageId");
			 setTitle(wpTitle);
			 
//			TextView title =(TextView) findViewById(R.id.wallpaper_title_single);
//			title.setText(wpTitle);
			
			ImageView img=(ImageView) findViewById(R.id.wallpaper_img_single);
			img.setImageResource(wpImage);

		 }
	}
	private void addPictureToGallery(String imgName ,String title,int imgId, boolean share){
		Bitmap bm = BitmapFactory.decodeResource( getResources(), imgId);
		extStorageDirectory = Environment.getExternalStorageDirectory().toString()+ALBUM_PATH;
		try {
		   File dir = new File(extStorageDirectory);
	        if (!dir.exists()) {
	        	dir.mkdirs();
		     }
	        OutputStream outStream = null;
	        File file = new File(extStorageDirectory, "IMG_"+imgName+".jpg");
	        if(file.exists()){
			    file.delete();
			    file.createNewFile();
	        }
		    outStream = new FileOutputStream(file);
		    bm.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
		    outStream.flush();
		    outStream.close();
		    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
			Uri contentUri= Uri.fromFile(file);
			intent.setData(contentUri);
		    this.sendBroadcast(intent);
		    if (share){
		    	Intent i = new Intent();
	        	i.setAction(Intent.ACTION_SEND);   
		    	i.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_wallpaper_text) +" "+ title );	        	
	        	i.putExtra(Intent.EXTRA_STREAM, contentUri);
	        	i.setType("image/*");
	        	//i.setType("text/plain");
	        	i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
	        	startActivity(Intent.createChooser(i, getResources().getText(R.string.share)));	
		    }
		    else{
		    	Toast.makeText(getApplicationContext(), R.string.save_to_gallery, Toast.LENGTH_LONG).show();
		    }
		   } catch (FileNotFoundException e) {		   
			   Log.e("fff", "FileNotFoundExceptionError " + e.toString());
		   } catch (IOException e) {
			   Log.e("fff", "IOExceptionError " + e.toString());
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
		Bundle extras = getIntent().getExtras();
		String wpTitle=extras.getString("title");
		Integer position=extras.getInt("position");
		switch(item.getItemId()){
		case R.id.action_share:    	 
	   		addPictureToGallery(wpTitle+"_"+getText(R.string.wp_res1).toString(),wpTitle,img_res1[position],true);
	   		return true;
		case R.id.wpres1:
			addPictureToGallery(wpTitle+"_"+getText(R.string.wp_res1).toString(),wpTitle,img_res1[position],false);
			return true;
		case R.id.wpres2:
			addPictureToGallery(wpTitle+"_"+getText(R.string.wp_res2).toString(),wpTitle,img_res2[position],false);
			return true;
		case R.id.wpres3:
			addPictureToGallery(wpTitle+"_"+getText(R.string.wp_res3).toString(),wpTitle,img_res3[position],false);     
            return true;
		}
		return super.onMenuItemSelected(featureId, item);
		
	}

}
