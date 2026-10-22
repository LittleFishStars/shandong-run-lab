package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.hv.TTDownloadField;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class SystemUtil {
    private static long bqH;
    private static long bqI;
    private static int bqJ;
    private static LEVEL bqK;

    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);

        int value;

        LEVEL(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static class a {
        public long bqL;
        public long bqM;
        public long bqN;
        public long bqO;
        public long bqP;
        public int mThreadsCount;
    }

    public static long WE() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!line.contains("MemTotal"));
            long jLongValue = Long.valueOf(line.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return jLongValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static a WF() throws Throwable {
        String strAD;
        a aVar = new a();
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile("/proc/self/status", "r");
            while (true) {
                try {
                    String line = randomAccessFile2.readLine();
                    if (line == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(line)) {
                        if (line.startsWith("VmSize") && line.contains("kB")) {
                            String strAD2 = aD(line, "VmSize");
                            if (strAD2 != null) {
                                aVar.bqM = Long.valueOf(strAD2).longValue();
                            }
                        } else if (line.startsWith("VmRSS:") && line.contains("kB")) {
                            String strAD3 = aD(line, "VmRSS:");
                            if (strAD3 != null) {
                                aVar.bqN = Long.valueOf(strAD3).longValue();
                            }
                        } else if (line.startsWith("Threads:") && (strAD = aD(line, "Threads:")) != null) {
                            aVar.mThreadsCount = Integer.valueOf(strAD).intValue();
                        }
                    }
                } catch (IOException unused) {
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return aVar;
    }

    private static String aD(String str, String str2) {
        int length = str2.length();
        int i = -1;
        while (true) {
            if (length >= str.length()) {
                length = -1;
                break;
            }
            char cCharAt = str.charAt(length);
            if (cCharAt < '0' || cCharAt > '9') {
                if (i != -1) {
                    break;
                }
            } else if (i == -1) {
                i = length;
            }
            length++;
        }
        if (i == -1) {
            return null;
        }
        return length == -1 ? str.substring(i) : str.substring(i, length);
    }

    public static boolean b(Context context, @NonNull String... strArr) {
        if (context == null) {
            return false;
        }
        for (int i = 0; i <= 0; i++) {
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    public static void checkUiThread() {
    }

    public static boolean eo(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return b(context, "android.permission.READ_PHONE_STATE");
    }

    public static long ep(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static float eq(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        try {
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume == 0) {
                return 0.0f;
            }
            return streamVolume / streamMaxVolume;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int er(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean ge(int i) {
        return getApiLevel() >= i;
    }

    private static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    @Nullable
    public static String getProcessName(Context context) {
        return ba.getProcessName(context);
    }

    public static boolean isInMainProcess(Context context) {
        return ba.isInMainProcess(context);
    }
}
