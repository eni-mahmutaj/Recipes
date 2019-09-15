package com.example.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private int counter = 5;
    private Button SigninButton;
    private TextView tvinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        tvinfo = (TextView) findViewById(R.id.tvinfo);
        SigninButton = (Button)findViewById(R.id.SigninButton);
        tvinfo.setText("Number of attempts remaining: 5");

        SigninButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate(username.getText().toString(),
                        password.getText().toString());
            }
        });
    }
    private void validate (String username, String password){
        if ((username.equals("Admin")) && (password.equals("1234" ))){

            Intent intent = new Intent(this,MainActivity.class);

            startActivity(intent);
        } else {
            counter --;
            tvinfo.setText("Number of attempts remaining: " +
                    String.valueOf(counter));
            if (counter ==0){

                SigninButton.setEnabled(false);
            }
        }
    }
}

