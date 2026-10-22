package cj.mobile.wm;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.byazt.tk.AdBaseConstants;
import com.wangmai.insightvision.openadsdk.FanTiApkProvider;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class he {
    public static Uri dexa(Context context, Intent intent, File file) {
        if (context.getApplicationInfo().targetSdkVersion < 24) {
            return Uri.fromFile(file);
        }
        Uri uriForFile = FanTiApkProvider.getUriForFile(context, context.getPackageName() + ".FanTiApkProvider", file);
        intent.addFlags(3);
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, uriForFile, 1);
        }
        return uriForFile;
    }

    public static String dexa(Application application, String str) {
        PackageInfo packageInfoDexc = dexc(application, str);
        if (packageInfoDexc != null) {
            return packageInfoDexc.packageName;
        }
        return null;
    }

    public static String dexa(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            f1.dexa("PackageUtils", "getVersionName: exception" + e.getMessage());
            return "";
        }
    }

    public static boolean dexa(Context context, String str) {
        return dexc(context, str) != null;
    }

    public static Intent dexb(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(dexa(context, intent, new File(str)), AdBaseConstants.MIME_APK);
        intent.addFlags(1);
        intent.addFlags(268435456);
        return intent;
    }

    @SuppressLint({"WrongConstant"})
    public static PackageInfo dexc(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"WrongConstant"})
    public static PackageInfo dexd(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dexe(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            return (String) applicationInfo.loadLabel(packageManager);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void dexf(Context context, String str) {
        try {
            context.startActivity(dexb(context, str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dexg(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return;
            }
            launchIntentForPackage.setFlags(872415232);
            context.startActivity(launchIntentForPackage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
