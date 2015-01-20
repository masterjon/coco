package com.app.coco_bongo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.app.coco_bongo.models.OptionsMenu;

public class SetActivity extends Activity {
	WebView myWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set);
		myWebView = (WebView) this.findViewById(R.id.webView);
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://m.mixcloud.com/CocoBongoShow/summer-mix-2014-cocobongostyle/");
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
	@Override
	public void onPause() {
	    super.onPause();
	    myWebView.onPause();
	    myWebView.pauseTimers(); //careful with this! Pauses all layout, parsing, and JavaScript timers for all WebViews.
	}

	@Override
	public void onResume() {
	    super.onResume();
	    myWebView.onResume();
	    myWebView.resumeTimers();
	}

	@Override
	public void onDestroy() {
	    super.onDestroy();
	   // parentViewGroup.removeAllViews(); 
	    myWebView.loadUrl("about:blank"); 
	    myWebView.stopLoading();
	    myWebView.setWebChromeClient(null);
	    myWebView.setWebViewClient(null);
	    myWebView.destroy();
	    myWebView = null;
	}


}
