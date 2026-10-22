package com.baidu.location.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.y.l;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.c.k;
import com.hjq.permissions.Permission;
import com.igexin.assist.util.AssistUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h {
    public static float A = 2.3f;
    public static float B = 3.8f;
    public static int C = 3;
    public static int D = 10;
    public static int E = 2;
    public static int F = 7;
    public static int G = 20;
    public static int H = 70;
    public static int I = 120;
    public static float J = 2.0f;
    public static float K = 10.0f;
    public static float L = 50.0f;
    public static float M = 200.0f;
    public static int N = 16;
    public static int O = 32;
    public static float P = 0.9f;
    public static int Q = 10000;
    public static float R = 0.5f;
    public static float S = 0.0f;
    public static float T = 0.1f;
    public static int U = 30;
    public static int V = 100;
    public static int W = 0;
    public static int X = 0;
    public static int Y = 0;
    public static int Z = 420000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f26475a = false;
    public static float aA = 0.75f;
    public static double aB = -0.10000000149011612d;
    public static int aC = 0;
    public static int aD = 0;
    public static int aE = 1;
    public static int aF = 1;
    public static int aG = 0;
    public static float aH = 0.8f;
    public static float aI = 0.2f;
    public static int aJ = 0;
    public static int[] aK = null;
    public static boolean aL = false;
    public static int aM = 8;
    public static int aN = 4000;
    public static int aO = 1;
    public static boolean aP = false;
    public static int aQ = -1;
    public static int aR = 10;
    public static int aS = 3;
    public static int aT = 40;
    public static double[] aU = null;
    public static int aV = 1;
    public static int aW = 1;
    public static int aX = 1;
    public static boolean aa = true;
    public static boolean ab = true;
    public static int ac = 20;
    public static int ad = 300;
    public static int ae = 1000;
    public static int af = Integer.MAX_VALUE;
    public static long ag = 900000;
    public static long ah = 420000;
    public static long ai = 180000;
    public static long aj = 0;
    public static long ak = 15;
    public static long al = 300000;
    public static int am = 1000;
    public static int an = 0;
    public static int ao = 30000;
    public static int ap = 30000;
    public static float aq = 10.0f;
    public static float ar = 6.0f;
    public static float as = 10.0f;
    public static int at = 60;
    public static int au = 70;
    public static int av = 6;
    public static String aw = null;
    public static boolean ax = false;
    public static int ay = 16;
    public static int az = 15;
    public static boolean b = false;
    public static boolean c = false;
    public static int d = 0;
    public static String e = "no";
    public static int f = 4;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static String m = "gcj02";
    public static String n = "";
    public static boolean o = true;
    public static int p = 3;
    public static double q = 0.0d;
    public static double r = 0.0d;
    public static double s = 0.0d;
    public static double t = 0.0d;
    public static int u = 0;
    public static byte[] v = null;
    public static boolean w = false;
    public static int x = 0;
    public static float y = 1.1f;
    public static float z = 2.2f;
    private static String bd = Build.MANUFACTURER;
    public static boolean aY = false;
    public static String aZ = null;
    public static int ba = -1;
    public static String bb = null;
    public static String bc = null;

    public static double a(double d2, double d3, double d4, double d5) {
        float[] fArr = new float[1];
        Location.distanceBetween(d2, d3, d4, d5, fArr);
        return fArr[0];
    }

    public static int a(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Exception unused) {
            return 2;
        }
    }

    public static int a(Context context, String str) {
        return !(context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) ? 0 : 1;
    }

    public static int a(Object obj, String str) throws Exception {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, null);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, null)).intValue();
    }

    public static int a(String str, String str2, String str3) {
        int iIndexOf;
        int length;
        int iIndexOf2;
        String strSubstring;
        if (str != null && !str.equals("") && (iIndexOf = str.indexOf(str2)) != -1 && (iIndexOf2 = str.indexOf(str3, (length = iIndexOf + str2.length()))) != -1 && (strSubstring = str.substring(length, iIndexOf2)) != null && !strSubstring.equals("")) {
            try {
                return Integer.parseInt(strSubstring);
            } catch (NumberFormatException unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i2), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    public static String a(com.baidu.location.c.a aVar, k kVar, Location location, String str, int i2) {
        return a(aVar, kVar, location, str, i2, false);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00c9 A[Catch: Exception -> 0x00cc, TRY_LEAVE, TryCatch #0 {Exception -> 0x00cc, blocks: (B:40:0x008a, B:44:0x00a8, B:47:0x00ae, B:48:0x00b1, B:53:0x00bd, B:55:0x00c1, B:57:0x00c5, B:58:0x00c9), top: B:62:0x008a }] */
    public static String a(com.baidu.location.c.a aVar, k kVar, Location location, String str, int i2, boolean z2) {
        String strB;
        StringBuffer stringBuffer = new StringBuffer(2048);
        if (aVar != null && (strB = com.baidu.location.c.f.a().b(aVar)) != null) {
            stringBuffer.append(strB);
        }
        if (kVar != null) {
            String strA = com.baidu.location.c.f.a().a(i2 == 0 ? N : az, true, kVar, ay);
            if (strA != null) {
                stringBuffer.append(strA);
            }
        }
        if (location != null) {
            String strB2 = (d == 0 || i2 == 0) ? com.baidu.location.c.d.b(location) : com.baidu.location.c.d.c(location);
            if (strB2 != null) {
                stringBuffer.append(strB2);
            }
        }
        String strA2 = b.a().a(i2 == 0);
        if (strA2 != null) {
            stringBuffer.append(strA2);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(com.baidu.location.c.d.a().m());
        String strA3 = com.baidu.location.c.f.a().a(aVar);
        if (strA3 != null && strA3.length() + stringBuffer.length() < 2000) {
            stringBuffer.append(strA3);
        }
        String string = stringBuffer.toString();
        if (location == null || kVar == null) {
            p = 3;
        } else {
            try {
                float speed = location.getSpeed();
                int i3 = d;
                int iA = com.baidu.location.c.f.a().a(kVar);
                int iA2 = kVar.a();
                boolean z3 = kVar.d;
                if (speed < ar && ((i3 == 1 || i3 == 0) && (iA < at || z3))) {
                    p = 1;
                } else if (speed >= as || (!(i3 == 1 || i3 == 0 || i3 == 3) || (iA >= au && iA2 <= av))) {
                    p = 3;
                } else {
                    p = 2;
                }
            } catch (Exception unused) {
                p = 3;
            }
        }
        return string;
    }

    public static String a(String str) {
        return Jni.en1(n + l.b + str);
    }

    public static String a(byte[] bArr, String str, boolean z2) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z2) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String a(byte[] bArr, boolean z2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z2);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean a(double d2, double d3) {
        return Math.abs(d2 - d3) <= 1.192092896E-7d;
    }

    public static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) <= 1.1920929E-7f;
    }

    public static boolean a(Location location) {
        String str;
        if (location == null || (str = bd) == null || !AssistUtils.BRAND_HW.equalsIgnoreCase(str)) {
            return false;
        }
        try {
            Bundle extras = location.getExtras();
            return extras != null && (extras.getInt("SourceType") & 128) == 128;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }

    public static boolean a(int[] iArr) {
        if (iArr != null && iArr.length >= 18) {
            for (int i2 : iArr) {
                if (i2 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int b(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode", -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String b(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                if (TextUtils.isEmpty(line)) {
                    return null;
                }
                return line;
            } catch (Exception unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean b() {
        return false;
    }

    public static boolean b(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static byte[] b(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        IOException e2;
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                try {
                    try {
                        byte[] bArr2 = new byte[2048];
                        while (true) {
                            int i2 = gZIPInputStream.read(bArr2);
                            if (i2 < 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, i2);
                        }
                        gZIPInputStream.close();
                    } catch (IOException e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        } catch (IOException e6) {
            gZIPInputStream = null;
            e2 = e6;
        } catch (Throwable th3) {
            gZIPInputStream = null;
            th = th3;
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static long c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime() / 1000;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet6Address) && inetAddressNextElement.getHostAddress() != null && !inetAddressNextElement.getHostAddress().startsWith("fe80:")) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean c(Context context) {
        int iA;
        if (context == null) {
            return true;
        }
        try {
            iA = a(context, "android.permission.ACCESS_COARSE_LOCATION");
        } catch (Exception e2) {
            e2.printStackTrace();
            iA = 1;
        }
        boolean z2 = iA == 1;
        if (z2) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 1) == 0) {
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        return z2;
    }

    public static String d() {
        return d.k;
    }

    public static String d(Context context) {
        int iA = a(context, "android.permission.ACCESS_COARSE_LOCATION");
        int iA2 = a(context, "android.permission.ACCESS_FINE_LOCATION");
        int iA3 = a(context, "android.permission.READ_PHONE_STATE");
        if (Build.VERSION.SDK_INT < 29) {
            return "&per=" + iA + "|" + iA2 + "|" + iA3;
        }
        return "&per=" + iA + "|" + iA2 + "|" + iA3 + "|" + a(context, Permission.ACCESS_BACKGROUND_LOCATION);
    }

    public static String d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("enc3")) {
                return new String(b(Base64.decode(jSONObject.optString("enc3").getBytes(), 0)), "UTF-8");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    public static String e() {
        String path;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    path = Environment.getExternalStorageDirectory().getPath();
                } else {
                    path = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            path = null;
        }
        if (path == null && Build.VERSION.SDK_INT > 28 && com.baidu.location.f.getServiceContext() != null) {
            try {
                path = com.baidu.location.f.getServiceContext().getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath();
            } catch (Exception unused) {
                path = null;
            }
        }
        if (path != null) {
            try {
                File file = new File(path + "/baidu/tempdata");
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return path;
    }

    public static String e(Context context) {
        int type = -1;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    type = activeNetworkInfo.getType();
                }
            } catch (Throwable unused) {
            }
        }
        return "&netc=" + type;
    }

    public static String f() {
        String strE = e();
        if (strE == null) {
            return null;
        }
        return strE + "/baidu/tempdata";
    }

    public static String f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int g(Context context) {
        int iA = a(context, "android.permission.ACCESS_FINE_LOCATION") | a(context, "android.permission.ACCESS_COARSE_LOCATION");
        if (b(context) != 0 && iA == 1) {
            return 1;
        }
        if (b(context) == 0 || iA == 1) {
            return (b(context) >= 1 || iA != 1) ? 0 : -1;
        }
        return -2;
    }

    public static String g() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String h() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return com.baidu.location.f.getServiceContext().getFilesDir().getPath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 31 && a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 && a(context, "android.permission.ACCESS_COARSE_LOCATION") == 1;
    }

    public static String i() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(com.baidu.location.f.getServiceContext().getFilesDir());
            String str = File.separator;
            sb.append(str);
            sb.append("/baidu/tempdata");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return com.baidu.location.f.getServiceContext().getFilesDir().getPath() + str + "/baidu/tempdata";
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean i(Context context) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 29) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                return activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String j() {
        return b("ro.mediatek.platform");
    }

    public static SSLSocketFactory k() throws Exception {
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.baidu.location.e.h.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                for (X509Certificate x509Certificate : x509CertificateArr) {
                    x509Certificate.checkValidity();
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerArr, new SecureRandom());
        return sSLContext.getSocketFactory();
    }
}
