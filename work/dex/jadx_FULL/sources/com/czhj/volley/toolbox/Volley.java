package com.czhj.volley.toolbox;

import android.content.Context;
import com.czhj.volley.Network;
import com.czhj.volley.RequestQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Volley {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29503a = "volley";
    private static boolean b;

    private static RequestQueue a(Context context, Network network) {
        RequestQueue requestQueue = new RequestQueue(network);
        requestQueue.start();
        return requestQueue;
    }

    public static boolean isEnableOkhttp3() {
        return b;
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, null);
    }

    public static RequestQueue newRequestQueue(Context context, BaseHttpStack baseHttpStack) {
        return a(context, baseHttpStack == null ? new BasicNetwork(new HurlStack()) : new BasicNetwork(baseHttpStack));
    }

    public static void setEnableOkhttp3(boolean z) {
        b = z;
    }
}
