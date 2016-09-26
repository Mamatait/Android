package com.example.admin.res;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText editTextUserName,editTextPassword,editTextConfirmPassword,editcity,editmobile;
    Button btnCreateAccount;
    LoginDataBaseAdapter loginDataBaseAdapter;
    String emobPattern="[0-9]{10}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        editTextUserName = (EditText) findViewById(R.id.ed);
        editTextPassword = (EditText) findViewById(R.id.ed2);
        editTextConfirmPassword = (EditText) findViewById(R.id.ed3);
        editcity = (EditText) findViewById(R.id.ed4);
        editmobile = (EditText) findViewById(R.id.ed5);

        btnCreateAccount= (Button) findViewById(R.id.button3);


        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();
                String confirmPassword=editTextConfirmPassword.getText().toString();

                // check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!editmobile.getText().toString().matches(emobPattern))
                {
                    Toast.makeText(getApplicationContext(),"Enter valid phone number",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                }
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}


