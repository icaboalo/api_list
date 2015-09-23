package com.icaboalo.amazonapilist.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 9/22/2015.
 */
public class Course {

    @SerializedName("title")
    String courseName;

    @SerializedName("image")
    String courseImage;

    @SerializedName("project_description")
    String courseDescription;

    public String getCourseName() {
        return courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}
