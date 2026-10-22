package com.zj.adlib;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.FormatMethod;
import com.google.errorprone.annotations.FormatString;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class su3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44778a;

    @Nullable
    public final String b;

    @KeepForSdk
    public su3(@NonNull String str) {
        this(str, null);
    }

    @KeepForSdk
    public boolean a(int i) {
        return Log.isLoggable(this.f44778a, i);
    }

    @KeepForSdk
    public boolean b() {
        return false;
    }

    @KeepForSdk
    public void c(@NonNull String str, @NonNull String str2) {
        if (a(3)) {
            Log.d(str, r(str2));
        }
    }

    @KeepForSdk
    public void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(3)) {
            Log.d(str, r(str2), th);
        }
    }

    @KeepForSdk
    public void e(@NonNull String str, @NonNull String str2) {
        if (a(6)) {
            Log.e(str, r(str2));
        }
    }

    @KeepForSdk
    public void f(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(6)) {
            Log.e(str, r(str2), th);
        }
    }

    @KeepForSdk
    @FormatMethod
    public void g(@NonNull String str, @NonNull @FormatString String str2, @NonNull Object... objArr) {
        if (a(6)) {
            Log.e(str, s(str2, objArr));
        }
    }

    @KeepForSdk
    public void h(@NonNull String str, @NonNull String str2) {
        if (a(4)) {
            Log.i(str, r(str2));
        }
    }

    @KeepForSdk
    public void i(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(4)) {
            Log.i(str, r(str2), th);
        }
    }

    @KeepForSdk
    public void j(@NonNull String str, @NonNull String str2) {
    }

    @KeepForSdk
    public void k(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
    }

    @KeepForSdk
    public void l(@NonNull String str, @NonNull String str2) {
        if (a(2)) {
            Log.v(str, r(str2));
        }
    }

    @KeepForSdk
    public void m(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(2)) {
            Log.v(str, r(str2), th);
        }
    }

    @KeepForSdk
    public void n(@NonNull String str, @NonNull String str2) {
        if (a(5)) {
            Log.w(str, r(str2));
        }
    }

    @KeepForSdk
    public void o(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(5)) {
            Log.w(str, r(str2), th);
        }
    }

    @KeepForSdk
    @FormatMethod
    public void p(@NonNull String str, @NonNull @FormatString String str2, @NonNull Object... objArr) {
        if (a(5)) {
            Log.w(this.f44778a, s(str2, objArr));
        }
    }

    @KeepForSdk
    public void q(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (a(7)) {
            Log.e(str, r(str2), th);
            Log.wtf(str, r(str2), th);
        }
    }

    public final String r(String str) {
        String str2 = this.b;
        return str2 == null ? str : str2.concat(str);
    }

    @FormatMethod
    public final String s(String str, Object... objArr) {
        String str2 = String.format(str, objArr);
        String str3 = this.b;
        return str3 == null ? str2 : str3.concat(str2);
    }

    @KeepForSdk
    public su3(@NonNull String str, @Nullable String str2) {
        yw6.m(str, "log tag cannot be null");
        yw6.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f44778a = str;
        if (str2 == null || str2.length() <= 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
    }
}
