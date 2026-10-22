package com.byazt.oj;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 91})
public class sp extends uj {
    public sp(View view, com.byazt.aq.c cVar) {
        super(view, cVar);
    }

    @Override // com.byazt.oj.uj
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> c() {
        this.ve.setTag(2097610709, Integer.valueOf(this.tt.ve()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.tt.da() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        return arrayList;
    }
}
