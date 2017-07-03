package com.ksonmultithreaddownload;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kson on 2017/7/3.
 */

public class HttpDemo {

    public static  void main(String[] args){

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .addHeader("Accept-Encoding","identity")
                .addHeader("Range","bytes=0-1000").url("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1499072284&di=a3030691466960b2e0ffe46855c278d5&src=http://pic.58pic.com/58pic/13/61/00/61a58PICtPr_1024.jpg").build();

        try {
            Response response = okHttpClient.newCall( request).execute();
            if (response.isSuccessful()){
                System.out.println(response.headers());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
