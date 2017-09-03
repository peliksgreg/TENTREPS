package com.google.maps.android.utils.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class SelectBillboard extends AppCompatActivity {

    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_question);

        Firebase.setAndroidContext(this);

        Button billboard1 = (Button) findViewById(R.id.btn1);
        Button billboard2 = (Button) findViewById(R.id.btn2);

        billboard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRef = new Firebase("https://ibol-936d7.firebaseio.com/quizzes/billboard1/is_completed");

               mRef.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {

                       String value = dataSnapshot.getValue(String.class);

                       if(value.equals("True")){

                           Toast.makeText(SelectBillboard.this, "Quiz already answered", Toast.LENGTH_SHORT).show();
                       } else {
                           startActivity(new Intent(SelectBillboard.this, Billboard1.class));
                       }
                   }

                   @Override
                   public void onCancelled(FirebaseError firebaseError) {
                       Toast.makeText(SelectBillboard.this, "Activity cancelled", Toast.LENGTH_SHORT).show();
                   }
               });

            }
        });

        billboard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRef = new Firebase("https://ibol-936d7.firebaseio.com/quizzes/billboard2/is_completed");

                mRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        String value = dataSnapshot.getValue(String.class);

                        if(value.equals("True")){

                            Toast.makeText(SelectBillboard.this, "Quiz already answered", Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(SelectBillboard.this, Billboard2.class));
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                        Toast.makeText(SelectBillboard.this, "Activity cancelled", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}
