package com.byazt.iox;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.byazt.im.a;
import com.byazt.im.n;
import com.byazt.im.sp;
import com.byazt.omf.gt;
import com.byazt.omf.gu;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 54})
public class ve {
    public sp c = new sp();
    public int ve = 3;
    public final gu tt = gt.c();

    public void c(final n nVar, final com.byazt.gat.tt<a, sp> ttVar) {
        if (this.tt == null || nVar == null) {
            return;
        }
        this.c.tt(false);
        this.tt.c(nVar.uj(), nVar.n(), this.ve, new gu.tt() { // from class: com.byazt.iox.ve.1
            @Override // com.byazt.omf.gu.tt
            public void c(int i, String str, com.byazt.ete.tt ttVar2) {
                ve.this.c.tt(i);
                ve.this.c.ve(ttVar2 != null ? ttVar2.ve() : 0);
                if (TextUtils.isEmpty(str)) {
                    str = "load ad error";
                }
                ve.this.c.c(str);
                ttVar.c(ve.this.c);
            }

            @Override // com.byazt.omf.gu.tt
            public void c(com.byazt.ete.c cVar, com.byazt.ete.tt ttVar2) {
                if (cVar == null || cVar.tt() == null) {
                    ve.this.c.tt(1);
                    ve.this.c.c("no ad or material");
                    ttVar.c(ve.this.c);
                    return;
                }
                a aVar = new a(cVar, false);
                aVar.tt(ttVar2.i());
                aVar.ve(ttVar2.da());
                aVar.uj(ttVar2.sl());
                aVar.n(ttVar2.t());
                aVar.c(nVar.c());
                aVar.c(nVar.ve());
                ttVar.tt(aVar);
            }
        });
    }
}
