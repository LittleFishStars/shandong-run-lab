package com.alibaba.baichuan.log;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TLogNative {
    public static final int AppednerModeAsync = 0;
    public static final int AppednerModeSync = 1;
    private static final int MAX_CACHE_CAPACITY = 100;
    private static LogWriteMonitor mLogWriteMonitor;
    private String TAG = "TLOG.TLogNative";
    private static final ConcurrentLRUCache<XLoggerInfo> sInitCache = new ConcurrentLRUCache<>(100);
    private static int pid = -1;
    private static volatile boolean sOpenSoSuccess = false;

    public interface LogWriteMonitor {
        void onLogWrite(int i, String str, String str2, String str3, String str4, String str5, String str6);
    }

    public static class XLoggerInfo {
        public String clientID;
        public String filename;
        public String funcname;
        public int level;
        public int line;
        public String log;
        public long maintid;
        public String module;
        public long pid;
        public String serverID;
        public String tag;
        public long tid;
        public String type;
    }

    public static native void addModuleFilter(String str, int i);

    public static native void appenderClose();

    public static native void appenderFlush(boolean z);

    public static void appenderFlushData(boolean z) {
        try {
            if (pid == Process.myPid()) {
                appenderFlush(z);
            }
        } catch (Exception e) {
            Log.e("TLogNative", "appenderFlushData failure", e);
        } catch (UnsatisfiedLinkError e2) {
            Log.e("TLogNative", "appenderFlushData failure, unsatisfied link error", e2);
        }
    }

    public static void appenderOpen(int i, String str, String str2, String str3, String str4) {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("bcmarsxlog");
            sOpenSoSuccess = appenderOpen(i, 0, str, str2, str3, str4);
            pid = Process.myPid();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static native boolean appenderOpen(int i, int i2, String str, String str2, String str3, String str4);

    public static native void cleanModuleFilter();

    public static void dispatch(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TLogInitializer.getInstance().getInitState() == 2) {
            ConcurrentLRUCache<XLoggerInfo> concurrentLRUCache = sInitCache;
            if (concurrentLRUCache.size() > 0) {
                concurrentLRUCache.clear();
                Log.e("tlog", "flush log in asyncInit Mode");
                for (XLoggerInfo xLoggerInfo : concurrentLRUCache) {
                    logWrite(xLoggerInfo.level, safeString(xLoggerInfo.module), safeString(xLoggerInfo.tag), safeString(xLoggerInfo.type), safeString(xLoggerInfo.clientID), safeString(xLoggerInfo.serverID), safeString(xLoggerInfo.log));
                }
            }
            logWrite(i, str, str2, str3, str4, str5, str6);
            return;
        }
        if (TLogInitializer.getInstance().isInitSync()) {
            Log.e("tlog", "tlog isn't init,please call init() ,or initSync(bool) method !");
            return;
        }
        XLoggerInfo xLoggerInfo2 = new XLoggerInfo();
        xLoggerInfo2.level = i;
        xLoggerInfo2.module = str;
        xLoggerInfo2.tag = str2;
        xLoggerInfo2.type = str3;
        xLoggerInfo2.clientID = str4;
        xLoggerInfo2.serverID = str5;
        xLoggerInfo2.log = str6;
        sInitCache.add(xLoggerInfo2);
    }

    public static native int getLogLevel();

    public static String getRc4EncryptSecretyKeyValue() {
        try {
            return TLogSecret.getInstance().getRc4EncryptSecretValue(TLogInitializer.getInstance().getSecurityKey());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getRsaPublicKeyMd5Value() {
        return TLogSecret.getInstance().getRsaMd5Value();
    }

    public static String getSecurityKey() {
        String securityKey = TLogInitializer.getInstance().getSecurityKey();
        return TextUtils.isEmpty(securityKey) ? "t_remote_debugger" : securityKey;
    }

    public static boolean isSoOpen() {
        return sOpenSoSuccess;
    }

    private static void logWrite(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        if (pid != Process.myPid()) {
            Log.e("tlog", "在fork的进程写tlog");
            return;
        }
        if (!sOpenSoSuccess) {
            Log.e("tlog", "sOpenSoSuccess:" + sOpenSoSuccess);
            return;
        }
        if (TextUtils.isEmpty(str) && str2.contains(Consts.DOT)) {
            str = str2.substring(0, str2.indexOf(Consts.DOT));
            str2 = str2.substring(str2.indexOf(Consts.DOT) + 1, str2.length());
        }
        if (TextUtils.isEmpty(str)) {
            str = "module";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "tag";
        }
        try {
            logWrite2(i, str, str2, str3, str4, str5, str6);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            LogWriteMonitor logWriteMonitor = mLogWriteMonitor;
            if (logWriteMonitor != null) {
                logWriteMonitor.onLogWrite(i, str, str2, str3, str4, str5, str6);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static native void logWrite(XLoggerInfo xLoggerInfo, String str);

    private static native void logWrite2(int i, String str, String str2, String str3, String str4, String str5, String str6);

    private static String safeString(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static native void setAppenderMode(int i);

    public static native void setConsoleLogOpen(boolean z);

    public static native void setLogLevel(int i);

    private static void setLogWriteMonitor(LogWriteMonitor logWriteMonitor) {
        mLogWriteMonitor = logWriteMonitor;
    }
}
