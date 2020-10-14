package com.jikkk9.sns_project;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_sign_up);

        // 회원가입 로직 [회원가입을 누르면 로직이 찍히도록]

        findViewById(R.id.signUpButton).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.signUpButton:
                    Log.e("클릭","클릭");

                    break;
            }
        }
    };


    /// 회원가입 로직 [회원가입을 누르면 로직이 찍히도록]

}