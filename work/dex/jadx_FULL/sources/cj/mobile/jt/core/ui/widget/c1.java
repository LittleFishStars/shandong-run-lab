package cj.mobile.jt.core.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class c1 extends l {
    public RelativeLayout i;
    public g j;

    public c1(Context context) {
        super(context);
    }

    private int getBottomLogoHeight() {
        return 0;
    }

    @Override // cj.mobile.jt.core.ui.widget.l
    public final void b() {
    }

    @Override // cj.mobile.jt.core.ui.widget.l, cj.mobile.jt.core.ui.widget.a
    public View getHotRegionView() {
        return this.i;
    }

    @Override // cj.mobile.jt.core.ui.widget.l, cj.mobile.jt.core.ui.widget.a
    public y0 getShakeView() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
    }

    public c1(Context context, b1 b1Var) {
        super(context, b1Var);
    }
}
