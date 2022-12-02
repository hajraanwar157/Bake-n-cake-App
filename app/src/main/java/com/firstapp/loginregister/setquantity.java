package com.firstapp.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class setquantity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerlayout;
    NavigationView navigationview;
    Toolbar toolbar;
    ImageView image;
    TextView t;
    TextView displayInteger, tprice;
    int item_price;
    int minteger = 0, total = 0, quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setquantity);

        drawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationview = (NavigationView) findViewById(R.id.nav_view1);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        image = (ImageView) findViewById(R.id.imageView3);
        t = (TextView) findViewById(R.id.textView12);
        tprice = (TextView) findViewById(R.id.textView5);//total price textview id
        displayInteger = (TextView) findViewById(R.id.textView13);
//        setSupportActionBar(toolbar);

        navigationview.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawerlayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationview.setNavigationItemSelectedListener(this);
        navigationview.setCheckedItem(R.id.nav_hom);
        Intent intent = getIntent();
        String item_name = intent.getStringExtra("item");
        item_price = Integer.parseInt(intent.getStringExtra("price"));
        byte[] bytes = intent.getByteArrayExtra("img");
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        image.setImageBitmap(bitmap);
        t.setText(item_name.toString() + ": " + item_price);
    }

    @Override
    public void onBackPressed() {
        if (drawerlayout.isDrawerOpen(GravityCompat.START)) {
            drawerlayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_hom:
                Intent i = new Intent(getApplicationContext(), home_screen.class);
                startActivity(i);
                finish();

            case R.id.nav_contact:
                Intent intent2 = new Intent(getApplicationContext(), contact.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_Logout:
                Intent intent3 = new Intent(getApplicationContext(), LogIn.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.nav_about:
                Intent intent4 = new Intent(getApplicationContext(), About.class);
                startActivity(intent4);
                finish();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void increaseInteger(View view) {
        if (minteger <= 9) {
            minteger = minteger + 1;
            display(minteger);
        } else {
            Toast.makeText(getApplicationContext(), "Reached maximum quantity", Toast.LENGTH_SHORT).show();
        }

    }

    public void decreaseInteger(View view) {
        if (minteger >= 1) {
            minteger = minteger - 1;
            display(minteger);
        } else {
            Toast.makeText(getApplicationContext(), "Invalid quantity", Toast.LENGTH_SHORT).show();
        }
    }

    private void display(int number) {
        quantity=number;
        displayInteger.setText("" + number);
        total = item_price * number;
        tprice.setText("Total price:" + total);

    }
public void order(View v) {
    if (total != 0 && quantity != 0) {
        Toast.makeText(getApplicationContext(), "your order is confirmed please pickup your order", Toast.LENGTH_SHORT).show();
    }
    else {
        Toast.makeText(getApplicationContext(), "your order is not confrimed", Toast.LENGTH_SHORT).show();
    }
}

}