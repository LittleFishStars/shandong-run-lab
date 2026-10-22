package com.zj.adlib;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class sv3 extends b {

    @Deprecated
    public static final int d = b.f31268a;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public static final String f19652d = "GooglePlayServicesErrorDialog";

    @NonNull
    @Deprecated
    public static final String e = "com.google.android.gms";

    @NonNull
    public static final String f = "com.android.vending";

    @Deprecated
    public static void A(int i, @NonNull Context context) {
        pv3 pv3VarX = pv3.x();
        if (b.o(context, i) || b.p(context, i)) {
            pv3VarX.J(context);
        } else {
            pv3VarX.C(context, i);
        }
    }

    @NonNull
    @Deprecated
    public static PendingIntent f(int i, @NonNull Context context, int i2) {
        return b.f(i, context, i2);
    }

    @NonNull
    @VisibleForTesting
    @Deprecated
    public static String g(int i) {
        return b.g(i);
    }

    @NonNull
    public static Context i(@NonNull Context context) {
        return b.i(context);
    }

    @NonNull
    public static Resources j(@NonNull Context context) {
        return b.j(context);
    }

    @HideFirstParty
    @Deprecated
    public static int l(@NonNull Context context) {
        return b.l(context);
    }

    @KeepForSdk
    @Deprecated
    public static int m(@NonNull Context context, int i) {
        return b.m(context, i);
    }

    @Deprecated
    public static boolean s(int i) {
        return b.s(i);
    }

    @Nullable
    @Deprecated
    public static Dialog v(int i, @NonNull Activity activity, int i2) {
        return w(i, activity, i2, null);
    }

    @Nullable
    @Deprecated
    public static Dialog w(int i, @NonNull Activity activity, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == b.o(activity, i)) {
            i = 18;
        }
        return pv3.x().t(activity, i, i2, onCancelListener);
    }

    @Deprecated
    public static boolean x(int i, @NonNull Activity activity, int i2) {
        return y(i, activity, i2, null);
    }

    @Deprecated
    public static boolean y(int i, @NonNull Activity activity, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return z(i, activity, null, i2, onCancelListener);
    }

    public static boolean z(int i, @NonNull Activity activity, @Nullable Fragment fragment, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == b.o(activity, i)) {
            i = 18;
        }
        pv3 pv3VarX = pv3.x();
        if (fragment == null) {
            return pv3VarX.B(activity, i, i2, onCancelListener);
        }
        Dialog dialogE = pv3VarX.E(activity, i, zag.b(fragment, pv3.x().e(activity, i, "d"), i2), onCancelListener);
        if (dialogE == null) {
            return false;
        }
        pv3VarX.H(activity, dialogE, f19652d, onCancelListener);
        return true;
    }
}
