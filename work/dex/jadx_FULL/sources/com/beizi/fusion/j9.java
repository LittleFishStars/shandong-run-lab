package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class j9 {
    public static qa a(ke keVar, sa saVar) {
        if (keVar == null) {
            return null;
        }
        cm cmVarB = keVar.b();
        if (cm.POST == cmVarB) {
            return new dl(keVar, saVar);
        }
        if (cm.GET == cmVarB) {
            return new n8(keVar, saVar);
        }
        if (cm.DOWNLOAD == cmVarB) {
            return new gh(keVar, saVar);
        }
        if (cm.CACHE_IMAGE == cmVarB) {
            return new lf(keVar, saVar);
        }
        if (cm.STREAM == cmVarB) {
            return new el(keVar, saVar);
        }
        return null;
    }
}
