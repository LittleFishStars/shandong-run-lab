package com.aliyun.svideosdk.common.struct.asset;

import android.graphics.Typeface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TypefaceConfig {
    public final boolean fakeBold;
    public final Typeface typeface;

    public TypefaceConfig() {
        this(null, false);
    }

    public TypefaceConfig(Typeface typeface) {
        this(typeface, false);
    }

    public TypefaceConfig(Typeface typeface, boolean z) {
        this.typeface = typeface;
        this.fakeBold = z;
    }
}
