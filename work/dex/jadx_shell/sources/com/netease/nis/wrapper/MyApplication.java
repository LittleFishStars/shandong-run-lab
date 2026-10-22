package com.netease.nis.wrapper;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public class MyApplication extends Application {
    public static final String VER = "7.6.3_936";
    public static String TAG = a.auu.a.c("ORcVFREWFw==");
    public static String strAppName = a.auu.a.c("LQoZSw8WESsEBwBPHQw9SwMXAAMVKxdaKBgyFT4JHQYABwwhCw==");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f0a = a.auu.a.c("Kx0AFwAQEREWAwwVEA0RVQ==");
    private static String b = a.auu.a.c("PhcbEwgXADw6BxIIBwYmOkU=");
    private static String c = a.auu.a.c("PQ0RCQ0sCScIHRE+Qw==");
    private static String d = a.auu.a.c("Nl1COhIEDDoGHDpQ");
    private static Context e = null;
    private static Application runApp = null;
    private static Application newApp = null;
    public static boolean mOfficial = true;
    public static boolean mNeedX86 = true;
    public static boolean mNeedBugrpt = false;
    public static boolean mLoadShell = false;
    private static boolean f = false;
    private static int g = 0;
    private static Handler h = new Handler(Looper.getMainLooper());

    private static Application a(Context context) {
        try {
            if (newApp != null || strAppName.compareTo("") == 0) {
                return newApp;
            }
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader == null) {
                return newApp;
            }
            Class<?> clsLoadClass = classLoader.loadClass(strAppName);
            if (clsLoadClass != null) {
                newApp = (Application) clsLoadClass.newInstance();
            }
            return newApp;
        } catch (Exception e2) {
            e2.toString();
            return newApp;
        }
    }

    private static boolean a() {
        boolean zContains = c.contains(a.auu.a.c("fw=="));
        new StringBuilder(a.auu.a.c("FQsRAAUwCiARBgoNIA0rCRgpAAYLLQ0pRQMgDSsJGCkABgstDTgMDBoRKwFO")).append(zContains).append(a.auu.a.c("bggnDQQfCQ0LAF8=")).append(g);
        return g == 2 && zContains;
    }

    public static native boolean g();

    public static Context getAppCtx() {
        return e;
    }

    public static Handler getHandler() {
        return h;
    }

    public static String getVersion() {
        return TAG + a.auu.a.c("eUtCS1IsXH1T");
    }

    public static native boolean l(Application application);

    public static void loadLib(Context context, String str) {
        o.a(context, str);
    }

    public static native synchronized void n0010111112(char c2, char c3, char c4, char c5, char c6, double d2);

    public static native synchronized void n00102(double d2);

    public static native synchronized void n001022(double d2, double d3);

    public static native synchronized void n0010312(Object obj, char c2, double d2);

    public static native synchronized char n0011112(char c2, char c3, double d2);

    public static native synchronized char n001112(char c2, double d2);

    public static native synchronized double n0012();

    public static native synchronized double n0012332(Object obj, Object obj2, double d2);

    public static native synchronized Object n0013();

    public static native void n0110();

    public static native void n01101(char c2);

    public static native void n011011(char c2, char c3);

    public static native void n0110111(char c2, char c3, char c4);

    public static native void n0110111111(char c2, char c3, char c4, char c5, char c6, char c7);

    public static native void n011011111131(char c2, char c3, char c4, char c5, char c6, char c7, Object obj, char c8);

    public static native void n0110113(char c2, char c3, Object obj);

    public static native void n011011333(char c2, char c3, Object obj, Object obj2, Object obj3);

    public static native void n011012(char c2, double d2);

    public static native void n0110121(char c2, double d2, char c3);

    public static native void n01101211(char c2, double d2, char c3, char c4);

    public static native void n011012111(char c2, double d2, char c3, char c4, char c5);

    public static native void n01101211111(char c2, double d2, char c3, char c4, char c5, char c6, char c7);

    public static native void n011012111111(char c2, double d2, char c3, char c4, char c5, char c6, char c7, char c8);

    public static native void n0110122(char c2, double d2, double d3);

    public static native void n0110123(char c2, double d2, Object obj);

    public static native void n01101231(char c2, double d2, Object obj, char c3);

    public static native void n011012313(char c2, double d2, Object obj, char c3, Object obj2);

    public static native void n011012321111(char c2, double d2, Object obj, double d3, char c3, char c4, char c5, char c6);

    public static native void n01101233(char c2, double d2, Object obj, Object obj2);

    public static native void n01101233311111111(char c2, double d2, Object obj, Object obj2, Object obj3, char c3, char c4, char c5, char c6, char c7, char c8, char c9, char c10);

    public static native void n011013(char c2, Object obj);

    public static native void n0110131(char c2, Object obj, char c3);

    public static native void n01101311(char c2, Object obj, char c3, char c4);

    public static native void n0110133(char c2, Object obj, Object obj2);

    public static native void n0110133313(char c2, Object obj, Object obj2, Object obj3, char c3, Object obj4);

    public static native void n01101333333(char c2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6);

    public static native void n01102(double d2);

    public static native void n011021(double d2, char c2);

    public static native void n0110211(double d2, char c2, char c3);

    public static native void n01102111(double d2, char c2, char c3, char c4);

    public static native void n011021111(double d2, char c2, char c3, char c4, char c5);

    public static native void n0110211111111111(double d2, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9, char c10, char c11, char c12);

    public static native void n011021113(double d2, char c2, char c3, char c4, Object obj);

    public static native void n01102113(double d2, char c2, char c3, Object obj);

    public static native void n011021133(double d2, char c2, char c3, Object obj, Object obj2);

    public static native void n0110212(double d2, char c2, double d3);

    public static native void n011021223(double d2, char c2, double d3, double d4, Object obj);

    public static native void n0110213(double d2, char c2, Object obj);

    public static native void n01102132(double d2, char c2, Object obj, double d3);

    public static native void n011022(double d2, double d3);

    public static native void n0110221(double d2, double d3, char c2);

    public static native void n01102212(double d2, double d3, char c2, double d4);

    public static native void n01102213(double d2, double d3, char c2, Object obj);

    public static native void n0110222(double d2, double d3, double d4);

    public static native void n01102221(double d2, double d3, double d4, char c2);

    public static native void n01102222(double d2, double d3, double d4, double d5);

    public static native void n011022222(double d2, double d3, double d4, double d5, double d6);

    public static native void n0110222222(double d2, double d3, double d4, double d5, double d6, double d7);

    public static native void n01102222222(double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    public static native void n0110223(double d2, double d3, Object obj);

    public static native void n0110223333(double d2, double d3, Object obj, Object obj2, Object obj3, Object obj4);

    public static native void n011023(double d2, Object obj);

    public static native void n0110231(double d2, Object obj, char c2);

    public static native void n01102311(double d2, Object obj, char c2, char c3);

    public static native void n0110233(double d2, Object obj, Object obj2);

    public static native void n011023311(double d2, Object obj, Object obj2, char c2, char c3);

    public static native void n011023323(double d2, Object obj, Object obj2, double d3, Object obj3);

    public static native void n0110233231(double d2, Object obj, Object obj2, double d3, Object obj3, char c2);

    public static native void n01102333(double d2, Object obj, Object obj2, Object obj3);

    public static native void n01103(Object obj);

    public static native void n011031(Object obj, char c2);

    public static native void n0110311(Object obj, char c2, char c3);

    public static native void n01103111(Object obj, char c2, char c3, char c4);

    public static native void n0110311131(Object obj, char c2, char c3, char c4, Object obj2, char c5);

    public static native void n01103113(Object obj, char c2, char c3, Object obj2);

    public static native void n011031133(Object obj, char c2, char c3, Object obj2, Object obj3);

    public static native void n0110312(Object obj, char c2, double d2);

    public static native void n0110313(Object obj, char c2, Object obj2);

    public static native void n011031311(Object obj, char c2, Object obj2, char c3, char c4);

    public static native void n011032(Object obj, double d2);

    public static native void n0110321(Object obj, double d2, char c2);

    public static native void n011033(Object obj, Object obj2);

    public static native void n0110331(Object obj, Object obj2, char c2);

    public static native void n01103311(Object obj, Object obj2, char c2, char c3);

    public static native void n011033111(Object obj, Object obj2, char c2, char c3, char c4);

    public static native void n01103313(Object obj, Object obj2, char c2, Object obj3);

    public static native void n011033133(Object obj, Object obj2, char c2, Object obj3, Object obj4);

    public static native void n0110331333(Object obj, Object obj2, char c2, Object obj3, Object obj4, Object obj5);

    public static native void n0110333(Object obj, Object obj2, Object obj3);

    public static native void n01103331(Object obj, Object obj2, Object obj3, char c2);

    public static native void n011033311(Object obj, Object obj2, Object obj3, char c2, char c3);

    public static native void n01103332(Object obj, Object obj2, Object obj3, double d2);

    public static native void n01103333(Object obj, Object obj2, Object obj3, Object obj4);

    public static native void n0110333313(Object obj, Object obj2, Object obj3, Object obj4, char c2, Object obj5);

    public static native void n011033331333(Object obj, Object obj2, Object obj3, Object obj4, char c2, Object obj5, Object obj6, Object obj7);

    public static native void n011033333(Object obj, Object obj2, Object obj3, Object obj4, Object obj5);

    public static native void n0110333332(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, double d2);

    public static native void n0110333333(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6);

    public static native void n01103333331(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, char c2);

    public static native void n01103333333(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7);

    public static native void n011033333333(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8);

    public static native char n0111();

    public static native char n01111(char c2);

    public static native char n011111(char c2, char c3);

    public static native char n0111111(char c2, char c3, char c4);

    public static native char n01111111(char c2, char c3, char c4, char c5);

    public static native char n0111113(char c2, char c3, Object obj);

    public static native char n01111133(char c2, char c3, Object obj, Object obj2);

    public static native char n0111113333(char c2, char c3, Object obj, Object obj2, Object obj3, Object obj4);

    public static native char n0111121(char c2, double d2, char c3);

    public static native char n0111121111311(char c2, double d2, char c3, char c4, char c5, char c6, Object obj, char c7, char c8);

    public static native char n0111123(char c2, double d2, Object obj);

    public static native char n0111131(char c2, Object obj, char c3);

    public static native char n0111133(char c2, Object obj, Object obj2);

    public static native char n0111133333333331111111111131111111(char c2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, char c3, char c4, char c5, char c6, char c7, char c8, char c9, char c10, char c11, char c12, char c13, Object obj11, char c14, char c15, char c16, char c17, char c18, char c19, char c20);

    public static native char n01112(double d2);

    public static native char n011121(double d2, char c2);

    public static native char n0111211(double d2, char c2, char c3);

    public static native char n01112111(double d2, char c2, char c3, char c4);

    public static native char n0111211111(double d2, char c2, char c3, char c4, char c5, char c6);

    public static native char n01112113(double d2, char c2, char c3, Object obj);

    public static native char n0111212(double d2, char c2, double d3);

    public static native char n0111213(double d2, char c2, Object obj);

    public static native char n011122(double d2, double d3);

    public static native char n0111221(double d2, double d3, char c2);

    public static native char n01112211(double d2, double d3, char c2, char c3);

    public static native char n011122111113(double d2, double d3, char c2, char c3, char c4, char c5, char c6, Object obj);

    public static native char n011122131(double d2, double d3, char c2, Object obj, char c3);

    public static native char n011122133(double d2, double d3, char c2, Object obj, Object obj2);

    public static native char n0111221331(double d2, double d3, char c2, Object obj, Object obj2, char c3);

    public static native char n0111222(double d2, double d3, double d4);

    public static native char n01112222(double d2, double d3, double d4, double d5);

    public static native char n011122222(double d2, double d3, double d4, double d5, double d6);

    public static native char n0111222222(double d2, double d3, double d4, double d5, double d6, double d7);

    public static native char n01112222222(double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    public static native char n0111223(double d2, double d3, Object obj);

    public static native char n01112231(double d2, double d3, Object obj, char c2);

    public static native char n01112233(double d2, double d3, Object obj, Object obj2);

    public static native char n011123(double d2, Object obj);

    public static native char n0111231(double d2, Object obj, char c2);

    public static native char n01112311(double d2, Object obj, char c2, char c3);

    public static native char n01112313(double d2, Object obj, char c2, Object obj2);

    public static native char n0111232(double d2, Object obj, double d3);

    public static native char n01112322(double d2, Object obj, double d3, double d4);

    public static native char n0111233(double d2, Object obj, Object obj2);

    public static native char n01112332(double d2, Object obj, Object obj2, double d3);

    public static native char n01113(Object obj);

    public static native char n011131(Object obj, char c2);

    public static native char n0111311(Object obj, char c2, char c3);

    public static native char n01113111(Object obj, char c2, char c3, char c4);

    public static native char n01113121(Object obj, char c2, double d2, char c3);

    public static native char n0111313(Object obj, char c2, Object obj2);

    public static native char n01113131311111111(Object obj, char c2, Object obj2, char c3, Object obj3, char c4, char c5, char c6, char c7, char c8, char c9, char c10, char c11);

    public static native char n0111313131113111(Object obj, char c2, Object obj2, char c3, Object obj3, char c4, char c5, char c6, Object obj4, char c7, char c8, char c9);

    public static native char n01113131311133111111(Object obj, char c2, Object obj2, char c3, Object obj3, char c4, char c5, char c6, Object obj4, Object obj5, char c7, char c8, char c9, char c10, char c11, char c12);

    public static native char n01113131311311311311333111(Object obj, char c2, Object obj2, char c3, Object obj3, char c4, char c5, Object obj4, char c6, char c7, Object obj5, char c8, char c9, Object obj6, char c10, char c11, Object obj7, Object obj8, Object obj9, char c12, char c13, char c14);

    public static native char n011132(Object obj, double d2);

    public static native char n011133(Object obj, Object obj2);

    public static native char n0111331(Object obj, Object obj2, char c2);

    public static native char n0111331111(Object obj, Object obj2, char c2, char c3, char c4, char c5);

    public static native char n01113311111(Object obj, Object obj2, char c2, char c3, char c4, char c5, char c6);

    public static native char n0111333(Object obj, Object obj2, Object obj3);

    public static native char n01113331(Object obj, Object obj2, Object obj3, char c2);

    public static native char n011133311(Object obj, Object obj2, Object obj3, char c2, char c3);

    public static native char n01113331313(Object obj, Object obj2, Object obj3, char c2, Object obj4, char c3, Object obj5);

    public static native char n01113333(Object obj, Object obj2, Object obj3, Object obj4);

    public static native double n0112();

    public static native double n01121(char c2);

    public static native double n011211(char c2, char c3);

    public static native double n0112111(char c2, char c3, char c4);

    public static native double n01121111(char c2, char c3, char c4, char c5);

    public static native double n011212(char c2, double d2);

    public static native double n0112121(char c2, double d2, char c3);

    public static native double n0112122(char c2, double d2, double d3);

    public static native double n01121233(char c2, double d2, Object obj, Object obj2);

    public static native double n011213(char c2, Object obj);

    public static native double n0112133311112(char c2, Object obj, Object obj2, Object obj3, char c3, char c4, char c5, char c6, double d2);

    public static native double n01122(double d2);

    public static native double n011221(double d2, char c2);

    public static native double n0112211(double d2, char c2, char c3);

    public static native double n0112212(double d2, char c2, double d3);

    public static native double n011221223(double d2, char c2, double d3, double d4, Object obj);

    public static native double n01122131(double d2, char c2, Object obj, char c3);

    public static native double n011222(double d2, double d3);

    public static native double n0112221(double d2, double d3, char c2);

    public static native double n011222113(double d2, double d3, char c2, char c3, Object obj);

    public static native double n0112222(double d2, double d3, double d4);

    public static native double n0112222111(double d2, double d3, double d4, char c2, char c3, char c4);

    public static native double n01122222(double d2, double d3, double d4, double d5);

    public static native double n011222222(double d2, double d3, double d4, double d5, double d6);

    public static native double n0112222222(double d2, double d3, double d4, double d5, double d6, double d7);

    public static native double n01122222222(double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    public static native double n0112223(double d2, double d3, Object obj);

    public static native double n011223(double d2, Object obj);

    public static native double n0112231(double d2, Object obj, char c2);

    public static native double n0112232(double d2, Object obj, double d3);

    public static native double n0112233(double d2, Object obj, Object obj2);

    public static native double n01122331(double d2, Object obj, Object obj2, char c2);

    public static native double n01123(Object obj);

    public static native double n011231(Object obj, char c2);

    public static native double n01123113(Object obj, char c2, char c3, Object obj2);

    public static native double n011231332(Object obj, char c2, Object obj2, Object obj3, double d2);

    public static native double n011232(Object obj, double d2);

    public static native double n011233(Object obj, Object obj2);

    public static native double n0112331(Object obj, Object obj2, char c2);

    public static native double n011233111(Object obj, Object obj2, char c2, char c3, char c4);

    public static native double n01123312(Object obj, Object obj2, char c2, double d2);

    public static native double n0112333(Object obj, Object obj2, Object obj3);

    public static native double n01123331(Object obj, Object obj2, Object obj3, char c2);

    public static native double n01123333(Object obj, Object obj2, Object obj3, Object obj4);

    public static native Object n0113();

    public static native Object n01131(char c2);

    public static native Object n011311(char c2, char c3);

    public static native Object n0113111(char c2, char c3, char c4);

    public static native Object n011311233(char c2, char c3, double d2, Object obj, Object obj2);

    public static native Object n011312(char c2, double d2);

    public static native Object n0113121(char c2, double d2, char c3);

    public static native Object n01131211(char c2, double d2, char c3, char c4);

    public static native Object n0113121111(char c2, double d2, char c3, char c4, char c5, char c6);

    public static native Object n011312221111133(char c2, double d2, double d3, double d4, char c3, char c4, char c5, char c6, char c7, Object obj, Object obj2);

    public static native Object n0113123(char c2, double d2, Object obj);

    public static native Object n011313(char c2, Object obj);

    public static native Object n0113133(char c2, Object obj, Object obj2);

    public static native Object n01131333(char c2, Object obj, Object obj2, Object obj3);

    public static native Object n01132(double d2);

    public static native Object n011321(double d2, char c2);

    public static native Object n0113211(double d2, char c2, char c3);

    public static native Object n011321223(double d2, char c2, double d3, double d4, Object obj);

    public static native Object n011322(double d2, double d3);

    public static native Object n0113221(double d2, double d3, char c2);

    public static native Object n01132211(double d2, double d3, char c2, char c3);

    public static native Object n0113222(double d2, double d3, double d4);

    public static native Object n01132222(double d2, double d3, double d4, double d5);

    public static native Object n011322222(double d2, double d3, double d4, double d5, double d6);

    public static native Object n0113222222(double d2, double d3, double d4, double d5, double d6, double d7);

    public static native Object n01132222222(double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    public static native Object n01132233(double d2, double d3, Object obj, Object obj2);

    public static native Object n011323(double d2, Object obj);

    public static native Object n0113231(double d2, Object obj, char c2);

    public static native Object n01132331(double d2, Object obj, Object obj2, char c2);

    public static native Object n011323323(double d2, Object obj, Object obj2, double d3, Object obj3);

    public static native Object n011323333111(double d2, Object obj, Object obj2, Object obj3, Object obj4, char c2, char c3, char c4);

    public static native Object n0113233333111(double d2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, char c2, char c3, char c4);

    public static native Object n01133(Object obj);

    public static native Object n011331(Object obj, char c2);

    public static native Object n0113311(Object obj, char c2, char c3);

    public static native Object n01133111(Object obj, char c2, char c3, char c4);

    public static native Object n011331111(Object obj, char c2, char c3, char c4, char c5);

    public static native Object n01133112(Object obj, char c2, char c3, double d2);

    public static native Object n0113311313(Object obj, char c2, char c3, Object obj2, char c4, Object obj3);

    public static native Object n01133131(Object obj, char c2, Object obj2, char c3);

    public static native Object n01133133331(Object obj, char c2, Object obj2, Object obj3, Object obj4, Object obj5, char c3);

    public static native Object n011332(Object obj, double d2);

    public static native Object n01133211(Object obj, double d2, char c2, char c3);

    public static native Object n0113322(Object obj, double d2, double d3);

    public static native Object n0113323(Object obj, double d2, Object obj2);

    public static native Object n011333(Object obj, Object obj2);

    public static native Object n0113331(Object obj, Object obj2, char c2);

    public static native Object n01133311(Object obj, Object obj2, char c2, char c3);

    public static native Object n01133313(Object obj, Object obj2, char c2, Object obj3);

    public static native Object n01133313311331123(Object obj, Object obj2, char c2, Object obj3, Object obj4, char c3, char c4, Object obj5, Object obj6, char c5, char c6, double d2, Object obj7);

    public static native Object n01133313331(Object obj, Object obj2, char c2, Object obj3, Object obj4, Object obj5, char c3);

    public static native Object n0113333(Object obj, Object obj2, Object obj3);

    public static native Object n01133331(Object obj, Object obj2, Object obj3, char c2);

    public static native Object n0113333133(Object obj, Object obj2, Object obj3, char c2, Object obj4, Object obj5);

    public static native Object n01133333(Object obj, Object obj2, Object obj3, Object obj4);

    public static native Object n011333331(Object obj, Object obj2, Object obj3, Object obj4, char c2);

    public static native Object n011333333(Object obj, Object obj2, Object obj3, Object obj4, Object obj5);

    public static native Object n0113333331(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, char c2);

    public static boolean needExtractSo() {
        boolean zContains = f0a.contains(a.auu.a.c("fw=="));
        new StringBuilder(a.auu.a.c("FQsRAAU2HToXFQYVIAoTRRYrBBYBCx0ABAIHXw==")).append(String.valueOf(zContains));
        return zContains;
    }

    public static boolean needX86So() {
        boolean zContains = d.contains(a.auu.a.c("fw=="));
        new StringBuilder(a.auu.a.c("FQsRAAUrXXg2GzhBESsrABA9WUVf")).append(String.valueOf(zContains));
        return zContains;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        Method method;
        super.attachBaseContext(context);
        String packageName = context.getPackageName();
        e = context;
        f = b.contains(a.auu.a.c("fw=="));
        g++;
        if (a()) {
            return;
        }
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        new StringBuilder(a.auu.a.c("FQQAEQAQDQwEBwAiHAs6AAwRPFMHKwIdC01TEysXBwwOHV8=")).append(getVersion()).append(a.auu.a.c("bggkFw4FDCoABjYWGhEtDU4=")).append(f);
        if (newApp == null) {
            if (!mLoadShell) {
                if (needExtractSo()) {
                    com.netease.nis.wrapper.plugin.c.a(context);
                }
                String strC = a.auu.a.c("IAAHAAI=");
                if (needX86So() && MyJni.a()) {
                    strC = a.auu.a.c("IAAHAAJeHXZT");
                }
                try {
                    o.a(context, strC);
                } catch (Exception e2) {
                    new StringBuilder(a.auu.a.c("FQQAEQAQDQwEBwAiHAs6AAwRPFMJIQQQFg5TADYGERUVGgogSQ==")).append(e2.toString());
                    System.loadLibrary(strC);
                }
            }
            MyJni.load(this, packageName);
            if (MyJni.a(context)) {
                mNeedBugrpt = true;
                String version = getVersion();
                boolean z = a.b;
                try {
                    String strConcat = a.auu.a.c("LQoZSw8WESsEBwBPHQw9Sw==").concat(a.auu.a.c("LBATFxEH"));
                    Class<?> cls = Class.forName(strConcat.concat(a.auu.a.c("YBAHABNdMD0ABjYVAQQ6ABMc")));
                    Object objNewInstance = cls.getConstructor(Context.class).newInstance(context);
                    cls.getMethod(a.auu.a.c("PQAAMBIWFxoEEw=="), String.class).invoke(objNewInstance, version);
                    if (z && (method = cls.getMethod(a.auu.a.c("PQAAIwgfESsXIwoTFxY="), String[].class)) != null) {
                        method.invoke(objNewInstance, new String[]{a.auu.a.c("LQoZSw8WESsEBwBPHQw9SwMXAAMVKxc="), a.auu.a.c("IgwWCwQAAC0="), a.auu.a.c("IgwWCwQUEC8XEEsSHA=="), a.auu.a.c("IgwWAQQLAycdWhYO"), a.auu.a.c("JgwaEVs="), a.auu.a.c("GQAWMwgWEgkKGwINFg==")});
                    }
                    Class<?> cls2 = Class.forName(strConcat.concat(a.auu.a.c("YCYGBBIbLS8LEAkEAQ==")));
                    cls2.getMethod(a.auu.a.c("JwsdEQ=="), Context.class, objNewInstance.getClass()).invoke(cls2, context, objNewInstance);
                } catch (Exception e3) {
                    new StringBuilder(a.auu.a.c("JwsdEUERECkXBBFBFhc8CgZf")).append(e3.toString());
                }
            }
            new StringBuilder(a.auu.a.c("FQkbBAUuRToMGQBb")).append(String.valueOf(System.currentTimeMillis() - lValueOf.longValue()));
            newApp = a(context);
            MyJni.ra(context, newApp);
        }
        NEDialog.showProbation(a.auu.a.c("IAoANRMcBy8RHQoP"));
        if (runApp == null) {
            runApp = this;
        }
        if (!f) {
            MyJni.cp();
        }
        new StringBuilder(a.auu.a.c("FQQAEQAQDQwEBwAiHAs6AAwRPFMAIAFYRRUaCCtf")).append(String.valueOf(System.currentTimeMillis() - lValueOf.longValue()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createPackageContext(String str, int i) {
        if (TextUtils.isEmpty(strAppName) || !f) {
            return super.createPackageContext(str, i);
        }
        new StringBuilder(a.auu.a.c("FQYGAAAHAB4EFw4AFAANChoRBAsRE0UEBAIYBCkAOgQMFl8=")).append(str).append(a.auu.a.c("bgMYBAYAXw==")).append(i);
        MyJni.rp(runApp.getBaseContext(), newApp);
        return str.equals(newApp.getPackageName()) ? newApp : super.createPackageContext(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return (TextUtils.isEmpty(strAppName) || !f) ? super.getPackageName() : "";
    }

    public native void n1110();

    public native void n11101(char c2);

    public native void n111011(char c2, char c3);

    public native void n1110111(char c2, char c3, char c4);

    public native void n11101111(char c2, char c3, char c4, char c5);

    public native void n1110111111(char c2, char c3, char c4, char c5, char c6, char c7);

    public native void n111011121(char c2, char c3, char c4, double d2, char c5);

    public native void n111011123(char c2, char c3, char c4, double d2, Object obj);

    public native void n11101113(char c2, char c3, char c4, Object obj);

    public native void n11101123(char c2, char c3, double d2, Object obj);

    public native void n1110113(char c2, char c3, Object obj);

    public native void n111011333331(char c2, char c3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, char c4);

    public native void n111012(char c2, double d2);

    public native void n1110121123(char c2, double d2, char c3, char c4, double d3, Object obj);

    public native void n111013(char c2, Object obj);

    public native void n1110131(char c2, Object obj, char c3);

    public native void n1110132(char c2, Object obj, double d2);

    public native void n1110133(char c2, Object obj, Object obj2);

    public native void n111013311(char c2, Object obj, Object obj2, char c3, char c4);

    public native void n1110133333(char c2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5);

    public native void n1110133333331(char c2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, char c3);

    public native void n11102(double d2);

    public native void n111021(double d2, char c2);

    public native void n1110211(double d2, char c2, char c3);

    public native void n11102111(double d2, char c2, char c3, char c4);

    public native void n111021111(double d2, char c2, char c3, char c4, char c5);

    public native void n1110211111(double d2, char c2, char c3, char c4, char c5, char c6);

    public native void n1110211111111(double d2, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9);

    public native void n111021111111111111111333(double d2, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9, char c10, char c11, char c12, char c13, char c14, char c15, char c16, char c17, Object obj, Object obj2, Object obj3);

    public native void n11102113(double d2, char c2, char c3, Object obj);

    public native void n111021131(double d2, char c2, char c3, Object obj, char c4);

    public native void n1110212(double d2, char c2, double d3);

    public native void n1110213(double d2, char c2, Object obj);

    public native void n11102131(double d2, char c2, Object obj, char c3);

    public native void n111021311111(double d2, char c2, Object obj, char c3, char c4, char c5, char c6, char c7);

    public native void n111021311111111(double d2, char c2, Object obj, char c3, char c4, char c5, char c6, char c7, char c8, char c9, char c10);

    public native void n1110213111111221(double d2, char c2, Object obj, char c3, char c4, char c5, char c6, char c7, char c8, double d3, double d4, char c9);

    public native void n111022(double d2, double d3);

    public native void n1110221(double d2, double d3, char c2);

    public native void n11102211(double d2, double d3, char c2, char c3);

    public native void n1110222(double d2, double d3, double d4);

    public native void n1110223(double d2, double d3, Object obj);

    public native void n11102231(double d2, double d3, Object obj, char c2);

    public native void n11102232(double d2, double d3, Object obj, double d4);

    public native void n11102233(double d2, double d3, Object obj, Object obj2);

    public native void n111023(double d2, Object obj);

    public native void n1110231(double d2, Object obj, char c2);

    public native void n111023111(double d2, Object obj, char c2, char c3, char c4);

    public native void n111023113(double d2, Object obj, char c2, char c3, Object obj2);

    public native void n1110232(double d2, Object obj, double d3);

    public native void n1110233(double d2, Object obj, Object obj2);

    public native void n11102331(double d2, Object obj, Object obj2, char c2);

    public native void n111023311(double d2, Object obj, Object obj2, char c2, char c3);

    public native void n1110233333(double d2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5);

    public native void n11103(Object obj);

    public native void n111031(Object obj, char c2);

    public native void n1110311(Object obj, char c2, char c3);

    public native void n11103111(Object obj, char c2, char c3, char c4);

    public native void n1110313(Object obj, char c2, Object obj2);

    public native void n11103131(Object obj, char c2, Object obj2, char c3);

    public native void n11103133(Object obj, char c2, Object obj2, Object obj3);

    public native void n111032(Object obj, double d2);

    public native void n1110321(Object obj, double d2, char c2);

    public native void n11103211(Object obj, double d2, char c2, char c3);

    public native void n1110323(Object obj, double d2, Object obj2);

    public native void n111033(Object obj, Object obj2);

    public native void n1110331(Object obj, Object obj2, char c2);

    public native void n11103311(Object obj, Object obj2, char c2, char c3);

    public native void n11103313(Object obj, Object obj2, char c2, Object obj3);

    public native void n1110332(Object obj, Object obj2, double d2);

    public native void n1110333(Object obj, Object obj2, Object obj3);

    public native void n11103331(Object obj, Object obj2, Object obj3, char c2);

    public native void n111033313(Object obj, Object obj2, Object obj3, char c2, Object obj4);

    public native void n11103331333(Object obj, Object obj2, Object obj3, char c2, Object obj4, Object obj5, Object obj6);

    public native void n11103333(Object obj, Object obj2, Object obj3, Object obj4);

    public native void n111033332(Object obj, Object obj2, Object obj3, Object obj4, double d2);

    public native void n111033333(Object obj, Object obj2, Object obj3, Object obj4, Object obj5);

    public native void n1110333331(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, char c2);

    public native void n1110333333(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6);

    public native char n1111();

    public native char n11111(char c2);

    public native char n111111(char c2, char c3);

    public native char n111111133(char c2, char c3, char c4, Object obj, Object obj2);

    public native char n1111113(char c2, char c3, Object obj);

    public native char n111113(char c2, Object obj);

    public native char n11111331(char c2, Object obj, Object obj2, char c3);

    public native char n1111133311133(char c2, Object obj, Object obj2, Object obj3, char c3, char c4, char c5, Object obj4, Object obj5);

    public native char n11111333111333(char c2, Object obj, Object obj2, Object obj3, char c3, char c4, char c5, Object obj4, Object obj5, Object obj6);

    public native char n11111333331(char c2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, char c3);

    public native char n11112(double d2);

    public native char n111121(double d2, char c2);

    public native char n1111211(double d2, char c2, char c3);

    public native char n11112111(double d2, char c2, char c3, char c4);

    public native char n111121111(double d2, char c2, char c3, char c4, char c5);

    public native char n1111211111(double d2, char c2, char c3, char c4, char c5, char c6);

    public native char n111121111111111(double d2, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9, char c10, char c11);

    public native char n1111211123(double d2, char c2, char c3, char c4, double d3, Object obj);

    public native char n111121121(double d2, char c2, char c3, double d3, char c4);

    public native char n111121122(double d2, char c2, char c3, double d3, double d4);

    public native char n11112122(double d2, char c2, double d3, double d4);

    public native char n111121221(double d2, char c2, double d3, double d4, char c3);

    public native char n111121223(double d2, char c2, double d3, double d4, Object obj);

    public native char n1111213(double d2, char c2, Object obj);

    public native char n1111213122(double d2, char c2, Object obj, char c3, double d3, double d4);

    public native char n111122(double d2, double d3);

    public native char n1111221(double d2, double d3, char c2);

    public native char n11112211(double d2, double d3, char c2, char c3);

    public native char n111122113(double d2, double d3, char c2, char c3, Object obj);

    public native char n1111222(double d2, double d3, double d4);

    public native char n11112221(double d2, double d3, double d4, char c2);

    public native char n1111223(double d2, double d3, Object obj);

    public native char n11112232(double d2, double d3, Object obj, double d4);

    public native char n111123(double d2, Object obj);

    public native char n1111231(double d2, Object obj, char c2);

    public native char n11112311(double d2, Object obj, char c2, char c3);

    public native char n111123111(double d2, Object obj, char c2, char c3, char c4);

    public native char n1111231111111113131(double d2, Object obj, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9, char c10, Object obj2, char c11, Object obj3, char c12);

    public native char n111123111111122(double d2, Object obj, char c2, char c3, char c4, char c5, char c6, char c7, char c8, double d3, double d4);

    public native char n11112311111112212(double d2, Object obj, char c2, char c3, char c4, char c5, char c6, char c7, char c8, double d3, double d4, char c9, double d5);

    public native char n111123111111221(double d2, Object obj, char c2, char c3, char c4, char c5, char c6, char c7, double d3, double d4, char c8);

    public native char n111123111111221311111112212(double d2, Object obj, char c2, char c3, char c4, char c5, char c6, char c7, double d3, double d4, char c8, Object obj2, char c9, char c10, char c11, char c12, char c13, char c14, char c15, double d5, double d6, char c16, double d7);

    public native char n1111231111122121(double d2, Object obj, char c2, char c3, char c4, char c5, char c6, double d3, double d4, char c7, double d5, char c8);

    public native char n11112311112(double d2, Object obj, char c2, char c3, char c4, char c5, double d3);

    public native char n1111231221(double d2, Object obj, char c2, double d3, double d4, char c3);

    public native char n11112312222(double d2, Object obj, char c2, double d3, double d4, double d5, double d6);

    public native char n1111232(double d2, Object obj, double d3);

    public native char n11112321(double d2, Object obj, double d3, char c2);

    public native char n11112322(double d2, Object obj, double d3, double d4);

    public native char n111123221(double d2, Object obj, double d3, double d4, char c2);

    public native char n111123223(double d2, Object obj, double d3, double d4, Object obj2);

    public native char n11112323(double d2, Object obj, double d3, Object obj2);

    public native char n1111233(double d2, Object obj, Object obj2);

    public native char n11112331(double d2, Object obj, Object obj2, char c2);

    public native char n11112331111111(double d2, Object obj, Object obj2, char c2, char c3, char c4, char c5, char c6, char c7, char c8);

    public native char n11113(Object obj);

    public native char n111131(Object obj, char c2);

    public native char n1111311(Object obj, char c2, char c3);

    public native char n11113211(Object obj, double d2, char c2, char c3);

    public native char n111133(Object obj, Object obj2);

    public native char n11113311(Object obj, Object obj2, char c2, char c3);

    public native char n111133111(Object obj, Object obj2, char c2, char c3, char c4);

    public native char n1111333(Object obj, Object obj2, Object obj3);

    public native char n11113333(Object obj, Object obj2, Object obj3, Object obj4);

    public native char n11113333313(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, char c2, Object obj6);

    public native double n1112();

    public native double n111211(char c2, char c3);

    public native double n111212(char c2, double d2);

    public native double n11121331111(char c2, Object obj, Object obj2, char c3, char c4, char c5, char c6);

    public native double n1112133313(char c2, Object obj, Object obj2, Object obj3, char c3, Object obj4);

    public native double n11122(double d2);

    public native double n111221(double d2, char c2);

    public native double n1112211(double d2, char c2, char c3);

    public native double n111222(double d2, double d3);

    public native double n1112221(double d2, double d3, char c2);

    public native double n1112223(double d2, double d3, Object obj);

    public native double n11122231(double d2, double d3, Object obj, char c2);

    public native double n11122232(double d2, double d3, Object obj, double d4);

    public native double n1112231(double d2, Object obj, char c2);

    public native double n1112232(double d2, Object obj, double d3);

    public native double n11122331(double d2, Object obj, Object obj2, char c2);

    public native double n11123(Object obj);

    public native double n11123111(Object obj, char c2, char c3, char c4);

    public native double n1112313(Object obj, char c2, Object obj2);

    public native double n111232(Object obj, double d2);

    public native double n11123221(Object obj, double d2, double d3, char c2);

    public native double n111233(Object obj, Object obj2);

    public native double n1112331111(Object obj, Object obj2, char c2, char c3, char c4, char c5);

    public native double n11123313(Object obj, Object obj2, char c2, Object obj3);

    public native double n11123333(Object obj, Object obj2, Object obj3, Object obj4);

    public native Object n1113();

    public native Object n11131(char c2);

    public native Object n111311(char c2, char c3);

    public native Object n11131111(char c2, char c3, char c4, char c5);

    public native Object n111311113(char c2, char c3, char c4, char c5, Object obj);

    public native Object n11131113(char c2, char c3, char c4, Object obj);

    public native Object n111313(char c2, Object obj);

    public native Object n11131333(char c2, Object obj, Object obj2, Object obj3);

    public native Object n11132(double d2);

    public native Object n111321(double d2, char c2);

    public native Object n1113211133(double d2, char c2, char c3, char c4, Object obj, Object obj2);

    public native Object n111321133(double d2, char c2, char c3, Object obj, Object obj2);

    public native Object n11132121(double d2, char c2, double d3, char c3);

    public native Object n11132123(double d2, char c2, double d3, Object obj);

    public native Object n111321232(double d2, char c2, double d3, Object obj, double d4);

    public native Object n111321331(double d2, char c2, Object obj, Object obj2, char c3);

    public native Object n111322(double d2, double d3);

    public native Object n1113221(double d2, double d3, char c2);

    public native Object n11132211(double d2, double d3, char c2, char c3);

    public native Object n11132222(double d2, double d3, double d4, double d5);

    public native Object n1113223(double d2, double d3, Object obj);

    public native Object n11132232(double d2, double d3, Object obj, double d4);

    public native Object n111323(double d2, Object obj);

    public native Object n1113233(double d2, Object obj, Object obj2);

    public native Object n11132331(double d2, Object obj, Object obj2, char c2);

    public native Object n111323333(double d2, Object obj, Object obj2, Object obj3, Object obj4);

    public native Object n11133(Object obj);

    public native Object n111331(Object obj, char c2);

    public native Object n1113311(Object obj, char c2, char c3);

    public native Object n1113311111(Object obj, char c2, char c3, char c4, char c5, char c6);

    public native Object n11133131(Object obj, char c2, Object obj2, char c3);

    public native Object n1113313331(Object obj, char c2, Object obj2, Object obj3, Object obj4, char c3);

    public native Object n111332(Object obj, double d2);

    public native Object n111333(Object obj, Object obj2);

    public native Object n11133311(Object obj, Object obj2, char c2, char c3);

    public native Object n111333111(Object obj, Object obj2, char c2, char c3, char c4);

    public native Object n11133313(Object obj, Object obj2, char c2, Object obj3);

    public native Object n111333131333(Object obj, Object obj2, char c2, Object obj3, char c3, Object obj4, Object obj5, Object obj6);

    public native Object n11133313331(Object obj, Object obj2, char c2, Object obj3, Object obj4, Object obj5, char c3);

    public native Object n11133313333(Object obj, Object obj2, char c2, Object obj3, Object obj4, Object obj5, Object obj6);

    public native Object n1113333(Object obj, Object obj2, Object obj3);

    public native Object n11133331(Object obj, Object obj2, Object obj3, char c2);

    public native Object n111333313(Object obj, Object obj2, Object obj3, char c2, Object obj4);

    public native Object n11133333(Object obj, Object obj2, Object obj3, Object obj4);

    public native Object n11133333311(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, char c2, char c3);

    public native Object n11133333313(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, char c2, Object obj6);

    public native Object n111333333313(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, char c2, Object obj7);

    public native Object n11133333333(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7);

    @Override // android.app.Application
    public void onCreate() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        super.onCreate();
        if (a()) {
            return;
        }
        if (runApp != null) {
            MyJni.run(runApp.getBaseContext(), newApp);
        }
        if (newApp != null) {
            MyJni.ip(newApp);
            newApp.onCreate();
        } else {
            MyJni.ip(runApp);
            new StringBuilder(a.auu.a.c("FRcBCzxTKDckBBUNGgYvER0KD10LKxI1FRFTDD1FGhANH0k8EBokEQNFJxZU")).append(runApp);
        }
        new StringBuilder(a.auu.a.c("FRcBCzxTEScIEV8=")).append(String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        e = getApplicationContext();
        new StringBuilder(a.auu.a.c("FQoaJhMWBDoAKUUEHQFiRQAMDBZf")).append(String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
