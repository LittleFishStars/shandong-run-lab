package com.efs.sdk.memleaksdk.monitor.shark;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Debug;
import android.os.StatFs;
import com.alibaba.ariver.permission.b;
import com.byazt.hv.TTDownloadField;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class df {
    public static String a() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) UMGlobalContext.getAppContext().getSystemService(TTDownloadField.TT_ACTIVITY);
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / 1024);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / 1024);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                }
            } catch (Throwable unused) {
            }
            sb.append("\n");
            return sb.toString();
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String b() {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 1024);
            int i = 0;
            do {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line.trim());
                    sb.append("\n");
                    i++;
                } catch (Throwable unused) {
                }
            } while (i < 500);
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        a(bufferedReader);
        sb.append("\n");
        return sb.toString();
    }

    private static long c(StatFs statFs) {
        return statFs.getAvailableBlocksLong();
    }

    private static long d(StatFs statFs) {
        return statFs.getFreeBlocksLong();
    }

    public static String b(Context context) {
        try {
            StatFs statFs = new StatFs(context.getFilesDir().getParent());
            long jB = b(statFs);
            return "total:      " + ((a(statFs) * jB) / 1024) + " kB\navailable:  " + ((c(statFs) * jB) / 1024) + " kB\nfree:       " + ((d(statFs) * jB) / 1024) + " kB\nblock size: " + jB + " B\n";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static long b(StatFs statFs) {
        return statFs.getBlockSizeLong();
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(Context context) {
        int i;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                return "";
            }
            int intExtra = intentRegisterReceiver.getIntExtra(b.b, -1);
            int intExtra2 = intentRegisterReceiver.getIntExtra("voltage", -1);
            int intExtra3 = intentRegisterReceiver.getIntExtra("temperature", -1);
            int intExtra4 = intentRegisterReceiver.getIntExtra("status", -1);
            int i2 = 0;
            if (intExtra4 == 1) {
                i = -1;
            } else if (intExtra4 == 2) {
                i = 1;
            } else {
                i = intExtra4 == 5 ? 2 : 0;
            }
            int intExtra5 = intentRegisterReceiver.getIntExtra("plugged", -1);
            if (intExtra5 == 1) {
                i2 = 1;
            } else if (intExtra5 == 2) {
                i2 = 2;
            }
            return "level: " + intExtra + "\nscale: " + intentRegisterReceiver.getIntExtra("scale", -1) + "\nhealth: " + intentRegisterReceiver.getIntExtra("health", -1) + "\npluged: " + i2 + "\nstatus: " + i + "\nvoltage: " + intExtra2 + "\ntemperature: " + intExtra3 + "\ntechnology: " + intentRegisterReceiver.getStringExtra("technology") + "\n";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static long a(StatFs statFs) {
        return statFs.getBlockCountLong();
    }
}
