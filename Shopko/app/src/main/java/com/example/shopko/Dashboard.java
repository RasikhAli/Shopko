package com.example.shopko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity
{
    String getUs = "";
    Button logout, add, show;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        user = (TextView) findViewById(R.id.usernameText);
        logout = (Button) findViewById(R.id.logout);
        add = (Button) findViewById(R.id.additems);
        show = (Button) findViewById(R.id.productsBtn);

        Bundle intent = getIntent().getExtras();
        if(intent != null)
        {
            getUs = intent.getString("User");
            user.setText(getUs);
        }
        Toast.makeText(Dashboard.this, "Hello " + getUs + ", Welcome to ShopKo", Toast.LENGTH_SHORT).show();

        logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        show.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });

        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(Dashboard.this, AddItems.class);
                startActivity(intent1);
            }
        });

    }
}