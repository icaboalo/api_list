package com.icaboalo.amazonapilist.io;

import com.icaboalo.amazonapilist.io.model.SearchCourseResponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by icaboalo on 9/22/2015.
 */
public interface ApiService {
    @GET(Constants.URL_SEARCH_COURSE)
    void searchCourse(Callback<SearchCourseResponse> serverResponse);
}
