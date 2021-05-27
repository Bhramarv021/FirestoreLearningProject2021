package com.example.firestorelearningproject2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText userName, userEmail;
    Button submit;
    FirebaseFirestore fireStoreRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.name);
        userEmail = findViewById(R.id.email);
        submit = findViewById(R.id.addBtn);

        fireStoreRoot = FirebaseFirestore.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    public void insertData(){
        Map<String , String > items = new HashMap<>();
        items.put("name", userName.getText().toString().trim());
        items.put("email", userEmail.getText().toString().trim());

        fireStoreRoot.collection("students").add(items)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        userName.setText("");
                        userEmail.setText("");
                        Toast.makeText(MainActivity.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}