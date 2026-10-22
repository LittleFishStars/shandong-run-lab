package com.google.android.exoplayer2.ui;

import android.view.View;
import androidx.annotation.Nullable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AdOverlayInfo {
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f4716a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f4717a;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Purpose {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31052a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final View f4718a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f4719a;

        public a(View view, int i) {
            this.f4718a = view;
            this.f31052a = i;
        }

        public AdOverlayInfo a() {
            return new AdOverlayInfo(this.f4718a, this.f31052a, this.f4719a);
        }

        public a b(@Nullable String str) {
            this.f4719a = str;
            return this;
        }
    }

    @Deprecated
    public AdOverlayInfo(View view, int i) {
        this(view, i, null);
    }

    @Deprecated
    public AdOverlayInfo(View view, int i, @Nullable String str) {
        this.f4716a = view;
        this.f31051a = i;
        this.f4717a = str;
    }
}
