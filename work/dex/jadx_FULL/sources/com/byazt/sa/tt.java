package com.byazt.sa;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.cd.x;
import com.byazt.nw.Swiper;
import com.byazt.pm.i;
import com.byazt.sz.z;
import com.google.common.base.a;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import io.flutter.plugin.editing.SpellCheckPlugin;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 795, 13})
public class tt extends com.byazt.xj.c<Swiper> implements com.byazt.nw.c {
    public String az;
    public int ca;
    public float cf;
    public int cl;
    public int di;
    public boolean e;
    public boolean ej;
    public boolean gk;
    public float hg;
    public String ij;
    public float is;
    public int iw;
    public float iy;
    public String jg;
    public float jt;
    public float k;
    public boolean kz;
    public float mq;
    public float nc;
    public float nl;
    public boolean nx;
    public boolean pe;
    public int pl;
    public JSONArray sd;
    public float vi;
    public boolean vp;
    public float w;
    public int yo;

    public tt(Context context) {
        super(context);
        this.yo = 0;
        this.vp = true;
        this.kz = true;
        this.vi = 500.0f;
        this.mq = -1.0f;
        this.cf = 2000.0f;
        this.ij = "slide";
        this.az = "dot";
        this.is = 8.0f;
        this.jt = 8.0f;
        this.w = 50.0f;
        this.nl = 90.0f;
        this.ej = false;
        this.pl = Color.parseColor("#666666");
        this.di = Color.parseColor("#ffffff");
        this.jg = "row";
        this.hg = 1.0f;
        this.k = 0.0f;
        this.iy = 0.0f;
        this.nc = 0.0f;
        this.ca = 0;
        this.cl = 0;
        this.gk = true;
        this.e = false;
        this.pe = true;
        float fC = x.c(this.tt, 8.0f);
        this.is = fC;
        this.jt = fC;
    }

    private void a(int i) {
        if (this.pn == null) {
            return;
        }
        if (this.iw == 0 && i == kk() - 1) {
            this.pn.c("SwiperView://reloop", 1);
        }
        if (this.iw == kk() - 1 && i == 0) {
            this.pn.c("SwiperView://reloop", 0);
        }
    }

    private void b() {
        List<com.byazt.xj.ve<View>> list = ((com.byazt.xj.c) this).c;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.byazt.xj.ve<View> veVar = ((com.byazt.xj.c) this).c.get(0);
        if (this.sd == null) {
            return;
        }
        for (int i = 0; i < this.sd.length(); i++) {
            z zVar = new z(this.tt);
            c(zVar);
            zVar.c(this.hq);
            try {
                JSONObject jSONObjectOptJSONObject = this.sd.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    if (jSONObjectOptJSONObject.has("$chunk")) {
                        this.uj.put("$item", jSONObjectOptJSONObject.optJSONArray("$chunk"));
                    } else {
                        this.uj.put("$item", jSONObjectOptJSONObject);
                    }
                    ((Swiper) this.n).c(zVar.c(veVar.md(), this.uj, (JSONObject) null));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private int kk() {
        if (this.ca == 1) {
            List<com.byazt.xj.ve<View>> list = ((com.byazt.xj.c) this).c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        JSONArray jSONArray = this.sd;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    private void q() {
        for (int i = 0; i < ((com.byazt.xj.c) this).c.size(); i++) {
            com.byazt.xj.ve<View> veVar = ((com.byazt.xj.c) this).c.get(i);
            if (veVar != null) {
                z zVar = new z(this.tt);
                c(zVar);
                zVar.c(this.hq);
                ((Swiper) this.n).c(zVar.c(veVar.md(), this.uj, (JSONObject) null));
            }
        }
    }

    private void sp(int i) {
        i iVar = this.pn;
        if (iVar == null) {
            return;
        }
        iVar.c("SwiperView://slide", Integer.valueOf(this.iw), Integer.valueOf(i), Integer.valueOf(!this.nx ? 1 : 0));
    }

    @Override // com.byazt.xj.ve
    public View c() {
        Swiper swiper = new Swiper(this.tt);
        this.n = swiper;
        swiper.c((uj) this);
        return this.n;
    }

    @Override // com.byazt.xj.c, com.byazt.xj.ve
    public void tt() {
        super.tt();
        ((Swiper) this.n).ve((int) this.vi).n(this.e).c(this.az).c(this.is).tt(this.jt).ve(this.w).uj(this.nl).tt(this.jg).c(this.yo).tt().uj(this.vp).c(this.kz).tt((int) this.vi).uj((int) this.cf).n((int) this.mq).tt(this.gk).ve(this.ej).sp(this.pl).a(this.di).i((int) this.iy).da((int) this.nc).x((int) this.k).n(this.hg).ve(this.ij).yp(this.cl);
        ((Swiper) this.n).setOnPageChangeListener(this);
        if (this.ca == 1) {
            q();
        } else {
            b();
        }
        ((Swiper) this.n).ve();
    }

    @Override // com.byazt.xj.c
    public void c(com.byazt.xj.ve veVar) {
        if (veVar == null) {
            return;
        }
        ((com.byazt.xj.c) this).c.add(veVar);
    }

    @Override // com.byazt.xj.c
    public void c(com.byazt.xj.ve veVar, ViewGroup.LayoutParams layoutParams) {
        if (veVar == null) {
            return;
        }
        ((com.byazt.xj.c) this).c.add(veVar);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1598524863:
                if (str.equals("startDelay")) {
                    b = 0;
                }
                break;
            case -1593646704:
                if (str.equals(SpellCheckPlugin.START_INDEX_KEY)) {
                    b = 1;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    b = 2;
                }
                break;
            case -1560813342:
                if (str.equals("indicatorStyle")) {
                    b = 3;
                }
                break;
            case -1557466889:
                if (str.equals("indicatorWidth")) {
                    b = 4;
                }
                break;
            case -1469828074:
                if (str.equals("indicatorHeight")) {
                    b = 5;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    b = 6;
                }
                break;
            case -1367379379:
                if (str.equals("driveMode")) {
                    b = 7;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    b = 8;
                }
                break;
            case -962590849:
                if (str.equals(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)) {
                    b = 9;
                }
                break;
            case -855614293:
                if (str.equals("disableOnInteraction")) {
                    b = 10;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    b = 11;
                }
                break;
            case -597162967:
                if (str.equals("indicatorX")) {
                    b = 12;
                }
                break;
            case -597162966:
                if (str.equals("indicatorY")) {
                    b = 13;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    b = a.p;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    b = a.q;
                }
                break;
            case 95467907:
                if (str.equals("delay")) {
                    b = a.r;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    b = 17;
                }
                break;
            case 195414576:
                if (str.equals("indicatorDirection")) {
                    b = a.u;
                }
                break;
            case 497874535:
                if (str.equals("allowTouchMove")) {
                    b = 19;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    b = a.x;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    b = a.y;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    b = a.z;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    b = a.A;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    b = a.B;
                }
                break;
        }
        switch (b) {
            case 0:
                this.mq = com.byazt.cd.ve.c(str2, -1.0f);
                break;
            case 1:
                this.cl = com.byazt.cd.ve.c(str2, 0);
                break;
            case 2:
                this.pl = com.byazt.cd.c.c(str2, this.pl);
                break;
            case 3:
                this.az = str2;
                break;
            case 4:
                this.is = x.c(this.tt, com.byazt.cd.ve.c(str2, 8.0f));
                break;
            case 5:
                this.jt = x.c(this.tt, com.byazt.cd.ve.c(str2, 8.0f));
                break;
            case 6:
                this.nc = x.c(this.tt, com.byazt.cd.ve.c(str2, 0.0f));
                break;
            case 7:
                this.ca = com.byazt.cd.ve.c(str2, 0);
                break;
            case 8:
                this.ij = str2;
                break;
            case 9:
                if (TextUtils.equals(str2, "vertical")) {
                    this.yo = 1;
                } else {
                    this.yo = 0;
                }
                break;
            case 10:
                this.e = com.byazt.cd.ve.c(str2, false);
                break;
            case 11:
                this.ej = com.byazt.cd.ve.c(str2, false);
                break;
            case 12:
                this.w = com.byazt.cd.ve.c(str2, 50.0f);
                break;
            case 13:
                this.nl = com.byazt.cd.ve.c(str2, 90.0f);
                break;
            case 14:
                this.iy = x.c(this.tt, com.byazt.cd.ve.c(str2, 0.0f));
                break;
            case 15:
                this.vp = com.byazt.cd.ve.c(str2, true);
                break;
            case 16:
                this.cf = com.byazt.cd.ve.c(str2, 2000.0f);
                break;
            case 17:
                this.vi = com.byazt.cd.ve.c(str2, 500.0f);
                break;
            case 18:
                this.jg = str2;
                break;
            case 19:
                this.gk = com.byazt.cd.ve.c(str2, true);
                break;
            case 20:
                this.hg = com.byazt.cd.ve.c(str2, 1.0f);
                break;
            case 21:
                this.k = x.c(this.tt, com.byazt.cd.ve.c(str2, 0.0f));
                break;
            case 22:
                this.di = com.byazt.cd.c.c(str2, this.di);
                break;
            case 23:
                this.kz = com.byazt.cd.ve.c(str2, true);
                break;
            case 24:
                this.sd = com.byazt.cd.tt.c(this.uj, str2, null);
                break;
        }
    }

    @Override // com.byazt.nw.c
    public void c(boolean z, int i, float f, int i2) {
        c(z, i, f);
    }

    @Override // com.byazt.nw.c
    public void c(boolean z, int i, int i2, boolean z2, boolean z3) {
        if (this.iw != i) {
            a(i);
            sp(i);
            this.iw = i;
        }
    }

    @Override // com.byazt.nw.c
    public void c(boolean z, int i) {
        if (i != 0) {
            if (i != 1) {
                return;
            }
            this.nx = true;
        } else {
            if (!z) {
                this.pe = true;
            }
            this.nx = false;
        }
    }

    private void c(boolean z, int i, float f) {
        if (this.pn != null && !z && i == kk() - 1 && f == 0.0f && this.pe) {
            this.pn.c("SwiperView://finish", new Object[0]);
            this.pe = false;
        }
    }

    private void c(z zVar) {
        if (this.e) {
            zVar.c(new com.byazt.sz.a() { // from class: com.byazt.sa.tt.1
                @Override // com.byazt.sz.a
                public void c(com.byazt.xj.ve veVar, String str, List<com.byazt.pm.a.c> list) {
                    if ((TextUtils.equals(str, "tap") || TextUtils.equals(str, "slide") || TextUtils.equals(str, "touchStart") || TextUtils.equals(str, "touchEnd")) && tt.this.n != null) {
                        ((Swiper) tt.this.n).n();
                    }
                }
            });
        }
    }
}
