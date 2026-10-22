package com.aliyun.svideosdk.common.struct.asset;

import android.graphics.Typeface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface FontResolver {
    public static final int DEFAULT_FONT = 10002;
    public static final int DEFAULT_FONT_2 = 10003;
    public static final int DEFAULT_FONT_3 = 10004;
    public static final int SYSTEM_FONT = 10001;

    long getFontIdValue(long j);

    int getFontType(long j);

    Typeface getTypeface(long j);

    Typeface getTypefaceByFont(long j);

    boolean isFontExit(long j);

    void removeFontById(Long l);

    void saveFontString(Long l, Long l2, Integer num);
}
