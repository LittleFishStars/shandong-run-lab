package cj.mobile.wm;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class b extends h {
    public final int dexe;
    public final List dexf;
    public final dex11 dexg;
    public final Object dexh;
    public final Map dexi;
    public final Collection dexj;

    public b(dex11 dex11Var, List list, int i) {
        super(null, null, 0);
        this.dexg = dex11Var;
        this.dexe = i;
        this.dexf = list;
        this.dexh = null;
        this.dexi = null;
        this.dexj = null;
    }

    public b(Collection collection) {
        super(null, null, 0);
        this.dexg = null;
        this.dexe = -1;
        this.dexf = null;
        this.dexh = null;
        this.dexi = null;
        this.dexj = collection;
    }

    public b(Map map, Object obj) {
        super(null, null, 0);
        this.dexg = null;
        this.dexe = -1;
        this.dexf = null;
        this.dexh = obj;
        this.dexi = map;
        this.dexj = null;
    }

    @Override // cj.mobile.wm.h
    public void dexa(dex11 dex11Var, Object obj, Type type, Map<String, Object> map) {
    }

    @Override // cj.mobile.wm.h
    public void dexa(Object obj, Object obj2) {
        com.wangmai.insightvision.openadsdk.d.b bVar;
        Object objG;
        Map map = this.dexi;
        if (map != null) {
            map.put(this.dexh, obj2);
            return;
        }
        Collection collection = this.dexj;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.dexf.set(this.dexe, obj2);
        com.wangmai.insightvision.openadsdk.d.b bVar2 = this.dexf;
        if (!(bVar2 instanceof com.wangmai.insightvision.openadsdk.d.b) || (objG = (bVar = bVar2).g()) == null || Array.getLength(objG) <= this.dexe) {
            return;
        }
        if (bVar.f() != null) {
            obj2 = q0.dexa(obj2, bVar.f(), this.dexg.dexb);
        }
        Array.set(objG, this.dexe, obj2);
    }
}
