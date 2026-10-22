package com.byazt.zwg;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.hz.t;
import com.byazt.nh.sp;
import com.byazt.oh.n;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1061, 54})
public class ve implements n {
    public t c;
    public com.byazt.ch.c tt;
    public c uj;
    public sp ve;

    public ve(Context context, com.byazt.ch.c cVar, sp spVar) {
        this.tt = cVar;
        if (cVar != null) {
            this.c = new t(context);
            this.ve = spVar;
        }
    }

    @Override // com.byazt.oh.n
    public void c() {
        HashMap map = new HashMap();
        String strU = this.tt.u();
        if (!TextUtils.isEmpty(strU)) {
            map.put("gdt", strU);
        }
        this.c.c(new com.byazt.ll.tt(7, this.tt.eo(), this.tt.or()), new com.byazt.uhf.tt() { // from class: com.byazt.zwg.ve.1
            @Override // com.byazt.uhf.tt
            public void c(com.byazt.pp.c cVar) {
                if (cVar == null || ve.this.ve == null) {
                    return;
                }
                ve.this.ve.c(cVar.c, cVar.tt);
            }

            @Override // com.byazt.uhf.tt
            public void tt() {
                if (ve.this.ve != null) {
                    ve.this.ve.c();
                    if (ve.this.uj == null) {
                        ve veVar = ve.this;
                        veVar.uj = new c(veVar.c);
                    }
                    ve.this.ve.tt(ve.this.uj);
                }
            }

            @Override // com.byazt.uhf.tt
            public void c() {
                if (ve.this.ve != null) {
                    if (ve.this.uj == null) {
                        ve veVar = ve.this;
                        veVar.uj = new c(veVar.c);
                    }
                    ve.this.ve.c(ve.this.uj);
                }
            }
        });
    }
}
