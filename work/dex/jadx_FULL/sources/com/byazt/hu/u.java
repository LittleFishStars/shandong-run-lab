package com.byazt.hu;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.aliyun.vod.common.utils.FileUtils;
import com.byazt.hv.TTDownloadField;
import com.byazt.nr.m;
import com.byazt.su.DownloadModel;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 67})
public class u {
    public static Object[] tt = new Object[0];
    public static Object[] ve = new Object[73];
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String uj = null;

    public static boolean a(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            return packageInfo != null && i <= packageInfo.versionCode;
        } catch (Exception e) {
            m.c(e);
            return false;
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static File da(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        File file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
        StringBuilder sb = new StringBuilder("getExtDir: file.toString()-->");
        sb.append(file.toString());
        com.byazt.x.c.tt("ToolUtils", sb.toString());
        return file;
    }

    public static Signature[] i(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            m.c(th);
            return null;
        }
    }

    public static boolean n(Context context, String str) {
        if (context == null) {
            context = com.byazt.gq.t.getContext();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Intent sp(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static boolean tt(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static Drawable uj(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static String ve(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static Signature[] x(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            m.c(th);
            return null;
        }
    }

    public static long c(JSONObject jSONObject, String str) {
        return com.byazt.ki.tt.c(jSONObject, str);
    }

    public static int tt(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static JSONObject c(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.byazt.ki.tt.c(jSONObject, jSONObject2);
    }

    @WorkerThread
    public static boolean ve(String str) {
        File file;
        Context context = com.byazt.gq.t.getContext();
        if (TextUtils.isEmpty(str) || !n(context, str)) {
            return false;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        if (com.byazt.gq.t.i().optInt("get_ext_dir_mode") == 0 && Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && com.byazt.gq.t.i().optInt("get_ext_dir_mode") == 1) {
                file = da(context, str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/".concat(String.valueOf(str)));
            }
            if (!file.exists()) {
                return false;
            }
            long jC = sp.c(file);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null && packageInfo.lastUpdateTime < jC;
        } catch (Exception e) {
            m.c(e);
            return true;
        }
    }

    @NonNull
    public static JSONObject c(JSONObject jSONObject) {
        return com.byazt.ki.tt.c(jSONObject);
    }

    @NonNull
    public static JSONObject c(JSONObject... jSONObjectArr) {
        return com.byazt.ki.tt.c(jSONObjectArr);
    }

    public static boolean c(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            return (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) ? false : true;
        } catch (Exception unused) {
        }
    }

    public static boolean tt(com.byazt.dd.tt ttVar) {
        if (ttVar == null) {
            return false;
        }
        return c(ttVar.n(), ttVar.qp(), ttVar.nb()).c();
    }

    public static boolean tt(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.byazt.gq.t.getContext();
        }
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    public static String c(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j >= FileUtils.ONE_GB) {
            return (j / FileUtils.ONE_GB) + "G";
        }
        if (j >= 1048576) {
            return (j / 1048576) + "M";
        }
        return decimalFormat.format(j / 1048576.0f) + "M";
    }

    public static long tt(long j) {
        try {
            return c(Environment.getExternalStorageDirectory(), j);
        } catch (Exception e) {
            m.c(e);
            return j;
        }
    }

    public static PackageInfo c(com.byazt.dd.tt ttVar) {
        DownloadInfo downloadInfo;
        if (ttVar == null || (downloadInfo = Downloader.getInstance(com.byazt.gq.t.getContext()).getDownloadInfo(ttVar.my())) == null) {
            return null;
        }
        try {
            return com.byazt.z.ve.c(com.byazt.gq.t.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean tt() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @NonNull
    public static HashMap<String, String> tt(JSONObject jSONObject) {
        HashMap<String, String> map = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.optString(next));
                }
                return map;
            } catch (Exception e) {
                m.c(e);
            }
        }
        return map;
    }

    public static Drawable c(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e) {
                m.c(e);
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static void ve() {
        try {
            if (com.byazt.gq.t.n().c(com.byazt.gq.t.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.byazt.gq.t.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (com.byazt.gq.t.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    public static com.byazt.nn.ve c(String str, int i, String str2) {
        com.byazt.nn.ve veVar = new com.byazt.nn.ve();
        if (TextUtils.isEmpty(str)) {
            return veVar;
        }
        try {
            PackageInfo packageInfo = com.byazt.gq.t.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                veVar.tt(packageInfo.versionCode);
                veVar.c(com.byazt.nn.ve.tt);
                com.byazt.ou.m mVarSp = com.byazt.gq.t.sp();
                if (mVarSp != null && mVarSp.c() && !c(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                    veVar.c(com.byazt.nn.ve.ve);
                }
            }
        } catch (Exception e) {
            com.byazt.x.c.n("ToolUtils", "getInstalledAppInfo:" + e.getMessage());
        }
        return veVar;
    }

    private static boolean c(int i, int i2, String str, String str2) {
        if (i2 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i2 > 0 && i >= i2) || c(str, str2) >= 0;
    }

    public static boolean c(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return c(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).c();
    }

    public static boolean c(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                return false;
            }
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            return packageInfo != null && i == packageInfo.versionCode;
        } catch (Exception e) {
            m.c(e);
            return false;
        }
    }

    public static boolean c(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i = 0; i < signatureArr.length; i++) {
            Signature signature = signatureArr[i];
            if ((signature == null && signatureArr2[i] != null) || (signature != null && !signature.equals(signatureArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static int c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String c(String str, int i) {
        if (i == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static int c(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] strArrSplit = str.split("\\.");
                String[] strArrSplit2 = str2.split("\\.");
                int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
                int i = 0;
                int i2 = 0;
                while (i < iMin) {
                    i2 = Integer.parseInt(strArrSplit[i]) - Integer.parseInt(strArrSplit2[i]);
                    if (i2 != 0) {
                        break;
                    }
                    i++;
                }
                if (i2 != 0) {
                    return i2 > 0 ? 1 : -1;
                }
                for (int i3 = i; i3 < strArrSplit.length; i3++) {
                    if (Integer.parseInt(strArrSplit[i3]) > 0) {
                        return 1;
                    }
                }
                while (i < strArrSplit2.length) {
                    if (Integer.parseInt(strArrSplit2[i]) > 0) {
                        return -1;
                    }
                    i++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String c(String... strArr) {
        return com.byazt.ki.tt.c(strArr);
    }

    @NonNull
    public static <T> T c(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    public static boolean c() {
        try {
            return com.byazt.gq.t.getContext().getPackageManager().getPackageInfo(com.byazt.gq.t.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33;
        } catch (PackageManager.NameNotFoundException e) {
            m.c(e);
            return false;
        }
    }

    public static long c(File file, long j) {
        if (file == null) {
            return j;
        }
        try {
            return com.byazt.w.a.uj(file.getAbsolutePath());
        } catch (Exception e) {
            m.c(e);
            return j;
        }
    }

    public static long c(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            return new StatFs(file.getAbsolutePath()).getTotalBytes();
        } catch (Throwable th) {
            m.c(th);
            return -1L;
        }
    }

    public static void c(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e) {
            m.c(e);
        }
    }
}
