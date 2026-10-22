package com.alibaba.analytics.core;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.t;
import com.alibaba.analytics.a.u;
import com.alibaba.analytics.a.y;
import com.alibaba.analytics.core.a.e;
import com.alibaba.analytics.core.a.f;
import com.alibaba.analytics.core.a.h;
import com.alibaba.analytics.core.a.k;
import com.alibaba.analytics.core.a.m;
import com.alibaba.analytics.core.a.n;
import com.alibaba.analytics.core.a.o;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.selfmonitor.i;
import com.alibaba.analytics.core.sync.UploadMode;
import com.alibaba.openid.OpenDeviceId;
import com.beizi.fusion.BeiZiBiddingConstant;
import com.ut.mini.UTAnalyticsDelegate;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.zj.adlib.xh9;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f23771a = new d();
    private String f;
    private Context mContext = null;
    private String u = null;
    private String v = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile IUTRequestAuthentication f639a = null;
    private String w = null;
    private String x = null;
    private String y = null;
    private String z = null;
    private String A = null;
    private String B = null;
    private boolean n = false;
    private String C = null;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private Map<String, String> f640f = null;
    private boolean o = false;
    private String D = null;
    private volatile boolean p = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.analytics.core.b.a f638a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private e f637a = null;
    private volatile boolean q = false;
    private volatile String E = null;
    private volatile boolean r = false;
    private String F = "";
    private boolean s = false;
    private boolean t = false;

    /* JADX INFO: renamed from: u, reason: collision with other field name */
    private boolean f641u = false;

    /* JADX INFO: renamed from: v, reason: collision with other field name */
    private boolean f642v = false;

    /* JADX INFO: renamed from: w, reason: collision with other field name */
    private boolean f643w = true;

    /* JADX INFO: renamed from: x, reason: collision with other field name */
    private boolean f644x = false;

    /* JADX INFO: renamed from: y, reason: collision with other field name */
    private boolean f645y = false;

    /* JADX INFO: renamed from: z, reason: collision with other field name */
    private boolean f646z = false;
    private String G = null;

    /* JADX INFO: renamed from: A, reason: collision with other field name */
    private boolean f636A = false;

    private void l() {
        try {
            Map<String, String> mapA = com.alibaba.analytics.a.a.a(this.mContext);
            if (mapA == null || mapA.size() <= 0) {
                return;
            }
            HashMap map = new HashMap();
            map.put(LogField.EVENTID.toString(), BeiZiBiddingConstant.Adn.ADN_JD);
            map.putAll(mapA);
            UTAnalyticsDelegate.getInstance().transferLog(map);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m() {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("UTCommon", 0);
        String string = sharedPreferences.getString("_lun", "");
        if (!u.isEmpty(string)) {
            try {
                this.z = new String(com.alibaba.analytics.a.b.decode(string.getBytes(), 2), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String string2 = sharedPreferences.getString("_luid", "");
        if (!u.isEmpty(string2)) {
            try {
                this.B = new String(com.alibaba.analytics.a.b.decode(string2.getBytes(), 2), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        String string3 = sharedPreferences.getString("_openid", "");
        if (u.isEmpty(string3)) {
            return;
        }
        try {
            this.f = new String(com.alibaba.analytics.a.b.decode(string3.getBytes(), 2), "UTF-8");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static boolean m110m() {
        return true;
    }

    private void q() {
        if (this.mContext == null) {
            return;
        }
        j.d();
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("UTRealTimeDebug", 0);
        long j = sharedPreferences.getLong("debug_date", 0L);
        j.d("", "debugDate", Long.valueOf(j));
        if (System.currentTimeMillis() - j <= 14400000) {
            HashMap map = new HashMap();
            map.put("debug_api_url", sharedPreferences.getString("debug_api_url", ""));
            map.put("debug_key", sharedPreferences.getString("debug_key", ""));
            turnOnRealTimeDebug(map);
        }
    }

    public synchronized void b(boolean z) {
        this.s = z;
    }

    public synchronized void c(boolean z) {
        this.f641u = z;
    }

    public void d(boolean z) {
        this.f642v = z;
    }

    public String e() {
        return this.E;
    }

    public String f() {
        return this.v;
    }

    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    public boolean m115g() {
        return this.f643w;
    }

    public String getAppkey() {
        return this.u;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getOaid() {
        return this.F;
    }

    /* JADX INFO: renamed from: h, reason: collision with other method in class */
    public synchronized boolean m116h() {
        return true;
    }

    @Deprecated
    /* JADX INFO: renamed from: i, reason: collision with other method in class */
    public void m117i() {
        this.q = true;
    }

    public synchronized void init(Application application) {
        Context applicationContext = application.getApplicationContext();
        this.mContext = applicationContext;
        if (applicationContext == null) {
            j.w("UTDC init failed", "context:null");
            return;
        }
        j.i(null, "init", Boolean.valueOf(this.p));
        if (this.p) {
            h.v();
        } else {
            new Thread(new Runnable() { // from class: com.alibaba.analytics.core.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String oaid = OpenDeviceId.getOAID(d.this.mContext);
                        if (TextUtils.isEmpty(oaid)) {
                            return;
                        }
                        d.this.F = oaid;
                    } catch (Throwable unused) {
                    }
                }
            }).start();
            new Thread(new Runnable() { // from class: com.alibaba.analytics.core.d.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.alibaba.analytics.core.d.b.b(d.this.mContext);
                    } catch (Throwable unused) {
                    }
                }
            }).start();
            try {
                com.alibaba.analytics.core.selfmonitor.b.a().init();
            } catch (Throwable th) {
                j.e(null, th, new Object[0]);
            }
            try {
                i.a().init();
            } catch (Throwable th2) {
                j.e(null, th2, new Object[0]);
            }
            m();
            new com.alibaba.analytics.core.b.c(this.mContext, "ut.db").y();
            this.f638a = new com.alibaba.analytics.core.b.a(this.mContext, "ut.db");
            com.alibaba.analytics.core.e.b.g(this.mContext);
            k kVar = new k();
            this.f637a = kVar;
            kVar.a(n.a());
            this.f637a.a(o.a());
            this.f637a.a(new f());
            this.f637a.a(com.alibaba.appmonitor.c.b.a());
            this.f637a.a(m.a());
            try {
                this.f637a.a(com.alibaba.analytics.core.a.d.a());
                com.alibaba.analytics.core.a.d.a().a("sw_plugin", new com.alibaba.analytics.core.a.b());
                com.alibaba.analytics.core.a.d.a().a("audid", new com.alibaba.analytics.core.a.a());
            } catch (Throwable unused) {
            }
            this.f637a.u();
            com.alibaba.analytics.core.d.h.a().startSync();
            com.alibaba.appmonitor.a.a.init(application);
            UTAnalyticsDelegate.getInstance().initUT(application);
            q();
            com.alibaba.analytics.core.sync.f.a().start();
            l();
            this.p = true;
        }
    }

    /* JADX INFO: renamed from: j, reason: collision with other method in class */
    public void m119j() {
        this.f643w = true;
    }

    /* JADX INFO: renamed from: k, reason: collision with other method in class */
    public void m121k() {
        this.f643w = false;
    }

    /* JADX INFO: renamed from: n, reason: collision with other method in class */
    public synchronized void m126n() {
        this.o = true;
        com.alibaba.appmonitor.a.a.W = true;
    }

    /* JADX INFO: renamed from: o, reason: collision with other method in class */
    public synchronized void m128o() {
        this.n = true;
    }

    public synchronized void p() {
        this.n = false;
    }

    public void setAppVersion(String str) {
        this.x = str;
    }

    public void setChannel(String str) {
        j.d((String) null, str, str);
        this.w = str;
    }

    public void setDebug(boolean z) {
        j.setDebug(z);
    }

    public synchronized void setSessionProperties(Map<String, String> map) {
        this.f640f = map;
    }

    public void turnOffRealTimeDebug() {
        p();
        d((String) null);
        com.alibaba.analytics.core.sync.f.a().a(UploadMode.INTERVAL);
        b((Map<String, String>) null);
        this.r = false;
    }

    public void turnOnDebug() {
        setDebug(true);
    }

    public void turnOnRealTimeDebug(Map<String, String> map) {
        j.d();
        if ("0".equalsIgnoreCase(com.alibaba.analytics.core.a.d.a().get("real_time_debug"))) {
            j.w("Variables", "Server Config turn off RealTimeDebug Mode!");
            return;
        }
        if (map != null && map.containsKey("debug_api_url") && map.containsKey("debug_key")) {
            String str = map.get("debug_api_url");
            String str2 = map.get("debug_key");
            if (!u.isEmpty(str) && !u.isEmpty(str2)) {
                m128o();
                d(str2);
            }
            if (map.containsKey("debug_sampling_option")) {
                m126n();
            }
            setDebug(true);
            com.alibaba.analytics.core.sync.f.a().a(UploadMode.REALTIME);
        }
        b(map);
    }

    public void updateUserAccount(String str, String str2, String str3) {
        e(str);
        b(str2, str3);
        f(str);
    }

    private void e(String str) {
        this.y = str;
        if (u.isEmpty(str)) {
            return;
        }
        this.z = str;
    }

    private void f(String str) {
        Context context;
        if (u.isEmpty(str) || (context = this.mContext) == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("UTCommon", 0).edit();
            editorEdit.putString("_lun", new String(com.alibaba.analytics.a.b.encode(str.getBytes("UTF-8"), 2)));
            editorEdit.commit();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String d() {
        if (this.E == null) {
            return null;
        }
        return "" + this.E.hashCode();
    }

    public String g() {
        Map<String, String> mapB;
        if (TextUtils.isEmpty(this.x) && (mapB = y.b(getContext())) != null) {
            this.x = mapB.get(LogField.APPVERSION);
        }
        return this.x;
    }

    public String h() {
        return this.z;
    }

    /* JADX INFO: renamed from: i, reason: collision with other method in class */
    public synchronized boolean m118i() {
        return this.s;
    }

    public String j() {
        if (TextUtils.isEmpty(this.w)) {
            String strB = t.b(getContext(), xh9.WEBSITE_PARAMS_CHANNEL);
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
        }
        return this.w;
    }

    public String k() {
        return this.y;
    }

    public static d a() {
        return f23771a;
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g(null);
            i(null);
        } else {
            if (TextUtils.isEmpty(str2) && str.equals(this.A)) {
                return;
            }
            g(str);
            i(str2);
            h(str);
            j(str2);
        }
    }

    private void h(String str) {
        Context context;
        if (u.isEmpty(str) || (context = this.mContext) == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("UTCommon", 0).edit();
            editorEdit.putString("_luid", new String(com.alibaba.analytics.a.b.encode(str.getBytes("UTF-8"), 2)));
            editorEdit.commit();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void c(String str) {
        this.E = str;
    }

    public String i() {
        return this.B;
    }

    /* JADX INFO: renamed from: k, reason: collision with other method in class */
    public synchronized boolean m122k() {
        return this.n;
    }

    /* JADX INFO: renamed from: o, reason: collision with other method in class */
    public boolean m129o() {
        if (this.f646z) {
            return this.f645y;
        }
        Context context = getContext();
        if (context == null) {
            return false;
        }
        if ("1".equalsIgnoreCase(com.alibaba.analytics.a.a.a(context, "package_type"))) {
            this.f645y = true;
            this.f646z = true;
        }
        return this.f645y;
    }

    private void i(String str) {
        this.f = str;
    }

    public synchronized void a(boolean z) {
        this.t = z;
    }

    public synchronized void d(String str) {
        this.C = str;
    }

    public synchronized String n() {
        return this.C;
    }

    /* JADX INFO: renamed from: n, reason: collision with other method in class */
    public boolean m127n() {
        return this.p;
    }

    private void g(String str) {
        this.A = str;
        if (u.isEmpty(str)) {
            return;
        }
        this.B = str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public e m111a() {
        return this.f637a;
    }

    /* JADX INFO: renamed from: j, reason: collision with other method in class */
    public synchronized boolean m120j() {
        return this.o;
    }

    private void j(String str) {
        Context context = this.mContext;
        if (context != null) {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("UTCommon", 0).edit();
                if (TextUtils.isEmpty(str)) {
                    editorEdit.putString("_openid", null);
                } else {
                    editorEdit.putString("_openid", new String(com.alibaba.analytics.a.b.encode(str.getBytes("UTF-8"), 2)));
                }
                editorEdit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(IUTRequestAuthentication iUTRequestAuthentication) {
        this.f639a = iUTRequestAuthentication;
        if (iUTRequestAuthentication != null) {
            this.u = iUTRequestAuthentication.getAppkey();
        }
    }

    /* JADX INFO: renamed from: l, reason: collision with other method in class */
    public String m123l() {
        return this.A;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public IUTRequestAuthentication m113a() {
        return this.f639a;
    }

    /* JADX INFO: renamed from: l, reason: collision with other method in class */
    public boolean m124l() {
        return this.r;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Map<String, String> m114a() {
        return this.f640f;
    }

    private void b(Map<String, String> map) {
        if (this.mContext == null) {
            return;
        }
        j.d("", map);
        SharedPreferences.Editor editorEdit = this.mContext.getSharedPreferences("UTRealTimeDebug", 0).edit();
        if (map != null && map.containsKey("debug_store")) {
            editorEdit.putString("debug_api_url", map.get("debug_api_url"));
            editorEdit.putString("debug_key", map.get("debug_key"));
            editorEdit.putLong("debug_date", System.currentTimeMillis());
        } else {
            editorEdit.putLong("debug_date", 0L);
        }
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public com.alibaba.analytics.core.b.a m112a() {
        return this.f638a;
    }

    public String o() {
        if (this.f636A) {
            return this.G;
        }
        Context context = getContext();
        if (context == null) {
            return null;
        }
        String strA = com.alibaba.analytics.a.a.a(context, "build_id");
        this.G = strA;
        this.f636A = true;
        return strA;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public String m125m() {
        return this.f;
    }
}
