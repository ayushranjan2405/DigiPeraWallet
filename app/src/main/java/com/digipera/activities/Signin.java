package com.digipera.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.dto.User;
import com.digipera.services.UserService;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        final Button button = (Button) findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String usernameStr = username.getText().toString();
                String passwordStr = password.getText().toString();

                User user = UserService.authenticate(usernameStr, passwordStr);
                if (user != null) {
                    Toast.makeText(Signin.this, "Signin SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    Intent intent = null;
                    if (user.getRelation().equalsIgnoreCase(Constants.PARENT)) {
                        intent = new Intent(getApplicationContext(), Dashboard.class);
                    } else if (user.getRelation().equalsIgnoreCase(Constants.DEPENDENT)) {
                        intent = new Intent(getApplicationContext(), DependentDashboard.class);
                    }
                    intent.putExtra("user", user);
                    startActivity(intent);
                } else {
                    Toast.makeText(Signin.this, "Signin FAILED !!! username Shilpi, Ishita, Rohan", Toast.LENGTH_SHORT).show();
                }


            }


        });

    }
}