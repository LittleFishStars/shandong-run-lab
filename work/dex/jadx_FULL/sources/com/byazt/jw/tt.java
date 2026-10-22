package com.byazt.jw;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import com.byazt.pm.a;
import com.byazt.xj.ve;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1216, 13})
public class tt extends com.byazt.vd.c {
    public tt(ve veVar, String str, a.c cVar) {
        super(veVar, str, cVar);
    }

    @Override // com.byazt.vd.c
    public void c() {
        Object obj;
        ve veVar;
        ve veVarTt;
        Map<String, Object> map = this.f29129a;
        if (map == null || map.isEmpty() || (obj = this.f29129a.get("id")) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf) || (veVarTt = (veVar = this.ve).tt(veVar)) == null) {
            return;
        }
        ve veVarUj = veVarTt.uj(strValueOf);
        if (veVarUj instanceof com.byazt.si.tt) {
            com.byazt.si.tt ttVar = (com.byazt.si.tt) veVarUj;
            ttVar.q();
            ttVar.c(new AnimatorListenerAdapter() { // from class: com.byazt.jw.tt.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    tt.this.ve();
                }
            });
        }
    }

    @Override // com.byazt.vd.c
    public void tt() {
    }
}
