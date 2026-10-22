package com.zj.adlib;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.b;
import com.google.android.gms.common.f;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.zzae;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@CheckReturnValue
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*javatests.*/com/google/android/gms/common/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class ll6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static j8c f43095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile d8c f17991a;

    public static j8c c() {
        j8c j8cVar;
        synchronized (j8c.class) {
            if (f43095a == null) {
                f43095a = new j8c();
            }
            j8cVar = f43095a;
        }
        return j8cVar;
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public ml6 a(@NonNull Context context, @NonNull String str) {
        boolean zK = b.k(context);
        c();
        if (!f.f()) {
            throw new zzae();
        }
        String strConcat = String.valueOf(str).concat(true != zK ? "-0" : "-1");
        if (this.f17991a != null && this.f17991a.f15945a.equals(strConcat)) {
            return this.f17991a.f41128a;
        }
        c();
        wud wudVarC = f.c(str, zK, false, false);
        if (wudVarC.f20574a) {
            this.f17991a = new d8c(strConcat, ml6.d(str, wudVarC.f20571a));
            return this.f17991a.f41128a;
        }
        yw6.l(wudVarC.f20572a);
        return ml6.a(str, wudVarC.f20572a, wudVarC.f20573a);
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public ml6 b(@NonNull Context context, @NonNull String str) {
        try {
            ml6 ml6VarA = a(context, str);
            ml6VarA.b();
            return ml6VarA;
        } catch (SecurityException e) {
            ml6 ml6VarA2 = a(context, str);
            if (!ml6VarA2.c()) {
                return ml6VarA2;
            }
            Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e);
            return ml6VarA2;
        }
    }
}
