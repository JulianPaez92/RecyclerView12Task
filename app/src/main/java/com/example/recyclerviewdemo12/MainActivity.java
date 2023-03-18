package com.example.recyclerviewdemo12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> productList = new ArrayList<Product>();
    RecyclerView productRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareDefaultData();
        productRecyclerview=findViewById(R.id.productRecycleView);
        //make recycleview look like gridview
        //spanCount -> Qty of columns in the view
        //productRecyclerview.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        productRecyclerview.setLayoutManager( new LinearLayoutManager(MainActivity.this));

        //Prepare and set adapter to recycleview
        productRecyclerview.setAdapter( new ProductAdapter() ); //last

    }

    void prepareDefaultData(){
        Product p1 = new Product("Kiwi", 300, R.drawable.kiwi);
        productList.add(p1);
        Product p2 = new Product("Orange", 300, R.drawable.orange);
        productList.add(p2);
        Product p3 = new Product("Pineapple", 300, R.drawable.pineapple);
        productList.add(p3);
        Product p4 = new Product("Strawberry", 300, R.drawable.strawberry);
        productList.add(p4);
    }

    //Create ViewHolder class to represent design of product_item_layout
    class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView productImageView;
        TextView textViewPrice, textViewTitle;
        Button buttonAddToCart;
        ProductViewHolder(View itemView){
            super(itemView);
            productImageView = itemView.findViewById(R.id.imageView);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            buttonAddToCart = itemView.findViewById(R.id.buttonAddToCart);
        }
    }

    //Create RecycleViewAdapter
    class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder>{

        ProductAdapter(){
            super();
        }

        //implement Adapter methods

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            //load product_item_layout
            //for gridview
            //View itemView = getLayoutInflater().inflate(R.layout.product_list_item_layouyt,null);
            //for listView
            View itemView = getLayoutInflater().inflate(R.layout.product_list_item_layouyt,null);



            ProductViewHolder holder = new ProductViewHolder(itemView);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
              
            //display product of given position on viewHolder design elements
            Product product = productList.get(position);
            holder.textViewTitle.setText(product.itemName);
            holder.textViewPrice.setText("Price: " + product.price);
            holder.productImageView.setImageResource(product.imageID);
            holder.buttonAddToCart.setOnClickListener( new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, product.itemName + " added to cart!",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }
    }

}