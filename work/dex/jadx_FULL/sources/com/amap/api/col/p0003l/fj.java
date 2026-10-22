package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.ali.auth.third.login.LoginConstants;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import com.zj.adlib.m4b;
import com.zj.adlib.p4b;
import com.zj.adlib.r8b;
import com.zj.adlib.s4b;
import com.zj.adlib.s6b;
import com.zj.adlib.t6b;
import com.zj.adlib.v6b;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class fj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f25947a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static long f871a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static a f872a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile b f873a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f874a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile boolean f875a = true;
    public static int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static String f876b = "";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f877b = false;
    public static int c = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static String f878c = "";

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static boolean f879c = false;
    public static int d = -1;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static String f880d = null;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static boolean f881d = false;
    public static String e = "";

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static volatile boolean f882e = false;
    public static String f = "";

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static boolean f883f = false;
    public static String g = "";

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static boolean f884g = false;
    public static String h = "";

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static boolean f885h = false;
    public static String i = "";

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static boolean f886i = false;
    public static String j = "";

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static boolean f887j = false;
    public static String k = "";

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static boolean f888k = false;
    public static String l = "";

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public static boolean f889l = false;
    public static String m = "";

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public static boolean f890m = false;
    public static String n = "";

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public static boolean f891n = false;
    public static String o = "";

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    public static boolean f892o = false;
    public static String p = null;

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    public static boolean f893p = false;
    public static String q = "";

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    public static boolean f894q = true;
    public static String r = "";

    /* JADX INFO: renamed from: r, reason: collision with other field name */
    public static boolean f895r = false;
    public static boolean s = false;
    public static boolean t = false;
    public static boolean u = false;

    public interface a {
        hs a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String b(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static BroadcastReceiver f25948a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static Context f896a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static ConnectivityManager.NetworkCallback f897a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static ConnectivityManager f898a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static NetworkRequest f899a;

        /* JADX INFO: renamed from: com.amap.api.col.3l.fj$b$1, reason: invalid class name */
        public class AnonymousClass1 extends BroadcastReceiver {
            public AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (s4b.v("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    fj.U();
                }
            }
        }

        public class a extends ConnectivityManager.NetworkCallback {
            public a() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                super.onAvailable(network);
                fj.U();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                fj.U();
            }
        }

        @SuppressLint({"WrongConstant"})
        public final void a(Context context) {
            if (fj.C(context, s4b.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f898a == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f898a = connectivityManager;
                if (connectivityManager != null) {
                    f899a = new NetworkRequest.Builder().addCapability(0).addCapability(1).build();
                    a aVar = new a();
                    f897a = aVar;
                    f898a.registerNetworkCallback(f899a, aVar);
                    f896a = context;
                }
            }
        }
    }

    public static class c extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25951a;

        public c(Context context) {
            this.f25951a = context;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            try {
                Map<String, String> mapB = fj.f872a.b();
                String strB = fj.f872a.b(fj.N(this.f25951a), "", "", fj.h0(this.f25951a));
                if (TextUtils.isEmpty(strB)) {
                    return;
                }
                hl.b();
                String strA = fj.f872a.a(this.f25951a, new String(hl.e(fj.f872a.a(strB.getBytes(), mapB)).f17171a));
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                fj.f876b = strA;
            } catch (Throwable unused) {
            }
        }
    }

    public static class d extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25952a;

        public d(Context context) {
            this.f25952a = context;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            fj.e(this.f25952a);
            fj.W();
        }
    }

    public static class e implements ServiceConnection {
        public static String f;
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f25953a;

        public e(Context context, int i) {
            this.f25953a = context;
            this.K = i;
        }

        public final String a() {
            try {
                if (!TextUtils.isEmpty(f)) {
                    return f;
                }
                byte[] bArrDigest = MessageDigest.getInstance(s4b.v("IU0hBMQ")).digest(this.f25953a.getPackageManager().getPackageInfo(this.f25953a.getPackageName(), 64).signatures[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b : bArrDigest) {
                    stringBuffer.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                }
                String string = stringBuffer.toString();
                if (!TextUtils.isEmpty(string)) {
                    f = string;
                }
                return string;
            } catch (Throwable unused) {
                return "";
            }
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0050 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #0 {all -> 0x0064, blocks: (B:3:0x0008, B:15:0x0050, B:10:0x0017, B:11:0x003a, B:12:0x0044), top: B:25:0x0008 }] */
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean z;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                int i = this.K;
                if (i == 2) {
                    parcelObtain.writeInterfaceToken(s4b.v("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"));
                } else {
                    if (i != 4) {
                        if (i != 5) {
                            z = false;
                        } else {
                            parcelObtain.writeInterfaceToken(s4b.v("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));
                            parcelObtain.writeString(this.f25953a.getPackageName());
                            parcelObtain.writeString(a());
                            parcelObtain.writeString(s4b.v("IT1VJRA"));
                        }
                        if (z) {
                            iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                            parcelObtain2.readException();
                            String unused = fj.e = parcelObtain2.readString();
                        }
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                    parcelObtain.writeInterfaceToken(s4b.v("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"));
                }
                z = true;
                if (z) {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    String unused2 = fj.e = parcelObtain2.readString();
                }
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th) {
                try {
                    v6b.b(th, "oac", String.valueOf(this.K));
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String A(Context context) {
        try {
            return i(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean C(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static a D() {
        return f872a;
    }

    public static String E(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String strH0 = h0(context);
            if (strH0 != null && strH0.length() >= 5) {
                return strH0.substring(3, 5);
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int F(Context context) {
        try {
            return l(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String G() {
        return h;
    }

    public static int H(Context context) {
        try {
            return j(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String[] I() {
        return new String[]{"", ""};
    }

    public static String J() {
        return m;
    }

    public static String K(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String L() {
        return k;
    }

    public static String M(Context context) {
        try {
            if (f883f) {
                return "";
            }
            if (TextUtils.isEmpty(e) && !f884g) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    z.g().b(new d(context));
                    return e;
                }
                f884g = true;
                return e(context);
            }
            return e;
        } catch (Throwable unused) {
        }
    }

    public static String N(Context context) {
        if (f885h) {
            String str = f874a;
            return str == null ? "" : str;
        }
        try {
            String str2 = f874a;
            if (str2 != null && !"".equals(str2)) {
                return f874a;
            }
            if (C(context, s4b.v("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
                f874a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (!TextUtils.isEmpty(f874a)) {
                f885h = true;
                return f874a;
            }
            try {
                String strA = a(context);
                f874a = strA;
                if (!TextUtils.isEmpty(strA)) {
                    f885h = true;
                    return f874a;
                }
            } catch (Throwable unused) {
            }
            try {
                f874a = b(context);
                f885h = true;
            } catch (Throwable unused2) {
            }
            String str3 = f874a;
            return str3 == null ? "" : str3;
        } catch (Throwable unused3) {
        }
    }

    public static void O() {
        try {
            t6b.a();
        } catch (Throwable unused) {
        }
    }

    public static long P() {
        long j2 = f871a;
        if (j2 != 0) {
            return j2;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            f871a = ((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576) + ((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576);
        } catch (Throwable unused) {
        }
        return f871a;
    }

    public static String Q(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if (TextUtils.isEmpty(g) && !f886i) {
            if (!C(context, s4b.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return "";
            }
            try {
                String str = (String) s4b.h(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
                f886i = true;
                return str;
            } catch (Throwable unused) {
                String str2 = g;
                return str2 == null ? "" : str2;
            }
        }
        return g;
    }

    public static String R() {
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        String property = System.getProperty("os.arch");
        p = property;
        return property;
    }

    public static String S(Context context) {
        if (TextUtils.isEmpty(f) && !f887j) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), s4b.v(new String(s6b.c(13))));
                f = string;
                f887j = true;
                return string == null ? "" : string;
            } catch (Throwable unused) {
                return f;
            }
        }
        return f;
    }

    public static String T(Context context) {
        try {
            TelephonyManager telephonyManagerM = m(context);
            if (telephonyManagerM == null) {
                return "";
            }
            String networkOperator = telephonyManagerM.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                return networkOperator.substring(0, 3);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void U() {
        c = -1;
        t = false;
        d = -1;
        u = false;
        r = "";
        s = false;
        i = "";
        f889l = false;
    }

    public static String V(Context context) {
        if (f889l) {
            return i;
        }
        try {
            r(context);
            TelephonyManager telephonyManagerM = m(context);
            if (telephonyManagerM == null) {
                return i;
            }
            String networkOperator = telephonyManagerM.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                i = networkOperator.substring(3);
                f889l = true;
                return i;
            }
            f889l = true;
            return i;
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ boolean W() {
        f884g = true;
        return true;
    }

    public static int X(Context context) {
        try {
            return l(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int Y(Context context) {
        try {
            return j(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static NetworkInfo Z(Context context) {
        ConnectivityManager connectivityManagerK;
        if (C(context, s4b.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (connectivityManagerK = k(context)) != null) {
            return connectivityManagerK.getActiveNetworkInfo();
        }
        return null;
    }

    public static String a(Context context) {
        try {
            String strO = r8b.o(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(strO) ? r8b.o(context, "Alvin2", "UTDID", "") : strO;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a0(Context context) {
        try {
            NetworkInfo networkInfoZ = Z(context);
            if (networkInfoZ == null) {
                return null;
            }
            return networkInfoZ.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (s4b.m(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    xmlPullParserNewPullParser.setInput(fileInputStream2, "utf-8");
                    boolean z = false;
                    for (int eventType = xmlPullParserNewPullParser.getEventType(); 1 != eventType; eventType = xmlPullParserNewPullParser.next()) {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                z = false;
                            } else if (eventType == 4 && z) {
                                String text = xmlPullParserNewPullParser.getText();
                                try {
                                    fileInputStream2.close();
                                } catch (Throwable unused) {
                                }
                                return text;
                            }
                        } else if (xmlPullParserNewPullParser.getAttributeCount() > 0) {
                            int attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                            for (int i2 = 0; i2 < attributeCount; i2++) {
                                String attributeValue = xmlPullParserNewPullParser.getAttributeValue(i2);
                                if ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) {
                                    z = true;
                                }
                            }
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream == null) {
                        return "";
                    }
                }
            }
            if (fileInputStream == null) {
                return "";
            }
        } catch (Throwable unused3) {
        }
        try {
            fileInputStream.close();
            return "";
        } catch (Throwable unused4) {
            return "";
        }
    }

    public static String b0(Context context) {
        StringBuilder sb;
        try {
            String str = j;
            if (str != null && !"".equals(str)) {
                return j;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i3 > i2) {
                sb = new StringBuilder();
                sb.append(i2);
                sb.append("*");
                sb.append(i3);
            } else {
                sb = new StringBuilder();
                sb.append(i3);
                sb.append("*");
                sb.append(i2);
            }
            j = sb.toString();
            return j;
        } catch (Throwable unused) {
        }
    }

    public static String c(Context context) {
        try {
            Class<?> cls = Class.forName(s4b.v("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object objInvoke = cls.getMethod(s4b.v("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (objInvoke != null) {
                String str = (String) objInvoke;
                e = str;
                return str;
            }
        } catch (Throwable th) {
            v6b.b(th, "oa", "xm");
            f883f = true;
        }
        return e;
    }

    public static String c0(Context context) {
        try {
            if (!C(context, s4b.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return q;
            }
            TelephonyManager telephonyManagerM = m(context);
            return telephonyManagerM == null ? "" : telephonyManagerM.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse(s4b.v("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    int columnCount = cursorQuery.getColumnCount();
                    for (int i2 = 0; i2 < columnCount; i2++) {
                        if (s4b.v("IdmFsdWU").equals(cursorQuery.getColumnName(i2))) {
                            e = cursorQuery.getString(i2);
                            break;
                        }
                    }
                }
                cursorQuery.close();
            }
        } catch (Throwable th) {
            f883f = true;
            v6b.b(th, "oa", "vivo");
        }
        return e;
    }

    public static String d0(Context context) {
        ConnectivityManager connectivityManagerK;
        NetworkInfo activeNetworkInfo;
        try {
            return (!C(context, s4b.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (connectivityManagerK = k(context)) == null || (activeNetworkInfo = connectivityManagerK.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String e(Context context) {
        String strV = s4b.v("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!strV.equalsIgnoreCase(str)) {
            String strV2 = s4b.v("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!strV2.equalsIgnoreCase(str2) && !s4b.v("IUkVETUk=").equalsIgnoreCase(str) && !s4b.v("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (s4b.v("Idml2bw").equalsIgnoreCase(str) || s4b.v("Idml2bw").equalsIgnoreCase(str2)) {
                    return d(context);
                }
                if (s4b.v("IaHVhd2Vp").equalsIgnoreCase(str) || s4b.v("IaHVhd2Vp").equalsIgnoreCase(str2) || s4b.v("ISE9OT1I=").equalsIgnoreCase(str)) {
                    return u(context, 2);
                }
                if (s4b.v("Mc2Ftc3VuZw").equalsIgnoreCase(str) || s4b.v("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                    return u(context, 4);
                }
                if (s4b.v("IT1BQTw").equalsIgnoreCase(str) || s4b.v("IT1BQTw").equalsIgnoreCase(str2) || s4b.v("MT25lUGx1cw").equalsIgnoreCase(str) || s4b.v("MT25lUGx1cw").equalsIgnoreCase(str2) || s4b.v("IUkVBTE1F").equalsIgnoreCase(str2)) {
                    return u(context, 5);
                }
                f883f = true;
                return e;
            }
        }
        return c(context);
    }

    public static String e0(Context context) {
        try {
            String strL = L();
            try {
                if (TextUtils.isEmpty(strL)) {
                    strL = t(context);
                }
                if (TextUtils.isEmpty(strL)) {
                    strL = N(context);
                }
                if (TextUtils.isEmpty(strL)) {
                    strL = M(context);
                }
                if (TextUtils.isEmpty(strL)) {
                    strL = S(context);
                }
                return TextUtils.isEmpty(strL) ? f(context) : strL;
            } catch (Throwable unused) {
                return strL;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String f(Context context) {
        if (!TextUtils.isEmpty(o)) {
            return o;
        }
        try {
            String strO = r8b.o(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(strO)) {
                o = "amap" + UUID.randomUUID().toString().replace(LoginConstants.UNDER_LINE, "").toLowerCase();
                SharedPreferences.Editor editorB = r8b.b(context, "open_common");
                r8b.i(editorB, "a1", s4b.r(o));
                r8b.e(editorB);
            } else {
                o = s4b.v(strO);
            }
        } catch (Throwable unused) {
        }
        return o;
    }

    public static String f0(Context context) {
        return L() + "#" + t(context) + "#" + e0(context);
    }

    public static boolean g(Context context) {
        int simState;
        TelephonyManager telephonyManagerM = m(context);
        return (telephonyManagerM == null || (simState = telephonyManagerM.getSimState()) == 0 || simState == 1) ? false : true;
    }

    public static String g0(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String str = l;
            if ((str == null || "".equals(str)) && C(context, s4b.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                TelephonyManager telephonyManagerM = m(context);
                if (telephonyManagerM == null) {
                    return "";
                }
                if (f893p) {
                    return l;
                }
                Method methodH = s4b.h(telephonyManagerM.getClass(), "QZ2V0TWVpZA==", new Class[0]);
                if (methodH != null) {
                    l = (String) methodH.invoke(telephonyManagerM, new Object[0]);
                }
                if (l == null) {
                    l = "";
                }
                f893p = true;
                return l;
            }
            return l;
        } catch (Throwable unused) {
        }
    }

    public static String h(Context context) throws IllegalAccessException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        boolean zG = g(context);
        if (f894q != zG) {
            if (zG) {
                q = "";
                f895r = false;
            }
            f894q = zG;
        }
        String str = q;
        if ((str == null || "".equals(str)) && !f895r) {
            if (!f894q) {
                return "";
            }
            if (!C(context, s4b.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return q;
            }
            TelephonyManager telephonyManagerM = m(context);
            if (telephonyManagerM == null) {
                return "";
            }
            Method methodH = s4b.h(telephonyManagerM.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
            if (methodH != null) {
                q = (String) methodH.invoke(telephonyManagerM, new Object[0]);
            }
            if (q == null) {
                q = "";
            }
            f895r = true;
            return q;
        }
        return q;
    }

    public static String h0(Context context) {
        try {
            return h(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String i(Context context) {
        TelephonyManager telephonyManagerM;
        if (s) {
            return r;
        }
        r(context);
        if (C(context, s4b.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (telephonyManagerM = m(context)) != null) {
            String simOperatorName = telephonyManagerM.getSimOperatorName();
            r = simOperatorName;
            if (TextUtils.isEmpty(simOperatorName)) {
                r = telephonyManagerM.getNetworkOperatorName();
            }
            s = true;
            return r;
        }
        return r;
    }

    public static int i0(Context context) {
        int i2 = b;
        if (i2 != 0) {
            return i2;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        int i3 = ((int) (memoryInfo.totalMem / 1024)) / 1024;
        b = i3;
        return i3;
    }

    public static int j(Context context) {
        if (t) {
            return c;
        }
        r(context);
        if (context == null || !C(context, s4b.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return c;
        }
        ConnectivityManager connectivityManagerK = k(context);
        if (connectivityManagerK == null) {
            return c;
        }
        NetworkInfo activeNetworkInfo = connectivityManagerK.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            t = true;
            return c;
        }
        int type = activeNetworkInfo.getType();
        c = type;
        t = true;
        return type;
    }

    public static String j0(Context context) {
        try {
            return i(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static ConnectivityManager k(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static int l(Context context) {
        TelephonyManager telephonyManagerM;
        if (u) {
            return d;
        }
        r(context);
        if (C(context, s4b.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (telephonyManagerM = m(context)) != null) {
            int networkType = telephonyManagerM.getNetworkType();
            d = networkType;
            u = true;
            return networkType;
        }
        return d;
    }

    public static TelephonyManager m(Context context) {
        return (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
    }

    public static String n(Context context) {
        String strO;
        if (!f875a) {
            return "";
        }
        try {
            strO = o(context);
        } catch (Throwable unused) {
            strO = null;
        }
        if (TextUtils.isEmpty(strO)) {
            f875a = false;
            return "";
        }
        try {
            byte[] bytes = s4b.v("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(m4b.e(s4b.v("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), m4b.g(strO), bytes), "UTF-8");
        } catch (Throwable unused2) {
            f875a = false;
            return "";
        }
    }

    public static String o(Context context) {
        String strP;
        try {
            strP = p(context);
        } catch (Throwable unused) {
            strP = "";
        }
        if (TextUtils.isEmpty(strP)) {
            return context == null ? "" : context.getSharedPreferences(s4b.v("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(p4b.d(s4b.v("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
        }
        return strP;
    }

    public static String p(Context context) {
        RandomAccessFile randomAccessFile;
        String[] strArrSplit;
        if (!C(context, s4b.v("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            return "";
        }
        String strD = p4b.d(s4b.v("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String strQ = q(context);
        if (TextUtils.isEmpty(strQ)) {
            return "";
        }
        File file = new File(strQ + File.separator + s4b.v("KYmFja3Vwcw"), s4b.v("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i2 = randomAccessFile.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, i2);
                        } catch (Throwable unused) {
                            byteArrayOutputStream = byteArrayOutputStream2;
                            w(byteArrayOutputStream);
                        }
                    }
                    String str = new String(byteArrayOutputStream2.toByteArray(), "UTF-8");
                    if (!TextUtils.isEmpty(str) && str.contains(s4b.v("SIw")) && (strArrSplit = str.split(s4b.v("SIw"))) != null && strArrSplit.length == 2 && TextUtils.equals(strD, strArrSplit[0])) {
                        String str2 = strArrSplit[1];
                        w(byteArrayOutputStream2);
                        w(randomAccessFile);
                        return str2;
                    }
                    w(byteArrayOutputStream2);
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                randomAccessFile = null;
            }
            w(randomAccessFile);
        }
        return "";
    }

    public static String q(Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(s4b.v("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(s4b.v("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(s4b.v("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(s4b.v("DaXNSZW1vdmFibGU"), new Class[0]);
            Object objInvoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(objInvoke);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = Array.get(objInvoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static synchronized b r(Context context) {
        if (f873a == null) {
            if (context == null) {
                return null;
            }
            b bVar = new b();
            f873a = bVar;
            bVar.a(context.getApplicationContext());
        }
        return f873a;
    }

    public static String s() {
        return f880d;
    }

    public static String t(Context context) {
        try {
            if (!TextUtils.isEmpty(f876b)) {
                return f876b;
            }
            if (context == null) {
                return "";
            }
            String strN = n(context);
            f876b = strN;
            if (!TextUtils.isEmpty(strN)) {
                return f876b;
            }
            if (D() == null || f882e) {
                return "";
            }
            f882e = true;
            z.g().b(new c(context));
            return "";
        } catch (Throwable unused) {
        }
    }

    public static String u(Context context, int i2) {
        try {
            Intent intent = new Intent();
            if (i2 == 2) {
                intent.setAction(s4b.v("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(s4b.v("UY29tLmh1YXdlaS5od2lk"));
            } else if (i2 == 4) {
                intent.setClassName(s4b.v("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), s4b.v("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else {
                if (i2 != 5) {
                    f883f = true;
                    return e;
                }
                intent.setClassName(s4b.v("YY29tLmhleXRhcC5vcGVuaWQ"), s4b.v("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(s4b.v("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            e eVar = new e(context, i2);
            if (context.bindService(intent, eVar, 1)) {
                int i3 = 0;
                while (i3 < 100 && TextUtils.isEmpty(e)) {
                    i3++;
                    Thread.sleep(15L);
                }
                context.unbindService(eVar);
            }
            return e;
        } catch (Throwable th) {
            v6b.b(th, "oa", String.valueOf(i2));
            f883f = true;
            return e;
        }
    }

    public static void v(a aVar) {
        if (f872a == null) {
            f872a = aVar;
        }
    }

    public static void w(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void x(String str) {
        f880d = str;
    }

    public static String z() {
        try {
            if (!TextUtils.isEmpty(f878c)) {
                return f878c;
            }
            a aVar = f872a;
            return aVar == null ? "" : aVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }
}
