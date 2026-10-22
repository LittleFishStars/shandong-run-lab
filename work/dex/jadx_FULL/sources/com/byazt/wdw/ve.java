package com.byazt.wdw;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.bzd.x;
import com.byazt.eia.i;
import com.byazt.ete.ic;
import com.byazt.ete.yp;
import com.byazt.nr.h;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.gu;
import com.byazt.omf.rh;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tt f29157a;
    public i c;
    public final AtomicBoolean n = new AtomicBoolean(true);
    public Map<String, Object> sp;
    public final yp tt;
    public String uj;
    public final Context ve;

    public interface c {
        void c();
    }

    public interface tt {
        void c();

        void c(String str, boolean z);
    }

    public ve(i iVar, yp ypVar, Context context, Map<String, Object> map) {
        this.c = iVar;
        this.ve = context;
        this.tt = ypVar;
        this.sp = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(yp ypVar) {
        if (this.n.getAndSet(false)) {
            tt(ypVar);
        }
    }

    private void tt(final yp ypVar) {
        if (ypVar == null) {
            return;
        }
        try {
            gt.c().c(ypVar.tt(), new gu.ve<com.byazt.hm.tt>() { // from class: com.byazt.wdw.ve.3
                @Override // com.byazt.omf.gu.ve
                public void c(int i, String str) {
                    ve.this.c();
                    ve.this.ve(ypVar);
                }

                @Override // com.byazt.omf.gu.ve
                public void c(com.byazt.hm.tt ttVar) {
                    if (ttVar == null || !ttVar.i() || TextUtils.isEmpty(ttVar.n())) {
                        ve.this.c();
                        ve.this.ve(ypVar);
                    } else {
                        try {
                            ve.this.c(new JSONObject(ttVar.n()));
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public ve c(String str) {
        this.uj = str;
        return this;
    }

    private void tt(JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean("is_apply_coupon");
        String strOptString = jSONObject.optString("error_type");
        ic icVarC = com.byazt.ppf.ve.c(this.c, this.sp);
        if (zOptBoolean && "success".equals(strOptString)) {
            com.byazt.ddx.uj.tt(icVarC, this.uj, 1);
        } else if (zOptBoolean && "has_applied".equals(strOptString)) {
            com.byazt.ddx.uj.tt(icVarC, this.uj, 2);
        } else if (!zOptBoolean) {
            com.byazt.ddx.uj.tt(icVarC, this.uj, 3);
        }
        if (this.f29157a != null) {
            if (zOptBoolean && "success".equals(strOptString)) {
                this.f29157a.c();
            } else {
                this.f29157a.c(strOptString, zOptBoolean);
            }
        }
    }

    public void c(tt ttVar) {
        this.f29157a = ttVar;
    }

    public static boolean c(i iVar, boolean z) {
        yp ypVarMy = iVar != null ? iVar.my() : null;
        return ypVarMy != null && ypVarMy.tt(z);
    }

    public static boolean c(yp ypVar, boolean z) {
        return ypVar != null && ypVar.tt(z);
    }

    public int c(final c cVar) {
        yp ypVar = this.tt;
        c(ypVar);
        tt(ypVar);
        rh.a().postDelayed(new Runnable() { // from class: com.byazt.wdw.ve.1
            @Override // java.lang.Runnable
            public void run() {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c();
                }
            }
        }, 500L);
        return 1;
    }

    private void c(yp ypVar) {
        if (ypVar == null || TextUtils.isEmpty(ypVar.uj())) {
            return;
        }
        final String strUj = ypVar.uj();
        x.c(new Runnable() { // from class: com.byazt.wdw.ve.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h.tt(ve.this.ve.getApplicationContext(), strUj, 0, 17, 0, 0);
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.byazt.ddx.uj.tt(com.byazt.ppf.ve.c(this.c, this.sp), this.uj, 4);
        tt ttVar = this.f29157a;
        if (ttVar != null) {
            ttVar.c("net_fail", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        try {
            if (jSONObject.has("is_apply_coupon")) {
                tt(jSONObject);
            }
        } catch (Throwable unused) {
            c();
        }
    }
}
