package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.d;
import com.zj.adlib.da9;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface TrackSelection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31042a = 0;
    public static final int b = 10000;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    int b(d dVar);

    da9 d();

    d e(int i);

    int getIndexInTrackGroup(int i);

    int getType();

    int indexOf(int i);

    int length();
}
