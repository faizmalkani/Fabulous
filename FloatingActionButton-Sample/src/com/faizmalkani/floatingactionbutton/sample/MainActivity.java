package com.faizmalkani.floatingactionbutton.sample;

import com.faizmalkani.floatingactionbutton.Fab;
import com.faizmalkani.floatingactionbutton.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity 
{
	
	Fab mFab;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    	mFab = (Fab)findViewById(R.id.fabbutton);
    	mFab.setFabColor(Color.WHITE);
    	mFab.setFabDrawable(getResources().getDrawable(R.drawable.ic_content_edit));
    	getActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
    }
    
    
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) 
    {
    	 MenuInflater inflater = getMenuInflater();
    	    inflater.inflate(R.menu.main, menu);
    	    return true;
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		startActivity(new Intent(this, About.class));
		return super.onOptionsItemSelected(item);
	}



	public void hideFab(View view)
    {
    	mFab.hideFab();
    	getActionBar().hide();
    }
    
    public void showFab(View view)
    {
    	mFab.showFab();
    	getActionBar().show();
    }
    
    public void colorToggle(View view)
    {
    	switch(view.getId())
    	{
    		case R.id.blueButton:
    		{
    			int holoBlue = getResources().getColor(android.R.color.holo_blue_light);
    			mFab.setFabColor(holoBlue);
    			getActionBar().setBackgroundDrawable(new ColorDrawable(holoBlue));
    			mFab.setFabDrawable(getResources().getDrawable(R.drawable.ic_content_new));
    			break;
    		}
    		case R.id.purpleButton:
    		{
    			int holoPurple = getResources().getColor(android.R.color.holo_purple);
    			mFab.setFabColor(holoPurple);
    			getActionBar().setBackgroundDrawable(new ColorDrawable(holoPurple));
    			mFab.setFabDrawable(getResources().getDrawable(R.drawable.ic_av_play));
    			break;
    		}
    		case R.id.greenButton:
    		{
    			int holoGreen = getResources().getColor(android.R.color.holo_green_light);
    			mFab.setFabColor(holoGreen);
    			getActionBar().setBackgroundDrawable(new ColorDrawable(holoGreen));
    			mFab.setFabDrawable(getResources().getDrawable(R.drawable.ic_content_discard));
    			break;
    		}
    		case R.id.orangeButton:
    		{
    			int holoOrange = getResources().getColor(android.R.color.holo_orange_light);
    			mFab.setFabColor(holoOrange);
    			getActionBar().setBackgroundDrawable(new ColorDrawable(holoOrange));
    			mFab.setFabDrawable(getResources().getDrawable(R.drawable.ic_social_add_person));
    			break;
    		}
    		case R.id.redButton:
    		{
    			int holoRed = getResources().getColor(android.R.color.holo_red_light);
    			mFab.setFabColor(holoRed);
    			getActionBar().setBackgroundDrawable(new ColorDrawable(holoRed));
    			mFab.setFabDrawable(getResources().getDrawable(R.drawable.ic_navigation_accept));
    			break;
    		}
    	}
    }
    
}
