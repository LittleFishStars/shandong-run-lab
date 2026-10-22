package com.byazt.hz;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.vx.nu;
import com.byazt.vx.yp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 66})
public class t extends da implements com.byazt.zq.uj {
    public com.byazt.uhf.tt c;
    public final com.byazt.zq.ve gt;
    public com.byazt.nf.c m;
    public boolean my;
    public final com.byazt.zq.tt rl;
    public com.byazt.uhf.c tt;

    @com.byazt.zqa.c(c = {0, 1, 701, 125})
    public class c implements com.byazt.zq.tt {
        public volatile boolean tt;
        public final Handler uj;
        public volatile boolean ve;

        private c() {
            this.tt = false;
            this.ve = false;
            this.uj = new Handler(Looper.getMainLooper());
        }

        private void x() {
            this.uj.postDelayed(new Runnable() { // from class: com.byazt.hz.t.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ve || c.this.tt) {
                        c.this.sp();
                        return;
                    }
                    t.this.c(new com.byazt.bo.c() { // from class: com.byazt.hz.t.c.2.1
                        @Override // com.byazt.bo.c
                        public boolean c() {
                            return true;
                        }

                        @Override // com.byazt.bo.c
                        public float tt() {
                            com.byazt.ll.tt ttVar = t.this.f28639a;
                            if (ttVar != null) {
                                return ttVar.p();
                            }
                            return 0.0f;
                        }

                        @Override // com.byazt.bo.c
                        @Nullable
                        public Map<String, Object> uj() {
                            return new HashMap();
                        }

                        @Override // com.byazt.bo.c
                        @Nullable
                        public String ve() {
                            com.byazt.ll.tt ttVar = t.this.f28639a;
                            return ttVar != null ? ttVar.yv() : "";
                        }
                    });
                    c.this.sp();
                }
            }, com.byazt.ck.tt.c().a());
        }

        @Override // com.byazt.ln.c
        public void a() {
            sp();
            this.tt = true;
            if (!yp.c()) {
                t.this.yv();
                if (t.this.m.c()) {
                    t.this.m.tt();
                }
                if (t.this.tt != null) {
                    t.this.tt.a();
                    return;
                }
                return;
            }
            com.byazt.yl.ve veVar = t.this.uj;
            if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                if (!yp.ve()) {
                    String strC = nu.c();
                    t tVar = t.this;
                    com.byazt.ng.a.c(tVar.uj, tVar.f28639a, 3, 1, 0, strC);
                    return;
                }
                t tVar2 = t.this;
                com.byazt.ng.a.c(tVar2.uj, tVar2.f28639a, 3, 0, 0, (String) null);
            }
            if (t.this.zm()) {
                return;
            }
            t.this.yv();
            if (t.this.m.c()) {
                t.this.m.tt();
            }
            if (t.this.tt != null) {
                t.this.tt.a();
            }
        }

        @Override // com.byazt.ln.c
        public void c(@NonNull com.byazt.bo.c cVar) {
        }

        /* JADX WARN: Code duplicated, block: B:15:0x003b  */
        @Override // com.byazt.ln.c
        public void g_() {
            String str;
            String str2;
            long jCurrentTimeMillis;
            String strC;
            if (yp.c()) {
                com.byazt.yl.ve veVar = t.this.uj;
                if (veVar == null || !MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                    strC = null;
                } else if (!yp.ve()) {
                    String strC2 = nu.c();
                    t tVar = t.this;
                    com.byazt.ng.a.c(tVar.uj, tVar.f28639a, 5, 1, 0, strC2);
                    return;
                } else if (yp.x()) {
                    strC = nu.c();
                } else {
                    strC = null;
                }
                if (!t.this.zm() && t.this.tt != null) {
                    t.this.tt.i_();
                }
                str = strC;
            } else {
                if (t.this.tt != null) {
                    t.this.tt.i_();
                }
                str = null;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (nu.c(t.this.uj)) {
                String strTt = nu.tt();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                str2 = strTt;
            } else {
                str2 = null;
                jCurrentTimeMillis = -1;
            }
            com.byazt.bg.c.n(t.this.n);
            t tVar2 = t.this;
            com.byazt.yl.ve veVar2 = tVar2.uj;
            com.byazt.ng.a.c(veVar2, tVar2.f28639a, 0, str2, jCurrentTimeMillis, str, veVar2.isClickListenRepeatOnce());
        }

        @Override // com.byazt.ln.c
        public void h_() {
            sp();
            this.ve = true;
            if (!yp.c()) {
                t.this.yv();
                if (t.this.tt != null) {
                    t.this.tt.j_();
                    return;
                }
                return;
            }
            com.byazt.yl.ve veVar = t.this.uj;
            if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                if (!yp.ve()) {
                    String strC = nu.c();
                    t tVar = t.this;
                    com.byazt.ng.a.c(tVar.uj, tVar.f28639a, 2, 1, 0, strC);
                    return;
                }
                t tVar2 = t.this;
                com.byazt.ng.a.c(tVar2.uj, tVar2.f28639a, 2, 0, 0, (String) null);
            }
            if (t.this.zm()) {
                return;
            }
            t.this.yv();
            if (t.this.tt != null) {
                t.this.tt.j_();
            }
        }

        @Override // com.byazt.ln.c
        public void n() {
            t.this.n();
        }

        public void sp() {
            this.uj.removeCallbacksAndMessages(null);
        }

        @Override // com.byazt.ln.c
        public void uj() {
            if (!yp.c()) {
                t.this.yv();
                if (t.this.m.c()) {
                    t.this.m.n();
                }
                if (t.this.tt != null) {
                    t.this.tt.uj();
                    return;
                }
                return;
            }
            com.byazt.yl.ve veVar = t.this.uj;
            if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                if (!yp.ve()) {
                    String strC = nu.c();
                    t tVar = t.this;
                    com.byazt.ng.a.c(tVar.uj, tVar.f28639a, 1, 1, 0, strC);
                    return;
                }
                t tVar2 = t.this;
                com.byazt.ng.a.c(tVar2.uj, tVar2.f28639a, 1, 0, 0, (String) null);
            }
            if (t.this.zm()) {
                return;
            }
            t.this.yv();
            if (t.this.m.c()) {
                t.this.m.n();
            }
            if (t.this.tt != null) {
                t.this.tt.uj();
            }
        }

        /* JADX WARN: Code duplicated, block: B:15:0x005e  */
        @Override // com.byazt.ln.c
        public void c() {
            String strC;
            String str;
            long jCurrentTimeMillis;
            com.byazt.yl.ve veVar;
            t.this.my = true;
            x();
            if (!yp.c() || (veVar = t.this.uj) == null || !MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                strC = null;
            } else {
                if (!yp.ve()) {
                    t.this.c(true);
                    com.byazt.pp.c cVar = new com.byazt.pp.c(40063, com.byazt.pp.c.c(40063));
                    String strC2 = nu.c();
                    t tVar = t.this;
                    com.byazt.ng.a.c(tVar.uj, tVar.f28639a, cVar, 1, 0, (String) null, 0L, strC2);
                    t.this.ve(cVar);
                    return;
                }
                if (yp.sp()) {
                    strC = nu.c();
                } else {
                    strC = null;
                }
            }
            if (t.this.tt != null) {
                t.this.tt.c();
            }
            if (t.this.m.c()) {
                t.this.m.c(new com.byazt.nf.c.tt() { // from class: com.byazt.hz.t.c.1
                    @Override // com.byazt.nf.c.tt
                    public void c(final com.byazt.bo.c cVar2) {
                        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.t.c.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (t.this.tt != null) {
                                    t.this.tt.c(cVar2);
                                    t.this.c(cVar2, 0);
                                }
                            }
                        });
                    }
                });
                com.byazt.nf.c cVar2 = t.this.m;
                t tVar2 = t.this;
                cVar2.c(tVar2.f28639a, tVar2.uj);
            }
            com.byazt.hr.u.c().sp(t.this.n);
            if (t.this.uj != null) {
                com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.c(t.this.n, "show_listen") + "adSlotId：" + t.this.uj.getAdNetworkSlotId() + "，广告类型：" + com.byazt.yl.c.c(t.this.uj.getAdNetworkPlatformId()));
                com.byazt.hr.sl slVarC = com.byazt.hr.sl.c();
                t tVar3 = t.this;
                slVarC.tt(tVar3.n, tVar3.uj.getAdNetworkSlotId());
            }
            t tVar4 = t.this;
            tVar4.c(tVar4.ve);
            t tVar5 = t.this;
            tVar5.ve(tVar5.uj);
            com.byazt.yl.ve veVar2 = t.this.uj;
            if (veVar2 != null) {
                String adnName = veVar2.getAdnName();
                t tVar6 = t.this;
                com.byazt.xx.ve.c(adnName, tVar6.n, tVar6.uj.getAdNetworkSlotId());
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (nu.c(t.this.uj)) {
                String strTt = nu.tt();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                str = strTt;
            } else {
                str = null;
                jCurrentTimeMillis = -1;
            }
            t tVar7 = t.this;
            com.byazt.ng.a.c(tVar7.uj, tVar7.f28639a, 0, str, jCurrentTimeMillis, strC, false, tVar7.gt());
            com.byazt.bg.c.sp(t.this.n);
            com.byazt.bg.c.ve(t.this.n);
            com.byazt.psp.uj.c(1, t.this.f28639a.gt(), t.this.uj.getAdType(), t.this.uj.getCpm());
            t tVar8 = t.this;
            com.byazt.oi.ve.c(tVar8.n, tVar8.uj);
        }

        @Override // com.byazt.ln.c
        public void c(@NonNull com.byazt.pp.c cVar) {
            String strTt;
            long jCurrentTimeMillis;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (nu.c(t.this.uj)) {
                strTt = nu.tt();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                strTt = null;
                jCurrentTimeMillis = -1;
            }
            t tVar = t.this;
            com.byazt.ng.a.c(tVar.uj, tVar.f28639a, cVar, 1, 0, strTt, jCurrentTimeMillis);
            t.this.ve(cVar);
        }
    }

    public t(Context context) {
        super(context);
        this.my = false;
        this.gt = new com.byazt.zq.ve() { // from class: com.byazt.hz.t.4
            public final c tt;

            {
                this.tt = new c();
            }

            @Override // com.byazt.xu.c
            public void c() {
                t.this.my = true;
                this.tt.c();
            }

            @Override // com.byazt.xu.c
            public void n() {
            }

            @Override // com.byazt.xu.c
            public void tt() {
                this.tt.g_();
            }

            @Override // com.byazt.xu.c
            public void uj() {
            }

            @Override // com.byazt.xu.c
            public void ve() {
                this.tt.h_();
            }

            @Override // com.byazt.xu.c
            public void c(@NonNull com.byazt.pp.c cVar) {
                this.tt.c(cVar);
            }
        };
        this.rl = new c();
    }

    @Override // com.byazt.uhf.c
    public void a() {
        if (!yp.c()) {
            yv();
            if (this.m.c()) {
                this.m.tt();
            }
            com.byazt.uhf.c cVar = this.tt;
            if (cVar != null) {
                cVar.a();
                return;
            }
            return;
        }
        com.byazt.yl.ve veVar = this.uj;
        if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
            if (!yp.tt()) {
                com.byazt.ng.a.c(this.uj, this.f28639a, 3, 1, 0, nu.c());
                return;
            }
            com.byazt.ng.a.c(this.uj, this.f28639a, 3, 0, 0, (String) null);
        }
        if (zm()) {
            return;
        }
        yv();
        if (this.m.c()) {
            this.m.tt();
        }
        com.byazt.uhf.c cVar2 = this.tt;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    @Override // com.byazt.hz.tt
    public com.byazt.pp.ve f_() {
        if (this.my) {
            return super.f_();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0040  */
    @Override // com.byazt.uhf.c
    public void i_() {
        String str;
        String str2;
        long jCurrentTimeMillis;
        String strC;
        com.byazt.uhf.c cVar;
        com.byazt.bg.c.n(this.f28639a.gt());
        if (yp.c()) {
            com.byazt.yl.ve veVar = this.uj;
            if (veVar == null || !MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                strC = null;
            } else if (!yp.tt()) {
                com.byazt.ng.a.c(this.uj, this.f28639a, 5, 1, 0, nu.c());
                return;
            } else if (yp.n()) {
                strC = nu.c();
            } else {
                strC = null;
            }
            if (!zm() && (cVar = this.tt) != null) {
                cVar.i_();
            }
            str = strC;
        } else {
            com.byazt.uhf.c cVar2 = this.tt;
            if (cVar2 != null) {
                cVar2.i_();
            }
            str = null;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            String strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            str2 = strTt;
        } else {
            str2 = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.yl.ve veVar2 = this.uj;
        com.byazt.ng.a.c(veVar2, this.f28639a, 0, str2, jCurrentTimeMillis, str, veVar2.isClickListenRepeatOnce());
    }

    @Override // com.byazt.uhf.c
    public void j_() {
        if (!yp.c()) {
            yv();
            com.byazt.uhf.c cVar = this.tt;
            if (cVar != null) {
                cVar.j_();
                return;
            }
            return;
        }
        com.byazt.yl.ve veVar = this.uj;
        if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
            if (!yp.tt()) {
                com.byazt.ng.a.c(this.uj, this.f28639a, 2, 1, 0, nu.c());
                return;
            }
            com.byazt.ng.a.c(this.uj, this.f28639a, 2, 0, 0, (String) null);
        }
        if (zm()) {
            return;
        }
        yv();
        com.byazt.uhf.c cVar2 = this.tt;
        if (cVar2 != null) {
            cVar2.j_();
        }
    }

    @Override // com.byazt.uhf.c
    public void n() {
        String strTt;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.ng.a.c(this.uj, this.f28639a, (com.byazt.pp.c) null, 2, 0, strTt, jCurrentTimeMillis);
        com.byazt.uhf.c cVar = this.tt;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void sp() {
        com.byazt.uhf.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c();
        }
    }

    @Override // com.byazt.uhf.c
    public void uj() {
        if (!yp.c()) {
            yv();
            if (this.m.c()) {
                com.byazt.eu.tt.tt("GROMORE_SS_REWARD_VERIFY", "onVideoComplete回调，M客户端调用M服务端激励回调.....");
                this.m.n();
            }
            com.byazt.uhf.c cVar = this.tt;
            if (cVar != null) {
                cVar.uj();
                return;
            }
            return;
        }
        com.byazt.yl.ve veVar = this.uj;
        if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
            if (!yp.tt()) {
                com.byazt.ng.a.c(this.uj, this.f28639a, 1, 1, 0, nu.c());
                return;
            }
            com.byazt.ng.a.c(this.uj, this.f28639a, 1, 0, 0, (String) null);
        }
        if (zm()) {
            return;
        }
        yv();
        if (this.m.c()) {
            this.m.n();
        }
        com.byazt.uhf.c cVar2 = this.tt;
        if (cVar2 != null) {
            cVar2.uj();
        }
    }

    @Override // com.byazt.hz.da, com.byazt.hz.tt
    public void ve() {
        if (this.uj == null) {
            com.byazt.hk.c cVarC = com.byazt.hk.c.c();
            List<com.byazt.yl.ve> listC = this.ve.c(false);
            String str = this.n;
            com.byazt.ll.tt ttVar = this.f28639a;
            cVarC.c(listC, str, ttVar, ttVar.n(), this.uj);
        }
        super.ve();
        this.m.ve();
        this.c = null;
        this.tt = null;
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void x() {
        com.byazt.uhf.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.tt();
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void tt(@NonNull com.byazt.pp.c cVar) {
        com.byazt.uhf.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c(cVar);
        }
    }

    private void tt(com.byazt.bo.c cVar) {
        if (this.m.c()) {
            this.m.c(cVar, this.uj);
            return;
        }
        com.byazt.uhf.c cVar2 = this.tt;
        if (cVar2 != null) {
            cVar2.c(c(this.f28639a, cVar, this.uj, (Map<String, Object>) null));
            c((com.byazt.bo.c) null, 0);
        }
    }

    public void c(com.byazt.ll.tt ttVar, @NonNull com.byazt.uhf.tt ttVar2) {
        c(ttVar);
        this.m = new com.byazt.nf.c(this.n);
        this.c = ttVar2;
        this.i = this;
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(final com.byazt.pp.c cVar) {
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.t.3
            @Override // java.lang.Runnable
            public void run() {
                if (t.this.tt != null) {
                    t.this.tt.c(cVar);
                }
            }
        });
    }

    @MainThread
    public void c(Activity activity, Object obj, String str) {
        c(activity, obj, str, new da.c() { // from class: com.byazt.hz.t.1
            @Override // com.byazt.hz.da.c
            public void c() {
                t.this.ve(new com.byazt.pp.c(40052, com.byazt.pp.c.c(40052)));
            }
        });
        if (this.tt == null) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "注意：未设置GMRewardedAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        c(this.uj);
    }

    @MainThread
    public void c(Activity activity) {
        c(activity, (Object) null, (String) null);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022  */
    @Override // com.byazt.hz.da
    public void c(com.byazt.yl.ve veVar, Activity activity, Object obj, String str) {
        if (veVar != null) {
            if (veVar.getSubAdType() != 6) {
                if (veVar.getSubAdType() == 7) {
                    this.i = this.rl;
                } else if (veVar.getSubAdType() == 8) {
                    this.i = this.gt;
                } else {
                    this.i = this;
                }
            } else {
                this.i = this;
            }
        }
        super.c(veVar, activity, obj, str);
    }

    public void c(com.byazt.uhf.c cVar) {
        this.tt = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.bo.c cVar, int i) {
        String strTt;
        long jCurrentTimeMillis;
        int i2;
        int iIntValue;
        String str;
        Map<String, Object> mapUj;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        String str2 = strTt;
        long j = jCurrentTimeMillis;
        if (cVar == null || (mapUj = cVar.uj()) == null) {
            i2 = 0;
            iIntValue = 0;
            str = "";
        } else {
            Integer num = (Integer) mapUj.get(MediationConstant.KEY_REASON);
            int iIntValue2 = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) mapUj.get("errorCode");
            iIntValue = num2 != null ? num2.intValue() : 0;
            str = (String) mapUj.get("errorMsg");
            i2 = iIntValue2;
        }
        com.byazt.ng.a.c(this.uj, this.f28639a, i, str2, j, i2, iIntValue, str);
    }

    public static com.byazt.bo.c c(final com.byazt.ll.tt ttVar, final com.byazt.bo.c cVar, final com.byazt.yl.ve veVar, final Map<String, Object> map) {
        if (cVar == null) {
            return null;
        }
        return new com.byazt.bo.c() { // from class: com.byazt.hz.t.2
            @Override // com.byazt.bo.c
            public boolean c() {
                return cVar.c();
            }

            @Override // com.byazt.bo.c
            public float tt() {
                return cVar.tt();
            }

            @Override // com.byazt.bo.c
            public Map<String, Object> uj() {
                Map<String, Object> mapUj = cVar.uj();
                HashMap map2 = (mapUj == null || mapUj.size() <= 0) ? new HashMap() : new HashMap(mapUj);
                Map map3 = map;
                if (map3 != null && !map3.isEmpty()) {
                    map2.putAll(map);
                }
                com.byazt.pp.ve veVarC = com.byazt.vx.t.c(ttVar, veVar, true);
                map2.put(MediationConstant.KEY_ADN_NAME, veVarC != null ? veVarC.t() : "");
                map2.put("ecpm", veVarC != null ? veVarC.u() : "");
                return map2;
            }

            @Override // com.byazt.bo.c
            public String ve() {
                return cVar.ve();
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0050  */
    @Override // com.byazt.uhf.c
    public void c() {
        String strC;
        String str;
        long jCurrentTimeMillis;
        com.byazt.yl.ve veVar;
        this.my = true;
        if (!yp.c() || (veVar = this.uj) == null || !MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
            strC = null;
        } else {
            if (!yp.tt()) {
                c(true);
                com.byazt.pp.c cVar = new com.byazt.pp.c(40063, com.byazt.pp.c.c(40063));
                com.byazt.ng.a.c(this.uj, this.f28639a, cVar, 1, 0, (String) null, 0L, nu.c());
                ve(cVar);
                return;
            }
            if (yp.uj()) {
                strC = nu.c();
            } else {
                strC = null;
            }
        }
        com.byazt.uhf.c cVar2 = this.tt;
        if (cVar2 != null) {
            cVar2.c();
        }
        if (this.m.c()) {
            this.m.c(new com.byazt.nf.c.tt() { // from class: com.byazt.hz.t.5
                @Override // com.byazt.nf.c.tt
                public void c(final com.byazt.bo.c cVar3) {
                    com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.t.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (t.this.tt != null) {
                                t.this.tt.c(cVar3);
                                t.this.c(cVar3, 0);
                            }
                        }
                    });
                }
            });
            this.m.c(this.f28639a, this.uj);
        }
        com.byazt.hr.u.c().sp(this.n);
        if (this.uj != null) {
            com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.c(this.n, "show_listen") + "adSlotId：" + this.uj.getAdNetworkSlotId() + "，广告类型：" + com.byazt.yl.c.c(this.uj.getAdNetworkPlatformId()));
            com.byazt.hr.sl.c().tt(this.n, this.uj.getAdNetworkSlotId());
        }
        c(this.ve);
        ve(this.uj);
        com.byazt.yl.ve veVar2 = this.uj;
        if (veVar2 != null) {
            com.byazt.xx.ve.c(veVar2.getAdnName(), this.n, this.uj.getAdNetworkSlotId());
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            String strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            str = strTt;
        } else {
            str = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.ng.a.c(this.uj, this.f28639a, 0, str, jCurrentTimeMillis, strC, false, gt());
        com.byazt.bg.c.sp(this.f28639a.gt());
        com.byazt.bg.c.ve(this.f28639a.gt());
        com.byazt.psp.uj.c(1, this.f28639a.gt(), this.uj.getAdType(), this.uj.getCpm());
        com.byazt.oi.ve.c(this.n, this.uj);
    }

    @Override // com.byazt.uhf.c
    public void c(@NonNull com.byazt.pp.c cVar) {
        String strTt;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.ng.a.c(this.uj, this.f28639a, cVar, 1, 0, strTt, jCurrentTimeMillis);
        ve(cVar);
    }

    @Override // com.byazt.uhf.c
    public void c(@NonNull com.byazt.bo.c cVar) {
        if (yp.c()) {
            com.byazt.yl.ve veVar = this.uj;
            if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                if (!yp.tt()) {
                    com.byazt.ng.a.c(this.uj, this.f28639a, 4, 1, 0, nu.c());
                    return;
                } else {
                    com.byazt.ng.a.c(this.uj, this.f28639a, 4, 0, 0, yp.a() ? nu.c() : null);
                }
            }
            if (zm()) {
                return;
            }
            tt(cVar);
            return;
        }
        tt(cVar);
    }
}
