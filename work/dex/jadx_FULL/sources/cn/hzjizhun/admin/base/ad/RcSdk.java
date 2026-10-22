package cn.hzjizhun.admin.base.ad;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import cn.hzjizhun.admin.base.k0;
import cn.hzjizhun.admin.base.utils.CrashRecorder;
import com.zj.adlib.c0b;
import com.zj.adlib.lha;
import com.zj.adlib.mib;
import com.zj.adlib.rvb;
import com.zj.adlib.rzb;
import com.zj.adlib.ylb;
import com.zj.adlib.zmb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RcSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f22695a = 2.75f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Context f279a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f280a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile boolean f281a = false;
    public static float b = 2.75f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static String f282b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f283b;
    public static String c;
    public static String d;
    public static String e;

    public static String c() {
        return e;
    }

    public static String d() {
        return f280a;
    }

    public static Context e() {
        return f279a;
    }

    public static String f() {
        return c;
    }

    public static void finishApp() {
        try {
            CrashRecorder.getInstance().finishPage();
        } catch (Throwable unused) {
        }
    }

    public static String g() {
        return d;
    }

    public static String getPackageName(Application application) {
        try {
            return application.getApplicationInfo().packageName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String h() {
        return f282b;
    }

    public static float i() {
        return f22695a;
    }

    public static synchronized void init(Context context) {
        if (context != null) {
            try {
                if (!f281a) {
                    if (f279a == null) {
                        f279a = context.getApplicationContext();
                    }
                    k0.a();
                    zmb zmbVarA = zmb.a();
                    lha lhaVar = new lha();
                    zmbVarA.getClass();
                    mib mibVarA = mib.a();
                    ylb ylbVar = new ylb(zmbVarA, lhaVar);
                    mibVarA.getClass();
                    mib.f18226a.submit(ylbVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static float j() {
        return b;
    }

    public static boolean k() {
        return f283b;
    }

    public static void setAndroidId(String str) {
        e = str;
    }

    public static void setErrorCallback(ErrorCallback errorCallback) {
        try {
            rzb.a().f19454a = errorCallback;
        } catch (Throwable unused) {
        }
    }

    public static void setImei(String str) {
        c = str;
    }

    public static void setImsi(String str) {
        d = str;
    }

    public static void setLocation(float f, float f2) {
        rvb rvbVarA = rvb.a();
        rvbVarA.getClass();
        try {
            rvbVarA.f19444a = f;
            rvbVarA.b = f2;
        } catch (Throwable unused) {
        }
    }

    public static void setMacAddress(String str) {
        f282b = str;
    }

    public static void setOaid(String str) {
        c0b c0bVarA = c0b.a();
        c0bVarA.getClass();
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c0bVarA.f15670a = str;
        } catch (Throwable unused) {
        }
    }

    public static void setTouchMajor(float f) {
        f22695a = f;
    }

    public static void setTouchMinor(float f) {
        b = f;
    }

    public static void setUrl(String str) {
        f280a = str;
    }

    public static void startAccelerate() {
        f283b = true;
    }
}
