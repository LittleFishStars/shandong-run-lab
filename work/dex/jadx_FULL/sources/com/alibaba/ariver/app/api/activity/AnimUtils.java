package com.alibaba.ariver.app.api.activity;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AnimUtils {
    public static int getAnimResId(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "anim", context.getPackageName());
        if (identifier <= 0) {
            return 0;
        }
        return identifier;
    }
}
