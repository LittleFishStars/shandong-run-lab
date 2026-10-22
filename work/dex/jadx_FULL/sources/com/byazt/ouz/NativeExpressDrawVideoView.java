package com.byazt.ouz;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aas.pf;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 2163})
public class NativeExpressDrawVideoView extends NativeExpressVideoView {
    public int gu;

    public NativeExpressDrawVideoView(Context context, ic icVar, com.byazt.dj.tt ttVar, String str) {
        super(context, icVar, ttVar, str);
        this.gu = getResources().getConfiguration().orientation;
    }

    private void gu() {
        int i = getResources().getConfiguration().orientation;
        if (this.gu != i) {
            this.gu = i;
            pf.c(this, new pf.c() { // from class: com.byazt.ouz.NativeExpressDrawVideoView.1
                @Override // com.byazt.aas.pf.c
                public void c(View view) {
                    int width = NativeExpressDrawVideoView.this.getWidth();
                    int height = NativeExpressDrawVideoView.this.getHeight();
                    NativeExpressDrawVideoView nativeExpressDrawVideoView = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView.c(nativeExpressDrawVideoView.yp, width, height);
                    View viewFindViewById = NativeExpressDrawVideoView.this.yp.findViewById(2114387714);
                    NativeExpressDrawVideoView.this.c(viewFindViewById, width, height);
                    if (viewFindViewById != null) {
                        viewFindViewById.requestLayout();
                    }
                    NativeExpressDrawVideoView nativeExpressDrawVideoView2 = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView2.c(nativeExpressDrawVideoView2.getWebView(), width, height);
                    ExpressVideoView expressVideoView = NativeExpressDrawVideoView.this.sl;
                    if (expressVideoView != null) {
                        expressVideoView.c(width, height);
                    }
                }
            });
        }
    }

    @Override // com.byazt.ouz.NativeExpressVideoView, com.byazt.ouz.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        gu();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        gu();
    }

    @Override // com.byazt.ouz.NativeExpressView, android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        gu();
    }

    @Override // com.byazt.ouz.NativeExpressVideoView
    public ExpressVideoView c(Context context, ic icVar, String str) {
        return new ExpressVideoView(context, icVar, str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }
}
