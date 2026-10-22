package com.zj.adlib;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.Utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class zn1 {
    public zn1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int a(@ColorRes int i) {
        return ContextCompat.getColor(Utils.a(), i);
    }

    public static int b() {
        return c(true);
    }

    public static int c(boolean z) {
        return (z ? ((int) (Math.random() * 256.0d)) << 24 : -16777216) | ((int) (Math.random() * 1.6777216E7d));
    }

    public static String d(@ColorInt int i) {
        String hexString = Integer.toHexString(i);
        while (hexString.length() < 6) {
            hexString = "0" + hexString;
        }
        while (hexString.length() < 8) {
            hexString = "f" + hexString;
        }
        return "#" + hexString;
    }

    public static String e(@ColorInt int i) {
        String hexString = Integer.toHexString(i & 16777215);
        while (hexString.length() < 6) {
            hexString = "0" + hexString;
        }
        return "#" + hexString;
    }

    public static boolean f(@ColorInt int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) >= 127.5d;
    }

    public static int g(@ColorInt int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return (i & 16777215) | (((int) ((f * 255.0f) + 0.5f)) << 24);
    }

    public static int h(@ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public static int i(@ColorInt int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return (i & (-256)) | ((int) ((f * 255.0f) + 0.5f));
    }

    public static int j(@ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        return (i & (-256)) | i2;
    }

    public static int k(@ColorInt int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return (i & (-65281)) | (((int) ((f * 255.0f) + 0.5f)) << 8);
    }

    public static int l(@ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        return (i & (-65281)) | (i2 << 8);
    }

    public static int m(@ColorInt int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return (i & (-16711681)) | (((int) ((f * 255.0f) + 0.5f)) << 16);
    }

    public static int n(@ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        return (i & (-16711681)) | (i2 << 16);
    }

    public static int o(@NonNull String str) {
        return Color.parseColor(str);
    }
}
