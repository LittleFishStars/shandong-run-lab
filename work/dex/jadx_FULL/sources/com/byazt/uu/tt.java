package com.byazt.uu;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.byazt.ly.uj;
import com.byazt.ly.ve;
import com.byazt.nr.m;
import com.byazt.vx.qy;
import com.byazt.vx.yv;
import com.byazt.yf.sl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1497, 13})
public abstract class tt {
    public ve c;
    public final Set<String> tt = new CopyOnWriteArraySet();
    public boolean uj = false;
    public boolean ve = false;

    private synchronized void ve(sl slVar) {
        try {
            if (this.uj || !com.byazt.px.c.ve(tt(), this.ve)) {
                String strVe = ve();
                if (!TextUtils.isEmpty(strVe)) {
                    throw new Exception("adn init ".concat(String.valueOf(strVe)));
                }
                Map<String, Object> mapC = c();
                if (mapC == null) {
                    throw new Exception("adn init getConfig() is null");
                }
                mapC.put(MediationConstant.EXTRA_ADN_NAME, tt());
                mapC.put("q_x_c", Integer.valueOf(com.byazt.ck.tt.c().uj()));
                mapC.put("wf_q_x_c", Integer.valueOf(com.byazt.ck.tt.c().n()));
                uj ujVarC = com.byazt.px.tt.c().c(tt(), slVar);
                if (ujVarC == null) {
                    throw new Exception("configuration is null");
                }
                c(ujVarC, mapC);
                if (!this.uj) {
                    com.byazt.px.c.tt(tt(), this.ve);
                }
            }
        } catch (Throwable th) {
            m.c(th);
            com.byazt.px.c.c(tt(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, th.toString()));
        }
    }

    public abstract Map<String, Object> c();

    public abstract String tt();

    public void uj() {
        tt((sl) null);
    }

    public abstract String ve();

    private void tt(sl slVar) {
        com.byazt.nbs.c cVarC = com.byazt.bp.tt.tt().c(tt());
        if (slVar == null && cVarC == null && !MediationConstant.ADN_PANGLE.equals(tt())) {
            return;
        }
        ve(slVar);
    }

    public void c(sl slVar) {
        this.uj = true;
        tt(slVar);
    }

    public void c(sl slVar, ve veVar) {
        this.c = veVar;
        this.uj = true;
        tt(slVar);
    }

    private synchronized void c(uj ujVar, Map<String, Object> map) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.byazt.eu.tt.c("TMe", "--==--time: start " + tt());
        ujVar.initAdn(com.byazt.bp.tt.getContext(), map, new ve() { // from class: com.byazt.uu.tt.1
            @Override // com.byazt.ly.ve
            public void c() {
                if (tt.this.c != null) {
                    tt.this.c.c();
                }
                if (TextUtils.equals(tt.this.tt(), MediationConstant.ADN_PANGLE)) {
                    qy.c();
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                com.byazt.eu.tt.c("TMe", "--==--time: " + tt.this.tt() + ", ----==----- " + jElapsedRealtime2);
                if (!tt.this.tt.contains(tt.this.tt())) {
                    tt.this.tt.add(tt.this.tt());
                    yv.c(tt.this.tt(), jElapsedRealtime2);
                }
                com.byazt.px.c.c(tt.this.tt(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
            }

            @Override // com.byazt.ly.ve
            public void c(@NonNull com.byazt.pp.c cVar) {
                if (tt.this.c != null) {
                    tt.this.c.c(cVar);
                }
                if (cVar != null) {
                    com.byazt.px.c.c(tt.this.tt(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + cVar.c + " errorMessage = " + cVar.tt));
                }
            }
        });
    }
}
