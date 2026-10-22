package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@CheckReturnValue
public class ml6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f43328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Throwable f18252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f18253a;

    @Nullable
    public final String b;

    public ml6(String str, int i, boolean z, @Nullable String str2, @Nullable Throwable th) {
        this.f43328a = str;
        this.f18253a = z;
        this.b = str2;
        this.f18252a = th;
    }

    @NonNull
    public static ml6 a(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        return new ml6(str, 1, false, str2, th);
    }

    @NonNull
    public static ml6 d(@NonNull String str, int i) {
        return new ml6(str, i, true, null, null);
    }

    public final void b() {
        if (this.f18253a) {
            return;
        }
        String strConcat = "PackageVerificationRslt: ".concat(String.valueOf(this.b));
        Throwable th = this.f18252a;
        if (th == null) {
            throw new SecurityException(strConcat);
        }
        throw new SecurityException(strConcat, th);
    }

    public final boolean c() {
        return this.f18253a;
    }
}
