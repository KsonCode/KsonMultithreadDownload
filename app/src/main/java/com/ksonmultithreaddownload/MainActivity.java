package com.ksonmultithreaddownload;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.filedownload.DownloadManager;
import com.filedownload.file.FileStorageManager;
import com.filedownload.http.DownloadCallback;
import com.filedownload.http.HttpManager;
import com.filedownload.utils.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private ProgressBar mProgress;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mProgress = (ProgressBar) findViewById(R.id.progress);

        Map<String, String> map = new HashMap<>();
        map.put("username", "nate");
        map.put("userage", "12");


        DownloadManager.Holder.getInstance();


        final String url = "http://shouji.360tpcdn.com/160901/84c090897cbf0158b498da0f42f73308/com.icoolme.android.weather_2016090200.apk";
//        final String url = "http://bj.bcebos.com/weitu-cms/233108474740.jpg";
        DownloadManager.getInstance().download(url, new DownloadCallback() {
            @Override
            public void success(File file) {
//                if (count < 1) {
//                    count++;
//                    return;
//                }
//                installApk(file);
                Logger.debug("nate", "success " + file.getAbsoluteFile());

//                final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//
//                mImageView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        mImageView.setImageBitmap(bitmap);
//                    }
//                });

            }

            @Override
            public void fail(int errorCode, String errorMessage) {
                Logger.debug("nate", "fail " + errorCode + "  " + errorMessage);
            }

            @Override
            public void progress(int progress) {
                Logger.debug("nate", "progress    " + progress);


                mProgress.setProgress(progress);

            }
        });

    }

    private void installApk(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://" + file.getAbsoluteFile().toString()), "application/vnd.android.package-archive");
        MainActivity.this.startActivity(intent);
    }
}
