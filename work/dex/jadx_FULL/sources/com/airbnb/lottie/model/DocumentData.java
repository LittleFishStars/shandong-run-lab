package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DocumentData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Justification f490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f492a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @ColorInt
    public int f493b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f494b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @ColorInt
    public int f495c;
    public float d;

    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f, Justification justification, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z) {
        a(str, str2, f, justification, i, f2, f3, i2, i3, f4, z);
    }

    public void a(String str, String str2, float f, Justification justification, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z) {
        this.f491a = str;
        this.f494b = str2;
        this.f23367a = f;
        this.f490a = justification;
        this.f489a = i;
        this.b = f2;
        this.c = f3;
        this.f493b = i2;
        this.f495c = i3;
        this.d = f4;
        this.f492a = z;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f491a.hashCode() * 31) + this.f494b.hashCode()) * 31) + this.f23367a)) * 31) + this.f490a.ordinal()) * 31) + this.f489a;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.b);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f493b;
    }

    public DocumentData() {
    }
}
