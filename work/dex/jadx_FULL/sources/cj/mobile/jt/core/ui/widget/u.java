package cj.mobile.jt.core.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import cj.mobile.jt.core.JuTuiAdSlot;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class u extends i {
    public RelativeLayout f;
    public g g;

    public u(Context context, cj.mobile.jt.core.modle.g0 g0Var, JuTuiAdSlot juTuiAdSlot, cj.mobile.jt.core.modle.b0 b0Var) {
        super(context, g0Var, juTuiAdSlot, b0Var);
    }

    private int getBottomLogoHeight() {
        return 0;
    }

    @Override // cj.mobile.jt.core.ui.widget.i
    public final void c() {
    }

    @Override // cj.mobile.jt.core.ui.widget.i, cj.mobile.jt.core.ui.widget.a
    public View getHotRegionView() {
        return this.f;
    }

    @Override // cj.mobile.jt.core.ui.widget.i, cj.mobile.jt.core.ui.widget.a
    public y0 getShakeView() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
    }
}
