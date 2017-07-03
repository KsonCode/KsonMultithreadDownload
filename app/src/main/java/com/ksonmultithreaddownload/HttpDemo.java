package com.ksonmultithreaddownload;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kson on 2017/7/3.
 */

public class HttpDemo {

    public static  void main(String[] args){

//        OkHttpClient okHttpClient = new OkHttpClient();
//        Request request = new Request.Builder()
//                .addHeader("Accept-Encoding","identity")
//                .addHeader("Range","bytes=0-1000").url("http://pic.58pic.com/58pic/13/61/00/61a58PICtPr_1024.jpg").build();
//
//        try {
//            Response response = okHttpClient.newCall( request).execute();
//            if (response.isSuccessful()){
//                System.out.println(response.headers());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        final ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
        final LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,60, TimeUnit.SECONDS,queue);

        for (int i = 0; i <16 ; i++) {

            final int finalI = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("index = "+ finalI+"/ queue size = "+queue.size());
                }
            });

        }

    }
}
