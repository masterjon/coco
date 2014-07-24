package com.example.coco_bongo;

import java.util.Locale;

import com.example.coco_bongo.models.OptionsMenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LangActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lang);
		Button es_Btn= (Button) findViewById(R.id.es_button);
		es_Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Locale locale = new Locale("es"); 
		         Locale.setDefault(locale);
		         Configuration config = new Configuration();
		         config.locale = locale;
		         getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
				Intent i = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(i);
				// TODO Auto-generated method stub
				
			}
		});
		Button en_Btn= (Button) findViewById(R.id.en_button);
		en_Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Locale locale = new Locale("en"); 
		         Locale.setDefault(locale);
		         Configuration config = new Configuration();
		         config.locale = locale;
		         getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
				Intent i = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(i);
				// TODO Auto-generated method stub
				
			}
		});
		Button pr_Btn= (Button) findViewById(R.id.pr_button);
		pr_Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Locale locale = new Locale("pt"); 
		         Locale.setDefault(locale);
		         Configuration config = new Configuration();
		         config.locale = locale;
		         getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
		         
				Intent i= new Intent(getApplicationContext(), MainActivity.class);
				startActivity(i);
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
