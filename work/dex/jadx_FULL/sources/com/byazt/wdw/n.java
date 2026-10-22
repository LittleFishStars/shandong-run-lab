package com.byazt.wdw;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.byazt.aas.nb;
import com.byazt.aas.rl;
import com.byazt.bzd.x;
import com.byazt.cr.a;
import com.byazt.ddx.i;
import com.byazt.eia.da;
import com.byazt.ete.hq;
import com.byazt.ete.ic;
import com.byazt.nr.h;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.gu;
import com.byazt.omf.p;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 46})
public class n {
    public static volatile boolean sp = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hq f29155a;
    public Toast c;
    public Map<String, Object> da;
    public final boolean i;
    public boolean n;
    public final Context tt;
    public String uj;
    public int ve;
    public final da x;

    public interface c {
        void c();

        void c(com.byazt.cr.c cVar);
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 934})
    public class tt implements gu.ve<JSONObject> {
        public final c c;
        public final hq tt;
        public final Toast uj;

        public tt(c cVar, hq hqVar, Toast toast) {
            this.c = cVar;
            this.tt = hqVar;
            this.uj = toast;
        }

        @Override // com.byazt.omf.gu.ve
        public void c(int i, String str) {
            m.tt("WechatClickHandler", "getWechatLink failed:" + i + ", " + str);
            this.tt.tt(0);
            Toast toast = this.uj;
            if (toast != null) {
                toast.cancel();
            }
            a aVar = i == 606 ? a.f28374a : a.n;
            c cVar = this.c;
            if (cVar != null) {
                cVar.c(aVar);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.byazt.omf.gu.ve
        public void c(JSONObject jSONObject) {
            String strOptString = jSONObject.optString(NativeModel.JSON_KEY_SCHEME);
            if (!TextUtils.isEmpty(strOptString)) {
                n.this.c(strOptString, this.tt, this.c);
            } else {
                c(606, " scheme is null!");
            }
        }
    }

    public n(da daVar, Context context, boolean z) {
        this.x = daVar;
        this.tt = context;
        this.i = z;
    }

    private void uj() {
        x.c(new Runnable() { // from class: com.byazt.wdw.n.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (n.this.c != null) {
                        n.this.c.cancel();
                    }
                    n nVar = n.this;
                    nVar.c = h.c(nVar.tt, "即将跳转微信...", 1, 17, 0, 0);
                    n.this.c.show();
                } catch (Throwable th) {
                    m.ve("toast error:" + th.getMessage());
                }
            }
        });
    }

    private int ve() {
        hq hqVar = this.f29155a;
        if (hqVar == null) {
            return 0;
        }
        if (hqVar.a() == 1 && uj.ve().c()) {
            return TextUtils.isEmpty(this.f29155a.sp()) ? 0 : 1;
        }
        return 2;
    }

    public n tt(boolean z) {
        this.n = z;
        return this;
    }

    private boolean tt(c cVar) {
        int iVe;
        int iTt = this.f29155a.tt();
        if (iTt != 1) {
            if (iTt != 2 || (iVe = ve()) == 0) {
                return false;
            }
            if (iVe == 1) {
                c(cVar, this.f29155a);
                return true;
            }
            if (TextUtils.isEmpty(this.f29155a.c())) {
                return false;
            }
            c(cVar, this.f29155a, 2000L);
            return true;
        }
        if (this.n) {
            if (TextUtils.isEmpty(this.f29155a.x())) {
                return true;
            }
            if (ve() == 1) {
                c(cVar, this.f29155a);
                return true;
            }
        }
        return false;
    }

    public static boolean c() {
        return sp;
    }

    public static void c(boolean z) {
        sp = z;
    }

    public n c(String str) {
        this.uj = str;
        return this;
    }

    public n c(int i) {
        this.ve = i;
        return this;
    }

    public n c(Map<String, Object> map) {
        this.da = map;
        return this;
    }

    public boolean c(c cVar) {
        if (this.f29155a == null) {
            da daVar = this.x;
            this.f29155a = daVar != null ? daVar.A_() : null;
        }
        if (this.f29155a == null) {
            return false;
        }
        if (this.i) {
            da daVar2 = this.x;
            if (daVar2 instanceof com.byazt.eia.uj) {
                return c(((com.byazt.eia.uj) daVar2).da(), cVar);
            }
        }
        return tt(cVar);
    }

    public ic tt() {
        return com.byazt.ppf.ve.c(this.x, this.da);
    }

    private boolean c(int i, c cVar) {
        if (i == 1) {
            c(cVar, this.f29155a);
            return true;
        }
        if (i != 2) {
            if (i != 3 || !this.n) {
                return false;
            }
            c(cVar, this.f29155a);
            return true;
        }
        if (TextUtils.isEmpty(this.f29155a.c())) {
            return false;
        }
        c(cVar, this.f29155a, 2000L);
        return true;
    }

    private void c(final c cVar, hq hqVar) {
        uj();
        da daVar = this.x;
        if ((daVar instanceof com.byazt.eia.uj) && !TextUtils.isEmpty(((com.byazt.eia.uj) daVar).sp()) && !TextUtils.isEmpty(((com.byazt.eia.uj) this.x).i())) {
            uj ujVarVe = uj.ve();
            da daVar2 = this.x;
            ujVarVe.c(daVar2, ((com.byazt.eia.uj) daVar2).i(), ((com.byazt.eia.uj) this.x).sp(), cVar, this.uj, this.n, this.da);
        } else {
            gt.c().c(hqVar, this.x.x(), this.x.w_(), new tt(cVar, hqVar, this.c) { // from class: com.byazt.wdw.n.1
                @Override // com.byazt.wdw.n.tt, com.byazt.omf.gu.ve
                public void c(JSONObject jSONObject) {
                    String strOptString = jSONObject.optString("userName");
                    String strOptString2 = jSONObject.optString("path");
                    if (TextUtils.isEmpty(strOptString)) {
                        c(605, " userName or path is null!");
                        return;
                    }
                    if (n.this.c != null) {
                        n.this.c.cancel();
                    }
                    uj.ve().c(n.this.x, strOptString, strOptString2, cVar, n.this.uj, n.this.n, n.this.da);
                }

                @Override // com.byazt.wdw.n.tt, com.byazt.omf.gu.ve
                public void c(int i, String str) {
                    a aVar;
                    n.this.f29155a.tt(0);
                    if (n.this.c != null) {
                        n.this.c.cancel();
                    }
                    if (i == 606) {
                        aVar = a.da;
                    } else {
                        aVar = a.i;
                    }
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c(aVar);
                    }
                }
            }, 1, 2000L);
        }
    }

    private void c(c cVar, hq hqVar, long j) {
        uj();
        gt.c().c(hqVar, this.x.x(), this.x.w_(), new tt(cVar, hqVar, this.c), 2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, final hq hqVar, final c cVar) {
        Toast toast = this.c;
        if (toast != null) {
            toast.cancel();
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        final String strC = rl.tt(tt()) ? this.uj : nb.c(this.ve);
        HashMap map = new HashMap();
        map.put("source", "WechatClickProcesser");
        map.put(NativeModel.JSON_KEY_SCHEME, nb.c(str));
        com.byazt.ddx.uj.c(tt(), strC, (Map<String, Object>) map, false);
        com.byazt.nr.tt.c(this.tt, intent, new com.byazt.nr.tt.c() { // from class: com.byazt.wdw.n.3
            @Override // com.byazt.nr.tt.c
            public void c() {
                hqVar.tt(1);
                com.byazt.ddx.uj.c(n.this.tt(), strC, (Throwable) null, false, true);
                com.byazt.ddx.x.c().c(n.this.tt(), strC, false, false, new i.c() { // from class: com.byazt.wdw.n.3.1
                    @Override // com.byazt.ddx.i.c
                    public void c(long j) {
                        c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.c(a.x);
                        }
                    }

                    @Override // com.byazt.ddx.i.c
                    public void c(String str2) {
                    }

                    @Override // com.byazt.ddx.i.c
                    public void c(boolean z) {
                        c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.c();
                        }
                    }
                });
            }

            @Override // com.byazt.nr.tt.c
            public void c(Throwable th) {
                com.byazt.ddx.uj.c(n.this.tt(), strC, th, false, false);
                hqVar.tt(0);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(a.sp);
                }
            }
        }, TextUtils.equals(p.x, "internal"));
    }
}
