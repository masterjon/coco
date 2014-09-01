package com.app.coco_bongo;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.app.coco_bongo.data.CustomGrid;
import com.app.coco_bongo.models.OptionsMenu;

public class SonidosActivity extends Activity {
	boolean isPlaying = false;
	MediaPlayer mediaPlayer ;
	int[] promoItem = {
		R.string.sound_heig,
		R.string.sound_just,
		R.string.sound_lion,
		R.string.sound_hammer,
		R.string.sound_oh_yeah,
		R.string.sound_birds,
		R.string.sound_party,
		R.string.sound_horn,
		R.string.sound_piano_1,
		R.string.sound_piano_2,
		R.string.sound_piano_3,
		R.string.sound_piano_4,
	};
	int[] imagesId ={
		0,
		R.drawable.sound_icon,

	};
	int[] soundsId={
		R.raw.heigh_ho,
		R.raw.just_called,
		R.raw.leon,
		R.raw.martillazo,
		R.raw.oh_yeah,
		R.raw.pajaritos,
		R.raw.party_people,
		R.raw.sirena,
		R.raw.piano_estadio_1,
		R.raw.piano_estadio_2,
		R.raw.piano_estadio_3,
		R.raw.piano_estadio_4,
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sonidos);
		GridView grid = (GridView) findViewById(R.id.grid_sonidos);
		CustomGrid adapter = new CustomGrid(getApplicationContext(),promoItem,imagesId);
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(new OnItemClickListener() {
			@SuppressWarnings("null")
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {

				Uri uri=Uri.parse("android.resource://com.app.coco_bongo/" + soundsId[position]);
				if (!isPlaying){
					
					mediaPlayer = new MediaPlayer();
					 try {
						mediaPlayer.setDataSource(getApplicationContext(), uri);
						mediaPlayer.prepare();
						mediaPlayer.start();
						isPlaying=true;
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}else{

			        isPlaying = false;
			        mediaPlayer.stop();
			        mediaPlayer.reset();
			        try {
						mediaPlayer.setDataSource(getApplicationContext(),uri);
						mediaPlayer.prepare();
				        mediaPlayer.start();
				        isPlaying = true;
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        

			    }
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
					
					@Override
					public void onCompletion(MediaPlayer mp) {
						mp.release();
						isPlaying=false;
						// TODO Auto-generated method stub
						
					}
				});
				
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

}
