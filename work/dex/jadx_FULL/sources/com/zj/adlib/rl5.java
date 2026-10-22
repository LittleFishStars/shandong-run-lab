package com.zj.adlib;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class rl5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f44480a = ImmutableMap.of("mkv", "video/x-matroska");

    @Nullable
    public static String a(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0 || iLastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(iLastIndexOf + 1);
    }

    @Nullable
    public static String b(String str) {
        String strA = a(str);
        if (strA == null) {
            return null;
        }
        String lowerCase = strA.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        return mimeTypeFromExtension == null ? f44480a.get(lowerCase) : mimeTypeFromExtension;
    }

    public static boolean c(String str) {
        return f44480a.containsValue(str);
    }

    public static boolean d(@Nullable String str) {
        return str != null && str.startsWith("image/");
    }

    public static boolean e(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }
}
