package android.taobao.windvane.util;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import android.taobao.windvane.config.GlobalConfig;
import android.text.TextUtils;
import com.alipay.sdk.m.y.l;
import com.byazt.hv.TTDownloadField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CommonUtils {
    private static final String TAG = "CommonUtils";
    private static String currentProcessName = "";
    private static Boolean isMainProcess;

    public static String getProcessName() {
        try {
            String str = currentProcessName;
            if (str != null && str.length() > 0) {
                return currentProcessName;
            }
            if (GlobalConfig.context == null) {
                return null;
            }
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) GlobalConfig.context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    currentProcessName = runningAppProcessInfo.processName;
                }
            }
            return currentProcessName;
        } catch (Exception e) {
            TaoLog.e("getProcessName error", e.toString());
        }
    }

    public static boolean isMainProcess() {
        if (isMainProcess == null) {
            String processName = getProcessName();
            Application application = GlobalConfig.context;
            isMainProcess = Boolean.valueOf(application != null && TextUtils.equals(processName, application.getPackageName()));
        }
        return isMainProcess.booleanValue();
    }

    public static String parseCharset(String str) {
        int iIndexOf;
        if (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf("charset")) == -1 || str.indexOf("=", iIndexOf) == -1) {
            return "";
        }
        String strSubstring = str.substring(str.indexOf("=", iIndexOf) + 1);
        int iIndexOf2 = strSubstring.indexOf(l.b);
        if (iIndexOf2 != -1) {
            strSubstring = strSubstring.substring(0, iIndexOf2).trim();
        }
        return strSubstring.trim();
    }

    public static long parseDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str.trim()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String parseMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iIndexOf = str.indexOf(l.b);
        return iIndexOf == -1 ? str.trim() : str.substring(0, iIndexOf).trim();
    }
}
