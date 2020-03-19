package com.example.smartgk.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartgk.Fragment.BookFragmentPackage.BookDetailsFragment;
import com.example.smartgk.Fragment.HomeFragmentSearch;
import com.example.smartgk.R;
import com.example.smartgk.model.Home_model_real.Book;
import com.example.smartgk.utitlies.Constants;

import java.util.List;

public class BuyBooksAdapter extends RecyclerView.Adapter<BuyBooksAdapter.MyViewHolder> {

    List<Book> mList;
    Context context;
    HomeFragmentSearch homeFragmentSearch;

    public BuyBooksAdapter(Context context, List<Book> mList, HomeFragmentSearch homeFragmentSearch){
        this.context = context;
        this.mList = mList;
        this.homeFragmentSearch = homeFragmentSearch;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buy_books, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Book buyBooks =mList.get(position);
        Glide
                .with((context) )
                .load(buyBooks.getImage())
                .centerCrop()
                .into(holder.image);
        holder.bookTitle.setText(buyBooks.getTitle());
        holder.bookPrice.setText(buyBooks.getPrice());
        holder.booksCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new BookDetailsFragment();
                FragmentTransaction transaction = homeFragmentSearch.getActivity().getSupportFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.BOOK_TITLE1,holder.bookTitle.getText().toString());
                bundle.putString(Constants.BOOK_PRICE, holder.bookPrice.getText().toString());
                fragment.setArguments(bundle);
                Toast.makeText(homeFragmentSearch.getContext(), buyBooks.getTitle(),Toast.LENGTH_SHORT).show();

                transaction.replace(R.id.main_content, fragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ImageView image;
        TextView bookPrice, bookTitle;
        CardView booksCard;
        public MyViewHolder(View itemView) {
            super(itemView);

            booksCard = itemView.findViewById(R.id.cardA3);
            image = (ImageView) itemView.findViewById(R.id.course_img);
            bookTitle = itemView.findViewById(R.id.title_name);
            bookPrice = itemView.findViewById(R.id.course_price);
        }
    }
}
