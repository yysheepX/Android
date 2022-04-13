package com.example.myproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import java.util.Map;
import java.util.prefs.PreferenceChangeEvent;

public class MainActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private CheckBox remember;
    private Button login;
    private Button register;

    //重写方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //所有初始化封装到此方法中
        initView();

        Map<String, String> userInfo = SPSaveQQ.getUserInfo(this); //获取用户信息
        if (userInfo !=null){
            et_username.setText(userInfo.get("account"));
            et_password.setText(userInfo.get("password"));
        }

    }//onCreat


    private void initView() {
        //绑定控件，这样变量就代表了被绑定的控件
        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        remember=findViewById(R.id.remeber);
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);



        //注册控件的点击事件
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到注册界面，并实现注册功能
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivityForResult(intent, 1);
            }
        });//跳转至注册

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                switch (v2.getId()) {
                    case R.id.re_t:
                        String account = et_username.getText().toString().trim();
                        String password = et_password.getText().toString().trim();

                        if (TextUtils.isEmpty(account)) {
                            Toast.makeText(MainActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (TextUtils.isEmpty(password)) {
                            Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                            return;
                        }
                            Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }



}//max

