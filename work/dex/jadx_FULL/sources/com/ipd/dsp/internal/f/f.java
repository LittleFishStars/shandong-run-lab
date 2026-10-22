package com.ipd.dsp.internal.f;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38294a = "UTF-8";
    public static final Charset b = Charset.forName("UTF-8");

    void a(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
