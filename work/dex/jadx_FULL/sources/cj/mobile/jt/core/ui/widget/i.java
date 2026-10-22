package cj.mobile.jt.core.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cj.mobile.jt.core.JuTuiAdSlot;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class i extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22589a;
    public final cj.mobile.jt.core.modle.g0 b;
    public final cj.mobile.jt.core.utils.l c;
    public FrameLayout d;
    public cj.mobile.jt.common.video.k e;

    public i(Context context, cj.mobile.jt.core.modle.g0 g0Var, JuTuiAdSlot juTuiAdSlot, cj.mobile.jt.core.modle.b0 b0Var) {
    }

    public void c() {
    }

    @Override // cj.mobile.jt.core.ui.widget.a
    public View getAdView() {
        return this.d;
    }

    public abstract /* synthetic */ View getHotRegionView();

    @Override // cj.mobile.jt.core.ui.widget.a
    public ViewGroup getRoot() {
        return this;
    }

    public abstract /* synthetic */ y0 getShakeView();

    @Override // cj.mobile.jt.core.ui.widget.a
    public cj.mobile.jt.common.video.k getVideoView() {
        return this.e;
    }
}
