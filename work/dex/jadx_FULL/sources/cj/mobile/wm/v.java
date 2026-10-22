package cj.mobile.wm;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class v implements g0 {
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        m0 m0Var = zVar.dexb;
        Enum r2 = (Enum) obj;
        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.d.y) == 0) {
            m0Var.dexb(r2.ordinal());
            return;
        }
        String string = r2.toString();
        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.b.y) != 0) {
            m0Var.dexb(string);
        } else {
            m0Var.dexa(string, (char) 0, false);
        }
    }
}
