package com.faizmalkani.floatingactionbutton.sample;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.faizmalkani.floatingactionbutton.FloatingActionButton;


public class MainActivity extends ActionBarActivity {

    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFab = (FloatingActionButton) findViewById(R.id.fabbutton);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.list_item, getResources().getStringArray(R.array.planets_array)));
        mFab.listenTo(listView);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this, About.class));
        return super.onOptionsItemSelected(item);
    }


    public void hideFab(View view) {
        mFab.hide(true);
        //getActionBar().hide();
    }

    public void showFab(View view) {
        mFab.hide(false);
        //getActionBar().show();
    }

    public void fabClicked(View view) {
        Toast.makeText(this, getResources().getString(R.string.hello_world), Toast.LENGTH_LONG)
                .show();
    }

    public void colorToggle(View view) {
        switch (view.getId()) {
            case R.id.blueButton: {
                int holoBlue = getResources().getColor(R.color.holo_blue_light);
                mFab.setColor(holoBlue);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(holoBlue));
                mFab.setDrawable(getResources().getDrawable(R.drawable.ic_content_new));
                break;
            }
            case R.id.purpleButton: {
                int holoPurple = getResources().getColor(R.color.holo_purple);
                mFab.setColor(holoPurple);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(holoPurple));
                mFab.setDrawable(getResources().getDrawable(R.drawable.ic_av_play));
                break;
            }
            case R.id.greenButton: {
                int holoGreen = getResources().getColor(R.color.holo_green_light);
                mFab.setColor(holoGreen);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(holoGreen));
                mFab.setDrawable(getResources().getDrawable(R.drawable.ic_content_discard));
                break;
            }
            case R.id.orangeButton: {
                int holoOrange = getResources().getColor(R.color.holo_orange_light);
                mFab.setColor(holoOrange);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(holoOrange));
                mFab.setDrawable(getResources().getDrawable(R.drawable.ic_social_add_person));
                break;
            }
            case R.id.redButton: {
                int holoRed = getResources().getColor(R.color.holo_red_light);
                mFab.setColor(holoRed);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(holoRed));
                mFab.setDrawable(getResources().getDrawable(R.drawable.ic_navigation_accept));
                break;
            }
        }
    }

}
