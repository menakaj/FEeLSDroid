package com.hackers.FEELSDroid;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by menaka on 4/3/15.
 */
public class Login extends Activity {
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
                String regNO = regNo.getText().toString();
                String pwd = password.getText().toString();

                if(regNO.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter registration number..!!!", Toast.LENGTH_LONG).show();
                }else if(pwd.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter Password...!!!", Toast.LENGTH_LONG).show();
                }else{

                    Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}