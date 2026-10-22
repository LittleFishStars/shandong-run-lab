package com.byazt.tjo;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.byazt.aas.eo;
import com.byazt.omf.AdSdkInitializerHolder;
import com.byazt.omf.gt;
import com.byazt.omf.md;
import com.byazt.omf.p;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 516, 66})
public class t implements Function<SparseArray<Object>, Object> {
    public com.byazt.lkb.c c;
    public Bundle n;
    public com.byazt.fb.ve tt;
    public uj uj;
    public final com.byazt.omf.ve ve;

    public t(Bundle bundle, com.byazt.omf.ve veVar) {
        this.ve = veVar;
        this.n = bundle;
    }

    public boolean isInitSuccess() {
        com.byazt.lkb.c cVar = this.c;
        if (cVar != null && cVar.c()) {
            com.byazt.omf.ve veVar = this.ve;
            return veVar != null && this.uj != null && veVar.isInitSuccess() && this.uj.c();
        }
        com.byazt.omf.ve veVar2 = this.ve;
        if (veVar2 != null) {
            return veVar2.isInitSuccess();
        }
        return false;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        switch (pluginValueSetTt.intValue(-99999987)) {
            case -999002:
                return Boolean.valueOf(isInitSuccess());
            case -999001:
                try {
                    com.byazt.lkb.c cVarC = com.byazt.lkb.c.c(pluginValueSetTt);
                    this.c = cVarC;
                    if (cVarC.uj()) {
                        com.byazt.eu.tt.c();
                        com.byazt.hm.c.c();
                    }
                    if (this.c.t() && !AdSdkInitializerHolder.isSdkInitSuccess()) {
                        eo.c();
                    }
                    com.byazt.omf.x.m().ve(pluginValueSetTt.stringValue(261001));
                    c(pluginValueSetTt);
                    Context context = (Context) pluginValueSetTt.objectValue(-998000, Context.class);
                    gt.c(context);
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long jLongValue = pluginValueSetTt.longValue(25, 0L);
                    a.n = jLongValue;
                    if (jLongValue == 0) {
                        a.n = jElapsedRealtime;
                    }
                    long jLongValue2 = pluginValueSetTt.longValue(24, 0L);
                    a.f29059a = jLongValue2;
                    if (jLongValue2 == 0) {
                        a.f29059a = jElapsedRealtime;
                    }
                    long jLongValue3 = pluginValueSetTt.longValue(1, 0L);
                    a.sp = jLongValue3;
                    if (jLongValue3 == 0) {
                        a.sp = jElapsedRealtime;
                    }
                    long jLongValue4 = pluginValueSetTt.longValue(27, 0L);
                    a.x = jLongValue4;
                    if (jLongValue4 <= 0) {
                        a.x = a.sp;
                    }
                    boolean zCx = gt.tt().cx();
                    if (this.c.c() || zCx) {
                        com.byazt.vq.c.c().tt();
                        com.byazt.omf.x.m().a(zCx);
                        com.byazt.omf.x.m().sp(true);
                        c(context, pluginValueSetTt);
                    } else {
                        this.ve.apply(sparseArray);
                    }
                } catch (Throwable th) {
                    com.byazt.lkb.c cVar = this.c;
                    if (cVar != null) {
                        new com.byazt.fb.ve(cVar.ve()).c(0, com.byazt.yxi.n.c().c(false).c(4000).c(th.getMessage() != null ? th.getMessage() : "init error").tt());
                    }
                }
                break;
            case -999000:
                if (this.ve != null) {
                    com.byazt.eu.tt.tt("TMe", "getManager mediation");
                    md manager = this.ve.getManager();
                    if (manager != null) {
                        return new sl(manager);
                    }
                }
                break;
        }
        return com.byazt.rl.c.tt.apply(sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, com.byazt.lkb.c cVar, com.byazt.fb.ve veVar, long j, long j2, JSONObject jSONObject) {
        a.c(jSONObject, "s-init_gm");
        uj ujVar = new uj();
        this.uj = ujVar;
        ujVar.c(context, cVar, veVar, j, this.ve, j2, jSONObject);
    }

    private void c(final Context context, final PluginValueSet pluginValueSet) {
        final JSONObject jSONObject = new JSONObject();
        com.byazt.fb.ve veVar = new com.byazt.fb.ve(this.c.ve());
        this.tt = veVar;
        veVar.c(new com.byazt.fb.tt() { // from class: com.byazt.tjo.t.1
            @Override // com.byazt.fb.tt
            public void c(boolean z) {
                final long jLongValue;
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = 0;
                try {
                    jLongValue = pluginValueSet.longValue(1, SystemClock.elapsedRealtime());
                    if (jLongValue != 0) {
                        try {
                            a.c = jElapsedRealtime - jLongValue;
                            a.ve = jElapsedRealtime - a.x;
                        } catch (Exception unused) {
                            j = jLongValue;
                            jLongValue = j;
                        }
                    }
                } catch (Exception unused2) {
                }
                if (z) {
                    com.byazt.dc.n.c(new Runnable() { // from class: com.byazt.tjo.t.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            t tVar = t.this;
                            tVar.c(context, tVar.c, t.this.tt, jLongValue, jElapsedRealtime, jSONObject);
                        }
                    });
                }
            }
        });
        if (this.ve != null) {
            com.byazt.qe.tt.c(com.byazt.bp.tt.tt()).c(pluginValueSet, jSONObject);
            this.ve.init(context, pluginValueSet, this.tt);
        } else {
            this.tt.c(0, com.byazt.yxi.n.c().c(false).c(80000).c("init error Initializer is null").tt());
        }
    }

    private void c(@ForbidWrapParam PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                p.ve = bool.booleanValue();
            }
        } catch (Exception unused) {
        }
    }
}
