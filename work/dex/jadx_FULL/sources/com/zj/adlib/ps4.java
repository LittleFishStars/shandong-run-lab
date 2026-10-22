package com.zj.adlib;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ps4<T> {
    public static final int c = 784923401;
    public static final float f = -3987645.8f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f44051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f18923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PointF f18924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Interpolator f18925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final k35 f18926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Float f18927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final T f18928a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f18929b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public PointF f18930b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final Interpolator f18931b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public T f18932b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float f18933c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public final Interpolator f18934c;
    public float d;
    public float e;

    public ps4(k35 k35Var, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.b = -3987645.8f;
        this.f18933c = -3987645.8f;
        this.f18923a = c;
        this.f18929b = c;
        this.d = Float.MIN_VALUE;
        this.e = Float.MIN_VALUE;
        this.f18924a = null;
        this.f18930b = null;
        this.f18926a = k35Var;
        this.f18928a = t;
        this.f18932b = t2;
        this.f18925a = interpolator;
        this.f18931b = null;
        this.f18934c = null;
        this.f44051a = f2;
        this.f18927a = f3;
    }

    public boolean a(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f2) {
        return f2 >= e() && f2 < b();
    }

    public float b() {
        if (this.f18926a == null) {
            return 1.0f;
        }
        if (this.e == Float.MIN_VALUE) {
            if (this.f18927a == null) {
                this.e = 1.0f;
            } else {
                this.e = e() + ((this.f18927a.floatValue() - this.f44051a) / this.f18926a.e());
            }
        }
        return this.e;
    }

    public float c() {
        if (this.f18933c == -3987645.8f) {
            this.f18933c = ((Float) this.f18932b).floatValue();
        }
        return this.f18933c;
    }

    public int d() {
        if (this.f18929b == 784923401) {
            this.f18929b = ((Integer) this.f18932b).intValue();
        }
        return this.f18929b;
    }

    public float e() {
        k35 k35Var = this.f18926a;
        if (k35Var == null) {
            return 0.0f;
        }
        if (this.d == Float.MIN_VALUE) {
            this.d = (this.f44051a - k35Var.r()) / this.f18926a.e();
        }
        return this.d;
    }

    public float f() {
        if (this.b == -3987645.8f) {
            this.b = ((Float) this.f18928a).floatValue();
        }
        return this.b;
    }

    public int g() {
        if (this.f18923a == 784923401) {
            this.f18923a = ((Integer) this.f18928a).intValue();
        }
        return this.f18923a;
    }

    public boolean h() {
        return this.f18925a == null && this.f18931b == null && this.f18934c == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f18928a + ", endValue=" + this.f18932b + ", startFrame=" + this.f44051a + ", endFrame=" + this.f18927a + ", interpolator=" + this.f18925a + '}';
    }

    public ps4(k35 k35Var, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, float f2, @Nullable Float f3) {
        this.b = -3987645.8f;
        this.f18933c = -3987645.8f;
        this.f18923a = c;
        this.f18929b = c;
        this.d = Float.MIN_VALUE;
        this.e = Float.MIN_VALUE;
        this.f18924a = null;
        this.f18930b = null;
        this.f18926a = k35Var;
        this.f18928a = t;
        this.f18932b = t2;
        this.f18925a = null;
        this.f18931b = interpolator;
        this.f18934c = interpolator2;
        this.f44051a = f2;
        this.f18927a = f3;
    }

    public ps4(k35 k35Var, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, @Nullable Interpolator interpolator3, float f2, @Nullable Float f3) {
        this.b = -3987645.8f;
        this.f18933c = -3987645.8f;
        this.f18923a = c;
        this.f18929b = c;
        this.d = Float.MIN_VALUE;
        this.e = Float.MIN_VALUE;
        this.f18924a = null;
        this.f18930b = null;
        this.f18926a = k35Var;
        this.f18928a = t;
        this.f18932b = t2;
        this.f18925a = interpolator;
        this.f18931b = interpolator2;
        this.f18934c = interpolator3;
        this.f44051a = f2;
        this.f18927a = f3;
    }

    public ps4(T t) {
        this.b = -3987645.8f;
        this.f18933c = -3987645.8f;
        this.f18923a = c;
        this.f18929b = c;
        this.d = Float.MIN_VALUE;
        this.e = Float.MIN_VALUE;
        this.f18924a = null;
        this.f18930b = null;
        this.f18926a = null;
        this.f18928a = t;
        this.f18932b = t;
        this.f18925a = null;
        this.f18931b = null;
        this.f18934c = null;
        this.f44051a = Float.MIN_VALUE;
        this.f18927a = Float.valueOf(Float.MAX_VALUE);
    }
}
