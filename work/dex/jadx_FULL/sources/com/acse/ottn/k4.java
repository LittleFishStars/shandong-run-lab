package com.acse.ottn;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k4 f23073a;

    public static k4 a() {
        if (f23073a == null) {
            synchronized (k4.class) {
                if (f23073a == null) {
                    f23073a = new k4();
                }
            }
        }
        return f23073a;
    }

    public void a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        context.startActivity(Intent.createChooser(intent, str));
    }

    public static void a(Context context, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        intent.putExtra("android.intent.extra.STREAM", uri);
        context.startActivity(Intent.createChooser(intent, str));
    }
}
