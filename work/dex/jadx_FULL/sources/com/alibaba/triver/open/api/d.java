package com.alibaba.triver.open.api;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25041a = "request";
    public static String b = "image";
    public static String c = "font";
    public static String d = "video";
    public static String e = "link";
    public static String f = "bundle";
    public static String g = "web";
    public static String h = "others";

    @NonNull
    public static Uri a(String str, String str2, Uri uri) {
        if (TextUtils.isEmpty(str)) {
            return uri;
        }
        Uri uri2 = Uri.parse(str);
        Uri.Builder builderBuildUpon = uri.buildUpon();
        if (!uri.isRelative()) {
            return uri;
        }
        if (uri.getEncodedPath().length() == 0) {
            return (b.equals(str2) && TextUtils.isEmpty(uri.toString())) ? uri : uri2;
        }
        return a(builderBuildUpon, uri2, uri).build();
    }

    private static Uri.Builder a(Uri.Builder builder, Uri uri, Uri uri2) {
        if (uri2.getAuthority() != null) {
            return builder.scheme(uri.getScheme());
        }
        builder.encodedAuthority(uri.getEncodedAuthority()).scheme(uri.getScheme()).path(null);
        if (uri2.getPath().startsWith(WVNativeCallbackUtil.SEPERATER)) {
            builder.appendEncodedPath(uri2.getEncodedPath().substring(1));
        } else {
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size() - (!uri.getPath().endsWith(WVNativeCallbackUtil.SEPERATER) ? 1 : 0);
            for (int i = 0; i < size; i++) {
                builder.appendEncodedPath(pathSegments.get(i));
            }
            builder.appendEncodedPath(uri2.getEncodedPath());
        }
        return builder;
    }
}
