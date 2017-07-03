package com.filedownload.utils;

import android.text.TextUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kson on 2017/7/3.
 */

public class Md5Utils {

    public static String generateCode(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();

        try {
            MessageDigest digest = MessageDigest.getInstance("md5");

            digest.update(url.getBytes());

            byte[] cipher = digest.digest();

            for (byte b : cipher) {
                String hexStr = Integer.toHexString(b & 0xff);
                buffer.append(hexStr.length() == 1 ? "0" + hexStr : hexStr);//转换16进制
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
