package cj.mobile.p;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import cj.mobile.listener.CJAppAdListener;
import com.zj.adlib.c49;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b {
    public static int A;
    public static int B;
    public static int C;
    public static int D;
    public static int E;
    public static int F;
    public static int G;
    public static int H;
    public static int I;
    public static int J;
    public static int K;
    public static int L;
    public static int M;
    public static String N;
    public static boolean O;
    public static boolean P;
    public static String Y;
    public static String b;
    public static String c0;
    public static boolean d;
    public static boolean e;
    public static int e0;
    public static boolean f;
    public static int f0;
    public static boolean g;
    public static int g0;
    public static boolean h;
    public static boolean i;
    public static boolean j;
    public static boolean k;
    public static boolean l;
    public static boolean m;
    public static boolean n;
    public static CJAppAdListener n0;
    public static boolean o;
    public static boolean p;
    public static boolean q;
    public static boolean r;
    public static boolean s;
    public static boolean t;
    public static boolean u;
    public static boolean v;
    public static boolean w;
    public static boolean x;
    public static int y;
    public static int z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f22637a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue());
    public static String c = "";
    public static int Q = 1;
    public static String R = "";
    public static String S = "";
    public static String T = "";
    public static String U = "";
    public static boolean V = true;
    public static boolean W = true;
    public static String X = "";
    public static String Z = "";
    public static String a0 = "";
    public static String b0 = "";
    public static boolean d0 = true;
    public static HandlerThread h0 = new HandlerThread("MyThreadFallsSort");
    public static int i0 = 111111;
    public static boolean j0 = false;
    public static boolean k0 = true;
    public static boolean l0 = true;
    public static boolean m0 = false;
    public static int o0 = 0;
    public static Handler p0 = new Handler(Looper.getMainLooper());

    public static void a(String str) {
        b = str;
    }

    public static void b(String str) {
        c = str;
    }

    public static String c() {
        String str = b;
        String str2 = "";
        if (str != null) {
            char[] charArray = str.toCharArray();
            for (int i2 = 0; i2 < charArray.length; i2++) {
                if (i2 % 2 == 0) {
                    str2 = str2 + charArray[i2];
                }
            }
        }
        return str2;
    }

    public static String d() {
        String str = c;
        if (str == null || str.equals("")) {
            new c().b();
        }
        return c;
    }

    public static void a() {
        try {
            if (h0.isAlive()) {
                return;
            }
            h0.start();
        } catch (Exception e2) {
            g.a("threadFallsSort", e2.getMessage());
        }
    }

    public static String b() {
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random random = new Random();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(jCurrentTimeMillis);
        for (int i2 = 0; i2 < 4; i2++) {
            stringBuffer.append(c49.f40900a);
            for (int i3 = 1; i3 < 5; i3++) {
                stringBuffer.append(charArray[random.nextInt(62)]);
            }
        }
        return k.a(stringBuffer.toString());
    }

    public static void a(Context context, String str, String str2, int i2) {
        j.a(context, "type-" + str, str2);
        j.b(context, "price-" + str, i2);
    }
}
