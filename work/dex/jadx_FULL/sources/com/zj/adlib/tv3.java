package com.zj.adlib;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
@Deprecated
public final class tv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    @GuardedBy("sLock")
    public static tv3 f45012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f19901a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Status f19902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f19903a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f19904a;
    public final boolean b;

    @VisibleForTesting
    @KeepForSdk
    public tv3(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", TypedValues.Custom.S_INT, resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            int integer = resources.getInteger(identifier);
            boolean z2 = integer == 0;
            z = integer != 0;
            this.b = z2;
        } else {
            this.b = false;
        }
        this.f19904a = z;
        String strB = w8c.b(context);
        strB = strB == null ? new ts8(context).a("google_app_id") : strB;
        if (TextUtils.isEmpty(strB)) {
            this.f19902a = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f19903a = null;
        } else {
            this.f19903a = strB;
            this.f19902a = Status.RESULT_SUCCESS;
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public tv3(String str, boolean z) {
        this.f19903a = str;
        this.f19902a = Status.RESULT_SUCCESS;
        this.f19904a = z;
        this.b = !z;
    }

    @KeepForSdk
    public static tv3 b(String str) {
        tv3 tv3Var;
        synchronized (f19901a) {
            tv3Var = f45012a;
            if (tv3Var == null) {
                throw new IllegalStateException("Initialize must be called before " + str + Consts.DOT);
            }
        }
        return tv3Var;
    }

    @VisibleForTesting
    @KeepForSdk
    public static void c() {
        synchronized (f19901a) {
            f45012a = null;
        }
    }

    @Nullable
    @KeepForSdk
    public static String d() {
        return b("getGoogleAppId").f19903a;
    }

    @NonNull
    @KeepForSdk
    public static Status e(@NonNull Context context) {
        Status status;
        yw6.m(context, "Context must not be null.");
        synchronized (f19901a) {
            if (f45012a == null) {
                f45012a = new tv3(context);
            }
            status = f45012a.f19902a;
        }
        return status;
    }

    @NonNull
    @KeepForSdk
    public static Status f(@NonNull Context context, @NonNull String str, boolean z) {
        yw6.m(context, "Context must not be null.");
        yw6.i(str, "App ID must be nonempty.");
        synchronized (f19901a) {
            tv3 tv3Var = f45012a;
            if (tv3Var != null) {
                return tv3Var.a(str);
            }
            tv3 tv3Var2 = new tv3(str, z);
            f45012a = tv3Var2;
            return tv3Var2.f19902a;
        }
    }

    @KeepForSdk
    public static boolean g() {
        tv3 tv3VarB = b("isMeasurementEnabled");
        return tv3VarB.f19902a.isSuccess() && tv3VarB.f19904a;
    }

    @KeepForSdk
    public static boolean h() {
        return b("isMeasurementExplicitlyDisabled").b;
    }

    @VisibleForTesting
    @KeepForSdk
    public Status a(String str) {
        String str2 = this.f19903a;
        if (str2 == null || str2.equals(str)) {
            return Status.RESULT_SUCCESS;
        }
        return new Status(10, "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + this.f19903a + "'.");
    }
}
