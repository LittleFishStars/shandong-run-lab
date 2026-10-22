package com.byazt.w;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.byazt.b.t;
import com.byazt.c.cu;
import com.byazt.c.gr;
import com.byazt.hv.TTDownloadField;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1017, 34})
public class a {
    public static final String c = "a";
    public static Boolean da;
    public static ConnectivityManager i;
    public static Boolean sl;
    public static final Pattern tt = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    public static String ve = null;
    public static volatile SparseArray<Boolean> uj = new SparseArray<>();
    public static volatile SparseArray<List<cu>> n = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f29153a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static Pattern sp = null;
    public static Pattern x = null;

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String strUj = uj(com.byazt.zz.ve.ic());
        return strUj != null && strUj.equals(str);
    }

    public static double c(long j) {
        return j / 1048576.0d;
    }

    public static String c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static boolean c(int i2) {
        return i2 == 0 || i2 == 2;
    }

    private static String da(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (sp == null) {
                sp = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            Matcher matcher = sp.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            if (x == null) {
                x = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
            }
            Matcher matcher2 = x.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    private static String i() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i2 = bufferedReader.read();
                    if (i2 <= 0) {
                        break;
                    }
                    sb.append((char) i2);
                }
                if (com.byazt.x.c.c()) {
                    com.byazt.x.c.tt("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                c(bufferedReader);
                return string;
            } catch (Throwable unused) {
                c(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String n(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return c(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static boolean sl(String str) {
        String str2 = c;
        m.tt(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                m.tt(str2, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    public static String sp(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static long tt(com.byazt.hs.sp spVar) {
        if (spVar == null) {
            return -1L;
        }
        String strTt = tt(spVar, "Content-Range");
        if (TextUtils.isEmpty(strTt)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(strTt);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e) {
            com.byazt.x.c.uj(c, "parse content-length from content-range failed " + e);
        }
        return -1L;
    }

    public static boolean tt(long j) {
        return j == -1;
    }

    public static boolean uj(int i2) {
        return i2 == 206 || i2 == 200;
    }

    public static boolean uj(DownloadInfo downloadInfo) {
        boolean z = false;
        if (downloadInfo.isDeleteCacheIfCheckFailed() || !TextUtils.isEmpty(downloadInfo.getLastModified())) {
            com.byazt.x.c.tt(c, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        } else {
            com.byazt.x.c.tt(c, "dcache::last modify is emtpy, so just return cache");
        }
        com.byazt.x.c.tt(c, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    public static String ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static boolean ve(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 0;
    }

    public static boolean x(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1006) {
                return true;
            }
            if (errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064) {
                String message = baseException.getMessage();
                return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
            }
        } else if (th instanceof IOException) {
            String strDa = da(th);
            if (!TextUtils.isEmpty(strDa) && strDa.contains("ENOSPC")) {
                return true;
            }
        }
        return false;
    }

    public static String c(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            if (i2 >= 0 && i2 + i3 <= bArr.length) {
                int i4 = i3 * 2;
                char[] cArr = new char[i4];
                int i5 = 0;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = bArr[i6 + i2] & 255;
                    int i8 = i5 + 1;
                    char[] cArr2 = f29153a;
                    cArr[i5] = cArr2[i7 >> 4];
                    i5 = i8 + 1;
                    cArr[i8] = cArr2[i7 & 15];
                }
                return new String(cArr, 0, i4);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    public static void ve(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            m.uj(c, "deleteFile: " + str + WVNativeCallbackUtil.SEPERATER + str2);
            file.delete();
        }
    }

    public static boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        String strDa = da(th);
        return !TextUtils.isEmpty(strDa) && strDa.contains("Requested Range Not Satisfiable");
    }

    public static long a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<com.byazt.t.tt> listVe = com.byazt.zz.ve.zm().ve(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (z) {
            if (listVe == null || chunkCount != listVe.size()) {
                return 0L;
            }
            return tt(listVe);
        }
        return downloadInfo.getCurBytes();
    }

    private static String n(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (com.byazt.x.c.c()) {
                            com.byazt.x.c.tt("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
        return null;
    }

    public static long uj(String str) throws BaseException {
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (IllegalArgumentException e) {
            throw new BaseException(1050, e);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    private static String sl() {
        String str;
        Throwable th;
        try {
            Method declaredMethod = Class.forName(ProcessUtils.ACTIVITY_THREAD, false, Application.class.getClassLoader()).getDeclaredMethod(TRiverConstants.KEY_CURRENT_PROCESS_NAME, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (!(objInvoke instanceof String)) {
                return null;
            }
            str = (String) objInvoke;
            try {
                if (!TextUtils.isEmpty(str) && com.byazt.x.c.c()) {
                    com.byazt.x.c.tt("Process", "processName = " + str);
                }
            } catch (Throwable th2) {
                th = th2;
                m.c(th);
            }
            return str;
        } catch (Throwable th3) {
            str = null;
            th = th3;
        }
        m.c(th);
        return str;
    }

    public static boolean sp(Throwable th) {
        return com.byazt.zz.ve.aw().c(th);
    }

    public static File sp() {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception unused) {
            externalStorageState = "";
        }
        if ("mounted".equals(externalStorageState)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static boolean ve(DownloadInfo downloadInfo) {
        return c(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static long tt(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split(WVNativeCallbackUtil.SEPERATER);
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.byazt.x.c.uj(c, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static boolean ve(String str, String str2, String str3) {
        return c(tt(str, str2, str3));
    }

    public static boolean x(String str) {
        Context contextIc;
        if (com.byazt.k.c.ve().tt("save_path_security") > 0 && (contextIc = com.byazt.zz.ve.ic()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + contextIc.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static boolean uj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            try {
                bArr[i2] = (byte) (Integer.parseInt(str.substring(i3, i3 + 2), 16) & 255);
            } catch (Exception e) {
                m.c(e);
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            m.c(e2);
            return str;
        }
    }

    private static String da() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && com.byazt.x.c.c()) {
                com.byazt.x.c.tt("Process", "processName = " + processName);
            }
            return processName;
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }

    public static boolean ve(com.byazt.hs.sp spVar) {
        if (spVar == null) {
            return false;
        }
        if (c.c(8)) {
            return com.ipd.dsp.internal.g0.c.k.equals(spVar.c("Transfer-Encoding")) || c(spVar) == -1;
        }
        return c(spVar) == -1;
    }

    public static String a() {
        return c(Downloader.getInstance(com.byazt.zz.ve.ic()).getGlobalSaveTempDir(), false);
    }

    public static long i(String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
            if (!matcher.find()) {
                return 0L;
            }
            try {
                j = Long.parseLong(matcher.group(1));
                return j;
            } catch (Throwable th) {
                m.c(th);
                return 0L;
            }
        } catch (Throwable th2) {
            m.c(th2);
            return j;
        }
    }

    public static String tt(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static String uj(Context context) {
        String str = ve;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strDa = da();
        ve = strDa;
        if (!TextUtils.isEmpty(strDa)) {
            return ve;
        }
        String strSl = sl();
        ve = strSl;
        if (!TextUtils.isEmpty(strSl)) {
            return ve;
        }
        String strN = n(context);
        ve = strN;
        if (!TextUtils.isEmpty(strN)) {
            return ve;
        }
        String strI = i();
        ve = strI;
        return strI;
    }

    public static boolean n(Throwable th) {
        if (th == null) {
            return false;
        }
        String strDa = da(th);
        return !TextUtils.isEmpty(strDa) && strDa.contains("Precondition Failed");
    }

    public static boolean ve(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerC = c(context);
            if (connectivityManagerC == null || (activeNetworkInfo = connectivityManagerC.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean x() {
        Context contextIc = com.byazt.zz.ve.ic();
        return (contextIc == null || tt(contextIc) || !ve(contextIc)) ? false : true;
    }

    public static long tt(List<com.byazt.t.tt> list) {
        Iterator<com.byazt.t.tt> it = list.iterator();
        long jZ = 0;
        while (it.hasNext()) {
            jZ += it.next().z();
        }
        return jZ;
    }

    public static String da(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            m.c(th2);
            return "throwable getMsg error";
        }
    }

    public static com.byazt.ev.a n(int i2) {
        com.byazt.ev.a aVar = com.byazt.ev.a.MAIN;
        com.byazt.ev.a aVar2 = com.byazt.ev.a.SUB;
        if (i2 != aVar2.ordinal()) {
            aVar2 = com.byazt.ev.a.NOTIFICATION;
            if (i2 != aVar2.ordinal()) {
                return aVar;
            }
        }
        return aVar2;
    }

    public static void tt(DownloadInfo downloadInfo) {
        com.byazt.k.c cVarC;
        JSONObject jSONObjectUj;
        if (downloadInfo == null || (jSONObjectUj = (cVarC = com.byazt.k.c.c(downloadInfo.getId())).uj("download_dir")) == null) {
            return;
        }
        String strOptString = jSONObjectUj.optString("ins_desc");
        if (!TextUtils.isEmpty(strOptString)) {
            ve(downloadInfo.getSavePath(), strOptString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String strC = c(title, cVarC);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(strC) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(strC);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            sl(file2.getPath());
            file = file.getParentFile();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0037  */
    public static boolean ve() {
        Boolean bool = sl;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strUj = uj(com.byazt.zz.ve.ic());
        if (strUj != null) {
            if (strUj.equals(com.byazt.zz.ve.ic().getPackageName() + ":downloader")) {
                sl = Boolean.TRUE;
            } else {
                sl = Boolean.FALSE;
            }
        } else {
            sl = Boolean.FALSE;
        }
        return sl.booleanValue();
    }

    public static long c(com.byazt.hs.sp spVar) {
        if (spVar == null) {
            return -1L;
        }
        String strTt = tt(spVar, "Content-Length");
        if (TextUtils.isEmpty(strTt) && c.c(1)) {
            return tt(spVar);
        }
        try {
            return Long.parseLong(strTt);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<com.byazt.t.tt> listVe = com.byazt.zz.ve.zm().ve(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (listVe != null && listVe.size() > 1) {
            long jUj = uj(listVe);
            if (jUj >= 0) {
                return jUj;
            }
        }
        return 0L;
    }

    public static String c(com.byazt.hs.sp spVar, String str) {
        String strDa = da(spVar.c("Content-Disposition"));
        return TextUtils.isEmpty(strDa) ? n(str) : strDa;
    }

    public static String n() {
        return c(Downloader.getInstance(com.byazt.zz.ve.ic()).getGlobalSaveDir(), true);
    }

    public static boolean ve(Throwable th) {
        if (th == null) {
            return false;
        }
        String strDa = da(th);
        return !TextUtils.isEmpty(strDa) && strDa.contains("network not available");
    }

    public static com.byazt.t.n c(DownloadInfo downloadInfo, String str, String str2, int i2) throws BaseException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            boolean zMkdirs = false;
            if (file.exists() && file.isDirectory()) {
                throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
            }
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (!file2.exists()) {
                            if (!file2.mkdirs() && !file2.exists()) {
                                if (com.byazt.k.c.c(downloadInfo).c("opt_mkdir_failed", 0) != 1) {
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                                int i3 = 0;
                                while (!zMkdirs) {
                                    int i4 = i3 + 1;
                                    if (i3 >= 3) {
                                        break;
                                    }
                                    try {
                                        Thread.sleep(10L);
                                        zMkdirs = file2.mkdirs();
                                        i3 = i4;
                                    } catch (InterruptedException unused) {
                                    }
                                }
                                if (!zMkdirs) {
                                    if (uj(downloadInfo.getSavePath()) < PlaybackStateCompat.ACTION_PREPARE) {
                                        throw new BaseException(1006, "download savePath directory can not created:" + str);
                                    }
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                            }
                        } else {
                            file2.delete();
                            if (!file2.mkdirs() && !file2.exists()) {
                                throw new BaseException(1031, "download savePath is not directory:path=" + str);
                            }
                            throw new BaseException(1031, "download savePath is not directory:" + str);
                        }
                    }
                    file.createNewFile();
                } catch (IOException e) {
                    throw new BaseException(1036, e);
                }
            }
            return new com.byazt.t.n(file, i2);
        }
        throw new BaseException(1021, new IOException("path must be not empty"));
    }

    public static boolean uj() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean ve(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        if (baseException.getErrorCode() != 1011) {
            return baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException);
        }
        return true;
    }

    public static String n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strN = n(str2);
        return (TextUtils.isEmpty(strN) || str.contains(strN)) ? str : new File(str, strN).getAbsolutePath();
    }

    public static boolean uj(Throwable th) {
        if (th == null) {
            return false;
        }
        String strDa = da(th);
        return !TextUtils.isEmpty(strDa) && strDa.contains("Exception in connect");
    }

    private static void ve(Throwable th, String str) throws com.byazt.m.sp {
        com.byazt.m.sp spVarC = com.byazt.zz.ve.aw().c(th, null);
        if (spVarC == null) {
            spVarC = com.byazt.zz.ve.aw().c(th.getCause(), null);
        }
        if (spVarC == null) {
            return;
        }
        throw new com.byazt.m.sp(spVarC.getErrorCode(), tt(spVarC, str)).c(spVarC.c());
    }

    private static long uj(List<com.byazt.t.tt> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long jYp = -1;
        for (com.byazt.t.tt ttVar : list) {
            if (ttVar != null && (ttVar.yp() <= ttVar.m() || ttVar.m() == 0)) {
                if (jYp == -1 || jYp > ttVar.yp()) {
                    jYp = ttVar.yp();
                }
            }
        }
        return jYp;
    }

    public static long ve(long j) {
        return System.currentTimeMillis() - j;
    }

    public static boolean ve(List<com.byazt.t.ve> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.byazt.t.ve veVar : list) {
            if (veVar != null && !TextUtils.isEmpty(veVar.c()) && !TextUtils.isEmpty(veVar.tt()) && "download-tc21-1-15".equals(veVar.c()) && "download-tc21-1-15".equals(veVar.tt())) {
                return true;
            }
        }
        return false;
    }

    public static int tt(String str, String str2, String str3) {
        return com.byazt.v.ve.c(str3, new File(str, str2));
    }

    public static String tt(int i2) {
        String str = "ttmd5 check code = " + i2 + ", ";
        if (i2 != 99) {
            switch (i2) {
                case 0:
                    return str + "md5 match";
                case 1:
                    return str + "md5 not match";
                case 2:
                    return str + "md5 empty";
                case 3:
                    return str + "ttmd5 version not support";
                case 4:
                    return str + "ttmd5 tag parser error";
                case 5:
                    return str + "file not exist";
                case 6:
                    return str + "get file md5 error";
                default:
                    return str;
            }
        }
        return str + "unknown error";
    }

    @TargetApi(19)
    private static void tt(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            long jTransferFrom = channel2.transferFrom(channel, j, j2 > 31457280 ? 31457280L : j2);
                            if (jTransferFrom == 0) {
                                break;
                            } else {
                                j += jTransferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        channel.close();
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (channel2 == null) {
                                throw th2;
                            }
                            try {
                                channel2.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th2;
                            }
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                if (channel == null) {
                                    throw th4;
                                }
                                try {
                                    channel.close();
                                    throw th4;
                                } catch (Throwable th5) {
                                    th.addSuppressed(th5);
                                    throw th4;
                                }
                            }
                        }
                    }
                } catch (Throwable th6) {
                    try {
                        throw th6;
                    } catch (Throwable th7) {
                        try {
                            fileOutputStream.close();
                            throw th7;
                        } catch (Throwable th8) {
                            th6.addSuppressed(th8);
                            throw th7;
                        }
                    }
                }
            } catch (Throwable th9) {
                throw th9;
            }
        } catch (Throwable th10) {
            try {
                throw th10;
            } catch (Throwable th11) {
                try {
                    fileInputStream.close();
                    throw th11;
                } catch (Throwable th12) {
                    th10.addSuppressed(th12);
                    throw th11;
                }
            }
        }
    }

    public static List<com.byazt.t.tt> c(List<com.byazt.t.tt> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.byazt.t.tt ttVar : list) {
            if (ttVar != null) {
                if (ttVar.uj()) {
                    sparseArray.put(ttVar.my(), ttVar);
                    List<com.byazt.t.tt> list2 = (List) sparseArray2.get(ttVar.my());
                    if (list2 != null) {
                        Iterator<com.byazt.t.tt> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().c(ttVar);
                        }
                        ttVar.c(list2);
                    }
                } else {
                    com.byazt.t.tt ttVar2 = (com.byazt.t.tt) sparseArray.get(ttVar.tt());
                    if (ttVar2 != null) {
                        List<com.byazt.t.tt> listSp = ttVar2.sp();
                        if (listSp == null) {
                            listSp = new ArrayList<>();
                            ttVar2.c(listSp);
                        }
                        ttVar.c(ttVar2);
                        listSp.add(ttVar);
                    } else {
                        List arrayList = (List) sparseArray2.get(ttVar.tt());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            sparseArray2.put(ttVar.tt(), arrayList);
                        }
                        arrayList.add(ttVar);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList2.add(sparseArray.get(sparseArray.keyAt(i2)));
        }
        return arrayList2.isEmpty() ? list : arrayList2;
    }

    public static boolean tt(File file, File file2) throws BaseException {
        String str = c;
        m.uj(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean zRenameTo = file.renameTo(file2);
        if (!zRenameTo) {
            zRenameTo = c(file, file2);
            try {
                m.uj(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return zRenameTo;
    }

    public static boolean tt(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerC = c(context);
            return connectivityManagerC != null && (activeNetworkInfo = connectivityManagerC.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && 1 == activeNetworkInfo.getType();
        } catch (Exception unused) {
        }
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String c(String str, String str2, String str3) {
        String strC;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            strC = c(str2, str3);
        } else {
            strC = c(str, str3);
        }
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        return String.format("%s.tp", strC);
    }

    public static boolean tt() {
        return !ve() && com.byazt.zz.ve.ve() && t.c(true).sp();
    }

    public static boolean tt(Throwable th) {
        if (th == null) {
            return false;
        }
        String strDa = da(th);
        if (!(th instanceof com.byazt.m.tt) || (((com.byazt.m.tt) th).c() != 403 && (TextUtils.isEmpty(strDa) || !strDa.contains("403")))) {
            return !TextUtils.isEmpty(strDa) && strDa.contains("Forbidden");
        }
        return true;
    }

    public static void c(DownloadInfo downloadInfo) {
        c(downloadInfo, true);
    }

    public static void c(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                ve(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                m.c(th);
                return;
            }
        }
        ve(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            tt(downloadInfo);
        }
        if (z) {
            String strN = n(downloadInfo.getUrl());
            if (TextUtils.isEmpty(strN) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(strN)) {
                return;
            }
            sl(downloadInfo.getSavePath());
        }
    }

    public static boolean tt(BaseException baseException) {
        if (!(baseException instanceof com.byazt.m.tt)) {
            return false;
        }
        com.byazt.m.tt ttVar = (com.byazt.m.tt) baseException;
        return ttVar.c() == 412 || ttVar.c() == 416;
    }

    public static String tt(Throwable th, String str) {
        if (str == null) {
            return da(th);
        }
        return str + c49.f40900a + da(th);
    }

    public static void tt(List<com.byazt.t.ve> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.byazt.t.ve("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static String tt(com.byazt.hs.sp spVar, String str) {
        if (spVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String strC = spVar.c(str);
        if (!com.byazt.k.c.ve().tt("fix_get_http_resp_head_ignore_case", true)) {
            return strC;
        }
        if (TextUtils.isEmpty(strC)) {
            strC = spVar.c(str.toLowerCase());
        }
        return TextUtils.isEmpty(strC) ? spVar.c(str.toUpperCase()) : strC;
    }

    public static boolean c(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean c(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists() && ve(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                    return true;
                }
            } catch (OutOfMemoryError e) {
                m.c(e);
            }
        }
        return false;
    }

    public static boolean tt(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && ve(com.byazt.zz.ve.ic());
    }

    public static int c(File file, String str) {
        return com.byazt.v.ve.c(str, file);
    }

    public static void c(DownloadInfo downloadInfo, gr grVar, cu cuVar) {
        boolean z;
        BaseException baseException;
        boolean z2;
        String str = c;
        com.byazt.x.c.tt(str, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
        try {
            synchronized (uj) {
                Boolean bool = uj.get(downloadInfo.getId());
                Boolean bool2 = Boolean.TRUE;
                if (bool == bool2) {
                    com.byazt.x.c.tt(str, "has another same task is saving temp file");
                    if (cuVar != null) {
                        List<cu> arrayList = n.get(downloadInfo.getId());
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            n.put(downloadInfo.getId(), arrayList);
                        }
                        arrayList.add(cuVar);
                    }
                    return;
                }
                com.byazt.x.c.tt(str, "saveTempFileStatusMap put id:" + downloadInfo.getId());
                uj.put(downloadInfo.getId(), bool2);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                boolean zX = x(downloadInfo.getSavePath());
                if (file2.exists()) {
                    com.byazt.x.c.tt(str, "targetFile exist");
                    int iC = c(file2, downloadInfo.getMd5());
                    if (c(iC)) {
                        com.byazt.x.c.tt(str, "tempFile not exist , targetFile exists and md5 check valid");
                        downloadInfo.setTTMd5CheckStatus(iC);
                        if (cuVar != null) {
                            cuVar.c();
                        }
                        c(downloadInfo.getId(), true, (BaseException) null);
                    } else {
                        if (file.exists()) {
                            z = true;
                        } else {
                            BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), tt(iC)));
                            if (cuVar != null) {
                                cuVar.c(baseException2);
                            }
                            c(downloadInfo.getId(), false, baseException2);
                            z = false;
                        }
                        if (zX && !file2.delete()) {
                            if (z) {
                                BaseException baseException3 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + tt(iC));
                                if (cuVar != null) {
                                    cuVar.c(baseException3);
                                }
                                c(downloadInfo.getId(), false, baseException3);
                            } else if (grVar != null) {
                                com.byazt.zl.c.c(grVar, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                            }
                        }
                    }
                    z = false;
                } else if (file.exists()) {
                    z = true;
                } else {
                    BaseException baseException4 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                    if (cuVar != null) {
                        cuVar.c(baseException4);
                    }
                    c(downloadInfo.getId(), false, baseException4);
                    z = false;
                }
                if (z) {
                    try {
                        int iC2 = com.byazt.k.c.c(downloadInfo.getId()).c("download_finish_check_ttmd5", 2);
                        if (iC2 > 0) {
                            int iC3 = c(file, downloadInfo.getMd5());
                            downloadInfo.setTTMd5CheckStatus(iC3);
                            if (iC2 >= 2 && !c(iC3)) {
                                BaseException baseException5 = new BaseException(1034, tt(iC3));
                                if (cuVar != null) {
                                    cuVar.c(baseException5);
                                }
                                c(downloadInfo.getId(), false, baseException5);
                                c(downloadInfo, zX);
                                return;
                            }
                        }
                        z2 = !tt(file, file2);
                        baseException = null;
                    } catch (BaseException e) {
                        if (com.byazt.k.c.c(downloadInfo.getId()).c("fix_file_rename_failed")) {
                            baseException = e;
                            z2 = true;
                        } else {
                            baseException = e;
                            z2 = false;
                        }
                    }
                    if (z2) {
                        if (baseException == null) {
                            baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                        }
                        if (cuVar != null) {
                            cuVar.c(baseException);
                        }
                        c(downloadInfo.getId(), false, baseException);
                        return;
                    }
                    if (cuVar != null) {
                        cuVar.c();
                    }
                    c(downloadInfo.getId(), true, (BaseException) null);
                }
            }
        } catch (Throwable th) {
            com.byazt.x.c.tt(c, "saveFileAsTargetName throwable " + th.getMessage());
            if (cuVar != null) {
                cuVar.c(new BaseException(1038, tt(th, "saveFileAsTargetName")));
            }
        }
    }

    private static void c(int i2, boolean z, BaseException baseException) {
        synchronized (uj) {
            List<cu> list = n.get(i2);
            if (list != null) {
                for (cu cuVar : list) {
                    if (cuVar != null) {
                        if (z) {
                            cuVar.c();
                        } else {
                            cuVar.c(baseException);
                        }
                    }
                }
            }
            com.byazt.x.c.tt(c, "handleTempSaveCallback id:" + i2);
            uj.remove(i2);
        }
    }

    public static void c(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        m.uj(c, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!c(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean c(File file, File file2) throws BaseException {
        return c(file, file2, true);
    }

    public static boolean c(File file, File file2, boolean z) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    m.uj(c, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    tt(file, file2, z);
                    return true;
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                c(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static boolean c(int i2, String str) {
        if (c.c(16777216)) {
            return i2 == 206 || i2 == 1;
        }
        if (i2 >= 400) {
            return false;
        }
        return i2 == 206 || i2 == 1 || "bytes".equals(str);
    }

    public static List<com.byazt.t.ve> c(List<com.byazt.t.ve> list, String str, com.byazt.t.tt ttVar) {
        return c(list, str, ttVar.u(), ttVar.m());
    }

    public static List<com.byazt.t.ve> c(List<com.byazt.t.ve> list, String str, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.byazt.t.ve veVar : list) {
                if (veVar != null) {
                    arrayList.add(veVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.byazt.t.ve("If-Match", str));
        }
        arrayList.add(new com.byazt.t.ve("Accept-Encoding", HlsPlaylistParser.V));
        String str2 = j2 <= 0 ? String.format("bytes=%s-", String.valueOf(j)) : String.format("bytes=%s-%s", String.valueOf(j), String.valueOf(j2));
        arrayList.add(new com.byazt.t.ve("Range", str2));
        com.byazt.x.c.tt(c, " range CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + str2);
        return arrayList;
    }

    public static boolean c(int i2, String str, String str2) {
        return i2 == -3 && !uj(str, str2);
    }

    public static ConnectivityManager c(Context context) {
        ConnectivityManager connectivityManager = i;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        i = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean c() {
        Boolean bool = da;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strUj = uj(com.byazt.zz.ve.ic());
        Boolean boolValueOf = Boolean.valueOf((strUj == null || !strUj.contains(u15.f19942b)) && strUj != null && strUj.equals(com.byazt.zz.ve.ic().getPackageName()));
        da = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        String strDa = da(th);
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        return !TextUtils.isEmpty(strDa) && (strDa.contains("time out") || strDa.contains("Time-out"));
    }

    public static boolean c(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static void c(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (!(th instanceof BaseException)) {
            if (!(th instanceof SSLHandshakeException)) {
                if (!c(th)) {
                    if (!n(th)) {
                        if (!a(th)) {
                            if (!tt(th)) {
                                if (!ve(th)) {
                                    if (!uj(th)) {
                                        if (th instanceof IOException) {
                                            ve(th, str);
                                            c((IOException) th, str);
                                            return;
                                        }
                                        throw new BaseException(1000, tt(th, str2));
                                    }
                                    throw new BaseException(1041, tt(th, str2));
                                }
                                throw new BaseException(1049, tt(th, str2));
                            }
                            throw new BaseException(1047, tt(th, str2));
                        }
                        throw new com.byazt.m.tt(1004, 416, tt(th, str2));
                    }
                    throw new com.byazt.m.tt(1004, 412, tt(th, str2));
                }
                throw new BaseException(1048, tt(th, str2));
            }
            throw new BaseException(1011, tt(th, str2));
        }
        BaseException baseException = (BaseException) th;
        baseException.setErrorMsg(str2 + c49.f40900a + baseException.getErrorMessage());
        throw baseException;
    }

    public static void c(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String strTt = tt(iOException, str);
        if (!(iOException instanceof ConnectException)) {
            if (!(iOException instanceof UnknownHostException)) {
                if (!(iOException instanceof NoRouteToHostException)) {
                    if (!(iOException instanceof UnknownServiceException)) {
                        if (!(iOException instanceof PortUnreachableException)) {
                            if (!(iOException instanceof SocketTimeoutException)) {
                                if (!(iOException instanceof SocketException)) {
                                    if (!(iOException instanceof HttpRetryException)) {
                                        if (!(iOException instanceof ProtocolException)) {
                                            if (!(iOException instanceof MalformedURLException)) {
                                                if (!(iOException instanceof FileNotFoundException)) {
                                                    if (!(iOException instanceof InterruptedIOException)) {
                                                        if (!(iOException instanceof UnsupportedEncodingException)) {
                                                            if (!(iOException instanceof EOFException)) {
                                                                if (!(iOException instanceof StreamResetException)) {
                                                                    if (!(iOException instanceof SSLException)) {
                                                                        if (x(iOException)) {
                                                                            throw new BaseException(1006, strTt);
                                                                        }
                                                                        throw new BaseException(1023, strTt);
                                                                    }
                                                                    throw new BaseException(1011, strTt);
                                                                }
                                                                throw new BaseException(1067, strTt);
                                                            }
                                                            throw new BaseException(1066, strTt);
                                                        }
                                                        throw new BaseException(1065, strTt);
                                                    }
                                                    throw new BaseException(1064, strTt);
                                                }
                                                throw new BaseException(1063, strTt);
                                            }
                                            throw new BaseException(1062, strTt);
                                        }
                                        throw new BaseException(1061, strTt);
                                    }
                                    throw new BaseException(1060, strTt);
                                }
                                throw new BaseException(1059, strTt);
                            }
                            throw new BaseException(1048, strTt);
                        }
                        throw new BaseException(1058, strTt);
                    }
                    throw new BaseException(1057, strTt);
                }
                throw new BaseException(1056, strTt);
            }
            throw new BaseException(1055, strTt);
        }
        throw new BaseException(1041, strTt);
    }

    public static boolean c(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static <K> HashMap<Integer, K> c(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> map = new HashMap<>();
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = sparseArray.keyAt(i2);
            map.put(Integer.valueOf(iKeyAt), sparseArray.valueAt(i2));
        }
        return map;
    }

    public static <K> void c(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean c(List<com.byazt.t.ve> list, List<com.byazt.t.ve> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void c(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        }
    }

    public static void c(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        }
    }

    public static String c(String str, int i2) {
        if (i2 == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static String c(String str, com.byazt.k.c cVar) {
        JSONObject jSONObjectUj;
        String str2;
        if (cVar == null || (jSONObjectUj = cVar.uj("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectUj.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith(WVNativeCallbackUtil.SEPERATER)) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    private static String c(File file, boolean z) {
        Context contextIc = com.byazt.zz.ve.ic();
        if (c(file)) {
            return file.getAbsolutePath();
        }
        int i2 = contextIc.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
            if (com.byazt.k.c.ve().tt("fix_save_external_dir") <= 0) {
                File fileC = com.byazt.nys.tt.c(contextIc, Environment.DIRECTORY_DOWNLOADS);
                if (c(fileC)) {
                    return fileC.getAbsolutePath();
                }
            }
        } else {
            if (z) {
                File fileSp = sp();
                if (c(fileSp)) {
                    return fileSp.getAbsolutePath();
                }
            }
            if (com.byazt.k.c.ve().tt("fix_save_external_dir") <= 0) {
                File fileC2 = com.byazt.nys.tt.c(contextIc, Environment.DIRECTORY_DOWNLOADS);
                if (c(fileC2)) {
                    return fileC2.getAbsolutePath();
                }
            }
        }
        return com.byazt.nys.tt.c(contextIc).getAbsolutePath();
    }

    public static boolean c(File file) {
        if (file == null) {
            return false;
        }
        try {
            return (file.exists() || file.mkdirs()) && file.isDirectory();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void c(List<com.byazt.t.ve> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.byazt.t.ve("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static int c(Object obj, int i2) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i2;
        }
    }

    public static String c(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean c(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }
}
