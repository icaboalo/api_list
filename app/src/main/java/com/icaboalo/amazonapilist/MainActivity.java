package com.icaboalo.amazonapilist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.icaboalo.amazonapilist.domain.Course;
import com.icaboalo.amazonapilist.io.ApiClient;
import com.icaboalo.amazonapilist.io.model.SearchCourseResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<Course> myCourseList;
    RecyclerViewAdapter recyclerViewAdapter;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        setUpRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        executeWithRetrofit();
    }

    private void setUpRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.character_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(this, createCourse());
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    private List<Course> createCourse() {
        myCourseList = new ArrayList<>();
        myCourseList.add(new Course());
        return myCourseList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void executeWithRetrofit() {
        ApiClient.searchCourse(new Callback<SearchCourseResponse>() {
            @Override
            public void success(SearchCourseResponse searchCourseResponse, Response response) {
                List<Course> courses = searchCourseResponse.getCourses();
                recyclerViewAdapter.setData(courses);

                for (Course course : courses) {
                    Log.i("Courses", course.getCourseName());
                }

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
