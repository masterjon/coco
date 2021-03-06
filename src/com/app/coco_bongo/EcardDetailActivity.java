package com.app.coco_bongo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.coco_bongo.utils.AlbumStorageDirFactory;
import com.app.coco_bongo.utils.BitmapManager;

public class EcardDetailActivity extends Activity {
	private static final int SELECT_PICTURE =2;
	private static final int TAKE_PICTURE =1;
	private ImageView img;
	private String currentPhotoPath;
	private String currentPhotoname;
	private Bitmap myImageBitmap;
	private Bitmap rotatedBm; 
	public final static String DIALOG_TAG = "dialogo";
	final Context context = this;
	private static final String ALBUM_PATH="/Pictures/CocoBongo/";
	private static final String ALBUM_TMP="/Pictures/CocoBongoTmp/";
	private static final Uri IMAGE_PROVIDER_URI = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ecard_detail);
		Bundle extras = getIntent().getExtras();
		 if(extras != null){
			 String eTitle=extras.getString("title");
			 Integer eImage=extras.getInt("imageId");
			 setTitle(eTitle);
			 
			//TextView title =(TextView) findViewById(R.id.ecard_title_single);
			//title.setText(eTitle);
			
			img=(ImageView) findViewById(R.id.ecard_img_single);
			ImageView frame=(ImageView) findViewById(R.id.ecard_img_frame);
			frame.setBackgroundResource(eImage);
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				// set title
			alertDialogBuilder.setTitle(R.string.select_image_from);
			alertDialogBuilder
				.setCancelable(false)
				.setSingleChoiceItems(R.array.array_image_input_method, -1, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//Toast.makeText(context, "Click " + which, Toast.LENGTH_SHORT).show();
						if(which==0){
							takePictureFromCamera(img);
						}
						else if(which==1){
							takePictureFromGallery(img);
						}						
						dialog.cancel();
					}
				})
				.setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {	
						EcardDetailActivity.this.finish();
					}
				});
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();



		 }
	}	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		 if (resultCode==RESULT_OK)	{	
			 switch (requestCode) {
			 	case SELECT_PICTURE:{
			 		 Uri selectedImageUri = data.getData();
			 		 currentPhotoname= selectedImageUri.getLastPathSegment().toString();
			 		 
					 currentPhotoPath= AlbumStorageDirFactory.getImageFromGalleryPath(this, selectedImageUri);
			         try {
						//Bitmap bm = decodeUri(getApplicationContext(),selectedImageUri,500);
				         Matrix matrix = new Matrix();
				         int orientation = getOrientation(getApplicationContext(),selectedImageUri);
					     
					     Bitmap bm = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImageUri);
				         if (bm.getWidth() > bm.getHeight() && orientation==0){
				        	 matrix.postRotate(orientation);
				        	 bm= Bitmap.createScaledBitmap(bm,750,562, true);
				        	 rotatedBm=bm;
				        	 //Toast.makeText(getApplicationContext(), "bm.getWidth()>bm.getHeight() && orientation==0",Toast.LENGTH_LONG).show();
						 }	
				         else if(bm.getWidth() < bm.getHeight() && orientation==0){
				        	 matrix.postRotate(orientation);
				        	 bm= Bitmap.createScaledBitmap(bm,562,750, true);
				        	 rotatedBm=bm;
				        	 //Toast.makeText(getApplicationContext(), "bm.getWidth()<bm.getHeight() && orientation==0",Toast.LENGTH_LONG).show();
				         }
				         else if (bm.getWidth() > bm.getHeight() && orientation==90){
				        	 matrix.postRotate(orientation);
				        	 bm= Bitmap.createScaledBitmap(bm,750,562, true);
				        	 rotatedBm = Bitmap.createBitmap(bm , 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);
				        	 //Toast.makeText(getApplicationContext(), "bm.getWidth()<bm.getHeight() && orientation==90",Toast.LENGTH_LONG).show();
				         }
				         else{
				        	 matrix.postRotate(orientation);
				        	 bm= Bitmap.createScaledBitmap(bm,750,562, true);
				        	 rotatedBm=bm;
				        	 //Toast.makeText(getApplicationContext(),"width:"+bm.getWidth()+"height:"+bm.getHeight()+"orientation:"+orientation,Toast.LENGTH_LONG).show();
				         }

				    
			         img.setImageBitmap(rotatedBm);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				break;
			 	}
				case TAKE_PICTURE:{
					String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
					currentPhotoname= timeStamp;
		    		if (currentPhotoPath!=null){
		    			Matrix matrix = new Matrix();
		    			int orientation = getOrientationCameraPic(currentPhotoPath);
		    			
		    			 myImageBitmap=BitmapManager.setPic(img, currentPhotoPath);
		    			 if (myImageBitmap.getWidth() < myImageBitmap.getHeight()){
		    				 matrix.postRotate(0);
		    			 }
		    			 else{
		    				 matrix.postRotate(orientation);
		    			 }
		    			 rotatedBm = Bitmap.createBitmap(myImageBitmap , 0, 0, myImageBitmap.getWidth(), myImageBitmap.getHeight(), matrix, true);
		    			 img.setImageBitmap(rotatedBm);
		    			//addPictureToGallery();
		    			currentPhotoPath=null;
		    		}
		    		break;
		    	}
			}
		 }
	}
	public static int getOrientation(Context context, Uri photoUri) {
	    Cursor cursor = context.getContentResolver().query(photoUri,
	            new String[] { MediaStore.Images.ImageColumns.ORIENTATION },
	            null, null, null);

	    try {
	        if (cursor.moveToFirst()) {
	            return cursor.getInt(0);
	        } else {
	            return 0;
	        }
	    } finally {
	        cursor.close();
	    }
	}
	public static int getOrientationCameraPic(String photo){
		int rotate = 0;
        ExifInterface exif;
		try {
			exif = new ExifInterface(photo);
			  int exifOrientation = exif.getAttributeInt(
	    	          ExifInterface.TAG_ORIENTATION,
	    	          ExifInterface.ORIENTATION_NORMAL);
			  

	          switch (exifOrientation) {
	          case ExifInterface.ORIENTATION_ROTATE_90:
	          rotate = 90;
	          break; 

	         case ExifInterface.ORIENTATION_ROTATE_180:
	         rotate = 180;
	         break;

	         case ExifInterface.ORIENTATION_ROTATE_270:
	         rotate = 270;
	         break;
	         }
			  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return rotate;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ecard_detail, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		return super.onOptionsItemSelected(item);
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.action_share) {
			mergeDownloadImg(true);
			return true;
		} else if (itemId == R.id.action_download) {
			mergeDownloadImg(false);
			return true;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
	
	
	public void takePictureFromGallery(View v){
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		
		startActivityForResult(Intent.createChooser(intent,getString(R.string.select_picture)),SELECT_PICTURE);
	}
	public void takePictureFromCamera(View v){
		  
		//seguimos la recomendacion de google para revisar si existe el intent deseado
		// en este caso es ACTION_IMAGE_CAPTURE que permite llamar a la aplicacion de camara
		if (isIntentAvailable(this, MediaStore.ACTION_IMAGE_CAPTURE)){
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			File f = null;
			try {
				//llamamos a la utileria que nos da la ruta del album
				f= AlbumStorageDirFactory.setUpPhotoFile(ALBUM_TMP);
				currentPhotoPath = f.getAbsolutePath();
				intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(f));
			} catch (IOException e) {
				f= null;
				currentPhotoPath= null;
				
			}
			//mando a llamar a la camara 
			//este metodo se usa cuando se espera un resultado del inten o actividad nueva en este caso la foto
			//el rsultado se maneja con el metodo  onActivityResult
			startActivityForResult(intent, TAKE_PICTURE);
		}
	}

	
	public void mergeDownloadImg(boolean share){
		Bundle extras = getIntent().getExtras();
		if(extras != null){
   			 Integer frameImage=extras.getInt("imageId");
			String mTempDir = Environment.getExternalStorageDirectory() + ALBUM_PATH;
			File mTempFile = new File(mTempDir);
			if(!mTempFile.exists()) {
			    mTempFile.mkdirs();
			}
			//File name 
			//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
			String mSavedImageName = "IMG_"+currentPhotoname+frameImage.toString()+".png";
			//Width = 604, Height = 1024 Change as per your requirement
			//Bitmap mBackground = Bitmap.createBitmap(1697, 2266, Bitmap.Config.ARGB_8888);
			//Bitmap mBackground = Bitmap.createBitmap(1456, 1944, Bitmap.Config.ARGB_8888);
		

			Bitmap  mTopImage = BitmapFactory.decodeResource(getResources(), frameImage);
			//Put back and top images in your res folder
			int width, height,x,y = 0;
			
//			 if(mTopImage.getWidth() > rotatedBm.getWidth()) { 
//			      width = mTopImage.getWidth(); 
//			      height = mTopImage.getHeight();
//			      x=(mTopImage.getWidth() - rotatedBm.getWidth())/2;
//			      y= (mTopImage.getHeight() - rotatedBm.getHeight())/2;
//			    } else { 
//			      width = rotatedBm.getWidth(); 
//			      height = rotatedBm.getHeight(); 
//			      x=(rotatedBm.getWidth() - mTopImage.getWidth())/2;
//			      y= (rotatedBm.getHeight() - mTopImage.getHeight())/2;
//			    } 
			Bitmap mBackground = Bitmap.createBitmap(562, 750, Bitmap.Config.ARGB_8888);
			mTopImage = Bitmap.createScaledBitmap(mTopImage, 562, 750, true);
			rotatedBm= Bitmap.createScaledBitmap(rotatedBm, 562, 750, true);
			Canvas mCanvas = new 	Canvas(mBackground);
			mCanvas.drawBitmap(rotatedBm, 0f, 0f, null);
			mCanvas.drawBitmap(mTopImage,0f, 0f, null);
			

			try {
			    BitmapDrawable mBitmapDrawable = new BitmapDrawable(getResources(),mBackground);
			    Bitmap mNewSaving = mBitmapDrawable.getBitmap();
			    String FtoSave = mTempDir + mSavedImageName;
			    File mFile = new File(FtoSave);
			    FileOutputStream mFileOutputStream = new FileOutputStream(mFile);
			    mNewSaving.compress(CompressFormat.PNG, 95, mFileOutputStream);
			    mFileOutputStream.flush();
			    mFileOutputStream.close();
			    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
				Uri contentUri= Uri.fromFile(mFile);
				intent.setData(contentUri);
				this.sendBroadcast(intent);
				if (share){
					Intent i = new Intent();
		        	i.setAction(Intent.ACTION_SEND); 
					i.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_ecard_text));	        	
		        	i.putExtra(Intent.EXTRA_STREAM,contentUri );
		        	i.setType("image/png");
		        	startActivity(Intent.createChooser(i, getResources().getText(R.string.share)));
				}
				else{
					 Toast.makeText(getApplicationContext(), R.string.save_to_gallery, Toast.LENGTH_LONG).show();
				}
					
			} catch(FileNotFoundException e) {
			    Log.e("fff", "FileNotFoundExceptionError " + e.toString());
			} catch(IOException e) {
			    Log.e("fff", "IOExceptionError " + e.toString());
			}
			
		}

	}
	
	/**
	 * Indicates whether the specified action can be used as an intent. This
	 * method queries the package manager for installed packages that can
	 * respond to an intent with the specified action. If no suitable package is
	 * found, this method returns false.
	 * http://android-developers.blogspot.com/2009/01/can-i-use-this-intent.html
	 *
	 * @param context The application's environment.
	 * @param action The Intent action to check for availability.
	 *
	 * @return True if an Intent with the specified action can be sent and
	 *         responded to, false otherwise.
	 */
	public static boolean isIntentAvailable(Context context, String action) {
		final PackageManager packageManager = context.getPackageManager();
		final Intent intent = new Intent(action);
		List<ResolveInfo> list =
			packageManager.queryIntentActivities(intent,
					PackageManager.MATCH_DEFAULT_ONLY);
		return list.size() > 0;
	}

}
