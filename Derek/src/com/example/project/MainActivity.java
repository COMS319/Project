package com.example.project;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends Activity {
	protected boolean _active = true;
	protected int _splashtime = 3000;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //this removes the action bar, we wont need it since all of the options and settings will have a button
        //and having this bar would be waisted space
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        //Make sure that the screen orientation is locked in landscape mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        //set the user interface layout for this activity
        //the layout file is defined in the project res/layout/main_activity.xml file
        setContentView(R.layout.activity_main);
        
        Thread splashThread = new Thread(){
        	@Override
        	public void run(){
        		try{
        			int waited = 0;
        			while(_active && (waited < _splashtime)){
        				sleep(100);
        				if(_active){
        					waited += 100;
        				}
        			}
        		} catch(Exception e){
        		
        		}finally{
        			startActivity(new Intent(MainActivity.this, StartScreen.class));
        			finish();
        		}
        	};
        };
        splashThread.start();
        
        /*
        int secondsDelayed = 3;
        new Handler().postDelayed(new Runnable() {
        	public void run() {
        		startActivity(new Intent(MainActivity.this, StartScreen.class));
        		finish();
        	}
        }, secondsDelayed * 1000);
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
