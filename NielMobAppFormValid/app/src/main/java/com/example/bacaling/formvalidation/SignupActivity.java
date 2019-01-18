package com.example.bacaling.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText etUsername, etPassword , etFullName,etConfirmPassword;
    RadioButton rbMale, rbFemale;
    int formsuccess;
    String username , password , fullname , confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etFullName = findViewById(R.id.etFullName);
        etPassword = findViewById(R.id.etPassword);
        etUsername = findViewById(R.id.etUsername);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_cancel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.btnSave:
                formsuccess = 5;

                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                confirmPassword = etConfirmPassword.getText().toString();
                fullname = etFullName.getText().toString();

                if (username.equals("")){
                    etUsername.setError("This field is required");
                    formsuccess--;
                }
                if (password.equals("")){
                    etPassword.setError("This field is required");
                    formsuccess--;
                }
                if (confirmPassword.equals("")){
                    etConfirmPassword.setError("This field is required");
                    formsuccess--;
                }
                if (!confirmPassword.equals(password)){
                    etConfirmPassword.setError("Password mismatched");
                    formsuccess--;
                }
                if (fullname.equals("")){
                    etFullName.setError("This field is required");
                    formsuccess--;
                }
                if (formsuccess == 5){
                    Toast.makeText(this, "Form Successfully Validated", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCancel:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
