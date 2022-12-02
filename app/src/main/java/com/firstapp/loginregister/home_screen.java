package com.firstapp.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;

public class home_screen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{
DrawerLayout drawerlayout;
NavigationView navigationview;
Toolbar toolbar;
CardView card1,card2,card3,card4,card5,card6,card7,card8;
ImageView bread,confectionery,cookie,croissant,donut,pastry,waffle,cake;
TextView tbread,tconfectionery,tcookie,tcroissant,tdonut,tpastry,twaffle,tcake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        drawerlayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        navigationview=(NavigationView) findViewById(R.id.nav_view);
        toolbar=(Toolbar) findViewById(R.id.toolbar);

        card1=(CardView)findViewById(R.id.c1);
        card2=(CardView)findViewById(R.id.c2);
        card3=(CardView)findViewById(R.id.c3);
        card4=(CardView)findViewById(R.id.c4);
        card5=(CardView)findViewById(R.id.c5);
        card6=(CardView)findViewById(R.id.c6);
        card7=(CardView)findViewById(R.id.c7);
        card8=(CardView)findViewById(R.id.c8);

        bread=(ImageView)findViewById(R.id.breadimage);
        confectionery=(ImageView)findViewById(R.id.confectioneryimage);
        cookie=(ImageView)findViewById(R.id.cookieimage);
        croissant=(ImageView)findViewById(R.id.croissantimage);
        donut=(ImageView)findViewById(R.id.donutimage);
        pastry=(ImageView)findViewById(R.id.pastryimage);
        waffle=(ImageView)findViewById(R.id.Waffleimage);
        cake=(ImageView)findViewById(R.id.cakeimage);

        tbread=(TextView)findViewById(R.id.bread);
        tconfectionery=(TextView)findViewById(R.id.confectionery);
        tcookie=(TextView)findViewById(R.id.cookie);
        tcroissant=(TextView)findViewById(R.id.croissant);
        tdonut=(TextView)findViewById(R.id.donut);
        tpastry=(TextView)findViewById(R.id.pastry);
        twaffle=(TextView)findViewById(R.id.Waffle);
        tcake=(TextView)findViewById(R.id.cake);
//        setSupportActionBar(toolbar);
        navigationview.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle
                (this,drawerlayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationview.setNavigationItemSelectedListener(this);
       navigationview.setCheckedItem(R.id.nav_hom);
       card1.setOnClickListener(this);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);
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
        break;

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
        Intent intent4=new Intent(getApplicationContext(),About.class);
        startActivity(intent4);
        finish();
        break;
    default:
        throw new IllegalStateException("Unexpected value: " + item.getItemId());
}
drawerlayout.closeDrawer(GravityCompat.START);
    return true;
    }

    @Override
    public void onClick(View v) {
        String str = null;
        String price=null;
        ImageView img = null;
        switch(v.getId())
        {
            case R.id.c1:
                str=tbread.getText().toString();
                img=bread;
                price="100";

                break;
            case R.id.c2:
                str=tconfectionery.getText().toString();
                price="200";
                img=confectionery;
                break;
            case R.id.c3:
                str=tcookie.getText().toString();
                price="40";
               img=cookie;
                break;

            case R.id.c4:
                str=tcroissant.getText().toString();
                price="50";
                img=croissant;
                break;
            case R.id.c5:
                str=tdonut.getText().toString();
                price="80";
                img=donut;
                break;
            case R.id.c6:
                str=tpastry.getText().toString();
                price="150";
                img=pastry;
                break;
            case R.id.c7:
                str=twaffle.getText().toString();
                price="50";
               img=waffle;
                break;
            case R.id.c8:
                str=tcake.getText().toString();
                price="500";
                img=cake;
                break;
        }
        Intent intent=new Intent(getApplicationContext(), setquantity.class);
     intent.putExtra("img",imageViewToByte(img));
       intent.putExtra("price",price);
       intent.putExtra("item",str);
        startActivity(intent);
    }
    public byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap=((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,80,byteArrayOutputStream);
        byte[]bytes=byteArrayOutputStream.toByteArray();
        return bytes;
    }
}