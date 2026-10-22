package com.hailiang.advlib.common;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f32565a = "https://tracelog-debug.qquanquan.com";
    public static String c = "";
    private static long e = 0;
    private static long f = 0;
    private static int g = -1;
    private static boolean h;
    private static Handler j;
    private static final StringBuilder d = new StringBuilder();
    public static String b = "";
    private static final HandlerThread i = new HandlerThread("cpc/sdk-remote-" + b);

    @Keep
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f32566a;

        public a(String str) {
            this.f32566a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.a(this.f32566a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static Handler a() {
        if (j == null) {
            synchronized (e.class) {
                try {
                    if (j == null) {
                        HandlerThread handlerThread = i;
                        handlerThread.start();
                        j = new Handler(handlerThread.getLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    public static String a(Context context) {
        if (context != null && !h) {
            String strA = c.a(context, f32565a, "trace_log");
            f32565a = strA;
            h = true;
            return strA;
        }
        return f32565a;
    }

    private static String a(String str, Map<String, String> map) {
        return str + f.a(map);
    }

    private static Map a(Context context, String str, Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put("os", "Android");
        map2.put("timestamp", String.valueOf(System.currentTimeMillis()));
        map2.put("opt_bootstrap_v", b);
        map2.put("opt_lib_v", c);
        map2.put("t", str + "");
        if (context != null) {
            map2.put("opt_app_pkgid", context.getPackageName());
            map2.put("opt_app_vn", f.b(context));
            map2.put("opt_app_vc", f.a(context) + "");
        }
        map2.put("opt_os_version", Build.VERSION.RELEASE + "");
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                map2.put(key, map.get(key));
            }
        }
        try {
            String str2 = Build.BRAND;
            if (str2 != null) {
                map2.put("opt_brand", str2);
            }
            String str3 = Build.MODEL;
            if (str3 != null) {
                map2.put("opt_model", str3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return map2;
    }

    public static void a(Context context, int i2) {
        if (context == null || !b()) {
            return;
        }
        HashMap map = new HashMap();
        map.put("op1", "Loading");
        map.put("opt_loadId", f + "");
        map.put("opt_step", i2 + "");
        StringBuilder sb = d;
        sb.append(i2 + c49.f40900a);
        map.put("opt_path", sb.toString());
        long jCurrentTimeMillis = e != 0 ? System.currentTimeMillis() - e : 0L;
        e = System.currentTimeMillis();
        map.put("opt_loadTime", jCurrentTimeMillis + "");
        b(context, "LoadSdk", map);
        Log.i("reportLoadsdkLoading", "step = " + i2 + " , time = " + jCurrentTimeMillis);
    }

    public static void a(Context context, String str, String str2, long j2) {
        try {
            if (b()) {
                HashMap map = new HashMap();
                map.put("op1", str);
                map.put("opt_download", "sdk");
                map.put("opt_url", str2 + "");
                if (j2 > 0) {
                    map.put("opt_block_time", j2 + "");
                }
                b(context, "Download", map);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, String str2, String str3, long j2) {
        try {
            HashMap map = new HashMap();
            map.put("op1", str);
            map.put("op2", str2);
            map.put("opt_download", "sdk");
            map.put("opt_url", str3 + "");
            if (j2 > 0) {
                map.put("opt_block_time", j2 + "");
            }
            b(context, "DownloadError", map);
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, String str, String str2, Map<String, String> map) {
        a aVar = new a(a(str, (Map<String, String>) a(context, str2, map)));
        Handler handlerA = a();
        if (handlerA != null) {
            handlerA.post(aVar);
        }
    }

    public static void a(Context context, String str, String str2, Map map, boolean z, boolean z2) {
        if (context != null) {
            HashMap map2 = new HashMap();
            map2.put("op1", str);
            map2.put("op2", str2);
            map2.put("opt_unzip", (z ? 1 : 0) + "");
            map2.put("opt_checkonline", (z2 ? 1 : 0) + "");
            map2.put(CrashHianalyticsData.THREAD_NAME, Thread.currentThread().getName());
            if (map != null && map.size() > 0) {
                map2.putAll(map);
            }
            b(context, "SDKError", map2);
        }
    }

    public static void a(Runnable runnable) {
        Handler handlerA = a();
        if (handlerA != null) {
            handlerA.post(runnable);
        }
    }

    public static void a(Runnable runnable, long j2) {
        Handler handlerA = a();
        if (handlerA != null) {
            handlerA.postDelayed(runnable, j2);
        }
    }

    public static void a(String str) throws Throwable {
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            try {
                uRLConnectionOpenConnection.connect();
                int responseCode = ((HttpURLConnection) uRLConnectionOpenConnection).getResponseCode();
                if (responseCode != 200) {
                    Log.e("NetUtils", "ERROR " + String.valueOf(responseCode) + " on url \"" + str + "\"");
                }
            } finally {
                try {
                    ((HttpURLConnection) uRLConnectionOpenConnection).disconnect();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b(Context context, String str, Map<String, String> map) {
        a(context, a(context), str, map);
    }

    public static boolean b() {
        if (g == -1) {
            g = new Random().nextInt(10);
        }
        return g == 1;
    }

    public static void c() {
        f = System.currentTimeMillis();
    }

    public static void c(Context context, String str, Map<String, String> map) {
        if (context != null) {
            HashMap map2 = new HashMap();
            map2.put("op1", "LOAD_ERROR");
            map2.put("opt_error", str);
            try {
                map2.put("opt_process", f.c(context));
            } catch (Throwable unused) {
            }
            if (map != null && map.size() > 0) {
                map2.putAll(map);
            }
            b(context, "LoadSdk", map2);
        }
    }
}
