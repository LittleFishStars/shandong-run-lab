package com.zj.adlib;

import com.facebook.imagepipeline.nativecode.WebpTranscoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class av9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WebpTranscoder f40621a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f15402a = false;

    static {
        try {
            f40621a = (WebpTranscoder) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            f15402a = true;
        } catch (Throwable unused) {
            f15402a = false;
        }
    }

    public static WebpTranscoder a() {
        return f40621a;
    }
}
