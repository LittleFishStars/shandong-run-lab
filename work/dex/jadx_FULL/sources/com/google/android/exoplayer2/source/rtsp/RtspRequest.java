package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class RtspRequest {
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = 6;
    public static final int i = 7;
    public static final int j = 8;
    public static final int k = 9;
    public static final int l = 10;
    public static final int m = 11;
    public static final int n = 12;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f4389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f4390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f4391a;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Method {
    }

    public RtspRequest(Uri uri, int i2, d dVar, String str) {
        this.f4389a = uri;
        this.f30967a = i2;
        this.f4390a = dVar;
        this.f4391a = str;
    }
}
