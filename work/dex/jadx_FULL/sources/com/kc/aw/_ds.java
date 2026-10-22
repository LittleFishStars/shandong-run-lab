package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ds implements Serializable {
    public String _a;
    public String _b;
    public String _c;
    public long _d;
    public long _e;
    public int _f;
    public int _g = 45;

    public final long _a() {
        return this._e;
    }

    public final void _a(int i) {
        this._g = i;
    }

    public final void _a(long j) {
        this._e = j;
    }

    public final void _a(String str) {
        this._b = str;
    }

    public final int _b() {
        return this._g;
    }

    public final void _b(int i) {
        this._f = i;
    }

    public final void _b(long j) {
        this._d = j;
    }

    public final void _b(String str) {
        this._a = str;
    }

    public final String _c() {
        return this._c;
    }

    public final void _c(String str) {
        this._c = str;
    }

    public final int _d() {
        return this._f;
    }

    public final long _e() {
        return this._d;
    }
}
