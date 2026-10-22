package com.getui.gtc.dyc;

import android.text.TextUtils;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.dyc.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f30343a;
    private final g c;
    private final List<com.getui.gtc.dyc.b.c> d;
    private final Map<String, Object> e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f30345a = new f();
    }

    private f() {
        this.f30343a = e.a();
        this.c = g.a();
        this.d = new ArrayList();
        this.e = new ConcurrentHashMap();
    }

    public static f a() {
        return a.f30345a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, h hVar) {
        return (System.currentTimeMillis() - hVar.c() <= bVar.h() && bVar.g().equals(hVar.a()) && bVar.c().equals(hVar.e())) ? false : true;
    }

    public Map<String, String> a(final b bVar) {
        try {
            final h hVarA = this.f30343a.a(bVar.b());
            if (hVarA == null || a(bVar, hVarA)) {
                ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.dyc.f.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (f.this.e) {
                            if (f.this.e.get(bVar.b()) == null) {
                                f.this.e.put(bVar.b(), new Object());
                            }
                        }
                        synchronized (f.this.e.get(bVar.b())) {
                            boolean z = bVar.h() <= 0;
                            h hVarA2 = f.this.f30343a.a(bVar.b());
                            if (!z && hVarA2 != null && ((hVarA == null || (hVarA2.f() != null && !hVarA2.f().equals(hVarA.f()))) && bVar.i() != null)) {
                                com.getui.gtc.dyc.b.c cVarI = bVar.i();
                                h hVar = hVarA;
                                cVarI.a(hVar == null ? null : hVar.f(), hVarA2.f());
                            }
                            if (hVarA2 == null || f.this.a(bVar, hVarA2)) {
                                if (!z && hVarA2 != null) {
                                    bVar.f(hVarA2.d());
                                }
                                try {
                                    h hVarA3 = f.this.c.a(bVar);
                                    if (hVarA3 != null) {
                                        if (!TextUtils.isEmpty(hVarA3.d())) {
                                            Map<String, String> mapF = hVarA3.f();
                                            if (mapF != null) {
                                                Map<String, String> map = new HashMap<>(mapF);
                                                for (String str : mapF.keySet()) {
                                                    if (str != null && str.endsWith(".gtc_skip")) {
                                                        map.remove(str);
                                                    }
                                                }
                                                hVarA3.a(map);
                                                f.this.f30343a.a(bVar.b(), hVarA3);
                                                hVarA3.a(mapF);
                                                if (bVar.i() != null) {
                                                    bVar.i().a(hVarA2 == null ? null : hVarA2.f(), mapF);
                                                }
                                                Iterator it = new ArrayList(f.this.d).iterator();
                                                while (it.hasNext()) {
                                                    ((com.getui.gtc.dyc.b.c) it.next()).a(hVarA2 == null ? null : hVarA2.f(), mapF);
                                                }
                                            }
                                        } else if (hVarA2 != null) {
                                            hVarA2.a(hVarA3.c());
                                            f.this.f30343a.a(bVar.b(), hVarA2);
                                        }
                                    }
                                } catch (Throwable th) {
                                    com.getui.gtc.dyc.a.a.a.a(th);
                                    String message = th.getMessage();
                                    if (bVar.i() != null) {
                                        bVar.i().b(message);
                                        if (bVar.i() instanceof com.getui.gtc.dyc.b.d) {
                                            ((com.getui.gtc.dyc.b.d) bVar.i()).a(new Exception(th));
                                        }
                                    }
                                    for (com.getui.gtc.dyc.b.c cVar : new ArrayList(f.this.d)) {
                                        cVar.b(message);
                                        if (cVar instanceof com.getui.gtc.dyc.b.d) {
                                            ((com.getui.gtc.dyc.b.d) cVar).a(new Exception(th));
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }
            if (hVarA == null) {
                return null;
            }
            return hVarA.f();
        } catch (Throwable th) {
            com.getui.gtc.dyc.a.a.a.a(th);
            return null;
        }
    }

    public Map<String, String> a(String str) {
        h hVarA = this.f30343a.a(str);
        if (hVarA == null) {
            return null;
        }
        return hVarA.f();
    }

    public void a(com.getui.gtc.dyc.b.c cVar) {
        synchronized (this.d) {
            if (!this.d.contains(cVar)) {
                this.d.add(cVar);
            }
        }
    }

    public void a(String str, Map<String, String> map) {
        h hVarA = this.f30343a.a(str);
        Map<String, String> mapF = hVarA.f();
        mapF.clear();
        mapF.putAll(map);
        this.f30343a.a(str, hVarA);
    }

    public Map<String, Map<String, String>> c() {
        HashMap<String, h> mapC = this.f30343a.c();
        if (mapC == null || mapC.size() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (Map.Entry<String, h> entry : mapC.entrySet()) {
            h value = entry.getValue();
            if (value.f() != null) {
                map.put(entry.getKey(), value.f());
            }
        }
        return map;
    }

    public void c(com.getui.gtc.dyc.b.c cVar) {
        synchronized (this.d) {
            this.d.remove(cVar);
        }
    }
}
