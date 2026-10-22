package com.byazt.go;

import android.widget.FrameLayout;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.hkv.tt;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, 1225, 2170})
public abstract class AbstractEndCardFrameLayout extends FrameLayout {
    public final TTBaseVideoActivity c;
    public final ic tt;

    public AbstractEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        super(tTBaseVideoActivity);
        this.c = tTBaseVideoActivity;
        this.tt = icVar;
        c();
    }

    public abstract void c();

    public abstract SSWebView getEndCardWebView();

    public abstract SSWebView getPlayableWebView();

    public abstract FrameLayout getVideoArea();

    public abstract void setClickListener(tt ttVar);

    public void tt() {
    }
}
