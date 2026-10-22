package com.kc.openset.verify;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface ServiceVerifyResultListener {
    void onServiceVerifyError(String str, String str2, ServiceVerifyType serviceVerifyType);

    void onServiceVerifySuccess(String str, int i, ServiceVerifyType serviceVerifyType);
}
