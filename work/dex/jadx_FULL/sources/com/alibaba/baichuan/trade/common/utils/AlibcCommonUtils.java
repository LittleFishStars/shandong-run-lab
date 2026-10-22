package com.alibaba.baichuan.trade.common.utils;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.byazt.hv.TTDownloadField;
import com.randy.alibcextend.utils.ProcessManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcCommonUtils {
    public static Set<String> SDK_INIT_INFO = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24569a = "AlibcCommonUtils";
    private static boolean b = false;

    @RequiresApi(api = 21)
    public static class RecentUseComparator implements Comparator<UsageStats> {
        @Override // java.util.Comparator
        public int compare(UsageStats usageStats, UsageStats usageStats2) {
            return Long.compare(usageStats2.getLastTimeUsed(), usageStats.getLastTimeUsed());
        }
    }

    private static void a(Object obj, StringBuilder sb) {
        if (obj == null) {
            return;
        }
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    String next = itKeys.next();
                    if (!next.equals(UserTrackConstant.SIGN)) {
                        Object obj2 = jSONObject.get(next);
                        if (obj2 != null && !"null".equals(String.valueOf(obj2))) {
                            sb.append(next);
                        }
                        a(obj2, sb);
                    }
                } catch (JSONException e) {
                    AlibcLogger.e(f24569a, "json解析异常: msg=" + e.getMessage());
                    return;
                }
            }
            return;
        }
        if (!(obj instanceof JSONArray)) {
            if ("null".equals(String.valueOf(obj))) {
                return;
            }
            sb.append(obj);
            return;
        }
        JSONArray jSONArray = (JSONArray) obj;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                a(jSONArray.get(i), sb);
            } catch (JSONException e2) {
                AlibcLogger.e(f24569a, "json解析异常: msg=" + e2.getMessage());
                return;
            }
        }
    }

    public static int compileVersion(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("compared version is invalid");
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        int length = 0;
        for (int i = 0; i < iMin; i++) {
            length = strArrSplit[i].length() - strArrSplit2[i].length();
            if (length != 0 || (length = strArrSplit[i].compareTo(strArrSplit2[i])) != 0) {
                break;
            }
        }
        return length != 0 ? length : strArrSplit.length - strArrSplit2.length;
    }

    public static String getAppVersion(Context context) {
        if (!TextUtils.isEmpty(AlibcBaseTradeCommon.isvVersion)) {
            return AlibcBaseTradeCommon.isvVersion;
        }
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return "";
            }
            String strValueOf = String.valueOf(packageManager.getPackageInfo(context.getPackageName(), 0).versionName);
            return !TextUtils.isEmpty(strValueOf) ? strValueOf : "";
        } catch (PackageManager.NameNotFoundException e) {
            AlibcLogger.e(f24569a, "get package info exception: " + e.getMessage());
            return "";
        }
    }

    public static String getBase64(String str, int i) {
        return Base64.encodeToString(str.getBytes(), i);
    }

    public static String getMD5Sign(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            a(new JSONObject(str), sb);
            try {
                sb.append(AlibcCommonConstant.MD5_SALT);
                char[] charArray = sb.toString().toCharArray();
                Arrays.sort(charArray);
                return md5Digest(new String(charArray).getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                AlibcLogger.e(f24569a, "生成摘要错误: " + e.getMessage());
                return null;
            }
        } catch (JSONException e2) {
            AlibcLogger.e(f24569a, "json解析异常: msg=" + e2.getMessage());
            return "";
        }
    }

    public static boolean getRunningAppProcesses(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.ObjectInputStream] */
    public static Map<String, String> getSDKInfo(Context context) {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream2;
        ?? r3;
        String str;
        StringBuilder sb;
        try {
            try {
                File file = new File(context.getCacheDir() + File.separator + md5Digest("bcSdk".getBytes("UTF-8")));
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "infos");
                if (file2.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file2);
                    try {
                        ObjectInputStream objectInputStream3 = new ObjectInputStream(fileInputStream2);
                        try {
                            HashMap map = (HashMap) objectInputStream3.readObject();
                            objectInputStream3.close();
                            try {
                                objectInputStream3.close();
                            } catch (IOException e) {
                                AlibcLogger.e(f24569a, "close object input stream exception: " + e.getMessage());
                            }
                            try {
                                fileInputStream2.close();
                            } catch (IOException e2) {
                                AlibcLogger.e(f24569a, "close file input stream exception: " + e2.getMessage());
                            }
                            return map;
                        } catch (IOException e3) {
                            objectInputStream2 = objectInputStream3;
                            e = e3;
                            fileInputStream = fileInputStream2;
                            AlibcLogger.e(f24569a, "file operate exception: " + e.getMessage());
                            r3 = objectInputStream2;
                            if (objectInputStream2 != null) {
                                try {
                                    objectInputStream2.close();
                                    r3 = objectInputStream2;
                                } catch (IOException e4) {
                                    String str2 = f24569a;
                                    AlibcLogger.e(str2, "close object input stream exception: " + e4.getMessage());
                                    r3 = str2;
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e = e5;
                                    str = f24569a;
                                    sb = new StringBuilder("close file input stream exception: ");
                                    sb.append(e.getMessage());
                                    AlibcLogger.e(str, sb.toString());
                                }
                            }
                            return null;
                        } catch (Throwable th) {
                            objectInputStream = objectInputStream3;
                            th = th;
                            fileInputStream = fileInputStream2;
                            AlibcLogger.e(f24569a, "Error Exception: " + th.getMessage());
                            r3 = objectInputStream;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                    r3 = objectInputStream;
                                } catch (IOException e6) {
                                    String str3 = f24569a;
                                    AlibcLogger.e(str3, "close object input stream exception: " + e6.getMessage());
                                    r3 = str3;
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e7) {
                                    e = e7;
                                    str = f24569a;
                                    sb = new StringBuilder("close file input stream exception: ");
                                    sb.append(e.getMessage());
                                    AlibcLogger.e(str, sb.toString());
                                }
                            }
                            return null;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        fileInputStream = fileInputStream2;
                        objectInputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        objectInputStream = null;
                    }
                }
            } catch (Throwable th3) {
                if (r3 != 0) {
                    try {
                        r3.close();
                    } catch (IOException e9) {
                        AlibcLogger.e(f24569a, "close object input stream exception: " + e9.getMessage());
                    }
                }
                if (fileInputStream == null) {
                    throw th3;
                }
                try {
                    fileInputStream.close();
                    throw th3;
                } catch (IOException e10) {
                    AlibcLogger.e(f24569a, "close file input stream exception: " + e10.getMessage());
                    throw th3;
                }
            }
        } catch (IOException e11) {
            e = e11;
            objectInputStream2 = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            fileInputStream = null;
        }
        return null;
    }

    @RequiresApi(api = 21)
    public static boolean hasUsageAccessPermission(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            return ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) == 0;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean isApkDebug(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return (packageManager == null || packageManager.getPackageInfo(str, 0) == null) ? false : true;
            } catch (PackageManager.NameNotFoundException e) {
                AlibcLogger.e(f24569a, "package not found: " + e.getMessage());
            }
        }
        return false;
    }

    public static boolean isDebug(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            AlibcLogger.e(f24569a, e.getMessage());
            return false;
        }
    }

    public static boolean isForeGround(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (hasUsageAccessPermission(context)) {
                UsageStatsManager usageStatsManager = (UsageStatsManager) context.getApplicationContext().getSystemService("usagestats");
                long jCurrentTimeMillis = System.currentTimeMillis();
                List<UsageStats> listQueryUsageStats = usageStatsManager.queryUsageStats(4, jCurrentTimeMillis - 10000, jCurrentTimeMillis);
                if (listQueryUsageStats == null || listQueryUsageStats.size() == 0) {
                    return false;
                }
                Collections.sort(listQueryUsageStats, new RecentUseComparator());
                return str.equals(listQueryUsageStats.get(0).getPackageName());
            }
            if (getRunningAppProcesses(context, str)) {
                return true;
            }
            try {
                return ((Boolean) ProcessManager.class.getMethod("getLinuxCoreInfo", Context.class, String.class).invoke(null, context, str)).booleanValue();
            } catch (Exception unused) {
                AlibcLogger.e(f24569a, "");
            }
        }
        return false;
    }

    public static boolean isOpenAnalysisTool() {
        return b;
    }

    public static String md5Digest(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                int i = b2 & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static Object readObjectFromFile(Context context, String str) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        Object object = null;
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(context.getApplicationContext().openFileInput(str));
                    try {
                        object = objectInputStream.readObject();
                        objectInputStream2 = objectInputStream;
                    } catch (IOException e) {
                        e = e;
                        AlibcLogger.e(f24569a, "read object from local file exception: " + e.getMessage());
                        objectInputStream2 = objectInputStream;
                        str = objectInputStream;
                        if (objectInputStream != null) {
                        }
                        return object;
                    } catch (ClassNotFoundException unused) {
                        AlibcLogger.e(f24569a, "class not found");
                        str = objectInputStream;
                        if (objectInputStream != null) {
                            objectInputStream2 = objectInputStream;
                        }
                        return object;
                    } catch (Throwable th) {
                        th = th;
                        AlibcLogger.e(f24569a, "Error Exception: " + th.getMessage());
                        str = objectInputStream;
                        if (objectInputStream != null) {
                            objectInputStream2 = objectInputStream;
                        }
                        return object;
                    }
                } catch (Throwable th2) {
                    if (str != 0) {
                        try {
                            str.close();
                        } catch (IOException unused2) {
                            AlibcLogger.e(f24569a, "close input stream exception");
                        }
                    }
                    throw th2;
                }
            } catch (IOException e2) {
                e = e2;
                objectInputStream = null;
            } catch (ClassNotFoundException unused3) {
                objectInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
            }
            objectInputStream2.close();
            str = objectInputStream2;
        } catch (IOException unused4) {
            AlibcLogger.e(f24569a, "close input stream exception");
            str = objectInputStream2;
        }
        return object;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x013f: IF  (r3 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:92:?, block:B:63:0x013f */
    public static void saveSDKInfo(Context context, HashMap map) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        String str;
        StringBuilder sb;
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                File file = new File(context.getCacheDir() + File.separator + md5Digest("bcSdk".getBytes("UTF-8")));
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "infos");
                if (file2.exists()) {
                    file2.delete();
                }
                fileOutputStream = new FileOutputStream(file2);
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                    try {
                        objectOutputStream2.writeObject(map);
                        objectOutputStream2.flush();
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e) {
                            AlibcLogger.e(f24569a, "close object output stream exception: " + e.getMessage());
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            str = f24569a;
                            sb = new StringBuilder("close file output stream exception: ");
                            sb.append(e.getMessage());
                            AlibcLogger.e(str, sb.toString());
                        }
                    } catch (IOException e3) {
                        objectOutputStream = objectOutputStream2;
                        e = e3;
                        AlibcLogger.e(f24569a, "file operate exception: " + e.getMessage());
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e4) {
                                AlibcLogger.e(f24569a, "close object output stream exception: " + e4.getMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                                e = e5;
                                str = f24569a;
                                sb = new StringBuilder("close file output stream exception: ");
                                sb.append(e.getMessage());
                                AlibcLogger.e(str, sb.toString());
                            }
                        }
                    } catch (Throwable th) {
                        objectOutputStream = objectOutputStream2;
                        th = th;
                        AlibcLogger.e(f24569a, "Error Exception: " + th.getMessage());
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e6) {
                                AlibcLogger.e(f24569a, "close object output stream exception: " + e6.getMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e7) {
                                e = e7;
                                str = f24569a;
                                sb = new StringBuilder("close file output stream exception: ");
                                sb.append(e.getMessage());
                                AlibcLogger.e(str, sb.toString());
                            }
                        }
                    }
                } catch (IOException e8) {
                    e = e8;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                if (0 != 0) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e9) {
                        AlibcLogger.e(f24569a, "close object output stream exception: " + e9.getMessage());
                    }
                }
                if (fileOutputStream2 == null) {
                    throw th3;
                }
                try {
                    fileOutputStream2.close();
                    throw th3;
                } catch (IOException e10) {
                    AlibcLogger.e(f24569a, "close file output stream exception: " + e10.getMessage());
                    throw th3;
                }
            }
        } catch (IOException e11) {
            e = e11;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static void setOpenAnalysisTool(boolean z) {
        b = z;
    }

    public static boolean verifySdkExist(String str, String str2) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            AlibcLogger.e(f24569a, str2 + " is not exist: " + e.getMessage());
            return false;
        }
    }

    public static synchronized void writeObjectToFile(Context context, Object obj, String str) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
            objectOutputStream = new ObjectOutputStream(fileOutputStreamOpenFileOutput);
            try {
                objectOutputStream.writeObject(obj);
                fileOutputStreamOpenFileOutput.getFD().sync();
            } catch (IOException unused) {
                objectOutputStream2 = objectOutputStream;
                AlibcLogger.e(f24569a, "write object to local file exception");
                objectOutputStream = objectOutputStream2;
            } catch (Throwable th) {
                th = th;
                objectOutputStream2 = objectOutputStream;
                AlibcLogger.e(f24569a, "Error Exception: " + th.getMessage());
                objectOutputStream = objectOutputStream2;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (objectOutputStream != null) {
            try {
                objectOutputStream.close();
            } catch (IOException unused3) {
                AlibcLogger.e(f24569a, "close output stream exception");
            }
        }
    }
}
