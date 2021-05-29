package com.example.firestorelearningproject2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class firebaseQueryDemo extends AppCompatActivity {

    TextView dataTv;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_query_demo);

        dataTv = findViewById(R.id.textData);
        firebaseFirestore = FirebaseFirestore.getInstance();

        dataTv.setText("");
        fetchData();
    }

    public void fetchData(){
//        firebaseFirestore.collection("students").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        for(QueryDocumentSnapshot q : queryDocumentSnapshots)
//                            dataTv.append(" "+q.getString("name")+" : "+q.getString("email")+"\n\n");
//                    }
//                });

        firebaseFirestore.collection("students").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for(QueryDocumentSnapshot q : queryDocumentSnapshots){
                            String data = q.getString("name");
                            if(data.contains("an")){
                                dataTv.append("Hello "+q.getString("name")+"\n\n");
                            }
                        }
                    }
                });
    }
}