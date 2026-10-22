package cj.mobile.wm;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class sa extends com.wangmai.insightvision.openadsdk.j.j.m<String> {
    public final Object dexs;
    public Map<String, String> dext;
    public fa.dexb<String> dexu;

    public sa(int i, String str, fa.dexb<String> dexbVar, fa.dexa dexaVar) {
        super(i, str, dexaVar);
        this.dexs = new Object();
        this.dext = new HashMap();
        this.dexu = dexbVar;
    }

    public fa<String> dexa(da daVar) {
        String str;
        try {
            str = new String(daVar.dexb, na.dexa(daVar.dexc));
        } catch (UnsupportedEncodingException unused) {
            str = new String(daVar.dexb);
        }
        return fa.dexa(str, na.dexa(daVar));
    }

    /* JADX INFO: renamed from: dexe, reason: merged with bridge method [inline-methods] */
    public void dexa(String str) {
        fa.dexb<String> dexbVar;
        synchronized (this.dexs) {
            dexbVar = this.dexu;
        }
        if (dexbVar != null) {
            dexbVar.a(str);
        }
    }

    public Map<String, String> dexf() {
        return this.dext;
    }
}
