package com.hackers.FEELSDroid;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

/**
 * Created by menaka on 4/3/15.
 */
public class Login extends Activity {
    private String res;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        final EditText regNo = (EditText) findViewById(R.id.editText);
        final EditText password = (EditText) findViewById(R.id.editText2);
        final Button btnlogin = (Button) findViewById(R.id.btn_login);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * Thread to invoke login.
                 * */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
                        postParameters.add(new BasicNameValuePair("username", regNo.getText().toString()));
                        postParameters.add(new BasicNameValuePair("password", password.getText().toString()));
                        String response = null;
                        try{
                            response = SimpleHttpClient.executeHttpPost("http://localhost:8080/login/index.php", postParameters);
                            res = response.toString();
                            res = res.replaceAll("\\s+","");
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();

                String regNO = regNo.getText().toString();
                String pwd = password.getText().toString();

                if(regNO.isEmpty()){
                    regNo.setBackgroundColor(Color.RED);
                    Toast.makeText(getApplicationContext(), "Enter registration number..!!!", Toast.LENGTH_LONG).show();
                }else if(pwd.isEmpty()){
                    password.setBackgroundColor(Color.RED);
                    Toast.makeText(getApplicationContext(), "Enter Password...!!!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_LONG).show();
                    gotoHome(view);
                }
            }
        });

    }


    public void gotoHome(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

}