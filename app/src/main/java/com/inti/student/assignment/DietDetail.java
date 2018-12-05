package com.inti.student.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.inti.student.assignment.Model.Diet;
import com.squareup.picasso.Picasso;

public class DietDetail extends AppCompatActivity {

    TextView diet_name,diet_protein,diet_calcium,diet_carbohydrate,diet_fat,diet_water,diet_vitamin,diet_calories;
    ImageView diet_image;

    String DietsId="";

    FirebaseDatabase database;
    DatabaseReference diets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_detail);

        database = FirebaseDatabase.getInstance();
        diets = database.getReference("Diets");


        diet_name = (TextView)findViewById(R.id.diet_name);
        diet_protein = (TextView)findViewById(R.id.diet_protein);
        diet_image = (ImageView)findViewById(R.id.diet_image);
        diet_calcium = (TextView)findViewById(R.id.diet_calcium);
        diet_carbohydrate = (TextView)findViewById(R.id.diet_carbohydrate);
        diet_fat = (TextView)findViewById(R.id.diet_fat);
        diet_water = (TextView)findViewById(R.id.diet_water);
        diet_vitamin = (TextView)findViewById(R.id.diet_vitamin);
        diet_calories = (TextView)findViewById(R.id.diet_calories);


        if(getIntent() !=null)
            DietsId = getIntent().getStringExtra("DietsId");
        if(!DietsId.isEmpty())
        {
            getDetailDiet(DietsId);
        }



    }

    private void getDetailDiet(String DietsId) {
        diets.child(DietsId).addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                Diet diet = dataSnapshot.getValue(Diet.class);

                Picasso.with(getBaseContext()).load(diet.getImage())
                        .into(diet_image);

                diet_name.setText(diet.getName());
                diet_protein.setText(diet.getProtein());
                diet_calcium.setText(diet.getCalcium());
                diet_carbohydrate.setText(diet.getCarbohydrate());
                diet_fat.setText(diet.getFat());
                diet_water.setText(diet.getWater());
                diet_vitamin.setText(diet.getVitamin());
                diet_calories.setText(diet.getCalories());

            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }

        });
    }
}