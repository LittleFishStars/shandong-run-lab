package com.byazt.oj;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 133})
public class z extends uj {
    public z(View view, com.byazt.aq.c cVar) {
        super(view, cVar);
    }

    @Override // com.byazt.oj.uj
    public List<ObjectAnimator> c() {
        float f;
        float fC = com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.tt.a());
        float fC2 = com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.tt.sp());
        float f2 = 0.0f;
        if ("reverse".equals(this.tt.m())) {
            f = fC2;
            fC2 = 0.0f;
            f2 = fC;
            fC = 0.0f;
        } else {
            f = 0.0f;
        }
        if (com.byazt.or.ve.c(this.ve.getContext())) {
            fC = -fC;
            f2 = -f2;
        }
        this.ve.setTranslationX(fC);
        this.ve.setTranslationY(fC2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "translationX", fC, f2).setDuration((int) (this.tt.da() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.ve, "translationY", fC2, f).setDuration((int) (this.tt.da() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        arrayList.add(c(duration2));
        return arrayList;
    }
}
