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
import com.inti.student.assignment.Model.CategorySupplements;
import com.inti.student.assignment.ViewHolder.MenuViewHolder;
import com.squareup.picasso.Picasso;


public class Supplement extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference categorySupplements;
    TextView txtFullName;

    RecyclerView recycler_supplements;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<CategorySupplements,MenuViewHolder> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplement);

        //firebase
        database = FirebaseDatabase.getInstance();
        categorySupplements = database.getReference("CategorySupplements");

        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtFullName.setText(Common.currentUser.getEmail());

        //menu
        recycler_supplements = (RecyclerView)findViewById(R.id.recycler_supplements);
        recycler_supplements.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_supplements.setLayoutManager(layoutManager);

        loadMenu();
    }

    private void loadMenu() {
        adapter = new FirebaseRecyclerAdapter<CategorySupplements, MenuViewHolder>(CategorySupplements.class,R.layout.menu_item,
                MenuViewHolder.class,categorySupplements) {
            @Override
            protected void populateViewHolder(MenuViewHolder viewHolder, CategorySupplements model, int position) {
                viewHolder.txtMenuName.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.imageView);
                final CategorySupplements clickItem= model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //get id and send to according activity
                        Intent productList = new Intent(Supplement.this,ProductList.class);
                        productList.putExtra("CategorySupplementsId",adapter.getRef(position).getKey());
                        startActivity(productList);
                    }
                });
            }
        };
        recycler_supplements.setAdapter(adapter);
    }
}
