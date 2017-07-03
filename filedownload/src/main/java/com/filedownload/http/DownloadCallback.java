package com.filedownload.http;

import java.io.File;

/**
 * Created by kson on 2017/7/3.
 */

public interface DownloadCallback {
    void success(File file);
    void fail(int code,String msg);
    void progress(int progress);
}
