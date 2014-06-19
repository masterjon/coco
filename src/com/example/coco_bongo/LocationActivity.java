package com.example.coco_bongo;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
	

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LocationActivity extends Activity {
	 //static final LatLng HAMBURG = new LatLng(-86.747208,21.132893);
	  static final LatLng COCO_CANCUN = new LatLng(21.132893,-86.747208);
	  static final LatLng COCO_PLAYA = new LatLng(20.62811903364482,-87.07241714000702);
	  static final LatLng COCO_PUNTACANA = new LatLng(18.638309468634958,-68.3990654157008);
	  
	  static final LatLng CAMERA = new LatLng(20,-78);
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location);
		map=((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		map.setMyLocationEnabled(true);
		// Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
			       // .title("Hamburg"));
	    Marker coco_cancun = map.addMarker(new MarkerOptions()
	        .position(COCO_CANCUN)
	        .title("Coco Bongo Cancún")
	        .snippet("Blvd. Kukulcan Km 9.5 Plaza Forum, Zona Hotelera Cancún Q.Roo, México")
	        .icon(BitmapDescriptorFactory
	            .fromResource(R.drawable.ic_launcher)));
	    
	    Marker coco_playa = map.addMarker(new MarkerOptions()
        .position(COCO_PLAYA)
        .title("Coco Bongo Playa del Carmen")
        .snippet("Av. 10 y Calle 12, Playa de Carmen Q.Roo, México")
        .icon(BitmapDescriptorFactory
            .fromResource(R.drawable.ic_launcher)));
	    
	    Marker coco_puntacana = map.addMarker(new MarkerOptions()
        .position(COCO_PUNTACANA)
        .title("Coco Bongo Punta Cana")
        .snippet("Centro comercial Downtown Punta Cana, carretera Barcelo, Esq. el Boulevard, cruce de Coco Loco Bávaro, Punta Cana República Dominicana")
        .icon(BitmapDescriptorFactory
            .fromResource(R.drawable.ic_launcher)));
			    
	    map.setInfoWindowAdapter(new PopupAdapter(getLayoutInflater()));
//	    map.setOnInfoWindowClickListener((OnInfoWindowClickListener) this);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(COCO_CANCUN,10));
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(CAMERA,10));
		
		map.animateCamera(CameraUpdateFactory.zoomTo(4),2000, null);
		map.getUiSettings().setZoomControlsEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.location, menu);
		return true;
	}

}