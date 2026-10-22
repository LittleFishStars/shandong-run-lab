package com.byazt.ouz;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.un.NativeVideoTsView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 1397})
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    public int c;
    public boolean gu;
    public boolean qy;
    public boolean rl;
    public ImageView tt;

    public ExpressVideoView(Context context, ic icVar, String str, boolean z) {
        super(context, icVar, false, false, str, false, false);
        this.rl = false;
        if ("draw_ad".equals(str)) {
            this.rl = true;
        }
        this.qy = z;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
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

    public void E_() {
        ImageView imageView = this.u;
        if (imageView != null) {
            pf.c((View) imageView, 0);
        }
    }

    public void F_() {
        t();
        pf.c((View) this.da, 0);
    }

    public boolean G_() {
        com.byazt.dh.ve veVar = this.n;
        return (veVar == null || veVar.nu() == null || !this.n.nu().isPlaying()) ? false : true;
    }

    public void a() {
        ImageView imageView = this.t;
        if (imageView != null) {
            pf.c((View) imageView, 8);
        }
    }

    @Override // com.byazt.un.NativeVideoTsView
    public com.byazt.dh.ve c(Context context, ViewGroup viewGroup, ic icVar, String str, boolean z, boolean z2, boolean z3) {
        return this.qy ? new com.byazt.un.ve(context, viewGroup, icVar, str, z, z2, z3) : super.c(context, viewGroup, icVar, str, z, z2, z3);
    }

    public com.byazt.dh.ve getVideoController() {
        return this.n;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.t;
        if (imageView != null && imageView.getVisibility() == 0) {
            pf.n(this.da);
        }
        tt(this.c);
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
        this.rl = z;
    }

    public void setPauseIcon(boolean z) {
        if (this.tt == null) {
            this.tt = new ImageView(getContext());
            if (com.byazt.omf.x.m().sv() != null) {
                this.tt.setImageBitmap(com.byazt.omf.x.m().sv());
            } else {
                com.byazt.nr.z.c(com.byazt.omf.gt.getContext(), "tt_new_play_video", this.tt, 320);
            }
            this.tt.setScaleType(ImageView.ScaleType.FIT_XY);
            int iVe = pf.ve(getContext(), this.m);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iVe, iVe);
            layoutParams.gravity = 17;
            this.f29101a.addView(this.tt, layoutParams);
        }
        if (z) {
            this.tt.setVisibility(0);
        } else {
            this.tt.setVisibility(8);
        }
    }

    public void setShouldCheckNetChange(boolean z) {
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            veVar.n(z);
        }
    }

    public void setShowAdInteractionView(boolean z) {
        com.byazt.dh.tt ttVarRh;
        com.byazt.dh.ve veVar = this.n;
        if (veVar == null || (ttVarRh = veVar.rh()) == null) {
            return;
        }
        ttVarRh.c(z);
    }

    public void setVideoPlayStatus(int i) {
        this.c = i;
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void tt() {
        if (this.rl) {
            super.tt(this.c);
        }
    }

    public void ve() {
        ImageView imageView = this.u;
        if (imageView != null) {
            pf.c((View) imageView, 8);
        }
    }

    public void tt(boolean z) {
        this.gu = z;
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void c(boolean z) {
        if (this.gu) {
            super.c(z);
        }
    }
}
