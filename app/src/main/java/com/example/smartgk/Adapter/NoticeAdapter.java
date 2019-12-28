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
import com.example.smartgk.model.Notices;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.MyViewHolder> {
    List<Notices> mList;
    Context context;


    public NoticeAdapter(Context context, List<Notices> mList){
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notices, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final NoticeAdapter.MyViewHolder holder, final int position) {
        final Notices notices =mList.get(position);
        holder.noticeDate.setText(notices.getNoticeDate());
        holder.noticeTitle.setText(notices.getNoticeTitle());
        holder.noticeDesc.setText(notices.getNoticeDesc());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView noticeDate, noticeTitle, noticeDesc;
        CardView noticesCard;
        public MyViewHolder(View itemView) {
            super(itemView);

            noticesCard = itemView.findViewById(R.id.cardNotices);
            noticeTitle = itemView.findViewById(R.id.noticeTitle);
            noticeDesc = itemView.findViewById(R.id.noticeDesc);
            noticeDate = itemView.findViewById(R.id.noticeDate);
        }
    }
}
