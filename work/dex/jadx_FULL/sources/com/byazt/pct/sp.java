package com.byazt.pct;

import android.text.TextUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 124, 91})
public class sp implements qy.c {
    public final x c;
    public final com.byazt.pct.c da;
    public final boolean i;
    public final u sp;
    public final gt tt;
    public final boolean x;
    public final Map<String, tt> ve = new HashMap();
    public final Map<String, uj.tt> uj = new HashMap();
    public final List<m> n = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<uj> f28940a = new HashSet();

    @com.byazt.zqa.c(c = {0, 1, 124, 180})
    public static final class c {
        public boolean c;
        public String tt;

        private c(boolean z, String str) {
            this.c = z;
            this.tt = str;
        }
    }

    public sp(da daVar, com.byazt.pct.c cVar, rl rlVar) {
        this.da = cVar;
        this.c = daVar.uj;
        gt gtVar = new gt(rlVar, daVar.t, daVar.u);
        this.tt = gtVar;
        gtVar.c(this);
        gtVar.c(daVar.m);
        this.sp = daVar.i;
        this.x = daVar.x;
        this.i = daVar.z;
    }

    private gu tt(String str, tt ttVar) {
        return this.i ? gu.PRIVATE : this.tt.c(this.x, str, ttVar);
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public c c(m mVar, a aVar) throws Exception {
        tt ttVar = this.ve.get(mVar.uj);
        if (ttVar != null) {
            try {
                gu guVarTt = tt(aVar.tt, ttVar);
                aVar.uj = guVarTt;
                if (guVarTt == null) {
                    i.c("Permission denied, call: ".concat(String.valueOf(mVar)));
                    throw new rh(-1);
                }
                if (ttVar instanceof n) {
                    return c(mVar, (n) ttVar, aVar);
                }
                if (ttVar instanceof ve) {
                    return c(mVar, (ve) ttVar, guVarTt);
                }
            } catch (rl.c e) {
                i.c("No remote permission config fetched, call pending: ".concat(String.valueOf(mVar)), e);
                this.n.add(mVar);
                return new c(false, gr.c());
            }
        }
        uj.tt ttVar2 = this.uj.get(mVar.uj);
        if (ttVar2 == null) {
            i.tt("Received call: " + mVar + ", but not registered.");
            return null;
        }
        uj ujVarC = ttVar2.c();
        ujVarC.c(mVar.uj);
        gu guVarTt2 = tt(aVar.tt, ujVarC);
        aVar.uj = guVarTt2;
        if (guVarTt2 != null) {
            return c(mVar, ujVarC, aVar);
        }
        i.c("Permission denied, call: ".concat(String.valueOf(mVar)));
        ujVarC.n();
        throw new rh(-1);
    }

    public void c(String str, n<?, ?> nVar) {
        nVar.c(str);
        this.ve.put(str, nVar);
    }

    public void c(String str, uj.tt ttVar) {
        this.uj.put(str, ttVar);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.ve.containsKey(str)) {
            return true;
        }
        return this.uj.containsKey(str);
    }

    public void c() {
        Iterator<uj> it = this.f28940a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f28940a.clear();
        this.ve.clear();
        this.uj.clear();
        this.tt.tt(this);
    }

    private c c(m mVar, n nVar, a aVar) throws Exception {
        return new c(true, gr.c(this.c.c(nVar.c(c(mVar.n, (tt) nVar), aVar))));
    }

    private c c(final m mVar, final uj ujVar, a aVar) throws Exception {
        this.f28940a.add(ujVar);
        ujVar.c(c(mVar.n, ujVar), aVar, new uj.c() { // from class: com.byazt.pct.sp.1
            @Override // com.byazt.pct.uj.c
            public void c(Object obj) {
                if (sp.this.da == null) {
                    return;
                }
                sp.this.da.tt(gr.c(sp.this.c.c(obj)), mVar);
                sp.this.f28940a.remove(ujVar);
            }

            @Override // com.byazt.pct.uj.c
            public void c(Throwable th) {
                if (sp.this.da == null) {
                    return;
                }
                sp.this.da.tt(gr.c(th), mVar);
                sp.this.f28940a.remove(ujVar);
            }
        });
        return new c(false, gr.c());
    }

    private c c(final m mVar, ve veVar, gu guVar) throws Exception {
        new my(mVar.uj, guVar, new my.c() { // from class: com.byazt.pct.sp.2
        });
        return new c(false, gr.c());
    }

    private Object c(String str, tt ttVar) throws JSONException {
        return this.c.c(str, c(ttVar)[0]);
    }

    private static Type[] c(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        }
        throw new IllegalStateException("Method is not parameterized?!");
    }
}
