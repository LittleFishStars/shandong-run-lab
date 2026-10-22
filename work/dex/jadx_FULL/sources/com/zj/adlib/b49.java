package com.zj.adlib;

import android.graphics.Typeface;
import android.text.style.CharacterStyle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class b49 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40677a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Typeface f15437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharacterStyle f15438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public fm8 f15439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f15440a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15441a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f15442b;
    public int c;
    public int d;

    public void a(fm8 builder) {
        this.f15439a = builder;
    }

    public int b() {
        return this.d;
    }

    public Typeface c() {
        return this.f15437a;
    }

    public CharacterStyle d() {
        return this.f15438a;
    }

    public String e() {
        return this.f15440a;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.f40677a;
    }

    public int h() {
        return this.c;
    }

    public fm8 i() {
        this.f15439a.e(this);
        return this.f15439a;
    }

    public b49 j(int backgroundColor) {
        this.d = backgroundColor;
        return this;
    }

    public b49 k(Typeface customTypeface) {
        this.f15437a = customTypeface;
        return this;
    }

    public b49 l(boolean showStrikethrough) {
        this.f15441a = showStrikethrough;
        return this;
    }

    public b49 m(boolean showUnderline) {
        this.f15442b = showUnderline;
        return this;
    }

    public b49 n(CharacterStyle textSpan) {
        this.f15438a = textSpan;
        return this;
    }

    public b49 o(String text) {
        this.f15440a = text;
        return this;
    }

    public b49 p(int textColor) {
        this.b = textColor;
        return this;
    }

    public b49 q(int textSize) {
        this.f40677a = textSize;
        return this;
    }

    public b49 r(int typeface) {
        this.c = typeface;
        return this;
    }

    public boolean s() {
        return this.f15441a;
    }

    public boolean t() {
        return this.f15442b;
    }
}
