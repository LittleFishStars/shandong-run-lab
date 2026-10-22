package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.byazt.tk.AdBaseConstants;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class au {

    public interface a {
        void d(Throwable th);

        void qD();
    }

    public static boolean a(@Nullable String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            at.VN().VP();
            Context context = ServiceProvider.getContext();
            File file = new File(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.addFlags(3);
            Uri uriForFile = getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
            intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
            Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                context.grantUriPermission(it.next().activityInfo.packageName, uriForFile, 3);
            }
            context.startActivity(intent);
            com.kwad.sdk.core.c.b.LW();
            at.VN().s(com.kwad.sdk.core.c.b.getCurrentActivity());
            if (aVar == null) {
                return true;
            }
            aVar.qD();
            return true;
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.d(th);
            }
            return false;
        }
    }

    public static void aA(String str, String str2) {
        com.kwad.sdk.core.d.c.w("PackageUtil", "saveDownloadFile " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot save package, has no download apk info.");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot save package, download apk is not exists.");
            return;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        ai.f(context, str2, file.length());
        try {
            ai.g(context, str2, com.kwad.sdk.utils.a.getFileMD5(file));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public static int aB(String str, String str2) {
        ApplicationInfo applicationInfo;
        com.kwad.sdk.core.d.c.w("PackageUtil", "isPackageChanged " + str + " packageName " + str2);
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 0;
        }
        long jAc = ai.ac(context, str);
        String strAd = ai.ad(context, str);
        if (TextUtils.isEmpty(strAd) || jAc <= 0) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, has no download apk info.");
            return 0;
        }
        PackageInfo packageInfoNoCache = aa.getPackageInfoNoCache(context, str2, 0);
        if (packageInfoNoCache == null) {
            return 0;
        }
        if (TextUtils.isEmpty(str2) || (applicationInfo = packageInfoNoCache.applicationInfo) == null || TextUtils.isEmpty(applicationInfo.publicSourceDir)) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, cannot get installed apk info.");
            return 0;
        }
        File file = new File(packageInfoNoCache.applicationInfo.publicSourceDir);
        if (!file.exists()) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, insgtalled apk is not exists.");
            return 0;
        }
        if (jAc != file.length()) {
            return 1;
        }
        if (TextUtils.isEmpty(strAd)) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, cannot calculate md5 of download file.");
            return 0;
        }
        String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
        if (!TextUtils.isEmpty(fileMD5)) {
            return strAd.equalsIgnoreCase(fileMD5) ? 2 : 1;
        }
        com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, cannot calculate md5 of installed file.");
        return 0;
    }

    public static boolean aw(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = aa.getPackageInfo(context, str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || !applicationInfo.enabled) ? false : true;
        } catch (Exception unused) {
        }
    }

    public static boolean ax(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfoNoCache = aa.getPackageInfoNoCache(context, str, 0);
            return (packageInfoNoCache == null || (applicationInfo = packageInfoNoCache.applicationInfo) == null || !applicationInfo.enabled) ? false : true;
        } catch (Exception unused) {
        }
    }

    public static int ay(@Nullable Context context, String str) {
        if (context == null || str == null || d.cM(context)) {
            return -1;
        }
        try {
            if ((context.getApplicationInfo().targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33) || ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                return -1;
            }
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str);
            return (file.exists() && file.isDirectory()) ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static boolean az(@Nullable Context context, @Nullable String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            com.kwad.sdk.core.d.c.d("PackageUtil", "openApp context: " + context);
            launchIntentForPackage.setFlags(337641472);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean dG(Context context) {
        return ax(context, "com.smile.gifmaker");
    }

    public static boolean dH(Context context) {
        return ax(context, "com.kuaishou.nebula");
    }

    public static int dI(Context context) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfoNoCache = aa.getPackageInfoNoCache(context, "com.smile.gifmaker", 0);
            if ((packageInfoNoCache == null || (applicationInfo = packageInfoNoCache.applicationInfo) == null || !applicationInfo.enabled) ? false : true) {
                return bz.aE(packageInfoNoCache.versionName, "13.10.10") ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static int dJ(Context context) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfoNoCache = aa.getPackageInfoNoCache(context, "com.kuaishou.nebula", 0);
            if ((packageInfoNoCache == null || (applicationInfo = packageInfoNoCache.applicationInfo) == null || !applicationInfo.enabled) ? false : true) {
                return bz.aE(packageInfoNoCache.versionName, "13.10.10") ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private static Uri getUriForFile(@NonNull Context context, @NonNull String str, @NonNull File file) throws Throwable {
        FileOutputStream fileOutputStream;
        try {
            return FileProvider.getUriForFile(context, str, file);
        } catch (IllegalArgumentException unused) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "ANR Risk -- Copying the file the location cache to avoid Huawei 'external-files-path' bug for N+ devices");
            File file2 = new File(context.getCacheDir(), "ksadsdk");
            y.W(file2);
            file2.mkdirs();
            File file3 = new File(file2, file.getName());
            try {
                file3.createNewFile();
            } catch (Exception unused2) {
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file3);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = fileInputStream2.read(bArr);
                            if (i == -1) {
                                com.kwad.sdk.core.d.c.i("PackageUtil", "Completed Android N+ Huawei file copy. Attempting to return the cached file");
                                Uri uriForFile = FileProvider.getUriForFile(context, str, file3);
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                return uriForFile;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                    } catch (IOException e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            com.kwad.sdk.core.d.c.e("PackageUtil", "Failed to copy the Huawei file. Re-throwing exception", e);
                            throw new IllegalArgumentException("Huawei devices are unsupported for Android N", e);
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        }
    }

    public static boolean hV(@Nullable String str) {
        return a(str, null);
    }

    public static String hW(String str) {
        PackageInfo packageArchiveInfo;
        if (!new File(str).exists()) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot save package, download apk is not exists.");
            return null;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.applicationInfo.packageName;
    }
}
