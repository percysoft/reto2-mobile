package com.example.percy.reto2_mobile;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText etName,etLastName,etPhone,etEmail,etEdad;
    TextInputLayout tilName,tilLastName,tilPhone,tilEmail,tilEdad;
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

        tilName = (TextInputLayout) findViewById(R.id.tilName);
        tilLastName = (TextInputLayout) findViewById(R.id.tilLastName);
        tilPhone = (TextInputLayout) findViewById(R.id.tilPhone);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        tilEdad = (TextInputLayout) findViewById(R.id.tilEdad);

        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        if(!isvalidateCampo(etName,tilName,R.string.error_name)) {
            return;
        }
        if(!isvalidateCampo(etLastName,tilLastName,R.string.error_lastname)) {
            return;
        }
        if(!isvalidateCampo(etPhone,tilPhone,R.string.error_phone)) {
            return;
        }
        if(!isvalidateCampo(etEdad,tilEdad,R.string.error_edad)) {
            return;
        }
        if(!isvalidateCampo(etEmail,tilEmail,R.string.error_email)) {
            return;
        }
        if(!isvalidateEmail(etEmail.getText().toString())){
            tilEmail.setError(getString(R.string.error_email_invalidate));
            etEmail.requestFocus();
            return;
        } else {
            tilEmail.setErrorEnabled(false);
        }
        lanzarActivity();

    }
    public static final Pattern EMAIL_ADDRESS
            = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
    private boolean isvalidateEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    private boolean isvalidateCampo(EditText editText, TextInputLayout textInputLayout,int errorString) {
        if(editText.getText().toString().trim().isEmpty()) {
            textInputLayout.setError(getString(errorString));
            editText.requestFocus();
            return false;
        }
        else {
            textInputLayout.setErrorEnabled(false);
        }
            return true;
    }

    public void lanzarActivity() {
        String name= etName.getText().toString();
        String last_name= etLastName.getText().toString();
        String phone= etPhone.getText().toString();
        String email= etEmail.getText().toString();
        String edad= etEdad.getText().toString();

        Intent i = new Intent(this, receptionActivity.class);
        i.putExtra("name", name);
        i.putExtra("last_name", last_name);
        i.putExtra("phone", phone);
        i.putExtra("email", email);
        i.putExtra("edad", edad);
        startActivity(i);
    }
}
