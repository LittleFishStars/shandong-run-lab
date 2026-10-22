package com.autonavi.aps.amapapi.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import androidx.core.view.MotionEventCompat;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.amap.api.col.p0003l.fj;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.zj.adlib.j4b;
import com.zj.adlib.m4b;
import com.zj.adlib.s4b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static WifiManager f26207a;
    private static int b;
    private static String[] c;
    private static String d;

    public static float a(float f) {
        return (float) (((long) (((double) f) * 100.0d)) / 100.0d);
    }

    public static String a(int i) {
        if (i == 33) {
            return "补偿定位失败，未命中缓存";
        }
        switch (i) {
            case 0:
                return "success";
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case 8:
                return "其他错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case 12:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
            default:
                switch (i) {
                    case 18:
                        return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
                    case 19:
                        return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
                    case 20:
                        return "模糊定位失败，具体可查看错误信息/详细信息描述";
                    default:
                        return "其他错误";
                }
        }
    }

    public static boolean a(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar == null || PrepareException.ERROR_AUTH_FAIL.equals(aVar.d()) || "5".equals(aVar.d()) || "6".equals(aVar.d())) {
            return false;
        }
        return b(aVar);
    }

    public static double b(double d2) {
        return ((long) (d2 * 1000000.0d)) / 1000000.0d;
    }

    public static boolean b(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == AudioStats.AUDIO_AMPLITUDE_NONE && latitude == AudioStats.AUDIO_AMPLITUDE_NONE) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    public static double c(double d2) {
        return ((long) (d2 * 100.0d)) / 100.0d;
    }

    public static int c() {
        int i = b;
        if (i > 0) {
            return i;
        }
        try {
            try {
                return e.b("android.os.Build$VERSION", "SDK_INT");
            } catch (Throwable unused) {
                return 0;
            }
        } catch (Throwable unused2) {
            return Integer.parseInt(e.a("android.os.Build$VERSION", "SDK").toString());
        }
    }

    private static boolean d(Context context, String str) throws Throwable {
        return ((Integer) e.a(str, "getInt", new Object[]{context.getContentResolver(), ((String) e.a(str, "AIRPLANE_MODE_ON")).toString()}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static String e() {
        try {
            return m4b.f("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean f(Context context) {
        int iB;
        if (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
            return true;
        }
        try {
            iB = e.b(((Application) context).getBaseContext(), "checkSelfPermission", com.autonavi.aps.amapapi.b.G);
        } catch (Throwable unused) {
            iB = 0;
        }
        return iB == 0;
    }

    @SuppressLint({"NewApi"})
    public static boolean g(Context context) {
        boolean zIsWifiEnabled;
        if (context == null) {
            return true;
        }
        if (f26207a == null) {
            f26207a = (WifiManager) a(context, "wifi");
        }
        try {
            if (c(context, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                zIsWifiEnabled = f26207a.isWifiEnabled();
            } else {
                b.a(new Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");
                zIsWifiEnabled = false;
            }
        } catch (Throwable unused) {
        }
        if (zIsWifiEnabled || c() <= 17) {
            return zIsWifiEnabled;
        }
        try {
            return "true".equals(String.valueOf(e.a(f26207a, "isScanAlwaysAvailable", new Object[0])));
        } catch (Throwable unused2) {
            return zIsWifiEnabled;
        }
    }

    public static String h(Context context) {
        NetworkInfo networkInfoC = c(context);
        if (networkInfoC == null || !networkInfoC.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = networkInfoC.getType();
        if (type == 1) {
            return NetworkUtil.NETWORK_TYPE_WIFI;
        }
        if (type != 0) {
            return "UNKNOWN";
        }
        String subtypeName = networkInfoC.getSubtypeName();
        switch (networkInfoC.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkUtil.NETWORK_TYPE_3G;
            case 13:
                return NetworkUtil.NETWORK_TYPE_4G;
            default:
                if (!"GSM".equalsIgnoreCase(subtypeName)) {
                    return ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) ? NetworkUtil.NETWORK_TYPE_3G : subtypeName;
                }
                break;
        }
        return NetworkUtil.NETWORK_TYPE_2G;
    }

    public static String i(Context context) {
        String strG = fj.G();
        if (TextUtils.isEmpty(strG) || strG.equals(com.alipay.sdk.m.y.d.f25528a)) {
            strG = h.a(context);
        }
        return TextUtils.isEmpty(strG) ? com.alipay.sdk.m.y.d.f25528a : strG;
    }

    public static boolean j(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static boolean k(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }

    public static String l(Context context) {
        if (d == null) {
            d = com.autonavi.aps.amapapi.security.a.a("MD5", j4b.g(context));
        }
        return d;
    }

    public static boolean m(Context context) {
        try {
            return o(context) || n(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean n(Context context) {
        return h("vivo") && p(context) && q(context);
    }

    private static boolean o(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 31 && context != null && context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean p(Context context) {
        try {
            int i = Build.VERSION.SDK_INT;
            int i2 = context.getApplicationInfo().targetSdkVersion;
            return ((i == 30) && (i2 >= 23)) || ((i == 31) && (i2 <= 30 && i2 >= 23));
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean q(Context context) {
        Cursor cursorQuery;
        boolean z;
        boolean z2 = false;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, "package_name=?", new String[]{context.getPackageName()}, null);
            z = false;
            while (cursorQuery != null) {
                try {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    if (cursorQuery.getString(0) != null && cursorQuery.getInt(1) == 1) {
                        z = true;
                    }
                } catch (Throwable unused) {
                    z2 = z;
                    z = z2;
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return z;
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(b.j)) {
            return b.j;
        }
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(j4b.g(context), 64);
        } catch (Throwable th) {
            b.a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(b.k)) {
                b.k = null;
            }
        } catch (Throwable th2) {
            b.a(th2, "Utils", "getAppName");
        }
        StringBuilder sb = new StringBuilder();
        if (packageInfo != null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            CharSequence charSequenceLoadLabel = applicationInfo != null ? applicationInfo.loadLabel(context.getPackageManager()) : null;
            if (charSequenceLoadLabel != null) {
                sb.append(charSequenceLoadLabel.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        String strG = j4b.g(context);
        if (!TextUtils.isEmpty(strG)) {
            sb.append(",");
            sb.append(strG);
        }
        if (!TextUtils.isEmpty(b.k)) {
            sb.append(",");
            sb.append(b.k);
        }
        String string = sb.toString();
        b.j = string;
        return string;
    }

    public static boolean e(Context context) {
        int iB;
        if (context.getApplicationInfo().targetSdkVersion >= 23) {
            Application application = (Application) context;
            for (String str : com.autonavi.aps.amapapi.b.F) {
                try {
                    iB = e.b(application.getBaseContext(), "checkSelfPermission", str);
                } catch (Throwable unused) {
                    iB = 0;
                }
                if (iB != 0) {
                    return false;
                }
            }
        } else {
            for (String str2 : com.autonavi.aps.amapapi.b.F) {
                if (context.checkCallingOrSelfPermission(str2) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return b(aMapLocation);
        }
        return false;
    }

    public static NetworkInfo c(Context context) {
        try {
            return fj.Z(context);
        } catch (Throwable th) {
            b.a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    public static int f(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    public static String[] a(TelephonyManager telephonyManager) {
        int i;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr2[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            b.a(th, "Utils", "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return ("0".equals(strArr2[0]) && "0".equals(strArr2[1]) && (strArr = c) != null) ? strArr : strArr2;
        }
        c = strArr2;
        return strArr2;
    }

    public static double c(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    private static FileOutputStream c(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.canWrite()) {
                    throw new IOException("File '" + file + "' cannot be written to");
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IOException("Directory '" + parentFile + "' could not be created");
                }
                file.createNewFile();
            }
        }
        return new FileOutputStream(file, false);
    }

    public static int d() {
        return new Random().nextInt(65536) - 32768;
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo networkInfoC = c(context);
            return networkInfoC != null && networkInfoC.isConnectedOrConnecting();
        } catch (Throwable unused) {
        }
    }

    public static byte g(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    private static boolean h(String str) {
        try {
            return Build.MANUFACTURER.equalsIgnoreCase(str) || Build.BRAND.toLowerCase().contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static float d(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static int e(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            return context.checkSelfPermission(s4b.v(str)) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (c() < 17) {
                return d(context, "android.provider.Settings$System");
            }
            return d(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte[] b(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    public static float a(double[] dArr) {
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static int b(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            i |= (bArr[i2] & 255) << ((1 - i2) * 8);
        }
        return i;
    }

    public static float a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static ArrayList<String> b(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("#");
            for (int i = 0; i < strArrSplit.length; i++) {
                if (strArrSplit[i].contains(",nb") || strArrSplit[i].contains(",access")) {
                    arrayList.add(strArrSplit[i]);
                }
            }
        }
        return arrayList;
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        return a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private static FileInputStream b(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return new FileInputStream(file);
                }
                throw new IOException("File '" + file + "' cannot be read");
            }
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    public static Object a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            b.a(th, "Utils", "getServ");
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        return s4b.u(bArr);
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return s4b.n(jSONObject, str);
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || com.alipay.sdk.m.y.d.f25528a.equals(str) || "02:00:00:00:00:00".equals(str) || str.contains(" :")) ? false : true;
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static String a(Context context, TelephonyManager telephonyManager) {
        int networkType = 0;
        if (telephonyManager != null) {
            try {
                if (context.getApplicationInfo().targetSdkVersion < 29 && Build.VERSION.SDK_INT < 30) {
                    networkType = telephonyManager.getNetworkType();
                }
            } catch (Throwable unused) {
            }
        }
        switch (networkType) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((j >> (i * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] a(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return bArr;
    }

    public static String a(long j, String str) {
        SimpleDateFormat simpleDateFormat;
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat2 = null;
        try {
            simpleDateFormat = new SimpleDateFormat(str, Locale.CHINA);
            try {
                simpleDateFormat.applyPattern(str);
            } catch (Throwable th) {
                th = th;
                simpleDateFormat2 = simpleDateFormat;
                b.a(th, "Utils", "formatUTC");
                simpleDateFormat = simpleDateFormat2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (j <= 0) {
            j = a();
        }
        return simpleDateFormat == null ? "NULL" : simpleDateFormat.format(Long.valueOf(j));
    }

    public static double a(double d2) {
        return b(d2);
    }

    public static boolean a(Location location, int i) {
        boolean zIsFromMockProvider;
        try {
            zIsFromMockProvider = location.isFromMockProvider();
        } catch (Throwable unused) {
            zIsFromMockProvider = false;
        }
        if (zIsFromMockProvider) {
            return true;
        }
        try {
            Bundle extras = location.getExtras();
            if ((extras != null ? extras.getInt("satellites") : 0) <= 0) {
                return true;
            }
            if (i == 0 && location.getAltitude() == AudioStats.AUDIO_AMPLITUDE_NONE && location.getBearing() == 0.0f && location.getSpeed() == 0.0f) {
                return true;
            }
        } catch (Throwable unused2) {
        }
        return false;
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strReplace = "2.0.201501131131".replace(Consts.DOT, "");
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    cursorQuery = sQLiteDatabase.query("sqlite_master", new String[]{"count(*) as c"}, "type = 'table' AND name = '" + str.trim() + strReplace + "'", null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst() && cursorQuery.getInt(0) > 0) {
                                z = true;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return z;
                }
            } catch (Throwable unused2) {
                cursorQuery = null;
            }
            if (cursorQuery == null) {
                return true;
            }
            cursorQuery.close();
            return true;
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList<String> arrayListB = b(str);
            String[] strArrSplit = str2.toString().split("#");
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                if (strArrSplit[i3].contains(",nb") || strArrSplit[i3].contains(",access")) {
                    i++;
                    if (arrayListB.contains(strArrSplit[i3])) {
                        i2++;
                    }
                }
            }
            if (i2 * 2 >= ((double) (arrayListB.size() + i)) * 0.618d) {
                return true;
            }
        }
        return false;
    }

    public static List<String> a(File file) {
        FileInputStream fileInputStreamB;
        InputStreamReader inputStreamReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStreamB = b(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStreamB, Charset.defaultCharset());
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                arrayList.add(line);
                            } catch (Throwable unused) {
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (fileInputStreamB != null) {
                                    fileInputStreamB.close();
                                }
                            }
                        }
                        bufferedReader2.close();
                        inputStreamReader.close();
                        if (fileInputStreamB != null) {
                            fileInputStreamB.close();
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    inputStreamReader = null;
                }
            } catch (Throwable unused4) {
                fileInputStreamB = null;
                inputStreamReader = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void a(File file, String str) {
        FileOutputStream fileOutputStreamC = null;
        try {
            fileOutputStreamC = c(file);
            if (str != null) {
                fileOutputStreamC.write(str.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStreamC != null) {
                try {
                    fileOutputStreamC.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
