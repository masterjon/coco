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
import android.widget.TextView;
import android.widget.Toast;


public class ShowDetailActivity extends Activity {
	private static final String ALBUM_PATH="/Pictures/CocoBongo/";
	String extStorageDirectory;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_detail);
		Bundle extras = getIntent().getExtras();
		 if(extras != null){
			 String showTitle=extras.getString("title");
			 Integer showImage=extras.getInt("imageId");
			 setTitle(showTitle);
//			TextView title =(TextView) findViewById(R.id.show_title_single);
//			title.setText(showTitle);
			
			ImageView img=(ImageView) findViewById(R.id.show_img_single);
			img.setImageResource(showImage);
			
			
		   
		 }
	}

	private void addPictureToGallery(String title,int imgId, boolean share){
		Bitmap bm = BitmapFactory.decodeResource( getResources(), imgId);
		extStorageDirectory = Environment.getExternalStorageDirectory().toString()+ALBUM_PATH;
		try {
		   File dir = new File(extStorageDirectory);
	        if (!dir.exists()) {
	        	dir.mkdirs();
		     }
	        OutputStream outStream = null;
	        File file = new File(extStorageDirectory, "IMG_"+title+".jpg");
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
		    	i.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_shows_text) + title );	        	
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
		getMenuInflater().inflate(R.menu.show_detail, menu);
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		Bundle extras = getIntent().getExtras();
		String wpTitle=extras.getString("title");
		Integer img=extras.getInt("imageId");
		switch(item.getItemId()){
		case R.id.action_share:
			addPictureToGallery(wpTitle,img,true);
            return true;
		case R.id.action_download:
			addPictureToGallery(wpTitle,img,false);
			return true;
		}
		return super.onMenuItemSelected(featureId, item);
	}

}
