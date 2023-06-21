package com.example.assingment_2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.assingment_2.R;
import com.example.assingment_2.classes.Subject;

public class MainActivity2_subject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        RecyclerView recycler = findViewById(R.id.subject_recycler);

        String[] captions = new String[Subject.subjects.length];
        int[] ids = new int[Subject.subjects.length];

        for(int i = 0; i<captions.length;i++){
            captions[i] = Subject.subjects[i].getSubjectName();
            ids[i] = Subject.subjects[i].getImageID();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids);
        recycler.setAdapter(adapter);
    }
}