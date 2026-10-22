package com.alibaba.sdk.android.oss.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OSSSharedPreferences {
    private static OSSSharedPreferences sInstance;
    private SharedPreferences mSp;

    private OSSSharedPreferences(Context context) {
        this.mSp = context.getSharedPreferences("oss_android_sdk_sp", 0);
    }

    public static OSSSharedPreferences instance(Context context) {
        if (sInstance == null) {
            synchronized (OSSSharedPreferences.class) {
                if (sInstance == null) {
                    sInstance = new OSSSharedPreferences(context);
                }
            }
        }
        return sInstance;
    }

    public boolean contains(String str) {
        return this.mSp.contains(str);
    }

    public String getStringValue(String str) {
        return this.mSp.getString(str, "");
    }

    public void removeKey(String str) {
        SharedPreferences.Editor editorEdit = this.mSp.edit();
        editorEdit.remove(str);
        editorEdit.commit();
    }

    public void setStringValue(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.mSp.edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }
}
