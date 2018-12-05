package com.inti.student.assignment;

import android.media.Image;
import android.provider.ContactsContract;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.inti.student.assignment.Model.Product;
import com.squareup.picasso.Picasso;

public class SupplementDetail extends AppCompatActivity {

    TextView product_name,product_price,product_description;
    ImageView product_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ElegantNumberButton numberButton;

    String ProductsId="";

    FirebaseDatabase database;
    DatabaseReference products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplement_detail);

        database = FirebaseDatabase.getInstance();
        products = database.getReference("Products");

        numberButton = (ElegantNumberButton)findViewById(R.id.number_button);

        product_description = (TextView)findViewById(R.id.product_description);
        product_name = (TextView)findViewById(R.id.product_name);
        product_price = (TextView)findViewById(R.id.product_price);
        product_image = (ImageView)findViewById(R.id.product_image);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);
        if(getIntent() !=null)
            ProductsId = getIntent().getStringExtra("ProductsId");
        if(!ProductsId.isEmpty())
        {
            getDetailProduct(ProductsId);
        }



    }

    private void getDetailProduct(String ProductsId) {
        products.child(ProductsId).addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                Product product = dataSnapshot.getValue(Product.class);

                Picasso.with(getBaseContext()).load(product.getImage())
                        .into(product_image);

                collapsingToolbarLayout.setTitle(product.getName());

                product_price.setText(product.getPrice());

                product_name.setText(product.getName());

                product_description.setText(product.getDescription());

            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }

        });
    }
}
