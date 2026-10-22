package com.byazt.oj;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 34})
public class a extends uj {
    public a(View view, com.byazt.aq.c cVar) {
        super(view, cVar);
    }

    @Override // com.byazt.oj.uj
    public List<ObjectAnimator> c() {
        float f = this.ve.getLayoutParams().width;
        this.ve.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "translationX", f, 0.0f).setDuration((int) (this.tt.da() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.ve, "alpha", 0.0f, 1.0f).setDuration((int) (this.tt.da() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        arrayList.add(c(duration2));
        return arrayList;
    }
}
