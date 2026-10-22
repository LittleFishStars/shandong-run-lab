package com.byazt.lk;

import android.util.Pair;
import com.byazt.ut.i;
import com.byazt.ut.sl;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 715, 54})
public class ve {
    public i c;
    public final com.byazt.ut.c tt;

    public ve(com.byazt.ut.c cVar) {
        this.tt = cVar;
    }

    public void c(i iVar) {
        this.c = iVar;
    }

    public Object tt(sl slVar, com.byazt.dna.c cVar, Object obj, Function function, boolean z) {
        return c(slVar, cVar, obj, function, z, true);
    }

    public Object c(sl slVar, com.byazt.dna.c cVar, Object obj, Function function, boolean z) {
        return c(slVar, cVar, obj, function, z, false);
    }

    private Object c(sl slVar, com.byazt.dna.c cVar, Object obj, Function function, boolean z, boolean z2) {
        if (obj.getClass().getClassLoader() == com.byazt.ut.c.class.getClassLoader() && !slVar.c.isAssignableFrom(obj.getClass())) {
            Object objC = slVar.c(cVar);
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(CachedContentIndex.a.e, slVar.f29108a);
                    jSONObject.putOpt("origin", obj.getClass().getName());
                    jSONObject.putOpt("memoryProxyService", objC);
                    jSONObject.putOpt("apiClazz", slVar.c.getName());
                    Map<String, Object> mapC = this.tt.n().c();
                    if (mapC != null) {
                        for (String str : mapC.keySet()) {
                            Object obj2 = mapC.get(str);
                            if (obj2 instanceof Pair) {
                                Pair pair = (Pair) obj2;
                                jSONObject.putOpt(str + "_create", pair.first);
                                jSONObject.putOpt(str, pair.second);
                            } else {
                                jSONObject.putOpt(str, obj2);
                            }
                        }
                    }
                    jSONObject.putOpt("allServices", mapC);
                } catch (JSONException unused) {
                }
                this.c.c(5, jSONObject.toString(), new RuntimeException("service not match"));
            }
            if (objC != null) {
                return objC;
            }
            return null;
        }
        Object objC2 = c(slVar, cVar, obj, z2);
        if (z) {
            slVar.c(objC2, cVar);
            if (function != null) {
                slVar.c(function);
                slVar.c(com.byazt.rj.c.c(function, slVar.f29108a));
            } else {
                slVar.c(slVar.ve);
            }
        }
        return objC2;
    }

    private Object c(sl slVar, com.byazt.dna.c cVar, Object obj, boolean z) {
        try {
            if (slVar.tt.isInstance(obj)) {
                return obj;
            }
            if (slVar.c.isInstance(obj)) {
                return slVar.tt.getDeclaredConstructor(slVar.c).newInstance(obj);
            }
            if (obj instanceof Function) {
                if (slVar.i && z) {
                    obj = slVar.tt.getDeclaredConstructor(Function.class, slVar.c).newInstance(obj, this.tt.ve().c(slVar, cVar, false).second);
                } else {
                    obj = slVar.tt.getDeclaredConstructor(Function.class).newInstance(obj);
                }
                i iVar = this.c;
            } else {
                i iVar2 = this.c;
                if (iVar2 != null) {
                    iVar2.c(slVar, 0, "service not instanceof Function:".concat(String.valueOf(obj)), (Throwable) null);
                }
            }
            return obj;
        } catch (Throwable th) {
            i iVar3 = this.c;
            if (iVar3 != null) {
                iVar3.c(slVar, 0, "reuse failed", th);
            }
        }
    }
}
