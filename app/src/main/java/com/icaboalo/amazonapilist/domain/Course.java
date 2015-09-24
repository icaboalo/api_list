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

    @SerializedName("level")
    String courseLevel;

    public String getCourseName() {
        return courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getCourseLevel() {
        return courseLevel;
    }
}
