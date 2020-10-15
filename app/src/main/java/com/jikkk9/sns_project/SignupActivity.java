package com.jikkk9.sns_project;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {
    private  static final String TAG = "SignupActivity"; //[ 신규 사용자 가입 필요한 변수 ]
    private FirebaseAuth mAuth; // Firebase 인증 [FirebaseAuth의 인스턴스를 선언합니다.]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_sign_up);

        // 회원가입 로직 [회원가입을 누르면 로직이 찍히도록]

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance(); // // Firebase 인증 [onCreate() 메서드에서 FirebaseAuth 인스턴스를 초기화합니다.]
        findViewById(R.id.signUpButton).setOnClickListener(onClickListener);
    }

    @Override
    public void onStart() { // Firebase 인증 [활동을 초기화할 때 사용자가 현재 로그인되어 있는지 확인합니다.]
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.signUpButton:
                    Log.e("클릭","클릭");
                    signUp();
                    break;
            }
        }
    };

   // 신규 사용자 가입
   // [createUserWithEmailAndPassword]
   // (/docs/reference/android/com/google/firebase/auth/FirebaseAuth.html#createUserWithEmailAndPassword(java.lang.String, java.lang.String)
   // 메서드를 사용하여 이메일 주소와 비밀번호를 가져와 유효성을 검사한 후 신규 사용자를 생성하는 새 createAccount 메서드를 만듭니다.
    private void signUp() {
        String email = ((EditText)findViewById(R.id.emailEditText)).getText().toString();
        String password = ((EditText)findViewById(R.id.passwordEditText)).getText().toString();


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        }

                        // ...
                    }
                });
        }


    /// 회원가입 로직 [회원가입을 누르면 로직이 찍히도록]

}