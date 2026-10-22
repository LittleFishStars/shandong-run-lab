package com.kc.cw.ad.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.WebSettings;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.kc.cw.ad.SSAd;
import com.kc.cw.ad.TransparentActivity;
import com.kc.cw.ad.internal.activity.BrowserAdActivity;
import com.kc.cw.ad.internal.utilities.IS2SManager;
import com.kc.cw.ad.utils.OctUtil;
import com.kc.cw.ad.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import io.flutter.plugin.editing.SpellCheckPlugin;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class q implements IS2SManager {
    private static q C = null;
    private static boolean F = false;
    private static boolean Y = false;
    public static String p = null;
    public static String q = "";
    public static String r = "";
    public static int v = 1000;
    public static int w = 1000;
    public static long x = 7200000;
    private String D;
    private String E;
    private Boolean H;
    private float O;
    private DisplayMetrics Q;
    private com.kc.cw.ad.internal.d.h W;
    private long X;
    private String ab;
    private String ac;
    private long ad;
    public int d;
    public String i;
    public ArrayList<String> j;
    public String k;
    public String n;
    public Context s;
    public float t;
    public float u;
    public JSONArray z;
    private int G = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f39051a = 500;
    public int b = 1000;
    public int c = 0;
    public boolean e = true;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public ConcurrentHashMap<String, com.kc.cw.ad.a.a> l = new ConcurrentHashMap<>();
    public boolean m = false;
    public HashMap<String, String> o = new HashMap<>();
    private HashSet<String> I = new HashSet<>();
    private HashSet<String> J = new HashSet<>();
    private HashSet<String> K = new HashSet<>();
    private HashSet<String> L = new HashSet<>();
    private HashSet<String> M = new HashSet<>();
    private HashSet<String> N = new HashSet<>();
    private boolean P = true;
    private boolean R = false;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    public boolean y = false;
    public int A = 0;
    public int B = 0;
    private volatile int Z = 0;
    private volatile long aa = 0;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.q$4, reason: invalid class name */
    @Keep
    public class AnonymousClass4 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f39055a;
        final q b;

        public AnonymousClass4(q qVar, int i) {
            this.b = qVar;
            this.f39055a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                OctUtil.a().call(new OctUtil.C(this) { // from class: com.kc.cw.ad.internal.q.4.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final AnonymousClass4 f39056a;

                    {
                        this.f39056a = this;
                    }

                    @Override // com.kc.cw.ad.utils.OctUtil.C
                    public String e(String str) {
                        Map.Entry<String, com.kc.cw.ad.a.a> next;
                        com.kc.cw.ad.a.a value;
                        try {
                            com.kc.cw.ad.d.b.f.a("OctopusAd", "scheme:" + str);
                            ConcurrentHashMap<String, com.kc.cw.ad.a.a> concurrentHashMap = q.a().l;
                            if (concurrentHashMap.isEmpty() || TextUtils.isEmpty(str)) {
                                return null;
                            }
                            Iterator<Map.Entry<String, com.kc.cw.ad.a.a>> it = concurrentHashMap.entrySet().iterator();
                            while (it.hasNext() && (value = (next = it.next()).getValue()) != null) {
                                if (!TextUtils.isEmpty(value.k())) {
                                    for (String str2 : value.k().split(",")) {
                                        if (str.equals(str2)) {
                                            this.f39056a.b.b(value);
                                            return "";
                                        }
                                    }
                                } else if (str.equals(next.getKey()) || "octdpopen".equals(next.getKey())) {
                                    String strC = value.c();
                                    if (!TextUtils.isEmpty(strC)) {
                                        this.f39056a.b.a(value);
                                        concurrentHashMap.remove(next.getKey());
                                        if (!value.e() || TextUtils.isEmpty(value.d())) {
                                            return strC;
                                        }
                                        return strC + ";;;" + value.d();
                                    }
                                }
                            }
                            return null;
                        } catch (Exception e) {
                            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                            return null;
                        }
                    }
                }, this.f39055a);
            } catch (Throwable th) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.q$6, reason: invalid class name */
    @Keep
    public class AnonymousClass6 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List f39058a;
        final q b;

        public AnonymousClass6(q qVar, List list) {
            this.b = qVar;
            this.f39058a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.f39058a.size(); i++) {
                try {
                    com.kc.cw.ad.a.c.i iVar = (com.kc.cw.ad.a.c.i) this.f39058a.get(i);
                    if (iVar != null && !TextUtils.isEmpty(iVar.b())) {
                        String strB = iVar.b();
                        if (strB.contains("track=oct")) {
                            strB = strB + "&opt=13";
                        }
                        new i(strB).b();
                    }
                    if (iVar != null && !TextUtils.isEmpty(iVar.c())) {
                        String strC = iVar.c();
                        this.b.X = com.kc.cw.ad.d.b.i.d();
                        k.a().a(new k.a(this, strC) { // from class: com.kc.cw.ad.internal.q.6.1

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            final String f39059a;
                            final AnonymousClass6 b;

                            {
                                this.b = this;
                                this.f39059a = strC;
                            }

                            @Override // com.kc.cw.ad.internal.k.a
                            public void a(String str) {
                                if ("AppBackground".equals(str)) {
                                    this.b.b.e(this.f39059a);
                                    k.a().b(this);
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
                    return;
                }
            }
        }
    }

    public static /* synthetic */ int a(q qVar) {
        int i = qVar.G;
        qVar.G = i + 1;
        return i;
    }

    public static q a() {
        q qVar;
        synchronized (q.class) {
            try {
                if (C == null) {
                    C = new q();
                }
                qVar = C;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVar;
    }

    private String a(Context context, String str, String str2) {
        String str3 = c(str2) + "/sdk/config?appId=" + str + "&bundle=" + context.getPackageName() + "&brand=" + Build.BRAND + "&model=" + Build.MODEL + "&sdkVersion=2.6.1.8&os=android";
        if (this.f) {
            str3 = str3 + "&ssl=1";
        }
        if (!((SSAd.getCustomController() == null || SSAd.getCustomController().isCanUseAppList()) ? false : true)) {
            return str3;
        }
        return str3 + "&alist=0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kc.cw.ad.a.a aVar) {
        List<com.kc.cw.ad.a.c.i> listI;
        if (aVar == null || (listI = aVar.i()) == null) {
            return;
        }
        for (int i = 0; i < listI.size(); i++) {
            com.kc.cw.ad.a.c.i iVar = listI.get(i);
            if (iVar != null && !TextUtils.isEmpty(iVar.a())) {
                String strA = iVar.a();
                if (strA.contains("track=oct")) {
                    strA = strA + "&opt=13";
                }
                new i(strA).b();
            }
        }
        com.kc.cw.ad.d.e.a(new AnonymousClass6(this, listI), aVar.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.kc.cw.ad.a.a aVar) {
        if (aVar != null) {
            o.a(new l("DPFORBID", aVar.l(), aVar.a(), System.currentTimeMillis() - aVar.h(), aVar.k()));
        }
    }

    public static /* synthetic */ int c(q qVar) {
        int i = qVar.G;
        qVar.G = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (TextUtils.isEmpty(this.ab) || TextUtils.isEmpty(this.ac)) {
            return;
        }
        o.a(new l("OTHERDPJUMP", this.ab, this.ac, this.ad, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("track=oct")) {
                str = str + "&opt=13&result=0";
            }
            new i(str).b();
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private com.kc.cw.ad.internal.d.h u() {
        Context context = this.s;
        if (context == null) {
            return null;
        }
        try {
            return new com.kc.cw.ad.internal.d.h.a(context).a(536870912L).a();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Map.Entry<String, com.kc.cw.ad.a.a> next;
        com.kc.cw.ad.a.a value;
        try {
            ConcurrentHashMap<String, com.kc.cw.ad.a.a> concurrentHashMap = a().l;
            if (concurrentHashMap.isEmpty()) {
                return;
            }
            Iterator<Map.Entry<String, com.kc.cw.ad.a.a>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext() && (value = (next = it.next()).getValue()) != null) {
                if ("octdpopen".equals(next.getKey())) {
                    String strC = value.c();
                    if (TextUtils.isEmpty(strC)) {
                        continue;
                    } else {
                        concurrentHashMap.remove(next.getKey());
                        a(value);
                        OctUtil.a().a(this.s, strC, value.d(), false, null);
                    }
                }
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void w() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Throwable unused) {
        }
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Method declaredMethod = cls.getDeclaredMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objInvoke, true);
        } catch (Throwable unused2) {
        }
    }

    public void a(float f) {
        x.a(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        x.a(p, (Object) "Octopus.initialize() must be called prior to setting the app volume.");
        this.O = f;
    }

    public void a(int i) {
        if (this.T || !this.V) {
            return;
        }
        this.T = true;
        ThreadUtils.runOnUIThread(new AnonymousClass4(this, i));
    }

    public void a(Context context, String str) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        synchronized (q.class) {
            try {
                if (context == null) {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
                try {
                    Log.i("OctopusAd", "SDK_VERSION:2.6.1.8");
                    this.s = context.getApplicationContext();
                    ThreadUtils.runOnThreadPool(new Runnable(this) { // from class: com.kc.cw.ad.internal.q.1

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        final q f39052a;

                        {
                            this.f39052a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f39052a.m();
                        }
                    });
                    com.kc.cw.ad.internal.c.f.a(this.s);
                    p = str;
                    DisplayMetrics displayMetrics = this.s.getResources().getDisplayMetrics();
                    this.Q = displayMetrics;
                    int i = displayMetrics.widthPixels;
                    int i2 = displayMetrics.heightPixels;
                    if (i < i2) {
                        this.t = i / 720.0f;
                        this.u = i2 / 1280.0f;
                    } else {
                        this.t = i2 / 720.0f;
                        this.u = i / 1280.0f;
                    }
                    this.V = com.kc.cw.ad.d.b.i.b("com.kc.cw.ad.utils.OctUtil$C");
                    this.e = com.kc.cw.ad.internal.c.o.c(this.s, "getBootId");
                    this.h = com.kc.cw.ad.internal.c.o.c(this.s, "getOperator");
                    this.g = com.kc.cw.ad.internal.c.o.c(this.s, "ipv6");
                    this.f = com.kc.cw.ad.internal.c.o.a(this.s, "ssl", SSAd.getCustomController() != null && SSAd.getCustomController().isUseHttps());
                    this.i = com.kc.cw.ad.internal.c.o.b(this.s, "sdk");
                    this.j = com.kc.cw.ad.internal.c.o.a(this.s, "sdkList");
                    this.k = com.kc.cw.ad.internal.c.o.b(this.s, "sdklog");
                    this.Z = com.kc.cw.ad.internal.c.o.b(this.s, SpellCheckPlugin.START_INDEX_KEY, 0);
                    this.H = (Boolean) com.kc.cw.ad.internal.c.o.c(this.s, "encrypt", Boolean.TRUE);
                    com.kc.cw.a.a.a().a(this.s);
                    com.kc.cw.a.a.a().b();
                    a().B = com.kc.cw.ad.internal.c.o.b(this.s, "minimumMemory", 0);
                    if (!a().c()) {
                        new m(a(this.s, str, this.i)).b();
                    }
                    ((Application) this.s).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks(this) { // from class: com.kc.cw.ad.internal.q.2

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        final q f39053a;

                        {
                            this.f39053a = this;
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityCreated(Activity activity, Bundle bundle) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityDestroyed(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityPaused(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityResumed(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStarted(Activity activity) {
                            q.a(this.f39053a);
                            if ((activity instanceof BrowserAdActivity) || (activity instanceof TransparentActivity)) {
                                return;
                            }
                            k.a().a("AppSelfForeground");
                            this.f39053a.v();
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStopped(Activity activity) {
                            q.c(this.f39053a);
                            if (this.f39053a.G < 0) {
                                this.f39053a.G = 0;
                            }
                            if (this.f39053a.G == 0) {
                                k.a().a("AppBackground");
                            }
                        }
                    });
                    if (SSAd.getCustomController() == null || SSAd.getCustomController().isCanUseOaid()) {
                        com.kc.cw.ad.d.a.b.a((Application) this.s);
                    }
                    if (!this.R) {
                        com.kc.cw.ad.d.g.a(this.s).a(new com.kc.cw.ad.d.f(this) { // from class: com.kc.cw.ad.internal.q.3

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            final q f39054a;

                            {
                                this.f39054a = this;
                            }

                            @Override // com.kc.cw.ad.d.f
                            public void a() {
                                com.kc.cw.ad.d.b.f.a("OctopusAd", "上报活跃量");
                            }

                            @Override // com.kc.cw.ad.d.f
                            public void a(long j, long j2) {
                                com.kc.cw.ad.d.b.f.a("OctopusAd", "在线时长:" + (j2 - j));
                                com.kc.cw.ad.internal.c.o.a(this.f39054a.s, "startTime", Long.valueOf(j));
                                com.kc.cw.ad.internal.c.o.a(this.f39054a.s, "endTime", Long.valueOf(j2));
                            }
                        });
                    }
                    this.R = true;
                    if (Build.VERSION.SDK_INT >= 28) {
                        w();
                    }
                    o.a(new l("INIT", str, 1));
                } catch (Exception e) {
                    o.a(new l("INIT", str, 0));
                    com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str) {
        this.D = str;
    }

    public void a(String str, String str2, long j) {
        this.ab = str;
        this.ac = str2;
        this.ad = j;
        if (this.U) {
            return;
        }
        this.U = true;
        try {
            if (com.kc.cw.ad.d.b.i.b("com.kc.cw.ad.utils.OctUtil$E")) {
                OctUtil.a().error(new OctUtil.E(this) { // from class: com.kc.cw.ad.internal.q.5

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final q f39057a;

                    {
                        this.f39057a = this;
                    }

                    @Override // com.kc.cw.ad.utils.OctUtil.E
                    public void e(Throwable th) {
                        this.f39057a.d(th.getMessage());
                    }
                });
            }
        } catch (Throwable th) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    public void a(String str, boolean z) {
    }

    public void a(boolean z) {
        x.a(p, (Object) "Octopus.initialize() must be called prior to setting the app volume.");
        this.P = z;
    }

    public com.kc.cw.ad.internal.d.h b() {
        if (this.s == null) {
            return null;
        }
        com.kc.cw.ad.internal.d.h hVar = this.W;
        if (hVar != null) {
            return hVar;
        }
        com.kc.cw.ad.internal.d.h hVarU = u();
        this.W = hVarU;
        return hVarU;
    }

    public String b(String str, boolean z) {
        String str2;
        Boolean bool = this.H;
        if (bool == null || bool.booleanValue()) {
            str2 = z ? "/api/zysdksd?isEncrypt=2" : "/api/zysdk?isEncrypt=2";
        } else {
            str2 = z ? "/api/zysdksd?isEncrypt=0" : "/api/zysdk?isEncrypt=0";
        }
        return c(str) + str2;
    }

    public void b(int i) {
        v = i;
        w = i;
    }

    public void b(String str) {
        this.E = str;
    }

    public void b(boolean z) {
        Y = z;
    }

    public String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strReplace = this.f ? "http://sdk.zhangyuyidong.cn".replace("http:", "https:") : "http://sdk.zhangyuyidong.cn";
        return this.g ? strReplace.replace("sdk.", "sdk6.") : strReplace;
    }

    public boolean c() {
        int i = this.B;
        return i > 0 && i < 100 && com.kc.cw.ad.d.b.i.a() < ((long) this.B) * 1000000;
    }

    public void d() {
        String str;
        if (this.S) {
            return;
        }
        this.S = true;
        try {
            OctUtil.a().init(this.s);
        } catch (Exception e) {
            e = e;
            str = "An Exception Caught";
            com.kc.cw.ad.d.b.f.a("OctopusAd", str, e);
        } catch (Throwable th) {
            e = th;
            str = "A Throwable Caught";
            com.kc.cw.ad.d.b.f.a("OctopusAd", str, e);
        }
    }

    public void e() {
        JSONArray jSONArray;
        try {
            if (this.A <= 0 || (jSONArray = this.z) == null || jSONArray.length() <= 0 || System.currentTimeMillis() - this.aa <= 5000) {
                return;
            }
            this.aa = System.currentTimeMillis();
            if (this.Z >= this.z.length()) {
                this.Z = 0;
            }
            ArrayList arrayList = new ArrayList();
            String strB = com.kc.cw.ad.d.b.i.b(l());
            if (!TextUtils.isEmpty(strB)) {
                arrayList = new ArrayList(Arrays.asList(strB.split(", ")));
            }
            int iMin = Math.min(this.Z + this.A, this.z.length());
            for (int i = this.Z; i < iMin; i++) {
                JSONObject jSONObject = this.z.getJSONObject(i);
                String strOptString = jSONObject.optString(LoginConstants.SID);
                String strOptString2 = jSONObject.optString(com.igexin.push.core.b.aC);
                boolean zA = com.kc.cw.ad.d.b.i.a(strOptString2);
                if (!zA) {
                    zA = com.kc.cw.ad.d.b.i.c(this.s, strOptString2);
                }
                if (!zA) {
                    arrayList.remove(strOptString);
                } else if (!arrayList.contains(strOptString)) {
                    arrayList.add(strOptString);
                }
            }
            com.kc.cw.ad.d.b.f.c("OctopusAd", arrayList.toString());
            this.Z = iMin;
            com.kc.cw.ad.internal.c.o.a(this.s, SpellCheckPlugin.START_INDEX_KEY, Integer.valueOf(this.Z));
            com.kc.cw.ad.d.b.f.c("OctopusAd", this.Z + "");
            if (arrayList.isEmpty()) {
                return;
            }
            String strReplace = arrayList.toString().replace("[", "").replace("]", "");
            com.kc.cw.ad.internal.c.o.a(this.s, "codeList", strReplace);
            com.kc.cw.ad.internal.c.a.a().F = strReplace;
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public boolean f() {
        return this.V;
    }

    public float g() {
        return this.O;
    }

    @Override // com.kc.cw.ad.internal.utilities.IS2SManager
    public String getBuyerId() {
        return !this.R ? "" : p;
    }

    @Override // com.kc.cw.ad.internal.utilities.IS2SManager
    public String getSDKInfo(String str) {
        if (!this.R) {
            return "";
        }
        w wVar = new w(str);
        wVar.a();
        return wVar.d();
    }

    public boolean h() {
        return this.P;
    }

    public String i() {
        return this.D;
    }

    public String j() {
        return this.E;
    }

    public String k() {
        return p;
    }

    public Context l() {
        return this.s;
    }

    public String m() {
        String str;
        synchronized (this) {
            if (TextUtils.isEmpty(this.n)) {
                try {
                    this.n = WebSettings.getDefaultUserAgent(this.s);
                } catch (Exception e) {
                    com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                }
                if (TextUtils.isEmpty(this.n)) {
                    this.n = "Mozilla/5.0 (Linux; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + " Build/UP1A.231005.007; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/116.0.0.0 Mobile Safari/537.36";
                }
            }
            str = this.n;
        }
        return str;
    }

    public String n() {
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        String strReplace = this.f ? "http://sdklog.zhangyuyidong.cn".replace("http:", "https:") : "http://sdklog.zhangyuyidong.cn";
        return this.g ? strReplace.replace("sdklog.", "sdklog6.") : strReplace;
    }

    public float o() {
        return this.t;
    }

    public float p() {
        return this.u;
    }

    public float q() {
        return Math.max(this.t, this.u);
    }

    public DisplayMetrics r() {
        return this.Q;
    }

    public HashSet<String> s() {
        return this.N;
    }

    public boolean t() {
        return Y;
    }
}
