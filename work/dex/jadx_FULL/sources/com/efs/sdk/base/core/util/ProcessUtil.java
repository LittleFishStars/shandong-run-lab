package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ProcessUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f29610a = null;
    private static List<Integer> b = null;
    private static long c = -1;

    public static String getCurrentProcessName() {
        String str = f29610a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String processName = getProcessName(Process.myPid());
        f29610a = processName;
        return processName;
    }

    public static String getProcessName(int i) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i + "/cmdline")));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i2 = bufferedReader2.read();
                    if (i2 <= 0) {
                        sb.trimToSize();
                        String string = sb.toString();
                        try {
                            bufferedReader2.close();
                            return string;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return string;
                        }
                    }
                    sb.append((char) i2);
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                try {
                    Log.e("efs.base", "get process name error", th);
                    return "";
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static boolean isProcessExist(Context context, String str) {
        try {
            int i = Integer.parseInt(str);
            List<Integer> list = b;
            boolean z = false;
            if (list != null && !list.isEmpty() && c > 0 && System.currentTimeMillis() - c <= 600000) {
                z = true;
            }
            if (!z) {
                List<Integer> list2 = b;
                if (list2 != null) {
                    list2.clear();
                } else {
                    b = new ArrayList();
                }
                if (!TextUtils.isEmpty(getProcessName(Process.myPid()))) {
                    b.add(Integer.valueOf(Process.myPid()));
                }
                if (!TextUtils.isEmpty(getProcessName(i))) {
                    b.add(Integer.valueOf(i));
                }
                c = System.currentTimeMillis();
            }
            return b.contains(Integer.valueOf(i));
        } catch (Throwable th) {
            Log.e("efs.base", "Process exist judge error", th);
            return true;
        }
    }

    public static int myPid() {
        return Process.myPid();
    }
}
