package cj.mobile.wm;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex10 extends h {
    public j dexe;

    public dex10(a aVar, Class<?> cls, n0 n0Var) {
        super(cls, n0Var, 2);
    }

    public j dexa(a aVar) {
        if (this.dexe == null) {
            n0 n0Var = this.dexa;
            this.dexe = aVar.dexa(n0Var.dexg, n0Var.dexh);
        }
        return this.dexe;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:24:0x0077  */
    @Override // cj.mobile.wm.h
    public void dexa(dex11 dex11Var, Object obj, Type type, Map<String, Object> map) throws com.wangmai.insightvision.openadsdk.d.d {
        Object objDexa;
        Class<?> cls;
        if (this.dexe == null) {
            a aVar = dex11Var.dexb;
            n0 n0Var = this.dexa;
            this.dexe = aVar.dexa(n0Var.dexg, n0Var.dexh);
        }
        Type p0Var = this.dexa.dexh;
        boolean z = type instanceof ParameterizedType;
        if (z) {
            dex20 dex20Var = dex11Var.dexf;
            if (dex20Var != null) {
                dex20Var.dexd = type;
            }
            p0Var = n0.dexa(this.dexb, type, p0Var);
            this.dexe = dex11Var.dexb.dexa(p0Var);
        }
        if ((p0Var instanceof ParameterizedType) && z) {
            ParameterizedType parameterizedType = (ParameterizedType) p0Var;
            ParameterizedType parameterizedType2 = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType2.getRawType();
            if ((rawType instanceof Class) && q0.dexa(actualTypeArguments, ((Class) rawType).getTypeParameters(), parameterizedType2.getActualTypeArguments())) {
                p0Var = new p0(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
            }
        }
        n0 n0Var2 = this.dexa;
        String str = n0Var2.dexn;
        if (str != null) {
            j jVar = this.dexe;
            if (jVar instanceof u) {
                objDexa = ((u) jVar).dexa(dex11Var, p0Var, n0Var2.dexa, str);
            } else {
                objDexa = this.dexe.dexa(dex11Var, p0Var, n0Var2.dexa);
            }
        } else {
            objDexa = this.dexe.dexa(dex11Var, p0Var, n0Var2.dexa);
        }
        if (dex11Var.dexj == 1) {
            dex11.dexa dexaVarDexd = dex11Var.dexd();
            dexaVarDexd.dexc = this;
            dexaVarDexd.dexd = dex11Var.dexf;
            dex11Var.dexj = 0;
            return;
        }
        if (obj == null) {
            map.put(this.dexa.dexa, objDexa);
            return;
        }
        if (objDexa == null && ((cls = this.dexa.dexg) == Byte.TYPE || cls == Short.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
            return;
        }
        dexa(obj, objDexa);
    }
}
