package com.alipay.sdk.m.u0;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.acse.ottn.p3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    public static String A = null;
    public static volatile c B = null;
    public static volatile b C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25513a = "VMS_IDLG_SDK_Client";
    public static final String b = "content://com.vivo.vms.IdProvider/IdentifierId";
    public static final String c = "persist.sys.identifierid.supported";
    public static final String d = "appid";
    public static final String e = "type";
    public static final String f = "OAID";
    public static final String g = "VAID";
    public static final String h = "AAID";
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 4;
    public static final int m = 11;
    public static final int n = 2000;
    public static Context o = null;
    public static boolean p = false;
    public static d q;
    public static d r;
    public static d s;
    public static Object t = new Object();
    public static HandlerThread u;
    public static Handler v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 11) {
                Log.e(c.f25513a, "message type valid");
                return;
            }
            String unused = c.w = c.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
            synchronized (c.t) {
                c.t.notify();
            }
        }
    }

    public static void f() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        u = handlerThread;
        handlerThread.start();
        v = new a(u.getLooper());
    }

    public String c(String str) {
        if (!g()) {
            return null;
        }
        String str2 = y;
        if (str2 != null) {
            return str2;
        }
        a(1, str);
        if (r == null && y != null) {
            a(o, 1, str);
        }
        return y;
    }

    public String d() {
        if (!g()) {
            return null;
        }
        String str = x;
        if (str != null) {
            return str;
        }
        a(0, (String) null);
        if (q == null) {
            a(o, 0, null);
        }
        return x;
    }

    public String e() {
        if (!g()) {
            return null;
        }
        a(4, (String) null);
        return A;
    }

    public boolean g() {
        return p;
    }

    public String b(String str) {
        if (!g()) {
            return null;
        }
        String str2 = z;
        if (str2 != null) {
            return str2;
        }
        a(2, str);
        if (s == null && z != null) {
            a(o, 2, str);
        }
        return z;
    }

    public static c a(Context context) {
        if (B == null) {
            synchronized (c.class) {
                o = context.getApplicationContext();
                B = new c();
            }
        }
        if (C == null) {
            synchronized (c.class) {
                o = context.getApplicationContext();
                f();
                C = new b(o);
                c();
            }
        }
        return B;
    }

    public static void c() {
        p = "1".equals(a(c, "0"));
    }

    public final void b(int i2, String str) {
        Message messageObtainMessage = v.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        v.sendMessage(messageObtainMessage);
    }

    public void a(int i2, String str) {
        synchronized (t) {
            b(i2, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                t.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= 2000) {
                Log.d(f25513a, "query timeout");
            } else if (i2 == 0) {
                x = w;
                w = null;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    String str2 = w;
                    if (str2 != null) {
                        z = str2;
                        w = null;
                    } else {
                        Log.e(f25513a, "get aaid failed");
                    }
                } else if (i2 != 4) {
                }
                A = w;
                w = null;
            } else {
                String str3 = w;
                if (str3 != null) {
                    y = str3;
                    w = null;
                } else {
                    Log.e(f25513a, "get vaid failed");
                }
            }
        }
    }

    public static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a(Context context, int i2, String str) {
        if (i2 == 0) {
            q = new d(B, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, q);
            return;
        }
        if (i2 == 1) {
            r = new d(B, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, r);
            return;
        }
        if (i2 != 2) {
            return;
        }
        s = new d(B, 2, str);
        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, s);
    }
}
