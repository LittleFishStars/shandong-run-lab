package com.zj.adlib;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class e25 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final su3 f16182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f16183a;
    public final String b;

    @KeepForSdk
    public e25(@NonNull String str, @NonNull String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.b = string;
        this.f16183a = str;
        this.f16182a = new su3(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.f16183a, i)) {
            i++;
        }
        this.f41329a = i;
    }

    @KeepForSdk
    public void a(@NonNull String str, @NonNull Object... objArr) {
        if (f(3)) {
            Log.d(this.f16183a, format(str, objArr));
        }
    }

    @KeepForSdk
    public void b(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        Log.e(this.f16183a, format(str, objArr), th);
    }

    @KeepForSdk
    public void c(@NonNull String str, @NonNull Object... objArr) {
        Log.e(this.f16183a, format(str, objArr));
    }

    @NonNull
    @KeepForSdk
    public String d() {
        return this.f16183a;
    }

    @KeepForSdk
    public void e(@NonNull String str, @NonNull Object... objArr) {
        Log.i(this.f16183a, format(str, objArr));
    }

    @KeepForSdk
    public boolean f(int i) {
        return this.f41329a <= i;
    }

    @NonNull
    @KeepForSdk
    public String format(@NonNull String str, @NonNull Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.b.concat(str);
    }

    @KeepForSdk
    public void g(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        if (f(2)) {
            Log.v(this.f16183a, format(str, objArr), th);
        }
    }

    @KeepForSdk
    public void h(@NonNull String str, @NonNull Object... objArr) {
        if (f(2)) {
            Log.v(this.f16183a, format(str, objArr));
        }
    }

    @KeepForSdk
    public void i(@NonNull String str, @NonNull Object... objArr) {
        Log.w(this.f16183a, format(str, objArr));
    }

    @KeepForSdk
    public void j(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        Log.wtf(this.f16183a, format(str, objArr), th);
    }

    @KeepForSdk
    public void k(@NonNull Throwable th) {
        Log.wtf(this.f16183a, th);
    }
}
