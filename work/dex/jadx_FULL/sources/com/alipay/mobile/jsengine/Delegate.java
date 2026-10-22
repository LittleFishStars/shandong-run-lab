package com.alipay.mobile.jsengine;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.zj.adlib.c49;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class Delegate {
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    public int getConfig(String str, int i) {
        try {
            String config = getConfig(str, "");
            if (!TextUtils.isEmpty(config)) {
                return Integer.valueOf(config.trim()).intValue();
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public abstract String getConfig(String str, String str2);

    public abstract Context getContext();

    public String getDiskInfo() {
        return c49.f40900a;
    }

    public abstract String getWebViewCoreSoPath();

    public abstract void log(LogData logData);

    public abstract void releaseProcessLock(Object obj);

    public abstract Object takeProcessLock(String str);

    public abstract void unzipWebViewCoreSo();

    public void w(String str, String str2) {
        Log.w(str, str2);
    }

    public void e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
