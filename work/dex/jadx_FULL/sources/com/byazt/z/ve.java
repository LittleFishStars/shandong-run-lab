package com.byazt.z;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.aliyun.vod.common.utils.FileUtils;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.c.yv;
import com.byazt.ev.DownloadStatus;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.s.da;
import com.byazt.s.sl;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zz.Downloader;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 133, 54})
public class ve {
    public static int c;
    public static NotificationChannel tt;

    /* JADX INFO: Access modifiers changed from: private */
    public static int uj(Context context, int i, boolean z) {
        if (com.byazt.k.c.c(i).tt("notification_opt_2") == 1) {
            com.byazt.n.tt.c().a(i);
        }
        c((Activity) sp.c().tt());
        return com.byazt.k.c.c(i).c("install_queue_enable", 0) == 1 ? sp.c().c(context, i, z) : tt(context, i, z);
    }

    private static String c(long j, long j2, String str, boolean z) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d) + " " + str;
        }
        return new DecimalFormat("#").format(d) + " " + str;
    }

    public static int tt(final Context context, final int i, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.byazt.zz.ve.tt(new Runnable() { // from class: com.byazt.z.ve.2
                    @Override // java.lang.Runnable
                    public void run() {
                        uj.sl().t();
                        int iC = ve.c(context, i, z, downloadInfo, file);
                        if (iC == 1 && uj.sl().nu() != null) {
                            uj.sl().nu().c(downloadInfo, null);
                        }
                        ve.tt(downloadInfo, z, iC);
                    }
                });
                return 1;
            }
        }
        tt(downloadInfo, z, 2);
        return 2;
    }

    public static boolean ve(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return tt(context, downloadInfo, c(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static String c(long j) {
        return c(j, true);
    }

    public static boolean ve(String str) {
        return !TextUtils.isEmpty(str) && str.equals(AdBaseConstants.MIME_APK);
    }

    public static String c(long j, boolean z) {
        long[] jArr = {FileUtils.ONE_TB, FileUtils.ONE_GB, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return c(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    public static List<String> ve() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(AdBaseConstants.MIME_APK);
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    private static JSONObject uj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e) {
            m.c(e);
        }
        com.byazt.zz.ve.bm().c(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    public static int c(final Context context, final int i, final boolean z) {
        sl slVarX = uj.sl().x();
        if (slVarX == null) {
            return uj(context, i, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        c = 1;
        slVarX.c(downloadInfo, new da() { // from class: com.byazt.z.ve.1
            @Override // com.byazt.s.da
            public void c() {
                int unused = ve.c = ve.uj(context, i, z);
            }
        });
        return c;
    }

    public static boolean tt(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return c(context, downloadInfo, packageInfo, false);
    }

    public static int tt(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo packageInfoC = c(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (packageInfoC != null) {
                    int i = packageInfoC.versionCode;
                    downloadInfo.setAppVersionCode(i);
                    return i;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0061 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x007a  */
    /* JADX WARN: Code duplicated, block: B:34:0x008e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x008f  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ee A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ef A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:66:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static int c(Context context, int i, boolean z, DownloadInfo downloadInfo, File file) {
        PackageInfo packageInfoC;
        int[] iArr;
        Intent intentC;
        Process processExec;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                processExec = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
                try {
                    processExec.waitFor();
                } catch (Throwable th) {
                    th = th;
                    try {
                        m.c(th);
                        if (processExec != null) {
                        }
                        packageInfoC = c(downloadInfo, file);
                        if (packageInfoC != null) {
                            try {
                                downloadInfo.setFilePackageName(packageInfoC.packageName);
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        th = null;
                        if (uj.sl().uj() != null) {
                            if (packageInfoC == null) {
                                BaseException baseException = new BaseException(2001, th);
                                uj.sl().uj().c(downloadInfo, baseException, baseException.getErrorCode());
                            } else {
                                uj.sl().uj().c(downloadInfo, null, 11);
                            }
                        }
                        if (c(context, downloadInfo, packageInfoC)) {
                            return 2;
                        }
                        if (packageInfoC != null) {
                            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfoC.packageName);
                            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfoC.versionCode));
                        }
                        iArr = new int[1];
                        if (tt(context, downloadInfo, packageInfoC)) {
                            intentC = context.getPackageManager().getLaunchIntentForPackage(packageInfoC.packageName);
                        } else {
                            if (z) {
                            }
                            intentC = c(context, downloadInfo, file, z, iArr);
                        }
                        if (intentC == null) {
                            if (iArr[0] == 1) {
                                return 2;
                            }
                            return 0;
                        }
                        intentC.addFlags(268435456);
                        if (downloadInfo.getLinkMode() > 0) {
                            intentC.putExtra("android.intent.extra.RETURN_RESULT", true);
                        }
                        if (iArr[0] == 0) {
                        }
                        return c(context, intentC);
                    } catch (Throwable th3) {
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                processExec = null;
            }
            processExec.destroy();
        }
        try {
            packageInfoC = c(downloadInfo, file);
            if (packageInfoC != null) {
                downloadInfo.setFilePackageName(packageInfoC.packageName);
            }
            th = null;
        } catch (Throwable th5) {
            th = th5;
            packageInfoC = null;
        }
        if (uj.sl().uj() != null) {
            if (packageInfoC == null) {
                BaseException baseException2 = new BaseException(2001, th);
                uj.sl().uj().c(downloadInfo, baseException2, baseException2.getErrorCode());
            } else {
                uj.sl().uj().c(downloadInfo, null, 11);
            }
        }
        if (c(context, downloadInfo, packageInfoC)) {
            return 2;
        }
        if (packageInfoC != null && com.byazt.k.c.c(downloadInfo.getId()).c("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfoC.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfoC.versionCode));
        }
        iArr = new int[1];
        if (tt(context, downloadInfo, packageInfoC)) {
            intentC = context.getPackageManager().getLaunchIntentForPackage(packageInfoC.packageName);
        } else {
            if (z && c(context, i, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            }
            intentC = c(context, downloadInfo, file, z, iArr);
        }
        if (intentC == null) {
            if (iArr[0] == 1) {
                return 2;
            }
            return 0;
        }
        intentC.addFlags(268435456);
        if (downloadInfo.getLinkMode() > 0 && com.byazt.k.c.c(downloadInfo.getId()).c("app_install_return_result", 0) == 1) {
            intentC.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 || !tt.c(context, downloadInfo, intentC, z)) {
            return c(context, intentC);
        }
        return 1;
    }

    public static String tt() {
        return com.byazt.w.a.n();
    }

    public static boolean tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.optBoolean("bind_app", false) || !jSONObject.optBoolean("auto_install_with_notification", true);
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public static int c(Context context, Intent intent) {
        try {
            if (uj.sl().m() != null && uj.sl().m().c(intent)) {
                return 1;
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean c(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.byazt.s.n nVarVe = uj.sl().ve();
        if (nVarVe != null) {
            nVarVe.c(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (nVarVe.c()) {
                return true;
            }
        }
        yv downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.c(8, downloadInfo, packageInfo.packageName, "");
        com.byazt.s.uj ujVarTt = uj.sl().tt();
        return (ujVarTt instanceof com.byazt.s.c) && ((com.byazt.s.c) ujVarTt).tt();
    }

    public static boolean c(Context context, int i, File file) {
        if (com.byazt.k.c.c(i).c("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.byazt.i.n.u() || com.byazt.i.n.yp()) && com.byazt.w.da.c(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                m.c(e);
            }
        }
        return false;
    }

    public static int c() {
        return uj.sl().sp() ? 16384 : 0;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x0021, B:13:0x0027, B:14:0x002c), top: B:21:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x002c A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x0021, B:13:0x0027, B:14:0x002c), top: B:21:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Uri c(int i, IDownloadFileUriProvider iDownloadFileUriProvider, Context context, String str, File file) {
        Uri uriFromFile;
        try {
            if (iDownloadFileUriProvider != null) {
                uriFromFile = iDownloadFileUriProvider.getUriForFile(str, file.getAbsolutePath());
            } else {
                com.byazt.s.sp spVarA = uj.sl().a();
                if (spVarA != null) {
                    uriFromFile = spVarA.c(i, str, file.getAbsolutePath());
                } else {
                    uriFromFile = null;
                }
                if (uriFromFile == null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            uriFromFile = FileProvider.getUriForFile(context, str, file);
                        } else {
                            uriFromFile = Uri.fromFile(file);
                        }
                    } catch (Throwable th) {
                        m.c(th);
                    }
                }
                return uriFromFile;
            }
        } catch (Throwable unused) {
        }
        if (uriFromFile == null) {
            if (!TextUtils.isEmpty(str)) {
                uriFromFile = FileProvider.getUriForFile(context, str, file);
            } else {
                uriFromFile = Uri.fromFile(file);
            }
        }
        return uriFromFile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6 */
    private static Intent c(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z, int[] iArr) {
        Uri uriC = c(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, uj.sl().n(), file);
        if (uriC == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.setDataAndType(uriC, AdBaseConstants.MIME_APK);
        com.byazt.s.n nVarVe = uj.sl().ve();
        boolean zC = nVarVe != null ? nVarVe.c(downloadInfo.getId(), z) : false;
        yv downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        ?? C = zC;
        if (downloadNotificationEventListener != null) {
            C = downloadNotificationEventListener.c(z);
        }
        iArr[0] = C;
        if (C != 0) {
            return null;
        }
        return intent;
    }

    public static boolean c(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && c(com.byazt.zz.ve.ic(), downloadInfo, str);
        }
        return true;
    }

    public static boolean c(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                m.uj("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo packageInfoC = c(downloadInfo, file);
                if (packageInfoC == null || !packageInfoC.packageName.equals(str)) {
                    return false;
                }
                int i = packageInfoC.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, c());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!com.byazt.k.c.c(downloadInfo.getId()).c("install_callback_error")) {
                    return false;
                }
                String strC = com.byazt.w.a.c(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                int iC = com.byazt.w.a.c(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (strC == null || TextUtils.isEmpty(strC) || !strC.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, c());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || iC != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            m.c(e);
            return false;
        }
    }

    public static boolean c(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, c());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        if (z) {
            return i < i2;
        }
        if (downloadInfo == null || com.byazt.k.c.c(downloadInfo.getId()).c("install_with_same_version_code", 0) != 1) {
            return i <= i2;
        }
        return i < i2;
    }

    public static boolean c(Context context, DownloadInfo downloadInfo) {
        return c(context, downloadInfo, true);
    }

    public static boolean c(Context context, DownloadInfo downloadInfo, boolean z) {
        PackageInfo packageInfo;
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z) {
            return ve(context, downloadInfo);
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, c());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        if (com.byazt.k.c.c(downloadInfo.getId()).c("install_with_same_version_code", 0) == 1) {
            return appVersionCode < packageInfo.versionCode;
        }
        return appVersionCode <= packageInfo.versionCode;
    }

    public static PackageInfo c(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        m.uj("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return c(downloadInfo, file);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    public static String c(String str, String str2, String str3, boolean z) {
        String lastPathSegment = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri uri = Uri.parse(str);
        if (z) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(uri.getLastPathSegment()) || uri.getLastPathSegment().contains("..")) {
                    str2 = "default.apk";
                } else {
                    str2 = uri.getLastPathSegment();
                }
            }
        } else {
            if (!TextUtils.isEmpty(uri.getLastPathSegment()) && !uri.getLastPathSegment().contains("..")) {
                lastPathSegment = uri.getLastPathSegment();
            }
            if (!TextUtils.isEmpty(lastPathSegment)) {
                str2 = lastPathSegment;
            } else if (TextUtils.isEmpty(str2)) {
                str2 = "default.apk";
            }
        }
        if (!ve(str3) || str2.endsWith(".apk")) {
            return str2;
        }
        return str2 + ".apk";
    }

    public static String c(String str, com.byazt.k.c cVar) {
        JSONObject jSONObjectUj;
        String str2;
        if (cVar == null || (jSONObjectUj = cVar.uj("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectUj.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith(WVNativeCallbackUtil.SEPERATER)) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).optBoolean("bind_app", false);
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public static int c(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i) || i == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i) ? 3 : 0;
    }

    @TargetApi(26)
    public static String c(@NonNull Context context) {
        try {
            if (tt == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                tt = notificationChannel;
                notificationChannel.setSound(null, null);
                tt.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(tt);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return "111111";
    }

    public static void c(DownloadInfo downloadInfo, boolean z, boolean z2) {
        uj.sl().c(new n(com.byazt.zz.ve.ic(), downloadInfo.getUrl()).c(downloadInfo.getTitle()).tt(downloadInfo.getName()).ve(downloadInfo.getSavePath()).c(downloadInfo.isShowNotification()).tt(downloadInfo.isAutoInstallWithoutNotification()).ve(downloadInfo.isOnlyWifi() || z2).n(downloadInfo.getExtra()).a(downloadInfo.getMimeType()).c(downloadInfo.getExtraHeaders()).n(true).tt(downloadInfo.getRetryCount()).ve(downloadInfo.getBackUpUrlRetryCount()).tt(downloadInfo.getBackUpUrls()).uj(downloadInfo.getMinProgressTimeMsInterval()).n(downloadInfo.getMaxProgressCount()).a(z).uj(downloadInfo.isNeedHttpsToHttpRetry()).sp(downloadInfo.getPackageName()).x(downloadInfo.getMd5()).c(downloadInfo.getExpectFileLength()).i(downloadInfo.isNeedDefaultHttpServiceBackUp()).da(downloadInfo.isNeedReuseFirstConnection()).t(downloadInfo.isNeedIndependentProcess()).c(downloadInfo.getEnqueueType()).yp(downloadInfo.isForce()).u(downloadInfo.isHeadConnectionAvailable()).sp(downloadInfo.isNeedRetryDelay()).i(downloadInfo.getRetryDelayTimeArray()).c(uj(downloadInfo.getDownloadSettingString())).sl(downloadInfo.getIconUrl()).a(downloadInfo.getExecutorGroup()).m(downloadInfo.isAutoInstall()));
    }

    public static void c(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    public static PackageInfo c(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.byazt.o.n.c(com.byazt.zz.ve.ic(), file, c());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo packageInfoC = com.byazt.o.n.c(com.byazt.zz.ve.ic(), file, c());
        downloadInfo.setPackageInfo(packageInfoC);
        return packageInfoC;
    }

    public static int c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
