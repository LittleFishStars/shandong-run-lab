package com.kc.openset.bean;

import androidx.camera.video.AudioStats;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.hook.LogoInfoBean;
import com.kc.openset.hook.SensitivityBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class c {
    private int A;
    private List<b> B;
    private List<a> C;
    private int D;
    private int E;
    private String F;

    @Deprecated
    private boolean V;
    private String W;
    private int Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f39708a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private List<String> i;
    private List<String> j;
    private List<String> k;
    private List<String> l;
    private List<String> m;
    private List<String> n;
    private List<String> o;
    private int p;
    private int q;
    private int r;
    private int s;
    private String t;
    private String u;
    private String v;
    private String w;
    private int x;
    private int y;
    private int z;
    private int G = 1;
    private int H = 1;
    private int I = 1;
    private int J = 1;
    private int K = 0;
    private boolean L = false;
    private int M = 0;
    private int N = 0;
    private double O = AudioStats.AUDIO_AMPLITUDE_NONE;
    private int P = 4000;
    private final Map<String, Integer> Q = new HashMap();
    private final List<SensitivityBean> R = new ArrayList();
    private final List<LogoInfoBean> S = new ArrayList();
    private String T = "";
    private final List<com.kc.openset.bean.b> U = new ArrayList();
    private int X = 2;

    @Keep
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f39709a;
        private String b;
        private String c;

        static {
            OSETSDKProtected.interface11(4305);
        }

        public a() {
        }

        public a(String str, String str2, String str3) {
            this.f39709a = str;
            this.b = str2;
            this.c = str3;
        }

        public static native /* synthetic */ String a(a aVar, String str);

        public static native /* synthetic */ String b(a aVar, String str);

        public static native /* synthetic */ String c(a aVar, String str);

        public native String a();

        public native String b();

        public native String c();
    }

    @Keep
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f39710a;
        private List<a> b;

        @Keep
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f39711a;
            private String b;

            static {
                OSETSDKProtected.interface11(4306);
            }

            public static native /* synthetic */ String a(a aVar, String str);

            public static native /* synthetic */ String b(a aVar, String str);

            public native String a();

            public native String b();
        }

        static {
            OSETSDKProtected.interface11(4307);
        }

        public static native /* synthetic */ String a(b bVar, String str);

        public static native /* synthetic */ List a(b bVar, List list);

        public native List<a> a();

        public native String b();
    }

    static {
        OSETSDKProtected.interface11(4308);
    }

    private native List<a> a(JSONObject jSONObject);

    private native List<String> a(JSONObject jSONObject, String str);

    private native void b(JSONObject jSONObject);

    private native List<b> c(JSONObject jSONObject);

    private native void d(JSONObject jSONObject);

    private native void e(JSONObject jSONObject);

    public native String A();

    public native List<String> B();

    public native int C();

    public native String D();

    public native String E();

    public native List<String> F();

    public native List<SensitivityBean> G();

    public native double H();

    public native int I();

    public native String J();

    public native boolean K();

    public native boolean L();

    public native boolean M();

    public native boolean N();

    public native boolean O();

    public native boolean P();

    public native boolean Q();

    public native boolean R();

    public native boolean S();

    public native boolean T();

    public native boolean U();

    public native boolean V();

    public native boolean W();

    public native boolean X();

    public native String a();

    public native void a(String str);

    public native List<a> b();

    public native int c();

    public native int d();

    public native int e();

    public native String f();

    public native List<String> g();

    public native Map<String, Integer> h();

    public native int i();

    public native int j();

    public native String k();

    public native int l();

    public native String m();

    public native List<String> n();

    public native List<b> o();

    public native String p();

    public native List<com.kc.openset.bean.b> q();

    public native String r();

    public native List<String> s();

    public native String t();

    public native List<String> u();

    public native String v();

    public native List<String> w();

    public native String x();

    public native List<LogoInfoBean> y();

    public native String z();
}
