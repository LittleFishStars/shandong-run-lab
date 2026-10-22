package com.zj.adlib;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@CheckReturnValue
public class wud {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wud f45695a = new wud(true, 3, 1, null, null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f20571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f20572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Throwable f20573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f20574a;

    public wud(boolean z, int i, int i2, @Nullable String str, @Nullable Throwable th) {
        this.f20574a = z;
        this.f20571a = i;
        this.f20572a = str;
        this.f20573a = th;
    }

    @Deprecated
    public static wud b() {
        return f45695a;
    }

    public static wud c(@NonNull String str) {
        return new wud(false, 1, 5, str, null);
    }

    public static wud d(@NonNull String str, @NonNull Throwable th) {
        return new wud(false, 1, 5, str, th);
    }

    public static wud f(int i) {
        return new wud(true, i, 1, null, null);
    }

    public static wud g(int i, int i2, @NonNull String str, @Nullable Throwable th) {
        return new wud(false, i, i2, str, th);
    }

    @Nullable
    public String a() {
        return this.f20572a;
    }

    public final void e() {
        if (this.f20574a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f20573a != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f20573a);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
