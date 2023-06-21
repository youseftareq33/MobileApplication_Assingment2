package com.example.assingment_2.classes;

import com.example.assingment_2.R;

public class Subject {

    // Attributes for Subject
    private String subject_name;
    private int imageID;

    public static final Subject[] subjects = {
            new Subject("Math", R.drawable.math),
            new Subject("Science", R.drawable.science),
            new Subject("English", R.drawable.english),
    };

    //---------------------------------------------------------------------------------
    // Constructor for Subject
    public Subject(String subject_name, int imageID) {
        this.subject_name = subject_name;
        this.imageID=imageID;
    }

    public Subject(String subject_name) {
        this.subject_name = subject_name;
    }

    //---------------------------------------------------------------------------------
    // Getter and Setter

    // for Subject Name
    public String getSubjectName() {
        return subject_name;
    }

    public void setSubjectName(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getImageID(){return imageID;}
}
