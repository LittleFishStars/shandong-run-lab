package com.kc.dw.ad.draw;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.core.ad.draw.DrawAdListener;
import com.kc.dw.platform.ad_adapter.draw.b;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdDrawRootView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DrawAdListener f39088a;
    public a b;

    @Keep
    public interface a {
    }

    public SsdDrawRootView(Context context) {
        super(context);
    }

    public SsdDrawRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SsdDrawRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        DrawAdListener drawAdListener;
        super.onVisibilityChanged(view, i);
        a aVar = this.b;
        if (aVar != null) {
            View view2 = ((b) aVar).f39458a;
            if (view2 instanceof NormalMediaView) {
                NormalMediaView normalMediaView = (NormalMediaView) view2;
                if (i == 0) {
                    normalMediaView.resume();
                } else {
                    normalMediaView.pause();
                }
            }
        }
        if (i == 0 && isShown() && (drawAdListener = this.f39088a) != null) {
            drawAdListener.onAdExposure();
        }
    }

    public void setAdListener(DrawAdListener drawAdListener) {
        this.f39088a = drawAdListener;
    }

    public void setOnVisibilityChangeListener(a aVar) {
        this.b = aVar;
    }
}
