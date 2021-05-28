package com.example.firestorelearningproject2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    TextView uName, uEmail;
    Button bckBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        uName = findViewById(R.id.userNameTv);
        uEmail = findViewById(R.id.userEmailTv);
        bckBtn = findViewById(R.id.backBtn);

        uName.setText(getIntent().getStringExtra("uname"));
        uEmail.setText(getIntent().getStringExtra("uemail"));

        bckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detail.this, MainActivity.class));
                finish();
            }
        });
    }
}