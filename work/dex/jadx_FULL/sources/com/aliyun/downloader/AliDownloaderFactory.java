package com.aliyun.downloader;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AliDownloaderFactory {
    public static AliMediaDownloader create(Context context) {
        return new ApsaraDownloader(context.getApplicationContext());
    }

    public static int deleteFile(String str, String str2, String str3, int i) {
        return AliMediaDownloader.deleteFile(str, str2, str3, i);
    }
}
