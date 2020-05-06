//package com.example.midproject;
//
//import android.app.Application;
//import android.content.Context;
//import androidx.room.Room;
//
//public class MyApp extends Application {
//    public static MyApp instance;
//    private MyDatabase database;
//    private Context context;
//
//    public MyApp(Context context) {
//        this.context = context;
//        database= Room.databaseBuilder(context, MyDatabase.class,"tasks").build();
//    }
//    public static synchronized MyApp getInstance(Context context){
//        if(instance==null){
//            instance=new MyApp(context);
//        }
//        return instance;
//    }
//
//
//
//    public  MyDatabase getDatabase() {
//        return database;
//    }
//    //    @Override
////    public void onCreate() {
////        super.onCreate();
////        instance=this;
////        database= Room.databaseBuilder(this, MyDatabase.class, "tasks_db").build();
////    }
////public static MyApplication getInstance(){
////        return instance;
////}
////
////    public MyDatabase getDatabase() {
////        return database;
////    }
//}
//
