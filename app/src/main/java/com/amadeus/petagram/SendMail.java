package com.amadeus.petagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail extends AsyncTask<Void,Void,Void> {

    private Context context;
    private Session session;
    private View view;

    private String email;
    private String subject = "CONTACTO";
    private String message;

    private ProgressDialog progressDialog;

    public SendMail(Context context, String email, String message) {
        this.context = context;
        this.email = email;
        this.message = message;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    //Authenticating the password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(DataMail.email, DataMail.password);
                    }
                });

        try {

            MimeMessage mm = new MimeMessage(session);


            mm.setFrom(new InternetAddress(DataMail.email));

            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            mm.setSubject(subject);

            mm.setText(message);


            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(context,"Enviando Mensaje","Por favor Espere...",false,false);
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressDialog.dismiss();

        Toast.makeText(context,"Mensaje Enviado!",Toast.LENGTH_LONG).show();
        super.onPostExecute(aVoid);
    }
}
