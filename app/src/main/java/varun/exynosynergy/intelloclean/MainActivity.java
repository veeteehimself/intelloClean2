package varun.exynosynergy.intelloclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class
MainActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    EditText name,email,phone,gender,age,pass;
    Button mButtonLogin;
    TextView mTextViewRegister;
    static DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mTextViewRegister = (TextView) findViewById(R.id.textview_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registerIntent);

            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);
                if(res==true)
                {
                    Toast.makeText(MainActivity.this,"Successfully Logged In",Toast.LENGTH_SHORT).show();
                    /*Cursor c=MainActivity.db.getData(user,pwd);
                    String name2=c.getString(2);
                    String email2=c.getString(3);
                    String phone2=c.getString(4);
                    String gender2=c.getString(5);
                    String age2=c.getString(6);*/
                    Intent HomePage = new Intent(MainActivity.this,profile.class);
                    //HomePage.putExtra("name",name2);
                    startActivity(HomePage);

                }
                else
                {
                    Toast.makeText(MainActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
                    /*name.setText("");
                    email.setText("");
                    phone.setText("");
                    gender.setText("");
                    age.setText("");
                    pass.setText("");*/
                }
            }
        });

    }
}

