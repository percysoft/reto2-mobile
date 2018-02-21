package com.example.percy.reto2_mobile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName,etLastName,etPhone,etEmail,etEdad;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etEdad = (EditText) findViewById(R.id.etEdad);

        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().equals("") || etName.getText().toString().equals(null)) {
                    Context context = getApplicationContext();
                    CharSequence text = "Falta llenar datos!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    lanzarActivity();
                }
            }
        });
    }
    public void lanzarActivity() {
        String name= etName.getText().toString();
        String last_name= etLastName.getText().toString();
        String phone= etPhone.getText().toString();
        String email= etEmail.getText().toString();
        String edad= etEdad.getText().toString();

        Intent i = new Intent(this, ClaseActivity.class);
        i.putExtra("name", name);
        i.putExtra("last_name", last_name);
        i.putExtra("phone", phone);
        i.putExtra("email", email);
        i.putExtra("edad", edad);
        startActivity(i);
    }
}
