package com.alipay.sdk.m.m;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: com.alipay.sdk.m.m.a$a, reason: collision with other inner class name */
    public class RunnableC0196a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25460a;
        public final /* synthetic */ com.alipay.sdk.m.w.a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public RunnableC0196a(Context context, com.alipay.sdk.m.w.a aVar, String str, String str2) {
            this.f25460a = context;
            this.b = aVar;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.a(this.f25460a, this.b.n.d(this.c), this.d);
            } catch (Throwable th) {
                g.a(th);
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f25461a = "RecordPref";
        public static final String b = "alipay_cashier_statistic_record";

        public static synchronized String a(Context context, String str, String str2) {
            g.b(f25461a, "stat append " + str2 + " , " + str);
            if (context != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = UUID.randomUUID().toString();
                }
                C0197a c0197aA = a(context);
                if (c0197aA.f25462a.size() > 20) {
                    c0197aA.f25462a.clear();
                }
                c0197aA.f25462a.put(str2, str);
                a(context, c0197aA);
                return str2;
            }
            return null;
        }

        public static synchronized String b(Context context) {
            g.b(f25461a, "stat peek");
            if (context == null) {
                return null;
            }
            C0197a c0197aA = a(context);
            if (c0197aA.f25462a.isEmpty()) {
                return null;
            }
            try {
                return c0197aA.f25462a.entrySet().iterator().next().getValue();
            } catch (Throwable th) {
                g.a(th);
                return null;
            }
        }

        /* JADX INFO: renamed from: com.alipay.sdk.m.m.a$b$a, reason: collision with other inner class name */
        public static final class C0197a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final LinkedHashMap<String, String> f25462a = new LinkedHashMap<>();

            public C0197a() {
            }

            public String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.f25462a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th) {
                    g.a(th);
                    return new JSONArray().toString();
                }
            }

            public C0197a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        this.f25462a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    g.a(th);
                }
            }
        }

        public static synchronized int a(Context context, String str) {
            g.b(f25461a, "stat remove " + str);
            if (context != null && !TextUtils.isEmpty(str)) {
                C0197a c0197aA = a(context);
                if (c0197aA.f25462a.isEmpty()) {
                    return 0;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, String> entry : c0197aA.f25462a.entrySet()) {
                        if (str.equals(entry.getValue())) {
                            arrayList.add(entry.getKey());
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        c0197aA.f25462a.remove((String) it.next());
                    }
                    a(context, c0197aA);
                    return arrayList.size();
                } catch (Throwable th) {
                    g.a(th);
                    int size = c0197aA.f25462a.size();
                    a(context, new C0197a());
                    return size;
                }
            }
            return 0;
        }

        public static synchronized C0197a a(Context context) {
            try {
                String strA = m.a(null, context, b, null);
                if (TextUtils.isEmpty(strA)) {
                    return new C0197a();
                }
                return new C0197a(strA);
            } catch (Throwable th) {
                g.a(th);
                return new C0197a();
            }
        }

        public static synchronized void a(Context context, C0197a c0197a) {
            if (c0197a == null) {
                try {
                    c0197a = new C0197a();
                } catch (Throwable th) {
                    g.a(th);
                }
            }
            m.b(null, context, b, c0197a.a());
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: com.alipay.sdk.m.m.a$c$a, reason: collision with other inner class name */
        public class RunnableC0198a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f25463a;
            public final /* synthetic */ Context b;

            public RunnableC0198a(String str, Context context) {
                this.f25463a = str;
                this.b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f25463a) || c.b(this.b, this.f25463a)) {
                    for (int i = 0; i < 4; i++) {
                        String strB = b.b(this.b);
                        if (TextUtils.isEmpty(strB) || !c.b(this.b, strB)) {
                            return;
                        }
                    }
                }
            }
        }

        public static boolean b(Context context, String str) {
            g.b(com.alipay.sdk.m.n.a.B, "stat sub " + str);
            try {
                if ((com.alipay.sdk.m.o.b.i().g() ? new com.alipay.sdk.m.u.e() : new com.alipay.sdk.m.u.f()).a((com.alipay.sdk.m.w.a) null, context, str) == null) {
                    return false;
                }
                b.a(context, str);
                return true;
            } catch (Throwable th) {
                g.a(th);
                return false;
            }
        }

        public static synchronized void a(Context context, com.alipay.sdk.m.m.b bVar, String str, String str2) {
            if (context == null || bVar == null || str == null) {
                return;
            }
            a(context, bVar.d(str), str2);
        }

        public static synchronized void a(Context context) {
            a(context, null, null);
        }

        public static synchronized void a(Context context, String str, String str2) {
            if (context == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                b.a(context, str, str2);
            }
            new Thread(new RunnableC0198a(str, context)).start();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f25464a = "alipay_cashier_ap_seq_v";

        public static synchronized long a(Context context) {
            return e.a(context, f25464a);
        }
    }

    public static final class e {
        public static synchronized long a(Context context, String str) {
            long j;
            String strA;
            try {
                strA = m.a(null, context, str, null);
            } catch (Throwable unused) {
            }
            j = (!TextUtils.isEmpty(strA) ? Long.parseLong(strA) : 0L) + 1;
            try {
                m.b(null, context, str, Long.toString(j));
            } catch (Throwable unused2) {
            }
            return j;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f25465a = "alipay_cashier_statistic_v";

        public static synchronized long a(Context context) {
            return e.a(context, f25465a);
        }
    }

    public static synchronized void a(Context context, com.alipay.sdk.m.w.a aVar, String str, String str2) {
        if (context == null || aVar == null) {
            return;
        }
        g.b(com.alipay.sdk.m.n.a.B, "StatisticManager stash start");
        if (com.alipay.sdk.m.o.b.i().h(null)) {
            com.alipay.sdk.m.q.a.a(new RunnableC0196a(context, aVar, str, str2));
        } else {
            try {
                b.a(context, aVar.n.d(str), str2);
            } catch (Throwable th) {
                g.a(th);
            }
        }
        g.b(com.alipay.sdk.m.n.a.B, "StatisticManager stash finish");
    }

    public static synchronized void b(Context context, com.alipay.sdk.m.w.a aVar, String str, String str2) {
        if (context == null || aVar == null) {
            return;
        }
        c.a(context, aVar.n, str, str2);
    }

    public static void b(com.alipay.sdk.m.w.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.n.c(str, str2, str3);
    }

    public static synchronized void a(Context context) {
        c.a(context);
    }

    public static void a(com.alipay.sdk.m.w.a aVar, String str, Throwable th) {
        if (aVar == null || th == null) {
            return;
        }
        aVar.n.a(str, th.getClass().getSimpleName(), th);
    }

    public static void a(com.alipay.sdk.m.w.a aVar, String str, String str2, Throwable th, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.n.a(str, str2, th, str3);
    }

    public static void a(com.alipay.sdk.m.w.a aVar, String str, String str2, Throwable th) {
        if (aVar == null) {
            return;
        }
        aVar.n.a(str, str2, th);
    }

    public static void a(com.alipay.sdk.m.w.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.n.a(str, str2, str3);
    }

    public static void a(com.alipay.sdk.m.w.a aVar, String str, String str2) {
        if (aVar == null) {
            return;
        }
        aVar.n.a(str, str2);
    }
}
