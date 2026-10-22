package com.google.android.exoplayer2.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.zj.adlib.gj9;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class CaptionStyleCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CaptionStyleCompat f31056a = new CaptionStyleCompat(-1, -16777216, 0, 0, -1, null);
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 3;
    public static final int j = 4;
    public static final int k = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f4727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Typeface f4728a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface EdgeType {
    }

    public CaptionStyleCompat(int i2, int i3, int i4, int i5, int i6, @Nullable Typeface typeface) {
        this.f4727a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = i6;
        this.f4728a = typeface;
    }

    @RequiresApi(19)
    public static CaptionStyleCompat a(CaptioningManager.CaptionStyle captionStyle) {
        return gj9.f41922a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    @RequiresApi(19)
    public static CaptionStyleCompat b(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @RequiresApi(21)
    public static CaptionStyleCompat c(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f31056a.f4727a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f31056a.b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f31056a.c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f31056a.d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f31056a.e, captionStyle.getTypeface());
    }
}
