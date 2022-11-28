package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.firebase.FirebaseUtil;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private EditText password;
    private Button login;
    private FirebaseUtil firebaseUtil;
    private FirebaseFirestore db;

    public void init() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
//        firebaseUtil = FirebaseUtil.getInstance();
//        firebaseUtil.init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        init();
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                Toast.makeText(this, username.getText().toString(), Toast.LENGTH_LONG).show();
                Map<String, Object> users = new HashMap<>();
                users.put("username", "Los Angeles");
                users.put("password", "CA");
                db.collection("users").add(users).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println("111111111111111111111111111111111111111111111111");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("222222222222222222222222222222222222222222222222");
                    }
                });
//                firebaseUtil.insert("users",users);
                break;
            default:
                break;
        }
    }
}