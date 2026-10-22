package com.baidu.xclient.gdid;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mshield.b.a.g;
import com.baidu.xclient.gdid.d.b;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f26825a = null;
    public static Context b = null;
    public static String c = "";
    public static String d = "";
    public static final HashMap<String, String> e = new HashMap<>();
    public b f;
    public String h;
    public AtomicBoolean g = new AtomicBoolean(false);
    public ConcurrentHashMap<String, String> i = new ConcurrentHashMap<>();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.g();
                d.this.a(true, true);
            } catch (Throwable th) {
                com.baidu.xclient.gdid.j.d.a(th);
            }
        }
    }

    public class b implements Runnable {
        public b(d dVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h.a().a(d.b);
            } catch (Throwable th) {
                com.baidu.xclient.gdid.j.d.a(th);
            }
        }
    }

    public static d a() {
        if (f26825a == null) {
            synchronized (d.class) {
                if (f26825a == null) {
                    f26825a = new d();
                }
            }
        }
        return f26825a;
    }

    public Object a(int i, Object obj, Object obj2, Object obj3) {
        return com.baidu.xclient.gdid.jni.c.a(b).a(i, obj, obj2, obj3);
    }

    public String a(Context context) {
        try {
            String strC = c("p");
            if (!TextUtils.isEmpty(strC)) {
                return strC;
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
        return context.getPackageName();
    }

    public String a(String str) {
        return com.baidu.xclient.gdid.jni.c.a(b).a(str);
    }

    public void a(Context context, String str, String str2) {
        try {
            if (this.g.get()) {
                return;
            }
            b = context;
            c = str;
            d = str2;
            i();
            this.g.set(true);
            new Thread(new a()).start();
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public void a(Context context, String str, String str2, HashMap<String, String> map) {
        b = context;
        c = str;
        d = str2;
        if (map != null) {
            HashMap<String, String> map2 = e;
            synchronized (map2) {
                map2.putAll(map);
            }
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x002f */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(HashMap<String, String> map) {
        if (map != null) {
            if (map.size() == 0) {
                return;
            }
            synchronized (e) {
                try {
                    for (String str : map.keySet()) {
                        e.put(str, map.get(str));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            a(jSONObject, "15027", com.baidu.xclient.gdid.b.a.a(b));
            a(jSONObject, "15003", com.baidu.mshield.b.b.a.a(b));
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            jSONObject.put(str, str2);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, StringBuilder sb) {
        try {
            a(jSONObject, "15200", "C");
            a(jSONObject, "01001", com.baidu.xclient.gdid.j.a.a(b));
            a(jSONObject, "15017", (String) com.baidu.xclient.gdid.j.d.c(b).first);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public void a(boolean z) {
        if (e.e().v()) {
            return;
        }
        if (e.e().w()) {
            b(z);
            return;
        }
        long jH = e.e().h();
        if (System.currentTimeMillis() - jH < e.e().i()) {
            b(z);
        } else {
            f();
        }
    }

    public void a(boolean z, boolean z2) {
        try {
            c.a().a(b);
            a(z);
            if (z2) {
                long jL = e.e().l();
                long jM = e.e().m();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = jCurrentTimeMillis - jL;
                if (j >= jM) {
                    e.e().e(jCurrentTimeMillis);
                } else {
                    jM -= j;
                }
                com.baidu.xclient.gdid.d.a.a(b, jM);
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public String b(String str) {
        return com.baidu.xclient.gdid.jni.c.a(b).d(str);
    }

    public void b() {
        try {
            h();
            this.g.set(false);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public final void b(JSONObject jSONObject) {
        try {
            jSONObject.put("12006", com.baidu.mshield.b.e.a.c(b, "screen_brightness"));
        } catch (Throwable unused) {
            try {
                jSONObject.put("12006", -1);
            } catch (Throwable th) {
                try {
                    com.baidu.xclient.gdid.j.d.a(th);
                } catch (Throwable th2) {
                    com.baidu.xclient.gdid.j.d.a(th2);
                }
            }
        }
    }

    public final void b(JSONObject jSONObject, StringBuilder sb) {
        StringBuilder sb2;
        String str;
        try {
            a(jSONObject, "02018", com.baidu.xclient.gdid.j.c.a("02018", c("arid"), sb));
            jSONObject.put("02015", c("arv"));
            jSONObject.put("02016", c("arl"));
            jSONObject.put("02002", com.baidu.xclient.gdid.jni.c.a(b).f());
            jSONObject.put("02003", c("mod"));
            jSONObject.put("02004", com.baidu.xclient.gdid.jni.c.a(b).k());
            jSONObject.put("02005", com.baidu.xclient.gdid.jni.c.a(b).j());
            jSONObject.put("02006", com.baidu.xclient.gdid.jni.c.a(b).i());
            jSONObject.put("02007", com.baidu.xclient.gdid.jni.c.a(b).h());
            jSONObject.put("02008", com.baidu.xclient.gdid.jni.c.a(b).g());
            jSONObject.put("15023", com.baidu.xclient.gdid.i.a.a());
            jSONObject.put("15021", com.baidu.xclient.gdid.i.a.c());
            jSONObject.put("15020", com.baidu.xclient.gdid.i.a.b());
            jSONObject.put("15022", com.baidu.xclient.gdid.i.a.d());
            String strB = g.b(b);
            String strC = g.c(b);
            jSONObject.put("15029", strB);
            jSONObject.put("15030", strC);
            a(jSONObject, "15048", com.baidu.xclient.gdid.jni.b.a(b).a());
            a(jSONObject, "p", com.baidu.mshield.b.a.e.c() ? "1" : "0");
            a(jSONObject, "s", com.baidu.xclient.gdid.jni.c.a(b).a());
            a(jSONObject, "11005", String.valueOf(com.baidu.mshield.b.a.e.b()));
            String strA = com.baidu.mshield.b.a.e.a();
            if (!TextUtils.isEmpty(strA)) {
                if (strA.contains("64")) {
                    sb2 = new StringBuilder();
                    str = "64 ";
                } else {
                    sb2 = new StringBuilder();
                    str = "32 ";
                }
                sb2.append(str);
                sb2.append(strA);
                strA = sb2.toString();
            }
            a(jSONObject, "11003", strA);
            a(jSONObject, "02010", com.baidu.xclient.gdid.i.a.a(b));
            a(jSONObject, "02012", com.baidu.xclient.gdid.i.a.b(b));
            a(jSONObject, "02059", com.baidu.xclient.gdid.jni.c.a(b).e());
            try {
                com.baidu.xclient.gdid.j.e eVar = new com.baidu.xclient.gdid.j.e();
                eVar.a(10, 10);
                String strGlGetString = eVar.f.glGetString(7937);
                a(jSONObject, "20081", eVar.f.glGetString(7936));
                a(jSONObject, "20082", strGlGetString);
                eVar.b();
            } catch (Throwable th) {
                com.baidu.xclient.gdid.j.d.a(th);
            }
            a(jSONObject, "12001", com.baidu.xclient.gdid.i.a.c(b));
            a(jSONObject, "12007", String.valueOf(com.baidu.xclient.gdid.i.a.d(b)));
            a(jSONObject, "06011", String.valueOf(com.baidu.xclient.gdid.i.a.e(b)));
            a(jSONObject, "06012", String.valueOf(com.baidu.xclient.gdid.i.a.f(b) ? 1 : 0));
        } catch (Throwable th2) {
            com.baidu.xclient.gdid.j.d.a(th2);
        }
    }

    public final void b(boolean z) {
        if (z) {
            com.baidu.xclient.gdid.j.b.b().postDelayed(new b(this), 65000L);
        } else {
            h.a().a(b);
        }
    }

    public String c(String str) {
        try {
            HashMap<String, String> map = e;
            if (map.size() <= 0) {
                return "";
            }
            synchronized (map) {
                if (!map.containsKey(str)) {
                    return "";
                }
                return map.get(str);
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
            return "";
        }
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            a(jSONObject, sb);
            a(jSONObject);
            b(jSONObject, sb);
            b(jSONObject);
            jSONObject.put("15057", sb);
            jSONObject.put("15006", TextUtils.isEmpty(com.baidu.xclient.gdid.jni.c.a(b).a()) ? 1 : 0);
            return jSONObject;
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
            return null;
        }
    }

    public synchronized String[] d() {
        String[] strArr = {"", ""};
        String str = this.h;
        if (TextUtils.isEmpty(str)) {
            return strArr;
        }
        String str2 = this.i.get(str);
        strArr[0] = str;
        strArr[1] = str2;
        return strArr;
    }

    public String e() {
        return "";
    }

    public final void f() {
        JSONObject jSONObjectC;
        try {
            if (com.baidu.xclient.gdid.j.d.a(b) && com.baidu.mshield.b.e.a.d(b) && (jSONObjectC = c()) != null) {
                if (new com.baidu.xclient.gdid.g.a(b, null).a(com.baidu.xclient.gdid.j.d.a(b, jSONObjectC, "1072101").toString())) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    e.e().g(jCurrentTimeMillis);
                    e.e().c(jCurrentTimeMillis);
                } else {
                    h.a().a(b);
                }
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public final void g() {
        try {
            this.f = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.f26828a);
            if (Build.VERSION.SDK_INT >= 33) {
                try {
                    b.registerReceiver(this.f, intentFilter, 4);
                } catch (Throwable th) {
                    com.baidu.xclient.gdid.j.d.a(th);
                }
            } else {
                b.registerReceiver(this.f, intentFilter);
            }
        } catch (Throwable th2) {
            com.baidu.xclient.gdid.j.d.a(th2);
        }
    }

    public final void h() {
        try {
            b.unregisterReceiver(this.f);
            this.f = null;
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public final void i() {
        JSONObject jSONObject;
        String strP = e.e().p();
        String strU = e.e().u();
        e.e().t();
        if (TextUtils.isEmpty(strU)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(strU);
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
        }
        if (TextUtils.isEmpty(strP)) {
            return;
        }
        this.i.put(strP, jSONObject.toString());
        this.h = strP;
    }
}
