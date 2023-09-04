package com.example.shopko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {
    TextInputEditText email;
    TextInputEditText pass;
    TextInputEditText phonenum;
    TextInputEditText username;
    Spinner coun;
    DatePicker dob;
    Button submit;

    ArrayAdapter count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (TextInputEditText) findViewById(R.id.username);
        email = (TextInputEditText) findViewById(R.id.Email);
        pass = (TextInputEditText) findViewById(R.id.Password);
        phonenum = (TextInputEditText) findViewById(R.id.phonenum);
//        dob = (DatePicker) findViewById(R.id.datePicker);
        submit = (Button) findViewById(R.id.register);

        coun = (Spinner) findViewById(R.id.country);
        String[] con = {"Pakistan", "Iran", "India", "Lybia", "Kuwait", "Dubai"};
        count = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, con);
        coun.setAdapter(count);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                boolean check = true;

                if (email.getText().toString().trim().isEmpty()) {
                    check = true;
                    email.setError("Please Enter Email...");
                    email.requestFocus();
                } else {
                    check = false;
                }

                if (pass.getText().toString().trim().isEmpty()) {
                    check = true;
                    pass.setError("Please Enter Password...");
                    pass.requestFocus();
                } else {
                    check = false;
                }

                if (username.getText().toString().trim().isEmpty()) {
                    check = true;
                    username.setError("Please Enter Your Name...");
                    username.requestFocus();
                } else {
                    check = false;
                }

                if (phonenum.getText().toString().trim().isEmpty()) {
                    check = true;
                    phonenum.setError("Please Enter Your Age...");
                    phonenum.requestFocus();
                } else {
                    check = false;
                }
//
//                if (check == false)
//                {
//                    String mail = email.getText().toString().trim();
//                    String pas = pass.getText().toString().trim();
//                    String UName = username.getText().toString().trim();
//                    String phone = phonenum.getText().toString().trim();
////                    String birth = dob.toString();
////                    String count = coun.getSelectedItem().toString();
//
////                    Register(mail, pas, UName, phone, birth, count);
//                    Register(mail,pas,UName,phone);
//                }
            }
        });
    }
    public void Register(String mail, String pass, String Un, String ph)
    {
        Toast.makeText(Register.this, "Registered Successfully...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Register.this, MainActivity.class);
        intent.putExtra("sendUsername", Un);
        intent.putExtra("sendPassword", pass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }
}