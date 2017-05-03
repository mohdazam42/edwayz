package com.edwayzapp.edwayz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

import com.edwayzapp.utils.Constants;
import com.edwayzapp.utils.Utils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userNameEt = null;
    private EditText passwordEt = null;
    private Button loginButton = null;
    private Button skipButton = null;
    private Button createNewAccBtn = null;
    private CheckBox rememberCb = null;
    private CheckBox forgotMeCb = null;

    SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        initListener();
    }

    private void initListener() {
        loginButton.setOnClickListener(this);
        skipButton.setOnClickListener(this);
        createNewAccBtn.setOnClickListener(this);
    }

    private void initViews() {
        userNameEt = (EditText) findViewById(R.id.user_name_et);
        passwordEt = (EditText) findViewById(R.id.password_et);
        loginButton = (Button) findViewById(R.id.login_button);
        skipButton = (Button) findViewById(R.id.skip_button);
        createNewAccBtn = (Button) findViewById(R.id.create_new_acc_btn);
        rememberCb = (CheckBox) findViewById(R.id.remember_me_cb);
        forgotMeCb = (CheckBox) findViewById(R.id.forgot_pass_cb);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                String msg = validation();
                if (msg.equalsIgnoreCase("")) {
                    if (Utils.isNetworkAvailable(LoginActivity.this)) {
                        startSelClass();
                        Utils.setSharedPref(LoginActivity.this, Constants.KEY_IS_LOGIN, "TRUE");
                    } else {
                        Toast.makeText(LoginActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case R.id.create_new_acc_btn:
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                break;
            case R.id.skip_button:
                startSelClass();
                break;  //4110323
        }
    }

    private String validation() {
        String msg = "";
        if (userNameEt.getText().toString().length() == 0 && passwordEt.getText().toString().length() == 0) {
            msg = "Please Enter Your Account Details";
            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_LONG).show();
            return msg;
        } else if (userNameEt.getText().toString().length() == 0) {
            msg = "Please Enter Your Username";
            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_LONG).show();
            return msg;
        } else if (!Utils.isValidEmail(userNameEt.getText().toString())) {
            msg = "Please Enter Valid Email Address";
            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_LONG).show();
            return msg;
        } else if (passwordEt.getText().toString().length() == 0) {
            msg = "Please Enter Your Password";
            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_LONG).show();
            return msg;
        }
        return msg;
    }

    private void startSelClass() {
        Intent intent = new Intent(LoginActivity.this, SelClassActivity.class);
        startActivity(intent);
        finish();
    }
}
