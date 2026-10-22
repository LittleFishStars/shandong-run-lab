package com.byazt.ut;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.byazt.dna.gu;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 834, 20})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.lk.uj f29107a;
    public i c;
    public final com.byazt.lk.ve n;
    public final com.byazt.gh.c sp;
    public final com.byazt.lk.c uj;
    public final com.byazt.lk.tt ve;
    public final com.byazt.rj.c x;
    public String tt = "";
    public final Map<String, Object> i = new HashMap();
    public final Set<Function> da = new HashSet();
    public boolean sl = false;
    public Map<String, com.byazt.dna.c> t = new HashMap();

    public c() {
        com.byazt.lk.tt ttVar = new com.byazt.lk.tt();
        this.ve = ttVar;
        this.n = new com.byazt.lk.ve(this);
        this.uj = new com.byazt.lk.c();
        this.sp = new com.byazt.gh.c(this);
        this.f29107a = new com.byazt.lk.uj();
        this.x = new com.byazt.rj.c(ttVar, this);
    }

    public i a() {
        return this.c;
    }

    public void c(i iVar) {
        this.c = iVar;
        this.uj.c(iVar);
        this.n.c(iVar);
        this.sp.c(iVar);
        this.f29107a.c(iVar);
    }

    public com.byazt.lk.uj n() {
        return this.f29107a;
    }

    public com.byazt.lk.tt sp() {
        return this.ve;
    }

    public boolean tt() {
        return this.sl;
    }

    public com.byazt.lk.ve uj() {
        return this.n;
    }

    public com.byazt.lk.c ve() {
        return this.uj;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T> T c(String str, com.byazt.dna.c cVar, boolean z) {
        Pair<Function, Object> pairC;
        Object obj;
        Object obj2;
        if (TextUtils.isEmpty(str)) {
            i iVar = this.c;
            if (iVar != null) {
                iVar.c(str, new RuntimeException("null key"));
            }
            return null;
        }
        sl slVarC = this.ve.c(str);
        if (slVarC == null) {
            return null;
        }
        T t = (T) slVarC.c(cVar);
        if (t != null) {
            return t;
        }
        if (slVarC.ve < 0) {
            return null;
        }
        boolean z2 = "m_d_s".equals(str) || "m_s".equals(str);
        if (z2 && (t = (T) this.i.get(str)) != null) {
            return t;
        }
        synchronized (slVarC) {
            if (!z2) {
                if (slVarC.n && (pairC = this.f29107a.c(slVarC, cVar)) != null && (obj = pairC.second) != null && (t = (T) this.n.c(slVarC, cVar, obj, (Function) pairC.first, true)) != null) {
                    return t;
                }
            }
            Pair<Function, Object> pairC2 = this.uj.c(slVarC, cVar, z);
            T t2 = (pairC2 == null || (obj2 = pairC2.second) == null) ? t : (T) obj2;
            if (t2 != null) {
                if (z2) {
                    this.i.put(str, t2);
                } else if (slVarC.n) {
                    this.f29107a.c(slVarC, cVar, t2, (Function) pairC2.first);
                }
                Object objC = this.n.c(slVarC, cVar, t2, null, true);
                if (z && objC != null) {
                    t2 = (T) objC;
                }
            }
            return t2;
        }
    }

    public Object c(String str, com.byazt.dna.c cVar, Object obj, Function function) {
        return this.n.c(this.ve.c(str), cVar, obj, function, true);
    }

    @Deprecated
    public void c(List<String> list) {
        this.sp.c(list);
    }

    public void c(uj ujVar, Function function) {
        if (function == ujVar) {
            i iVar = this.c;
            if (iVar != null) {
                iVar.c(4, "regSelf", new RuntimeException());
                return;
            }
            return;
        }
        if (ujVar.getClass().getClassLoader() == function.getClass().getClassLoader()) {
            i iVar2 = this.c;
            if (iVar2 != null) {
                iVar2.c(3, "two main service bridge registered", new RuntimeException());
                return;
            }
            return;
        }
        if (this.da.contains(function)) {
            return;
        }
        boolean zBooleanValue = com.byazt.rj.c.c(function).booleanValue();
        if (zBooleanValue && this.sl) {
            i iVar3 = this.c;
            if (iVar3 != null) {
                iVar3.c(1, "two main service bridge registered", (Throwable) null);
                return;
            }
            return;
        }
        this.sp.c(function, zBooleanValue);
        sl[] slVarArrC = this.ve.c();
        if (slVarArrC == null || slVarArrC.length == 0) {
            return;
        }
        com.byazt.hsa.c cVar = new com.byazt.hsa.c(this.c);
        for (sl slVar : slVarArrC) {
            if (slVar.n) {
                if (cVar.c(slVar, function) && !zBooleanValue) {
                    cVar.c(slVar, this, function);
                }
                if (zBooleanValue) {
                    synchronized (slVar) {
                        this.f29107a.c(slVar, this);
                    }
                } else {
                    continue;
                }
            }
        }
        if (this.sl) {
            for (Function function2 : this.da) {
                function2.apply(function);
                function.apply(function2);
            }
            this.da.size();
        } else if (zBooleanValue) {
            function.apply(ujVar);
        }
        synchronized (this.da) {
            this.da.add(function);
        }
    }

    public Map<String, Object> c() {
        if (this.sl) {
            return this.i;
        }
        return Collections.emptyMap();
    }

    public Object c(Object obj) {
        if (obj instanceof SparseArray) {
            return this.x.c((SparseArray) obj);
        }
        return null;
    }

    public Object c(String str, com.byazt.dna.c cVar) {
        Function functionTt;
        synchronized (this.da) {
            Object obj = null;
            for (Function function : this.da) {
                Object objC = com.byazt.rj.c.c(function, str, cVar);
                if (objC != null) {
                    if ((objC instanceof Function) && (functionTt = com.byazt.rj.c.tt((Function) objC)) != null) {
                        objC = functionTt;
                    }
                    return c(str, cVar, objC, function);
                }
                obj = objC;
            }
            return obj;
        }
    }

    public static int c(Function function) {
        Object objApply = function.apply(0);
        if (objApply instanceof Integer) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public void c(boolean z) {
        this.sl = z;
        if (z) {
            uj.getService("m_d_s");
            uj.getService("m_s");
        }
    }

    public com.byazt.dna.c c(String str) {
        SparseArray sparseArray;
        com.byazt.dna.c cVarC;
        if (TextUtils.isEmpty(str)) {
            str = this.tt;
        } else if (TextUtils.isEmpty(this.tt)) {
            this.tt = str;
        }
        com.byazt.dna.c cVar = this.t.get(str);
        if (cVar != null) {
            return cVar;
        }
        this.ve.c("context");
        gu guVar = (gu) uj.getService("m_d_s");
        Object data = guVar.getData(-2);
        if (data instanceof SparseArray) {
            sparseArray = (SparseArray) data;
        } else {
            sparseArray = new SparseArray();
            guVar.setData(-2, sparseArray);
        }
        Object obj = sparseArray.get(str.hashCode());
        if (obj instanceof com.byazt.dna.c) {
            cVarC = (com.byazt.dna.c) obj;
        } else {
            cVarC = this.uj.c(str);
        }
        this.t.put(str, cVarC);
        return cVarC;
    }
}
