package com.example.license_project_2;

import android.content.SharedPreferences;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressManager extends AppCompatActivity {
    private static String lectureTitle;
    private final SharedPreferences sharedPrefs;

    public ProgressManager(Context context){
        sharedPrefs = context.getSharedPreferences("lesson",context.MODE_PRIVATE);
    };

    public void setTaskDone(String lessonName, String task, Boolean done){
        sharedPrefs.edit().putBoolean(lessonName+"_"+task, done).apply(); // setting the task
    }

    public Boolean isTaskDone(String lessonName, String task){
        return sharedPrefs.getBoolean(lessonName+"_"+task, false);
    }

    public int getLessonProgress(String lessonName){
        int count = 0;

        if(isTaskDone(lessonName, "definition")){
            count++;
        }
        if(isTaskDone(lessonName, "properties")){
            count+=3;
        }
        if(isTaskDone(lessonName, "examples")){
            count+=6;
        }
        return (count*100)/10;
    }



//  TO DO:
//    public int getChapterProgress(){
//
//    }
}
