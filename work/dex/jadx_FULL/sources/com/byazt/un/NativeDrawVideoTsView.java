package com.byazt.un;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.omf.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 96, 2008})
@SuppressLint({"ViewConstructor"})
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    public boolean c;
    public int tt;

    public NativeDrawVideoTsView(Context context, ic icVar) {
        super(context, icVar);
        this.c = false;
        setOnClickListener(this);
        this.tt = getResources().getConfiguration().orientation;
    }

    private void rl() {
        t();
        RelativeLayout relativeLayout = this.da;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            }
            com.byazt.xky.tt.c(xd.tt(this.uj)).to(this.sl);
            c(this.sl, xd.tt(this.uj));
        }
        x();
    }

    private void x() {
        pf.c((View) this.da, 0);
        pf.c((View) this.sl, 0);
        pf.c((View) this.u, 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.t;
        if (imageView != null && imageView.getVisibility() == 0) {
            pf.n(this.da);
        }
        tt();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int i = this.tt;
        int i2 = configuration.orientation;
        if (i == i2) {
            return;
        }
        this.tt = i2;
        pf.c(this, new pf.c() { // from class: com.byazt.un.NativeDrawVideoTsView.1
            @Override // com.byazt.aas.pf.c
            public void c(View view) {
                NativeDrawVideoTsView nativeDrawVideoTsView = NativeDrawVideoTsView.this;
                if (nativeDrawVideoTsView.n == null) {
                    return;
                }
                NativeDrawVideoTsView.this.c(nativeDrawVideoTsView.getWidth(), NativeDrawVideoTsView.this.getHeight());
            }
        });
    }

    @Override // com.byazt.un.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        ImageView imageView = this.t;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            rl();
        }
    }

    @Override // com.byazt.un.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        ImageView imageView = this.t;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            rl();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.c = z;
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void sp() {
        this.z = "draw_ad";
        super.sp();
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void tt() {
        if (this.c) {
            super.tt();
        }
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void uj() {
        int i = getResources().getConfiguration().orientation;
        if (this.tt == i) {
            super.uj();
        } else {
            this.tt = i;
            pf.c(this, new pf.c() { // from class: com.byazt.un.NativeDrawVideoTsView.2
                @Override // com.byazt.aas.pf.c
                public void c(View view) {
                    NativeDrawVideoTsView nativeDrawVideoTsView = NativeDrawVideoTsView.this;
                    if (nativeDrawVideoTsView.n == null) {
                        return;
                    }
                    NativeDrawVideoTsView.this.c(nativeDrawVideoTsView.getWidth(), NativeDrawVideoTsView.this.getHeight());
                    NativeDrawVideoTsView.super.uj();
                }
            });
        }
    }

    public void c(Bitmap bitmap, int i) {
        x.m().c(bitmap);
        this.m = i;
    }

    @Override // com.byazt.un.NativeVideoTsView
    public com.byazt.dh.ve c(Context context, ViewGroup viewGroup, ic icVar, String str, boolean z, boolean z2, boolean z3) {
        return new ve(context, viewGroup, icVar, str, z, z2, z3);
    }

    public NativeDrawVideoTsView(Context context, ic icVar, String str, boolean z, boolean z2) {
        super(context, icVar, str, z, z2);
        this.c = false;
        setOnClickListener(this);
        this.tt = getResources().getConfiguration().orientation;
    }
}
