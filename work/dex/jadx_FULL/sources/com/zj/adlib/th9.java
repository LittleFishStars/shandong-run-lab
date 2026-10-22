package com.zj.adlib;

import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class th9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44926a = "http";
    public static final String b = "https";
    public static final String c = "file";
    public static final String d = "content";
    public static final String e = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo").getPath();
    public static final String f = "asset";
    public static final String g = "res";
    public static final String h = "data";

    @Nullable
    public static String a(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    public static boolean b(@Nullable Uri uri) {
        return "data".equals(a(uri));
    }

    public static boolean c(@Nullable Uri uri) {
        return "asset".equals(a(uri));
    }

    public static boolean d(Uri uri) {
        String string = uri.toString();
        return string.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || string.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean e(Uri uri) {
        return f(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(e);
    }

    public static boolean f(@Nullable Uri uri) {
        return "content".equals(a(uri));
    }

    public static boolean g(@Nullable Uri uri) {
        return "file".equals(a(uri));
    }

    public static boolean h(@Nullable Uri uri) {
        return "res".equals(a(uri));
    }

    public static boolean i(@Nullable Uri uri) {
        String strA = a(uri);
        return "https".equals(strA) || "http".equals(strA);
    }

    public static Uri j(@Nullable String str) {
        if (str != null) {
            return Uri.parse(str);
        }
        return null;
    }
}
