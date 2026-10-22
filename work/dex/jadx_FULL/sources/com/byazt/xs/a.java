package com.byazt.xs;

import android.content.Context;
import com.byazt.nr.zm;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 468, 34})
public class a implements com.byazt.dq.uj.c {
    public zm c;
    public com.byazt.xj.ve tt;

    public a(Context context, com.byazt.xj.ve veVar) {
        this.c = new zm(context, 1, com.byazt.omf.x.m().uj());
        this.tt = veVar;
    }

    private int ve() {
        JSONObject jSONObjectDa;
        com.byazt.xj.ve veVar = this.tt;
        if (veVar == null || (jSONObjectDa = veVar.da()) == null) {
            return 0;
        }
        return jSONObjectDa.optInt("meta_hashcode", 0);
    }

    @Override // com.byazt.dq.uj.c
    public void c() {
        zm zmVar = this.c;
        if (zmVar != null) {
            zmVar.c(ve());
        }
    }

    @Override // com.byazt.dq.uj.c
    public void tt() {
        zm zmVar = this.c;
        if (zmVar != null) {
            zmVar.tt(ve());
        }
    }

    @Override // com.byazt.dq.uj.c
    public void c(float f) {
        zm zmVar = this.c;
        if (zmVar != null) {
            zmVar.c(f);
        }
    }

    @Override // com.byazt.dq.uj.c
    public void c(final com.byazt.dq.uj.tt ttVar) {
        zm zmVar = this.c;
        if (zmVar != null) {
            zmVar.c(new zm.c() { // from class: com.byazt.xs.a.1
                @Override // com.byazt.nr.zm.c
                public void c(int i) {
                    com.byazt.dq.uj.tt ttVar2 = ttVar;
                    if (ttVar2 != null) {
                        ttVar2.c(i);
                    }
                }
            });
        }
    }
}
