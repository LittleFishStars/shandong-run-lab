package com.byazt.i;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.acse.ottn.p3;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.nr.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 42, 34})
public class a {
    public static Boolean c;

    private static boolean a() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.endsWith(".so") || line.endsWith(".jar")) {
                    hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(c("636f6d2e73617572696b2e737562737472617465")) || str.contains(c("58706f7365644272696467652e6a6172")) || str.contains(c("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c() {
        Boolean bool = c;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    private static boolean n() {
        String[] strArr = {c("2f7362696e2f7375"), c("2f73797374656d2f62696e2f7375"), c("2f73797374656d2f7862696e2f7375"), c("2f646174612f6c6f63616c2f7862696e2f7375"), c("2f646174612f6c6f63616c2f62696e2f7375"), c("2f73797374656d2f73642f7862696e2f7375"), c("2f73797374656d2f62696e2f6661696c736166652f7375"), c("2f646174612f6c6f63616c2f7375")};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean tt() {
        if (uj() == 0) {
            return true;
        }
        return n();
    }

    private static int uj() {
        String str = null;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod(p3.f, String.class).invoke(null, c("726f2e736563757265"));
            if (objInvoke != null) {
                str = (String) objInvoke;
            }
        } catch (Exception unused) {
        }
        return (str == null || !"0".equals(str)) ? 1 : 0;
    }

    public static boolean ve(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return intentRegisterReceiver != null && intentRegisterReceiver.getIntExtra("plugged", -1) == 2;
    }

    @WorkerThread
    public static synchronized void c(@NonNull Context context) {
        if (c == null) {
            c = Boolean.valueOf((tt() || tt(context) || ve(context) || !uj(context) || ve() || n(context)) ? false : true);
        }
    }

    public static boolean tt(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
        }
    }

    @WorkerThread
    public static boolean ve() {
        try {
            InetAddress.getByName(c("3132372e302e302e31"));
            new Socket(c("3132372e302e302e31"), Integer.parseInt(c("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean uj(Context context) {
        try {
            int simState = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimState();
            return (simState == 1 || simState == 0) ? false : true;
        } catch (Throwable unused) {
        }
    }

    private static String c(@NonNull String str) {
        return com.byazt.w.a.c(str);
    }

    @WorkerThread
    public static boolean n(Context context) {
        return a() || a(context);
    }

    private static boolean a(Context context) {
        List listAsList = Arrays.asList(c("64652e726f62762e616e64726f69642e78706f736564"), c("636f6d2e746f706a6f686e77752e6d616769736b"), c("696f2e76612e6578706f736564"), c("636f6d2e77696e642e636f74746572"), c("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), c("6d652e7765697368752e657870"), c("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            try {
                if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e) {
                m.c(e);
            }
        }
        return false;
    }
}
