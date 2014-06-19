package com.example.coco_bongo;

import com.example.coco_bongo.data.CustomGrid;
import com.example.coco_bongo.models.menuItem;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.GridView;

public class SonidosActivity extends Activity {
	String[] promoItem = {
		"Sonido 1",
		"Sonido 2",
		"Sonido 3",
		"Sonido 4",
		"Sonido 5",
		"Sonido 6",
		"Sonido 7",
		"Sonido 8",
		"Sonido 9",

		
	};
	int[] imagesId ={
		0,
		R.drawable.sound_icon,

	};
	int[] soundsId={
		R.raw.send1,
		R.raw.send2,
		R.raw.send3,
		R.raw.send4,
		R.raw.send5,
		R.raw.send6,
		R.raw.send7,
		R.raw.send8,
		R.raw.send9
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

}
