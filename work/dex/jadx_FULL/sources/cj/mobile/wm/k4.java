package cj.mobile.wm;

import android.net.Uri;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class k4 {
    public static final int dexa = 22;

    public static boolean dexa(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && com.ipd.dsp.internal.n.a.c.equals(uri.getPathSegments().get(0));
    }

    public static String dexb(Uri uri) {
        return uri.toString().substring(dexa);
    }
}
