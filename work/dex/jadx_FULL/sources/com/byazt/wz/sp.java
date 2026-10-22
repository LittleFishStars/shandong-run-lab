package com.byazt.wz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.byazt.aas.nb;
import com.byazt.aas.zb;
import com.byazt.ete.ic;
import com.byazt.ete.nu;
import com.byazt.hv.TTDownloadField;
import com.byazt.nr.h;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.yih.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 65, 91})
public class sp extends uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ic f29171a;
    public volatile com.byazt.yzg.ve da;
    public String n;
    public volatile boolean sl;
    public String sp;
    public WeakReference<Context> uj;
    public int i = 0;
    public boolean t = false;
    public boolean u = false;
    public AtomicBoolean yp = new AtomicBoolean(false);
    public final com.byazt.wrq.tt c = new com.byazt.wrq.tt() { // from class: com.byazt.wz.sp.7
        @Override // com.byazt.wrq.tt
        public void onDownloadActive(long j, long j2, String str) {
            if (sp.this.yp.get()) {
                sp.this.yp.set(false);
                com.byazt.rgb.c.ve(sp.this.gu(), 2);
            }
        }

        @Override // com.byazt.wrq.tt
        public void onDownloadFailed(long j, long j2, String str) {
            com.byazt.rgb.c.uj(sp.this.gu(), 1);
        }

        @Override // com.byazt.wrq.tt
        public void onDownloadFinished(long j, long j2, String str) {
            com.byazt.rgb.c.n(sp.this.gu());
        }

        @Override // com.byazt.wrq.tt
        public void onDownloadPaused(long j, long j2, String str) {
            com.byazt.rgb.c.ve(sp.this.gu());
            sp.this.yp.set(true);
        }

        @Override // com.byazt.wrq.tt
        public void onDownloadStart() {
            com.byazt.rgb.c.ve(sp.this.gu(), 1);
        }

        @Override // com.byazt.su.DownloadStatusChangeListener
        public void onIdle() {
        }

        @Override // com.byazt.wrq.tt
        public void onInstalled(long j, long j2, String str) {
            com.byazt.rgb.c.n(sp.this.gu(), 1);
        }
    };
    public com.byazt.aas.c.tt tt = new com.byazt.aas.c.tt() { // from class: com.byazt.wz.sp.8
        @Override // com.byazt.aas.c.tt
        public void onAppBackground() {
        }

        @Override // com.byazt.aas.c.tt
        public void onAppExit() {
        }

        @Override // com.byazt.aas.c.tt
        public void onAppForeground() {
            if (com.byazt.omf.x.m().d()) {
                return;
            }
            com.byazt.rgb.c.tt(sp.this.gu());
            com.byazt.omf.x.m().ve().tt(sp.this.tt);
        }

        @Override // com.byazt.aas.c.tt
        public void onAppStart() {
        }
    };
    public final com.byazt.su.tt ve = new com.byazt.su.tt() { // from class: com.byazt.wz.sp.9
        @Override // com.byazt.su.tt
        public void c() {
            com.byazt.rgb.c.tt(sp.this.gu(), 1);
            com.byazt.omf.x.m().ve().c(sp.this.tt);
        }

        @Override // com.byazt.su.tt
        public void tt() {
            com.byazt.rgb.c.tt(sp.this.gu(), 2);
        }
    };
    public Function<SparseArray<Object>, Object> x = com.byazt.omf.x.m().nb();

    public sp(Context context, String str, ic icVar, String str2) {
        this.uj = new WeakReference<>(context);
        this.f29171a = icVar;
        this.sp = str2;
        this.n = str;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context;
        try {
            WeakReference<Context> weakReference = this.uj;
            return (weakReference == null || (context = weakReference.get()) == null) ? gt.getContext() : context;
        } catch (Throwable unused) {
            return gt.getContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gu() {
        ic icVar = this.f29171a;
        if (icVar == null) {
            return null;
        }
        return icVar.zm();
    }

    private boolean m() {
        ic icVar = this.f29171a;
        if (icVar == null || icVar.yp() == null) {
            return false;
        }
        String strTt = this.f29171a.yp().tt();
        if (TextUtils.isEmpty(strTt)) {
            return false;
        }
        nu.c((String) null);
        Uri uri = Uri.parse(strTt);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (!nb.c(intent)) {
            return false;
        }
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            getContext().startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        final Map<String, Object> mapRl = rl();
        if (!uj()) {
            c(16, mapRl);
        } else {
            com.byazt.qt.ve.c(mapRl, new com.byazt.wrq.c() { // from class: com.byazt.wz.sp.4
                @Override // com.byazt.ou.IDownloadButtonClickListener
                public void handleComplianceDialog(boolean z) {
                }

                @Override // com.byazt.ou.IDownloadButtonClickListener
                public void handleMarketFailedComplianceDialog() {
                    if (mapRl == null) {
                        return;
                    }
                    com.byazt.qt.ve.c(0, sp.this.gt());
                    sp.this.x().c(sp.this.i());
                    mapRl.remove("downloadButtonClickListener");
                    if (sp.this.u()) {
                        return;
                    }
                    sp.this.c((com.byazt.ete.uj) null);
                }
            });
            c(mapRl);
        }
    }

    private boolean nu() {
        if (this.x == null || com.byazt.ete.gt.m(this.f29171a) == 1) {
            return true;
        }
        if (gt.tt().jg()) {
            return c("正在下载，可在通知栏暂停或取消", true);
        }
        ic icVar = this.f29171a;
        if (com.byazt.ete.gt.da(icVar)) {
            return true;
        }
        x.tt(icVar, "dmb");
        return c("应用正在下载...", false);
    }

    private void qy() {
        if (uj() && !this.sl) {
            com.byazt.qt.ve.c(false, (com.byazt.wrq.ve) null, gt());
        }
    }

    private boolean rh() {
        if (this.x == null) {
            return false;
        }
        Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(6).c(Boolean.class).c(0, new zb().c("downloadUrl", this.n).c("hashCode", Integer.valueOf(gt()))).tt());
        return objApply != null && ((Boolean) objApply).booleanValue();
    }

    private Map<String, Object> rl() {
        long jLongValue = Double.valueOf(this.f29171a.uj()).longValue();
        return t() ? new zb().c(TRiverConstants.KEY_ENVIRONMENT_USERAGENT, null).c("isDisableDialog", Boolean.TRUE).c("downloadStatusChangeListener", null).c("action_type_button", 2).c("id", Long.valueOf(jLongValue)).c(TTDownloadField.TT_ACTIVITY, getContext()).c("open_market_in_app", Boolean.valueOf(com.byazt.ete.gt.my(this.f29171a))).c("hashCode", Integer.valueOf(gt())) : new zb().c("downloadUrl", this.n).c("hashCode", Integer.valueOf(gt())).c("id", Long.valueOf(jLongValue)).c(TTDownloadField.TT_ACTIVITY, getContext()).c("open_market_in_app", Boolean.valueOf(com.byazt.ete.gt.my(this.f29171a))).c("action_type_button", 2);
    }

    private synchronized void sl() {
        if (this.x == null) {
            return;
        }
        if (!t()) {
            this.x.apply(com.byazt.yxi.uj.c().c(5).c(Void.class).c(0, new zb().c("hashCode", Integer.valueOf(gt())).c("downloadStatusChangeListener", this.c).c("marketStatusChangeListener", this.ve)).tt());
            return;
        }
        zb zbVar = new zb();
        zbVar.c("hashCode", Integer.valueOf(gt()));
        Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(19).c(Boolean.class).c(0, zbVar).tt());
        if (objApply != null && ((Boolean) objApply).booleanValue()) {
            this.x.apply(com.byazt.yxi.uj.c().c(14).c(Boolean.class).c(0, new zb().c("hashCode", Integer.valueOf(gt()))).tt());
        }
    }

    private boolean t() {
        ic icVar = this.f29171a;
        if (icVar != null) {
            return com.byazt.ete.gt.c(icVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        int i = this.i;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("tt_download_check") { // from class: com.byazt.wz.sp.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.ete.uj ujVarC = gt.c().c(sp.this.f29171a, sp.this.n);
                    if (ujVarC == null || !ujVarC.sp()) {
                        x.c(gt.getContext(), sp.this.f29171a, "web_2");
                        return;
                    }
                    com.byazt.ete.a aVarC = x.c(ujVarC.x());
                    com.byazt.ete.a aVarRh = sp.this.f29171a.rh();
                    if (aVarRh == null) {
                        sp.this.f29171a.c(aVarC);
                    } else {
                        aVarRh.da(aVarC.yp());
                        aVarRh.tt(aVarC.n());
                        aVarRh.uj(aVarC.sp());
                        aVarRh.tt(aVarC.t());
                        aVarRh.n(aVarC.x());
                        aVarRh.i(aVarC.u());
                        aVarRh.ve(aVarC.a());
                        aVarRh.a(aVarC.i());
                        aVarRh.sp(aVarC.da());
                        aVarRh.x(aVarC.sl());
                        aVarC = aVarRh;
                    }
                    if (sp.this.yp()) {
                        return;
                    }
                    sp.this.c(aVarC.a(), aVarC.yp(), aVarC.u());
                    sp.this.c(ujVarC);
                }
            });
            return true;
        }
        if (yp()) {
            return true;
        }
        x.c(gt.getContext(), this.f29171a, "web_1");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yp() {
        return m() || z();
    }

    private boolean z() {
        ic icVar = this.f29171a;
        com.byazt.ete.a aVarRh = icVar != null ? icVar.rh() : null;
        String strU = aVarRh != null ? aVarRh.u() : "";
        Intent intentTt = TextUtils.isEmpty(strU) ? null : nb.tt(getContext(), strU);
        if (intentTt != null && nb.tt(strU)) {
            try {
                getContext().startActivity(intentTt);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.byazt.pop.ve
    public void c(int i, com.byazt.dk.ve.c cVar) {
    }

    @Override // com.byazt.pop.ve
    public void c(ic icVar, boolean z) {
    }

    @Override // com.byazt.pop.ve
    public void c(com.byazt.pop.c cVar) {
    }

    @Override // com.byazt.pop.ve
    public void c(com.byazt.pop.c cVar, boolean z) {
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.rgb.c.n(gu(), 2);
    }

    private synchronized void da() {
        if (this.x == null) {
            return;
        }
        if (p.uj >= 6400 && !p.x()) {
            com.byazt.qt.ve.c((com.byazt.wrq.ve) null, gt());
        }
        if (t()) {
            this.x.apply(com.byazt.yxi.uj.c().c(18).c(Boolean.class).c(0, new zb().c("hashCode", Integer.valueOf(gt()))).tt());
        } else {
            this.x.apply(com.byazt.yxi.uj.c().c(4).c(Void.class).c(0, new zb().c("hashCode", Integer.valueOf(gt()))).tt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.yzg.c i() {
        return uj() ? new com.byazt.yzg.n() : new com.byazt.yzg.uj();
    }

    @Override // com.byazt.pop.ve
    public Map<String, Object> a() {
        return new HashMap();
    }

    @Override // com.byazt.pop.ve
    public void n() {
        com.byazt.rgb.c.uj(gu());
        Function<SparseArray<Object>, Object> function = this.x;
        if (function != null) {
            function.apply(com.byazt.yxi.uj.c().c(8).c(Void.class).c(0, new zb().c("force", Boolean.TRUE).c("hashCode", Integer.valueOf(gt()))).tt());
        }
    }

    @Override // com.byazt.pop.ve
    public boolean sp() {
        return this.u;
    }

    @Override // com.byazt.pop.ve
    public void tt() {
        sl();
    }

    @Override // com.byazt.pop.ve
    public boolean uj() {
        Function<SparseArray<Object>, Object> function = this.x;
        return function != null && com.byazt.qt.ve.c(function, gt()) == 2;
    }

    @Override // com.byazt.pop.ve
    public void ve() {
        da();
        WeakReference<Context> weakReference = this.uj;
        if (weakReference != null) {
            weakReference.clear();
            this.uj = null;
        }
        this.da = null;
    }

    public com.byazt.yzg.ve x() {
        if (this.da == null) {
            synchronized (this) {
                if (this.da == null) {
                    this.da = new com.byazt.yzg.ve(getContext(), this.f29171a);
                }
            }
        }
        return this.da;
    }

    private boolean tt(com.byazt.ete.uj ujVar) {
        com.byazt.yzg.ve veVarX = x();
        if (!veVarX.uj(false) || sp() || rh()) {
            return false;
        }
        if (c(getContext(), this.f29171a, this.sp)) {
            return true;
        }
        veVarX.c(ujVar, this.sp, this.n, new com.byazt.av.tt() { // from class: com.byazt.wz.sp.2
            @Override // com.byazt.av.tt
            public void c() {
                sp.this.my();
                sp.this.tt(true);
            }
        });
        return true;
    }

    @Override // com.byazt.pop.ve
    public void uj(boolean z) {
        this.u = z;
    }

    @Override // com.byazt.pop.ve
    public void c() {
        com.byazt.qt.ve.c(this.n, this.sp, this.f29171a, (JSONObject) null, gt());
        com.byazt.qt.ve.c(this.f29171a, gt(), nb.yv(this.f29171a));
        com.byazt.qt.ve.c(this.sp, gt());
        sl();
    }

    @Override // com.byazt.pop.ve
    public void ve(boolean z) {
        this.t = z;
    }

    @Override // com.byazt.pop.ve
    public void tt(boolean z) {
        if (z) {
            this.sl = true;
            if (uj()) {
                com.byazt.qt.ve.c(true, com.byazt.qt.ve.c(this.f29171a, this.t), gt());
            }
        }
    }

    @Override // com.byazt.pop.ve
    public void c(JSONObject jSONObject, boolean z) {
        if (this.f29171a != null) {
            com.byazt.rgb.c.c(this.f29171a.zm(), uj() ? 1 : 2);
        }
        x().c(i());
        if (nu()) {
            if (uj() || !u()) {
                c((com.byazt.ete.uj) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, String str3) {
        if (this.x == null) {
            return;
        }
        this.x.apply(com.byazt.yxi.uj.c().c(24).c(Boolean.class).c(0, new zb().c("appIcon", str).c("appName", str2).c("hashCode", Integer.valueOf(gt())).c(ALPParamConstant.PACKAGENAME, str3)).tt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.ete.uj ujVar) {
        qy();
        if (tt(ujVar)) {
            return;
        }
        my();
    }

    private boolean c(final String str, final boolean z) {
        if (!rh()) {
            return true;
        }
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.wz.sp.3
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    h.tt(sp.this.getContext(), str, 0, 17, 0, 0);
                } else {
                    h.c(sp.this.getContext(), str, 0);
                }
            }
        });
        return false;
    }

    private void c(final Map<String, Object> map) {
        i.c(new Runnable() { // from class: com.byazt.wz.sp.5
            @Override // java.lang.Runnable
            public void run() {
                sp.this.c(17, (Map<String, Object>) map);
            }
        }, this.f29171a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i, final Map<String, Object> map) {
        try {
            if (this.x == null) {
                return;
            }
            if (t()) {
                this.x.apply(com.byazt.yxi.uj.c().c(13).c(Void.class).c(0, map).tt());
                this.sl = false;
            } else {
                map.put("itemClickListener", new com.byazt.wrq.uj() { // from class: com.byazt.wz.sp.6
                    @Override // com.byazt.wrq.uj
                    public void onItemClick() {
                        com.byazt.qt.ve.tt(1, sp.this.gt());
                        map.remove("itemClickListener");
                        sp.this.x.apply(com.byazt.yxi.uj.c().c(i).c(Void.class).c(0, map).tt());
                    }
                });
                this.x.apply(com.byazt.yxi.uj.c().c(i).c(Void.class).c(0, map).tt());
                this.sl = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.pop.ve
    public void c(int i) {
        this.i = i;
    }
}
