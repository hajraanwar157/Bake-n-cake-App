package com.firstapp.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class About extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerlayout;
    NavigationView navigationview;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        drawerlayout=(DrawerLayout) findViewById(R.id.drawer2);
        navigationview=(NavigationView) findViewById(R.id.nav_view2);
        toolbar=(Toolbar) findViewById(R.id.toolbar2);
        navigationview.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle
                (this,drawerlayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationview.setNavigationItemSelectedListener(this);
        navigationview.setCheckedItem(R.id.nav_about);
    }
    @Override
    public void onBackPressed()
    {
        if(drawerlayout.isDrawerOpen(GravityCompat.START)){
            drawerlayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.nav_hom:
                Intent i=new Intent(getApplicationContext(),home_screen.class);
                startActivity(i);
                finish();
            case R.id.nav_contact:
                Intent intent2=new Intent(getApplicationContext(),contact.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_Logout:
                Intent intent3=new Intent(getApplicationContext(),LogIn.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.nav_about:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }
}