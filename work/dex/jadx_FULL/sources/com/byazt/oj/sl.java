package com.byazt.oj;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.tm.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 158})
public class sl extends uj {
    public sl(View view, com.byazt.aq.c cVar) {
        super(view, cVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // com.byazt.oj.uj
    public List<ObjectAnimator> c() {
        float f;
        float fSl = (float) this.tt.sl();
        float fT = (float) this.tt.t();
        String strM = this.tt.m();
        float f2 = 1.0f;
        if ("reverse".equals(strM) || "alternate-reverse".equals(strM)) {
            f = 1.0f;
        } else {
            f = fT;
            fT = 1.0f;
            f2 = fSl;
            fSl = 1.0f;
        }
        this.ve.setTag(2097610710, this.tt.tt());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "scaleX", fSl, f2).setDuration((int) (this.tt.da() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.ve, "scaleY", fT, f).setDuration((int) (this.tt.da() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        arrayList.add(c(duration2));
        return arrayList;
    }
}
