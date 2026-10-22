package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.widget.l;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long alC;
    private float baM;
    private boolean baN;
    private boolean baO;
    private ViewTreeObserver.OnScrollChangedListener baP;
    private ca baQ;
    private l eW;
    private int ph;
    private ViewTreeObserver qD;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.alC = 500L;
        this.baM = 0.1f;
        this.baO = true;
        init();
    }

    private void Po() {
        if (Pq()) {
            Pp();
        } else {
            Pr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Pq() {
        if (!this.baQ.Xh() || Math.abs(this.baQ.brw.height() - getHeight()) > getHeight() * (1.0f - this.baM) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.baQ.brw;
        return rect.bottom > 0 && rect.top < this.ph;
    }

    private void Pr() {
        if (this.baP == null) {
            this.baP = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.Pq()) {
                        AdBasePvFrameLayout.this.Pp();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.qD = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.baP);
            }
        }
    }

    private void Ps() {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.baP != null && (viewTreeObserver = this.qD) != null && viewTreeObserver.isAlive()) {
                this.qD.removeOnScrollChangedListener(this.baP);
            }
            this.baP = null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private void init() {
        this.baQ = new ca(this);
        this.ph = n.getScreenHeight(getContext());
        this.baO = true;
    }

    private void qZ() {
        if (this.baO) {
            Po();
        }
    }

    public final void Pp() {
        Ps();
        l lVar = this.eW;
        if (lVar != null) {
            lVar.aZ();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Pr();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ps();
        this.baN = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z;
        if (this.baN || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            z = true;
            this.baN = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            qZ();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f) {
        this.baM = f;
    }

    public void setVisibleListener(l lVar) {
        this.eW = lVar;
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alC = 500L;
        this.baM = 0.1f;
        this.baO = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alC = 500L;
        this.baM = 0.1f;
        this.baO = true;
        init();
    }
}
