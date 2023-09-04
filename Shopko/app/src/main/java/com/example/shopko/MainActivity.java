package com.example.shopko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
{

    TextInputEditText    user;
    TextInputEditText    password;
    TextView    register_now;
    Button      login_btn;


    String User = "Rasikh12", Pass = "Rasikh12";

    public void to_Register(View view)
    {
        register_now = (TextView) findViewById(R.id.to_register);

        register_now.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user        = (TextInputEditText) findViewById(R.id.username);
        password    = (TextInputEditText) findViewById(R.id.password);
        login_btn   = (Button) findViewById(R.id.loginbtn);

        login_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String usern = user.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(usern.isEmpty() && pass.isEmpty())
                {
                    user.setError("");
                    password.setError("");
                    Toast.makeText(MainActivity.this, "Error: Enter Username & Password", Toast.LENGTH_SHORT).show();
                }
                else if(usern.isEmpty())
                {
                    user.setError("");
                    Toast.makeText(MainActivity.this, "Error: Enter Username", Toast.LENGTH_SHORT).show();
                }
                else if(pass.isEmpty())
                {
                    password.setError("");
                    Toast.makeText(MainActivity.this, "Error: Enter Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    userLogin(usern,pass);
                }
            }
            private void userLogin(String userN, String pass)
            {
                String getus = "", getpas = "";
                Bundle intent = getIntent().getExtras();
                if(intent != null)
                {
                    getus = intent.getString("sendUsername");
                    getpas = intent.getString("sendPassword");
                }

                if(userN == User && pass == Pass)
                {
                    Intent intent1 = new Intent(MainActivity.this, Dashboard.class);
                    intent1.putExtra("User", userN);
                    startActivity(intent1);
                    finish();
                }
                else if(userN == getus && pass == getpas)
                {
                    Intent intent1 = new Intent(MainActivity.this, Dashboard.class);
                    intent1.putExtra("User", userN);
                    startActivity(intent1);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Wrong Credentials...", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}