package com.example.smartgk.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartgk.Fragment.ExamFormFragment;
import com.example.smartgk.Fragment.ExamFragment;
import com.example.smartgk.R;
import com.example.smartgk.model.Exams;

import java.util.List;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.MyViewHolder>  {

    List<Exams> mList;
    Context context;
    ExamFragment examFragment;

    public ExamAdapter(Context context, List<Exams> mList, ExamFragment examFragment){
        this.context = context;
        this.mList = mList;
        this.examFragment = examFragment;
    }

    @NonNull
    @Override
    public ExamAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exams, parent, false);
        ExamAdapter.MyViewHolder vh = new ExamAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExamAdapter.MyViewHolder holder, final int position) {
        final Exams exams =mList.get(position);
        holder.examTitle.setText(exams.getExamTitle());
        holder.currentDate.setText(exams.getCurrentDate());
        holder.startDate.setText(exams.getStartDate());
        holder.endDate.setText(exams.getEndDate());

        holder.viewExams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ExamFormFragment();
                Bundle args = new Bundle();
                FragmentTransaction transaction = examFragment.getActivity().getSupportFragmentManager().beginTransaction();
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
        TextView currentDate, startDate, endDate, examTitle;
        Button viewExams;
        CardView examsCard;
        public MyViewHolder(View itemView) {
            super(itemView);
            examsCard = itemView.findViewById(R.id.examsCard);
            currentDate = itemView.findViewById(R.id.examDate);
            startDate = itemView.findViewById(R.id.examSt);
            endDate = itemView.findViewById(R.id.examEt);
            examTitle = itemView.findViewById(R.id.examName);
            viewExams = itemView.findViewById(R.id.viewExam);
        }
    }
}
