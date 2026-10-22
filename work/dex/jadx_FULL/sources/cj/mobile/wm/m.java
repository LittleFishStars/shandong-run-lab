package cj.mobile.wm;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m implements g0, j {
    public static m dexa = new m();

    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) {
        return (T) dex11Var.dexg();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        String str = (String) obj;
        m0 m0Var = zVar.dexb;
        if (str == null) {
            m0Var.dexa();
        } else {
            m0Var.dexa(str);
        }
    }
}
