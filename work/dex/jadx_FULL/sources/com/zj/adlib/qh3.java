package com.zj.adlib;

import android.R;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.a;
import com.gyf.immersionbar.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class qh3 implements ViewTreeObserver.OnGlobalLayoutListener {
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f44208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Window f19101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f19102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19103a;
    public View b;
    public View c;

    public qh3(e eVar) {
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.f19102a = eVar;
        Window windowN0 = eVar.N0();
        this.f19101a = windowN0;
        View decorView = windowN0.getDecorView();
        this.f44208a = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(R.id.content);
        if (eVar.f1()) {
            Fragment fragmentL0 = eVar.L0();
            if (fragmentL0 != null) {
                this.c = fragmentL0.getView();
            } else {
                android.app.Fragment fragmentN0 = eVar.n0();
                if (fragmentN0 != null) {
                    this.c = fragmentN0.getView();
                }
            }
        } else {
            View childAt = frameLayout.getChildAt(0);
            this.c = childAt;
            if (childAt != null && (childAt instanceof DrawerLayout)) {
                this.c = ((DrawerLayout) childAt).getChildAt(0);
            }
        }
        View view = this.c;
        if (view != null) {
            this.K = view.getPaddingLeft();
            this.L = this.c.getPaddingTop();
            this.M = this.c.getPaddingRight();
            this.N = this.c.getPaddingBottom();
        }
        View view2 = this.c;
        this.b = view2 != null ? view2 : frameLayout;
    }

    public void a() {
        if (this.f19103a) {
            this.f44208a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f19103a = false;
        }
    }

    public void b() {
        if (this.f19103a) {
            if (this.c != null) {
                this.b.setPadding(this.K, this.L, this.M, this.N);
            } else {
                this.b.setPadding(this.f19102a.D0(), this.f19102a.F0(), this.f19102a.E0(), this.f19102a.C0());
            }
        }
    }

    public void c(int i) {
        this.f19101a.setSoftInputMode(i);
        if (this.f19103a) {
            return;
        }
        this.f44208a.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f19103a = true;
    }

    public void d() {
        this.O = 0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        e eVar = this.f19102a;
        if (eVar == null || eVar.m0() == null || !this.f19102a.m0().k) {
            return;
        }
        a aVarL0 = this.f19102a.l0();
        int iD = aVarL0.n() ? aVarL0.d() : aVarL0.g();
        Rect rect = new Rect();
        this.f44208a.getWindowVisibleDisplayFrame(rect);
        int height = this.b.getHeight() - rect.bottom;
        if (height != this.O) {
            this.O = height;
            boolean z = true;
            if (e.G(this.f19101a.getDecorView().findViewById(R.id.content))) {
                height -= iD;
                if (height <= iD) {
                    z = false;
                }
            } else if (this.c != null) {
                if (this.f19102a.m0().j) {
                    height += this.f19102a.h0() + aVarL0.k();
                }
                if (this.f19102a.m0().f20102h) {
                    height += aVarL0.k();
                }
                if (height > iD) {
                    i = this.N + height;
                } else {
                    i = 0;
                    z = false;
                }
                this.b.setPadding(this.K, this.L, this.M, i);
            } else {
                int iC0 = this.f19102a.C0();
                height -= iD;
                if (height > iD) {
                    iC0 = height + iD;
                } else {
                    z = false;
                }
                this.b.setPadding(this.f19102a.D0(), this.f19102a.F0(), this.f19102a.E0(), iC0);
            }
            int i2 = height >= 0 ? height : 0;
            if (this.f19102a.m0().f20091a != null) {
                this.f19102a.m0().f20091a.a(z, i2);
            }
            if (!z && this.f19102a.m0().f20089a != BarHide.FLAG_SHOW_BAR) {
                this.f19102a.S1();
            }
            if (z) {
                return;
            }
            this.f19102a.S();
        }
    }
}
