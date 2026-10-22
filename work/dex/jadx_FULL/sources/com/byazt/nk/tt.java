package com.byazt.nk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.oq.CircleLongPressView;
import com.byazt.tm.DynamicBaseWidget;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 13})
public class tt implements sp {
    public CircleLongPressView c;

    public tt(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar) {
        this.c = new CircleLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.byazt.or.x.c(context, 180.0f), (int) com.byazt.or.x.c(context, 180.0f));
        layoutParams.gravity = 17;
        this.c.setLayoutParams(layoutParams);
        this.c.setGuideText(spVar.lt());
    }

    @Override // com.byazt.nk.sp
    public void c() {
        this.c.c();
    }

    @Override // com.byazt.nk.sp
    public void tt() {
        this.c.tt();
    }

    @Override // com.byazt.nk.sp
    /* JADX INFO: renamed from: uj, reason: merged with bridge method [inline-methods] */
    public CircleLongPressView ve() {
        return this.c;
    }
}
