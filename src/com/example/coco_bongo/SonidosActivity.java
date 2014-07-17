package com.example.coco_bongo;

import com.example.coco_bongo.data.CustomGrid;
import com.example.coco_bongo.models.OptionsMenu;
import com.example.coco_bongo.models.menuItem;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.GridView;

public class SonidosActivity extends Activity {
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
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),soundsId[position]);
				mediaPlayer.start();
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sonidos, menu);
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		OptionsMenu.selectItem(item,getApplicationContext());
		return super.onMenuItemSelected(featureId, item);
	}

}
