package com.inti.student.assignment;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inti.student.assignment.Common.Common;
import com.inti.student.assignment.Interface.ItemClickListener;
import com.inti.student.assignment.Model.CategoryDiet;
import com.inti.student.assignment.ViewHolder.MenuViewHolder;
import com.squareup.picasso.Picasso;

public class Diet extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference categoryDiet;
    TextView txtFullName;


    RecyclerView recycler_diet;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<CategoryDiet,MenuViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        //firebase
        database = FirebaseDatabase.getInstance();
        categoryDiet = database.getReference("CategoryDiet");

        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtFullName.setText(Common.currentUser.getEmail());


        //menu
        recycler_diet = (RecyclerView)findViewById(R.id.recycler_diet);
        recycler_diet.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_diet.setLayoutManager(layoutManager);

        loadMenu();


    }

    private void loadMenu() {
        adapter = new FirebaseRecyclerAdapter<CategoryDiet, MenuViewHolder>(CategoryDiet.class,R.layout.menu_item,MenuViewHolder.class,categoryDiet) {

            @Override
            protected void populateViewHolder(MenuViewHolder viewHolder, CategoryDiet model, int position) {
                viewHolder.txtMenuName.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.imageView);
                final CategoryDiet clickItem= model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent dietList = new Intent(Diet.this,DietList.class);
                        dietList.putExtra("CategoryDietId",adapter.getRef(position).getKey());
                        startActivity(dietList);
                    }
                });

            }
        };
        recycler_diet.setAdapter(adapter);
    }
}
