package varun.exynosynergy.intelloclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextEmail;
    EditText mTextPhone;
    EditText mTextGender;
    EditText mTextAge;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextEmail = (EditText)findViewById(R.id.edittext_email);
        mTextPhone = (EditText)findViewById(R.id.edittext_phone);
        mTextGender = (EditText)findViewById(R.id.edittext_gender);
        mTextAge = (EditText)findViewById(R.id.edittext_age);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText)findViewById(R.id.edittext_cnfpassword);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mTextViewLogin = (TextView) findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(LoginIntent);

            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String email = mTextEmail.getText().toString().trim();
                String phone = mTextPhone.getText().toString().trim();
                String gender = mTextGender.getText().toString().trim();
                String age = mTextAge.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,email, phone,gender, age, pwd);
                    if(val > 0){
                    Toast.makeText(RegisterActivity.this,"You have registered",Toast.LENGTH_SHORT).show();
                    Intent moveToLogin = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(moveToLogin);
                    }else{
                        Toast.makeText(RegisterActivity.this,"Registration error",Toast.LENGTH_SHORT).show();
                    }
                }
                else{

                    Toast.makeText(RegisterActivity.this,"Password doesn't match",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
