package com.igexin.push.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.igexin.push.c.e.AnonymousClass1;
import com.igexin.push.config.SDKUrlConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class h {
    private static final String e = b.f37886a + h.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f37894a;
    private Handler i;
    protected final Map<String, e> b = new LinkedHashMap();
    protected final Map<String, d> c = new HashMap();
    private final Object f = new Object();
    private final Object g = new Object();
    protected a d = new a();
    private final Comparator<Map.Entry<String, d>> h = new Comparator<Map.Entry<String, d>>() { // from class: com.igexin.push.c.h.1
        private static int a(Map.Entry<String, d> entry, Map.Entry<String, d> entry2) {
            return (int) (entry.getValue().c() - entry2.getValue().c());
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Map.Entry<String, d> entry, Map.Entry<String, d> entry2) {
            return (int) (entry.getValue().c() - entry2.getValue().c());
        }
    };

    /* JADX WARN: Code duplicated, block: B:6:0x003a  */
    public h(String str, String str2) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        if (!SDKUrlConfig.hasMultipleXfr()) {
            a();
            return;
        }
        JSONObject jSONObject2 = null;
        if (TextUtils.isEmpty(str)) {
            a();
        } else {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                com.igexin.c.a.c.a.a(e2);
                jSONObject = null;
            }
            if (jSONObject == null || jSONObject.length() == 0) {
                a();
            } else {
                if (jSONObject.has("lastDetectTime")) {
                    try {
                        this.f37894a = jSONObject.getLong("lastDetectTime");
                    } catch (JSONException e3) {
                        com.igexin.c.a.c.a.a(e3);
                    }
                }
                if (Math.abs(System.currentTimeMillis() - this.f37894a) < b.c) {
                    if (jSONObject.has(GoodsSpecificationPreviewActivity.z)) {
                        try {
                            jSONArray = jSONObject.getJSONArray(GoodsSpecificationPreviewActivity.z);
                        } catch (JSONException e4) {
                            com.igexin.c.a.c.a.a(e4);
                            jSONArray = null;
                        }
                    } else {
                        jSONArray = null;
                    }
                    if (jSONArray == null || jSONArray.length() == 0) {
                        a();
                    } else {
                        List<String> listA = a(jSONArray);
                        if (listA.isEmpty()) {
                            a();
                        } else {
                            List<String> defaultXfrList = SDKUrlConfig.getDefaultXfrList();
                            ArrayList arrayList = new ArrayList(defaultXfrList);
                            arrayList.retainAll(listA);
                            if (arrayList.size() != listA.size()) {
                                String str3 = e;
                                com.igexin.c.a.c.a.a(str3, "db cache xfr != default, use default");
                                com.igexin.c.a.c.a.a(str3 + " | db cache xfr != default, use default", new Object[0]);
                                arrayList.clear();
                                defaultXfrList.clear();
                                listA.clear();
                                a();
                            } else {
                                String str4 = e;
                                com.igexin.c.a.c.a.a(str4, "db cache xfr == default, use cache");
                                com.igexin.c.a.c.a.a(str4 + " | db cache xfr == default, use cache", new Object[0]);
                                b(jSONArray);
                            }
                        }
                    }
                } else {
                    a();
                }
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            jSONObject2 = new JSONObject(str2);
        } catch (JSONException e5) {
            com.igexin.c.a.c.a.a(e5);
        }
        if (jSONObject2 == null || jSONObject2.length() == 0) {
            return;
        }
        if (jSONObject2.has("loginFailedlCnt")) {
            try {
                this.d.g = jSONObject2.getInt("loginFailedlCnt");
            } catch (JSONException e6) {
                com.igexin.c.a.c.a.a(e6);
            }
        }
        if (jSONObject2.has("lastChange2BackupTime")) {
            try {
                this.d.h = jSONObject2.getLong("lastChange2BackupTime");
            } catch (JSONException e7) {
                com.igexin.c.a.c.a.a(e7);
            }
        }
        if (jSONObject2.has("lastOfflineTime")) {
            try {
                this.d.i = jSONObject2.getLong("lastOfflineTime");
            } catch (JSONException e8) {
                com.igexin.c.a.c.a.a(e8);
            }
        }
        if (jSONObject2.has("domainType")) {
            try {
                this.d.e = a.EnumC0850a.a(jSONObject2.getInt("domainType"));
                if (this.d.e == a.EnumC0850a.BACKUP) {
                    this.d.f.set(true);
                }
            } catch (JSONException e9) {
                com.igexin.c.a.c.a.a(e9);
            }
        }
    }

    private static d a(JSONObject jSONObject) throws Exception {
        if (!jSONObject.has("domain")) {
            return null;
        }
        d dVar = new d();
        dVar.a(jSONObject.getString("domain"));
        if (jSONObject.has("port")) {
            dVar.b = jSONObject.getInt("port");
        }
        if (jSONObject.has(LoginConstants.IP)) {
            dVar.f37890a = jSONObject.getString(LoginConstants.IP);
        }
        if (jSONObject.has("consumeTime")) {
            dVar.c = jSONObject.getLong("consumeTime");
        }
        if (jSONObject.has("detectSuccessTime")) {
            dVar.d = jSONObject.getLong("detectSuccessTime");
        }
        if (jSONObject.has("isDomain")) {
            dVar.e = jSONObject.getBoolean("isDomain");
        }
        return dVar;
    }

    private static List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(jSONArray.getJSONObject(i).getString("domain"));
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        return arrayList;
    }

    private void a() {
        this.f37894a = 0L;
        if (r()) {
            if (com.igexin.push.core.e.ap != null) {
                com.igexin.push.core.e.f.a().b("null", true);
            }
        } else if (com.igexin.push.core.e.aq != null) {
            com.igexin.push.core.e.f.a().b("null", false);
        }
        List<String> defaultXfrList = SDKUrlConfig.getDefaultXfrList();
        ArrayList arrayList = new ArrayList();
        for (String str : defaultXfrList) {
            d dVar = new d(str, Integer.parseInt(com.igexin.c.a.b.g.a(str)[2]));
            if (defaultXfrList.size() > 1) {
                b(dVar);
            }
            arrayList.add(dVar);
        }
        this.d.b(arrayList);
        defaultXfrList.clear();
    }

    private static List<String> b() {
        return SDKUrlConfig.getDefaultXfrList();
    }

    private void b(d dVar) {
        e eVar = new e();
        eVar.d = c() == b.EnumC0851b.f37888a;
        eVar.a(d());
        eVar.b = dVar;
        synchronized (this.g) {
            this.b.put(dVar.a(), eVar);
        }
    }

    private void b(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            a();
            return;
        }
        JSONArray jSONArray = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            a();
            return;
        }
        if (jSONObject.has("lastDetectTime")) {
            try {
                this.f37894a = jSONObject.getLong("lastDetectTime");
            } catch (JSONException e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
        if (Math.abs(System.currentTimeMillis() - this.f37894a) >= b.c) {
            a();
            return;
        }
        if (jSONObject.has(GoodsSpecificationPreviewActivity.z)) {
            try {
                jSONArray = jSONObject.getJSONArray(GoodsSpecificationPreviewActivity.z);
            } catch (JSONException e4) {
                com.igexin.c.a.c.a.a(e4);
            }
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            a();
            return;
        }
        List<String> listA = a(jSONArray);
        if (listA.isEmpty()) {
            a();
            return;
        }
        List<String> defaultXfrList = SDKUrlConfig.getDefaultXfrList();
        ArrayList arrayList = new ArrayList(defaultXfrList);
        arrayList.retainAll(listA);
        if (arrayList.size() == listA.size()) {
            String str2 = e;
            com.igexin.c.a.c.a.a(str2, "db cache xfr == default, use cache");
            com.igexin.c.a.c.a.a(str2 + " | db cache xfr == default, use cache", new Object[0]);
            b(jSONArray);
            return;
        }
        String str3 = e;
        com.igexin.c.a.c.a.a(str3, "db cache xfr != default, use default");
        com.igexin.c.a.c.a.a(str3 + " | db cache xfr != default, use default", new Object[0]);
        arrayList.clear();
        defaultXfrList.clear();
        listA.clear();
        a();
    }

    private void b(JSONArray jSONArray) {
        d dVar;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("domain")) {
                    dVar = new d();
                    dVar.a(jSONObject.getString("domain"));
                    if (jSONObject.has("port")) {
                        dVar.b = jSONObject.getInt("port");
                    }
                    if (jSONObject.has(LoginConstants.IP)) {
                        dVar.f37890a = jSONObject.getString(LoginConstants.IP);
                    }
                    if (jSONObject.has("consumeTime")) {
                        dVar.c = jSONObject.getLong("consumeTime");
                    }
                    if (jSONObject.has("detectSuccessTime")) {
                        dVar.d = jSONObject.getLong("detectSuccessTime");
                    }
                    if (jSONObject.has("isDomain")) {
                        dVar.e = jSONObject.getBoolean("isDomain");
                    }
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    this.c.put(dVar.a(), dVar);
                } else {
                    try {
                        dVar = d(jSONObject.getString("domain"));
                    } catch (Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                        com.igexin.c.a.c.a.a(e + "|initWithCacheData exception " + e2.toString(), new Object[0]);
                        this.c.clear();
                        a();
                        return;
                    }
                }
                if (dVar != null) {
                    b(dVar);
                    arrayList.add(dVar);
                }
            } catch (Exception e3) {
                com.igexin.c.a.c.a.a(e3);
                com.igexin.c.a.c.a.a(e + "|initWithCacheData exception " + e3.toString(), new Object[0]);
                return;
            }
        }
        this.d.b(arrayList);
    }

    private void c(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        if (jSONObject.has("loginFailedlCnt")) {
            try {
                this.d.g = jSONObject.getInt("loginFailedlCnt");
            } catch (JSONException e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
        if (jSONObject.has("lastChange2BackupTime")) {
            try {
                this.d.h = jSONObject.getLong("lastChange2BackupTime");
            } catch (JSONException e4) {
                com.igexin.c.a.c.a.a(e4);
            }
        }
        if (jSONObject.has("lastOfflineTime")) {
            try {
                this.d.i = jSONObject.getLong("lastOfflineTime");
            } catch (JSONException e5) {
                com.igexin.c.a.c.a.a(e5);
            }
        }
        if (jSONObject.has("domainType")) {
            try {
                this.d.e = a.EnumC0850a.a(jSONObject.getInt("domainType"));
                if (this.d.e == a.EnumC0850a.BACKUP) {
                    this.d.f.set(true);
                }
            } catch (JSONException e6) {
                com.igexin.c.a.c.a.a(e6);
            }
        }
    }

    private static d d(String str) {
        d dVar = new d();
        String[] strArrA = com.igexin.c.a.b.g.a(str);
        dVar.a(str);
        dVar.b = Integer.parseInt(strArrA[2]);
        return dVar;
    }

    public static void k() {
        com.igexin.push.core.e.f.a().b("null", true);
        com.igexin.push.core.e.f.a().b("null", false);
    }

    private void p() {
        synchronized (this.f) {
            this.c.clear();
        }
    }

    private boolean q() {
        long jAbs = Math.abs(System.currentTimeMillis() - this.f37894a);
        long j = b.c;
        if (jAbs >= (2 * j) - 3600) {
            com.igexin.c.a.c.a.a(e + "|current time - last detect time > " + (j / 1000) + " s, detect = true", new Object[0]);
            f.f37893a.set(true);
            return true;
        }
        if (!f.f37893a.getAndSet(true)) {
            long jAbs2 = Math.abs(j - jAbs);
            f.g().a(jAbs2, TimeUnit.MILLISECONDS);
            com.igexin.c.a.c.a.a(e + "|set next detect time = " + jAbs2, new Object[0]);
        }
        return false;
    }

    private boolean r() {
        return c() == b.EnumC0851b.b;
    }

    public final e a(String str) {
        synchronized (this.g) {
            for (Map.Entry<String, e> entry : this.b.entrySet()) {
                if (entry.getKey().equals(str)) {
                    return entry.getValue();
                }
            }
            return null;
        }
    }

    public final void a(d dVar) {
        synchronized (this.f) {
            this.c.put(dVar.a(), dVar);
        }
        a aVar = this.d;
        synchronized (aVar.d) {
            aVar.b = 0;
            Collections.sort(aVar.c, aVar.k);
        }
    }

    public abstract int c();

    public abstract i d();

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final void e() {
        /*
            r9 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r9.f37894a
            long r0 = r0 - r2
            long r0 = java.lang.Math.abs(r0)
            long r2 = com.igexin.push.c.b.c
            r4 = 2
            long r4 = r4 * r2
            r6 = 3600(0xe10, double:1.7786E-320)
            long r4 = r4 - r6
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r4 < 0) goto L43
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.igexin.push.c.h.e
            r0.append(r1)
            java.lang.String r1 = "|current time - last detect time > "
            r0.append(r1)
            r7 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r7
            r0.append(r2)
            java.lang.String r1 = " s, detect = true"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r6]
            com.igexin.c.a.c.a.a(r0, r1)
            java.util.concurrent.atomic.AtomicBoolean r0 = com.igexin.push.c.f.f37893a
            r0.set(r5)
            goto L76
        L43:
            java.util.concurrent.atomic.AtomicBoolean r4 = com.igexin.push.c.f.f37893a
            boolean r4 = r4.getAndSet(r5)
            if (r4 != 0) goto L75
            long r2 = r2 - r0
            long r0 = java.lang.Math.abs(r2)
            com.igexin.push.c.f r2 = com.igexin.push.c.f.g()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            r2.a(r0, r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = com.igexin.push.c.h.e
            r2.append(r3)
            java.lang.String r3 = "|set next detect time = "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.Object[] r1 = new java.lang.Object[r6]
            com.igexin.c.a.c.a.a(r0, r1)
        L75:
            r5 = r6
        L76:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            if (r5 != 0) goto L92
            r0.<init>()
            java.lang.String r1 = com.igexin.push.c.h.e
            r0.append(r1)
            java.lang.String r1 = "|startDetect detect = false, return !!!"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r6]
            com.igexin.c.a.c.a.a(r0, r1)
            return
        L92:
            r0.<init>()
            java.lang.String r1 = com.igexin.push.c.h.e
            r0.append(r1)
            java.lang.String r1 = "|startDetect detect = true, start detect !!!"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r6]
            com.igexin.c.a.c.a.a(r0, r1)
            r9.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.h.e():void");
    }

    public final void f() {
        synchronized (this.g) {
            for (Map.Entry<String, e> entry : this.b.entrySet()) {
                entry.getValue().a((i) null);
                entry.getValue().a();
            }
        }
    }

    public final void g() {
        f();
        p();
        List<String> defaultXfrList = SDKUrlConfig.getDefaultXfrList();
        synchronized (this.g) {
            int size = this.b.size();
            if (defaultXfrList.size() < size) {
                int size2 = size - defaultXfrList.size();
                Iterator<Map.Entry<String, e>> it = this.b.entrySet().iterator();
                for (int i = 0; it.hasNext() && i < size2; i++) {
                    it.next().getValue().b();
                    it.remove();
                }
            }
            ArrayList arrayList = new ArrayList(this.b.values());
            this.b.clear();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < defaultXfrList.size(); i2++) {
                d dVar = new d();
                String[] strArrA = com.igexin.c.a.b.g.a(defaultXfrList.get(i2));
                dVar.a(defaultXfrList.get(i2));
                dVar.b = Integer.parseInt(strArrA[2]);
                if (i2 < size) {
                    e eVar = (e) arrayList.get(i2);
                    eVar.b = dVar;
                    this.b.put(dVar.a(), eVar);
                } else {
                    b(dVar);
                }
                arrayList2.add(dVar);
            }
            this.d.b(arrayList2);
        }
    }

    public final void h() {
        f();
        p();
        List<String> defaultXfrList = SDKUrlConfig.getDefaultXfrList();
        synchronized (this.g) {
            Iterator<Map.Entry<String, e>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().b();
            }
            this.b.clear();
            ArrayList arrayList = new ArrayList();
            d dVar = new d();
            String[] strArrA = com.igexin.c.a.b.g.a(defaultXfrList.get(0));
            dVar.a(defaultXfrList.get(0));
            dVar.b = Integer.parseInt(strArrA[2]);
            arrayList.add(dVar);
            this.d.b(arrayList);
            arrayList.clear();
        }
    }

    public final void i() {
        this.f37894a = System.currentTimeMillis();
        synchronized (this.g) {
            for (Map.Entry<String, e> entry : this.b.entrySet()) {
                entry.getValue();
                entry.getValue().a(d());
                if (entry.getValue().b != null) {
                    entry.getValue().b.b();
                }
                e value = entry.getValue();
                synchronized (i.class) {
                    if (value.c != null) {
                        value.f37891a = com.igexin.b.a.a().f37791a.submit(value.new AnonymousClass1());
                    }
                }
            }
        }
    }

    public final synchronized void j() {
        this.f37894a = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        synchronized (this.g) {
            try {
                jSONObject.put("lastDetectTime", this.f37894a);
                jSONObject.put(GoodsSpecificationPreviewActivity.z, jSONArray);
                Iterator<Map.Entry<String, e>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectF = it.next().getValue().b.f();
                    if (jSONObjectF != null) {
                        jSONArray.put(jSONObjectF);
                    }
                }
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        if (jSONObject.length() > 0) {
            if (r()) {
                com.igexin.push.core.e.f.a().b(jSONObject.toString(), true);
                return;
            }
            com.igexin.push.core.e.f.a().b(jSONObject.toString(), false);
        }
    }

    public final synchronized void l() {
        a aVar = this.d;
        a.EnumC0850a enumC0850a = aVar.e;
        com.igexin.c.a.c.a.a(a.f37881a + "|detect success, current type = " + aVar.e, new Object[0]);
        if (aVar.e == a.EnumC0850a.BACKUP) {
            aVar.a(a.EnumC0850a.TRY_NORMAL);
            com.igexin.push.core.d unused = com.igexin.push.core.d.a.f37984a;
            com.igexin.push.e.a.a(true);
        }
    }

    public final void m() {
        synchronized (h.class) {
            if (this.i == null) {
                HandlerThread handlerThread = new HandlerThread("NetDetect-T");
                handlerThread.start();
                this.i = new Handler(handlerThread.getLooper());
            }
        }
        this.i.removeCallbacksAndMessages("detToken");
        this.i.postAtTime(new Runnable() { // from class: com.igexin.push.c.h.2
            @Override // java.lang.Runnable
            public final void run() {
                String unused = h.e;
                try {
                    h.this.j();
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        }, "detToken", SystemClock.uptimeMillis() + 5000);
    }

    public final synchronized void n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loginFailedlCnt", this.d.g);
            jSONObject.put("lastChange2BackupTime", this.d.h);
            jSONObject.put("lastOfflineTime", this.d.i);
            jSONObject.put("domainType", this.d.e.d);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
        if (jSONObject.length() > 0) {
            if (r()) {
                com.igexin.push.core.e.f.a().a(jSONObject.toString(), true);
                return;
            }
            com.igexin.push.core.e.f.a().a(jSONObject.toString(), false);
        }
    }
}
