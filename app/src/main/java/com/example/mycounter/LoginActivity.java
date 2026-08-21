package com.example.mycounter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        // 找到登录按钮
        Button loginButton = findViewById(R.id.btn_login);
        
        // 设置点击事件
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 出 Toast 提示登录成功
                Toast.makeText(LoginActivity.this, getString(R.string.login_success_toast), Toast.LENGTH_SHORT).show();
            }
        });
    }
}