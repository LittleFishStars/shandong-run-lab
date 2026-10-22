package com.bykv.vk.component.ttvideo.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bykv.vk.component.ttvideo.player.CalledByNative;
import com.bykv.vk.component.ttvideo.player.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public final class AVNetwork {
    public static final int IS_MOBILE_NETWORK = 2;
    public static final int IS_UNKOWN_NETWORK = 0;
    public static final int IS_WIFF_NETWORK = 1;

    @SuppressLint({"MissingPermission"})
    @CalledByNative
    public static int getNetworkType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return 1;
            }
            if (type == 0) {
                return 2;
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
