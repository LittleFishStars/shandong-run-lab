package com.byazt.kcl;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.byazt.dn.UgenBanner;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.ff.TopProxyLayout;
import com.byazt.ge.RewardBrowserMixTopLayoutImpl;
import com.byazt.ge.TopLayoutImpl;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.hkv.tt f28720a;
    public final TTBaseVideoActivity c;
    public com.byazt.ge.n i;
    public UgenBanner n;
    public com.byazt.ge.a sp;
    public ic tt;
    public TextView uj;
    public com.byazt.ge.c ve;
    public com.byazt.ge.uj x;

    public n(TTBaseVideoActivity tTBaseVideoActivity) {
        this.c = tTBaseVideoActivity;
    }

    private void x() {
        TopProxyLayout topProxyLayout = (TopProxyLayout) this.c.findViewById(2114387721);
        if (topProxyLayout != null) {
            c(topProxyLayout);
        }
        this.uj = (TextView) this.c.findViewById(2114387801);
        this.n = (UgenBanner) this.c.findViewById(2114387901);
    }

    public void a(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setShowBack(z);
        }
    }

    public void n(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setShowSound(z);
        }
    }

    public void sp(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setShowAgain(z);
        }
    }

    public void tt(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setShowDislike(z);
        }
    }

    public void uj(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setSoundMute(z);
        }
    }

    public void ve(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setDislikeLeft(z);
        }
    }

    public void c(ic icVar, tt ttVar, boolean z, com.byazt.hkv.tt ttVar2) {
        this.tt = icVar;
        this.f28720a = ttVar2;
        x();
        this.sp = new com.byazt.ge.a(this.c, this.tt, ttVar, this, z);
        this.i = new com.byazt.ge.n(this.c, this.tt, ttVar, this, z);
        this.x = new com.byazt.ge.uj(this.c, this.tt, ttVar, this, z);
        c(1);
    }

    public void a() {
        UgenBanner ugenBanner = this.n;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.c(this.tt, this.f28720a);
    }

    public boolean n() {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            return cVar.getSkipOrCloseVisible();
        }
        return false;
    }

    public void sp() {
        UgenBanner ugenBanner = this.n;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.c();
    }

    public void tt() {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.tt();
        }
    }

    public View uj() {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            return cVar.getCloseButton();
        }
        return null;
    }

    public void ve() {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.ve();
        }
    }

    public void tt(String str) {
        TextView textView = this.uj;
        if (textView != null) {
            textView.setText(str);
            this.uj.setVisibility(0);
            this.uj.postDelayed(new Runnable() { // from class: com.byazt.kcl.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.uj.setVisibility(8);
                }
            }, 3000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View, com.byazt.ge.c] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.byazt.kcl.n] */
    public void c(TopProxyLayout topProxyLayout) {
        TopLayoutImpl topLayoutImplC;
        ?? r0;
        RewardBrowserMixTopLayoutImpl rewardBrowserMixTopLayoutImplC;
        if (my.u(this.tt)) {
            rewardBrowserMixTopLayoutImplC = new RewardBrowserMixTopLayoutImpl(topProxyLayout.getContext()).c(this.tt);
        } else {
            topLayoutImplC = new TopLayoutImpl(topProxyLayout.getContext()).c(this.tt);
        }
        if (r0 != 0) {
            r0 = topLayoutImplC;
            r0 = rewardBrowserMixTopLayoutImplC;
            this.ve = r0;
        } else {
            r0 = topLayoutImplC;
            r0 = rewardBrowserMixTopLayoutImplC;
            m.uj("RewardFullTopProxyManager", "view not implements ITopLayout interface");
        }
        ViewParent parent = topProxyLayout.getParent();
        if (parent instanceof ViewGroup) {
            c(topProxyLayout, r0, (ViewGroup) parent);
        }
    }

    private void c(TopProxyLayout topProxyLayout, View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(topProxyLayout);
        viewGroup.removeViewInLayout(topProxyLayout);
        ViewGroup.LayoutParams layoutParams = topProxyLayout.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    public void c(boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setVisible(z);
        }
    }

    public void c(boolean z, String str, String str2, boolean z2, boolean z3) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.c(z, str, str2, z2, z3);
        }
    }

    public void c(String str, String str2, boolean z) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.c(str, str2, z);
        }
    }

    public void c() {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void c(int i) {
        if (i == 2) {
            c(this.x);
        } else if (i != 4) {
            c(this.sp);
        } else {
            c(this.i);
        }
    }

    public void c(com.byazt.ge.tt ttVar) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setListener(ttVar);
        }
    }

    public void c(String str) {
        com.byazt.ge.c cVar = this.ve;
        if (cVar != null) {
            cVar.setPlayAgainEntranceText(str);
        }
    }

    public void c(ic icVar) {
        com.byazt.ge.a aVar = this.sp;
        if (aVar != null) {
            aVar.c(icVar);
        }
        com.byazt.ge.uj ujVar = this.x;
        if (ujVar != null) {
            ujVar.c(icVar);
        }
        com.byazt.ge.n nVar = this.i;
        if (nVar != null) {
            nVar.c(icVar);
        }
    }
}
