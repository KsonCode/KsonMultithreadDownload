package com.ksonmultithreaddownload;

import android.app.Application;

import com.filedownload.DownloadConfig;
import com.filedownload.DownloadManager;
import com.filedownload.db.DownloadHelper;
import com.filedownload.file.FileStorageManager;
import com.filedownload.http.HttpManager;

/**
 * Created by kson on 2017/7/3.
 */

public class DownloadApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FileStorageManager.getInstance().init(this);
        HttpManager.getInstance().init(this);
        DownloadHelper.getInstance().init(this);

        DownloadConfig config = new DownloadConfig.Builder()
                .setCoreThreadSize(2)
                .setMaxThreadSize(4)
                .setLocalProgressThreadSize(1)
                .builder();
        DownloadManager.getInstance().init(config);
    }
}
