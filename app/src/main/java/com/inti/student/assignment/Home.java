package com.inti.student.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inti.student.assignment.Common.Common;

public class Home extends AppCompatActivity {

    FirebaseDatabase database;
    GridLayout mainGrid;
    ImageView view1,view2,view3;
    Button btn_log_out;

    TextView txtFullName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //firebase
        database = FirebaseDatabase.getInstance();

        //User Name
        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtFullName.setText(Common.currentUser.getEmail());
        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        view1 = (ImageView)findViewById(R.id.view1);
        view2 = (ImageView)findViewById(R.id.view2);
        view3 = (ImageView)findViewById(R.id.view3);


        view1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent diet = new Intent(Home.this,Diet.class);
                startActivity(diet);
            }
        });

        view2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent exercise = new Intent(Home.this,Exercise.class);
                startActivity(exercise);
            }
        });

        view3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent supplement = new Intent(Home.this,Supplement.class);
                startActivity(supplement);
            }
        });

    }
}