package com.byazt.ff;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.byazt.el.SSWebView;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, 142, 1595})
public class SSWebViewVideoPage extends SSWebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28540a;
    public boolean n;
    public boolean sp;
    public ViewParent x;

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.n = true;
        this.f28540a = -1.0f;
        this.sp = false;
    }

    public void a() {
        if (this.sp) {
            return;
        }
        this.x.requestDisallowInterceptTouchEvent(true);
        this.sp = true;
    }

    public void c(boolean z) {
        if (((ScrollView) this.x).getScrollY() == 0) {
            if (z) {
                a();
                return;
            } else {
                sp();
                return;
            }
        }
        if (!this.n) {
            a();
        } else if (z) {
            sp();
        } else {
            a();
        }
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0 && z2) {
            this.n = true;
        } else {
            this.n = false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.x == null) {
            this.x = c((View) this);
        }
        if (motionEvent.getAction() == 0) {
            this.f28540a = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.f28540a;
            if (y > 0.0f) {
                c(true);
            } else if (y != 0.0f && y < 0.0f) {
                c(false);
            }
            this.f28540a = motionEvent.getY();
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            a();
            this.sp = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void sp() {
        if (this.sp) {
            return;
        }
        this.x.requestDisallowInterceptTouchEvent(false);
        this.sp = true;
    }
}
