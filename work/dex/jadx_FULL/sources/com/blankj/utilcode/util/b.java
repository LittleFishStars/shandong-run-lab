package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.hv.TTDownloadField;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28217a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Drawable f1422a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1423a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1424a;
        public String b;
        public String c;
        public String d;

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            i(str2);
            h(drawable);
            j(str);
            k(str3);
            n(str4);
            m(i);
            l(z);
        }

        public Drawable a() {
            return this.f1422a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.f1423a;
        }

        public String d() {
            return this.c;
        }

        public int e() {
            return this.f28217a;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.f1424a;
        }

        public void h(Drawable drawable) {
            this.f1422a = drawable;
        }

        public void i(String str) {
            this.b = str;
        }

        public void j(String str) {
            this.f1423a = str;
        }

        public void k(String str) {
            this.c = str;
        }

        public void l(boolean z) {
            this.f1424a = z;
        }

        public void m(int i) {
            this.f28217a = i;
        }

        public void n(String str) {
            this.d = str;
        }

        @NonNull
        public String toString() {
            return "{\n    pkg name: " + c() + "\n    app icon: " + a() + "\n    app name: " + b() + "\n    app path: " + d() + "\n    app v name: " + f() + "\n    app v code: " + e() + "\n    is system: " + g() + "\n}";
        }
    }

    public b() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int A() {
        return B(Utils.a().getPackageName());
    }

    public static int B(String str) {
        if (i.C0(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = Utils.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @NonNull
    public static String C() {
        return D(Utils.a().getPackageName());
    }

    @NonNull
    public static String D(String str) {
        if (i.C0(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = Utils.a().getPackageManager().getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    @NonNull
    public static List<a> E() {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = Utils.a().getPackageManager();
        if (packageManager == null) {
            return arrayList;
        }
        Iterator<PackageInfo> it = packageManager.getInstalledPackages(0).iterator();
        while (it.hasNext()) {
            a aVarF = F(packageManager, it.next());
            if (aVarF != null) {
                arrayList.add(aVarF);
            }
        }
        return arrayList;
    }

    public static a F(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        String str = packageInfo.versionName;
        int i = packageInfo.versionCode;
        String str2 = packageInfo.packageName;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return new a(str2, "", null, "", str, i, false);
        }
        return new a(str2, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, str, i, (applicationInfo.flags & 1) != 0);
    }

    public static void G(Uri uri) {
        Intent intentU = i.U(uri);
        if (intentU == null) {
            return;
        }
        Utils.a().startActivity(intentU);
    }

    public static void H(File file) {
        Intent intentV = i.V(file);
        if (intentV == null) {
            return;
        }
        Utils.a().startActivity(intentV);
    }

    public static void I(String str) {
        H(i.O(str));
    }

    public static boolean J() {
        return K(Utils.a().getPackageName());
    }

    public static boolean K(String str) {
        if (i.C0(str)) {
            return false;
        }
        try {
            return (Utils.a().getPackageManager().getApplicationInfo(str, 0).flags & 2) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean L() {
        return i.q0();
    }

    public static boolean M(@NonNull String str) {
        return !i.C0(str) && str.equals(i.P());
    }

    public static boolean N(String str) {
        if (i.C0(str)) {
            return false;
        }
        try {
            return Utils.a().getPackageManager().getApplicationInfo(str, 0).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean O() {
        return i.A("echo root", true).f28230a == 0;
    }

    public static boolean P(String str) {
        ActivityManager activityManager;
        if (!i.C0(str) && (activityManager = (ActivityManager) Utils.a().getSystemService(TTDownloadField.TT_ACTIVITY)) != null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
            if (runningTasks != null && runningTasks.size() > 0) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo.baseActivity != null && str.equals(runningTaskInfo.baseActivity.getPackageName())) {
                        return true;
                    }
                }
            }
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            if (runningServices != null && runningServices.size() > 0) {
                Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().service.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean Q() {
        return R(Utils.a().getPackageName());
    }

    public static boolean R(String str) {
        if (i.C0(str)) {
            return false;
        }
        try {
            return (Utils.a().getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void S(String str) {
        if (i.C0(str)) {
            return;
        }
        Intent intentX = i.X(str);
        if (intentX == null) {
            Log.e("AppUtils", "Didn't exist launcher activities_run.");
        } else {
            Utils.a().startActivity(intentX);
        }
    }

    public static void T() {
        W(Utils.a().getPackageName());
    }

    public static void U(Activity activity, int i) {
        V(activity, i, Utils.a().getPackageName());
    }

    public static void V(Activity activity, int i, String str) {
        if (activity == null || i.C0(str)) {
            return;
        }
        Intent intentW = i.W(str, false);
        if (i.w0(intentW)) {
            activity.startActivityForResult(intentW, i);
        }
    }

    public static void W(String str) {
        if (i.C0(str)) {
            return;
        }
        Intent intentW = i.W(str, true);
        if (i.w0(intentW)) {
            Utils.a().startActivity(intentW);
        }
    }

    public static void X() {
        Y(false);
    }

    public static void Y(boolean z) {
        Intent intentX = i.X(Utils.a().getPackageName());
        if (intentX == null) {
            Log.e("AppUtils", "Didn't exist launcher activities_run.");
            return;
        }
        intentX.addFlags(335577088);
        Utils.a().startActivity(intentX);
        if (z) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    public static void Z(String str) {
        if (i.C0(str)) {
            return;
        }
        Utils.a().startActivity(i.h0(str));
    }

    public static void a() {
        i.C();
        System.exit(0);
    }

    @Nullable
    public static a b(File file) {
        if (file != null && file.isFile() && file.exists()) {
            return c(file.getAbsolutePath());
        }
        return null;
    }

    @Nullable
    public static a c(String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (i.C0(str) || (packageManager = Utils.a().getPackageManager()) == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        return F(packageManager, packageArchiveInfo);
    }

    @Nullable
    public static Drawable d() {
        return e(Utils.a().getPackageName());
    }

    @Nullable
    public static Drawable e(String str) {
        if (i.C0(str)) {
            return null;
        }
        try {
            PackageManager packageManager = Utils.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int f() {
        return g(Utils.a().getPackageName());
    }

    public static int g(String str) {
        if (i.C0(str)) {
            return 0;
        }
        try {
            PackageInfo packageInfo = Utils.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Nullable
    public static a h() {
        return i(Utils.a().getPackageName());
    }

    @Nullable
    public static a i(String str) {
        try {
            PackageManager packageManager = Utils.a().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return F(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @NonNull
    public static String j() {
        return k(Utils.a().getPackageName());
    }

    @NonNull
    public static String k(String str) {
        if (i.C0(str)) {
            return "";
        }
        try {
            PackageManager packageManager = Utils.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    @NonNull
    public static String l() {
        return Utils.a().getPackageName();
    }

    @NonNull
    public static String m() {
        return n(Utils.a().getPackageName());
    }

    @NonNull
    public static String n(String str) {
        if (i.C0(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = Utils.a().getPackageManager().getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Nullable
    public static Signature[] o() {
        return q(Utils.a().getPackageName());
    }

    @Nullable
    public static Signature[] p(File file) {
        if (file == null) {
            return null;
        }
        PackageManager packageManager = Utils.a().getPackageManager();
        if (Build.VERSION.SDK_INT < 28) {
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 64);
            if (packageArchiveInfo == null) {
                return null;
            }
            return packageArchiveInfo.signatures;
        }
        PackageInfo packageArchiveInfo2 = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 134217728);
        if (packageArchiveInfo2 == null) {
            return null;
        }
        SigningInfo signingInfo = packageArchiveInfo2.signingInfo;
        return signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
    }

    @Nullable
    public static Signature[] q(String str) {
        if (i.C0(str)) {
            return null;
        }
        try {
            PackageManager packageManager = Utils.a().getPackageManager();
            if (Build.VERSION.SDK_INT < 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signatures;
            }
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 134217728);
            if (packageInfo2 == null) {
                return null;
            }
            SigningInfo signingInfo = packageInfo2.signingInfo;
            return signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> r(String str, String str2) {
        Signature[] signatureArrQ;
        ArrayList arrayList = new ArrayList();
        if (!i.C0(str) && (signatureArrQ = q(str)) != null && signatureArrQ.length > 0) {
            for (Signature signature : signatureArrQ) {
                arrayList.add(i.k(i.i0(signature.toByteArray(), str2)).replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0"));
            }
        }
        return arrayList;
    }

    public static void registerAppStatusChangedListener(@NonNull Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        i.addOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    @NonNull
    public static List<String> s() {
        return t(Utils.a().getPackageName());
    }

    @NonNull
    public static List<String> t(String str) {
        return r(str, "MD5");
    }

    @NonNull
    public static List<String> u() {
        return v(Utils.a().getPackageName());
    }

    public static void unregisterAppStatusChangedListener(@NonNull Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        i.removeOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    @NonNull
    public static List<String> v(String str) {
        return r(str, "SHA1");
    }

    @NonNull
    public static List<String> w() {
        return x(Utils.a().getPackageName());
    }

    @NonNull
    public static List<String> x(String str) {
        return r(str, "SHA256");
    }

    public static int y() {
        return z(Utils.a().getPackageName());
    }

    public static int z(String str) {
        try {
            return Utils.a().getPackageManager().getApplicationInfo(str, 0).uid;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
