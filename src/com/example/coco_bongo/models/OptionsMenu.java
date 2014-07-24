package com.example.coco_bongo.models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.coco_bongo.EcardsActivity;
import com.example.coco_bongo.LangActivity;
import com.example.coco_bongo.LocationActivity;
import com.example.coco_bongo.MediaActivity;
import com.example.coco_bongo.PromosActivity;
import com.example.coco_bongo.R;
import com.example.coco_bongo.SetActivity;
import com.example.coco_bongo.ShowsActivity;
import com.example.coco_bongo.TicketsActivity;

public class OptionsMenu extends Activity{
   public static boolean selectItem(MenuItem item, Context context){
	   switch(item.getItemId()){
	   case R.id.action_tickets:
		   Intent ticketsIntent = new Intent(context, TicketsActivity.class);
		   ticketsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   context.startActivity(ticketsIntent);
		   return true;
	   case R.id.action_promos:
		   Intent promosIntent = new Intent(context, PromosActivity.class);
		   promosIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   context.startActivity(promosIntent);
		   return true;
	   case R.id.action_boutique:
		   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cocobongoboutique.com/store/"));
		   browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   context.startActivity(browserIntent);
		   return true;
	   case R.id.action_shows:
		   Intent showsIntent = new Intent(context, ShowsActivity.class);
		   showsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   context.startActivity(showsIntent);
		   return true;
	   case R.id.action_set:
		   Intent setIntent = new Intent(context, SetActivity.class);
		   setIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   context.startActivity(setIntent);
		   return true;
	   case R.id.action_media:
		   Intent mediaIntent = new Intent(context,MediaActivity.class);
		   mediaIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   context.startActivity(mediaIntent);
		   return true;
	   case R.id.action_galeria:
  			Intent galleryIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://galeria.cocobongo.com.mx/"));
  			galleryIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(galleryIntent);
			return true;
	   	case R.id.action_ecard:
	   		Intent ecardsIntent= new Intent(context,EcardsActivity.class);
	   		ecardsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(ecardsIntent);
		    return true;
	 	case R.id.action_ubicacion:
	 		Intent locationIntent= new Intent(context,LocationActivity.class);
	 		locationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(locationIntent);
	 	    return true;
	 	case R.id.action_lenguaje:
	 		Intent langIntent = new Intent(context,LangActivity.class);
	 		langIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	 		context.startActivity(langIntent);
	 		return true;
	   }
	   return true;
   }
}
