package com.example.assingment_2.classes;

public class Test {

    // Attributes for Test
    private String test_name;
    private String question;


    //---------------------------------------------------------------------------------
    // Constructor for Test
    public Test(String test_name, String question) {
        this.test_name=test_name;
        this.question=question;
    }


    //---------------------------------------------------------------------------------
    // Getter and Setter

    // for Test Name
    public String getTestName() {
        return test_name;
    }

    public void setTestName(String test_name) {
        this.test_name = test_name;
    }

    //********************************
    // for Question

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}
