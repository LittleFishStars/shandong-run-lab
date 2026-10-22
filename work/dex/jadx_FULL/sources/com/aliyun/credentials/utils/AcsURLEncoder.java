package com.aliyun.credentials.utils;

import com.aliyun.credentials.exception.CredentialException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AcsURLEncoder {
    public static final String URL_ENCODING = "UTF-8";

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new CredentialException(e.getMessage(), e);
        }
    }

    public static String percentEncode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException e) {
            throw new CredentialException(e.getMessage(), e);
        }
    }
}
