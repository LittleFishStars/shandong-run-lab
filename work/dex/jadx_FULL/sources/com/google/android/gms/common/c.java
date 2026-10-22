package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.zj.adlib.wud;
import com.zj.adlib.yw6;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@CheckReturnValue
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static c f31269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static volatile Set f5627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f5628a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile String f5629a;

    public c(@NonNull Context context) {
        this.f5628a = context.getApplicationContext();
    }

    @NonNull
    @KeepForSdk
    public static c a(@NonNull Context context) {
        yw6.l(context);
        synchronized (c.class) {
            if (f31269a == null) {
                f.e(context);
                f31269a = new c(context);
            }
        }
        return f31269a;
    }

    @Nullable
    public static final zzj e(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzjVarArr.length; i++) {
            if (zzjVarArr[i].equals(zzkVar)) {
                return zzjVarArr[i];
            }
        }
        return null;
    }

    public static final boolean f(@NonNull PackageInfo packageInfo, boolean z) {
        if (z && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
        }
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? e(packageInfo, e.f31278a) : e(packageInfo, e.f31278a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public boolean b(@NonNull PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (f(packageInfo, false)) {
            return true;
        }
        if (f(packageInfo, true)) {
            if (b.k(this.f5628a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean c(@NonNull String str) {
        wud wudVarG = g(str, false, false);
        wudVarG.e();
        return wudVarG.f20574a;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean d(int i) {
        wud wudVarC;
        String[] packagesForUid = this.f5628a.getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null || (packagesForUid.length) == 0) {
            wudVarC = wud.c("no pkgs");
        } else {
            wudVarC = null;
            for (String str : packagesForUid) {
                wudVarC = g(str, false, false);
                if (!wudVarC.f20574a) {
                }
            }
            yw6.l(wudVarC);
        }
        wudVarC.e();
        return wudVarC.f20574a;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public final wud g(String str, boolean z, boolean z2) {
        wud wudVarC;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return wud.c("null pkg");
        }
        if (str.equals(this.f5629a)) {
            return wud.b();
        }
        if (f.g()) {
            wudVarC = f.b(str, b.k(this.f5628a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f5628a.getPackageManager().getPackageInfo(str, 64);
                boolean zK = b.k(this.f5628a);
                if (packageInfo == null) {
                    wudVarC = wud.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        wudVarC = wud.c("single cert required");
                    } else {
                        zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        wud wudVarA = f.a(str2, zzkVar, zK, false);
                        wudVarC = (!wudVarA.f20574a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !f.a(str2, zzkVar, false, true).f20574a) ? wudVarA : wud.c("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                return wud.d("no pkg ".concat(str), e);
            }
        }
        if (wudVarC.f20574a) {
            this.f5629a = str;
        }
        return wudVarC;
    }
}
