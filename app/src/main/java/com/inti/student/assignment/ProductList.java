package com.inti.student.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inti.student.assignment.Interface.ItemClickListener;
import com.inti.student.assignment.Model.Product;
import com.inti.student.assignment.ViewHolder.ProductsViewHolder;
import com.squareup.picasso.Picasso;

public class ProductList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference productList;

    String categorySupplementsId="";

    FirebaseRecyclerAdapter<Product,ProductsViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        //firebase
        database = FirebaseDatabase.getInstance();
        productList = database.getReference("Products");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_product);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Intent
        if(getIntent() !=null)
            categorySupplementsId = getIntent().getStringExtra("CategorySupplementsId");

        if(!categorySupplementsId.isEmpty() && categorySupplementsId !=null)
        {
            loadListProduct(categorySupplementsId);
        }


    }

    private void loadListProduct(String categorySupplementsId) {
        adapter = new FirebaseRecyclerAdapter<Product, ProductsViewHolder>(Product.class,R.layout.product_item,ProductsViewHolder.class,productList.orderByChild("MenuId").equalTo(categorySupplementsId)) {
            @Override
            protected void populateViewHolder(ProductsViewHolder viewHolder, Product model, int position) {
                viewHolder.product_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.product_image);

                final Product local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent supplementDetail = new Intent(ProductList.this,SupplementDetail.class);
                        supplementDetail.putExtra("ProductsId",adapter.getRef(position).getKey());
                        startActivity(supplementDetail);
                    }
                });

            }
        };
        recyclerView.setAdapter(adapter);
    }
}
