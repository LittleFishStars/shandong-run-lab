package com.alibaba.alibcprotocol.utils;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourceUtils {
    public static final String TAG = "ResourceUtils";

    public static int getIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str2, str, context.getPackageName());
    }

    public static int getRLayout(Context context, String str) {
        return getIdentifier(context, "layout", str);
    }
}
