package com.firstapp.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUp extends AppCompatActivity {
TextInputEditText tusername,tfullname,temail,tpassword;
Button btn;
TextView t;
ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        tfullname=(TextInputEditText) findViewById(R.id.fullname);
        tusername=(TextInputEditText) findViewById(R.id.username);
        temail=(TextInputEditText) findViewById(R.id.email);
        tpassword=(TextInputEditText) findViewById(R.id.password);
        bar=(ProgressBar)findViewById(R.id.progress);
        btn=(Button) findViewById(R.id.buttonSignUp);
        t=(TextView)findViewById(R.id.loginText);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LogIn.class);
                startActivity(intent);
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname, username, password, email;
                fullname = String.valueOf(tfullname.getText());
                username = String.valueOf(tusername.getText());
                password = String.valueOf(tpassword.getText());
                email = String.valueOf(temail.getText());
                if (!fullname.equals("") && !username.equals("") && !password.equals("") && !email.equals("")) {
                    bar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[4];
                            field[0] = "fullname";
                            field[1] = "username";
                            field[2] = "password";
                            field[3] = "email";
                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = fullname;
                            data[1] = username;
                            data[2] = password;
                            data[3] = email;
                            PutData putData = new PutData("https://192.168.131.92/LoginRegister/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    bar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Sign Up Success"))
                                    { Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent i=new Intent(getApplicationContext(),LogIn.class);
                                        startActivity(i);
                                        finish();
                                        Log.i("PutData", result);
                                    }
                                     else
                                    {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }

                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"All fields required",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}