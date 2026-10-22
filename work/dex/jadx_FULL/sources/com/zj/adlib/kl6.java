package com.zj.adlib;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class kl6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Context f42850a;

    public kl6(@NonNull Context context) {
        this.f42850a = context;
    }

    @KeepForSdk
    public int a(@NonNull String str) {
        return this.f42850a.checkCallingOrSelfPermission(str);
    }

    @KeepForSdk
    public int b(@NonNull String str, @NonNull String str2) {
        return this.f42850a.getPackageManager().checkPermission(str, str2);
    }

    @NonNull
    @KeepForSdk
    public ApplicationInfo c(@NonNull String str, int i) throws PackageManager.NameNotFoundException {
        return this.f42850a.getPackageManager().getApplicationInfo(str, i);
    }

    @NonNull
    @KeepForSdk
    public CharSequence d(@NonNull String str) throws PackageManager.NameNotFoundException {
        return this.f42850a.getPackageManager().getApplicationLabel(this.f42850a.getPackageManager().getApplicationInfo(str, 0));
    }

    @NonNull
    @KeepForSdk
    public Pair<CharSequence, Drawable> e(@NonNull String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo = this.f42850a.getPackageManager().getApplicationInfo(str, 0);
        return Pair.create(this.f42850a.getPackageManager().getApplicationLabel(applicationInfo), this.f42850a.getPackageManager().getApplicationIcon(applicationInfo));
    }

    @NonNull
    @KeepForSdk
    public PackageInfo f(@NonNull String str, int i) throws PackageManager.NameNotFoundException {
        return this.f42850a.getPackageManager().getPackageInfo(str, i);
    }

    @KeepForSdk
    public boolean g() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return kb4.a(this.f42850a);
        }
        if (!is6.n() || (nameForUid = this.f42850a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f42850a.getPackageManager().isInstantApp(nameForUid);
    }

    @TargetApi(19)
    public final boolean h(int i, @NonNull String str) {
        if (is6.h()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) this.f42850a.getSystemService("appops");
                if (appOpsManager == null) {
                    throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
                }
                appOpsManager.checkPackage(i, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.f42850a.getPackageManager().getPackagesForUid(i);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
