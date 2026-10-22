package com.zj.adlib;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ShowFirstParty
@KeepForSdk
public class qv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @KeepForSdk
    public static final int f44306a = b.f31268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final qv3 f19176a = new qv3();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f19177a = "com.google.android.gms";

    @NonNull
    @KeepForSdk
    public static final String b = "com.android.vending";

    @KeepForSdk
    public static final String c = "d";

    @KeepForSdk
    public static final String d = "n";

    @KeepForSdk
    public qv3() {
    }

    @NonNull
    @KeepForSdk
    public static qv3 i() {
        return f19176a;
    }

    @KeepForSdk
    public void a(@NonNull Context context) {
        b.a(context);
    }

    @ShowFirstParty
    @KeepForSdk
    public int b(@NonNull Context context) {
        return b.d(context);
    }

    @ShowFirstParty
    @KeepForSdk
    public int c(@NonNull Context context) {
        return b.e(context);
    }

    @Deprecated
    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public Intent d(int i) {
        return e(null, i, null);
    }

    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public Intent e(@Nullable Context context, int i, @Nullable String str) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return null;
            }
            return mrd.c("com.google.android.gms");
        }
        if (context != null && cm2.l(context)) {
            return mrd.a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f44306a);
        sb.append(c49.f40900a);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(c49.f40900a);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append(c49.f40900a);
        if (context != null) {
            try {
                sb.append(w0a.a(context).f(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return mrd.b("com.google.android.gms", sb.toString());
    }

    @Nullable
    @KeepForSdk
    public PendingIntent f(@NonNull Context context, int i, int i2) {
        return g(context, i, i2, null);
    }

    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public PendingIntent g(@NonNull Context context, int i, int i2, @Nullable String str) {
        Intent intentE = e(context, i, str);
        if (intentE == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, intentE, uhc.f45151a | 134217728);
    }

    @NonNull
    @KeepForSdk
    public String h(int i) {
        return b.g(i);
    }

    @HideFirstParty
    @KeepForSdk
    public int j(@NonNull Context context) {
        return k(context, f44306a);
    }

    @KeepForSdk
    public int k(@NonNull Context context, int i) {
        int iM = b.m(context, i);
        if (b.o(context, iM)) {
            return 18;
        }
        return iM;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean l(@NonNull Context context, int i) {
        return b.o(context, i);
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean m(@NonNull Context context, int i) {
        return b.p(context, i);
    }

    @KeepForSdk
    public boolean n(@NonNull Context context, @NonNull String str) {
        return b.u(context, str);
    }

    @KeepForSdk
    public boolean o(int i) {
        return b.s(i);
    }

    @KeepForSdk
    public void p(@NonNull Context context, int i) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        b.c(context, i);
    }
}
