package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.n;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class i {
    private final ca baQ;
    private final k btG;
    private boolean btI;
    private boolean btJ;
    private ViewTreeObserver.OnScrollChangedListener btL;
    private final View mView;
    private final int ph;
    private float btH = 0.1f;
    private boolean btK = true;

    public i(View view, k kVar) {
        this.mView = view;
        this.btG = kVar;
        this.baQ = new ca(view);
        this.ph = n.getScreenHeight(view.getContext());
    }

    private void Pr() {
        if (this.btL == null) {
            this.btL = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.i.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (i.this.XO()) {
                        i.this.aZ();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.btL);
            }
        }
    }

    private void Ps() {
        if (this.btL == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.btL);
            }
            this.btL = null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private void XN() {
        if (XO()) {
            aZ();
        } else {
            Ps();
            Pr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean XO() {
        if (this.baQ.Xh() && Math.abs(this.baQ.brw.height() - this.mView.getHeight()) <= this.mView.getHeight() * (1.0f - this.btH) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            Rect rect = this.baQ.brw;
            if (rect.bottom > 0 && rect.top < this.ph) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ() {
        try {
            Ps();
            k kVar = this.btG;
            if (kVar != null) {
                kVar.H(this.mView);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void qZ() {
        if (this.btK) {
            XN();
        }
    }

    public final void XM() {
        if (this.btJ) {
            qZ();
        }
    }

    public final void cG(boolean z) {
        this.btK = z;
    }

    public final void d(int i, int i2, int i3, int i4) {
        this.btJ = false;
        if (this.btI || (i3 | i4) != 0 || (i | i2) == 0) {
            return;
        }
        this.btJ = true;
        this.btI = true;
    }

    public final float getVisiblePercent() {
        return this.btH;
    }

    public final void onAttachedToWindow() {
        Pr();
    }

    public final void onDetachedFromWindow() {
        Ps();
        this.btI = false;
    }

    public final void setVisiblePercent(float f) {
        this.btH = f;
    }
}
