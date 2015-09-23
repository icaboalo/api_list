package com.icaboalo.amazonapilist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icaboalo.amazonapilist.domain.Course;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by icaboalo on 9/22/2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Course> courseList;
    Context context;
    LayoutInflater inflater;

    public RecyclerViewAdapter(Context context, List<Course> courseList) {
        this.courseList = courseList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = inflater.inflate(R.layout.item_list, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView, R.id.course_name, R.id.course_description, R.id.course_image, R.id.course_image_big);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Course course = courseList.get(i);
        myViewHolder.setCourseName(course.getCourseName());
        myViewHolder.setCourseDescription(course.getCourseDescription());
        myViewHolder.setCourseImage(course.getCourseImage());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public void setData(List newData){
        courseList = newData;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView courseName, courseDescription;
        ImageView courseImage, courseImageBig;

        public MyViewHolder(View itemView, int courseName, int courseDescription, int courseImage, int courseImageBig) {
            super(itemView);
            this.courseName = (TextView) itemView.findViewById(courseName);
            this.courseDescription = (TextView) itemView.findViewById(courseDescription);
            this.courseImage = (ImageView) itemView.findViewById(courseImage);
            this.courseImageBig = (ImageView) itemView.findViewById(courseImageBig);
        }

        public void setCourseName(String courseName) {
            this.courseName.setText(courseName);
        }

        public void setCourseDescription(String courseDescription) {
            this.courseDescription.setText(courseDescription);
        }

        public void setCourseImage(String courseImageUrl) {
            Picasso.with(context).load(courseImageUrl).placeholder(R.mipmap.ic_launcher).into(courseImage);
            Picasso.with(context).load(courseImageUrl).placeholder(R.mipmap.ic_launcher).into(courseImageBig);
        }
    }
}
