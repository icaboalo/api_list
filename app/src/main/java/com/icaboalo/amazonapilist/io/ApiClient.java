package com.icaboalo.amazonapilist.io;

import com.icaboalo.amazonapilist.io.model.SearchCourseResponse;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by icaboalo on 9/22/2015.
 */
public class ApiClient {
    private static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            apiService = restAdapter.create(ApiService.class);
        }
        return apiService;
    }

    public static void searchCourse(Callback<SearchCourseResponse> serverResponse){
        getApiService().searchCourse(serverResponse);
    }
}
