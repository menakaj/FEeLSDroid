package com.hackers.FEELSDroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                login(view);
//                Login login = new Login();

            }
        });



    }
    public void login(View view){
        Intent intent = new Intent(this, Login.class);
//        intent.putExtra("hi", "dfhjhfksdjsdf");
        startActivity(intent);
    }
}
