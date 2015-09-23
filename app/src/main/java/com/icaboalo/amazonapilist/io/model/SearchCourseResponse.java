package com.icaboalo.amazonapilist.io.model;

import com.google.gson.annotations.SerializedName;
import com.icaboalo.amazonapilist.domain.Course;

import java.util.ArrayList;

/**
 * Created by icaboalo on 9/22/2015.
 */
public class SearchCourseResponse {

    @SerializedName("courses")
    ArrayList<Course> elements;

    public ArrayList<Course> getCourses(){
        return elements;
    }
}
