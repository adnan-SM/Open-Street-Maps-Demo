package com.example.osmdemo;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.MyLocationOverlay;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
 
public class MainActivity extends Activity {
  
 MyItemizedOverlay myItemizedOverlay = null;
 MapView mapView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setUseSafeCanvas(false);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mapView.getController().setZoom(6);
        
        GpsMyLocationProvider imlp = new
        		GpsMyLocationProvider(this.getBaseContext());
        imlp.setLocationUpdateMinDistance(1000);
        imlp.setLocationUpdateMinTime(6000);
        
        ResourceProxy resourceProxy = new DefaultResourceProxyImpl(getApplicationContext());
        
        MyLocationOverlay myLoc = new MyLocationOverlay(getApplicationContext(),mapView,resourceProxy);
        myLoc.setDrawAccuracyEnabled(true);
        mapView.getOverlays().add(myLoc);
        
        Drawable marker=getResources().getDrawable(android.R.drawable.star_big_on);
        int markerWidth = marker.getIntrinsicWidth();
        int markerHeight = marker.getIntrinsicHeight();
        marker.setBounds(0, markerHeight, markerWidth, 0);
         
        
     
        
        
      /*  myItemizedOverlay = new MyItemizedOverlay(marker, resourceProxy);
        mapView.getOverlays().add(myItemizedOverlay);
         
        GeoPoint myPoint1 = new GeoPoint(0*1000000, 0*1000000);
        myItemizedOverlay.addItem(myPoint1, "myPoint1", "myPoint1");
        GeoPoint myPoint2 = new GeoPoint(50*1000000, 50*1000000);
        myItemizedOverlay.addItem(myPoint2, "myPoint2", "myPoint2");*/
         
    } 
    
    @Override
    	protected void onResume() {
    		// TODO Auto-generated method stub
    		super.onResume();
    		
    	}
     
}