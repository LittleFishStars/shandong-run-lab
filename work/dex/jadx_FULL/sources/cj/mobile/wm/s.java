package cj.mobile.wm;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class s implements g0, j {
    public static final s dexa = new s();

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        if (r3 == 1) goto L5;
     */
    @Override // cj.mobile.wm.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        dex13 dex13Var = dex11Var.dexe;
        int iDexu = dex13Var.dexu();
        if (iDexu != 6) {
            if (iDexu == 7) {
                dex13Var.dexb(16);
            } else {
                if (iDexu != 2) {
                    Object objDexe = dex11Var.dexe();
                    if (objDexe == null) {
                        return null;
                    }
                    return (T) q0.dexc(objDexe);
                }
                int iDexe = dex13Var.dexe();
                dex13Var.dexb(16);
            }
            return (T) Boolean.FALSE;
        }
        dex13Var.dexb(16);
        return (T) Boolean.TRUE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        m0 m0Var = zVar.dexb;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.i.y) != 0) {
                m0Var.write(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                return;
            } else {
                m0Var.dexa();
                return;
            }
        }
        if (bool.booleanValue()) {
            m0Var.write("true");
        } else {
            m0Var.write(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
    }
}
