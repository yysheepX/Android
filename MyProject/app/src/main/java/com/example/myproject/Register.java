package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    //申明布局文件中用到的变量
    private EditText re_username;
    private EditText re_password;
    private Button re_t;
    private Button re_f;

    //重写方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView2();
    }

    private void initView2() {
        re_t=findViewById(R.id.re_t);
        re_f=findViewById(R.id.re_f);
        re_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到登陆界面
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivityForResult(intent, 1);
            }
        });

       re_t.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               switch (view.getId()) {
                   case R.id.re_t:
                       String account = re_username.getText().toString().trim();
                       String password = re_password.getText().toString().trim();

                       if (TextUtils.isEmpty(account)) {
                           Toast.makeText(Register.this, "请输入账号", Toast.LENGTH_SHORT).show();
                           return;
                       }
                       if (TextUtils.isEmpty(password)) {
                           Toast.makeText(Register.this, "请输入密码", Toast.LENGTH_SHORT).show();
                           return;}
                           Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();

                       //保存用户信息
                       //保存方法
                       boolean isSavaSuccess = SPSaveQQ.savaUserInfo(Register.this, account, password);

                       if (isSavaSuccess) {
                               Toast.makeText(Register.this, "保存成功", Toast.LENGTH_SHORT).show();
                           } else {
                               Toast.makeText(Register.this, "保存失败", Toast.LENGTH_SHORT).show();
                           }
                           break;

               }
           }
       });

}//initView2









}


