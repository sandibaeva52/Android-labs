package com.example.contactapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ContactHolder>{
private ArrayList<Contacts> contact_list=new ArrayList<>();
View view;
ContactHolder holder;
private Context context;
Dialog myDialog;

   public CustomAdapter(ArrayList<Contacts> contact_list/*,Context context*/){
       this.contact_list=contact_list;

   }

    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.row_items, parent, false);
    return new ContactHolder(view);

    }

    @Override

   public void onBindViewHolder(@NonNull ContactHolder holder, int position){
       Contacts contact=contact_list.get(position);
       holder.user_name.setText(contact.getName());
       holder.phone.setText(contact.getPhone());
       holder.address.setText(contact.getAddress());

    }


    @Override
    public int getItemCount() {
        return contact_list.size();

    }

    public class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
public TextView user_name, phone, address;

        public ContactHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            user_name=(TextView)itemView.findViewById(R.id.user_name);
            phone=(TextView)itemView.findViewById(R.id.phone);
            address=(TextView)itemView.findViewById(R.id.address);

        }


        @Override
        public void onClick(View v) {




        }



    }
}