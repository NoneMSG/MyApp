package com.jx372.myapp.core.provider;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.GsonBuilder;
import com.jx372.myapp.core.domain.User;
import com.jx372.myapp.core.network.JSONResult;

import java.net.HttpURLConnection;
import java.util.List;

/**
 * Created by bit-user on 2017-08-12.
 */

public class UserProvider {

    public List<User> fetchUserList() throws Exception {
        String url = "http://192.168.1.39:8088/mysite03/user/api/list";

        HttpRequest request = HttpRequest.get( url );

        request.accept( HttpRequest.CONTENT_TYPE_JSON );
        request.connectTimeout( 3000 );
        request.readTimeout( 3000 );

        int responseCode = request.code();
        if( responseCode != HttpURLConnection.HTTP_OK ) {
            throw new Exception( "Http Response :" + responseCode  );
        }

        JSONRestltFetcUserList jsonResult = new GsonBuilder().
            create().
            fromJson( request.bufferedReader(), JSONRestltFetcUserList.class );

        if( "fail".equals( jsonResult.getResult() ) ){
            throw new Exception( "Json Result fail:" + jsonResult.getResult() );
        }

        return jsonResult.getData();
    }

    private class JSONRestltFetcUserList extends JSONResult<List<User>> {}
}
