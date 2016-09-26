package com.example.admin.res;

        import android.app.Dialog;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;

    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(inti);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Methos to handleClick Event of Sign In Button
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.activity_main3);
                dialog.setTitle("Login");
                final EditText editTextUserName = (EditText) dialog.findViewById(R.id.editText3);
                final EditText editTextPassword = (EditText) dialog.findViewById(R.id.editText);

                Button btnSignIn = (Button) dialog.findViewById(R.id.button4);

                // Set On ClickListener
                btnSignIn.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        //get The User name and Password
                        String userName = editTextUserName.getText().toString();
                        String password = editTextPassword.getText().toString();

                        // fetch the Password form database for respective user name
                        String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

                        // check if the Stored password matches with  Password entered by user
                        if (password.equals(storedPassword)) {
                            Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        } else {
                            Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();

                        }
                        Intent intent=new Intent(MainActivity.this,Main4Activity.class);
                        startActivity(intent);
                    }
                });

                dialog.show();
            }
        });
    }
                //@Override
            protected void onDestroy() {
                super.onDestroy();
                // Close The Database
                loginDataBaseAdapter.close();
            }
}

