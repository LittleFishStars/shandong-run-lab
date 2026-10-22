package com.efs.sdk.memoryinfo;

import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class f {
    public static long a(Debug.MemoryInfo memoryInfo) {
        String memoryStat = memoryInfo.getMemoryStat("summary.graphics");
        try {
            if (TextUtils.isEmpty(memoryStat)) {
                return 0L;
            }
            return Long.parseLong(memoryStat);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static long a() {
        BufferedReader bufferedReader;
        long j;
        long j2 = -1;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/status")));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append('\n');
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return j2;
                }
                String[] strArrSplit = sb.toString().trim().split("\n");
                int length = strArrSplit.length;
                int length2 = strArrSplit.length;
                int i = 0;
                while (true) {
                    if (i >= length2) {
                        j = -1;
                        break;
                    }
                    String str = strArrSplit[i];
                    if (str.startsWith("VmSize")) {
                        Matcher matcher = Pattern.compile("\\d+").matcher(str);
                        if (matcher.find()) {
                            j = Long.parseLong(matcher.group());
                            break;
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return j2;
                    }
                    i++;
                }
                if (j == -1 && length > 12) {
                    try {
                        Matcher matcher2 = Pattern.compile("\\d+").matcher(strArrSplit[12]);
                        if (matcher2.find()) {
                            j = Long.parseLong(matcher2.group());
                        }
                    } catch (Throwable unused2) {
                        j2 = j;
                    }
                }
                try {
                    bufferedReader.close();
                    return j;
                } catch (Throwable unused3) {
                    return j;
                }
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
    }

    public static void a(String str, Throwable th) {
        if (a.DEBUG) {
            Log.e("MemoryCollect", str, th);
        }
    }
}
