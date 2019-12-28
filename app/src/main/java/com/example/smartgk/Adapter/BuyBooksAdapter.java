package com.example.smartgk.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgk.Actvities.BookDetailsActivity;
import com.example.smartgk.R;
import com.example.smartgk.model.BuyBooks;

import java.util.List;

public class BuyBooksAdapter extends RecyclerView.Adapter<BuyBooksAdapter.MyViewHolder> {

    List<BuyBooks> mList;
    Context context;

    public BuyBooksAdapter(Context context, List<BuyBooks> mList){
        this.context = context;
        this.mList = mList;
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
        final BuyBooks buyBooks =mList.get(position);
        holder.image.setImageResource(buyBooks.getBookImg());
        holder.bookTitle.setText(buyBooks.getBookName());
        holder.bookPrice.setText(buyBooks.getBookPrice());
        holder.booksCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intoBookSetails = new Intent(v.getContext(), BookDetailsActivity.class);
                context.startActivity(intoBookSetails);
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
