package com.baidu.xclient.gdid.i;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.xclient.gdid.j.d;
import com.byazt.hv.TTDownloadField;
import com.heytap.mcssdk.constant.MessageConstant;
import com.huawei.hms.utils.FileUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f26834a;
    public static long b;
    public static long c;
    public static long d;

    public static int a(long j) {
        try {
            if (g()) {
                String upperCase = Build.BOARD.trim().toUpperCase();
                if (upperCase.startsWith("SQW100-")) {
                    return 3072;
                }
                if (!upperCase.startsWith("SQC100-") && !upperCase.startsWith("SQK100-") && !upperCase.startsWith("SQN100-") && !upperCase.startsWith("SQR100-") && !upperCase.startsWith("STA100-") && !upperCase.startsWith("STK100-") && !upperCase.startsWith("STL100-") && !upperCase.startsWith("STR100-")) {
                    if (upperCase.startsWith("STJ100-")) {
                        return 1536;
                    }
                }
                return 2048;
            }
            float f = j / 1024.0f;
            if (f > 10.0f) {
                return MessageConstant.CommandId.COMMAND_BASE;
            }
            if (f > 8.0f) {
                return 10240;
            }
            if (f > 7.0f) {
                return 8192;
            }
            if (f > 5.0f) {
                return 6144;
            }
            if (f > 4.0f) {
                return 5120;
            }
            if (f > 3.0f) {
                return 4096;
            }
            if (f > 2.0f) {
                return 3072;
            }
            if (f > 1.0f) {
                return 2048;
            }
            if (f > 0.75f) {
                return 1024;
            }
            if (f > 0.5f) {
                return 768;
            }
            return f > 0.25f ? 512 : 0;
        } catch (Throwable th) {
            d.a(th);
            return 0;
        }
    }

    public static long a() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return -1L;
            }
            if (c == 0) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                c = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            }
            return c;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    public static long a(String str) {
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException e) {
            d.a(e);
            return Long.MIN_VALUE;
        }
    }

    public static String a(Context context) {
        try {
            int iA = a(g(context));
            if (iA <= 0) {
                return null;
            }
            if (iA % 1024 == 0) {
                return String.format("%d %s", Integer.valueOf(iA / 1024), "GB");
            }
            return (iA < 1024 || iA % 512 != 0) ? a(Long.valueOf(iA)) : String.format("%.1f %s", Float.valueOf(iA / 1024.0f), "GB");
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static String a(Long l) {
        try {
            return l.longValue() >= FileUtil.LOCAL_REPORT_FILE_MAX_SIZE ? String.format("%.2f %s", Float.valueOf(l.longValue() / 1024.0f), "GB") : String.format("%d %s", l, "MB");
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static long b() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return -1L;
            }
            if (d == 0) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                d = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            return d;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    public static String b(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            int i = (int) (memoryInfo.availMem / 1048576);
            if (i % 1024 == 0) {
                return String.format("%d %s", Integer.valueOf(i / 1024), "GB");
            }
            return (i < 1024 || i % 512 != 0) ? a(Long.valueOf(i)) : String.format("%.1f %s", Float.valueOf(i / 1024.0f), "GB");
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static long c() {
        try {
            if (f26834a == 0) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                f26834a = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            }
            return f26834a;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    public static String c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int i = point.x;
        return point.y + "X" + i;
    }

    public static int d(Context context) {
        try {
            return context.getResources().getConfiguration().orientation == 2 ? 0 : 1;
        } catch (Throwable th) {
            d.a(th);
            return 1;
        }
    }

    public static long d() {
        try {
            if (b == 0) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                b = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            }
            return b;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    public static int e(Context context) {
        try {
            BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
            if (batteryManager == null) {
                return 0;
            }
            return batteryManager.getIntProperty(4);
        } catch (Throwable th) {
            d.a(th);
            return 0;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static long e() {
        BufferedReader bufferedReader;
        String line;
        File fileA = com.baidu.mshield.b.e.a.a(com.baidu.xclient.gdid.d.b, "/proc/meminfo");
        long j = 0;
        if (fileA != null && fileA.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(fileA));
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            d.a(th);
                            return j;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th2) {
                                    d.a(th2);
                                }
                            }
                        }
                    }
                } while (!line.startsWith("MemTotal:"));
                String upperCase = line.substring(9).trim().toUpperCase();
                int iIndexOf = upperCase.indexOf(" KB");
                if (iIndexOf > 0) {
                    long jA = a(upperCase.substring(0, iIndexOf));
                    if (jA > 0) {
                        j = jA / 1024;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        }
        return j;
    }

    public static String f() {
        try {
            return Build.MANUFACTURER.trim();
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static boolean f(Context context) {
        try {
            int intExtra = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static long g(Context context) {
        try {
            long jH = h(context);
            return jH <= 0 ? e() : jH;
        } catch (Throwable th) {
            d.a(th);
            return 0L;
        }
    }

    public static boolean g() {
        try {
            return f().toUpperCase().equals("BLACKBERRY") || f().equals("RIM");
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static long h(Context context) {
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                if (activityManager == null) {
                    return 0L;
                }
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.totalMem / 1048576;
            } catch (Throwable th) {
                d.a(th);
            }
        }
        return 0L;
    }
}
