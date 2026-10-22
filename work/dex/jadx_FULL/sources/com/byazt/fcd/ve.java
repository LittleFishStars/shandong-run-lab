package com.byazt.fcd;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.view.View;
import com.byazt.ete.ic;
import com.byazt.ete.lt;
import com.byazt.ete.xd;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.byazt.xl.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 54})
public class ve extends com.byazt.fcd.c {
    public final AtomicBoolean aw;
    public com.byazt.dn.c bm;
    public final AtomicBoolean bx;
    public int cu;
    public final List<com.byazt.iym.tt> d;
    public int eo;
    public com.byazt.iym.n hd;
    public final AtomicBoolean ic;
    public com.byazt.qmz.c lr;
    public int nb;
    public int or;
    public final AtomicBoolean pf;
    public int qp;
    public final AtomicBoolean sv;
    public int zb;

    public interface c {
        void c();

        void c(int i);

        void c(long j, long j2);

        void tt();

        void uj();

        Map<String, Object> ve();
    }

    public ve(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity, icVar);
        this.d = new ArrayList();
        this.eo = 0;
        this.zb = 0;
        this.or = 0;
        this.cu = 0;
        this.qp = 0;
        this.nb = 0;
        this.pf = new AtomicBoolean(false);
        this.bx = new AtomicBoolean(false);
        this.sv = new AtomicBoolean(true);
        this.aw = new AtomicBoolean(false);
        this.ic = new AtomicBoolean(true);
    }

    private void f() {
        String str;
        boolean z;
        String str2;
        boolean z2 = Math.max(0, this.h.ve() - yv()) == 0;
        int iUj = lt.uj(this.tt);
        int iN = lt.n(this.tt);
        int iA = a(false);
        if (lt.x(this.tt)) {
            if (iA > 0) {
                str2 = iA + "s";
            } else {
                str2 = "奖励已领取";
            }
            z = false;
            str = str2;
        } else {
            str = "领取成功";
            if (iUj == 0) {
                if (iA > 0) {
                    str = iA + "s后可领取奖励";
                }
                z = true;
            } else {
                if (iA > 0) {
                    str = iA + "s";
                }
                z = false;
            }
        }
        tt(a(true));
        this.rh.c(z, str, (z2 && iN == 1) ? "跳过" : null, z2 && iN == 0, z2);
        com.byazt.qmz.c cVar = this.lr;
        if (cVar != null) {
            cVar.c((int) (this.h.c() / 1000), this.h.n(), this.h.tt(), a(false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.byazt.jzl.a aVarDa;
        com.byazt.iym.n nVar = this.hd;
        ic icVarC = null;
        com.byazt.dh.ve veVarQp = nVar != null ? nVar.qp() : null;
        com.byazt.iym.tt ttVar = this.d.get(this.cu);
        if (ttVar != null) {
            icVarC = ttVar.c();
            aVarDa = ttVar.da();
        } else {
            aVarDa = null;
        }
        this.my.c(icVarC, veVarQp, aVarDa);
        this.my.tt(this.c.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj() {
        if (this.cu < this.d.size() - 1) {
            this.d.get(this.cu + 1).t();
            this.d.get(this.cu + 1).c(this.n, this.f28536a);
        }
    }

    private void ir() {
        String str;
        String string;
        String str2;
        if (lt.x(this.tt)) {
            int iMin = this.cu + 1;
            int size = this.d.size();
            boolean z = this.cu + 1 >= this.d.size();
            boolean z2 = this.cu == 0;
            int iJ = j();
            boolean z3 = this.h.n() - this.or < lt.z(this.tt);
            if (this.sv.get()) {
                if (!z3) {
                    iMin = Math.min(iMin + 1, size);
                }
                int i = iMin;
                String str3 = i + WVNativeCallbackUtil.SEPERATER + size;
                if (z3) {
                    StringBuilder sb = new StringBuilder();
                    if (z2) {
                        str2 = "可看" + size + "个视频,当前 ";
                    } else {
                        str2 = "正在播放 ";
                    }
                    sb.append(str2);
                    sb.append(str3);
                    string = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    if (z) {
                        str = "";
                    } else {
                        str = iJ + "秒后播放 ";
                    }
                    sb2.append(str);
                    sb2.append(str3);
                    string = sb2.toString();
                }
                this.rh.c(string, this.aw.get() ? OptionsPickerHelper.e : null, this.aw.get());
                com.byazt.qmz.c cVar = this.lr;
                if (cVar != null) {
                    cVar.c(iJ, z, i, size, true, z3, this.aw.get());
                }
            } else {
                this.rh.c((String) null, (String) null, false);
                com.byazt.qmz.c cVar2 = this.lr;
                if (cVar2 != null) {
                    cVar2.c(0, z, 0, 0, false, false, false);
                }
                if (iJ == 0 && !dz()) {
                    i(false);
                }
            }
            if (iJ == 0) {
                i(false);
            }
        }
        if (this.h.n() <= lt.i(this.tt) || this.bx.get() || ma() == null) {
            return;
        }
        ma().n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.dqg.uj ma() {
        com.byazt.dqg.tt ttVar = this.i;
        if (ttVar instanceof com.byazt.dqg.uj) {
            return (com.byazt.dqg.uj) ttVar;
        }
        return null;
    }

    public static int tt(ic icVar) {
        return 8;
    }

    private void yf() {
        com.byazt.iym.n nVar = this.hd;
        if (nVar == null || !nVar.nb()) {
            int iUj = this.d.get(this.cu).uj();
            if (iUj > 0) {
                this.eo += iUj;
            }
            if ((lt.ve(this.tt) <= this.zb) && !this.pf.get()) {
                this.c.uj(0);
                this.c.t();
                this.pf.set(true);
            }
            int i = this.zb;
            if (i < this.eo) {
                this.zb = i + 1;
            }
        }
    }

    @Override // com.byazt.fcd.c
    public boolean a() {
        return false;
    }

    @Override // com.byazt.fcd.c
    public int aw() {
        return this.zb;
    }

    @Override // com.byazt.fcd.tt
    public boolean b() {
        return false;
    }

    @Override // com.byazt.fcd.c
    public int bx() {
        return lt.ve(this.tt) - this.zb;
    }

    public boolean dz() {
        ic icVarC = this.d.get(this.cu).c();
        return Math.round(xd.sp(icVarC)) <= ((long) lt.tt(icVarC));
    }

    @Override // com.byazt.fcd.c
    public int eo() {
        return tt(this.tt);
    }

    @Override // com.byazt.fcd.c
    public void gu() {
        if (this.gt.cu()) {
            return;
        }
        try {
            com.byazt.iym.n nVar = (com.byazt.iym.n) ma().tt().ve(this.qp);
            if (nVar != null) {
                nVar.md();
            }
        } catch (Exception e) {
            m.ve("cubic  resume exception:" + e.getMessage());
        }
    }

    @Override // com.byazt.fcd.tt
    public boolean iu() {
        if (lt.m(this.tt)) {
            return this.m;
        }
        return false;
    }

    public int j() {
        ic icVarC = this.d.get(this.cu).c();
        return Math.max(0, ((((int) Math.min(Math.round(xd.sp(icVarC)), lt.tt(icVarC))) + (dz() ? 1 : 0)) + this.or) - this.h.n());
    }

    @Override // com.byazt.fcd.tt
    public boolean kk() {
        return true;
    }

    @Override // com.byazt.fcd.c
    public void lt() {
        this.sv.set(false);
        this.ic.set(false);
        r();
    }

    @Override // com.byazt.fcd.c
    public void m() {
        super.m();
        List<com.byazt.iym.tt> list = this.d;
        if (list != null) {
            Iterator<com.byazt.iym.tt> it = list.iterator();
            while (it.hasNext()) {
                it.next().x();
            }
        }
        if (ma() != null) {
            ma().ve().uj();
        }
    }

    @Override // com.byazt.fcd.tt
    public boolean q() {
        return this.tt.wn() == 2 || this.tt.wn() == 3 || this.tt.wn() == 7;
    }

    @Override // com.byazt.fcd.c
    public void qy() {
        try {
            com.byazt.iym.n nVar = (com.byazt.iym.n) ma().tt().ve(this.qp);
            if (nVar != null) {
                nVar.p();
            }
        } catch (Exception e) {
            m.ve("cubic pause exception:" + e.getMessage());
        }
    }

    @Override // com.byazt.fcd.tt
    public void r() {
        f();
        yf();
        ir();
    }

    @Override // com.byazt.fcd.tt
    public void s() {
        this.rh.c(true);
        this.rh.tt(this.tt.fe());
        this.rh.ve(true);
        this.rh.n(true);
        if (!TextUtils.isEmpty(lt.sl(this.tt))) {
            this.rh.c(false);
            com.byazt.dn.c cVar = new com.byazt.dn.c(this.tt);
            this.bm = cVar;
            cVar.c(new com.byazt.xl.sp() { // from class: com.byazt.fcd.ve.1
                public boolean c = false;

                @Override // com.byazt.xl.sp
                public void c(final View view, final yp ypVar) {
                    if (this.c) {
                        return;
                    }
                    ve.this.c.or().post(new Runnable() { // from class: com.byazt.fcd.ve.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ve.this.c.or().getTopFrameContainer().removeAllViews();
                            ve.this.c.or().getTopFrameContainer().addView(view);
                            ve.this.rh.c(true);
                            yp ypVar2 = ypVar;
                            if (ypVar2 instanceof com.byazt.atv.ve) {
                                ve.this.lr = ((com.byazt.atv.ve) ypVar2).rh();
                                ve.this.lr.c((int) (ve.this.h.c() / 1000), ve.this.h.n(), ve.this.h.tt(), ve.this.a(false));
                                ve.this.r();
                            }
                        }
                    });
                }

                @Override // com.byazt.xl.sp
                public void c(int i, String str) {
                    this.c = true;
                    ve.this.rh.c(true);
                }
            });
            this.bm.c(new com.byazt.xl.x() { // from class: com.byazt.fcd.ve.2
                @Override // com.byazt.xl.x
                public void c(View view, int i, com.byazt.sr.ve veVar, int i2) {
                    if (i == 3) {
                        ve.this.lr().i();
                    } else if (i == 5) {
                        ve.this.lr().c(!ve.this.u);
                    } else {
                        if (i != 6) {
                            return;
                        }
                        ve.this.lr().a();
                    }
                }

                @Override // com.byazt.xl.x
                public void tt(View view, int i, com.byazt.sr.ve veVar, int i2) {
                }
            });
            this.bm.c(new com.byazt.kdw.tt() { // from class: com.byazt.fcd.ve.3
                @Override // com.byazt.kdw.tt
                public void c() {
                    ve.this.lt();
                }
            });
            this.bm.c(lt.sl(this.tt), lt.t(this.tt), this.n, 0, lt.u(this.tt));
        }
        r();
    }

    @Override // com.byazt.fcd.c, com.byazt.fcd.tt
    public boolean to() {
        return lt.x(this.tt);
    }

    @Override // com.byazt.fcd.c
    public void zm() {
        super.zm();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visible", false);
        } catch (JSONException e) {
            m.c(e);
        }
        this.gt.c(jSONObject);
        if (!to()) {
            qy();
        }
        this.sv.set(false);
        this.rh.c((String) null, (String) null, false);
        com.byazt.qmz.c cVar = this.lr;
        if (cVar != null) {
            cVar.c(0, true, 0, 0, false, false, false);
            this.lr.c((int) (this.h.c() / 1000), this.h.n(), this.h.tt(), a(false));
        }
    }

    @Override // com.byazt.fcd.c
    public View i() {
        return com.byazt.vfu.a.da(this.c);
    }

    @Override // com.byazt.fcd.c
    public int sp(boolean z) {
        return z ? bx() : lt.sp(this.tt) - this.zb;
    }

    @Override // com.byazt.fcd.c
    public void x() {
        super.x();
        this.d.add(new com.byazt.iym.tt(this.c, this.tt, this.t, q(), true));
        try {
            JSONArray jSONArray = new JSONArray(this.tt.hl());
            for (int i = 0; i < jSONArray.length(); i++) {
                this.d.add(new com.byazt.iym.tt(this.c, com.byazt.omf.c.c(jSONArray.getJSONObject(i)), this.t, q(), false));
            }
        } catch (JSONException e) {
            m.c(e);
        }
        Iterator<com.byazt.iym.tt> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().c(this.u);
        }
        this.aw.set(lt.yp(this.tt));
    }

    public void i(boolean z) {
        if (!this.gt.cu() && this.cu + 1 < this.d.size()) {
            this.or = this.h.n();
            if (!(z || this.ic.get() || lt.a(this.tt)) || ma() == null) {
                return;
            }
            ma().tt().tt(this.qp + 1);
        }
    }

    @Override // com.byazt.fcd.c
    public void n(boolean z) {
        super.n(z);
        com.byazt.iym.n nVar = this.hd;
        if (nVar != null) {
            nVar.ve(z);
        }
        Iterator<com.byazt.iym.tt> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().c(z);
        }
    }

    @Override // com.byazt.fcd.c, com.byazt.fcd.tt
    public void ve() {
        this.i.ve(true);
        if (ma() != null) {
            ma().ve().c(this.d);
            ma().uj().c(new com.byazt.iym.ve.c() { // from class: com.byazt.fcd.ve.4
                @Override // com.byazt.iym.ve.c
                public void c() {
                    ve veVar = ve.this;
                    veVar.m = true;
                    veVar.cu = 0;
                    c((com.byazt.iym.n) ve.this.ma().tt().ve(0));
                    ve.this.g();
                    ve.this.hj();
                    ve.this.c.tt(false, true);
                }

                @Override // com.byazt.iym.ve.c
                public void c(boolean z, int i, boolean z2) {
                    int i2 = ve.this.qp;
                    if (ve.this.hd != null) {
                        ve.this.c.lt().c(z, i2 + 1, ve.this.hd.eo());
                    }
                    ve.this.qp = i;
                    ve veVar = ve.this;
                    veVar.nb = Math.max(veVar.nb, i + 1);
                    ve veVar2 = ve.this;
                    veVar2.cu = i % veVar2.d.size();
                    c((com.byazt.iym.n) ve.this.ma().tt().ve(i));
                    ve.this.ma().a();
                    ve.this.bx.set(true);
                    ve.this.aw.set(lt.yp(ve.this.tt) && ve.this.cu + 1 < ve.this.d.size());
                    ve.this.r();
                    ve.this.hj();
                    ve veVar3 = ve.this;
                    veVar3.rh.c(((com.byazt.iym.tt) veVar3.d.get(ve.this.cu)).c());
                }

                @Override // com.byazt.iym.ve.c
                public void c(boolean z, int i) {
                    com.byazt.iym.n nVar = (com.byazt.iym.n) ve.this.ma().tt().ve(i);
                    if (nVar != null) {
                        nVar.tt(false);
                    }
                }

                private void c(com.byazt.iym.n nVar) {
                    if (nVar != null) {
                        ve.this.hd = nVar;
                        ve.this.hd.tt(true);
                        ve.this.hd.c(new c() { // from class: com.byazt.fcd.ve.4.1
                            @Override // com.byazt.fcd.ve.c
                            public void c() {
                                ve veVar = ve.this;
                                veVar.m = true;
                                veVar.ma().c(false);
                            }

                            @Override // com.byazt.fcd.ve.c
                            public void tt() {
                                ve veVar = ve.this;
                                veVar.m = false;
                                veVar.ma().c(true);
                            }

                            @Override // com.byazt.fcd.ve.c
                            public void uj() {
                                if (ve.this.cu + 1 >= ve.this.d.size() || !ve.this.sv.get()) {
                                    ve.this.c.a(1);
                                } else if (ve.this.dz()) {
                                    ve.this.i(false);
                                }
                            }

                            @Override // com.byazt.fcd.ve.c
                            public Map<String, Object> ve() {
                                return ve.this.c.x();
                            }

                            @Override // com.byazt.fcd.ve.c
                            public void c(int i) {
                                ve.this.eo += i;
                                ve.this.zb += i;
                                ve.this.c.t(i);
                            }

                            @Override // com.byazt.fcd.ve.c
                            public void c(long j, long j2) {
                                ve.this.m = false;
                            }
                        });
                        ve.this.m = nVar.nb();
                        ve.this.ma().c(!nVar.pf());
                    } else {
                        ve.this.m = false;
                    }
                    ve.this.g();
                }
            });
        }
    }

    public static boolean c(ic icVar) {
        return (icVar == null || !lt.c(icVar) || TextUtils.isEmpty(icVar.hl())) ? false : true;
    }

    @Override // com.byazt.fcd.c
    public com.byazt.dqg.tt c(boolean z) {
        com.byazt.dqg.uj ujVar = new com.byazt.dqg.uj(this.c, this.tt, z);
        float f = this.n;
        float f2 = this.f28536a;
        float[] fArrGt = {f, f2};
        if (f < 10.0f || f2 < 10.0f) {
            fArrGt = gt();
        }
        ujVar.c(fArrGt);
        this.i = ujVar;
        return ujVar;
    }

    @Override // com.byazt.fcd.c
    public com.byazt.qq.tt.c c(ic icVar, final com.byazt.qq.da daVar) {
        this.c.sv();
        com.byazt.qq.c veVar = lt.x(icVar) ? new com.byazt.qq.ve(this.c, icVar) : new com.byazt.qq.n(this.c, icVar);
        veVar.c(sv());
        return veVar.tt(new com.byazt.qq.da() { // from class: com.byazt.fcd.ve.5
            @Override // com.byazt.qq.da
            public void c() {
                super.c();
                com.byazt.qq.da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.c();
                }
                ve.this.c.aw();
            }

            @Override // com.byazt.qq.da
            public void tt() {
                com.byazt.qq.da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.tt();
                }
            }

            @Override // com.byazt.qq.da
            public void ve() {
                super.ve();
                ve.this.c.aw();
                ve.this.i(true);
                ve.this.c.lt().c("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.byazt.fcd.c
    public void c(Map<String, Object> map) {
        super.c(map);
        map.put("group_pos", Integer.valueOf(this.qp + 1));
        com.byazt.iym.n nVar = this.hd;
        if (nVar != null) {
            map.put("duration", Long.valueOf(nVar.eo()));
        }
    }

    @Override // com.byazt.fcd.c
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
        try {
            jSONObject.put("group_pos", this.cu + 1);
            jSONObject.put("duration", this.hd.eo());
        } catch (JSONException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.fcd.c
    public void c(View view) {
        super.c(view);
        this.hd.c(view);
    }
}
