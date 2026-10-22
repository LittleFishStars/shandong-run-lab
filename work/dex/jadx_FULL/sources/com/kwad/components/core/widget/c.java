package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.cc;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@SuppressLint({"ViewConstructor"})
public final class c extends View implements cc.a {
    private a avE;
    private boolean avF;
    private final int avG;
    private boolean avk;
    private boolean avl;
    private View bZ;
    private final cc ca;
    private final AtomicBoolean cb;

    public interface a {
        void fz();
    }

    public c(Context context, View view) {
        super(context);
        this.ca = new cc(this);
        this.cb = new AtomicBoolean(true);
        this.avG = (int) (com.kwad.sdk.core.config.e.Kd() * 100.0f);
        this.bZ = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void zK() {
        if (this.avl) {
            this.ca.removeCallbacksAndMessages(null);
            this.avl = false;
        }
    }

    private void zL() {
        if (!this.avF || this.avl) {
            return;
        }
        this.avl = true;
        this.ca.sendEmptyMessage(1);
    }

    private void zP() {
        this.cb.getAndSet(false);
    }

    private void zQ() {
        this.cb.getAndSet(true);
    }

    @Override // com.kwad.sdk.utils.cc.a
    public final void a(Message message) {
        a aVar;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!cb.a(this.bZ, this.avG, false)) {
                if (this.avk) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            } else {
                if (message.arg1 == 1000 && (aVar = this.avE) != null) {
                    aVar.fz();
                }
                this.ca.sendEmptyMessageDelayed(2, 500L);
                return;
            }
        }
        com.kwad.sdk.core.d.c.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.avl) {
            if (!cb.a(this.bZ, this.avG, false)) {
                this.ca.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            zK();
            Message messageObtainMessage = this.ca.obtainMessage();
            messageObtainMessage.what = 2;
            messageObtainMessage.arg1 = 1000;
            this.ca.sendMessageDelayed(messageObtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.d("EmptyView", "onAttachedToWindow:" + this);
        zL();
        this.avk = false;
        zP();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.d("EmptyView", "onDetachedFromWindow" + this);
        zK();
        this.avk = true;
        zQ();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.d("EmptyView", "onFinishTemporaryDetach:" + this.bZ.getParent());
        zP();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.d("EmptyView", "onStartTemporaryDetach:" + this.bZ.getParent());
        zQ();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.c.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.d.c.d("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public final void setNeedCheckingShow(boolean z) {
        this.avF = z;
        if (!z && this.avl) {
            zK();
        } else {
            if (!z || this.avl) {
                return;
            }
            zL();
        }
    }

    public final void setViewCallback(a aVar) {
        this.avE = aVar;
    }
}
