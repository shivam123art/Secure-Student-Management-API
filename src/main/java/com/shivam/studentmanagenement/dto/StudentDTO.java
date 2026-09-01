package com.shivam.studentmanagenement.dto;

public class StudentDTO {
    private String name;
    private int marks;
    public StudentDTO(){

    }
    public StudentDTO(String name ,int marks){
        this.name = name;
        this.marks = marks ;

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
}
