package com.inti.student.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inti.student.assignment.Interface.ItemClickListener;
import com.inti.student.assignment.Model.Diet;
import com.inti.student.assignment.ViewHolder.DietViewHolder;
import com.squareup.picasso.Picasso;

public class DietList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference dietList;

    String categoryDietId="";

    FirebaseRecyclerAdapter<Diet,DietViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_list);

        //firebase
        database = FirebaseDatabase.getInstance();
        dietList = database.getReference("Diets");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_diet);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Intent
        if(getIntent() !=null)
            categoryDietId = getIntent().getStringExtra("CategoryDietId");

        if(!categoryDietId.isEmpty() && categoryDietId !=null)
        {
            loadListDiet(categoryDietId);
        }


    }

    private void loadListDiet(String categoryDietId) {
        adapter = new FirebaseRecyclerAdapter<Diet, DietViewHolder>(Diet.class,R.layout.diet_item,DietViewHolder.class,dietList.orderByChild("MenuId").equalTo(categoryDietId)) {
            @Override
            protected void populateViewHolder(DietViewHolder viewHolder, Diet model, int position) {
                viewHolder.diet_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.diet_image);

                final Diet local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent dietDetail = new Intent(DietList.this,DietDetail.class);
                        dietDetail.putExtra("DietsId",adapter.getRef(position).getKey());
                        startActivity(dietDetail);
                    }
                });

            }
        };
        recyclerView.setAdapter(adapter);
    }
}
