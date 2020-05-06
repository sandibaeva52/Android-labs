package com.example.midproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddTodo extends AppCompatActivity{
    private EditText editTextId, editTextTitle, editTextStatus, editTextCategory,editTextDuration,editTextDescription;
private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add);

        editTextId = findViewById(R.id.editTextId);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextStatus = findViewById(R.id.editTextStatus);
        editTextCategory = findViewById(R.id.editTextCategory);
        editTextDuration = findViewById(R.id.editTextDuration);
        editTextDescription = findViewById(R.id.editTextDescription);

        btn_save=(Button)findViewById(R.id.button_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int uid=Integer.parseInt(editTextId.getText().toString());
                String sTitle = editTextTitle.getText().toString();
                 String sStatus= editTextStatus.getText().toString();
                 String sCategory = editTextCategory.getText().toString();
                String sDuration = editTextDuration.getText().toString();
                String sDescription = editTextDescription.getText().toString();

                Tasks tasks=new Tasks();
                 tasks.setID(uid);
                 tasks.setTitle(sTitle);
                 tasks.setStatus(sStatus);
                 tasks.setCategory(sCategory);
//                saveTask();

                MainActivity.db.tasksDAO().insert(tasks);
                Toast.makeText(getApplicationContext(), "Task Saved", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddTodo.this, MainActivity.class);
                startActivity(intent);
                editTextId.setText("");
                editTextTitle.setText("");
                editTextStatus.setText("");
                editTextCategory.setText("");
                editTextDuration.setText("");
                editTextDescription.setText("");

            }
        });
    }
}

//    private void saveTask() {
//
//
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
//
//        class SaveTask extends AsyncTask<Void, Void, Void> {
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//
//                //creating a task
//                Tasks task = new Tasks();
//                task.setTitle(sTitle);
//                task.setStatus(sStatus);
//                task.setCategory(sCategory);
//
//                //adding to database
//                MyApplication.getInstance(getApplicationContext()).getDatabase()
//                        .tasksDAO()
//                        .insert(task);
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                super.onPostExecute(aVoid);
//                finish();
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
//            }
//        }
//        SaveTask st = new SaveTask();
//        st.execute();
//    }
