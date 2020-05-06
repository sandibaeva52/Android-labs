package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private CustomAdapter adapter;
private ArrayList<Contacts> listContentArr=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       /* Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
       // recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        adapter = new CustomAdapter(listContentArr);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareContactData();
    }

    private void prepareContactData() {
        listContentArr.add(new Contacts("Aruzhan", 870115554,"Aktobe"));
        listContentArr.add(new Contacts("Aigerim",877146975,"Aktobe"));
        listContentArr.add(new Contacts("Assem",877542267,"Aktobe"));
        listContentArr.add(new Contacts("Gaukhar",877123315,"Aktobe"));
        listContentArr.add(new Contacts("Zarina",870124564,"Aktobe"));
        listContentArr.add(new Contacts("Assel",870770777,"Aktobe"));
        listContentArr.add(new Contacts("Tolkyn",870111111,"Aktobe"));
        listContentArr.add(new Contacts("Dariga",870212354,"Aktobe"));
        listContentArr.add(new Contacts("Aktoty",870278466,"Aktobe"));
        listContentArr.add(new Contacts("Aslan",877122233,"Aktobe"));
        listContentArr.add(new Contacts("Almas",877132665,"Aktobe"));
        listContentArr.add(new Contacts("Galiya",877566149,"Aktobe"));
        listContentArr.add(new Contacts("Sanim",870244465,"Aktobe"));
        listContentArr.add(new Contacts("Anar",870226548,"Aktobe"));
        listContentArr.add(new Contacts("Ayazhan",877521468,"Aktobe"));
        listContentArr.add(new Contacts("Karina",877154962,"Aktobe"));


        adapter.notifyDataSetChanged();

    }
        /*recyclerView=(RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
adapter=new CustomAdapter(listContentArr,this);
recyclerView.setAdapter(adapter);*/
//populateRecycleViewValues();



    }



   /* private void populateRecycleViewValues() {
        for(int i=1;i<=30;i++){
            Contacts contact=new Contacts();
            contact.setName("Adam");
            contact.setPhone(456632);
            contact.setAddress("101 Street");

            listContentArr.add(contact);
            }
        adapter.setListContent(listContentArr);
        recyclerView.setAdapter(adapter);
        }*/


