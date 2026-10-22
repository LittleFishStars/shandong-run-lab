package com.aliyun.vod.common.logger;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AndroidLogTool implements LogTool {
    @Override // com.aliyun.vod.common.logger.LogTool
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.aliyun.vod.common.logger.LogTool
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.aliyun.vod.common.logger.LogTool
    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.aliyun.vod.common.logger.LogTool
    public void v(String str, String str2) {
        Log.v(str, str2);
    }

    @Override // com.aliyun.vod.common.logger.LogTool
    public void w(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // com.aliyun.vod.common.logger.LogTool
    public void wtf(String str, String str2) {
        Log.wtf(str, str2);
    }
}
