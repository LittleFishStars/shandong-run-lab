package com.kc.cw.ad.c.j;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.acse.ottn.p3;
import com.alipay.sdk.m.y.l;
import com.kc.cw.ad.d.b.f;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {
    private static int A = 0;
    private static int B = 0;
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;
    private static int F = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f38757a = null;
    private static Object c = new Object();
    private static boolean d = false;
    private static int e = 13;
    private static c f;
    private static c g;
    private static c h;
    private static c i;
    private static HandlerThread j;
    private static Handler k;
    private static String l;
    private static String m;
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private static String r;
    private static volatile b s;
    private static volatile a t;
    private static int u;
    private static int v;
    private static int w;
    private static int x;
    private static int y;
    private static int z;
    private final int b;

    private b() {
        u();
        t = new a(f38757a);
        this.b = c(f38757a);
    }

    public static b a(Context context) {
        if (f38757a == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f38757a = context;
        }
        if (s == null) {
            synchronized (b.class) {
                try {
                    if (s == null) {
                        s = new b();
                        s.t();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return s;
    }

    private static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e2) {
                f.c("VMS_SDK_Client", "getProperty: invoke is error" + e2.getMessage());
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a(int i2, String str) {
        if (i2 == 0) {
            if (str == null) {
                v++;
                return;
            } else {
                u++;
                return;
            }
        }
        if (i2 == 1) {
            if (str == null) {
                x++;
                return;
            } else {
                w++;
                return;
            }
        }
        if (i2 == 2) {
            if (str == null) {
                z++;
                return;
            } else {
                y++;
                return;
            }
        }
        switch (i2) {
            case 8:
                if (str != null) {
                    A++;
                } else {
                    B++;
                }
                break;
            case 9:
                if (str != null) {
                    C++;
                } else {
                    D++;
                }
                break;
            case 10:
                if (str != null) {
                    E++;
                } else {
                    F++;
                }
                break;
        }
    }

    private static void a(Context context, int i2, String str) {
        synchronized (b.class) {
            try {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            if (h == null) {
                                h = new c(s, 2, str);
                                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, h);
                            }
                        }
                    } else if (g == null) {
                        g = new c(s, 1, str);
                        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, g);
                    }
                } else if (f == null) {
                    f = new c(s, 0, null);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a() {
        if (!d) {
            v();
        }
        return d;
    }

    public static b b(Context context) {
        if (a()) {
            return a(context);
        }
        return null;
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.vivo.vms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private void c(int i2, String str) {
        synchronized (c) {
            b(i2, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                c.wait(2000L);
            } catch (InterruptedException unused) {
                f.c("VMS_SDK_Client", "queryId: lock error");
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= 2000) {
                f.a("VMS_SDK_Client", "query timeout");
            }
        }
    }

    private void t() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable(this) { // from class: com.kc.cw.ad.c.j.b.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final b f38758a;

            {
                this.f38758a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.u + b.v + b.A + b.D + b.w + b.x + b.C + b.D + b.y + b.z + b.E + b.F > 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DeviceIdType.OAID, this.f38758a.a(b.u, b.v, b.A, b.B));
                    contentValues.put("vaid", this.f38758a.a(b.w, b.x, b.C, b.D));
                    contentValues.put("aaid", this.f38758a.a(b.y, b.z, b.E, b.F));
                    b.t.a(7, "vivo", new ContentValues[]{contentValues});
                    int unused = b.u = b.v = b.w = b.x = b.y = b.z = 0;
                    int unused2 = b.A = b.B = b.C = b.D = b.E = b.F = 0;
                }
            }
        }, 600L, 600L, TimeUnit.SECONDS);
    }

    private static void u() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        j = handlerThread;
        handlerThread.start();
        k = new Handler(j.getLooper()) { // from class: com.kc.cw.ad.c.j.b.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                String str2;
                if (message.what != 11) {
                    f.c("VMS_SDK_Client", "message type valid");
                    return;
                }
                int i2 = message.getData().getInt("type");
                try {
                    String strA = b.t.a(i2, message.getData().getString("appid"));
                    if (i2 == 0) {
                        String unused = b.l = strA;
                        b.a(8, b.l);
                    } else if (i2 == 1) {
                        if (strA != null) {
                            String unused2 = b.m = strA;
                        } else {
                            f.c("VMS_SDK_Client", "get vaid failed");
                        }
                        b.a(9, b.m);
                    } else if (i2 == 2) {
                        if (strA != null) {
                            String unused3 = b.n = strA;
                        } else {
                            f.c("VMS_SDK_Client", "get aaid failed");
                        }
                        b.a(10, b.n);
                    } else if (i2 != 3) {
                        if (i2 == 4) {
                            String unused4 = b.p = strA;
                        } else if (i2 == 5) {
                            if (strA != null) {
                                String unused5 = b.q = strA;
                            } else {
                                str = "VMS_SDK_Client";
                                str2 = "get guid failed";
                                f.c(str, str2);
                            }
                        }
                    } else if (strA != null) {
                        String unused6 = b.o = strA;
                    } else {
                        str = "VMS_SDK_Client";
                        str2 = "get udid failed";
                        f.c(str, str2);
                    }
                } catch (Exception e2) {
                    f.c("VMS_SDK_Client", "readException:" + e2.toString());
                }
                synchronized (b.c) {
                    b.c.notify();
                }
            }
        };
    }

    private static void v() {
        d = "1".equals(a(com.alipay.sdk.m.u0.c.c, "0")) || "1".equals(a("persist.sys.identifierid", "0"));
    }

    public String a(int i2, int i3, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(i3);
        stringBuffer.append(l.b);
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(i5);
        return stringBuffer.toString();
    }

    public String b() {
        String str = l;
        if (str == null) {
            c(0, null);
            if (f == null) {
                a(f38757a, 0, null);
            }
            str = l;
        }
        a(0, str);
        return l;
    }

    public void b(int i2, String str) {
        Message messageObtainMessage = k.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2 || i2 == 6) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        k.sendMessage(messageObtainMessage);
    }
}
