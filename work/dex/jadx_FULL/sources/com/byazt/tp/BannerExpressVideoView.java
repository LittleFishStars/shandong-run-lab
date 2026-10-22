package com.byazt.tp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ouz.NativeExpressVideoView;
import com.byazt.ouz.NativeExpressView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 436, 1958})
public class BannerExpressVideoView extends c {
    public BannerExpressVideoView(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        super(context, icVar, ttVar);
    }

    @Override // com.byazt.tp.c
    public void c() {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.c, this.uj, this.n, this.da);
        this.tt = nativeExpressVideoView;
        addView(nativeExpressVideoView, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    public com.byazt.ua.c getVideoModel() {
        NativeExpressView nativeExpressView = this.tt;
        if (nativeExpressView != null) {
            return ((NativeExpressVideoView) nativeExpressView).getVideoModel();
        }
        return null;
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void setDuration(int i) {
        super.setDuration(i);
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(com.byazt.ouz.c cVar) {
        super.setExpressInteractionListener(cVar);
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void setVideoAdListener(com.byazt.ft.ve veVar) {
        super.setVideoAdListener(veVar);
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ boolean tt() {
        return super.tt();
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void uj() {
        super.uj();
    }

    @Override // com.byazt.tp.c
    public /* bridge */ /* synthetic */ void ve() {
        super.ve();
    }

    @Override // com.byazt.tp.c
    public void c(ic icVar, com.byazt.dj.tt ttVar) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.c, icVar, ttVar, this.da);
        this.ve = nativeExpressVideoView;
        nativeExpressVideoView.setExpressInteractionListener(new com.byazt.ouz.c() { // from class: com.byazt.tp.BannerExpressVideoView.1
            @Override // com.byazt.ouz.c
            public void c(View view, int i) {
                BannerExpressVideoView bannerExpressVideoView = BannerExpressVideoView.this;
                com.byazt.ouz.c cVar = bannerExpressVideoView.f29067a;
                if (cVar != null) {
                    cVar.c(bannerExpressVideoView, i);
                }
            }

            @Override // com.byazt.ouz.c
            public void c(View view, float f, float f2) {
                BannerExpressVideoView.this.c(f, f2);
                BannerExpressVideoView.this.a();
            }
        });
        pf.c((View) this.ve, 8);
        addView(this.ve, new ViewGroup.LayoutParams(-1, -1));
    }
}
