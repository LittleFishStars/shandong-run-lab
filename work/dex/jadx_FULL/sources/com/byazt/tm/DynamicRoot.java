package com.byazt.tm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import com.byazt.aq.x;
import com.bytedance.component.sdk.annotation.ColorInt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2194})
public class DynamicRoot extends DynamicBaseWidgetImp {
    public tt c;

    public DynamicRoot(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public tt c(Bitmap bitmap) {
        c cVar = new c(bitmap, this.c);
        this.c = cVar;
        return cVar;
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public GradientDrawable getDrawable() {
        tt ttVar = new tt();
        this.c = ttVar;
        return ttVar;
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        return super.x();
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public GradientDrawable c(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        tt ttVar = new tt(orientation, iArr);
        this.c = ttVar;
        return ttVar;
    }
}
