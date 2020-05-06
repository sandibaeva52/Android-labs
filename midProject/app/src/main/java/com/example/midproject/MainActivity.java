package com.example.midproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonAddTask;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private ArrayList<Tasks> tasks=new ArrayList<>();
   public static MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list);
        db= Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"tasks").allowMainThreadQueries().build();
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        buttonAddTask=findViewById(R.id.add_button);
        buttonAddTask.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AddTodo.class);
                startActivity(intent);
            }
        });
        getTasks();

    }

    private void getTasks() {
        class GetTasks extends AsyncTask<Void, Void, List<Tasks>>{

            @Override
            protected List<Tasks> doInBackground(Void... voids) {
//               List<Tasks> myTasks= MyApplication.getInstance(getApplicationContext()).getDatabase().tasksDAO().getTasks();
                List<Tasks> myTasks= MainActivity.db.tasksDAO().getTasks();
                return myTasks;
            }

            @Override
            protected void onPostExecute(List<Tasks> myTasks){
                TaskAdapter adapter = new TaskAdapter(myTasks);
                recyclerView.setAdapter(adapter);
                super.onPostExecute(myTasks);

            }
        }
        GetTasks gt=new GetTasks();
        gt.execute();


    }
}
