package com.kwad.components.core.offline.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class a<T extends IOfflineCompo<?>> {
    private long Kk;
    private String abp = "";

    private void aB(final Context context) {
        if (com.kwad.components.core.a.OA.booleanValue()) {
            c.d(getTag(), "init start disableOffline");
            a(context, false, getClass().getClassLoader());
            return;
        }
        com.kwad.library.solder.lib.c.b bVarTv = tv();
        c.d(getTag(), "load component start pluginInfo: " + bVarTv);
        com.kwad.library.solder.a.a.a(context, bVarTv, new com.kwad.library.solder.lib.ext.b.a() { // from class: com.kwad.components.core.offline.b.a.1
            long abq;

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            public void b(com.kwad.library.solder.lib.b.a aVar) {
                super.b(aVar);
                c.d(a.this.getTag(), "install component resource start");
                com.kwad.components.core.offline.moitor.a.b(a.this.ty(), a.this.getDuration(), a.this.abp);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(com.kwad.library.solder.lib.b.a aVar) {
                super.a(aVar);
                c.d(a.this.getTag(), "install component resource success");
                com.kwad.components.core.offline.moitor.a.c(a.this.ty(), a.this.getDuration(), a.this.abp);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void e(com.kwad.library.solder.lib.b.a aVar) {
                super.e(aVar);
                this.abq = SystemClock.elapsedRealtime();
                a.this.abp = aVar.Eg() ? "ASSETS" : RVScheduleType.NETWORK;
                c.d(a.this.getTag(), "update component resource start");
                com.kwad.components.core.offline.moitor.c.d(a.this.ty(), a.this.getDuration(), a.this.abp);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(com.kwad.library.solder.lib.b.a aVar) {
                super.c(aVar);
                c.d(a.this.getTag(), "load component resource start");
                a.this.abp = "LOCAL";
                com.kwad.components.core.offline.moitor.a.b(a.this.ty(), a.this.getDuration(), aVar.DX().DK().El());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, com.kwad.library.b.a aVar2) {
                super.a(aVar, aVar2);
                c.d(a.this.getTag(), "load component resource success");
                com.kwad.components.core.offline.moitor.a.a(a.this.ty(), a.this.getDuration(), a.this.abp);
                a aVar3 = a.this;
                aVar3.a(context, !"LOCAL".equals(aVar3.abp), aVar2.DG());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(com.kwad.library.solder.lib.b.a aVar) {
                super.d(aVar);
                c.d(a.this.getTag(), "update component resource success");
                com.kwad.components.core.offline.moitor.c.a(a.this.ty(), a.this.getDuration(), SystemClock.elapsedRealtime() - this.abq, a.this.abp);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, PluginError pluginError) {
                super.a(aVar, pluginError);
                if (aVar.getState() == 1) {
                    com.kwad.components.core.offline.moitor.c.b(a.this.ty(), a.this.getDuration(), pluginError.getCode(), a.this.abp, pluginError.getMessage());
                }
                com.kwad.components.core.offline.moitor.a.a(a.this.ty(), a.this.getDuration(), pluginError.getCode(), "cmp_load_error " + pluginError.getMessage(), a.this.abp);
                c.d(a.this.getTag(), "load component resource failed error: " + pluginError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getDuration() {
        return SystemClock.elapsedRealtime() - this.Kk;
    }

    private com.kwad.library.solder.lib.c.b tv() {
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.aFr = tz();
        bVar.enable = true;
        bVar.aFv = false;
        bVar.aFs = com.kwad.sdk.core.network.idc.a.Mo().eQ(tB());
        bVar.version = tA();
        bVar.aFu = tC();
        if (com.kwad.components.core.a.OD.booleanValue()) {
            bVar.aEU = tD();
            bVar.aEV = true;
        }
        if (TextUtils.isEmpty(tC()) || TextUtils.isEmpty(tz()) || TextUtils.isEmpty(tA()) || TextUtils.isEmpty(tB())) {
            com.kwad.components.core.offline.moitor.a.a(ty(), getDuration(), 6001, "buildRemotePlugInfo error", this.abp);
        }
        return bVar;
    }

    private void tw() {
        c.d(getTag(), "init component start cost: " + getDuration());
        com.kwad.components.core.offline.moitor.a.d(ty(), getDuration());
    }

    public abstract void a(Context context, boolean z, T t);

    public final void bq(int i) {
        c.d(getTag(), "init component error time: " + getDuration());
        com.kwad.components.core.offline.moitor.a.a(ty(), getDuration(), 5001, "cmp_init_error, errorCode:" + i, this.abp);
    }

    public abstract String getTag();

    public final void init(Context context) {
        try {
            if (!isEnabled()) {
                try {
                    c.d(getTag(), "del start");
                    com.kwad.library.solder.a.a.o(context, tz());
                } catch (Throwable unused) {
                }
            } else {
                this.Kk = SystemClock.elapsedRealtime();
                com.kwad.components.core.offline.moitor.a.c(ty(), getDuration());
                c.d(getTag(), "init start");
                aB(context);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public abstract boolean isEnabled();

    public abstract String tA();

    public abstract String tB();

    public abstract String tC();

    public abstract String tD();

    public abstract String tE();

    public final void tx() {
        c.d(getTag(), "init component success cost: " + getDuration());
        com.kwad.components.core.offline.moitor.a.c(ty(), getDuration(), i.DQ().DK().El());
    }

    public abstract String ty();

    public abstract String tz();

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, boolean z, ClassLoader classLoader) {
        tw();
        String strTE = tE();
        try {
            IOfflineCompo iOfflineCompo = (IOfflineCompo) classLoader.loadClass(strTE).newInstance();
            c.d(getTag(), "load component instance success: " + iOfflineCompo.getClass().getName() + ", loadFromNet:" + z + ", classLoader:" + classLoader);
            a(context, z, iOfflineCompo);
        } catch (Throwable th) {
            com.kwad.components.core.offline.moitor.a.a(ty(), getDuration(), 4005, "loadClass error", this.abp);
            c.e(getTag(), "loadClass or instance failed: " + strTE, th);
        }
    }
}
