package com.example.midproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsFragment extends AppCompatActivity {
    private EditText editTextId, editTextTitle,editTextCategory,editTextStatus, editTextDuration,editTextDescription;
    private Button button_update, button_delete;
    Tasks task;
    int id;
    TaskAdapter adapter;
TasksDao tasksDao;
@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_details);
        button_update = findViewById(R.id.button_update);
        button_delete = findViewById(R.id.button_delete);

        editTextId=findViewById(R.id.id);
        editTextDuration=findViewById(R.id.durations);
        editTextDescription=findViewById(R.id.description);
        editTextTitle = findViewById(R.id.upd_title);
        editTextCategory = findViewById(R.id.upd_category);
        editTextStatus = findViewById(R.id.upd_status);

//    final Tasks task = (Tasks) getIntent().getSerializableExtra("task");
//    loadTask(task);



button_update.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
            String title = editTextTitle.getText().toString().trim();
            String category = editTextCategory.getText().toString().trim();
            String status = editTextStatus.getText().toString().trim();
//            Tasks task=tasksDao.getTaskById(id);
//            editTextId.setText(task.ID);
//            editTextDuration.setText(task.durations);
//            editTextDescription.setText(task.description);
//            editTextTitle.setText(task.title);
//            editTextCategory.setText(task.category);
//            editTextStatus.setText(task.status);

             Tasks task = new Tasks();
            task.setTitle(title);
            task.setCategory(category);
            task.setStatus(status);

            MainActivity.db.tasksDAO().update(task);
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
            editTextTitle.setText("");
            editTextCategory.setText("");
            editTextStatus.setText("");
//             updateTask();
            Intent intent=new Intent(DetailsFragment.this, MainActivity.class);
            startActivity(intent);


        }

    }
        );


        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int taskId=Integer.parseInt(editTextId.getText().toString());
                Tasks task=MainActivity.db.tasksDAO().getTaskById(taskId);
                MainActivity.db.tasksDAO().delete(task);
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                startActivity(new Intent(DetailsFragment.this, MainActivity.class));


            }
        });
        }
//
//    private void loadTask(Tasks task) {
//        editTextTitle.setText(task.getTitle());
//        editTextStatus.setText(task.getStatus());
//        editTextCategory.setText(task.getCategory());
//
//    }
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });
//        AlertDialog ad = builder.create();
//        ad.show();
//    }
//});
//    }


//
//    private void updateTask() {
//        final String sTitle = editTextTitle.getText().toString().trim();
//        final String sStatus = editTextStatus.getText().toString().trim();
//        final String sCategory = editTextCategory.getText().toString().trim();

//        if (sTitle.isEmpty()) {
//            editTextTitle.setError("Title required");
//            editTextTitle.requestFocus();
//            return;
//        }
//
//        if (sStatus.isEmpty()) {
//            editTextStatus.setError("Status required");
//            editTextStatus.requestFocus();
//            return;
//        }
//
//        if (sCategory.isEmpty()) {
//            editTextCategory.setError("Category required");
//            editTextCategory.requestFocus();
//            return;
//        }
//        class UpdateTask extends AsyncTask<Void, Void, Void> {
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                task.setTitle(sTitle);
//                task.setStatus(sStatus);
//                task.setCategory(sCategory);
//                MainActivity.db.tasksDAO().update(task);
//                return null;
//
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
//                finish();
////                startActivity(new Intent(DetailsFragment.this, MainActivity.class));
//                super.onPostExecute(aVoid);
//
//            }
//
//        }
//
//        UpdateTask ut = new UpdateTask();
//        ut.execute();
//
//    }
//
//    private void deleteTask(final Tasks task) {
//        class DeleteTask extends AsyncTask<Void, Void, Void> {
//            @Override
//            protected Void doInBackground(Void... voids){
//                MainActivity.db.tasksDAO().delete(task);
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid){
//                super.onPostExecute(aVoid);
//                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
//                finish();
//                startActivity(new Intent(DetailsFragment.this, MainActivity.class));
//            }
//        }
//        DeleteTask dt = new DeleteTask();
//        dt.execute();
//    }


    }