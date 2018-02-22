package com.example.percy.reto2_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class receptionActivity extends AppCompatActivity {
    TextView tvName,tvLastName,tvEmail,tvPhone,tvEdad;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception);

        tvName = (TextView) findViewById(R.id.tvName);
        tvLastName = (TextView) findViewById(R.id.tvLastName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvEdad = (TextView) findViewById(R.id.tvEdad);
        btnSend = (Button) findViewById(R.id.sendDates);
        recogerExtras();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareDate();
            }
        });
    }
    public void recogerExtras() {
        Bundle datos = this.getIntent().getExtras();
        String name = datos.getString("name");
        String last_name = datos.getString("last_name");
        String phone = datos.getString("phone");
        String email = datos.getString("email");
        String edad = datos.getString("edad");

        tvName.setText("Nombre: " + name);
        tvLastName.setText("Apeliidos: " + last_name);
        tvPhone.setText("Celular: " +phone);
        tvEmail.setText("Email: " + email);
        tvEdad.setText("Edad:" + edad);
    }
    public void shareDate() {
        String Mensaje = "Mis datos son:" +
                tvName.getText().toString() + "   "  +
                tvLastName.getText().toString() + "   "  +
                tvPhone.getText().toString() + "   "  +
                tvEmail.getText().toString() + "   "  +
                tvEdad.getText().toString() + " .";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, Mensaje);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
