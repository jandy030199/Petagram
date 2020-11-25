package com.amadeus.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtEMail;
    private EditText edtMessage;
    private EditText edtName;

    private Button btnSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtEMail = (EditText) findViewById(R.id.edtEmail);
        edtMessage = (EditText) findViewById(R.id.edtMessage);
        edtName = (EditText) findViewById(R.id.edtName);

        btnSendMessage = (Button) findViewById(R.id.btnSendMessage);

        btnSendMessage.setOnClickListener(this);

    }

    private void sendEmail() {

        String email = edtEMail.getText().toString().trim();
        String nombre = edtName.getText().toString().trim();
        String message = "Hola " + nombre + ", \n"+ "Hemos recibido tu mensaje.\nPronto nos comunicaremos contigo, gracias por contactarnos.";


        SendMail sendMail = new SendMail(this, email, message);

        if(nombre == "" && email == ""){

            Toast.makeText(this,"Ingrese su Nombre y Correo electrónico",Toast.LENGTH_LONG).show();

        }
        else {

            sendMail.execute();
        }



    }

    @Override
    public void onClick(View view) {
        sendEmail();

    }
}