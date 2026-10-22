package cj.mobile.jt.core.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class l extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22595a;
    public final String b;
    public final String c;
    public final String d;
    public cj.mobile.jt.core.ui.gif.k e;
    public cj.mobile.jt.common.video.k f;
    public final cj.mobile.jt.core.modle.b0 g;
    public s h;

    public l(Context context) {
        super(context);
    }

    public final void a() {
    }

    public abstract void b();

    @Override // cj.mobile.jt.core.ui.widget.a
    public View getAdView() {
        return this;
    }

    public abstract /* synthetic */ View getHotRegionView();

    public ImageView getImageView() {
        return this.e;
    }

    @Override // cj.mobile.jt.core.ui.widget.a
    public ViewGroup getRoot() {
        return this;
    }

    public abstract /* synthetic */ y0 getShakeView();

    @Override // cj.mobile.jt.core.ui.widget.a
    public cj.mobile.jt.common.video.k getVideoView() {
        return this.f;
    }

    public l(Context context, k kVar) {
    }
}
