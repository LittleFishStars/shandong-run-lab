package com.baidu.mapsdkplatform.comjni.util;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class JNIMD5 {
    public static native String encodeUrlParamsValue(String str);

    public static native String getSignMD5String(String str);

    public static native String getSignMD5StringUTF8(String str);

    public static native String getUrlNeedInfo();
}
