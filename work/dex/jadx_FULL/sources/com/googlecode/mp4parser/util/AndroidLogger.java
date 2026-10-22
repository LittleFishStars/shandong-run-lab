package com.googlecode.mp4parser.util;

import android.util.Log;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class AndroidLogger extends Logger {
    private static final String TAG = "isoparser";
    String name;

    public AndroidLogger(String str) {
        this.name = str;
    }

    @Override // com.googlecode.mp4parser.util.Logger
    public void logDebug(String str) {
        Log.d(TAG, String.valueOf(this.name) + u15.f19942b + str);
    }

    @Override // com.googlecode.mp4parser.util.Logger
    public void logError(String str) {
        Log.e(TAG, String.valueOf(this.name) + u15.f19942b + str);
    }

    @Override // com.googlecode.mp4parser.util.Logger
    public void logWarn(String str) {
        Log.w(TAG, String.valueOf(this.name) + u15.f19942b + str);
    }
}
