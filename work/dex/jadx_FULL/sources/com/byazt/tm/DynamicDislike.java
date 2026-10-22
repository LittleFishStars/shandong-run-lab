package com.byazt.tm;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.byazt.aq.x;
import com.byazt.oq.DislikeView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2064})
public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        if (com.byazt.sr.uj.c()) {
            this.z = new ImageView(context);
        } else {
            this.z = new DislikeView(context);
        }
        this.z.setTag(3);
        addView(this.z, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.z);
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        int iC = (int) com.byazt.or.x.c(this.sl, this.t.nu());
        View view = this.z;
        if (!(view instanceof DislikeView)) {
            return true;
        }
        ((DislikeView) view).setRadius((int) com.byazt.or.x.c(this.sl, this.t.z()));
        ((DislikeView) this.z).setStrokeWidth(iC);
        ((DislikeView) this.z).setStrokeColor(this.t.m());
        ((DislikeView) this.z).setBgColor(this.t.md());
        ((DislikeView) this.z).setDislikeColor(this.t.sp());
        ((DislikeView) this.z).setDislikeWidth((int) com.byazt.or.x.c(this.sl, 1.0f));
        return true;
    }
}
