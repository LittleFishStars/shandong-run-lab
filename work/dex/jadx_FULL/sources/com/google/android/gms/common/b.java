package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.zj.adlib.cm2;
import com.zj.adlib.dm1;
import com.zj.adlib.e7c;
import com.zj.adlib.is6;
import com.zj.adlib.qv3;
import com.zj.adlib.vf9;
import com.zj.adlib.w0a;
import com.zj.adlib.w8c;
import com.zj.adlib.yw6;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ShowFirstParty
@KeepForSdk
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @KeepForSdk
    @Deprecated
    public static final int f31268a = 12451000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    @Deprecated
    public static final String f5620a = "com.google.android.gms";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f5622a = false;

    @KeepForSdk
    public static final int b = 39789;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f5623b = "com.google.android.play.games";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public static boolean f5625b = false;

    @KeepForSdk
    public static final int c = 10436;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f5626c = "com.android.vending";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @KeepForSdk
    public static final AtomicBoolean f5621a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final AtomicBoolean f5624b = new AtomicBoolean();

    @KeepForSdk
    public b() {
    }

    @KeepForSdk
    @Deprecated
    public static void a(@NonNull Context context) {
        if (f5621a.getAndSet(true)) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(c);
            }
        } catch (SecurityException unused) {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static void b() {
        f5624b.set(true);
    }

    @KeepForSdk
    @Deprecated
    public static void c(@NonNull Context context, int i) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int iK = qv3.i().k(context, i);
        if (iK != 0) {
            Intent intentE = qv3.i().e(context, iK, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + iK);
            if (intentE != null) {
                throw new GooglePlayServicesRepairableException(iK, "Google Play Services not available", intentE);
            }
            throw new GooglePlayServicesNotAvailableException(iK);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static int d(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static int e(@NonNull Context context) {
        yw6.r(true);
        return dm1.a(context, context.getPackageName());
    }

    @Nullable
    @KeepForSdk
    @Deprecated
    public static PendingIntent f(int i, @NonNull Context context, int i2) {
        return qv3.i().f(context, i, i2);
    }

    @NonNull
    @VisibleForTesting
    @Deprecated
    @KeepForSdk
    public static String g(int i) {
        return ConnectionResult.zza(i);
    }

    @Deprecated
    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public static Intent h(int i) {
        return qv3.i().e(null, i, null);
    }

    @Nullable
    @KeepForSdk
    public static Context i(@NonNull Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    @KeepForSdk
    public static Resources j(@NonNull Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static boolean k(@NonNull Context context) {
        try {
            if (!f5625b) {
                PackageInfo packageInfoF = w0a.a(context).f("com.google.android.gms", 64);
                c.a(context);
                if (packageInfoF == null || c.f(packageInfoF, false) || !c.f(packageInfoF, true)) {
                    f5622a = false;
                } else {
                    f5622a = true;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
        } finally {
            f5625b = true;
        }
        return f5622a || !cm2.j();
    }

    @HideFirstParty
    @KeepForSdk
    @Deprecated
    public static int l(@NonNull Context context) {
        return m(context, f31268a);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00de  */
    /* JADX WARN: Code duplicated, block: B:53:0x0106  */
    /* JADX WARN: Code duplicated, block: B:61:0x0122 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0124 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:52:0x00de, please report this as an issue */
    @KeepForSdk
    @Deprecated
    public static int m(@NonNull Context context, int i) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f5624b.get()) {
            int iA = w8c.a(context);
            if (iA == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if (iA != f31268a) {
                throw new GooglePlayServicesIncorrectManifestValueException(iA);
            }
        }
        boolean z = (cm2.l(context) || cm2.n(context)) ? false : true;
        yw6.a(i >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            c.a(context);
            if (!c.f(packageInfo2, true)) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
            } else {
                if (!z) {
                    if (z) {
                    }
                    if (e7c.a(packageInfo2.versionCode) < e7c.a(i)) {
                        applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        }
                        if (applicationInfo.enabled) {
                            return 0;
                        }
                        return 3;
                    }
                    Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i + " but found " + packageInfo2.versionCode);
                    return 2;
                }
                yw6.l(packageInfo);
                if (!c.f(packageInfo, true)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                } else {
                    if (z || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                        if (e7c.a(packageInfo2.versionCode) < e7c.a(i)) {
                            applicationInfo = packageInfo2.applicationInfo;
                            if (applicationInfo == null) {
                                try {
                                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                                } catch (PackageManager.NameNotFoundException e) {
                                    Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e);
                                    return 1;
                                }
                            }
                            if (applicationInfo.enabled) {
                                return 3;
                            }
                            return 0;
                        }
                        Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i + " but found " + packageInfo2.versionCode);
                        return 2;
                    }
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                }
            }
            return 9;
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
            return 1;
        }
    }

    @KeepForSdk
    @Deprecated
    public static boolean n(@NonNull Context context, int i) {
        return vf9.a(context, i);
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static boolean o(@NonNull Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return u(context, "com.google.android.gms");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static boolean p(@NonNull Context context, int i) {
        if (i == 9) {
            return u(context, "com.android.vending");
        }
        return false;
    }

    @KeepForSdk
    @TargetApi(18)
    public static boolean q(@NonNull Context context) {
        if (!is6.g()) {
            return false;
        }
        Object systemService = context.getSystemService(RichTextUtils.USER_SCHEME);
        yw6.l(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @VisibleForTesting
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    public static boolean r(@NonNull Context context) {
        return cm2.f(context);
    }

    @KeepForSdk
    @Deprecated
    public static boolean s(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @KeepForSdk
    @TargetApi(19)
    @Deprecated
    public static boolean t(@NonNull Context context, int i, @NonNull String str) {
        return vf9.b(context, i, str);
    }

    @TargetApi(21)
    public static boolean u(Context context, String str) {
        boolean zEquals = str.equals("com.google.android.gms");
        if (is6.j()) {
            try {
                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (zEquals) {
                return applicationInfo.enabled;
            }
            return applicationInfo.enabled && !q(context);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }
}
