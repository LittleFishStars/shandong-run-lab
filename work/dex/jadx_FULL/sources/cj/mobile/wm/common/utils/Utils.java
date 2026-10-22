package cj.mobile.wm.common.utils;

import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.camera.video.AudioStats;
import cj.mobile.wm.common.bean.AndroidBundle;
import cj.mobile.wm.common.utils.Utils;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.utils.AesUtil;
import com.zj.adlib.c49;
import com.zj.adlib.o61;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Utils {
    public static final int BUFFER_SIZE = 4096;
    public static String packageName;
    public static final String TAG = dexc.dexa("XN`Vujmt");
    public static final String WM_DEFAULT_USER_AGENT = dexc.dexa("pliuuq.pliuuq0xn");
    public static final Charset UTF8 = Charset.forName(dexc.dexa("VUG.9"));
    public static boolean exportSuccess = false;
    public static String userAgent = "";
    public static String appName = "";
    public static String appVersionName = "";

    public static void asyncGetUserAgentByWebSetting(final Context context) {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.rj9
            @Override // java.lang.Runnable
            public final void run() {
                Utils.dexb(context);
            }
        });
    }

    public static String buildRequestId(String str) {
        try {
            return AesUtil.encrypt(UUID.randomUUID().toString() + System.currentTimeMillis() + "", ConstantInfo.getAppToken(), str);
        } catch (Throwable th) {
            DebugLog.release_e(TAG, dexc.dexa(o61.h) + str + dexc.dexa("^!cvjme!sfrvftuJe!gbjm!") + th);
            return "";
        }
    }

    public static boolean checkAppInstalledByPkgName(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 1) != null;
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ void dexa(final Context context) {
        WebView webView;
        try {
            long elapsedRealTime = getElapsedRealTime();
            webView = new WebView(context);
            try {
                final String userAgentString = webView.getSettings().getUserAgentString();
                if (!TextUtils.isEmpty(userAgentString)) {
                    userAgent = userAgentString;
                    DebugLog.common_weak(dexc.dexa("vb!XfcWjfx!") + getCostTime(elapsedRealTime));
                    ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.tj9
                        @Override // java.lang.Runnable
                        public final void run() {
                            Utils.saveUserAgentToLocal(context, userAgentString);
                        }
                    });
                }
            } catch (Throwable th) {
                th = th;
                try {
                    DebugLog.common_w(dexc.dexa("vtfsBhfou!gspn!xfcWjfx!gbjm-") + Log.getStackTraceString(th));
                } finally {
                    if (webView != null) {
                        webView.destroy();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            webView = null;
        }
    }

    public static /* synthetic */ void dexb(Context context) {
        try {
            long elapsedRealTime = getElapsedRealTime();
            String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            if (TextUtils.isEmpty(defaultUserAgent)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = defaultUserAgent.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = defaultUserAgent.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    stringBuffer.append(String.format(dexc.dexa("]v&15y"), Integer.valueOf(cCharAt)));
                } else {
                    stringBuffer.append(cCharAt);
                }
            }
            userAgent = stringBuffer.toString();
            DebugLog.common_weak(dexc.dexa("vb!XfcTfuujoh!") + getCostTime(elapsedRealTime));
            saveUserAgentToLocal(context, stringBuffer.toString());
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("btzodHfuVtfsBhfou!gbjm-") + Log.getStackTraceString(th));
        }
    }

    public static int dip2px(Context context, float f) {
        float deviceDensity = DeviceUtils.getDeviceDensity(context);
        if (deviceDensity <= 0.0f) {
            DebugLog.release_e(TAG, dexc.dexa("ejq3qy!tdbmf!=>!1"));
        } else {
            f = (f * deviceDensity) + 0.5f;
        }
        return (int) f;
    }

    public static int dpToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    /* JADX WARN: Code duplicated, block: B:40:0x012b  */
    /* JADX WARN: Code duplicated, block: B:60:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static synchronized boolean exportDexFile(Context context, String str, String str2) {
        InputStream inputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        if (!exportSuccess) {
            String strDexa = dexc.dexa("mzxn8/29/31");
            if (TextUtils.isEmpty(strDexa)) {
                DebugLog.loadPlugin_e(dexc.dexa("qsfqmh!wfstjpo!jowbmje"));
                ReportUtils.exReport(context, 200006, dexc.dexa("TEL扞樌捗楲鵦"), dexc.dexa("fyqpsuEfyGjmf!gbjm-CvjmeDpogjh/TEL`QMVHJO`WFSTJPO!jt!ovmm"));
            } else if (TextUtils.isEmpty(str)) {
                DebugLog.loadPlugin_e(dexc.dexa("qmh!qbui!jowbmje"));
                ReportUtils.exReport(context, 200006, dexc.dexa("TEL扞樌捗楲鵦"), dexc.dexa("fyqpsuEfyGjmf!gbjm-qmvhjoQbui!jt!ovmm"));
            } else if (TextUtils.isEmpty(str2)) {
                DebugLog.loadPlugin_e(dexc.dexa("qmh!obnf!jowbmje"));
                ReportUtils.exReport(context, 200006, dexc.dexa("TEL扞樌捗楲鵦"), dexc.dexa("fyqpsuEfyGjmf!gbjm-mpdbmEfyObnf!jt!ovmm"));
            } else {
                long elapsedRealTime = getElapsedRealTime();
                FileOutputStream fileOutputStream2 = null;
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(str, str2);
                    setFileWrite(file2, context);
                    InputStream inputStreamOpen = context.getAssets().open(strDexa);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            setFileReadOnly(file2, context);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i = inputStreamOpen.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                                fileOutputStream.flush();
                            }
                            SharedPreferencesHelper.getInstance(context).savePreferencesString(dexc.dexa("nn`tq`l23"), strDexa);
                            exportSuccess = true;
                            DebugLog.loadPlugin(dexc.dexa("qmh!fyq!epof!") + getCostTime(elapsedRealTime));
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            try {
                                String stackTraceString = Log.getStackTraceString(th);
                                DebugLog.loadPlugin_e(dexc.dexa("qmh!fyq!gbjm!") + stackTraceString);
                                ReportUtils.exReport(context, 200006, dexc.dexa("TEL扞樌捗楲鵦"), dexc.dexa("fyqpsuEfyGjmf!gbjm-") + stackTraceString);
                                if (inputStreamOpen != null) {
                                    try {
                                        inputStreamOpen.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream = fileOutputStream2;
                                }
                                return exportSuccess;
                            } catch (Throwable th3) {
                                if (inputStreamOpen != null) {
                                    try {
                                        inputStreamOpen.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (fileOutputStream2 == null) {
                                    throw th3;
                                }
                                try {
                                    fileOutputStream2.close();
                                    throw th3;
                                } catch (IOException unused4) {
                                    throw th3;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        inputStream = inputStreamOpen;
                        th = th4;
                        th = th;
                        inputStreamOpen = inputStream;
                        String stackTraceString2 = Log.getStackTraceString(th);
                        DebugLog.loadPlugin_e(dexc.dexa("qmh!fyq!gbjm!") + stackTraceString2);
                        ReportUtils.exReport(context, 200006, dexc.dexa("TEL扞樌捗楲鵦"), dexc.dexa("fyqpsuEfyGjmf!gbjm-") + stackTraceString2);
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream = fileOutputStream2;
                            fileOutputStream.close();
                        }
                        return exportSuccess;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                }
            }
        }
        return exportSuccess;
    }

    public static long generateRoll64FromMap(Map<String, String> map) {
        long elapsedRealTime = getElapsedRealTime();
        if (map == null || map.isEmpty()) {
            return 0L;
        }
        long jMix = 2538058380L;
        for (Map.Entry entry : new TreeMap(map).entrySet()) {
            jMix = mix(mix(jMix, (String) entry.getKey()), (String) entry.getValue());
        }
        DebugLog.common_w(dexc.dexa("hfofsbufSpmm75!NbqTj{f>") + map.size() + dexc.dexa(c49.f40900a) + getCostTime(elapsedRealTime));
        return jMix;
    }

    public static synchronized PackageInfo getApkPackageInfo(Context context, String str) {
        PackageInfo packageArchiveInfo;
        try {
            packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuBqlQbdlbhfJogp!gbjm-") + th);
            reportErrorInfo(null, dexc.dexa("hfuBqlQbdlbhfJogp!gbjm!"), th);
            packageArchiveInfo = null;
        }
        return packageArchiveInfo;
    }

    public static String getAppName(Context context) {
        if (TextUtils.isEmpty(appName)) {
            DebugLog.common_debug(dexc.dexa("ep!hfuBqqObnf>>>>?"));
            try {
                int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes;
                if (i != 0) {
                    appName = context.getResources().getString(i) + "";
                }
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuBqqObnf!gbjm!") + th);
                reportErrorInfo(context, dexc.dexa("hfuBqqObnf!gbjm!"), th);
            }
        } else {
            DebugLog.common_debug(dexc.dexa("hfuBqqObnf!dbdif!wbmje-bqqObnf"), appName);
        }
        return appName;
    }

    public static String getCostTime(long j) {
        StringBuffer stringBuffer = new StringBuffer(dexc.dexa("du!"));
        stringBuffer.append(getElapsedRealTime() - j);
        return stringBuffer.toString();
    }

    public static long getElapsedRealTime() {
        return SystemClock.elapsedRealtime();
    }

    public static List<String> getFilesAllName(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] fileArrListFiles = new File(str).listFiles();
            if (fileArrListFiles == null) {
                return null;
            }
            for (File file : fileArrListFiles) {
                arrayList.add(file.getAbsolutePath());
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, dexc.dexa("hfuGjmftBmmObnf!gbjm-qbui>") + str + dexc.dexa(c49.f40900a) + th);
            StringBuilder sb = new StringBuilder();
            sb.append(dexc.dexa("hfuGjmftBmmObnf!gbjm-qbui>"));
            sb.append(str);
            sb.append(dexc.dexa(c49.f40900a));
            reportErrorInfo(null, sb.toString(), th);
        }
        return arrayList;
    }

    public static String getPackageName(Context context) {
        if (TextUtils.isEmpty(packageName)) {
            DebugLog.common_debug(dexc.dexa("ep!hfuQbdlbhfObnf>>>>?"));
            packageName = context.getPackageName();
        } else {
            DebugLog.common_debug(dexc.dexa("hfuQbdlbhfObnf!dbdif!wbmje-qbdlbhfObnf"), packageName);
        }
        return packageName;
    }

    public static String getPackageNameFromApk(Context context, String str) {
        try {
            PackageInfo apkPackageInfo = getApkPackageInfo(context, str);
            return apkPackageInfo != null ? apkPackageInfo.applicationInfo.packageName : "";
        } catch (Throwable th) {
            DebugLog.W(TAG, dexc.dexa("hfuQbdlbhfObnfGspnBql!gbjm-bqlQbui>") + str + dexc.dexa(c49.f40900a) + th);
            StringBuilder sb = new StringBuilder();
            sb.append(dexc.dexa("hfuQbdlbhfObnfGspnBql!gbjm-bqlQbui>"));
            sb.append(str);
            sb.append(dexc.dexa(c49.f40900a));
            reportErrorInfo(context, sb.toString(), th);
            return "";
        }
    }

    public static String getProcessName(Context context) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(dexc.dexa("bdujwjuz"))).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == Process.myPid() && (str = runningAppProcessInfo.processName) != null) {
                return str;
            }
        }
        return "";
    }

    public static int getStatusBarHeightOffset(Context context, int i) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(dexc.dexa("tubuvt`cbs`ifjhiu"), dexc.dexa("ejnfo"), dexc.dexa("boespje"));
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier) + dpToPx(context, i);
            }
            Class<?> cls = Class.forName(dexc.dexa("dpn/boespje/joufsobm/S%ejnfo"));
            int dimensionPixelSize = resources.getDimensionPixelSize(Integer.parseInt(cls.getField(dexc.dexa("tubuvt`cbs`ifjhiu")).get(cls.newInstance()).toString()));
            if (dimensionPixelSize > 0) {
                return dimensionPixelSize + dpToPx(context, i);
            }
            return dpToPx(context, 48.0f);
        } catch (Throwable th) {
            DebugLog.W(TAG, dexc.dexa("hfuXjoepxIfjhiu!fssps-") + th);
            reportErrorInfo(context, dexc.dexa("鯿楈諘搤\uab19滧ꈈ꜇楲鵦)hfuXjoepxIfjhiu*"), th);
        }
    }

    public static String getTimeZone() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable th) {
            DebugLog.W(TAG, dexc.dexa("hfuUjnf[pof!gbjm!") + th);
            reportErrorInfo(null, dexc.dexa("hfuUjnf[pof!gbjm!"), th);
            return "";
        }
    }

    public static String getUserAgent(Context context) {
        if (TextUtils.isEmpty(userAgent) || userAgent.equals(WM_DEFAULT_USER_AGENT)) {
            String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(dexc.dexa("nn`tq`l3:"), "");
            if (TextUtils.isEmpty(preferencesString)) {
                String property = System.getProperty(dexc.dexa("iuuq/bhfou"));
                if (TextUtils.isEmpty(property)) {
                    userAgent = WM_DEFAULT_USER_AGENT;
                } else {
                    userAgent = property;
                }
            } else {
                userAgent = preferencesString;
            }
            asyncGetUserAgentByWebSetting(context);
        } else {
            DebugLog.common_debug(dexc.dexa("hfuVtfsBhfou!dbdif!wbmje-vtfsBhfou"), userAgent);
        }
        return userAgent;
    }

    public static String getVersionName(Context context) {
        if (TextUtils.isEmpty(appVersionName)) {
            DebugLog.common_debug(dexc.dexa("ep!hfuWfstjpoObnf>>>>?"));
            long elapsedRealTime = getElapsedRealTime();
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    appVersionName = packageInfo.versionName;
                }
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuWfstjpoObnf!gbjm!") + th);
                reportErrorInfo(context, dexc.dexa("hfuWfstjpoObnf!gbjm!"), th);
            }
            long elapsedRealTime2 = getElapsedRealTime() - elapsedRealTime;
            if (elapsedRealTime2 > 10) {
                DebugLog.common_w(dexc.dexa("hfuWfstjpoObnf!") + elapsedRealTime2 + dexc.dexa("!nt"));
            }
        } else {
            DebugLog.common_debug(dexc.dexa("hfuWfstjpoObnf!dbdif!wbmje-bqqWfstjpoObnf"), appVersionName);
        }
        return appVersionName;
    }

    public static boolean isAppInstalledByPkgName(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Throwable th) {
            DebugLog.W(TAG, dexc.dexa("jtBqqJotubmmfeCzQlhObnf!gbjm-qbdlbhfObnf>") + str + dexc.dexa(c49.f40900a) + th);
            return false;
        }
    }

    public static boolean isForeground1(Context context) {
        boolean z = false;
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(dexc.dexa("bdujwjuz"))).getRunningAppProcesses()) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(context.getApplicationInfo().processName)) {
                    z = true;
                }
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, dexc.dexa("jtGpsfhspvoe)svoojohQspdftt*!fssps;") + th);
            reportErrorInfo(context, dexc.dexa("滕蕩抎摏搱苷灂蜒綌楲鵦)jtGpsfhspvoe2*-"), 900025, dexc.dexa("滕蕩苷灂礁砦楲鵦"), th);
        }
        return z;
    }

    public static boolean isForeground2(Context context) {
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(dexc.dexa("bdujwjuz"))).getRunningTasks(1);
            return !runningTasks.isEmpty() && runningTasks.get(0).topActivity.getPackageName().equals(context.getPackageName());
        } catch (Throwable th) {
            DebugLog.release_e(TAG, dexc.dexa("jtGpsfhspvoe)svoojohUbtlt*!fssps;") + th);
            reportErrorInfo(context, dexc.dexa("滕蕩抎摏搱苷灂蜒綌楲鵦)jtGpsfhspvoe3*-"), 900025, dexc.dexa("滕蕩苷灂礁砦楲鵦"), th);
            return false;
        }
    }

    public static boolean isNextDay(long j, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = calendar.get(5);
        calendar.setTimeInMillis(j);
        if (i == calendar.get(5)) {
            return false;
        }
        DebugLog.common_weak(str + dexc.dexa("!jtOfyuEbz"));
        return true;
    }

    public static boolean isRunningForeground(Context context) {
        ThreadUtils.isUIThread(dexc.dexa("XN`Vujmt.jtSvoojohGpsfhspvoe"));
        return isForeground1(context);
    }

    public static long mix(long j, String str) {
        if (str == null) {
            str = "";
        }
        for (byte b : str.getBytes(UTF8)) {
            long j2 = (j ^ ((long) (b & 255))) * (-7046029254386353131L);
            j = j2 ^ (j2 >>> 32);
        }
        return j;
    }

    public static double parseDouble(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Double.parseDouble(str);
            }
        } catch (Throwable th) {
            DebugLog.release_w(TAG, dexc.dexa("qbstfEpvcmf!fssps!") + str + dexc.dexa(c49.f40900a) + th);
            StringBuilder sb = new StringBuilder();
            sb.append(dexc.dexa("貼柌龭玣楲鵦)qbstfEpvcmf*-wbmvf>"));
            sb.append(str);
            sb.append(dexc.dexa(c49.f40900a));
            reportErrorInfo(null, sb.toString(), 900001, dexc.dexa("疱环楅葇楲鵦"), th);
        }
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static int parseInt(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
        } catch (Throwable th) {
            DebugLog.release_w(TAG, dexc.dexa("qbstfJou!fssps!") + str + dexc.dexa(c49.f40900a) + th);
            StringBuilder sb = new StringBuilder();
            sb.append(dexc.dexa("貼柌龭玣楲鵦)qbstfJou*-wbmvf>"));
            sb.append(str);
            sb.append(dexc.dexa(c49.f40900a));
            reportErrorInfo(null, sb.toString(), 900001, dexc.dexa("疱环楅葇楲鵦"), th);
        }
        return 0;
    }

    public static int px2dip(Context context, float f) {
        float deviceDensity = DeviceUtils.getDeviceDensity(context);
        if (deviceDensity <= 0.0f) {
            DebugLog.release_e(TAG, dexc.dexa("qy3ejq!tdbmf!=>!1"));
        } else {
            f = (f / deviceDensity) + 0.5f;
        }
        return (int) f;
    }

    public static Set<String> queryAllInstalledAppList(Context context) {
        long elapsedRealTime = getElapsedRealTime();
        HashSet hashSet = new HashSet();
        try {
            Iterator<ApplicationInfo> it = context.getPackageManager().getInstalledApplications(0).iterator();
            while (it.hasNext()) {
                String str = it.next().packageName;
                if (!hashSet.contains(str)) {
                    hashSet.add(str);
                }
            }
        } catch (Throwable th) {
            DebugLog.inst_w(dexc.dexa("rvfsz!b!gbjm!") + th);
            reportErrorInfo(null, dexc.dexa("rvfsz!bmm!gbjm!"), th);
        }
        DebugLog.inst_d(dexc.dexa("rvfsz!b!") + getCostTime(elapsedRealTime));
        return hashSet;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    /* JADX WARN: Code duplicated, block: B:29:0x006b A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #0 {all -> 0x0036, blocks: (B:4:0x000b, B:6:0x0011, B:7:0x0015, B:9:0x001b, B:11:0x002b, B:14:0x0032, B:18:0x003a, B:20:0x0040, B:21:0x0048, B:23:0x004e, B:25:0x0060, B:28:0x0067, B:29:0x006b), top: B:34:0x000b }] */
    public static Set<String> queryInstalledAppListByCheckList(Context context, List<AndroidBundle> list, Map<String, String> map) {
        HashSet hashSet = new HashSet();
        long elapsedRealTime = getElapsedRealTime();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    Iterator<AndroidBundle> it = list.iterator();
                    while (it.hasNext()) {
                        String value = it.next().getValue();
                        if (checkAppInstalledByPkgName(context, value) && !hashSet.contains(value)) {
                            hashSet.add(value);
                        }
                    }
                } else if (map != null || map.isEmpty()) {
                    DebugLog.inst_w(dexc.dexa("rvfsz!m!gbjm-difdlmjtu!jowbmje"));
                } else {
                    Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
                    while (it2.hasNext()) {
                        String value2 = it2.next().getValue();
                        if (checkAppInstalledByPkgName(context, value2) && !hashSet.contains(value2)) {
                            hashSet.add(value2);
                        }
                    }
                }
            } catch (Throwable th) {
                DebugLog.inst_w(dexc.dexa("rvfsz!m!gbjm!") + th);
            }
        } else if (map != null) {
            DebugLog.inst_w(dexc.dexa("rvfsz!m!gbjm-difdlmjtu!jowbmje"));
        } else {
            DebugLog.inst_w(dexc.dexa("rvfsz!m!gbjm-difdlmjtu!jowbmje"));
        }
        DebugLog.inst_w(dexc.dexa("rvfsz!m!") + getCostTime(elapsedRealTime));
        return hashSet;
    }

    public static Set<String> queryVisibleInstalledAppList(Context context) {
        HashSet hashSet = new HashSet();
        long elapsedRealTime = getElapsedRealTime();
        try {
            Intent intent = new Intent(dexc.dexa("boespje/joufou/bdujpo/NBJO"), (Uri) null);
            intent.addCategory(dexc.dexa("boespje/joufou/dbufhpsz/MBVODIFS"));
            Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 0).iterator();
            while (it.hasNext()) {
                String str = it.next().activityInfo.packageName;
                if (!hashSet.contains(str)) {
                    hashSet.add(str);
                }
            }
        } catch (Throwable th) {
            DebugLog.inst_w(dexc.dexa("rvfsz!w!gbjm!") + th);
            reportErrorInfo(null, dexc.dexa("rvfsz!wjtjcmf!gbjm!"), th);
        }
        DebugLog.inst_d(dexc.dexa("rvfsz!w!") + getCostTime(elapsedRealTime));
        return hashSet;
    }

    public static void reportErrorInfo(Context context, String str, Throwable th) {
        reportErrorInfo(context, str, 900024, dexc.dexa("鯿楈���炰ꈈ꜇楲鵦"), th);
    }

    public static void saveUserAgentToLocal(Context context, String str) {
        SharedPreferencesHelper.getInstance(context).savePreferencesString(dexc.dexa("nn`tq`l3:"), str);
    }

    public static void setClip(Context context, String str) {
        if (context != null) {
            ((ClipboardManager) context.getSystemService(dexc.dexa("dmjqcpbse"))).setPrimaryClip(ClipData.newPlainText(dexc.dexa("mbcfm"), str));
        }
    }

    public static void setFileReadOnly(File file, Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo() != null && context.getApplicationInfo().targetSdkVersion >= 34 && !file.setReadOnly()) {
                DebugLog.release_w(TAG, dexc.dexa("tfuSfbePomz!gbmtf\"") + file.getName());
            }
        } catch (Throwable th) {
            DebugLog.release_w(TAG, dexc.dexa("tfuSfbePomz!gbjm!????") + th);
        }
    }

    public static void setFileWrite(File file, Context context) {
        try {
            ThreadUtils.isUIThread(dexc.dexa("tfuGjmfXsjuf"));
            if (file != null && Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo() != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                file.setWritable(true);
            }
        } catch (Throwable th) {
            DebugLog.release_w(TAG, dexc.dexa("tfuGjmfXsjuf!gbjm!????") + th);
        }
    }

    public static void reportErrorInfo(Context context, String str, int i, String str2, Throwable th) {
        ReportUtils.exReport(context, i, str2, str + (th != null ? th.toString() : ""));
    }

    public static int dip2px(int i) {
        return (int) ((i * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
