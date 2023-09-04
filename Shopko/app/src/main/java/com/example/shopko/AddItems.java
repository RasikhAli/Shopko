package com.example.shopko;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class AddItems extends AppCompatActivity
{

    Button goback, submit_btn;
    TextInputEditText ProductName;
    TextInputEditText Category;
    TextInputEditText Price;
    ImageView Image;
    Uri imageUri1;

    boolean uploaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        goback = (Button) findViewById(R.id.goBack);
        ProductName = (TextInputEditText) findViewById(R.id.productName);
        Category = (TextInputEditText) findViewById(R.id.category);
        Price = (TextInputEditText) findViewById(R.id.price);
        submit_btn = (Button) findViewById(R.id.submit);
        Image = (ImageView) findViewById(R.id.image);

        goback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AddItems.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        Image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGallery, 100);
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                boolean check = false;

                if (ProductName.getText().toString().trim().isEmpty())
                {
                    check = true;
                    ProductName.setError("Please Enter Product Name...");
                    ProductName.requestFocus();
                } else {
                    check = false;
                }

                if (Category.getText().toString().trim().isEmpty())
                {
                    check = true;
                    Category.setError("Please Enter Category...");
                    Category.requestFocus();
                } else {
                    check = false;
                }

                if (Price.getText().toString().trim().isEmpty())
                {
                    check = true;
                    Price.setError("Please Enter Price...");
                    Price.requestFocus();
                } else {
                    check = false;
                }

                if(uploaded == false)
                {
                    check = true;
                }

                if(check == false)
                {
                    String product = ProductName.getText().toString();
                    String category = Category.getText().toString();
                    String price = Price.getText().toString();

                    Intent intent = new Intent(AddItems.this, Products.class);
                    intent.putExtra("sendProductName", product);
                    intent.putExtra("sendCategory", category);
                    intent.putExtra("sendPrice", price);
                    startActivity(intent);
                }
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                imageUri1 = data.getData();
                Image.setImageURI(imageUri1);
                uploaded = true;
            }
        }
    }
}