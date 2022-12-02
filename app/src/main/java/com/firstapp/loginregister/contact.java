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

public class contact extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerlayout;
    NavigationView navigationview;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        drawerlayout=(DrawerLayout) findViewById(R.id.drawer3);
        navigationview=(NavigationView) findViewById(R.id.nav_view3);
        toolbar=(Toolbar) findViewById(R.id.toolbar3);
        navigationview.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle
                (this,drawerlayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationview.setNavigationItemSelectedListener(this);
        navigationview.setCheckedItem(R.id.nav_contact);
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
                break;
            case R.id.nav_Logout:
                Intent intent3=new Intent(getApplicationContext(),LogIn.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.nav_about:
                Intent intent2=new Intent(getApplicationContext(),About.class);
                startActivity(intent2);
                finish();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }
}