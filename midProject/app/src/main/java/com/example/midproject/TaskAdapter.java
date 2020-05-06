package com.example.midproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TasksViewHolder> {
    List<Tasks> myTasks;
    View view;
     Context context;
    public TaskAdapter( List<Tasks> myTasks){
        this.myTasks=myTasks;
    }

    @NonNull
    @Override
    public TaskAdapter.TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        view =layoutInflater.inflate(R.layout.fragment_items, parent, false);
        return new TasksViewHolder(view);
//holder.itemTask.setOnClickListener(new View.OnClickListener() {
    //@Override
   // public void onClick(View v) {

        //View view = LayoutInflater.from(context).inflate(R.layout.fragment_details, parent, false);
   // }
//})
//return holder;
        }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TasksViewHolder holder, int position) {
Tasks tsk=myTasks.get(position);
//        holder.id.setText(tsk.getID());
        holder.title.setText(tsk.getTitle());
        holder.category.setText(tsk.getCategory());
        holder.status.setText(tsk.getStatus());
    }

    @Override
    public int getItemCount() {
        return myTasks.size();
    }

    public class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView id,title, category, status;
        private LinearLayout itemTask;

        public TasksViewHolder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
//            id=(TextView)itemView.findViewById(R.id.id);
            title=(TextView)itemView.findViewById(R.id.title);
            category=(TextView)itemView.findViewById(R.id.category);
            status=(TextView)itemView.findViewById(R.id.status);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
           //loadFragment (new DetailsFragment());
            Intent intent=new Intent(context, DetailsFragment.class);
            context.startActivity(intent);
//            Tasks task = myTasks.get(getAdapterPosition());
//            Intent intent=new Intent(context, DetailsFragment.class);
//            intent.putExtra("task", task);
//            context.startActivity(intent);
        }


    }
}
