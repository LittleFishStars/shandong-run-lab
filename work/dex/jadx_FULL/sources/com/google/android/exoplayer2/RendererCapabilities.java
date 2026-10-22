package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface RendererCapabilities {

    @Deprecated
    public static final int A2 = 3;

    @Deprecated
    public static final int B2 = 2;

    @Deprecated
    public static final int D2 = 1;

    @Deprecated
    public static final int E2 = 0;
    public static final int F2 = 24;
    public static final int G2 = 16;
    public static final int H2 = 8;
    public static final int I2 = 0;
    public static final int J2 = 32;
    public static final int K2 = 32;
    public static final int L2 = 0;
    public static final int N2 = 64;
    public static final int O2 = 64;
    public static final int P2 = 0;
    public static final int Q2 = 128;
    public static final int R2 = 128;
    public static final int S2 = 0;
    public static final int y2 = 7;

    @Deprecated
    public static final int z2 = 4;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdaptiveSupport {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Capabilities {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DecoderSupport {
    }

    @Target({ElementType.TYPE_USE})
    @Deprecated
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FormatSupport {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface HardwareAccelerationSupport {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TunnelingSupport {
    }

    static int create(int i) {
        return create(i, 0, 0);
    }

    @SuppressLint({"WrongConstant"})
    static int create(int i, int i2, int i3, int i4, int i5) {
        return i | i2 | i3 | i4 | i5;
    }

    @SuppressLint({"WrongConstant"})
    static int getAdaptiveSupport(int i) {
        return i & 24;
    }

    @SuppressLint({"WrongConstant"})
    static int getDecoderSupport(int i) {
        return i & 128;
    }

    @SuppressLint({"WrongConstant"})
    static int getFormatSupport(int i) {
        return i & 7;
    }

    @SuppressLint({"WrongConstant"})
    static int getHardwareAccelerationSupport(int i) {
        return i & 64;
    }

    @SuppressLint({"WrongConstant"})
    static int getTunnelingSupport(int i) {
        return i & 32;
    }

    int e(d dVar) throws ExoPlaybackException;

    String getName();

    int getTrackType();

    int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException;

    static int create(int i, int i2, int i3) {
        return create(i, i2, i3, 0, 128);
    }
}
