package com.aliyun.svideosdk.license;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface ILicenseNativeInitCallback {
    void onError(int i, String str);

    void onSuccess(String str, long j, long j2, long j3);
}
