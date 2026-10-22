package com.byazt.sa;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.byazt.cd.x;
import com.byazt.nw.Swiper;
import com.byazt.sz.z;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 795, 54})
@Deprecated
public class ve extends com.byazt.xj.c<Swiper> {
    public int az;
    public String cf;
    public float di;
    public float ej;
    public boolean ij;
    public int is;
    public float jt;
    public boolean kz;
    public float mq;
    public com.byazt.xj.ve nl;
    public float pl;
    public float vi;
    public boolean vp;
    public JSONArray w;
    public String yo;

    public ve(Context context) {
        super(context);
        this.vp = true;
        this.kz = true;
        this.vi = 0.0f;
        this.mq = 2000.0f;
        this.cf = "normal";
        this.ij = true;
        this.az = Color.parseColor("#666666");
        this.is = Color.parseColor("#ffffff");
    }

    @Override // com.byazt.xj.ve
    public View c() {
        Swiper swiper = new Swiper(this.tt);
        this.n = swiper;
        swiper.c((uj) this);
        return this.n;
    }

    @Override // com.byazt.xj.ve
    public void c(JSONObject jSONObject) {
    }

    @Override // com.byazt.xj.c, com.byazt.xj.ve
    public void tt() {
        super.tt();
        JSONArray jSONArray = this.w;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((Swiper) this.n).x((int) this.ej).i((int) this.pl).da((int) this.di).ve(this.ij).a(this.is).sp(this.az).ve(this.cf).uj(this.vp).n(this.jt).c(this.kz).uj((int) this.mq).ve(this.ij);
        for (int i = 0; i < this.w.length(); i++) {
            z zVar = new z(this.tt);
            zVar.c(this.hq);
            com.byazt.xj.ve<View> veVarTt = zVar.tt(this.nl.md(), null);
            zVar.tt(this.w.optJSONObject(i));
            ((Swiper) this.n).c(veVarTt);
        }
        if (this.kz) {
            ((Swiper) this.n).ve();
        }
    }

    @Override // com.byazt.xj.c
    public void c(com.byazt.xj.ve veVar) {
        this.nl = veVar;
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        switch (str) {
            case "delayStart":
                this.vi = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case "indicatorColor":
                this.az = com.byazt.cd.c.c(str2);
                break;
            case "nextMargin":
                this.di = x.c(this.tt, com.byazt.cd.ve.c(str2, 0.0f));
                break;
            case "effect":
                this.cf = str2;
                break;
            case "direction":
                this.yo = str2;
                break;
            case "indicator":
                this.ij = com.byazt.cd.ve.c(str2, true);
                break;
            case "previousMargin":
                this.pl = x.c(this.tt, com.byazt.cd.ve.c(str2, 0.0f));
                break;
            case "loop":
                this.vp = com.byazt.cd.ve.c(str2, true);
                break;
            case "speed":
                this.mq = com.byazt.cd.ve.c(str2, 500.0f);
                break;
            case "pageCount":
                this.jt = com.byazt.cd.ve.c(str2, 1.0f);
                break;
            case "pageMargin":
                this.ej = x.c(this.tt, com.byazt.cd.ve.c(str2, 0.0f));
                break;
            case "indicatorSelectedColor":
                this.is = com.byazt.cd.c.c(str2);
                break;
            case "autoplay":
                this.kz = com.byazt.cd.ve.c(str2, true);
                break;
            case "dataList":
                this.w = com.byazt.cd.tt.c(this.uj, str2, null);
                break;
        }
    }
}
