package com.inti.student.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inti.student.assignment.Common.Common;
import com.inti.student.assignment.Interface.ItemClickListener;
import com.inti.student.assignment.Model.CategoryDiet;
import com.inti.student.assignment.Model.CategoryExercise;
import com.inti.student.assignment.ViewHolder.MenuViewHolder;
import com.squareup.picasso.Picasso;
public class Exercise extends AppCompatActivity {

    FirebaseDatabase database;
    GridLayout mainGrid;
    ImageView view1,view2,view3,view4;
    TextView txtFullName;

    RecyclerView recycler_exercise;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        //firebase
        database = FirebaseDatabase.getInstance();

        //User Name
        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtFullName.setText(Common.currentUser.getEmail());
        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        view1 = (ImageView)findViewById(R.id.view1);
        view2 = (ImageView)findViewById(R.id.view2);
        view3 = (ImageView)findViewById(R.id.view3);
        view4 = (ImageView)findViewById(R.id.view4);

        view1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent diet = new Intent(Exercise.this,ABS.class);
                startActivity(diet);
            }
        });

        view2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent exercise = new Intent(Exercise.this,ARM.class);
                startActivity(exercise);
            }
        });

        view3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent supplement = new Intent(Exercise.this,BACK.class);
                startActivity(supplement);
            }
        });

        view4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent supplement = new Intent(Exercise.this,CHEST.class);
                startActivity(supplement);
            }
        });

    }
}