package com.example.percy.reto2_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ClaseActivity extends AppCompatActivity {

    TextView tvName,tvLastName,tvPhone,tvEmail,tvEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase);

        tvName = (TextView) findViewById(R.id.tvName);
        tvLastName = (TextView) findViewById(R.id.tvLastName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvEdad = (TextView) findViewById(R.id.tvEdad);
        recogerExtras();

    }

    public void recogerExtras() {
        Bundle datos = this.getIntent().getExtras();
        String name = datos.getString("name");
        String last_name = datos.getString("last_name");
        String phone = datos.getString("phone");
        String email = datos.getString("email");
        String edad = datos.getString("edad");

        tvName.setText(name);
        tvLastName.setText(last_name);
        tvPhone.setText(phone);
        tvEmail.setText(email);
        tvEdad.setText(edad);

    }
}
