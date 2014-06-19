package com.example.coco_bongo;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.example.coco_bongo.utils.AlbumStorageDirFactory;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowDetailActivity extends Activity {
	private static final String ALBUM_NAME="Mejorandroid";
	private String currentPhotoPath;
	String extStorageDirectory;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_detail);
		Bundle extras = getIntent().getExtras();
		 if(extras != null){
			 String showTitle=extras.getString("title");
			 Integer showImage=extras.getInt("imageId");
			 
			TextView title =(TextView) findViewById(R.id.show_title_single);
			title.setText(showTitle);
			
			ImageView img=(ImageView) findViewById(R.id.show_img_single);
			img.setImageResource(showImage);
			
			Bitmap bm = BitmapFactory.decodeResource( getResources(), R.drawable.textura_roja);
			 extStorageDirectory = Environment.getExternalStorageDirectory().toString()+"/Pictures/CocoBongo/";
			
			   try {
				   
				   File dir = new File(extStorageDirectory);
			        if (!dir.exists()) {
			        dir.mkdirs();
			        }
			        OutputStream outStream = null;
			        File file = new File(extStorageDirectory, "image.jpg");
			        if(file.exists())
			            file.delete();
			        file.createNewFile();
				   
			       
			    outStream = new FileOutputStream(file);
			    bm.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
			    outStream.flush();
			    outStream.close();
			    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
				 Uri contentUri= Uri.fromFile(file);
				 intent.setData(contentUri);
					this.sendBroadcast(intent);
			   
			    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
			   
			   } catch (FileNotFoundException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
			   } catch (IOException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
			   }
			
//			String extStorageDirectory = Environment.getDataDirectory().toString();
//			File file = new File(extStorageDirectory, "ic_launcher.PNG");
//			
//			File f;
//			try {
//				f = AlbumStorageDirFactory.setUpPhotoFile(ALBUM_NAME);
//				currentPhotoPath = f.getAbsolutePath();
//				addPictureToGallery();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
			
		   
		 }
	}
	private void addPictureToGallery(){
		Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
		//un archivo en java se maeja con la clase File
		File f= new File(currentPhotoPath);
		//aqui ya tenemos el archivo creado con la ruta correcta
		Uri contentUri= Uri.fromFile(f);
		intent.setData(contentUri);
		this.sendBroadcast(intent);
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
