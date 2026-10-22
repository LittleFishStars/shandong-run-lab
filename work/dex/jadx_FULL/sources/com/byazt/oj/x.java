package com.byazt.oj;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 71})
public class x extends uj {
    public x(View view, com.byazt.aq.c cVar) {
        super(view, cVar);
    }

    @Override // com.byazt.oj.uj
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> c() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.tt.da() * 1000.0d));
        ((ViewGroup) this.ve.getParent()).setClipChildren(false);
        ((ViewGroup) this.ve.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.ve.getParent().getParent().getParent()).setClipChildren(false);
        this.ve.setTag(2097610712, this.tt.x());
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        return arrayList;
    }
}
