package com.aliyun.vod.common.utils;

import android.net.Uri;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class UriUtil {
    public static final String ASSETS = "assets";
    public static final String FILE = "file";
    public static final String MULI_SPLIT = ",";
    public static final String PROVIDER = "content";
    public static final String QUERY_CATEGORY = "category";
    public static final String QUERY_ID = "id";
    public static final String QUERY_TYPE = "type";
    public static final String QUPAI_ASSETS = "qupai-assets";

    public static String formatAssetURI(int i, int i2) {
        return String.format("%s://?type=%d&id=%d", "qupai-assets", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static String formatProvideURI(int[] iArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.append(i);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return String.format("%s://%s?category=%s", "content", str, sb.toString());
    }

    public static boolean getQueryB(Uri uri, String str, boolean z) {
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(queryParameter);
        } catch (Throwable unused) {
            return z;
        }
    }

    public static <E extends Enum<E>> E getQueryE(Uri uri, String str, E e) {
        if (uri.getQueryParameter(str) == null) {
            return e;
        }
        try {
            return (E) Enum.valueOf(e.getDeclaringClass(), str);
        } catch (Throwable unused) {
            return e;
        }
    }

    public static int getQueryI(Uri uri, String str, int i) {
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter == null) {
            return i;
        }
        try {
            return Integer.parseInt(queryParameter);
        } catch (Throwable unused) {
            return i;
        }
    }

    public static int[] getQueryIA(Uri uri) {
        String queryParameter = uri.getQueryParameter("category");
        if (queryParameter == null) {
            return null;
        }
        String[] strArrSplit = queryParameter.split(",");
        int[] iArr = new int[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            iArr[i] = Integer.parseInt(strArrSplit[i]);
        }
        return iArr;
    }

    public static long getQueryL(Uri uri, String str, long j) {
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter == null) {
            return j;
        }
        try {
            return Long.parseLong(queryParameter);
        } catch (Throwable unused) {
            return j;
        }
    }
}
